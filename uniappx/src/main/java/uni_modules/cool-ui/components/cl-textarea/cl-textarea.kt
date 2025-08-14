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
open class GenUniModulesCoolUiComponentsClTextareaClTextarea : VueComponent {
    constructor(__ins: ComponentInternalInstance) : super(__ins) {}
    open var pt: Any by `$props`
    open var modelValue: String by `$props`
    open var border: Boolean by `$props`
    open var disabled: Boolean by `$props`
    open var readonly: Boolean? by `$props`
    open var showWordLimit: Boolean by `$props`
    open var name: String by `$props`
    open var placeholder: String by `$props`
    open var placeholderClass: String by `$props`
    open var maxlength: Number by `$props`
    open var autofocus: Boolean by `$props`
    open var confirmType: String by `$props`
    open var cursor: Number by `$props`
    open var confirmHold: Boolean by `$props`
    open var height: Any by `$props`
    open var autoHeight: Boolean by `$props`
    open var fixed: Boolean by `$props`
    open var cursorSpacing: Number by `$props`
    open var cursorColor: String by `$props`
    open var showConfirmBar: Boolean by `$props`
    open var selectionStart: Number by `$props`
    open var selectionEnd: Number by `$props`
    open var adjustPosition: Boolean by `$props`
    open var inputmode: String by `$props`
    open var holdKeyboard: Boolean by `$props`
    open var disableDefaultPadding: Boolean by `$props`
    open var adjustKeyboardTo: String by `$props`
    open var isFocus: Boolean
        get() {
            return unref(this.`$exposed`["isFocus"]) as Boolean
        }
        set(value) {
            setRefValue(this.`$exposed`, "isFocus", value)
        }
    open var focus: () -> Unit
        get() {
            return unref(this.`$exposed`["focus"]) as () -> Unit
        }
        set(value) {
            setRefValue(this.`$exposed`, "focus", value)
        }
    companion object {
        @Suppress("UNUSED_PARAMETER", "UNUSED_VARIABLE")
        var setup: (__props: GenUniModulesCoolUiComponentsClTextareaClTextarea, _arg1: SetupContext) -> Any? = fun(__props, ref1): Any? {
            var __expose = ref1.expose
            val __ins = getCurrentInstance()!!
            val _ctx = __ins.proxy as GenUniModulesCoolUiComponentsClTextareaClTextarea
            val _cache = __ins.renderCache
            val props = __props
            fun emit(event: String, vararg do_not_transform_spread: Any?) {
                __ins.emit(event, *do_not_transform_spread)
            }
            val disabled = useForm().disabled
            val isError = useFormItem().isError
            val isDisabled = computed(fun(): Boolean {
                return disabled.value || props.disabled
            }
            )
            val pt = computed(fun(): PassThrough28 {
                return parsePt<PassThrough28>(props.pt)
            }
            )
            val _useSize = useSize(fun(): String {
                return pt.value.inner?.className ?: ""
            }
            )
            val ptClassName = _useSize.ptClassName
            val getSize = _useSize.getSize
            val textareaStyle = computed(fun(): UTSJSONObject {
                val style: UTSJSONObject = object : UTSJSONObject() {
                    var height = parseRpx(props.height)
                }
                val fontSize = getSize(null)
                if (fontSize != null) {
                    style["fontSize"] = fontSize
                }
                return style
            }
            )
            val value = ref(props.modelValue)
            val isFocus = ref<Boolean>(props.autofocus)
            fun gen_onFocus_fn() {
                isFocus.value = true
                emit("focus")
            }
            val onFocus = ::gen_onFocus_fn
            fun gen_onBlur_fn() {
                emit("blur")
                setTimeout(fun(){
                    isFocus.value = false
                }
                , 0)
            }
            val onBlur = ::gen_onBlur_fn
            fun gen_onInput_fn(e: UniInputEvent) {
                val kVal = e.detail.value
                value.value = kVal
                emit("update:modelValue", kVal)
                emit("change", kVal)
            }
            val onInput = ::gen_onInput_fn
            fun gen_onConfirm_fn(e: UniInputConfirmEvent) {
                emit("confirm", e)
            }
            val onConfirm = ::gen_onConfirm_fn
            fun gen_onKeyboardheightchange_fn(e: UniInputKeyboardHeightChangeEvent) {
                emit("keyboardheightchange", e)
            }
            val onKeyboardheightchange = ::gen_onKeyboardheightchange_fn
            fun gen_onLineChange_fn(e: UniTextareaLineChangeEvent) {
                emit("linechange", e)
            }
            val onLineChange = ::gen_onLineChange_fn
            fun gen_onTap_fn() {
                if (isDisabled.value) {
                    return
                }
                isFocus.value = true
            }
            val onTap = ::gen_onTap_fn
            fun gen_focus_fn() {
                setTimeout(fun(){
                    isFocus.value = false
                    nextTick(fun(){
                        isFocus.value = true
                    }
                    )
                }
                , 0)
            }
            val focus = ::gen_focus_fn
            watch(computed(fun(): String {
                return props.modelValue
            }
            ), fun(kVal: String){
                value.value = kVal
            }
            )
            __expose(_uM("isFocus" to isFocus, "focus" to focus))
            return fun(): Any? {
                val _component_cl_text = resolveEasyComponent("cl-text", GenUniModulesCoolUiComponentsClTextClTextClass)
                return _cE("view", _uM("class" to _nC(_uA(
                    "cl-textarea",
                    _uA(
                        _uM<String, Any?>(),
                        pt.value.className,
                        _uM("is-dark" to unref(isDark), "cl-textarea--border" to _ctx.border, "cl-textarea--focus" to isFocus.value, "cl-textarea--disabled" to isDisabled.value, "cl-textarea--error" to unref(isError))
                    )
                )), "onClick" to onTap), _uA(
                    _cE("textarea", _uM("class" to _nC(_uA(
                        "cl-textarea__inner",
                        _uA(
                            _uM("dark-colon-text-surface-50" to unref(isDark)),
                            _uM("is-disabled" to isDisabled.value, "is-dark" to unref(isDark)),
                            unref(ptClassName)
                        )
                    )), "style" to _nS(textareaStyle.value), "value" to value.value, "name" to _ctx.name, "disabled" to (_ctx.readonly ?: isDisabled.value), "placeholder" to _ctx.placeholder, "placeholder-class" to ("text-surface-400 " + _ctx.placeholderClass), "maxlength" to _ctx.maxlength, "auto-focus" to isFocus.value, "cursor" to _ctx.cursor, "cursor-spacing" to _ctx.cursorSpacing, "cursor-color" to _ctx.cursorColor, "show-confirm-bar" to _ctx.showConfirmBar, "confirm-hold" to _ctx.confirmHold, "auto-height" to _ctx.autoHeight, "fixed" to _ctx.fixed, "adjust-position" to _ctx.adjustPosition, "hold-keyboard" to _ctx.holdKeyboard, "inputmode" to _ctx.inputmode, "disable-default-padding" to _ctx.disableDefaultPadding, "adjust-keyboard-to" to _ctx.adjustKeyboardTo, "onConfirm" to onConfirm, "onInput" to onInput, "onLinechange" to onLineChange, "onBlur" to onBlur, "onFocus" to onFocus, "onKeyboardheightchange" to onKeyboardheightchange), null, 46, _uA(
                        "value",
                        "name",
                        "disabled",
                        "placeholder",
                        "placeholder-class",
                        "maxlength",
                        "auto-focus",
                        "cursor",
                        "cursor-spacing",
                        "cursor-color",
                        "show-confirm-bar",
                        "confirm-hold",
                        "auto-height",
                        "fixed",
                        "adjust-position",
                        "hold-keyboard",
                        "inputmode",
                        "disable-default-padding",
                        "adjust-keyboard-to"
                    )),
                    if (isTrue(_ctx.showWordLimit)) {
                        _cV(_component_cl_text, _uM("key" to 0, "pt" to object : UTSJSONObject() {
                            var className = "absolute right-2 bottom-2 -important-text-xs -important-text-surface-400"
                        }), _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                            return _uA(
                                _tD(value.value.length) + " / " + _tD(_ctx.maxlength)
                            )
                        }), "_" to 1))
                    } else {
                        _cC("v-if", true)
                    }
                ), 2)
            }
        }
        var name = "cl-textarea"
        val styles: Map<String, Map<String, Map<String, Any>>> by lazy {
            _nCS(_uA(
                styles0
            ))
        }
        val styles0: Map<String, Map<String, Map<String, Any>>>
            get() {
                return _uM("cl-textarea" to _uM("" to _uM("display" to "flex", "flexDirection" to "row", "alignItems" to "center", "backgroundColor" to "rgba(255,255,255,1)", "borderTopLeftRadius" to "14rpx", "borderTopRightRadius" to "14rpx", "borderBottomRightRadius" to "14rpx", "borderBottomLeftRadius" to "14rpx", "paddingTop" to "16rpx", "paddingRight" to "20rpx", "paddingBottom" to "16rpx", "paddingLeft" to "20rpx", "transitionProperty" to "borderColor,backgroundColor", "transitionDuration" to "0.2s"), ".is-dark" to _uM("backgroundColor" to "rgba(39,39,42,1)"), ".is-dark.cl-textarea--border" to _uM("borderTopColor" to "rgba(63,63,70,1)", "borderRightColor" to "rgba(63,63,70,1)", "borderBottomColor" to "rgba(63,63,70,1)", "borderLeftColor" to "rgba(63,63,70,1)"), ".is-dark.cl-textarea--border.cl-textarea--focus" to _uM("borderTopColor" to "rgba(20,184,166,1)", "borderRightColor" to "rgba(20,184,166,1)", "borderBottomColor" to "rgba(20,184,166,1)", "borderLeftColor" to "rgba(20,184,166,1)"), ".is-dark.cl-textarea--disabled" to _uM("backgroundColor" to "rgba(63,63,70,1)")), "uni-textarea-compute" to _uM(".cl-textarea " to _uM("opacity" to 0)), "cl-textarea__inner" to _uM("" to _uM("height" to "100%", "color" to "rgba(63,63,70,1)", "flex" to 1, "fontSize" to "28rpx"), ".is-dark" to _uM("color" to "rgba(255,255,255,1)")), "cl-textarea__icon" to _pS(_uM("display" to "flex", "height" to "100%", "alignItems" to "center", "justifyContent" to "center", "paddingLeft" to "20rpx")), "cl-textarea--border" to _pS(_uM("borderTopWidth" to 1, "borderRightWidth" to 1, "borderBottomWidth" to 1, "borderLeftWidth" to 1, "borderTopStyle" to "solid", "borderRightStyle" to "solid", "borderBottomStyle" to "solid", "borderLeftStyle" to "solid", "borderTopColor" to "rgba(228,228,231,1)", "borderRightColor" to "rgba(228,228,231,1)", "borderBottomColor" to "rgba(228,228,231,1)", "borderLeftColor" to "rgba(228,228,231,1)")), "cl-textarea--focus" to _pS(_uM("borderTopColor" to "rgba(20,184,166,1)", "borderRightColor" to "rgba(20,184,166,1)", "borderBottomColor" to "rgba(20,184,166,1)", "borderLeftColor" to "rgba(20,184,166,1)")), "cl-textarea--disabled" to _pS(_uM("backgroundColor" to "rgba(244,244,245,1)", "opacity" to 0.7)), "cl-textarea--error" to _pS(_uM("borderTopColor" to "rgba(239,68,68,1)", "borderRightColor" to "rgba(239,68,68,1)", "borderBottomColor" to "rgba(239,68,68,1)", "borderLeftColor" to "rgba(239,68,68,1)")), "@TRANSITION" to _uM("cl-textarea" to _uM("property" to "borderColor,backgroundColor", "duration" to "0.2s")))
            }
        var inheritAttrs = true
        var inject: Map<String, Map<String, Any?>> = _uM()
        var emits: Map<String, Any?> = _uM("update:modelValue" to null, "input" to null, "change" to null, "focus" to null, "blur" to null, "confirm" to null, "linechange" to null, "keyboardheightchange" to null)
        var props = _nP(_uM("pt" to _uM("default" to fun(): UTSJSONObject {
            return (UTSJSONObject())
        }
        ), "modelValue" to _uM("type" to "String", "default" to ""), "border" to _uM("type" to "Boolean", "default" to true), "disabled" to _uM("type" to "Boolean", "default" to false), "readonly" to _uM("type" to "Boolean", "default" to null), "showWordLimit" to _uM("type" to "Boolean", "default" to true), "name" to _uM("type" to "String", "default" to ""), "placeholder" to _uM("type" to "String", "default" to fun(): String {
            return t("请输入")
        }
        ), "placeholderClass" to _uM("type" to "String", "default" to ""), "maxlength" to _uM("type" to "Number", "default" to 140), "autofocus" to _uM("type" to "Boolean", "default" to false), "confirmType" to _uM("type" to "String", "default" to "done"), "cursor" to _uM("type" to "Number", "default" to 0), "confirmHold" to _uM("type" to "Boolean", "default" to false), "height" to _uM("type" to _uA(
            "Number",
            "String"
        ), "default" to 120), "autoHeight" to _uM("type" to "Boolean", "default" to false), "fixed" to _uM("type" to "Boolean", "default" to false), "cursorSpacing" to _uM("type" to "Number", "default" to 5), "cursorColor" to _uM("type" to "String", "default" to ""), "showConfirmBar" to _uM("type" to "Boolean", "default" to true), "selectionStart" to _uM("type" to "Number", "default" to -1), "selectionEnd" to _uM("type" to "Number", "default" to -1), "adjustPosition" to _uM("type" to "Boolean", "default" to true), "inputmode" to _uM("type" to "String", "default" to "text"), "holdKeyboard" to _uM("type" to "Boolean", "default" to false), "disableDefaultPadding" to _uM("type" to "Boolean", "default" to true), "adjustKeyboardTo" to _uM("type" to "String", "default" to "cursor")))
        var propsNeedCastKeys = _uA(
            "pt",
            "modelValue",
            "border",
            "disabled",
            "readonly",
            "showWordLimit",
            "name",
            "placeholder",
            "placeholderClass",
            "maxlength",
            "autofocus",
            "confirmType",
            "cursor",
            "confirmHold",
            "height",
            "autoHeight",
            "fixed",
            "cursorSpacing",
            "cursorColor",
            "showConfirmBar",
            "selectionStart",
            "selectionEnd",
            "adjustPosition",
            "inputmode",
            "holdKeyboard",
            "disableDefaultPadding",
            "adjustKeyboardTo"
        )
        var components: Map<String, CreateVueComponent> = _uM()
    }
}
