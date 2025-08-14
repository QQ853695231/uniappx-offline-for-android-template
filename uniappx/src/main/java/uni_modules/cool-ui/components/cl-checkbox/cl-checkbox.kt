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
open class GenUniModulesCoolUiComponentsClCheckboxClCheckbox : VueComponent {
    constructor(__ins: ComponentInternalInstance) : super(__ins) {}
    open var pt: Any by `$props`
    open var modelValue: Any? by `$props`
    open var label: String by `$props`
    open var value: Any? by `$props`
    open var disabled: Boolean by `$props`
    open var activeIcon: String by `$props`
    open var inactiveIcon: String by `$props`
    open var showIcon: Boolean by `$props`
    companion object {
        @Suppress("UNUSED_PARAMETER", "UNUSED_VARIABLE")
        var setup: (__props: GenUniModulesCoolUiComponentsClCheckboxClCheckbox) -> Any? = fun(__props): Any? {
            val __ins = getCurrentInstance()!!
            val _ctx = __ins.proxy as GenUniModulesCoolUiComponentsClCheckboxClCheckbox
            val _cache = __ins.renderCache
            val props = __props
            fun emit(event: String, vararg do_not_transform_spread: Any?) {
                __ins.emit(event, *do_not_transform_spread)
            }
            val slots = useSlots()
            val disabled = useForm().disabled
            val isDisabled = computed(fun(): Boolean {
                return props.disabled || disabled.value
            }
            )
            val pt = computed(fun(): PassThrough29 {
                return parsePt<PassThrough29>(props.pt)
            }
            )
            val isChecked = computed(fun(): Boolean {
                if (UTSArray.isArray(props.modelValue)) {
                    return (props.modelValue as UTSArray<Any>).includes(props.value!!)
                }
                if (UTSAndroid.`typeof`(props.modelValue) == "boolean") {
                    return props.modelValue as Boolean
                }
                return false
            }
            )
            val showLabel = computed(fun(): Boolean {
                return props.label != "" || get(slots, "default") != null
            }
            )
            val iconName = computed(fun(): String {
                if (isChecked.value) {
                    return props.activeIcon
                }
                return props.inactiveIcon
            }
            )
            fun gen_onTap_fn() {
                if (!isDisabled.value) {
                    var kVal = props.modelValue
                    if (UTSArray.isArray(kVal)) {
                        if (isChecked.value) {
                            kVal = pull(kVal as UTSArray<Any>, props.value!!)
                        } else {
                            (kVal as UTSArray<Any>).push(props.value!!)
                        }
                    } else {
                        kVal = !(kVal as Boolean)
                    }
                    emit("update:modelValue", kVal)
                    emit("change", kVal)
                }
            }
            val onTap = ::gen_onTap_fn
            return fun(): Any? {
                val _component_cl_icon = resolveEasyComponent("cl-icon", GenUniModulesCoolUiComponentsClIconClIconClass)
                val _component_cl_text = resolveEasyComponent("cl-text", GenUniModulesCoolUiComponentsClTextClTextClass)
                return _cE("view", _uM("class" to _nC(_uA(
                    "cl-checkbox",
                    _uA(
                        _uM<String, Any?>(),
                        _uM("cl-checkbox--disabled" to isDisabled.value, "cl-checkbox--checked" to isChecked.value),
                        pt.value.className
                    )
                )), "onClick" to onTap), _uA(
                    if (isTrue(_ctx.showIcon)) {
                        _cV(_component_cl_icon, _uM("key" to 0, "name" to iconName.value, "size" to (pt.value.icon?.size ?: 40), "pt" to object : UTSJSONObject() {
                            var className = unref(parseClass)(_uA(
                                "cl-checkbox__icon mr-1",
                                object : UTSJSONObject() {
                                    var `-important-text-primary-500` = isChecked.value
                                },
                                pt.value.icon?.className
                            ))
                        }), null, 8, _uA(
                            "name",
                            "size",
                            "pt"
                        ))
                    } else {
                        _cC("v-if", true)
                    }
                    ,
                    if (isTrue(showLabel.value)) {
                        _cV(_component_cl_text, _uM("key" to 1, "pt" to object : UTSJSONObject() {
                            var className = unref(parseClass)(_uA(
                                "cl-checkbox__label",
                                object : UTSJSONObject() {
                                    var `-important-text-primary-500` = isChecked.value
                                },
                                pt.value.label?.className
                            ))
                        }), _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                            return _uA(
                                renderSlot(_ctx.`$slots`, "default", UTSJSONObject(), fun(): UTSArray<Any> {
                                    return _uA(
                                        _tD(_ctx.label)
                                    )
                                })
                            )
                        }), "_" to 3), 8, _uA(
                            "pt"
                        ))
                    } else {
                        _cC("v-if", true)
                    }
                ), 2)
            }
        }
        var name = "cl-checkbox"
        val styles: Map<String, Map<String, Map<String, Any>>> by lazy {
            _nCS(_uA(
                styles0
            ))
        }
        val styles0: Map<String, Map<String, Map<String, Any>>>
            get() {
                return _uM("cl-checkbox" to _pS(_uM("display" to "flex", "flexDirection" to "row", "alignItems" to "center")), "cl-checkbox--disabled" to _pS(_uM("opacity" to 0.5)))
            }
        var inheritAttrs = true
        var inject: Map<String, Map<String, Any?>> = _uM()
        var emits: Map<String, Any?> = _uM("update:modelValue" to null, "change" to null)
        var props = _nP(_uM("pt" to _uM("default" to fun(): UTSJSONObject {
            return (UTSJSONObject())
        }
        ), "modelValue" to _uM("default" to fun(): UTSArray<Any?> {
            return _uA()
        }
        ), "label" to _uM("type" to "String", "default" to ""), "value" to _uM(), "disabled" to _uM("type" to "Boolean", "default" to false), "activeIcon" to _uM("type" to "String", "default" to "checkbox-line"), "inactiveIcon" to _uM("type" to "String", "default" to "checkbox-blank-line"), "showIcon" to _uM("type" to "Boolean", "default" to true)))
        var propsNeedCastKeys = _uA(
            "pt",
            "modelValue",
            "label",
            "disabled",
            "activeIcon",
            "inactiveIcon",
            "showIcon"
        )
        var components: Map<String, CreateVueComponent> = _uM()
    }
}
