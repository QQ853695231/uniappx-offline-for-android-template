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
open class GenUniModulesCoolUiComponentsClCascaderClCascader : VueComponent {
    constructor(__ins: ComponentInternalInstance) : super(__ins) {}
    open var pt: Any by `$props`
    open var modelValue: UTSArray<String> by `$props`
    open var title: String by `$props`
    open var placeholder: String by `$props`
    open var options: UTSArray<ClListViewItem> by `$props`
    open var showTrigger: Boolean by `$props`
    open var disabled: Boolean by `$props`
    open var labelKey: String by `$props`
    open var valueKey: String by `$props`
    open var textSeparator: String by `$props`
    open var height: Any by `$props`
    open var open: () -> Unit
        get() {
            return unref(this.`$exposed`["open"]) as () -> Unit
        }
        set(value) {
            setRefValue(this.`$exposed`, "open", value)
        }
    open var close: () -> Unit
        get() {
            return unref(this.`$exposed`["close"]) as () -> Unit
        }
        set(value) {
            setRefValue(this.`$exposed`, "close", value)
        }
    open var reset: () -> Unit
        get() {
            return unref(this.`$exposed`["reset"]) as () -> Unit
        }
        set(value) {
            setRefValue(this.`$exposed`, "reset", value)
        }
    open var clear: () -> Unit
        get() {
            return unref(this.`$exposed`["clear"]) as () -> Unit
        }
        set(value) {
            setRefValue(this.`$exposed`, "clear", value)
        }
    companion object {
        @Suppress("UNUSED_PARAMETER", "UNUSED_VARIABLE")
        var setup: (__props: GenUniModulesCoolUiComponentsClCascaderClCascader, _arg1: SetupContext) -> Any? = fun(__props, ref1): Any? {
            var __expose = ref1.expose
            val __ins = getCurrentInstance()!!
            val _ctx = __ins.proxy as GenUniModulesCoolUiComponentsClCascaderClCascader
            val _cache = __ins.renderCache
            val props = __props
            fun emit(event: String, vararg do_not_transform_spread: Any?) {
                __ins.emit(event, *do_not_transform_spread)
            }
            val popupRef = ref<ClPopupComponentPublicInstance?>(null)
            val pt = computed(fun(): PassThrough26 {
                return parsePt<PassThrough26>(props.pt)
            }
            )
            val current = ref(0)
            val isNext = ref(true)
            val value = ref(_uA<Any>())
            val list = computed<UTSArray<UTSArray<ClListViewItem>>>(fun(): UTSArray<UTSArray<ClListViewItem>> {
                var data = props.options
                if (isEmpty(value.value)) {
                    return _uA(
                        data
                    )
                }
                val arr = value.value.map(fun(v): UTSArray<ClListViewItem> {
                    val item = data.find(fun(e): Boolean {
                        return e[props.valueKey] == v
                    }
                    )
                    if (item == null) {
                        return _uA()
                    }
                    if (!isNull(item.children)) {
                        data = item.children ?: _uA()
                    }
                    return data as UTSArray<ClListViewItem>
                }
                )
                return _uA(
                    props.options
                ).concat(arr)
            }
            )
            val flatOptions = computed(fun(): UTSArray<ClListViewItem> {
                val data = props.options
                val arr = _uA<ClListViewItem>()
                fun deep(list: UTSArray<ClListViewItem>) {
                    list.forEach(fun(e){
                        arr.push(e)
                        if (e.children != null) {
                            deep(e.children!!)
                        }
                    }
                    )
                }
                deep(data)
                return arr
            }
            )
            val labels = computed(fun(): UTSArray<Any> {
                val arr = value.value.map(fun(v, i): Any {
                    return list.value[i].find(fun(e): Boolean {
                        return e[props.valueKey] == v
                    }
                    )?.get(props.labelKey) ?: ""
                }
                )
                if (isNext.value && !isEmpty(flatOptions.value)) {
                    arr.push(t("请选择"))
                }
                return arr
            }
            )
            val text = computed(fun(): String {
                return props.modelValue.map(fun(v): Any {
                    return flatOptions.value.find(fun(e): Boolean {
                        return e[props.valueKey] == v
                    }
                    )?.get(props.labelKey) ?: ""
                }
                ).join(props.textSeparator)
            }
            )
            val visible = ref(false)
            fun gen_open_fn() {
                visible.value = true
            }
            val open = ::gen_open_fn
            fun gen_close_fn() {
                visible.value = false
            }
            val close = ::gen_close_fn
            fun gen_reset_fn() {
                current.value = 0
                value.value = _uA()
                isNext.value = true
            }
            val reset = ::gen_reset_fn
            fun gen_onClosed_fn() {
                reset()
            }
            val onClosed = ::gen_onClosed_fn
            fun gen_clear_fn() {
                reset()
                emit("update:modelValue", value.value)
                emit("change", value.value)
            }
            val clear = ::gen_clear_fn
            fun gen_onItemTap_fn(item: ClListViewItem) {
                if (item[props.valueKey] == null) {
                    return
                }
                val data = list.value[current.value].find(fun(e): Boolean {
                    return e[props.valueKey] == item[props.valueKey]
                }
                )
                value.value = value.value.slice(0, current.value)
                value.value.push(item[props.valueKey]!!)
                if (data != null) {
                    if (data.children == null || isEmpty(data.children!!)) {
                        close()
                        isNext.value = false
                        emit("update:modelValue", value.value)
                        emit("change", value.value)
                    } else {
                        isNext.value = true
                        nextTick(fun(){
                            current.value += 1
                        }
                        )
                    }
                }
            }
            val onItemTap = ::gen_onItemTap_fn
            fun gen_onItemActive_fn(index: Number, item: ClListViewItem): Boolean {
                if (isEmpty(value.value)) {
                    return false
                }
                if (index >= value.value.length) {
                    return false
                }
                return value.value[index] == item[props.valueKey]
            }
            val onItemActive = ::gen_onItemActive_fn
            fun gen_onLabelTap_fn(index: Number) {
                current.value = index
            }
            val onLabelTap = ::gen_onLabelTap_fn
            fun gen_onSwiperChange_fn(e: UniSwiperChangeEvent) {
                current.value = e.detail.current
            }
            val onSwiperChange = ::gen_onSwiperChange_fn
            __expose(_uM("open" to open, "close" to close, "reset" to reset, "clear" to clear))
            return fun(): Any? {
                val _component_cl_select_trigger = resolveEasyComponent("cl-select-trigger", GenUniModulesCoolUiComponentsClSelectTriggerClSelectTriggerClass)
                val _component_cl_tag = resolveEasyComponent("cl-tag", GenUniModulesCoolUiComponentsClTagClTagClass)
                val _component_cl_text = resolveEasyComponent("cl-text", GenUniModulesCoolUiComponentsClTextClTextClass)
                val _component_cl_list_view = resolveEasyComponent("cl-list-view", GenUniModulesCoolUiComponentsClListViewClListViewClass)
                val _component_cl_popup = resolveEasyComponent("cl-popup", GenUniModulesCoolUiComponentsClPopupClPopupClass)
                return _cE(Fragment, null, _uA(
                    if (isTrue(_ctx.showTrigger)) {
                        _cV(_component_cl_select_trigger, _uM("key" to 0, "pt" to object : UTSJSONObject() {
                            var className = pt.value.trigger?.className
                            var icon = pt.value.trigger?.icon
                        }, "placeholder" to _ctx.placeholder, "disabled" to _ctx.disabled, "focus" to popupRef.value?.isOpen, "text" to text.value, "onOpen" to open, "onClear" to clear), null, 8, _uA(
                            "pt",
                            "placeholder",
                            "disabled",
                            "focus",
                            "text"
                        ))
                    } else {
                        _cC("v-if", true)
                    }
                    ,
                    _cV(_component_cl_popup, _uM("ref_key" to "popupRef", "ref" to popupRef, "modelValue" to visible.value, "onUpdate:modelValue" to fun(`$event`: Boolean){
                        visible.value = `$event`
                    }
                    , "title" to _ctx.title, "pt" to object : UTSJSONObject() {
                        var className = pt.value.popup?.className
                        var header = pt.value.popup?.header
                        var container = pt.value.popup?.container
                        var mask = pt.value.popup?.mask
                        var draw = pt.value.popup?.draw
                    }, "onClosed" to onClosed), _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                        return _uA(
                            _cE("view", _uM("class" to "cl-select-popup", "onTouchmove" to withModifiers(fun(){}, _uA(
                                "stop"
                            ))), _uA(
                                _cE("view", _uM("class" to "cl-select-popup__labels"), _uA(
                                    _cE(Fragment, null, RenderHelpers.renderList(labels.value, fun(item, index, __index, _cached): Any {
                                        return _cV(_component_cl_tag, _uM("key" to index, "type" to if (index != current.value) {
                                            "info"
                                        } else {
                                            "primary"
                                        }
                                        , "plain" to "", "onClick" to fun(){
                                            onLabelTap(index)
                                        }
                                        ), _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                                            return _uA(
                                                _tD(item)
                                            )
                                        }
                                        ), "_" to 2), 1032, _uA(
                                            "type",
                                            "onClick"
                                        ))
                                    }
                                    ), 128)
                                )),
                                _cE("view", _uM("class" to "cl-select-popup__list", "style" to _nS(_uM("height" to unref(parseRpx)(_ctx.height)))), _uA(
                                    if (isTrue(if (unref(isMp)()) {
                                        popupRef.value?.isOpen
                                    } else {
                                        true
                                    }
                                    )) {
                                        _cE("swiper", _uM("key" to 0, "class" to "h-full bg-transparent", "current" to current.value, "onChange" to onSwiperChange), _uA(
                                            _cE(Fragment, null, RenderHelpers.renderList(list.value, fun(data, index, __index, _cached): Any {
                                                return _cE("swiper-item", _uM("key" to index, "class" to "h-full bg-transparent"), _uA(
                                                    _cV(_component_cl_list_view, _uM("data" to data, "item-height" to 45, "virtual" to !unref(isMp)(), "onItemTap" to onItemTap), _uM("item" to withScopedSlotCtx(fun(slotProps: GenUniModulesCoolUiComponentsClListViewClListViewSlotDataItem): UTSArray<Any> {
                                                        val data = slotProps.data
                                                        val item = slotProps.item
                                                        return _uA(
                                                            _cE("view", _uM("class" to _nC(_uA(
                                                                "flex flex-row items-center justify-between w-full px--bracket-start-20rpx-bracket-end-",
                                                                _uM("bg-primary-50" to onItemActive(index, data), "bg-surface-800" to (unref(isDark) && onItemActive(index, data)))
                                                            )), "style" to _nS(_uM("height" to (item.height + "px")))), _uA(
                                                                _cV(_component_cl_text, _uM("pt" to object : UTSJSONObject() {
                                                                    var className = unref(parseClass)(object : UTSJSONObject() {
                                                                        var `-important-text-primary-500` = onItemActive(index, data)
                                                                    })
                                                                }), _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                                                                    return _uA(
                                                                        _tD(data[_ctx.labelKey])
                                                                    )
                                                                }), "_" to 2), 1032, _uA(
                                                                    "pt"
                                                                ))
                                                            ), 6)
                                                        )
                                                    }), "_" to 2), 1032, _uA(
                                                        "data",
                                                        "virtual"
                                                    ))
                                                ))
                                            }), 128)
                                        ), 40, _uA(
                                            "current"
                                        ))
                                    } else {
                                        _cC("v-if", true)
                                    }
                                ), 4)
                            ), 40, _uA(
                                "onTouchmove"
                            ))
                        )
                    }
                    ), "_" to 1), 8, _uA(
                        "modelValue",
                        "onUpdate:modelValue",
                        "title",
                        "pt"
                    ))
                ), 64)
            }
        }
        var name = "cl-cascader"
        val styles: Map<String, Map<String, Map<String, Any>>> by lazy {
            _nCS(_uA(
                styles0
            ))
        }
        val styles0: Map<String, Map<String, Map<String, Any>>>
            get() {
                return _uM("cl-select-popup__labels" to _pS(_uM("marginBottom" to "21rpx", "display" to "flex", "flexDirection" to "row", "paddingTop" to 0, "paddingRight" to "20rpx", "paddingBottom" to 0, "paddingLeft" to "20rpx")), "cl-select-popup__list" to _pS(_uM("position" to "relative")))
            }
        var inheritAttrs = true
        var inject: Map<String, Map<String, Any?>> = _uM()
        var emits: Map<String, Any?> = _uM("update:modelValue" to null, "change" to null)
        var props = _nP(_uM("pt" to _uM("default" to fun(): UTSJSONObject {
            return (UTSJSONObject())
        }
        ), "modelValue" to _uM("type" to "Array", "default" to fun(): UTSArray<Any?> {
            return _uA()
        }
        ), "title" to _uM("type" to "String", "default" to fun(): String {
            return t("请选择")
        }
        ), "placeholder" to _uM("type" to "String", "default" to fun(): String {
            return t("请选择")
        }
        ), "options" to _uM("type" to "Array", "default" to fun(): UTSArray<Any?> {
            return _uA()
        }
        ), "showTrigger" to _uM("type" to "Boolean", "default" to true), "disabled" to _uM("type" to "Boolean", "default" to false), "labelKey" to _uM("type" to "String", "default" to "label"), "valueKey" to _uM("type" to "String", "default" to "label"), "textSeparator" to _uM("type" to "String", "default" to " - "), "height" to _uM("type" to _uA(
            "String",
            "Number"
        ), "default" to 800)))
        var propsNeedCastKeys = _uA(
            "pt",
            "modelValue",
            "title",
            "placeholder",
            "options",
            "showTrigger",
            "disabled",
            "labelKey",
            "valueKey",
            "textSeparator",
            "height"
        )
        var components: Map<String, CreateVueComponent> = _uM()
    }
}
