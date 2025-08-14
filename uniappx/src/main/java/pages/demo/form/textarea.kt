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
open class GenPagesDemoFormTextarea : BasePage {
    constructor(__ins: ComponentInternalInstance, __renderer: String?) : super(__ins, __renderer) {
        onPageScroll(fun(e: OnPageScrollOptions) {
            scroller.emit(e.scrollTop)
        }
        , __ins)
        onPageShow(fun() {}, __ins)
    }
    companion object {
        @Suppress("UNUSED_PARAMETER", "UNUSED_VARIABLE")
        var setup: (__props: GenPagesDemoFormTextarea) -> Any? = fun(__props): Any? {
            val __ins = getCurrentInstance()!!
            val _ctx = __ins.proxy as GenPagesDemoFormTextarea
            val _cache = __ins.renderCache
            val content = ref("Cool Unix")
            val isBorder = ref(true)
            val isShowCount = ref(true)
            val isDisabled = ref(false)
            val isColor = ref(false)
            val isAutoHeight = ref(false)
            return fun(): Any? {
                val _component_cl_textarea = resolveEasyComponent("cl-textarea", GenUniModulesCoolUiComponentsClTextareaClTextareaClass)
                val _component_cl_switch = resolveEasyComponent("cl-switch", GenUniModulesCoolUiComponentsClSwitchClSwitchClass)
                val _component_cl_list_item = resolveEasyComponent("cl-list-item", GenUniModulesCoolUiComponentsClListItemClListItemClass)
                val _component_cl_list = resolveEasyComponent("cl-list", GenUniModulesCoolUiComponentsClListClListClass)
                val _component_cl_page = resolveEasyComponent("cl-page", GenUniModulesCoolUiComponentsClPageClPageClass)
                return _cV(_component_cl_page, null, _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                    return _uA(
                        _cE("view", _uM("class" to "p-3"), _uA(
                            _cV(unref(GenPagesDemoComponentsItemClass), _uM("label" to unref(t)("基础用法")), _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                                return _uA(
                                    _cV(_component_cl_textarea)
                                )
                            }
                            ), "_" to 1), 8, _uA(
                                "label"
                            )),
                            _cV(unref(GenPagesDemoComponentsItemClass), _uM("label" to unref(t)("自定义")), _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                                return _uA(
                                    _cE("view", _uM("class" to "mb-3"), _uA(
                                        _cV(_component_cl_textarea, _uM("modelValue" to content.value, "onUpdate:modelValue" to fun(`$event`: String){
                                            content.value = `$event`
                                        }
                                        , "border" to isBorder.value, "disabled" to isDisabled.value, "show-word-limit" to isShowCount.value, "auto-height" to isAutoHeight.value, "pt" to object : UTSJSONObject() {
                                            var className = unref(parseClass)(object : UTSJSONObject() {
                                                var `-important-bg-sky-100` = isColor.value
                                                var `-important-border-sky-700` = isColor.value
                                            })
                                            var inner = object : UTSJSONObject() {
                                                var className = unref(parseClass)(object : UTSJSONObject() {
                                                    var `-important-text-sky-700` = isColor.value
                                                })
                                            }
                                        }), null, 8, _uA(
                                            "modelValue",
                                            "onUpdate:modelValue",
                                            "border",
                                            "disabled",
                                            "show-word-limit",
                                            "auto-height",
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
                                            _cV(_component_cl_list_item, _uM("label" to unref(t)("显示字数")), _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                                                return _uA(
                                                    _cV(_component_cl_switch, _uM("modelValue" to isShowCount.value, "onUpdate:modelValue" to fun(`$event`: Boolean){
                                                        isShowCount.value = `$event`
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
                                            _cV(_component_cl_list_item, _uM("label" to unref(t)("自动增高")), _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                                                return _uA(
                                                    _cV(_component_cl_switch, _uM("modelValue" to isAutoHeight.value, "onUpdate:modelValue" to fun(`$event`: Boolean){
                                                        isAutoHeight.value = `$event`
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
