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
open class GenPagesDemoFormSlider : BasePage {
    constructor(__ins: ComponentInternalInstance, __renderer: String?) : super(__ins, __renderer) {
        onPageScroll(fun(e: OnPageScrollOptions) {
            scroller.emit(e.scrollTop)
        }
        , __ins)
        onPageShow(fun() {}, __ins)
    }
    companion object {
        @Suppress("UNUSED_PARAMETER", "UNUSED_VARIABLE")
        var setup: (__props: GenPagesDemoFormSlider) -> Any? = fun(__props): Any? {
            val __ins = getCurrentInstance()!!
            val _ctx = __ins.proxy as GenPagesDemoFormSlider
            val _cache = __ins.renderCache
            val num = ref(60)
            val num2 = ref(_uA<Number>(10, 20))
            val num3 = ref(35)
            val isDisabled = ref(false)
            val isShowValue = ref(true)
            val isStep = ref(false)
            val isSize = ref(false)
            val isMax = ref(false)
            val isColor = ref(false)
            return fun(): Any? {
                val _component_cl_slider = resolveEasyComponent("cl-slider", GenUniModulesCoolUiComponentsClSliderClSliderClass)
                val _component_cl_text = resolveEasyComponent("cl-text", GenUniModulesCoolUiComponentsClTextClTextClass)
                val _component_cl_switch = resolveEasyComponent("cl-switch", GenUniModulesCoolUiComponentsClSwitchClSwitchClass)
                val _component_cl_list_item = resolveEasyComponent("cl-list-item", GenUniModulesCoolUiComponentsClListItemClListItemClass)
                val _component_cl_list = resolveEasyComponent("cl-list", GenUniModulesCoolUiComponentsClListClListClass)
                val _component_cl_page = resolveEasyComponent("cl-page", GenUniModulesCoolUiComponentsClPageClPageClass)
                return _cV(_component_cl_page, null, _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                    return _uA(
                        _cE("view", _uM("class" to "p-3"), _uA(
                            _cV(unref(GenPagesDemoComponentsItemClass), _uM("label" to unref(t)("基础用法")), _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                                return _uA(
                                    _cV(_component_cl_slider, _uM("modelValue" to num.value, "onUpdate:modelValue" to fun(`$event`: Number){
                                        num.value = `$event`
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
                            _cV(unref(GenPagesDemoComponentsItemClass), _uM("label" to unref(t)("范围选择")), _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                                return _uA(
                                    _cV(_component_cl_text, _uM("pt" to object : UTSJSONObject() {
                                        var className = "mb-3"
                                    }), _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                                        return _uA(
                                            _tD(num2.value[0]) + " ～ " + _tD(num2.value[1])
                                        )
                                    }
                                    ), "_" to 1)),
                                    _cV(_component_cl_slider, _uM("values" to num2.value, "onUpdate:values" to fun(`$event`: UTSArray<Number>){
                                        num2.value = `$event`
                                    }
                                    , "range" to ""), null, 8, _uA(
                                        "values",
                                        "onUpdate:values"
                                    ))
                                )
                            }
                            ), "_" to 1), 8, _uA(
                                "label"
                            )),
                            _cV(unref(GenPagesDemoComponentsItemClass), _uM("label" to unref(t)("自定义")), _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                                return _uA(
                                    _cV(_component_cl_slider, _uM("modelValue" to num3.value, "onUpdate:modelValue" to fun(`$event`: Number){
                                        num3.value = `$event`
                                    }
                                    , "disabled" to isDisabled.value, "show-value" to isShowValue.value, "block-size" to if (isSize.value) {
                                        50
                                    } else {
                                        40
                                    }
                                    , "track-height" to if (isSize.value) {
                                        12
                                    } else {
                                        8
                                    }
                                    , "step" to if (isStep.value) {
                                        10
                                    } else {
                                        1
                                    }
                                    , "max" to if (isMax.value) {
                                        50
                                    } else {
                                        100
                                    }
                                    , "pt" to object : UTSJSONObject() {
                                        var thumb = object : UTSJSONObject() {
                                            var className = if (isColor.value) {
                                                "-important-bg-red-500"
                                            } else {
                                                ""
                                            }
                                        }
                                        var progress = object : UTSJSONObject() {
                                            var className = if (isColor.value) {
                                                "-important-bg-red-200"
                                            } else {
                                                ""
                                            }
                                        }
                                    }), null, 8, _uA(
                                        "modelValue",
                                        "onUpdate:modelValue",
                                        "disabled",
                                        "show-value",
                                        "block-size",
                                        "track-height",
                                        "step",
                                        "max",
                                        "pt"
                                    )),
                                    _cV(_component_cl_list, _uM("border" to "", "pt" to object : UTSJSONObject() {
                                        var className = "mt-3"
                                    }), _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                                        return _uA(
                                            _cV(_component_cl_list_item, _uM("label" to unref(t)("显示值")), _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                                                return _uA(
                                                    _cV(_component_cl_switch, _uM("modelValue" to isShowValue.value, "onUpdate:modelValue" to fun(`$event`: Boolean){
                                                        isShowValue.value = `$event`
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
                                            _cV(_component_cl_list_item, _uM("label" to unref(t)("步长10")), _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                                                return _uA(
                                                    _cV(_component_cl_switch, _uM("modelValue" to isStep.value, "onUpdate:modelValue" to fun(`$event`: Boolean){
                                                        isStep.value = `$event`
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
                                            _cV(_component_cl_list_item, _uM("label" to unref(t)("滑块大点")), _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                                                return _uA(
                                                    _cV(_component_cl_switch, _uM("modelValue" to isSize.value, "onUpdate:modelValue" to fun(`$event`: Boolean){
                                                        isSize.value = `$event`
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
                                            _cV(_component_cl_list_item, _uM("label" to unref(t)("换个颜色")), _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
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
                                            )),
                                            _cV(_component_cl_list_item, _uM("label" to unref(t)("最大50")), _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                                                return _uA(
                                                    _cV(_component_cl_switch, _uM("modelValue" to isMax.value, "onUpdate:modelValue" to fun(`$event`: Boolean){
                                                        isMax.value = `$event`
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
