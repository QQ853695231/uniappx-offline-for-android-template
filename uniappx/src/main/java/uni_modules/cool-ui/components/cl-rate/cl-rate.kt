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
open class GenUniModulesCoolUiComponentsClRateClRate : VueComponent {
    constructor(__ins: ComponentInternalInstance) : super(__ins) {}
    open var pt: Any by `$props`
    open var modelValue: Number by `$props`
    open var max: Number by `$props`
    open var disabled: Boolean by `$props`
    open var allowHalf: Boolean by `$props`
    open var showScore: Boolean by `$props`
    open var size: Number by `$props`
    open var icon: String by `$props`
    open var voidIcon: String by `$props`
    open var color: String by `$props`
    open var voidColor: String by `$props`
    companion object {
        @Suppress("UNUSED_PARAMETER", "UNUSED_VARIABLE")
        var setup: (__props: GenUniModulesCoolUiComponentsClRateClRate) -> Any? = fun(__props): Any? {
            val __ins = getCurrentInstance()!!
            val _ctx = __ins.proxy as GenUniModulesCoolUiComponentsClRateClRate
            val _cache = __ins.renderCache
            val props = __props
            fun emit(event: String, vararg do_not_transform_spread: Any?) {
                __ins.emit(event, *do_not_transform_spread)
            }
            val pt = computed(fun(): PassThrough40 {
                return parsePt<PassThrough40>(props.pt)
            }
            )
            val disabled = useForm().disabled
            val isDisabled = computed(fun(): Boolean {
                return props.disabled || disabled.value
            }
            )
            fun gen_getIconActiveWidth_fn(item: Number): Number {
                if (props.modelValue >= item) {
                    return props.size
                }
                if (Math.floor(props.modelValue) < item - 1) {
                    return 0
                }
                return Math.floor((props.modelValue % 1) * props.size)
            }
            val getIconActiveWidth = ::gen_getIconActiveWidth_fn
            fun gen_onTap_fn(index: Number) {
                if (isDisabled.value) {
                    return
                }
                var value: Number
                if (props.allowHalf) {
                    val currentValue = index + 1
                    if (props.modelValue == currentValue) {
                        value = index + 0.5
                    } else if (props.modelValue == index + 0.5) {
                        value = index
                    } else {
                        value = currentValue
                    }
                } else {
                    value = index + 1
                }
                value = Math.max(0, Math.min(value, props.max))
                emit("update:modelValue", value)
                emit("change", value)
            }
            val onTap = ::gen_onTap_fn
            return fun(): Any? {
                val _component_cl_icon = resolveEasyComponent("cl-icon", GenUniModulesCoolUiComponentsClIconClIconClass)
                val _component_cl_text = resolveEasyComponent("cl-text", GenUniModulesCoolUiComponentsClTextClTextClass)
                return _cE("view", _uM("class" to _nC(_uA(
                    "cl-rate",
                    _uA(
                        _uM<String, Any?>(),
                        _uM("cl-rate--disabled" to isDisabled.value),
                        pt.value.className
                    )
                ))), _uA(
                    _cE(Fragment, null, RenderHelpers.renderList(_ctx.max, fun(item, index, __index, _cached): Any {
                        return _cE("view", _uM("key" to index, "class" to _nC(_uA(
                            "cl-rate__item",
                            _uA(
                                _uM<String, Any?>(),
                                _uM("cl-rate__item--active" to (item <= _ctx.modelValue)),
                                pt.value.item?.className
                            )
                        )), "onTouchstart" to fun(){
                            onTap(index)
                        }
                        ), _uA(
                            _cV(_component_cl_icon, _uM("name" to _ctx.voidIcon, "color" to _ctx.voidColor, "size" to _ctx.size, "pt" to object : UTSJSONObject() {
                                var className = "" + pt.value.icon?.className
                            }), null, 8, _uA(
                                "name",
                                "color",
                                "size",
                                "pt"
                            )),
                            if (getIconActiveWidth(item) > 0) {
                                _cV(_component_cl_icon, _uM("key" to 0, "name" to _ctx.icon, "color" to _ctx.color, "size" to _ctx.size, "width" to getIconActiveWidth(item), "pt" to object : UTSJSONObject() {
                                    var className = "absolute left-0 " + pt.value.icon?.className
                                }), null, 8, _uA(
                                    "name",
                                    "color",
                                    "size",
                                    "width",
                                    "pt"
                                ))
                            } else {
                                _cC("v-if", true)
                            }
                        ), 42, _uA(
                            "onTouchstart"
                        ))
                    }
                    ), 128),
                    if (isTrue(_ctx.showScore)) {
                        _cV(_component_cl_text, _uM("key" to 0, "pt" to object : UTSJSONObject() {
                            var className = unref(parseClass)(_uA(
                                "cl-rate__score ml-2 font-bold",
                                pt.value.score?.className
                            ))
                        }), _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                            return _uA(
                                _tD(_ctx.modelValue)
                            )
                        }), "_" to 1), 8, _uA(
                            "pt"
                        ))
                    } else {
                        _cC("v-if", true)
                    }
                ), 2)
            }
        }
        var name = "cl-rate"
        val styles: Map<String, Map<String, Map<String, Any>>> by lazy {
            _nCS(_uA(
                styles0
            ))
        }
        val styles0: Map<String, Map<String, Map<String, Any>>>
            get() {
                return _uM("cl-rate" to _pS(_uM("display" to "flex", "flexDirection" to "row", "alignItems" to "center")), "cl-rate--disabled" to _pS(_uM("opacity" to 0.5)), "cl-rate__item" to _pS(_uM("position" to "relative", "display" to "flex", "alignItems" to "center", "justifyContent" to "center", "overflow" to "hidden", "transitionDuration" to "200ms", "transitionProperty" to "color", "marginRight" to "6rpx")), "@TRANSITION" to _uM("cl-rate__item" to _uM("duration" to "200ms", "property" to "color")))
            }
        var inheritAttrs = true
        var inject: Map<String, Map<String, Any?>> = _uM()
        var emits: Map<String, Any?> = _uM("update:modelValue" to null, "change" to null)
        var props = _nP(_uM("pt" to _uM("default" to fun(): UTSJSONObject {
            return (UTSJSONObject())
        }
        ), "modelValue" to _uM("type" to "Number", "default" to 0), "max" to _uM("type" to "Number", "default" to 5), "disabled" to _uM("type" to "Boolean", "default" to false), "allowHalf" to _uM("type" to "Boolean", "default" to false), "showScore" to _uM("type" to "Boolean", "default" to false), "size" to _uM("type" to "Number", "default" to 40), "icon" to _uM("type" to "String", "default" to "star-fill"), "voidIcon" to _uM("type" to "String", "default" to "star-fill"), "color" to _uM("type" to "String", "default" to "primary"), "voidColor" to _uM("type" to "String", "default" to "#dddddd")))
        var propsNeedCastKeys = _uA(
            "pt",
            "modelValue",
            "max",
            "disabled",
            "allowHalf",
            "showScore",
            "size",
            "icon",
            "voidIcon",
            "color",
            "voidColor"
        )
        var components: Map<String, CreateVueComponent> = _uM()
    }
}
