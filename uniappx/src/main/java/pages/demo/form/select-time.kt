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
open class GenPagesDemoFormSelectTime : BasePage {
    constructor(__ins: ComponentInternalInstance, __renderer: String?) : super(__ins, __renderer) {
        onPageScroll(fun(e: OnPageScrollOptions) {
            scroller.emit(e.scrollTop)
        }
        , __ins)
        onPageShow(fun() {}, __ins)
    }
    companion object {
        @Suppress("UNUSED_PARAMETER", "UNUSED_VARIABLE")
        var setup: (__props: GenPagesDemoFormSelectTime) -> Any? = fun(__props): Any? {
            val __ins = getCurrentInstance()!!
            val _ctx = __ins.proxy as GenPagesDemoFormSelectTime
            val _cache = __ins.renderCache
            val ui = useUi()
            val form = reactive<Form3>(Form3(time1 = "", time2 = "", time3 = ""))
            val isDisabled = ref(false)
            val isFormat = ref(false)
            val isHour = ref(false)
            val isMinute = ref(false)
            val isSecond = ref(true)
            val selectRef2 = ref<ClSelectTimeComponentPublicInstance?>(null)
            fun gen_openSelect2_fn() {
                selectRef2.value!!.open(fun(value){
                    ui.showToast(ClToastOptions(message = "\u4F60\u9009\u62E9\u4E86\uFF1A" + value))
                }
                )
            }
            val openSelect2 = ::gen_openSelect2_fn
            val type = computed(fun(): String {
                if (isHour.value) {
                    return "hour"
                }
                if (isMinute.value) {
                    return "minute"
                }
                return "second"
            }
            )
            val labelFormat = computed(fun(): String? {
                if (isFormat.value) {
                    when (type.value) {
                        "hour" -> 
                            return "{H}时"
                        "minute" -> 
                            return "{H}时{m}分"
                        "second" -> 
                            return "{H}时{m}分{s}秒"
                        else -> 
                            return null
                    }
                } else {
                    return null
                }
            }
            )
            return fun(): Any? {
                val _component_cl_select_time = resolveEasyComponent("cl-select-time", GenUniModulesCoolUiComponentsClSelectTimeClSelectTimeClass)
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
                                    _cV(_component_cl_select_time, _uM("modelValue" to form.time1, "onUpdate:modelValue" to fun(`$event`: String){
                                        form.time1 = `$event`
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
                            _cV(unref(GenPagesDemoComponentsItemClass), _uM("label" to unref(t)("自定义触发器")), _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                                return _uA(
                                    _cE("view", _uM("class" to "flex flex-row"), _uA(
                                        _cV(_component_cl_button, _uM("onClick" to openSelect2), _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                                            return _uA(
                                                _tD(unref(t)("打开选择器"))
                                            )
                                        }
                                        ), "_" to 1))
                                    )),
                                    _cV(_component_cl_select_time, _uM("ref_key" to "selectRef2", "ref" to selectRef2, "modelValue" to form.time2, "onUpdate:modelValue" to fun(`$event`: String){
                                        form.time2 = `$event`
                                    }
                                    , "show-trigger" to false), null, 8, _uA(
                                        "modelValue",
                                        "onUpdate:modelValue"
                                    ))
                                )
                            }
                            ), "_" to 1), 8, _uA(
                                "label"
                            )),
                            _cV(unref(GenPagesDemoComponentsItemClass), _uM("label" to unref(t)("自定义")), _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                                return _uA(
                                    _cV(_component_cl_select_time, _uM("modelValue" to form.time3, "onUpdate:modelValue" to fun(`$event`: String){
                                        form.time3 = `$event`
                                    }
                                    , "disabled" to isDisabled.value, "label-format" to labelFormat.value, "type" to type.value), null, 8, _uA(
                                        "modelValue",
                                        "onUpdate:modelValue",
                                        "disabled",
                                        "label-format",
                                        "type"
                                    )),
                                    _cV(_component_cl_list, _uM("border" to "", "pt" to object : UTSJSONObject() {
                                        var className = "mt-3"
                                    }), _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                                        return _uA(
                                            _cV(_component_cl_list_item, _uM("label" to unref(t)("时")), _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                                                return _uA(
                                                    _cV(_component_cl_switch, _uM("modelValue" to isHour.value, "onUpdate:modelValue" to fun(`$event`: Boolean){
                                                        isHour.value = `$event`
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
                                            _cV(_component_cl_list_item, _uM("label" to unref(t)("时:分")), _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                                                return _uA(
                                                    _cV(_component_cl_switch, _uM("modelValue" to isMinute.value, "onUpdate:modelValue" to fun(`$event`: Boolean){
                                                        isMinute.value = `$event`
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
                                            _cV(_component_cl_list_item, _uM("label" to unref(t)("时:分:秒")), _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                                                return _uA(
                                                    _cV(_component_cl_switch, _uM("modelValue" to isSecond.value, "onUpdate:modelValue" to fun(`$event`: Boolean){
                                                        isSecond.value = `$event`
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
                                            _cV(_component_cl_list_item, _uM("label" to unref(t)("标签格式化")), _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                                                return _uA(
                                                    _cV(_component_cl_switch, _uM("modelValue" to isFormat.value, "onUpdate:modelValue" to fun(`$event`: Boolean){
                                                        isFormat.value = `$event`
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
