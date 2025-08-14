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
open class GenUniModulesCoolUiComponentsClKeyboardPasswordClKeyboardPassword : VueComponent {
    constructor(__ins: ComponentInternalInstance) : super(__ins) {}
    open var pt: Any by `$props`
    open var modelValue: String by `$props`
    open var title: String by `$props`
    open var placeholder: String by `$props`
    open var minlength: Number by `$props`
    open var maxlength: Number by `$props`
    open var confirmText: String by `$props`
    open var showValue: Boolean by `$props`
    open var inputImmediate: Boolean by `$props`
    open var encrypt: Boolean by `$props`
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
        var setup: (__props: GenUniModulesCoolUiComponentsClKeyboardPasswordClKeyboardPassword, _arg1: SetupContext) -> Any? = fun(__props, ref1): Any? {
            var __expose = ref1.expose
            val __ins = getCurrentInstance()!!
            val _ctx = __ins.proxy as GenUniModulesCoolUiComponentsClKeyboardPasswordClKeyboardPassword
            val _cache = __ins.renderCache
            val props = __props
            fun emit(event: String, vararg do_not_transform_spread: Any?) {
                __ins.emit(event, *do_not_transform_spread)
            }
            val pt = computed(fun(): PassThrough38 {
                return parsePt<PassThrough38>(props.pt)
            }
            )
            val ui = useUi()
            val visible = ref(false)
            val value = ref(props.modelValue)
            val mode = ref<String>("letter")
            val valueText = computed(fun(): String {
                if (props.encrypt) {
                    return "*".repeat(value.value.length)
                }
                return value.value
            }
            )
            val list = computed(fun(): UTSArray<UTSArray<String>> {
                val letter = _uA(
                    _uA(
                        "q",
                        "w",
                        "e",
                        "r",
                        "t",
                        "y",
                        "u",
                        "i",
                        "o",
                        "p"
                    ),
                    _uA(
                        "a",
                        "s",
                        "d",
                        "f",
                        "g",
                        "h",
                        "j",
                        "k",
                        "l",
                        "m"
                    ),
                    _uA(
                        "caps",
                        "z",
                        "x",
                        "c",
                        "v",
                        "b",
                        "n",
                        "m",
                        "delete"
                    ),
                    _uA(
                        "number",
                        "space",
                        "confirm"
                    )
                ) as UTSArray<UTSArray<String>>
                val letterUpper = _uA(
                    _uA(
                        "Q",
                        "W",
                        "E",
                        "R",
                        "T",
                        "Y",
                        "U",
                        "I",
                        "O",
                        "P"
                    ),
                    _uA(
                        "A",
                        "S",
                        "D",
                        "F",
                        "G",
                        "H",
                        "J",
                        "K",
                        "L",
                        "M"
                    ),
                    _uA(
                        "caps",
                        "Z",
                        "X",
                        "C",
                        "V",
                        "B",
                        "N",
                        "M",
                        "delete"
                    ),
                    _uA(
                        "number",
                        "space",
                        "confirm"
                    )
                ) as UTSArray<UTSArray<String>>
                val number = _uA(
                    _uA(
                        "1",
                        "2",
                        "3",
                        "4",
                        "5",
                        "6",
                        "7",
                        "8",
                        "9",
                        "0"
                    ),
                    _uA(
                        "#",
                        "/",
                        ":",
                        ";",
                        "(",
                        ")",
                        "^",
                        "*",
                        "+"
                    ),
                    _uA(
                        "-",
                        "=",
                        "|",
                        "~",
                        "\$",
                        "&",
                        ".",
                        ",",
                        "delete"
                    ),
                    _uA(
                        "letter",
                        "%",
                        "?",
                        "!",
                        "{",
                        "}",
                        "confirm"
                    )
                ) as UTSArray<UTSArray<String>>
                when (mode.value) {
                    "letter" -> 
                        return letter
                    "letterUpper" -> 
                        return letterUpper
                    "number" -> 
                        return number
                    else -> 
                        return letter
                }
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
                if (key == "caps") {
                    mode.value = if (mode.value == "letter") {
                        "letterUpper"
                    } else {
                        "letter"
                    }
                    return
                }
                if (key == "letter") {
                    mode.value = "letter"
                    return
                }
                if (key == "number") {
                    mode.value = "number"
                    return
                }
                if (key == "confirm") {
                    if (value.value == "") {
                        ui.showToast(ClToastOptions(message = t("请输入内容")))
                        return
                    }
                    if (value.value.length < props.minlength || value.value.length > props.maxlength) {
                        ui.showToast(ClToastOptions(message = `$t`("请输入{minlength}到{maxlength}位密码", object : UTSJSONObject() {
                            var minlength = props.minlength
                            var maxlength = props.maxlength
                        })))
                        return
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
                if (value.value.length >= props.maxlength) {
                    ui.showToast(ClToastOptions(message = `$t`("最多输入{maxlength}位", object : UTSJSONObject() {
                        var maxlength = props.maxlength
                    })))
                    return
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
                val _component_cl_badge = resolveEasyComponent("cl-badge", GenUniModulesCoolUiComponentsClBadgeClBadgeClass)
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
                            "cl-keyboard-password",
                            _uA(
                                _uM<String, Any?>(),
                                pt.value.className
                            )
                        ))), _uA(
                            renderSlot(_ctx.`$slots`, "value", GenUniModulesCoolUiComponentsClKeyboardPasswordClKeyboardPasswordSlotDataValue(value = value.value), fun(): UTSArray<Any> {
                                return _uA(
                                    if (isTrue(_ctx.showValue)) {
                                        _cE("view", _uM("key" to 0, "class" to _nC(_uA(
                                            "cl-keyboard-password__value",
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
                                                        _tD(valueText.value)
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
                            _cE("view", _uM("class" to "cl-keyboard-password__list"), _uA(
                                _cE(Fragment, null, RenderHelpers.renderList(list.value, fun(row, rowIndex, __index, _cached): Any {
                                    return _cE("view", _uM("class" to _nC(_uA(
                                        "cl-keyboard-password__rows",
                                        _uA(
                                            _uM<String, Any?>(),
                                            "is-mode-" + mode.value
                                        )
                                    )), "key" to rowIndex), _uA(
                                        _cE(Fragment, null, RenderHelpers.renderList(row, fun(item, index, __index, _cached): Any {
                                            return _cE("view", _uM("key" to item, "class" to _nC(_uA(
                                                "cl-keyboard-password__item",
                                                _uA(
                                                    _uM<String, Any?>(),
                                                    "is-keycode-" + item,
                                                    _uM("is-empty" to (item == ""), "is-dark" to unref(isDark)),
                                                    pt.value.item?.className
                                                )
                                            )), "style" to _nS(_uM("marginRight" to if (index == row.length - 1) {
                                                "0"
                                            } else {
                                                "10rpx"
                                            }
                                            )), "hover-class" to "opacity-50", "hover-stay-time" to 50, "onTouchstart" to withModifiers(fun(){
                                                onCommand(item)
                                            }
                                            , _uA(
                                                "stop"
                                            ))), _uA(
                                                renderSlot(_ctx.`$slots`, "item", GenUniModulesCoolUiComponentsClKeyboardPasswordClKeyboardPasswordSlotDataItem(item = item), fun(): UTSArray<Any> {
                                                    return _uA(
                                                        if (item == "delete") {
                                                            _cV(_component_cl_icon, _uM("key" to 0, "name" to "delete-back-2-line", "size" to 36))
                                                        } else {
                                                            if (item == "confirm") {
                                                                _cV(_component_cl_text, _uM("key" to 1, "color" to "white", "pt" to object : UTSJSONObject() {
                                                                    var className = "-important-text-lg"
                                                                }), _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                                                                    return _uA(
                                                                        _tD(_ctx.confirmText)
                                                                    )
                                                                }), "_" to 1))
                                                            } else {
                                                                if (item == "letter") {
                                                                    _cV(_component_cl_text, _uM("key" to 2, "pt" to object : UTSJSONObject() {
                                                                        var className = "-important-text-lg"
                                                                    }), _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                                                                        return _uA(
                                                                            "ABC"
                                                                        )
                                                                    }), "_" to 1))
                                                                } else {
                                                                    if (item == "number") {
                                                                        _cV(_component_cl_text, _uM("key" to 3, "pt" to object : UTSJSONObject() {
                                                                            var className = "-important-text-lg"
                                                                        }), _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                                                                            return _uA(
                                                                                "123"
                                                                            )
                                                                        }), "_" to 1))
                                                                    } else {
                                                                        if (item == "caps") {
                                                                            _cE(Fragment, _uM("key" to 4), _uA(
                                                                                _cV(_component_cl_icon, _uM("name" to "upload-line", "size" to 36)),
                                                                                if (mode.value == "letterUpper") {
                                                                                    _cV(_component_cl_badge, _uM("key" to 0, "dot" to "", "position" to "", "type" to "info", "pt" to object : UTSJSONObject() {
                                                                                        var className = "-important-right-1 -important-top-1"
                                                                                    }))
                                                                                } else {
                                                                                    _cC("v-if", true)
                                                                                }
                                                                            ), 64)
                                                                        } else {
                                                                            _cV(_component_cl_text, _uM("key" to 5, "pt" to object : UTSJSONObject() {
                                                                                var className = "-important-text-lg"
                                                                            }), _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                                                                                return _uA(
                                                                                    _tD(item)
                                                                                )
                                                                            }
                                                                            ), "_" to 2), 1024)
                                                                        }
                                                                    }
                                                                }
                                                            }
                                                        }
                                                    )
                                                }
                                                )
                                            ), 46, _uA(
                                                "onTouchstart"
                                            ))
                                        }
                                        ), 128)
                                    ), 2)
                                }
                                ), 128)
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
        var name = "cl-keyboard-password"
        val styles: Map<String, Map<String, Map<String, Any>>> by lazy {
            _nCS(_uA(
                styles0
            ))
        }
        val styles0: Map<String, Map<String, Map<String, Any>>>
            get() {
                return _uM("cl-keyboard-password" to _pS(_uM("paddingTop" to 0, "paddingRight" to "20rpx", "paddingBottom" to "20rpx", "paddingLeft" to "20rpx")), "cl-keyboard-password__value" to _pS(_uM("display" to "flex", "flexDirection" to "row", "alignItems" to "center", "justifyContent" to "center", "height" to "80rpx", "marginBottom" to "20rpx")), "cl-keyboard-password__list" to _pS(_uM("position" to "relative")), "cl-keyboard-password__rows" to _uM("" to _uM("display" to "flex", "flexDirection" to "row", "alignItems" to "center"), ".is-mode-province" to _uM("justifyContent" to "center"), ".is-mode-plate" to _uM("justifyContent" to "space-between")), "cl-keyboard-password__item" to _uM("" to _uM("position" to "relative", "display" to "flex", "alignItems" to "center", "justifyContent" to "center", "borderTopLeftRadius" to "14rpx", "borderTopRightRadius" to "14rpx", "borderBottomRightRadius" to "14rpx", "borderBottomLeftRadius" to "14rpx", "backgroundColor" to "rgba(255,255,255,1)", "height" to "80rpx", "width" to "62rpx", "marginTop" to "10rpx", "flex" to 1), ".is-dark" to _uM("backgroundColor" to "rgba(39,39,42,1)"), ".is-keycode-number" to _uM("width" to "150rpx", "flex" to "none", "backgroundColor" to "rgba(228,228,231,1)"), ".is-keycode-letter" to _uM("width" to "150rpx", "flex" to "none", "backgroundColor" to "rgba(228,228,231,1)"), ".is-keycode-caps" to _uM("width" to "80rpx", "flex" to "none", "backgroundColor" to "rgba(228,228,231,1)"), ".is-keycode-delete" to _uM("width" to "80rpx", "flex" to "none", "backgroundColor" to "rgba(228,228,231,1)"), ".is-keycode-letter.is-dark" to _uM("backgroundColor" to "rgba(82,82,91,1)"), ".is-keycode-number.is-dark" to _uM("backgroundColor" to "rgba(82,82,91,1)"), ".is-keycode-caps.is-dark" to _uM("backgroundColor" to "rgba(82,82,91,1)"), ".is-keycode-delete.is-dark" to _uM("backgroundColor" to "rgba(82,82,91,1)"), ".is-keycode-confirm" to _uM("backgroundColor" to "rgba(20,184,166,1)", "!width" to "150rpx", "flex" to "none"), ".is-empty" to _uM("!backgroundColor" to "rgba(0,0,0,0)")))
            }
        var inheritAttrs = true
        var inject: Map<String, Map<String, Any?>> = _uM()
        var emits: Map<String, Any?> = _uM("update:modelValue" to null, "change" to null)
        var props = _nP(_uM("pt" to _uM("default" to fun(): UTSJSONObject {
            return (UTSJSONObject())
        }
        ), "modelValue" to _uM("type" to "String", "default" to ""), "title" to _uM("type" to "String", "default" to fun(): String {
            return t("密码键盘")
        }
        ), "placeholder" to _uM("type" to "String", "default" to fun(): String {
            return t("安全键盘，请放心输入")
        }
        ), "minlength" to _uM("type" to "Number", "default" to 6), "maxlength" to _uM("type" to "Number", "default" to 20), "confirmText" to _uM("type" to "String", "default" to fun(): String {
            return t("确定")
        }
        ), "showValue" to _uM("type" to "Boolean", "default" to true), "inputImmediate" to _uM("type" to "Boolean", "default" to false), "encrypt" to _uM("type" to "Boolean", "default" to false)))
        var propsNeedCastKeys = _uA(
            "pt",
            "modelValue",
            "title",
            "placeholder",
            "minlength",
            "maxlength",
            "confirmText",
            "showValue",
            "inputImmediate",
            "encrypt"
        )
        var components: Map<String, CreateVueComponent> = _uM()
    }
}
