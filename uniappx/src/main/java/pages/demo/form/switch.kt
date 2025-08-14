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
open class GenPagesDemoFormSwitch : BasePage {
    constructor(__ins: ComponentInternalInstance, __renderer: String?) : super(__ins, __renderer) {
        onPageScroll(fun(e: OnPageScrollOptions) {
            scroller.emit(e.scrollTop)
        }
        , __ins)
        onPageShow(fun() {}, __ins)
    }
    companion object {
        @Suppress("UNUSED_PARAMETER", "UNUSED_VARIABLE")
        var setup: (__props: GenPagesDemoFormSwitch) -> Any? = fun(__props): Any? {
            val __ins = getCurrentInstance()!!
            val _ctx = __ins.proxy as GenPagesDemoFormSwitch
            val _cache = __ins.renderCache
            val checked = ref(false)
            val isDisabled = ref(false)
            val isLoading = ref(false)
            val isSize = ref(false)
            val isCustom = ref(false)
            return fun(): Any? {
                val _component_cl_switch = resolveEasyComponent("cl-switch", GenUniModulesCoolUiComponentsClSwitchClSwitchClass)
                val _component_cl_list_item = resolveEasyComponent("cl-list-item", GenUniModulesCoolUiComponentsClListItemClListItemClass)
                val _component_cl_list = resolveEasyComponent("cl-list", GenUniModulesCoolUiComponentsClListClListClass)
                val _component_cl_page = resolveEasyComponent("cl-page", GenUniModulesCoolUiComponentsClPageClPageClass)
                return _cV(_component_cl_page, null, _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                    return _uA(
                        _cE("view", _uM("class" to "p-3"), _uA(
                            _cV(unref(GenPagesDemoComponentsItemClass), _uM("label" to unref(t)("基础用法")), _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                                return _uA(
                                    _cV(_component_cl_switch, _uM("modelValue" to checked.value, "onUpdate:modelValue" to fun(`$event`: Boolean){
                                        checked.value = `$event`
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
                            _cV(unref(GenPagesDemoComponentsItemClass), _uM("label" to unref(t)("自定义颜色")), _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                                return _uA(
                                    _cE("view", _uM("class" to "flex flex-row"), _uA(
                                        _cV(_component_cl_switch, _uM("modelValue" to checked.value, "onUpdate:modelValue" to fun(`$event`: Boolean){
                                            checked.value = `$event`
                                        }
                                        , "pt" to object : UTSJSONObject() {
                                            var className = "mr-5"
                                            var track = object : UTSJSONObject() {
                                                var className = "-important-bg-red-100"
                                            }
                                            var thumb = object : UTSJSONObject() {
                                                var className = "-important-bg-red-500"
                                            }
                                        }), null, 8, _uA(
                                            "modelValue",
                                            "onUpdate:modelValue"
                                        )),
                                        _cV(_component_cl_switch, _uM("modelValue" to checked.value, "onUpdate:modelValue" to fun(`$event`: Boolean){
                                            checked.value = `$event`
                                        }
                                        , "pt" to object : UTSJSONObject() {
                                            var track = object : UTSJSONObject() {
                                                var className = "-important-bg-purple-100"
                                            }
                                            var thumb = object : UTSJSONObject() {
                                                var className = "-important-bg-purple-500"
                                            }
                                        }), null, 8, _uA(
                                            "modelValue",
                                            "onUpdate:modelValue"
                                        ))
                                    ))
                                )
                            }
                            ), "_" to 1), 8, _uA(
                                "label"
                            )),
                            _cV(unref(GenPagesDemoComponentsItemClass), _uM("label" to unref(t)("自定义")), _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                                return _uA(
                                    _cV(_component_cl_switch, _uM("modelValue" to checked.value, "onUpdate:modelValue" to fun(`$event`: Boolean){
                                        checked.value = `$event`
                                    }
                                    , "loading" to isLoading.value, "disabled" to isDisabled.value, "height" to if (isSize.value) {
                                        60
                                    } else {
                                        48
                                    }
                                    , "width" to if (isSize.value) {
                                        100
                                    } else {
                                        80
                                    }
                                    , "pt" to object : UTSJSONObject() {
                                        var track = object : UTSJSONObject() {
                                            var className = unref(parseClass)(_uA(
                                                _uA(
                                                    isCustom.value,
                                                    "-important-rounded-md"
                                                )
                                            ))
                                        }
                                        var thumb = object : UTSJSONObject() {
                                            var className = unref(parseClass)(_uA(
                                                _uA(
                                                    isCustom.value,
                                                    "-important-rounded-md"
                                                )
                                            ))
                                        }
                                    }), null, 8, _uA(
                                        "modelValue",
                                        "onUpdate:modelValue",
                                        "loading",
                                        "disabled",
                                        "height",
                                        "width",
                                        "pt"
                                    )),
                                    _cV(_component_cl_list, _uM("border" to "", "pt" to object : UTSJSONObject() {
                                        var className = "mt-3"
                                    }), _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                                        return _uA(
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
                                            _cV(_component_cl_list_item, _uM("label" to unref(t)("加载中")), _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                                                return _uA(
                                                    _cV(_component_cl_switch, _uM("modelValue" to isLoading.value, "onUpdate:modelValue" to fun(`$event`: Boolean){
                                                        isLoading.value = `$event`
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
                                            _cV(_component_cl_list_item, _uM("label" to unref(t)("大一点")), _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
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
                                            _cV(_component_cl_list_item, _uM("label" to unref(t)("正方形")), _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
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
