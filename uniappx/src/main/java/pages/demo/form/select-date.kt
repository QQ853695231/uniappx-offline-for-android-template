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
open class GenPagesDemoFormSelectDate : BasePage {
    constructor(__ins: ComponentInternalInstance, __renderer: String?) : super(__ins, __renderer) {
        onPageScroll(fun(e: OnPageScrollOptions) {
            scroller.emit(e.scrollTop)
        }
        , __ins)
        onPageShow(fun() {}, __ins)
    }
    companion object {
        @Suppress("UNUSED_PARAMETER", "UNUSED_VARIABLE")
        var setup: (__props: GenPagesDemoFormSelectDate) -> Any? = fun(__props): Any? {
            val __ins = getCurrentInstance()!!
            val _ctx = __ins.proxy as GenPagesDemoFormSelectDate
            val _cache = __ins.renderCache
            val ui = useUi()
            fun gen_onDateChange_fn(value: String) {
                console.log("日期选择变化:", value)
                ui.showToast(ClToastOptions(message = "\u9009\u62E9\u4E86\u65E5\u671F: " + value, type = "success"))
            }
            val onDateChange = ::gen_onDateChange_fn
            val form = reactive<Form2>(Form2(date1 = "", date2 = "", date3 = "", date4 = "", date5 = _uA(), date6 = _uA(), date7 = ""))
            val isDisabled = ref(false)
            val isYear = ref(false)
            val isMonth = ref(false)
            val isDate = ref(true)
            val isHour = ref(false)
            val isMinute = ref(false)
            val isSecond = ref(false)
            val isFormat = ref(false)
            val type = computed(fun(): String {
                if (isSecond.value) {
                    return "second"
                }
                if (isMinute.value) {
                    return "minute"
                }
                if (isHour.value) {
                    return "hour"
                }
                if (isDate.value) {
                    return "date"
                }
                if (isMonth.value) {
                    return "month"
                }
                if (isYear.value) {
                    return "year"
                }
                return "second"
            }
            )
            val labelFormat = computed(fun(): String {
                if (isFormat.value) {
                    if (isSecond.value) {
                        return "YYYY年MM月DD日 HH时mm分ss秒"
                    }
                    if (isMinute.value) {
                        return "YYYY年MM月DD日 HH时mm分"
                    }
                    if (isHour.value) {
                        return "YYYY年MM月DD日 HH时"
                    }
                    if (isDate.value) {
                        return "YYYY年MM月DD日"
                    }
                    if (isMonth.value) {
                        return "YYYY年MM月"
                    }
                    if (isYear.value) {
                        return "YYYY年"
                    }
                } else {
                    if (isSecond.value) {
                        return "YYYY-MM-DD HH:mm:ss"
                    }
                    if (isMinute.value) {
                        return "YYYY-MM-DD HH:mm"
                    }
                    if (isHour.value) {
                        return "YYYY-MM-DD HH"
                    }
                    if (isDate.value) {
                        return "YYYY-MM-DD"
                    }
                    if (isMonth.value) {
                        return "YYYY-MM"
                    }
                    if (isYear.value) {
                        return "YYYY"
                    }
                }
                return "YYYY-MM-DD HH:mm:ss"
            }
            )
            val selectRef4 = ref<ClSelectDateComponentPublicInstance?>(null)
            fun gen_openSelect4_fn() {
                selectRef4.value!!.open(fun(value){
                    ui.showToast(ClToastOptions(message = "\u4F60\u9009\u62E9\u4E86\uFF1A" + value))
                }
                )
            }
            val openSelect4 = ::gen_openSelect4_fn
            val shortcuts = ref(_uA<ClSelectDateShortcut>(ClSelectDateShortcut(label = "昨日", value = _uA(
                dayUts().subtract(1, "day").format("YYYY-MM-DD"),
                dayUts().format("YYYY-MM-DD")
            )), ClSelectDateShortcut(label = "本周", value = _uA(
                dayUts().startOf("week").format("YYYY-MM-DD"),
                dayUts().endOf("week").format("YYYY-MM-DD")
            )), ClSelectDateShortcut(label = "本月", value = _uA(
                dayUts().startOf("month").format("YYYY-MM-DD"),
                dayUts().endOf("month").format("YYYY-MM-DD")
            ))))
            return fun(): Any? {
                val _component_cl_select_date = resolveEasyComponent("cl-select-date", GenUniModulesCoolUiComponentsClSelectDateClSelectDateClass)
                val _component_cl_button = resolveEasyComponent("cl-button", GenUniModulesCoolUiComponentsClButtonClButtonClass)
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
                                    _cV(_component_cl_select_date, _uM("modelValue" to form.date1, "onUpdate:modelValue" to fun(`$event`: String){
                                        form.date1 = `$event`
                                    }
                                    , "type" to "date", "onChange" to onDateChange), null, 8, _uA(
                                        "modelValue",
                                        "onUpdate:modelValue"
                                    ))
                                )
                            }
                            ), "_" to 1), 8, _uA(
                                "label"
                            )),
                            _cV(unref(GenPagesDemoComponentsItemClass), _uM("label" to unref(t)("固定开始、结束日期")), _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                                return _uA(
                                    _cV(_component_cl_select_date, _uM("modelValue" to form.date3, "onUpdate:modelValue" to fun(`$event`: String){
                                        form.date3 = `$event`
                                    }
                                    , "start" to "2025-06-01", "end" to "2027-08-01", "type" to "date"), null, 8, _uA(
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
                                        _cV(_component_cl_button, _uM("onClick" to openSelect4), _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                                            return _uA(
                                                _tD(unref(t)("打开选择器"))
                                            )
                                        }
                                        ), "_" to 1))
                                    )),
                                    _cV(_component_cl_select_date, _uM("ref_key" to "selectRef4", "ref" to selectRef4, "modelValue" to form.date4, "onUpdate:modelValue" to fun(`$event`: String){
                                        form.date4 = `$event`
                                    }
                                    , "type" to "date", "show-trigger" to false), null, 8, _uA(
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
                                            _tD(form.date5)
                                        )
                                    }
                                    ), "_" to 1)),
                                    _cV(_component_cl_select_date, _uM("values" to form.date5, "onUpdate:values" to fun(`$event`: UTSArray<String>){
                                        form.date5 = `$event`
                                    }
                                    , "type" to "date", "rangeable" to ""), null, 8, _uA(
                                        "values",
                                        "onUpdate:values"
                                    ))
                                )
                            }
                            ), "_" to 1), 8, _uA(
                                "label"
                            )),
                            _cV(unref(GenPagesDemoComponentsItemClass), _uM("label" to unref(t)("自定义快捷选项")), _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                                return _uA(
                                    _cV(_component_cl_select_date, _uM("values" to form.date6, "onUpdate:values" to fun(`$event`: UTSArray<String>){
                                        form.date6 = `$event`
                                    }
                                    , "type" to "date", "rangeable" to "", "shortcuts" to shortcuts.value), null, 8, _uA(
                                        "values",
                                        "onUpdate:values",
                                        "shortcuts"
                                    ))
                                )
                            }
                            ), "_" to 1), 8, _uA(
                                "label"
                            )),
                            _cV(unref(GenPagesDemoComponentsItemClass), _uM("label" to unref(t)("自定义")), _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                                return _uA(
                                    _cV(_component_cl_select_date, _uM("modelValue" to form.date7, "onUpdate:modelValue" to fun(`$event`: String){
                                        form.date7 = `$event`
                                    }
                                    , "type" to type.value, "label-format" to labelFormat.value, "disabled" to isDisabled.value), null, 8, _uA(
                                        "modelValue",
                                        "onUpdate:modelValue",
                                        "type",
                                        "label-format",
                                        "disabled"
                                    )),
                                    _cV(_component_cl_list, _uM("border" to "", "pt" to object : UTSJSONObject() {
                                        var className = "mt-3"
                                    }), _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                                        return _uA(
                                            _cV(_component_cl_list_item, _uM("label" to "YYYY"), _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                                                return _uA(
                                                    _cV(_component_cl_switch, _uM("modelValue" to isYear.value, "onUpdate:modelValue" to fun(`$event`: Boolean){
                                                        isYear.value = `$event`
                                                    }
                                                    ), null, 8, _uA(
                                                        "modelValue",
                                                        "onUpdate:modelValue"
                                                    ))
                                                )
                                            }
                                            ), "_" to 1)),
                                            _cV(_component_cl_list_item, _uM("label" to "YYYY-MM"), _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                                                return _uA(
                                                    _cV(_component_cl_switch, _uM("modelValue" to isMonth.value, "onUpdate:modelValue" to fun(`$event`: Boolean){
                                                        isMonth.value = `$event`
                                                    }
                                                    ), null, 8, _uA(
                                                        "modelValue",
                                                        "onUpdate:modelValue"
                                                    ))
                                                )
                                            }
                                            ), "_" to 1)),
                                            _cV(_component_cl_list_item, _uM("label" to "YYYY-MM-DD", "pt" to object : UTSJSONObject() {
                                                var label = object : UTSJSONObject() {
                                                    var className = "flex--bracket-start-2-bracket-end-"
                                                }
                                            }), _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                                                return _uA(
                                                    _cV(_component_cl_switch, _uM("modelValue" to isDate.value, "onUpdate:modelValue" to fun(`$event`: Boolean){
                                                        isDate.value = `$event`
                                                    }
                                                    ), null, 8, _uA(
                                                        "modelValue",
                                                        "onUpdate:modelValue"
                                                    ))
                                                )
                                            }
                                            ), "_" to 1)),
                                            _cV(_component_cl_list_item, _uM("label" to "YYYY-MM-DD HH", "pt" to object : UTSJSONObject() {
                                                var label = object : UTSJSONObject() {
                                                    var className = "flex--bracket-start-2-bracket-end-"
                                                }
                                            }), _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
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
                                            ), "_" to 1)),
                                            _cV(_component_cl_list_item, _uM("label" to "YYYY-MM-DD HH:mm", "pt" to object : UTSJSONObject() {
                                                var label = object : UTSJSONObject() {
                                                    var className = "flex--bracket-start-2-bracket-end-"
                                                }
                                            }), _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
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
                                            ), "_" to 1)),
                                            _cV(_component_cl_list_item, _uM("label" to "YYYY-MM-DD HH:mm:ss", "pt" to object : UTSJSONObject() {
                                                var label = object : UTSJSONObject() {
                                                    var className = "flex--bracket-start-2-bracket-end-"
                                                }
                                            }), _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
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
                                            ), "_" to 1)),
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
