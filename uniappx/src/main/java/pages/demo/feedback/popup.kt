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
open class GenPagesDemoFeedbackPopup : BasePage {
    constructor(__ins: ComponentInternalInstance, __renderer: String?) : super(__ins, __renderer) {
        onPageScroll(fun(e: OnPageScrollOptions) {
            scroller.emit(e.scrollTop)
        }
        , __ins)
        onPageShow(fun() {}, __ins)
    }
    companion object {
        @Suppress("UNUSED_PARAMETER", "UNUSED_VARIABLE")
        var setup: (__props: GenPagesDemoFeedbackPopup) -> Any? = fun(__props): Any? {
            val __ins = getCurrentInstance()!!
            val _ctx = __ins.proxy as GenPagesDemoFeedbackPopup
            val _cache = __ins.renderCache
            val visible = ref(false)
            val isWidth = ref(true)
            val unShowHeader = ref(false)
            val isCustom = ref(false)
            val direction = ref<ClPopupDirection>("bottom")
            val directionList = ref(_uA<ClTabsItem>(ClTabsItem(label = t("底部"), value = "bottom"), ClTabsItem(label = t("顶部"), value = "top"), ClTabsItem(label = t("左侧"), value = "left"), ClTabsItem(label = t("右侧"), value = "right"), ClTabsItem(label = t("中间"), value = "center")))
            val size = computed(fun(): String {
                if (direction.value == "left" || direction.value == "right" || direction.value == "center") {
                    return if (isWidth.value) {
                        "80%"
                    } else {
                        ""
                    }
                }
                return ""
            }
            )
            fun gen_openPopup_fn() {
                visible.value = true
            }
            val openPopup = ::gen_openPopup_fn
            return fun(): Any? {
                val _component_cl_button = resolveEasyComponent("cl-button", GenUniModulesCoolUiComponentsClButtonClButtonClass)
                val _component_cl_tabs = resolveEasyComponent("cl-tabs", GenUniModulesCoolUiComponentsClTabsClTabsClass)
                val _component_cl_switch = resolveEasyComponent("cl-switch", GenUniModulesCoolUiComponentsClSwitchClSwitchClass)
                val _component_cl_list_item = resolveEasyComponent("cl-list-item", GenUniModulesCoolUiComponentsClListItemClListItemClass)
                val _component_cl_list = resolveEasyComponent("cl-list", GenUniModulesCoolUiComponentsClListClListClass)
                val _component_cl_image = resolveEasyComponent("cl-image", GenUniModulesCoolUiComponentsClImageClImageClass)
                val _component_cl_text = resolveEasyComponent("cl-text", GenUniModulesCoolUiComponentsClTextClTextClass)
                val _component_cl_popup = resolveEasyComponent("cl-popup", GenUniModulesCoolUiComponentsClPopupClPopupClass)
                val _component_cl_page = resolveEasyComponent("cl-page", GenUniModulesCoolUiComponentsClPageClPageClass)
                return _cV(_component_cl_page, null, _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                    return _uA(
                        _cE("view", _uM("class" to "p-3"), _uA(
                            _cV(unref(GenPagesDemoComponentsItemClass), _uM("label" to unref(t)("自定义")), _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                                return _uA(
                                    _cV(_component_cl_button, _uM("onClick" to openPopup), _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                                        return _uA(
                                            _tD(unref(t)("打开弹窗"))
                                        )
                                    }
                                    ), "_" to 1)),
                                    _cV(_component_cl_list, _uM("border" to "", "class" to "mt-3"), _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                                        return _uA(
                                            _cE("view", _uM("class" to "w-full p-2"), _uA(
                                                _cV(_component_cl_tabs, _uM("modelValue" to direction.value, "onUpdate:modelValue" to fun(`$event`: ClPopupDirection){
                                                    direction.value = `$event`
                                                }
                                                , "list" to directionList.value, "show-slider" to "", "height" to 66), null, 8, _uA(
                                                    "modelValue",
                                                    "onUpdate:modelValue",
                                                    "list"
                                                ))
                                            )),
                                            _cV(_component_cl_list_item, _uM("label" to unref(t)("设置宽度 80%")), _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                                                return _uA(
                                                    _cV(_component_cl_switch, _uM("modelValue" to isWidth.value, "onUpdate:modelValue" to fun(`$event`: Boolean){
                                                        isWidth.value = `$event`
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
                                            _cV(_component_cl_list_item, _uM("label" to unref(t)("无头")), _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                                                return _uA(
                                                    _cV(_component_cl_switch, _uM("modelValue" to unShowHeader.value, "onUpdate:modelValue" to fun(`$event`: Boolean){
                                                        unShowHeader.value = `$event`
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
                        )),
                        _cV(_component_cl_popup, _uM("modelValue" to visible.value, "onUpdate:modelValue" to fun(`$event`: Boolean){
                            visible.value = `$event`
                        }
                        , "title" to unref(t)("标题"), "direction" to direction.value, "size" to size.value, "show-header" to !unShowHeader.value, "pt" to object : UTSJSONObject() {
                            var className = unref(parseClass)(_uA(
                                _uA(
                                    isCustom.value,
                                    "-important-p-3"
                                )
                            ))
                            var inner = object : UTSJSONObject() {
                                var className = unref(parseClass)(_uA(
                                    _uA(
                                        isCustom.value,
                                        "-important-rounded-2xl"
                                    )
                                ))
                            }
                        }), _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                            return _uA(
                                _cE("view", _uM("class" to _nC(_uA(
                                    "p-3",
                                    _uM("pt-0" to !unShowHeader.value)
                                ))), _uA(
                                    _cV(_component_cl_image, _uM("src" to "https://uni-docs.cool-js.com/demo/pages/demo/static/bg1.png", "class" to "mb-3", "height" to "auto", "width" to "100%", "mode" to "widthFix")),
                                    _cV(_component_cl_text, null, _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                                        return _uA(
                                            "春江花月夜， 花草复青青。 江水流不尽， 月光照无情。 夜来风雨急， 愁思满心头。 何时再相见， 共赏月明楼。 "
                                        )
                                    }
                                    ), "_" to 1))
                                ), 2)
                            )
                        }
                        ), "_" to 1), 8, _uA(
                            "modelValue",
                            "onUpdate:modelValue",
                            "title",
                            "direction",
                            "size",
                            "show-header",
                            "pt"
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
