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
open class GenPagesDemoFormCascader : BasePage {
    constructor(__ins: ComponentInternalInstance, __renderer: String?) : super(__ins, __renderer) {
        onPageScroll(fun(e: OnPageScrollOptions) {
            scroller.emit(e.scrollTop)
        }
        , __ins)
        onPageShow(fun() {}, __ins)
    }
    companion object {
        @Suppress("UNUSED_PARAMETER", "UNUSED_VARIABLE")
        var setup: (__props: GenPagesDemoFormCascader) -> Any? = fun(__props): Any? {
            val __ins = getCurrentInstance()!!
            val _ctx = __ins.proxy as GenPagesDemoFormCascader
            val _cache = __ins.renderCache
            val form = reactive<Form4>(Form4(cascader1 = _uA(), cascader2 = _uA(), cascader3 = _uA()))
            val isDisabled = ref(false)
            val isSeparator = ref(false)
            val isHeight = ref(false)
            val options = ref(_uA<ClCascaderOption>(ClListViewItem(label = "电子产品", value = "1", children = _uA(
                ClListViewItem(label = "手机", value = "1-1", children = _uA(
                    ClListViewItem(label = "苹果", value = "1-1-1", children = _uA(
                        ClListViewItem(label = "iPhone 15 Pro Max", value = "1-1-1-1"),
                        ClListViewItem(label = "iPhone 15 Pro", value = "1-1-1-2"),
                        ClListViewItem(label = "iPhone 15", value = "1-1-1-3"),
                        ClListViewItem(label = "iPhone 14 Pro Max", value = "1-1-1-4"),
                        ClListViewItem(label = "iPhone 14", value = "1-1-1-5")
                    )),
                    ClListViewItem(label = "华为", value = "1-1-2", children = _uA(
                        ClListViewItem(label = "Mate 60 Pro+", value = "1-1-2-1"),
                        ClListViewItem(label = "Mate 60 Pro", value = "1-1-2-2"),
                        ClListViewItem(label = "Mate 60", value = "1-1-2-3"),
                        ClListViewItem(label = "P60 Pro", value = "1-1-2-4"),
                        ClListViewItem(label = "P60", value = "1-1-2-5")
                    )),
                    ClListViewItem(label = "小米", value = "1-1-3", children = _uA(
                        ClListViewItem(label = "小米14 Pro", value = "1-1-3-1"),
                        ClListViewItem(label = "小米14", value = "1-1-3-2"),
                        ClListViewItem(label = "Redmi K70 Pro", value = "1-1-3-3"),
                        ClListViewItem(label = "Redmi K70", value = "1-1-3-4")
                    ))
                )),
                ClListViewItem(label = "电脑", value = "1-2", children = _uA(
                    ClListViewItem(label = "笔记本", value = "1-2-1", children = _uA(
                        ClListViewItem(label = "MacBook Pro 16", value = "1-2-1-1"),
                        ClListViewItem(label = "MacBook Pro 14", value = "1-2-1-2"),
                        ClListViewItem(label = "MacBook Air 15", value = "1-2-1-3"),
                        ClListViewItem(label = "ThinkPad X1", value = "1-2-1-4"),
                        ClListViewItem(label = "ROG 魔霸新锐", value = "1-2-1-5"),
                        ClListViewItem(label = "拯救者 Y9000P", value = "1-2-1-6")
                    )),
                    ClListViewItem(label = "台式机", value = "1-2-2", children = _uA(
                        ClListViewItem(label = "iMac 24寸", value = "1-2-2-1"),
                        ClListViewItem(label = "Mac Studio", value = "1-2-2-2"),
                        ClListViewItem(label = "Mac Pro", value = "1-2-2-3"),
                        ClListViewItem(label = "外星人", value = "1-2-2-4"),
                        ClListViewItem(label = "惠普暗影精灵", value = "1-2-2-5")
                    ))
                )),
                ClListViewItem(label = "平板", value = "1-3", children = _uA(
                    ClListViewItem(label = "iPad", value = "1-3-1", children = _uA(
                        ClListViewItem(label = "iPad Pro 12.9", value = "1-3-1-1"),
                        ClListViewItem(label = "iPad Pro 11", value = "1-3-1-2"),
                        ClListViewItem(label = "iPad Air", value = "1-3-1-3"),
                        ClListViewItem(label = "iPad mini", value = "1-3-1-4")
                    )),
                    ClListViewItem(label = "安卓平板", value = "1-3-2", children = _uA(
                        ClListViewItem(label = "小米平板6 Pro", value = "1-3-2-1"),
                        ClListViewItem(label = "华为MatePad Pro", value = "1-3-2-2"),
                        ClListViewItem(label = "三星Galaxy Tab S9", value = "1-3-2-3")
                    ))
                ))
            )), ClListViewItem(label = "服装", value = "2", children = _uA(
                ClListViewItem(label = "男装", value = "2-1", children = _uA(
                    ClListViewItem(label = "上衣", value = "2-1-1", children = _uA(
                        ClListViewItem(label = "短袖T恤", value = "2-1-1-1"),
                        ClListViewItem(label = "长袖T恤", value = "2-1-1-2"),
                        ClListViewItem(label = "衬衫", value = "2-1-1-3"),
                        ClListViewItem(label = "卫衣", value = "2-1-1-4"),
                        ClListViewItem(label = "夹克", value = "2-1-1-5"),
                        ClListViewItem(label = "毛衣", value = "2-1-1-6")
                    )),
                    ClListViewItem(label = "裤装", value = "2-1-2", children = _uA(
                        ClListViewItem(label = "牛仔裤", value = "2-1-2-1"),
                        ClListViewItem(label = "休闲裤", value = "2-1-2-2"),
                        ClListViewItem(label = "运动裤", value = "2-1-2-3"),
                        ClListViewItem(label = "西裤", value = "2-1-2-4"),
                        ClListViewItem(label = "短裤", value = "2-1-2-5")
                    )),
                    ClListViewItem(label = "外套", value = "2-1-3", children = _uA(
                        ClListViewItem(label = "羽绒服", value = "2-1-3-1"),
                        ClListViewItem(label = "大衣", value = "2-1-3-2"),
                        ClListViewItem(label = "夹克", value = "2-1-3-3"),
                        ClListViewItem(label = "西装", value = "2-1-3-4")
                    ))
                )),
                ClListViewItem(label = "女装", value = "2-2", children = _uA(
                    ClListViewItem(label = "裙装", value = "2-2-1", children = _uA(
                        ClListViewItem(label = "连衣裙", value = "2-2-1-1"),
                        ClListViewItem(label = "半身裙", value = "2-2-1-2"),
                        ClListViewItem(label = "A字裙", value = "2-2-1-3"),
                        ClListViewItem(label = "包臀裙", value = "2-2-1-4"),
                        ClListViewItem(label = "百褶裙", value = "2-2-1-5")
                    )),
                    ClListViewItem(label = "上装", value = "2-2-2", children = _uA(
                        ClListViewItem(label = "衬衫", value = "2-2-2-1"),
                        ClListViewItem(label = "T恤", value = "2-2-2-2"),
                        ClListViewItem(label = "毛衣", value = "2-2-2-3"),
                        ClListViewItem(label = "卫衣", value = "2-2-2-4"),
                        ClListViewItem(label = "雪纺衫", value = "2-2-2-5")
                    )),
                    ClListViewItem(label = "外套", value = "2-2-3", children = _uA(
                        ClListViewItem(label = "风衣", value = "2-2-3-1"),
                        ClListViewItem(label = "羽绒服", value = "2-2-3-2"),
                        ClListViewItem(label = "大衣", value = "2-2-3-3"),
                        ClListViewItem(label = "西装", value = "2-2-3-4"),
                        ClListViewItem(label = "皮衣", value = "2-2-3-5")
                    ))
                ))
            )), ClListViewItem(label = "食品", value = "3", children = _uA(
                ClListViewItem(label = "水果", value = "3-1", children = _uA(
                    ClListViewItem(label = "苹果", value = "3-1-1"),
                    ClListViewItem(label = "香蕉", value = "3-1-2"),
                    ClListViewItem(label = "橘子", value = "3-1-3")
                )),
                ClListViewItem(label = "蔬菜", value = "3-2", children = _uA(
                    ClListViewItem(label = "西红柿", value = "3-2-1"),
                    ClListViewItem(label = "黄瓜", value = "3-2-2"),
                    ClListViewItem(label = "胡萝卜", value = "3-2-3")
                ))
            )), ClListViewItem(label = "饮料", value = "4", children = _uA(
                ClListViewItem(label = "果汁", value = "4-1", children = _uA(
                    ClListViewItem(label = "苹果汁", value = "4-1-1"),
                    ClListViewItem(label = "橙汁", value = "4-1-2"),
                    ClListViewItem(label = "葡萄汁", value = "4-1-3"),
                    ClListViewItem(label = "西瓜汁", value = "4-1-4")
                ))
            ))))
            val options2 = useCascader(default1)
            return fun(): Any? {
                val _component_cl_cascader = resolveEasyComponent("cl-cascader", GenUniModulesCoolUiComponentsClCascaderClCascaderClass)
                val _component_cl_switch = resolveEasyComponent("cl-switch", GenUniModulesCoolUiComponentsClSwitchClSwitchClass)
                val _component_cl_list_item = resolveEasyComponent("cl-list-item", GenUniModulesCoolUiComponentsClListItemClListItemClass)
                val _component_cl_list = resolveEasyComponent("cl-list", GenUniModulesCoolUiComponentsClListClListClass)
                val _component_cl_page = resolveEasyComponent("cl-page", GenUniModulesCoolUiComponentsClPageClPageClass)
                return _cV(_component_cl_page, null, _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                    return _uA(
                        _cE("view", _uM("class" to "p-3"), _uA(
                            _cV(unref(GenPagesDemoComponentsItemClass), _uM("label" to unref(t)("基础用法")), _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                                return _uA(
                                    _cV(_component_cl_cascader, _uM("modelValue" to form.cascader1, "onUpdate:modelValue" to fun(`$event`: UTSArray<String>){
                                        form.cascader1 = `$event`
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
                            _cV(unref(GenPagesDemoComponentsItemClass), _uM("label" to unref(t)("带索引、地区选择")), _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                                return _uA(
                                    _cV(_component_cl_cascader, _uM("modelValue" to form.cascader2, "onUpdate:modelValue" to fun(`$event`: UTSArray<String>){
                                        form.cascader2 = `$event`
                                    }
                                    , "options" to unref(options2)), null, 8, _uA(
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
                                    _cV(_component_cl_cascader, _uM("modelValue" to form.cascader3, "onUpdate:modelValue" to fun(`$event`: UTSArray<String>){
                                        form.cascader3 = `$event`
                                    }
                                    , "options" to options.value, "disabled" to isDisabled.value, "text-separator" to if (isSeparator.value) {
                                        " / "
                                    } else {
                                        " - "
                                    }
                                    , "height" to if (isHeight.value) {
                                        500
                                    } else {
                                        800
                                    }
                                    ), null, 8, _uA(
                                        "modelValue",
                                        "onUpdate:modelValue",
                                        "options",
                                        "disabled",
                                        "text-separator",
                                        "height"
                                    )),
                                    _cV(_component_cl_list, _uM("border" to "", "pt" to object : UTSJSONObject() {
                                        var className = "mt-3"
                                    }), _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                                        return _uA(
                                            _cV(_component_cl_list_item, _uM("label" to unref(t)("换个分隔符")), _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                                                return _uA(
                                                    _cV(_component_cl_switch, _uM("modelValue" to isSeparator.value, "onUpdate:modelValue" to fun(`$event`: Boolean){
                                                        isSeparator.value = `$event`
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
                                            _cV(_component_cl_list_item, _uM("label" to unref(t)("列表高度小一点")), _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                                                return _uA(
                                                    _cV(_component_cl_switch, _uM("modelValue" to isHeight.value, "onUpdate:modelValue" to fun(`$event`: Boolean){
                                                        isHeight.value = `$event`
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
