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
import io.dcloud.uniapp.extapi.hideKeyboard as uni_hideKeyboard
open class GenUniModulesCoolUiComponentsClInputOtpClInputOtp : VueComponent {
    constructor(__ins: ComponentInternalInstance) : super(__ins) {}
    open var pt: Any by `$props`
    open var modelValue: String by `$props`
    open var autofocus: Boolean by `$props`
    open var length: Number by `$props`
    open var disabled: Boolean by `$props`
    open var inputType: String by `$props`
    companion object {
        @Suppress("UNUSED_PARAMETER", "UNUSED_VARIABLE")
        var setup: (__props: GenUniModulesCoolUiComponentsClInputOtpClInputOtp) -> Any? = fun(__props): Any? {
            val __ins = getCurrentInstance()!!
            val _ctx = __ins.proxy as GenUniModulesCoolUiComponentsClInputOtpClInputOtp
            val _cache = __ins.renderCache
            val props = __props
            fun emit(event: String, vararg do_not_transform_spread: Any?) {
                __ins.emit(event, *do_not_transform_spread)
            }
            val pt = computed(fun(): PassThrough35 {
                return parsePt<PassThrough35>(props.pt)
            }
            )
            val inputRef = ref<ClInputComponentPublicInstance?>(null)
            val value = ref(props.modelValue) as Ref<String>
            val isFocus = computed<Boolean>(fun(): Boolean {
                if (props.disabled) {
                    return false
                }
                if (inputRef.value == null) {
                    return false
                }
                return (inputRef.value as ClInputComponentPublicInstance).isFocus
            }
            )
            val list = computed<UTSArray<String>>(fun(): UTSArray<String> {
                val arr = _uA<String>()
                run {
                    var i: Number = 0
                    while(i < props.length){
                        arr.push(value.value.charAt(i))
                        i++
                    }
                }
                return arr
            }
            )
            watch(computed(fun(): String {
                return props.modelValue
            }
            ), fun(kVal: String){
                value.value = kVal
            }
            )
            fun gen_onInput_fn(kVal: String) {
                emit("update:modelValue", kVal)
                if (kVal.length == props.length) {
                    uni_hideKeyboard(null)
                    emit("done", kVal)
                }
            }
            val onInput = ::gen_onInput_fn
            val cursorOpacity = ref(0.3)
            var cursorAnimationId: Number = 0
            fun gen_animateCursor_fn(isIncreasing: Boolean) {
                if (!isFocus.value) {
                    return
                }
                if (cursorAnimationId != 0) {
                    cancelAnimationFrame(cursorAnimationId)
                    cursorAnimationId = 0
                }
                cursorAnimationId = requestAnimationFrame(fun(_task){
                    cursorOpacity.value += if (isIncreasing) {
                        0.01
                    } else {
                        -0.01
                    }
                    if (cursorOpacity.value > 1) {
                        gen_animateCursor_fn(false)
                    } else if (cursorOpacity.value <= 0.3) {
                        gen_animateCursor_fn(true)
                    } else {
                        gen_animateCursor_fn(isIncreasing)
                    }
                }
                )
            }
            val animateCursor = ::gen_animateCursor_fn
            return fun(): Any? {
                val _component_cl_input = resolveEasyComponent("cl-input", GenUniModulesCoolUiComponentsClInputClInputClass)
                val _component_cl_text = resolveEasyComponent("cl-text", GenUniModulesCoolUiComponentsClTextClTextClass)
                return _cE("view", _uM("class" to _nC(_uA(
                    "cl-input-otp",
                    _uA(
                        _uM<String, Any?>(),
                        _uM("cl-input-otp--disabled" to _ctx.disabled),
                        pt.value.className
                    )
                ))), _uA(
                    _cE("view", _uM("class" to "cl-input-otp__inner"), _uA(
                        _cV(_component_cl_input, _uM("modelValue" to value.value, "onUpdate:modelValue" to fun(`$event`: String){
                            value.value = `$event`
                        }
                        , "ref_key" to "inputRef", "ref" to inputRef, "type" to _ctx.inputType, "pt" to object : UTSJSONObject() {
                            var className = "-important-h-full"
                        }, "disabled" to _ctx.disabled, "autofocus" to _ctx.autofocus, "maxlength" to _ctx.length, "hold-keyboard" to false, "clearable" to false, "onInput" to onInput, "onFocus" to fun(){
                            animateCursor(true)
                        }
                        , "onBlur" to fun(){
                            animateCursor(true)
                        }
                        ), null, 8, _uA(
                            "modelValue",
                            "onUpdate:modelValue",
                            "type",
                            "disabled",
                            "autofocus",
                            "maxlength",
                            "onFocus",
                            "onBlur"
                        ))
                    )),
                    _cE("view", _uM("class" to _nC(_uA(
                        "cl-input-otp__list",
                        _uA(
                            _uM<String, Any?>(),
                            pt.value.list?.className
                        )
                    ))), _uA(
                        _cE(Fragment, null, RenderHelpers.renderList(list.value, fun(item, index, __index, _cached): Any {
                            return _cE("view", _uM("key" to index, "class" to _nC(_uA(
                                "cl-input-otp__item",
                                _uA(
                                    _uM<String, Any?>(),
                                    _uM("is-disabled" to _ctx.disabled, "is-dark" to unref(isDark), "is-active" to (value.value.length == index && isFocus.value)),
                                    pt.value.item?.className
                                )
                            ))), _uA(
                                _cV(_component_cl_text, _uM("pt" to object : UTSJSONObject() {
                                    var className = pt.value.value?.className
                                }), _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                                    return _uA(
                                        _tD(item)
                                    )
                                }
                                ), "_" to 2), 1032, _uA(
                                    "pt"
                                )),
                                if (isTrue(value.value.length == index && isFocus.value && item == "")) {
                                    _cE("view", _uM("key" to 0, "class" to _nC(_uA(
                                        "cl-input-otp__cursor",
                                        _uA(
                                            _uM<String, Any?>(),
                                            pt.value.cursor?.className
                                        )
                                    )), "style" to _nS(_uM("opacity" to cursorOpacity.value))), null, 6)
                                } else {
                                    _cC("v-if", true)
                                }
                            ), 2)
                        }
                        ), 128)
                    ), 2)
                ), 2)
            }
        }
        var name = "cl-input-otp"
        val styles: Map<String, Map<String, Map<String, Any>>> by lazy {
            _nCS(_uA(
                styles0
            ))
        }
        val styles0: Map<String, Map<String, Map<String, Any>>>
            get() {
                return _uM("cl-input-otp" to _pS(_uM("position" to "relative")), "cl-input-otp__inner" to _pS(_uM("position" to "absolute", "top" to 0, "zIndex" to 10, "height" to "100%", "opacity" to 0, "left" to "-100%", "width" to "200%")), "cl-input-otp__list" to _pS(_uM("position" to "relative", "display" to "flex", "flexDirection" to "row", "marginTop" to 0, "marginRight" to "-10rpx", "marginBottom" to 0, "marginLeft" to "-10rpx")), "cl-input-otp__item" to _uM("" to _uM("display" to "flex", "flexDirection" to "row", "alignItems" to "center", "justifyContent" to "center", "borderTopLeftRadius" to "14rpx", "borderTopRightRadius" to "14rpx", "borderBottomRightRadius" to "14rpx", "borderBottomLeftRadius" to "14rpx", "borderTopWidth" to 1, "borderRightWidth" to 1, "borderBottomWidth" to 1, "borderLeftWidth" to 1, "borderTopStyle" to "solid", "borderRightStyle" to "solid", "borderBottomStyle" to "solid", "borderLeftStyle" to "solid", "borderTopColor" to "rgba(228,228,231,1)", "borderRightColor" to "rgba(228,228,231,1)", "borderBottomColor" to "rgba(228,228,231,1)", "borderLeftColor" to "rgba(228,228,231,1)", "backgroundColor" to "rgba(255,255,255,1)", "height" to "80rpx", "width" to "80rpx", "marginTop" to 0, "marginRight" to "10rpx", "marginBottom" to 0, "marginLeft" to "10rpx"), ".is-disabled" to _uM("backgroundColor" to "rgba(244,244,245,1)", "opacity" to 0.7), ".is-dark" to _uM("borderTopColor" to "rgba(82,82,91,1)", "borderRightColor" to "rgba(82,82,91,1)", "borderBottomColor" to "rgba(82,82,91,1)", "borderLeftColor" to "rgba(82,82,91,1)", "backgroundColor" to "rgba(39,39,42,1)"), ".is-dark.is-disabled" to _uM("backgroundColor" to "rgba(63,63,70,1)"), ".is-active" to _uM("borderTopColor" to "rgba(20,184,166,1)", "borderRightColor" to "rgba(20,184,166,1)", "borderBottomColor" to "rgba(20,184,166,1)", "borderLeftColor" to "rgba(20,184,166,1)")), "cl-input-otp__cursor" to _pS(_uM("position" to "absolute", "backgroundColor" to "rgba(20,184,166,1)", "width" to "2rpx", "height" to "36rpx")), "cl-input-otp--disabled" to _pS(_uM("opacity" to 0.5)))
            }
        var inheritAttrs = true
        var inject: Map<String, Map<String, Any?>> = _uM()
        var emits: Map<String, Any?> = _uM("update:modelValue" to null, "done" to null)
        var props = _nP(_uM("pt" to _uM("default" to fun(): UTSJSONObject {
            return (UTSJSONObject())
        }
        ), "modelValue" to _uM("type" to "String", "default" to ""), "autofocus" to _uM("type" to "Boolean", "default" to false), "length" to _uM("type" to "Number", "default" to 4), "disabled" to _uM("type" to "Boolean", "default" to false), "inputType" to _uM("type" to "String", "default" to "number")))
        var propsNeedCastKeys = _uA(
            "pt",
            "modelValue",
            "autofocus",
            "length",
            "disabled",
            "inputType"
        )
        var components: Map<String, CreateVueComponent> = _uM()
    }
}
