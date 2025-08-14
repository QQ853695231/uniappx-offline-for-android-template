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
open class GenPagesDemoFormInput : BasePage {
    constructor(__ins: ComponentInternalInstance, __renderer: String?) : super(__ins, __renderer) {
        onPageScroll(fun(e: OnPageScrollOptions) {
            scroller.emit(e.scrollTop)
        }
        , __ins)
        onPageShow(fun() {}, __ins)
    }
    companion object {
        @Suppress("UNUSED_PARAMETER", "UNUSED_VARIABLE")
        var setup: (__props: GenPagesDemoFormInput) -> Any? = fun(__props): Any? {
            val __ins = getCurrentInstance()!!
            val _ctx = __ins.proxy as GenPagesDemoFormInput
            val _cache = __ins.renderCache
            val ui = useUi()
            val content = ref("Cool Unix")
            val isBorder = ref(true)
            val isLeftIcon = ref(true)
            val isRightIcon = ref(false)
            val isDisabled = ref(false)
            val isColor = ref(false)
            fun gen_toAlert_fn() {
                ui.showToast(ClToastOptions(message = "Hello"))
            }
            val toAlert = ::gen_toAlert_fn
            return fun(): Any? {
                val _component_cl_input = resolveEasyComponent("cl-input", GenUniModulesCoolUiComponentsClInputClInputClass)
                val _component_cl_button = resolveEasyComponent("cl-button", GenUniModulesCoolUiComponentsClButtonClButtonClass)
                val _component_cl_switch = resolveEasyComponent("cl-switch", GenUniModulesCoolUiComponentsClSwitchClSwitchClass)
                val _component_cl_list_item = resolveEasyComponent("cl-list-item", GenUniModulesCoolUiComponentsClListItemClListItemClass)
                val _component_cl_list = resolveEasyComponent("cl-list", GenUniModulesCoolUiComponentsClListClListClass)
                val _component_cl_page = resolveEasyComponent("cl-page", GenUniModulesCoolUiComponentsClPageClPageClass)
                return _cV(_component_cl_page, null, _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                    return _uA(
                        _cE("view", _uM("class" to "p-3"), _uA(
                            _cV(unref(GenPagesDemoComponentsItemClass), _uM("label" to unref(t)("基础用法")), _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                                return _uA(
                                    _cV(_component_cl_input)
                                )
                            }
                            ), "_" to 1), 8, _uA(
                                "label"
                            )),
                            _cV(unref(GenPagesDemoComponentsItemClass), _uM("label" to unref(t)("数字输入")), _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                                return _uA(
                                    _cV(_component_cl_input, _uM("type" to "number"))
                                )
                            }
                            ), "_" to 1), 8, _uA(
                                "label"
                            )),
                            _cV(unref(GenPagesDemoComponentsItemClass), _uM("label" to unref(t)("密码输入")), _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                                return _uA(
                                    _cV(_component_cl_input, _uM("password" to ""))
                                )
                            }
                            ), "_" to 1), 8, _uA(
                                "label"
                            )),
                            _cV(unref(GenPagesDemoComponentsItemClass), _uM("label" to unref(t)("可清除")), _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                                return _uA(
                                    _cV(_component_cl_input, _uM("clearable" to "", "pt" to object : UTSJSONObject() {
                                        var className = "mb-2"
                                    })),
                                    _cV(unref(GenPagesDemoComponentsTipsClass), null, _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                                        return _uA(
                                            "设置 hold-keyboard 属性后，清除内容时输入框将保持聚焦状态"
                                        )
                                    }
                                    ), "_" to 1)),
                                    _cV(_component_cl_input, _uM("clearable" to "", "hold-keyboard" to ""))
                                )
                            }
                            ), "_" to 1), 8, _uA(
                                "label"
                            )),
                            _cV(unref(GenPagesDemoComponentsItemClass), _uM("label" to unref(t)("左右插槽")), _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                                return _uA(
                                    _cV(_component_cl_input, _uM("pt" to object : UTSJSONObject() {
                                        var className = "-important-pr-1 mb-2"
                                    }), _uM("append" to withSlotCtx(fun(): UTSArray<Any> {
                                        return _uA(
                                            _cV(_component_cl_button, _uM("type" to "primary", "size" to "small", "icon" to "send-plane-fill", "pt" to object : UTSJSONObject() {
                                                var className = "ml-2"
                                            }, "onClick" to toAlert))
                                        )
                                    }
                                    ), "_" to 1)),
                                    _cV(_component_cl_input, _uM("pt" to object : UTSJSONObject() {
                                        var className = "-important-pl-1"
                                    }), _uM("prepend" to withSlotCtx(fun(): UTSArray<Any> {
                                        return _uA(
                                            _cV(_component_cl_button, _uM("type" to "primary", "size" to "small", "icon" to "search-line", "pt" to object : UTSJSONObject() {
                                                var className = "mr-2"
                                            }, "onClick" to toAlert))
                                        )
                                    }
                                    ), "_" to 1))
                                )
                            }
                            ), "_" to 1), 8, _uA(
                                "label"
                            )),
                            _cV(unref(GenPagesDemoComponentsItemClass), _uM("label" to unref(t)("自定义")), _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                                return _uA(
                                    _cE("view", _uM("class" to "mb-3"), _uA(
                                        _cV(_component_cl_input, _uM("modelValue" to content.value, "onUpdate:modelValue" to fun(`$event`: String){
                                            content.value = `$event`
                                        }
                                        , "border" to isBorder.value, "suffix-icon" to if (isRightIcon.value) {
                                            "text"
                                        } else {
                                            ""
                                        }
                                        , "prefix-icon" to if (isLeftIcon.value) {
                                            "search-line"
                                        } else {
                                            ""
                                        }
                                        , "disabled" to isDisabled.value, "pt" to object : UTSJSONObject() {
                                            var className = unref(parseClass)(object : UTSJSONObject() {
                                                var `-important-bg-sky-100` = isColor.value
                                                var `-important-border-sky-700` = isColor.value
                                            })
                                            var inner = object : UTSJSONObject() {
                                                var className = unref(parseClass)(object : UTSJSONObject() {
                                                    var `-important-text-sky-700` = isColor.value
                                                })
                                            }
                                            var prefixIcon = object : UTSJSONObject() {
                                                var className = unref(parseClass)(object : UTSJSONObject() {
                                                    var `-important-text-sky-700` = isColor.value
                                                })
                                            }
                                        }), null, 8, _uA(
                                            "modelValue",
                                            "onUpdate:modelValue",
                                            "border",
                                            "suffix-icon",
                                            "prefix-icon",
                                            "disabled",
                                            "pt"
                                        ))
                                    )),
                                    _cV(_component_cl_list, _uM("border" to ""), _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                                        return _uA(
                                            _cV(_component_cl_list_item, _uM("label" to unref(t)("边框")), _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                                                return _uA(
                                                    _cV(_component_cl_switch, _uM("modelValue" to isBorder.value, "onUpdate:modelValue" to fun(`$event`: Boolean){
                                                        isBorder.value = `$event`
                                                    }
                                                    ), null, 8, _uA(
                                                        "modelValue",
                                                        "onUpdate:modelValue"
                                                    ))
                                                )
                                            }
                                            ), "_" to 1), 8, _uA(
                                                "label"
                                            )),
                                            _cV(_component_cl_list_item, _uM("label" to unref(t)("左图标")), _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                                                return _uA(
                                                    _cV(_component_cl_switch, _uM("modelValue" to isLeftIcon.value, "onUpdate:modelValue" to fun(`$event`: Boolean){
                                                        isLeftIcon.value = `$event`
                                                    }
                                                    ), null, 8, _uA(
                                                        "modelValue",
                                                        "onUpdate:modelValue"
                                                    ))
                                                )
                                            }
                                            ), "_" to 1), 8, _uA(
                                                "label"
                                            )),
                                            _cV(_component_cl_list_item, _uM("label" to unref(t)("右图标")), _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                                                return _uA(
                                                    _cV(_component_cl_switch, _uM("modelValue" to isRightIcon.value, "onUpdate:modelValue" to fun(`$event`: Boolean){
                                                        isRightIcon.value = `$event`
                                                    }
                                                    ), null, 8, _uA(
                                                        "modelValue",
                                                        "onUpdate:modelValue"
                                                    ))
                                                )
                                            }
                                            ), "_" to 1), 8, _uA(
                                                "label"
                                            )),
                                            _cV(_component_cl_list_item, _uM("label" to unref(t)("禁用")), _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                                                return _uA(
                                                    _cV(_component_cl_switch, _uM("modelValue" to isDisabled.value, "onUpdate:modelValue" to fun(`$event`: Boolean){
                                                        isDisabled.value = `$event`
                                                    }
                                                    ), null, 8, _uA(
                                                        "modelValue",
                                                        "onUpdate:modelValue"
                                                    ))
                                                )
                                            }
                                            ), "_" to 1), 8, _uA(
                                                "label"
                                            )),
                                            _cV(_component_cl_list_item, _uM("label" to unref(t)("其他颜色")), _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                                                return _uA(
                                                    _cV(_component_cl_switch, _uM("modelValue" to isColor.value, "onUpdate:modelValue" to fun(`$event`: Boolean){
                                                        isColor.value = `$event`
                                                    }
                                                    ), null, 8, _uA(
                                                        "modelValue",
                                                        "onUpdate:modelValue"
                                                    ))
                                                )
                                            }
                                            ), "_" to 1), 8, _uA(
                                                "label"
                                            ))
                                        )
                                    }
                                    ), "_" to 1))
                                )
                            }
                            ), "_" to 1), 8, _uA(
                                "label"
                            ))
                        ))
                    )
                }
                ), "_" to 1))
            }
        }
        val styles: Map<String, Map<String, Map<String, Any>>> by lazy {
            _nCS(_uA(), _uA(
                GenApp.styles
            ))
        }
        var inheritAttrs = true
        var inject: Map<String, Map<String, Any?>> = _uM()
        var emits: Map<String, Any?> = _uM()
        var props = _nP(_uM())
        var propsNeedCastKeys: UTSArray<String> = _uA()
        var components: Map<String, CreateVueComponent> = _uM()
    }
}
