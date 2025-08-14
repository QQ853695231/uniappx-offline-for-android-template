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
open class GenPagesDemoFormSelect : BasePage {
    constructor(__ins: ComponentInternalInstance, __renderer: String?) : super(__ins, __renderer) {
        onPageScroll(fun(e: OnPageScrollOptions) {
            scroller.emit(e.scrollTop)
        }
        , __ins)
        onPageShow(fun() {}, __ins)
    }
    companion object {
        @Suppress("UNUSED_PARAMETER", "UNUSED_VARIABLE")
        var setup: (__props: GenPagesDemoFormSelect) -> Any? = fun(__props): Any? {
            val __ins = getCurrentInstance()!!
            val _ctx = __ins.proxy as GenPagesDemoFormSelect
            val _cache = __ins.renderCache
            val ui = useUi()
            val selectRef2 = ref<ClSelectComponentPublicInstance?>(null)
            val isShowCancel = ref(true)
            val isButtonText = ref(false)
            val isDisabled = ref(false)
            val isShowValue = ref(false)
            val form = reactive<Form1>(Form1(selected = 1, selected2 = "2", selected3 = _uA(), selected4 = 3))
            val options = ref(_uA<ClSelectOption>(ClSelectOption(label = "HTML", value = 1), ClSelectOption(label = "CSS", value = 2), ClSelectOption(label = "JavaScript", value = 3), ClSelectOption(label = "Node", value = 4), ClSelectOption(label = "Vite", value = 5), ClSelectOption(label = "Webpack", value = 6)))
            val options2 = ref(_uA<ClSelectOption>(ClSelectOption(label = "Vue", value = "1"), ClSelectOption(label = "React", value = "2"), ClSelectOption(label = "Angular", value = "3"), ClSelectOption(label = "Svelte", value = "4")))
            val options3 = ref(_uA<ClSelectOption>(ClSelectOption(label = "福建省", value = 1, children = _uA(
                ClSelectOption(label = "福州市", value = 1, children = _uA(
                    ClSelectOption(label = "鼓楼区", value = 1),
                    ClSelectOption(label = "台江区", value = 2),
                    ClSelectOption(label = "仓山区", value = 3),
                    ClSelectOption(label = "马尾区", value = 4)
                )),
                ClSelectOption(label = "厦门市", value = 2, children = _uA(
                    ClSelectOption(label = "思明区", value = 1),
                    ClSelectOption(label = "湖里区", value = 2),
                    ClSelectOption(label = "集美区", value = 3),
                    ClSelectOption(label = "海沧区", value = 4)
                )),
                ClSelectOption(label = "泉州市", value = 3, children = _uA(
                    ClSelectOption(label = "鲤城区", value = 1),
                    ClSelectOption(label = "丰泽区", value = 2),
                    ClSelectOption(label = "洛江区", value = 3),
                    ClSelectOption(label = "泉港区", value = 4)
                ))
            )), ClSelectOption(label = "浙江省", value = 2, children = _uA(
                ClSelectOption(label = "杭州市", value = 1, children = _uA(
                    ClSelectOption(label = "上城区", value = 1),
                    ClSelectOption(label = "下城区", value = 2),
                    ClSelectOption(label = "江干区", value = 3),
                    ClSelectOption(label = "拱墅区", value = 4)
                )),
                ClSelectOption(label = "宁波市", value = 2, children = _uA(
                    ClSelectOption(label = "海曙区", value = 1),
                    ClSelectOption(label = "江北区", value = 2),
                    ClSelectOption(label = "北仑区", value = 3)
                ))
            )), ClSelectOption(label = "湖南省", value = 3, children = _uA(
                ClSelectOption(label = "长沙市", value = 1, children = _uA(
                    ClSelectOption(label = "芙蓉区", value = 1),
                    ClSelectOption(label = "天心区", value = 2),
                    ClSelectOption(label = "岳麓区", value = 3)
                )),
                ClSelectOption(label = "株洲市", value = 2, children = _uA(
                    ClSelectOption(label = "荷塘区", value = 1),
                    ClSelectOption(label = "芦淞区", value = 2)
                ))
            )), ClSelectOption(label = "江西省", value = 4, children = _uA(
                ClSelectOption(label = "南昌市", value = 1, children = _uA(
                    ClSelectOption(label = "东湖区", value = 1),
                    ClSelectOption(label = "西湖区", value = 2),
                    ClSelectOption(label = "青云谱区", value = 3)
                )),
                ClSelectOption(label = "九江市", value = 2, children = _uA(
                    ClSelectOption(label = "浔阳区", value = 1),
                    ClSelectOption(label = "濂溪区", value = 2)
                ))
            ))))
            fun gen_openSelect2_fn() {
                selectRef2.value!!.open(fun(value){
                    val d = options2.value.find(fun(item): Boolean {
                        return item.value == value
                    }
                    )
                    ui.showToast(ClToastOptions(message = "\u4F60\u9009\u62E9\u4E86 " + value + " : " + d?.label))
                }
                )
            }
            val openSelect2 = ::gen_openSelect2_fn
            return fun(): Any? {
                val _component_cl_select = resolveEasyComponent("cl-select", GenUniModulesCoolUiComponentsClSelectClSelectClass)
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
                                    _cV(_component_cl_select, _uM("modelValue" to form.selected, "onUpdate:modelValue" to fun(`$event`: Number?){
                                        form.selected = `$event`
                                    }
                                    , "options" to options.value), null, 8, _uA(
                                        "modelValue",
                                        "onUpdate:modelValue",
                                        "options"
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
                                    _cV(_component_cl_select, _uM("ref_key" to "selectRef2", "ref" to selectRef2, "modelValue" to form.selected2, "onUpdate:modelValue" to fun(`$event`: String){
                                        form.selected2 = `$event`
                                    }
                                    , "options" to options2.value, "show-trigger" to false), null, 8, _uA(
                                        "modelValue",
                                        "onUpdate:modelValue",
                                        "options"
                                    ))
                                )
                            }
                            ), "_" to 1), 8, _uA(
                                "label"
                            )),
                            _cV(unref(GenPagesDemoComponentsItemClass), _uM("label" to unref(t)("多列")), _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                                return _uA(
                                    _cV(unref(GenPagesDemoComponentsTipsClass), null, _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                                        return _uA(
                                            _tD(unref(t)("通过 children 配置多级数据，并使用 column-count 参数指定显示的列数"))
                                        )
                                    }
                                    ), "_" to 1)),
                                    _cV(_component_cl_select, _uM("modelValue" to form.selected3, "onUpdate:modelValue" to fun(`$event`: UTSArray<Number>){
                                        form.selected3 = `$event`
                                    }
                                    , "options" to options3.value, "column-count" to 3), null, 8, _uA(
                                        "modelValue",
                                        "onUpdate:modelValue",
                                        "options"
                                    ))
                                )
                            }
                            ), "_" to 1), 8, _uA(
                                "label"
                            )),
                            _cV(unref(GenPagesDemoComponentsItemClass), _uM("label" to unref(t)("自定义")), _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                                return _uA(
                                    if (isTrue(form.selected4 != null && isShowValue.value)) {
                                        _cV(_component_cl_text, _uM("key" to 0, "pt" to object : UTSJSONObject() {
                                            var className = "mb-3 -important-text-sm p-3 bg-surface-100  rounded-lg"
                                        }, "class" to _nC(_uM("dark-colon--important-bg-surface-700" to unref(isDark)))), _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                                            return _uA(
                                                _tD(unref(t)("绑定值")) + "：" + _tD(form.selected4)
                                            )
                                        }), "_" to 1), 8, _uA(
                                            "class"
                                        ))
                                    } else {
                                        _cC("v-if", true)
                                    }
                                    ,
                                    _cV(_component_cl_select, _uM("modelValue" to form.selected4, "onUpdate:modelValue" to fun(`$event`: Number?){
                                        form.selected4 = `$event`
                                    }
                                    , "options" to options.value, "disabled" to isDisabled.value, "show-cancel" to isShowCancel.value, "confirm-text" to if (isButtonText.value) {
                                        unref(t)("下一步")
                                    } else {
                                        unref(t)("确定")
                                    }
                                    , "cancel-text" to if (isButtonText.value) {
                                        unref(t)("关闭")
                                    } else {
                                        unref(t)("取消")
                                    }
                                    ), null, 8, _uA(
                                        "modelValue",
                                        "onUpdate:modelValue",
                                        "options",
                                        "disabled",
                                        "show-cancel",
                                        "confirm-text",
                                        "cancel-text"
                                    )),
                                    _cV(_component_cl_list, _uM("border" to "", "pt" to object : UTSJSONObject() {
                                        var className = "mt-3"
                                    }), _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                                        return _uA(
                                            _cV(_component_cl_list_item, _uM("label" to unref(t)("显示取消按钮")), _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                                                return _uA(
                                                    _cV(_component_cl_switch, _uM("modelValue" to isShowCancel.value, "onUpdate:modelValue" to fun(`$event`: Boolean){
                                                        isShowCancel.value = `$event`
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
                                            _cV(_component_cl_list_item, _uM("label" to unref(t)("修改按钮文案")), _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                                                return _uA(
                                                    _cV(_component_cl_switch, _uM("modelValue" to isButtonText.value, "onUpdate:modelValue" to fun(`$event`: Boolean){
                                                        isButtonText.value = `$event`
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
                                            _cV(_component_cl_list_item, _uM("label" to unref(t)("显示绑定值")), _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
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
