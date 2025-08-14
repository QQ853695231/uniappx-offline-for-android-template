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
open class GenPagesDemoFormRadio : BasePage {
    constructor(__ins: ComponentInternalInstance, __renderer: String?) : super(__ins, __renderer) {
        onPageScroll(fun(e: OnPageScrollOptions) {
            scroller.emit(e.scrollTop)
        }
        , __ins)
        onPageShow(fun() {}, __ins)
    }
    companion object {
        @Suppress("UNUSED_PARAMETER", "UNUSED_VARIABLE")
        var setup: (__props: GenPagesDemoFormRadio) -> Any? = fun(__props): Any? {
            val __ins = getCurrentInstance()!!
            val _ctx = __ins.proxy as GenPagesDemoFormRadio
            val _cache = __ins.renderCache
            val ui = useUi()
            val isIcon = ref(false)
            val isCustom = ref(false)
            val isDisabled = ref(false)
            val isHideIcon = ref(false)
            val isVerticalCustom = ref(false)
            val checked = ref("1")
            val checked2 = ref("2")
            val checked3 = ref("3")
            val options = ref(_uA<ClRadioOption>(ClRadioOption(label = "Vue", value = "1"), ClRadioOption(label = "React", value = "2"), ClRadioOption(label = "Angular", value = "3"), ClRadioOption(label = "Svelte", value = "4")))
            return fun(): Any? {
                val _component_cl_radio = resolveEasyComponent("cl-radio", GenUniModulesCoolUiComponentsClRadioClRadioClass)
                val _component_cl_switch = resolveEasyComponent("cl-switch", GenUniModulesCoolUiComponentsClSwitchClSwitchClass)
                val _component_cl_list_item = resolveEasyComponent("cl-list-item", GenUniModulesCoolUiComponentsClListItemClListItemClass)
                val _component_cl_list = resolveEasyComponent("cl-list", GenUniModulesCoolUiComponentsClListClListClass)
                val _component_cl_page = resolveEasyComponent("cl-page", GenUniModulesCoolUiComponentsClPageClPageClass)
                return _cV(_component_cl_page, null, _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                    return _uA(
                        _cE("view", _uM("class" to "p-3"), _uA(
                            _cV(unref(GenPagesDemoComponentsItemClass), _uM("label" to unref(t)("基础用法")), _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                                return _uA(
                                    _cE("view", _uM("class" to "flex flex-row flex-wrap"), _uA(
                                        _cE(Fragment, null, RenderHelpers.renderList(options.value, fun(item, index, __index, _cached): Any {
                                            return _cV(_component_cl_radio, _uM("modelValue" to checked2.value, "onUpdate:modelValue" to fun(`$event`: String){
                                                checked2.value = `$event`
                                            }
                                            , "key" to index, "value" to item.value, "pt" to object : UTSJSONObject() {
                                                var className = "mr-5"
                                            }), _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                                                return _uA(
                                                    _tD(item.label)
                                                )
                                            }
                                            ), "_" to 2), 1032, _uA(
                                                "modelValue",
                                                "onUpdate:modelValue",
                                                "value"
                                            ))
                                        }
                                        ), 128)
                                    ))
                                )
                            }
                            ), "_" to 1), 8, _uA(
                                "label"
                            )),
                            _cV(unref(GenPagesDemoComponentsItemClass), _uM("label" to unref(t)("纵向排列")), _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                                return _uA(
                                    _cE(Fragment, null, RenderHelpers.renderList(options.value, fun(item, index, __index, _cached): Any {
                                        return _cV(_component_cl_radio, _uM("modelValue" to checked.value, "onUpdate:modelValue" to fun(`$event`: String){
                                            checked.value = `$event`
                                        }
                                        , "key" to index, "value" to item.value, "pt" to object : UTSJSONObject() {
                                            var className = unref(parseClass)(_uA(
                                                "my-2",
                                                _uA(
                                                    isVerticalCustom.value,
                                                    "justify-between border border-solid border-surface-200 rounded-lg p-2 -important-my-1"
                                                )
                                            ))
                                        }), _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                                            return _uA(
                                                _tD(item.label)
                                            )
                                        }
                                        ), "_" to 2), 1032, _uA(
                                            "modelValue",
                                            "onUpdate:modelValue",
                                            "value",
                                            "pt"
                                        ))
                                    }
                                    ), 128),
                                    _cV(_component_cl_list, _uM("border" to "", "pt" to object : UTSJSONObject() {
                                        var className = "mt-2"
                                    }), _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                                        return _uA(
                                            _cV(_component_cl_list_item, _uM("label" to unref(t)("换个样式")), _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                                                return _uA(
                                                    _cV(_component_cl_switch, _uM("modelValue" to isVerticalCustom.value, "onUpdate:modelValue" to fun(`$event`: Boolean){
                                                        isVerticalCustom.value = `$event`
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
                            )),
                            _cV(unref(GenPagesDemoComponentsItemClass), _uM("label" to unref(t)("自定义")), _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                                return _uA(
                                    _cE("view", _uM("class" to "mb-3 flex flex-row flex-wrap"), _uA(
                                        _cE(Fragment, null, RenderHelpers.renderList(options.value, fun(item, index, __index, _cached): Any {
                                            return _cV(_component_cl_radio, _uM("modelValue" to checked3.value, "onUpdate:modelValue" to fun(`$event`: String){
                                                checked3.value = `$event`
                                            }
                                            , "key" to index, "value" to item.value, "disabled" to isDisabled.value, "show-icon" to !isHideIcon.value, "active-icon" to if (isIcon.value) {
                                                "heart-fill"
                                            } else {
                                                "checkbox-circle-line"
                                            }
                                            , "inactive-icon" to if (isIcon.value) {
                                                "heart-line"
                                            } else {
                                                "checkbox-blank-circle-line"
                                            }
                                            , "pt" to object : UTSJSONObject() {
                                                var className = unref(parseClass)(_uA(
                                                    "mr-5",
                                                    _uA(
                                                        isCustom.value,
                                                        "bg-surface-100 py-2 px-3 rounded-lg -important-mr-2 -important-mb-2"
                                                    ),
                                                    object : UTSJSONObject() {
                                                        var `-important-bg-surface-700` = unref(isDark) && isCustom.value
                                                    }
                                                ))
                                            }), _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                                                return _uA(
                                                    _tD(item.label)
                                                )
                                            }
                                            ), "_" to 2), 1032, _uA(
                                                "modelValue",
                                                "onUpdate:modelValue",
                                                "value",
                                                "disabled",
                                                "show-icon",
                                                "active-icon",
                                                "inactive-icon",
                                                "pt"
                                            ))
                                        }
                                        ), 128)
                                    )),
                                    _cV(_component_cl_list, _uM("border" to ""), _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                                        return _uA(
                                            _cV(_component_cl_list_item, _uM("label" to unref(t)("换个图标")), _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                                                return _uA(
                                                    _cV(_component_cl_switch, _uM("modelValue" to isIcon.value, "onUpdate:modelValue" to fun(`$event`: Boolean){
                                                        isIcon.value = `$event`
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
                                            _cV(_component_cl_list_item, _uM("label" to unref(t)("不显示图标")), _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                                                return _uA(
                                                    _cV(_component_cl_switch, _uM("modelValue" to isHideIcon.value, "onUpdate:modelValue" to fun(`$event`: Boolean){
                                                        isHideIcon.value = `$event`
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
                                            _cV(_component_cl_list_item, _uM("label" to unref(t)("其他样式")), _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
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
