@file:Suppress("UNCHECKED_CAST", "USELESS_CAST", "INAPPLICABLE_JVM_NAME", "UNUSED_ANONYMOUS_PARAMETER", "NAME_SHADOWING", "UNNECESSARY_NOT_NULL_ASSERTION")
package uni.UNIBC2A3BF
import io.dcloud.uniapp.*
import io.dcloud.uniapp.extapi.*
import io.dcloud.uniapp.framework.*
import io.dcloud.uniapp.runtime.*
import io.dcloud.uniapp.vue.*
import io.dcloud.uniapp.vue.shared.*
import io.dcloud.uts.*
import io.dcloud.uts.Map
import io.dcloud.uts.Set
import io.dcloud.uts.UTSAndroid
import io.dcloud.uniapp.extapi.chooseImage as uni_chooseImage
open class GenUniModulesCoolUiComponentsClUploadClUpload : VueComponent {
    constructor(__ins: ComponentInternalInstance) : super(__ins) {}
    open var pt: Any by `$props`
    open var modelValue: Any? by `$props`
    open var icon: String by `$props`
    open var text: String by `$props`
    open var sizeType: Any? by `$props`
    open var sourceType: UTSArray<String> by `$props`
    open var height: Any by `$props`
    open var width: Any by `$props`
    open var multiple: Boolean by `$props`
    open var limit: Number by `$props`
    open var disabled: Boolean by `$props`
    open var test: Boolean by `$props`
    companion object {
        @Suppress("UNUSED_PARAMETER", "UNUSED_VARIABLE")
        var setup: (__props: GenUniModulesCoolUiComponentsClUploadClUpload) -> Any? = fun(__props): Any? {
            val __ins = getCurrentInstance()!!
            val _ctx = __ins.proxy as GenUniModulesCoolUiComponentsClUploadClUpload
            val _cache = __ins.renderCache
            val props = __props
            fun emit(event: String, vararg do_not_transform_spread: Any?) {
                __ins.emit(event, *do_not_transform_spread)
            }
            val disabled = useForm().disabled
            val isDisabled = computed(fun(): Boolean {
                return disabled.value || props.disabled
            }
            )
            val pt = computed(fun(): PassThrough32 {
                return parsePt<PassThrough32>(props.pt)
            }
            )
            val list = ref(_uA<ClUploadItem>())
            val activeIndex = ref(0)
            val isAdd = computed(fun(): Boolean {
                val n = list.value.length
                if (isDisabled.value) {
                    return n == 0
                } else {
                    return n < (if (props.multiple) {
                        props.limit
                    } else {
                        1
                    }
                    )
                }
            }
            )
            val uploadStyle = computed(fun(): UTSJSONObject {
                return object : UTSJSONObject() {
                    var height = parseRpx(props.height)
                    var width = parseRpx(props.width)
                }
            }
            )
            fun gen_getUrls_fn(): UTSArray<String> {
                return list.value.filter(fun(e): Boolean {
                    return e.url != "" && e.progress == 100
                }
                ).map(fun(e): String {
                    return e.url
                }
                )
            }
            val getUrls = ::gen_getUrls_fn
            fun gen_getValue_fn(): Any {
                val urls = getUrls()
                if (props.multiple) {
                    return urls
                } else {
                    return urls[0]
                }
            }
            val getValue = ::gen_getValue_fn
            fun gen_append_fn(url: String): String {
                val item = if (activeIndex.value == -1) {
                    reactive<ClUploadItem>(ClUploadItem(uid = uuid(), preview = url, url = "", progress = 0))
                } else {
                    list.value[activeIndex.value]
                }
                if (activeIndex.value == -1) {
                    list.value.push(item)
                } else {
                    item.progress = 0
                    item.preview = url
                    item.url = ""
                }
                return item.uid
            }
            val append = ::gen_append_fn
            fun gen_change_fn() {
                val value = getValue()
                emit("update:modelValue", value)
                emit("change", value)
            }
            val change = ::gen_change_fn
            fun gen_update_fn(uid: String, data: Any) {
                val item = list.value.find(fun(e): Boolean {
                    return e.uid == uid
                }
                )
                if (item != null) {
                    forInObject(data, fun(value, key){
                        item[key] = value
                    }
                    )
                    if (item.progress == 100 && item.url != "") {
                        change()
                    }
                }
            }
            val update = ::gen_update_fn
            fun gen_remove_fn(uid: String) {
                list.value.splice(list.value.findIndex(fun(e): Boolean {
                    return e.uid == uid
                }
                ), 1)
                change()
            }
            val remove = ::gen_remove_fn
            fun gen_choose_fn(index: Number) {
                if (isDisabled.value) {
                    return
                }
                activeIndex.value = index
                val count = if (activeIndex.value == -1) {
                    props.limit - list.value.length
                } else {
                    1
                }
                if (count <= 0) {
                    emit("exceed", list.value)
                    return
                }
                uni_chooseImage(ChooseImageOptions(count = count, sizeType = props.sizeType as UTSArray<String>, sourceType = props.sourceType as UTSArray<String>, success = fun(res) {
                    if (UTSArray.isArray(res.tempFiles)) {
                        (res.tempFiles as UTSArray<ChooseImageTempFile>).forEach(fun(file){
                            val uid = append(file.path)
                            if (props.test) {
                                update(uid, object : UTSJSONObject() {
                                    var url = file.path
                                    var progress: Number = 100
                                })
                                emit("success", file.path, uid)
                                return
                            }
                            uploadFile(file, UploadOptions(onProgressUpdate = fun(ref1){
                                var progress = ref1.progress
                                update(uid, _uO("progress" to progress))
                                emit("progress", progress)
                            }
                            )).then(fun(url){
                                update(uid, _uO("url" to url, "progress" to 100))
                                emit("success", url, uid)
                            }
                            ).`catch`(fun(err){
                                emit("error", err as String)
                                remove(uid)
                            }
                            )
                        }
                        )
                    }
                }
                , fail = fun(err) {
                    console.error(err)
                    emit("error", err.errMsg)
                }
                ))
            }
            val choose = ::gen_choose_fn
            watch(computed(fun(): Any {
                return props.modelValue!!
            }
            ), fun(kVal: Any){
                val currentUrls = getUrls().join(",")
                val newUrls = if (UTSArray.isArray(kVal)) {
                    (kVal as UTSArray<String>).join(",")
                } else {
                    kVal as String
                }
                if (currentUrls != newUrls) {
                    val urls = if (UTSArray.isArray(kVal)) {
                        kVal as UTSArray<String>
                    } else {
                        _uA(
                            kVal as String
                        )
                    }
                    list.value = urls.filter(fun(url): Boolean {
                        return url != ""
                    }
                    ).map(fun(url): ClUploadItem {
                        return ClUploadItem(uid = uuid(), preview = url, url = url, progress = 100)
                    }
                    )
                }
            }
            , WatchOptions(immediate = true))
            return fun(): Any? {
                val _component_cl_icon = resolveEasyComponent("cl-icon", GenUniModulesCoolUiComponentsClIconClIconClass)
                val _component_cl_progress = resolveEasyComponent("cl-progress", GenUniModulesCoolUiComponentsClProgressClProgressClass)
                val _component_cl_text = resolveEasyComponent("cl-text", GenUniModulesCoolUiComponentsClTextClTextClass)
                return _cE("view", _uM("class" to _nC(_uA(
                    "cl-upload-list",
                    _uA(
                        _uM<String, Any?>(),
                        pt.value.className
                    )
                ))), _uA(
                    _cE(Fragment, null, RenderHelpers.renderList(list.value, fun(item, index, __index, _cached): Any {
                        return _cE("view", _uM("key" to item.uid, "class" to _nC(_uA(
                            "cl-upload",
                            _uA(
                                _uM<String, Any?>(),
                                _uM("is-dark" to unref(isDark), "is-disabled" to isDisabled.value),
                                pt.value.item?.className
                            )
                        )), "style" to _nS(uploadStyle.value), "onClick" to fun(){
                            choose(index)
                        }
                        ), _uA(
                            _cE("image", _uM("class" to _nC(_uA(
                                "cl-upload__image",
                                _uA(
                                    _uM<String, Any?>(),
                                    _uM("is-uploading" to (item.progress < 100)),
                                    pt.value.image?.className
                                )
                            )), "src" to item.preview, "mode" to "aspectFill"), null, 10, _uA(
                                "src"
                            )),
                            if (isTrue(!isDisabled.value)) {
                                _cV(_component_cl_icon, _uM("key" to 0, "name" to "close-line", "color" to "white", "pt" to object : UTSJSONObject() {
                                    var className = "cl-upload__close"
                                }, "onClick" to withModifiers(fun(){
                                    remove(item.uid)
                                }, _uA(
                                    "stop"
                                ))), null, 8, _uA(
                                    "onClick"
                                ))
                            } else {
                                _cC("v-if", true)
                            }
                            ,
                            if (item.progress < 100) {
                                _cE("view", _uM("key" to 1, "class" to "cl-upload__progress"), _uA(
                                    _cV(_component_cl_progress, _uM("value" to item.progress, "show-text" to false), null, 8, _uA(
                                        "value"
                                    ))
                                ))
                            } else {
                                _cC("v-if", true)
                            }
                        ), 14, _uA(
                            "onClick"
                        ))
                    }
                    ), 128),
                    if (isTrue(isAdd.value)) {
                        _cE("view", _uM("key" to 0, "class" to _nC(_uA(
                            "cl-upload is-add",
                            _uA(
                                _uM<String, Any?>(),
                                _uM("is-dark" to unref(isDark), "is-disabled" to isDisabled.value),
                                pt.value.add?.className
                            )
                        )), "style" to _nS(uploadStyle.value), "onClick" to fun(){
                            choose(-1)
                        }), _uA(
                            _cV(_component_cl_icon, _uM("name" to _ctx.icon, "pt" to object : UTSJSONObject() {
                                var className = unref(parseClass)(_uA(
                                    _uA(
                                        unref(isDark),
                                        "-important-text-white",
                                        "-important-text-surface-400"
                                    ),
                                    pt.value.icon?.className
                                ))
                            }, "size" to 50), null, 8, _uA(
                                "name",
                                "pt"
                            )),
                            _cV(_component_cl_text, _uM("pt" to object : UTSJSONObject() {
                                var className = unref(parseClass)(_uA(
                                    _uA(
                                        unref(isDark),
                                        "-important-text-white",
                                        "-important-text-surface-500"
                                    ),
                                    "-important-text-xs mt-1 text-center",
                                    pt.value.text?.className
                                ))
                            }), _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                                return _uA(
                                    _tD(_ctx.text)
                                )
                            }), "_" to 1), 8, _uA(
                                "pt"
                            ))
                        ), 14, _uA(
                            "onClick"
                        ))
                    } else {
                        _cC("v-if", true)
                    }
                ), 2)
            }
        }
        var name = "cl-upload"
        val styles: Map<String, Map<String, Map<String, Any>>> by lazy {
            _nCS(_uA(
                styles0
            ))
        }
        val styles0: Map<String, Map<String, Map<String, Any>>>
            get() {
                return _uM("cl-upload-list" to _pS(_uM("display" to "flex", "flexDirection" to "row", "flexWrap" to "wrap")), "cl-upload" to _uM(".cl-upload-list " to _uM("position" to "relative", "display" to "flex", "flexDirection" to "column", "alignItems" to "center", "justifyContent" to "center", "borderTopLeftRadius" to "21rpx", "borderTopRightRadius" to "21rpx", "borderBottomRightRadius" to "21rpx", "borderBottomLeftRadius" to "21rpx", "backgroundColor" to "rgba(244,244,245,1)", "marginRight" to "14rpx", "marginBottom" to "14rpx"), ".cl-upload-list .is-dark" to _uM("backgroundColor" to "rgba(63,63,70,1)"), ".cl-upload-list .is-disabled" to _uM("opacity" to 0.5), ".cl-upload-list .is-add" to _uM("paddingTop" to "7rpx", "paddingRight" to "7rpx", "paddingBottom" to "7rpx", "paddingLeft" to "7rpx")), "cl-upload__image" to _uM(".cl-upload-list " to _uM("position" to "absolute", "top" to 0, "left" to 0, "height" to "100%", "width" to "100%", "transitionProperty" to "opacity", "transitionDuration" to "0.2s"), ".cl-upload-list .is-uploading" to _uM("opacity" to 0.7)), "cl-upload__close" to _uM(".cl-upload-list " to _uM("position" to "absolute", "top" to "7rpx", "right" to "7rpx")), "cl-upload__progress" to _uM(".cl-upload-list " to _uM("position" to "absolute", "bottom" to "14rpx", "left" to 0, "zIndex" to 10, "width" to "100%", "paddingLeft" to "14rpx", "paddingRight" to "14rpx")), "@TRANSITION" to _uM("cl-upload__image" to _uM("property" to "opacity", "duration" to "0.2s")))
            }
        var inheritAttrs = true
        var inject: Map<String, Map<String, Any?>> = _uM()
        var emits: Map<String, Any?> = _uM("update:modelValue" to null, "change" to null, "exceed" to null, "success" to null, "error" to null, "progress" to null)
        var props = _nP(_uM("pt" to _uM("default" to fun(): UTSJSONObject {
            return (UTSJSONObject())
        }
        ), "modelValue" to _uM("default" to fun(): UTSArray<Any?> {
            return _uA()
        }
        ), "icon" to _uM("type" to "String", "default" to "camera-fill"), "text" to _uM("type" to "String", "default" to fun(): String {
            return t("上传 / 拍摄")
        }
        ), "sizeType" to _uM("default" to fun(): UTSArray<String> {
            return _uA(
                "original",
                "compressed"
            )
        }
        ), "sourceType" to _uM("type" to "Array", "default" to fun(): UTSArray<String> {
            return _uA(
                "album",
                "camera"
            )
        }
        ), "height" to _uM("type" to _uA(
            "Number",
            "String"
        ), "default" to 150), "width" to _uM("type" to _uA(
            "Number",
            "String"
        ), "default" to 150), "multiple" to _uM("type" to "Boolean", "default" to false), "limit" to _uM("type" to "Number", "default" to 9), "disabled" to _uM("type" to "Boolean", "default" to false), "test" to _uM("type" to "Boolean", "default" to false)))
        var propsNeedCastKeys = _uA(
            "pt",
            "modelValue",
            "icon",
            "text",
            "sizeType",
            "sourceType",
            "height",
            "width",
            "multiple",
            "limit",
            "disabled",
            "test"
        )
        var components: Map<String, CreateVueComponent> = _uM()
    }
}
