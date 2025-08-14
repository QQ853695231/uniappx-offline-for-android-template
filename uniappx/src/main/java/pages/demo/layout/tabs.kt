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
open class GenPagesDemoLayoutTabs : BasePage {
    constructor(__ins: ComponentInternalInstance, __renderer: String?) : super(__ins, __renderer) {
        onPageScroll(fun(e: OnPageScrollOptions) {
            scroller.emit(e.scrollTop)
        }
        , __ins)
        onPageShow(fun() {}, __ins)
    }
    companion object {
        @Suppress("UNUSED_PARAMETER", "UNUSED_VARIABLE")
        var setup: (__props: GenPagesDemoLayoutTabs) -> Any? = fun(__props): Any? {
            val __ins = getCurrentInstance()!!
            val _ctx = __ins.proxy as GenPagesDemoLayoutTabs
            val _cache = __ins.renderCache
            val form = reactive<Form6>(Form6(val1 = "1", val2 = "2", val3 = "1", val4 = "1", val5 = "2", val6 = "1"))
            val list = ref(_uA<ClTabsItem>(ClTabsItem(label = "Vue", value = "1"), ClTabsItem(label = "React", value = "2"), ClTabsItem(label = "Angular", value = "3"), ClTabsItem(label = "Svelte", value = "4"), ClTabsItem(label = "Jquery", value = "5"), ClTabsItem(label = "Vuex", value = "6"), ClTabsItem(label = "Vue Router", value = "7"), ClTabsItem(label = "Pinia", value = "8")))
            val list2 = ref(_uA<ClTabsItem>(ClTabsItem(label = "Vue", value = "1"), ClTabsItem(label = "React", value = "2"), ClTabsItem(label = "Angular", value = "3"), ClTabsItem(label = "Svelte", value = "4")))
            val list3 = ref(_uA<ClTabsItem>(ClTabsItem(label = "Vue", value = "1"), ClTabsItem(label = "React", value = "2"), ClTabsItem(label = "Angular", value = "3", disabled = true), ClTabsItem(label = "Svelte", value = "4")))
            val isShowLine = ref(true)
            val isDisabled = ref(false)
            val isColor = ref(false)
            val isPad = ref(false)
            return fun(): Any? {
                val _component_cl_tabs = resolveEasyComponent("cl-tabs", GenUniModulesCoolUiComponentsClTabsClTabsClass)
                val _component_cl_switch = resolveEasyComponent("cl-switch", GenUniModulesCoolUiComponentsClSwitchClSwitchClass)
                val _component_cl_list_item = resolveEasyComponent("cl-list-item", GenUniModulesCoolUiComponentsClListItemClListItemClass)
                val _component_cl_list = resolveEasyComponent("cl-list", GenUniModulesCoolUiComponentsClListClListClass)
                val _component_cl_page = resolveEasyComponent("cl-page", GenUniModulesCoolUiComponentsClPageClPageClass)
                return _cV(_component_cl_page, null, _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                    return _uA(
                        _cE("view", _uM("class" to "p-3"), _uA(
                            _cV(unref(GenPagesDemoComponentsItemClass), _uM("label" to unref(t)("基础用法")), _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                                return _uA(
                                    _cV(_component_cl_tabs, _uM("modelValue" to form.val1, "onUpdate:modelValue" to fun(`$event`: String){
                                        form.val1 = `$event`
                                    }
                                    , "list" to list.value), null, 8, _uA(
                                        "modelValue",
                                        "onUpdate:modelValue",
                                        "list"
                                    ))
                                )
                            }
                            ), "_" to 1), 8, _uA(
                                "label"
                            )),
                            _cV(unref(GenPagesDemoComponentsItemClass), _uM("label" to unref(t)("显示滑块")), _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                                return _uA(
                                    _cV(_component_cl_tabs, _uM("modelValue" to form.val2, "onUpdate:modelValue" to fun(`$event`: String){
                                        form.val2 = `$event`
                                    }
                                    , "list" to list.value, "show-slider" to "", "pt" to object : UTSJSONObject() {
                                        var className = if (isPad.value) {
                                            "-important-p-2"
                                        } else {
                                            ""
                                        }
                                    }), null, 8, _uA(
                                        "modelValue",
                                        "onUpdate:modelValue",
                                        "list",
                                        "pt"
                                    )),
                                    _cV(_component_cl_list, _uM("border" to "", "pt" to object : UTSJSONObject() {
                                        var className = "mt-3"
                                    }), _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                                        return _uA(
                                            _cV(_component_cl_list_item, _uM("label" to unref(t)("添加间距")), _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                                                return _uA(
                                                    _cV(_component_cl_switch, _uM("modelValue" to isPad.value, "onUpdate:modelValue" to fun(`$event`: Boolean){
                                                        isPad.value = `$event`
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
                            _cV(unref(GenPagesDemoComponentsItemClass), _uM("label" to unref(t)("横向填充")), _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                                return _uA(
                                    _cV(unref(GenPagesDemoComponentsTipsClass), null, _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                                        return _uA(
                                            _tD(unref(t)("适用于标签数量不多的情况"))
                                        )
                                    }
                                    ), "_" to 1)),
                                    _cV(_component_cl_tabs, _uM("modelValue" to form.val3, "onUpdate:modelValue" to fun(`$event`: String){
                                        form.val3 = `$event`
                                    }
                                    , "list" to list2.value, "fill" to ""), null, 8, _uA(
                                        "modelValue",
                                        "onUpdate:modelValue",
                                        "list"
                                    ))
                                )
                            }
                            ), "_" to 1), 8, _uA(
                                "label"
                            )),
                            _cV(unref(GenPagesDemoComponentsItemClass), _uM("label" to unref(t)("居中")), _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                                return _uA(
                                    _cE("view", _uM("class" to "flex flex-row justify-center"), _uA(
                                        _cV(_component_cl_tabs, _uM("modelValue" to form.val4, "onUpdate:modelValue" to fun(`$event`: String){
                                            form.val4 = `$event`
                                        }
                                        , "list" to list2.value), null, 8, _uA(
                                            "modelValue",
                                            "onUpdate:modelValue",
                                            "list"
                                        ))
                                    ))
                                )
                            }
                            ), "_" to 1), 8, _uA(
                                "label"
                            )),
                            _cV(unref(GenPagesDemoComponentsItemClass), _uM("label" to unref(t)("单个禁用")), _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                                return _uA(
                                    _cV(_component_cl_tabs, _uM("modelValue" to form.val5, "onUpdate:modelValue" to fun(`$event`: String){
                                        form.val5 = `$event`
                                    }
                                    , "list" to list3.value), null, 8, _uA(
                                        "modelValue",
                                        "onUpdate:modelValue",
                                        "list"
                                    ))
                                )
                            }
                            ), "_" to 1), 8, _uA(
                                "label"
                            )),
                            _cV(unref(GenPagesDemoComponentsItemClass), _uM("label" to unref(t)("自定义")), _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                                return _uA(
                                    _cV(_component_cl_tabs, _uM("modelValue" to form.val6, "onUpdate:modelValue" to fun(`$event`: String){
                                        form.val6 = `$event`
                                    }
                                    , "list" to list.value, "show-line" to isShowLine.value, "disabled" to isDisabled.value, "color" to if (isColor.value) {
                                        "red"
                                    } else {
                                        ""
                                    }
                                    , "un-color" to if (isColor.value) {
                                        "#ccc"
                                    } else {
                                        ""
                                    }
                                    ), null, 8, _uA(
                                        "modelValue",
                                        "onUpdate:modelValue",
                                        "list",
                                        "show-line",
                                        "disabled",
                                        "color",
                                        "un-color"
                                    )),
                                    _cV(_component_cl_list, _uM("border" to "", "pt" to object : UTSJSONObject() {
                                        var className = "mt-3"
                                    }), _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                                        return _uA(
                                            _cV(_component_cl_list_item, _uM("label" to unref(t)("显示下划线")), _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                                                return _uA(
                                                    _cV(_component_cl_switch, _uM("modelValue" to isShowLine.value, "onUpdate:modelValue" to fun(`$event`: Boolean){
                                                        isShowLine.value = `$event`
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
                                            _cV(_component_cl_list_item, _uM("label" to unref(t)("自定义颜色")), _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
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
