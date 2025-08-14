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
open class GenPagesDemoStatusRollingNumber : BasePage {
    constructor(__ins: ComponentInternalInstance, __renderer: String?) : super(__ins, __renderer) {
        onPageScroll(fun(e: OnPageScrollOptions) {
            scroller.emit(e.scrollTop)
        }
        , __ins)
        onPageShow(fun() {}, __ins)
    }
    companion object {
        @Suppress("UNUSED_PARAMETER", "UNUSED_VARIABLE")
        var setup: (__props: GenPagesDemoStatusRollingNumber) -> Any? = fun(__props): Any? {
            val __ins = getCurrentInstance()!!
            val _ctx = __ins.proxy as GenPagesDemoStatusRollingNumber
            val _cache = __ins.renderCache
            val value = ref(100)
            val isSpeed = ref(false)
            val isDecimals = ref(false)
            val isCustom = ref(false)
            fun gen_add_fn() {
                value.value += 100
            }
            val add = ::gen_add_fn
            fun gen_sub_fn() {
                value.value -= 100
            }
            val sub = ::gen_sub_fn
            return fun(): Any? {
                val _component_cl_rolling_number = resolveEasyComponent("cl-rolling-number", GenUniModulesCoolUiComponentsClRollingNumberClRollingNumberClass)
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
                                    _cV(_component_cl_rolling_number, _uM("value" to value.value), null, 8, _uA(
                                        "value"
                                    )),
                                    _cE("view", _uM("class" to "flex flex-row mt-2"), _uA(
                                        _cV(_component_cl_button, _uM("icon" to "add-line", "size" to "small", "onClick" to add)),
                                        _cV(_component_cl_button, _uM("icon" to "subtract-line", "type" to "light", "size" to "small", "onClick" to sub))
                                    ))
                                )
                            }
                            ), "_" to 1), 8, _uA(
                                "label"
                            )),
                            _cV(unref(GenPagesDemoComponentsItemClass), _uM("label" to unref(t)("自定义")), _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                                return _uA(
                                    _cE("view", _uM("class" to "flex flex-col items-center"), _uA(
                                        _cV(_component_cl_rolling_number, _uM("value" to value.value, "pt" to object : UTSJSONObject() {
                                            var className = unref(parseClass)(_uA(
                                                _uA(
                                                    isCustom.value,
                                                    "-important-text-3xl"
                                                )
                                            ))
                                            var color = if (isCustom.value) {
                                                "primary"
                                            } else {
                                                ""
                                            }
                                        }, "duration" to if (isSpeed.value) {
                                            300
                                        } else {
                                            1000
                                        }
                                        , "decimals" to if (isDecimals.value) {
                                            2
                                        } else {
                                            0
                                        }
                                        ), null, 8, _uA(
                                            "value",
                                            "pt",
                                            "duration",
                                            "decimals"
                                        )),
                                        _cE("view", _uM("class" to "flex flex-row mt-2"), _uA(
                                            _cV(_component_cl_button, _uM("icon" to "add-line", "size" to "small", "onClick" to add)),
                                            _cV(_component_cl_button, _uM("icon" to "subtract-line", "type" to "light", "size" to "small", "onClick" to sub))
                                        ))
                                    )),
                                    _cV(_component_cl_list, _uM("border" to "", "class" to "mt-3"), _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                                        return _uA(
                                            _cV(_component_cl_list_item, _uM("label" to unref(t)("加快滚动速度")), _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                                                return _uA(
                                                    _cV(_component_cl_switch, _uM("modelValue" to isSpeed.value, "onUpdate:modelValue" to fun(`$event`: Boolean){
                                                        isSpeed.value = `$event`
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
                                            _cV(_component_cl_list_item, _uM("label" to unref(t)("显示小数位数")), _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                                                return _uA(
                                                    _cV(_component_cl_switch, _uM("modelValue" to isDecimals.value, "onUpdate:modelValue" to fun(`$event`: Boolean){
                                                        isDecimals.value = `$event`
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
                                            _cV(_component_cl_list_item, _uM("label" to unref(t)("自定义样式")), _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                                                return _uA(
                                                    _cV(_component_cl_switch, _uM("modelValue" to isCustom.value, "onUpdate:modelValue" to fun(`$event`: Boolean){
                                                        isCustom.value = `$event`
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
