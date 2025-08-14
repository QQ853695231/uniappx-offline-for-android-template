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
import uts.sdk.modules.coolVibrate.vibrate
open class GenUniModulesCoolUiComponentsClKeyboardNumberClKeyboardNumber : VueComponent {
    constructor(__ins: ComponentInternalInstance) : super(__ins) {}
    open var pt: Any by `$props`
    open var modelValue: String by `$props`
    open var type: String by `$props`
    open var title: String by `$props`
    open var placeholder: String by `$props`
    open var maxlength: Number by `$props`
    open var confirmText: String by `$props`
    open var showValue: Boolean by `$props`
    open var inputImmediate: Boolean by `$props`
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
    companion object {
        @Suppress("UNUSED_PARAMETER", "UNUSED_VARIABLE")
        var setup: (__props: GenUniModulesCoolUiComponentsClKeyboardNumberClKeyboardNumber, _arg1: SetupContext) -> Any? = fun(__props, ref1): Any? {
            var __expose = ref1.expose
            val __ins = getCurrentInstance()!!
            val _ctx = __ins.proxy as GenUniModulesCoolUiComponentsClKeyboardNumberClKeyboardNumber
            val _cache = __ins.renderCache
            val props = __props
            fun emit(event: String, vararg do_not_transform_spread: Any?) {
                __ins.emit(event, *do_not_transform_spread)
            }
            val pt = computed(fun(): PassThrough36 {
                return parsePt<PassThrough36>(props.pt)
            }
            )
            val ui = useUi()
            val visible = ref(false)
            val value = ref(props.modelValue)
            val maxlength = computed(fun(): Number {
                if (props.type == "idcard") {
                    return 18
                }
                return props.maxlength
            }
            )
            val list = computed(fun(): UTSArray<String> {
                val arr = _uA(
                    "1",
                    "2",
                    "3",
                    "delete",
                    "4",
                    "5",
                    "6",
                    "",
                    "7",
                    "8",
                    "9",
                    "",
                    "00",
                    "0",
                    "",
                    "confirm"
                )
                if (props.type == "digit") {
                    arr[14] = "."
                }
                if (props.type == "idcard") {
                    arr[14] = "X"
                }
                return arr
            }
            )
            fun gen_open_fn() {
                visible.value = true
            }
            val open = ::gen_open_fn
            fun gen_close_fn() {
                visible.value = false
            }
            val close = ::gen_close_fn
            fun gen_onCommand_fn(key: String) {
                vibrate(1)
                if (key == "confirm") {
                    if (value.value == "") {
                        ui.showToast(ClToastOptions(message = t("请输入内容")))
                        return
                    }
                    if (value.value.endsWith(".")) {
                        value.value = value.value.slice(0, -1)
                    }
                    if (props.type == "idcard") {
                        if (!UTSRegExp("^(^[1-9]\\d{5}(18|19|20)?\\d{2}(0[1-9]|1[0-2])(0[1-9]|[12]\\d|3[01])\\d{3}(\\d|X|x)?\$)\$", "").test(value.value)) {
                            ui.showToast(ClToastOptions(message = t("身份证号码格式不正确")))
                            return
                        }
                    }
                    emit("update:modelValue", value.value)
                    emit("change", value.value)
                    close()
                    return
                }
                if (key == "delete") {
                    value.value = value.value.slice(0, -1)
                    return
                }
                if (value.value.length >= maxlength.value) {
                    ui.showToast(ClToastOptions(message = `$t`("最多输入{maxlength}位", object : UTSJSONObject() {
                        var maxlength = maxlength.value
                    })))
                    return
                }
                if (key == ".") {
                    if (value.value.includes(".")) {
                        return
                    }
                    if (value.value == "") {
                        value.value = "0."
                        return
                    }
                }
                if (key == "00") {
                    if (value.value.length + 2 > maxlength.value) {
                        value.value += "0"
                        return
                    }
                    if (value.value == "") {
                        value.value = "0"
                        return
                    }
                }
                if (key == "00" || key == "0") {
                    if (value.value == "" || value.value == "0") {
                        value.value = "0"
                        return
                    }
                }
                value.value += key
            }
            val onCommand = ::gen_onCommand_fn
            watch(value, fun(kVal: String){
                if (props.inputImmediate) {
                    emit("update:modelValue", kVal)
                    emit("change", kVal)
                }
            }
            )
            watch(computed(fun(): String {
                return props.modelValue
            }
            ), fun(kVal: String){
                value.value = kVal
            }
            )
            __expose(_uM("open" to open, "close" to close))
            return fun(): Any? {
                val _component_cl_text = resolveEasyComponent("cl-text", GenUniModulesCoolUiComponentsClTextClTextClass)
                val _component_cl_icon = resolveEasyComponent("cl-icon", GenUniModulesCoolUiComponentsClIconClIconClass)
                val _component_cl_col = resolveEasyComponent("cl-col", GenUniModulesCoolUiComponentsClColClColClass)
                val _component_cl_row = resolveEasyComponent("cl-row", GenUniModulesCoolUiComponentsClRowClRowClass)
                val _component_cl_popup = resolveEasyComponent("cl-popup", GenUniModulesCoolUiComponentsClPopupClPopupClass)
                return _cV(_component_cl_popup, _uM("title" to _ctx.title, "swipe-close-threshold" to 100, "pt" to object : UTSJSONObject() {
                    var inner = object : UTSJSONObject() {
                        var className = unref(parseClass)(_uA(
                            _uA(
                                unref(isDark),
                                "-important-bg-surface-700",
                                "-important-bg-surface-100"
                            ),
                            pt.value.popup?.className
                        ))
                    }
                    var mask = object : UTSJSONObject() {
                        var className = "-important-bg-transparent"
                    }
                }, "modelValue" to visible.value, "onUpdate:modelValue" to fun(`$event`: Boolean){
                    visible.value = `$event`
                }
                ), _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                    return _uA(
                        _cE("view", _uM("class" to _nC(_uA(
                            "cl-keyboard-number",
                            _uA(
                                _uM<String, Any?>(),
                                pt.value.className
                            )
                        ))), _uA(
                            renderSlot(_ctx.`$slots`, "value", GenUniModulesCoolUiComponentsClKeyboardNumberClKeyboardNumberSlotDataValue(value = value.value), fun(): UTSArray<Any> {
                                return _uA(
                                    if (isTrue(_ctx.showValue)) {
                                        _cE("view", _uM("key" to 0, "class" to _nC(_uA(
                                            "cl-keyboard-number__value",
                                            _uA(
                                                _uM<String, Any?>(),
                                                pt.value.value?.className
                                            )
                                        ))), _uA(
                                            if (value.value != "") {
                                                _cV(_component_cl_text, _uM("key" to 0, "pt" to object : UTSJSONObject() {
                                                    var className = "-important-text-2xl"
                                                }), _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                                                    return _uA(
                                                        _tD(value.value)
                                                    )
                                                }), "_" to 1))
                                            } else {
                                                _cV(_component_cl_text, _uM("key" to 1, "pt" to object : UTSJSONObject() {
                                                    var className = "-important-text-md -important-text-surface-400"
                                                }), _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                                                    return _uA(
                                                        _tD(_ctx.placeholder)
                                                    )
                                                }), "_" to 1))
                                            }
                                        ), 2)
                                    } else {
                                        _cC("v-if", true)
                                    }
                                )
                            }
                            ),
                            _cE("view", _uM("class" to "cl-keyboard-number__list"), _uA(
                                _cV(_component_cl_row, _uM("gutter" to 10), _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                                    return _uA(
                                        _cE(Fragment, null, RenderHelpers.renderList(list.value, fun(item, __key, __index, _cached): Any {
                                            return _cV(_component_cl_col, _uM("span" to 6, "key" to item), _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                                                return _uA(
                                                    _cE("view", _uM("class" to _nC(_uA(
                                                        "cl-keyboard-number__item",
                                                        _uA(
                                                            _uM<String, Any?>(),
                                                            "is-keycode-" + item,
                                                            _uM("is-dark" to unref(isDark), "is-empty" to (item == "")),
                                                            pt.value.item?.className
                                                        )
                                                    )), "hover-class" to "opacity-50", "hover-stay-time" to 50, "onTouchstart" to withModifiers(fun(){
                                                        onCommand(item)
                                                    }
                                                    , _uA(
                                                        "stop"
                                                    ))), _uA(
                                                        renderSlot(_ctx.`$slots`, "item", GenUniModulesCoolUiComponentsClKeyboardNumberClKeyboardNumberSlotDataItem(item = item), fun(): UTSArray<Any> {
                                                            return _uA(
                                                                if (item == "delete") {
                                                                    _cV(_component_cl_icon, _uM("key" to 0, "name" to "delete-back-2-line", "size" to 36))
                                                                } else {
                                                                    if (item == "confirm") {
                                                                        _cE("view", _uM("key" to 1, "class" to "cl-keyboard-number__item-confirm"), _uA(
                                                                            _cV(_component_cl_text, _uM("color" to "white", "pt" to object : UTSJSONObject() {
                                                                                var className = "-important-text-lg"
                                                                            }), _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                                                                                return _uA(
                                                                                    _tD(_ctx.confirmText)
                                                                                )
                                                                            }), "_" to 1))
                                                                        ))
                                                                    } else {
                                                                        _cV(_component_cl_text, _uM("key" to 2, "pt" to object : UTSJSONObject() {
                                                                            var className = "-important-text-lg"
                                                                        }), _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                                                                            return _uA(
                                                                                _tD(item)
                                                                            )
                                                                        }
                                                                        ), "_" to 2), 1024)
                                                                    }
                                                                }
                                                            )
                                                        }
                                                        )
                                                    ), 42, _uA(
                                                        "onTouchstart"
                                                    ))
                                                )
                                            }
                                            ), "_" to 2), 1024)
                                        }
                                        ), 128)
                                    )
                                }
                                ), "_" to 3))
                            ))
                        ), 2)
                    )
                }
                ), "_" to 3), 8, _uA(
                    "title",
                    "pt",
                    "modelValue",
                    "onUpdate:modelValue"
                ))
            }
        }
        var name = "cl-keyboard-number"
        val styles: Map<String, Map<String, Map<String, Any>>> by lazy {
            _nCS(_uA(
                styles0
            ))
        }
        val styles0: Map<String, Map<String, Map<String, Any>>>
            get() {
                return _uM("cl-keyboard-number" to _pS(_uM("paddingTop" to 0, "paddingRight" to "20rpx", "paddingBottom" to "20rpx", "paddingLeft" to "20rpx")), "cl-keyboard-number__value" to _pS(_uM("display" to "flex", "flexDirection" to "row", "alignItems" to "center", "justifyContent" to "center", "height" to "80rpx", "marginBottom" to "20rpx")), "cl-keyboard-number__list" to _pS(_uM("position" to "relative")), "cl-keyboard-number__item" to _uM("" to _uM("display" to "flex", "alignItems" to "center", "justifyContent" to "center", "borderTopLeftRadius" to "21rpx", "borderTopRightRadius" to "21rpx", "borderBottomRightRadius" to "21rpx", "borderBottomLeftRadius" to "21rpx", "backgroundColor" to "rgba(255,255,255,1)", "height" to "100rpx", "marginTop" to "10rpx", "overflow" to "visible"), ".is-dark" to _uM("backgroundColor" to "rgba(39,39,42,1)"), ".is-keycode-delete" to _uM("backgroundColor" to "rgba(228,228,231,1)"), ".is-keycode-delete.is-dark" to _uM("backgroundColor" to "rgba(39,39,42,1)"), ".is-keycode-confirm" to _uM("position" to "relative", "backgroundColor" to "rgba(0,0,0,0)"), ".is-empty" to _uM("!backgroundColor" to "rgba(0,0,0,0)")), "cl-keyboard-number__item-confirm" to _pS(_uM("display" to "flex", "flexDirection" to "column", "alignItems" to "center", "justifyContent" to "center", "position" to "absolute", "width" to "100%", "borderTopLeftRadius" to "21rpx", "borderTopRightRadius" to "21rpx", "borderBottomRightRadius" to "21rpx", "borderBottomLeftRadius" to "21rpx", "backgroundColor" to "rgba(20,184,166,1)", "height" to "320rpx", "top" to "-220rpx")))
            }
        var inheritAttrs = true
        var inject: Map<String, Map<String, Any?>> = _uM()
        var emits: Map<String, Any?> = _uM("update:modelValue" to null, "change" to null)
        var props = _nP(_uM("pt" to _uM("default" to fun(): UTSJSONObject {
            return (UTSJSONObject())
        }
        ), "modelValue" to _uM("type" to "String", "default" to ""), "type" to _uM("type" to "String", "default" to "digit"), "title" to _uM("type" to "String", "default" to fun(): String {
            return t("数字键盘")
        }
        ), "placeholder" to _uM("type" to "String", "default" to fun(): String {
            return t("安全键盘，请放心输入")
        }
        ), "maxlength" to _uM("type" to "Number", "default" to 10), "confirmText" to _uM("type" to "String", "default" to fun(): String {
            return t("确定")
        }
        ), "showValue" to _uM("type" to "Boolean", "default" to true), "inputImmediate" to _uM("type" to "Boolean", "default" to false)))
        var propsNeedCastKeys = _uA(
            "pt",
            "modelValue",
            "type",
            "title",
            "placeholder",
            "maxlength",
            "confirmText",
            "showValue",
            "inputImmediate"
        )
        var components: Map<String, CreateVueComponent> = _uM()
    }
}
