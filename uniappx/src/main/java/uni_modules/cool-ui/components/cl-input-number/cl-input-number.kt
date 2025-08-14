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
open class GenUniModulesCoolUiComponentsClInputNumberClInputNumber : VueComponent {
    constructor(__ins: ComponentInternalInstance) : super(__ins) {}
    open var modelValue: Number by `$props`
    open var pt: Any by `$props`
    open var placeholder: String by `$props`
    open var step: Number by `$props`
    open var max: Number by `$props`
    open var min: Number by `$props`
    open var inputType: String by `$props`
    open var inputable: Boolean by `$props`
    open var disabled: Boolean by `$props`
    open var size: Any? by `$props`
    companion object {
        @Suppress("UNUSED_PARAMETER", "UNUSED_VARIABLE")
        var setup: (__props: GenUniModulesCoolUiComponentsClInputNumberClInputNumber) -> Any? = fun(__props): Any? {
            val __ins = getCurrentInstance()!!
            val _ctx = __ins.proxy as GenUniModulesCoolUiComponentsClInputNumberClInputNumber
            val _cache = __ins.renderCache
            val props = __props
            fun emit(event: String, vararg do_not_transform_spread: Any?) {
                __ins.emit(event, *do_not_transform_spread)
            }
            val longPress = useLongPress()
            val disabled = useForm().disabled
            val isDisabled = computed(fun(): Boolean {
                return disabled.value || props.disabled
            }
            )
            val pt = computed(fun(): PassThrough34 {
                return parsePt<PassThrough34>(props.pt)
            }
            )
            val value = ref(props.modelValue)
            val isPlus = computed(fun(): Boolean {
                return !isDisabled.value && value.value < props.max
            }
            )
            val isMinus = computed(fun(): Boolean {
                return !isDisabled.value && value.value > props.min
            }
            )
            fun gen_update_fn() {
                nextTick(fun(){
                    var kVal = value.value
                    if (kVal < props.min) {
                        kVal = props.min
                    }
                    if (kVal > props.max) {
                        kVal = props.max
                    }
                    if (props.min > props.max) {
                        kVal = props.max
                    }
                    if (props.inputType == "digit") {
                        kVal = parseFloat(kVal.toFixed(2))
                    }
                    if (kVal != value.value) {
                        value.value = kVal
                    }
                    emit("update:modelValue", kVal)
                    emit("change", kVal)
                }
                )
            }
            val update = ::gen_update_fn
            fun gen_onPlus_fn() {
                if (isDisabled.value || !isPlus.value) {
                    return
                }
                longPress.start(fun(){
                    if (isPlus.value) {
                        val kVal = props.max - value.value
                        value.value += if (kVal > props.step) {
                            props.step
                        } else {
                            kVal
                        }
                        update()
                    }
                }
                )
            }
            val onPlus = ::gen_onPlus_fn
            fun gen_onMinus_fn() {
                if (isDisabled.value || !isMinus.value) {
                    return
                }
                longPress.start(fun(){
                    if (isMinus.value) {
                        val kVal = value.value - props.min
                        value.value -= if (kVal > props.step) {
                            props.step
                        } else {
                            kVal
                        }
                        update()
                    }
                }
                )
            }
            val onMinus = ::gen_onMinus_fn
            fun gen_onInput_fn(kVal: String) {
                if (kVal == "") {
                    value.value = 0
                } else {
                    value.value = parseFloat(kVal)
                }
                update()
            }
            val onInput = ::gen_onInput_fn
            watch(computed(fun(): Number {
                return props.modelValue
            }
            ), fun(kVal: Number){
                value.value = kVal
                update()
            }
            , WatchOptions(immediate = true))
            watch(computed(fun(): Number {
                return props.max
            }
            ), update)
            watch(computed(fun(): Number {
                return props.min
            }
            ), update)
            return fun(): Any? {
                val _component_cl_icon = resolveEasyComponent("cl-icon", GenUniModulesCoolUiComponentsClIconClIconClass)
                val _component_cl_input = resolveEasyComponent("cl-input", GenUniModulesCoolUiComponentsClInputClInputClass)
                return _cE("view", _uM("class" to _nC(_uA(
                    "cl-input-number",
                    _uA(
                        _uM<String, Any?>(),
                        _uM("cl-input-number--disabled" to isDisabled.value),
                        pt.value.className
                    )
                ))), _uA(
                    _cE("view", _uM("class" to _nC(_uA(
                        "cl-input-number__minus",
                        _uA(
                            _uM<String, Any?>(),
                            _uM("is-disabled" to !isMinus.value),
                            pt.value.op?.className,
                            pt.value.op?.minus?.className
                        )
                    )), "hover-class" to "-important-bg-surface-200", "hover-stay-time" to 50, "style" to _nS(_uM("height" to unref(parseRpx)(_ctx.size!!), "width" to unref(parseRpx)(_ctx.size!!))), "onTouchstart" to onMinus, "onTouchend" to unref(longPress).stop, "onTouchcancel" to unref(longPress).stop), _uA(
                        _cV(_component_cl_icon, _uM("name" to "subtract-line", "size" to (pt.value.op?.icon?.size ?: 36), "color" to (pt.value.op?.icon?.color ?: "info"), "pt" to object : UTSJSONObject() {
                            var className = pt.value.op?.icon?.className
                        }), null, 8, _uA(
                            "size",
                            "color",
                            "pt"
                        ))
                    ), 46, _uA(
                        "onTouchend",
                        "onTouchcancel"
                    )),
                    _cE("view", _uM("class" to "cl-input-number__value"), _uA(
                        _cV(_component_cl_input, _uM("model-value" to ("" + value.value), "type" to _ctx.inputType, "disabled" to isDisabled.value, "clearable" to false, "readonly" to (_ctx.inputable == false), "placeholder" to _ctx.placeholder, "hold-keyboard" to false, "pt" to object : UTSJSONObject() {
                            var className = "-important-h-full w--bracket-start-120rpx-bracket-end- " + pt.value.value?.className
                            var inner = object : UTSJSONObject() {
                                var className = "text-center " + pt.value.value?.input?.className
                            }
                        }, "onChange" to onInput), null, 8, _uA(
                            "model-value",
                            "type",
                            "disabled",
                            "readonly",
                            "placeholder",
                            "pt"
                        ))
                    )),
                    _cE("view", _uM("class" to _nC(_uA(
                        "cl-input-number__plus",
                        _uA(
                            _uM<String, Any?>(),
                            _uM("is-disabled" to !isPlus.value),
                            pt.value.op?.className,
                            pt.value.op?.plus?.className
                        )
                    )), "hover-class" to "-important-bg-primary-600", "hover-stay-time" to 50, "style" to _nS(_uM("height" to unref(parseRpx)(_ctx.size!!), "width" to unref(parseRpx)(_ctx.size!!))), "onTouchstart" to onPlus, "onTouchend" to unref(longPress).stop, "onTouchcancel" to unref(longPress).stop), _uA(
                        _cV(_component_cl_icon, _uM("name" to "add-line", "size" to (pt.value.op?.icon?.size ?: 36), "color" to (pt.value.op?.icon?.color ?: "white"), "pt" to object : UTSJSONObject() {
                            var className = pt.value.op?.icon?.className
                        }), null, 8, _uA(
                            "size",
                            "color",
                            "pt"
                        ))
                    ), 46, _uA(
                        "onTouchend",
                        "onTouchcancel"
                    ))
                ), 2)
            }
        }
        var name = "cl-input-number"
        val styles: Map<String, Map<String, Map<String, Any>>> by lazy {
            _nCS(_uA(
                styles0
            ))
        }
        val styles0: Map<String, Map<String, Map<String, Any>>>
            get() {
                return _uM("cl-input-number" to _pS(_uM("display" to "flex", "flexDirection" to "row", "alignItems" to "center")), "cl-input-number__plus" to _uM("" to _uM("display" to "flex", "alignItems" to "center", "justifyContent" to "center", "borderTopLeftRadius" to "10.5rpx", "borderTopRightRadius" to "10.5rpx", "borderBottomRightRadius" to "10.5rpx", "borderBottomLeftRadius" to "10.5rpx", "backgroundColor" to "rgba(20,184,166,1)"), ".is-disabled" to _uM("opacity" to 0.5)), "cl-input-number__minus" to _uM("" to _uM("display" to "flex", "alignItems" to "center", "justifyContent" to "center", "borderTopLeftRadius" to "10.5rpx", "borderTopRightRadius" to "10.5rpx", "borderBottomRightRadius" to "10.5rpx", "borderBottomLeftRadius" to "10.5rpx", "backgroundColor" to "rgba(244,244,245,1)"), ".is-disabled" to _uM("opacity" to 0.5)), "cl-input-number__value" to _pS(_uM("display" to "flex", "height" to "100%", "flexDirection" to "row", "alignItems" to "center", "justifyContent" to "center", "marginTop" to 0, "marginRight" to "12rpx", "marginBottom" to 0, "marginLeft" to "12rpx")))
            }
        var inheritAttrs = true
        var inject: Map<String, Map<String, Any?>> = _uM()
        var emits: Map<String, Any?> = _uM("update:modelValue" to null, "change" to null)
        var props = _nP(_uM("modelValue" to _uM("type" to "Number", "default" to 0), "pt" to _uM("default" to fun(): UTSJSONObject {
            return (UTSJSONObject())
        }
        ), "placeholder" to _uM("type" to "String", "default" to ""), "step" to _uM("type" to "Number", "default" to 1), "max" to _uM("type" to "Number", "default" to 100), "min" to _uM("type" to "Number", "default" to 0), "inputType" to _uM("type" to "String", "default" to "number"), "inputable" to _uM("type" to "Boolean", "default" to true), "disabled" to _uM("type" to "Boolean", "default" to false), "size" to _uM("default" to 50)))
        var propsNeedCastKeys = _uA(
            "modelValue",
            "pt",
            "placeholder",
            "step",
            "max",
            "min",
            "inputType",
            "inputable",
            "disabled",
            "size"
        )
        var components: Map<String, CreateVueComponent> = _uM()
    }
}
