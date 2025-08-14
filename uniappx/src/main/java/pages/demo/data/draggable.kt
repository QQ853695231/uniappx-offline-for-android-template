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
open class GenPagesDemoDataDraggable : BasePage {
    constructor(__ins: ComponentInternalInstance, __renderer: String?) : super(__ins, __renderer) {
        onPageScroll(fun(e: OnPageScrollOptions) {
            scroller.emit(e.scrollTop)
        }
        , __ins)
        onPageShow(fun() {}, __ins)
    }
    companion object {
        @Suppress("UNUSED_PARAMETER", "UNUSED_VARIABLE")
        var setup: (__props: GenPagesDemoDataDraggable) -> Any? = fun(__props): Any? {
            val __ins = getCurrentInstance()!!
            val _ctx = __ins.proxy as GenPagesDemoDataDraggable
            val _cache = __ins.renderCache
            val list = ref(_uA<UTSJSONObject>(object : UTSJSONObject() {
                var label = "明月几时有，把酒问青天"
            }, object : UTSJSONObject() {
                var label = "不知天上宫阙，今夕是何年"
                var disabled = true
            }, object : UTSJSONObject() {
                var label = "我欲乘风归去，又恐琼楼玉宇"
            }, object : UTSJSONObject() {
                var label = "高处不胜寒，起舞弄清影"
            }, object : UTSJSONObject() {
                var label = "何似在人间"
            }))
            val list2 = ref(_uA<UTSJSONObject>(object : UTSJSONObject() {
                var label = "明月几时有，把酒问青天"
            }, object : UTSJSONObject() {
                var label = "不知天上宫阙，今夕是何年"
            }, object : UTSJSONObject() {
                var label = "我欲乘风归去，又恐琼楼玉宇"
            }, object : UTSJSONObject() {
                var label = "高处不胜寒，起舞弄清影"
            }, object : UTSJSONObject() {
                var label = "何似在人间"
            }))
            val list3 = ref(_uA<UTSJSONObject>(object : UTSJSONObject() {
                var label = "项目1"
            }, object : UTSJSONObject() {
                var label = "项目2"
            }, object : UTSJSONObject() {
                var label = "项目3"
            }, object : UTSJSONObject() {
                var label = "项目4"
            }, object : UTSJSONObject() {
                var label = "项目5"
            }, object : UTSJSONObject() {
                var label = "项目6"
            }, object : UTSJSONObject() {
                var label = "项目7"
            }, object : UTSJSONObject() {
                var label = "项目8"
                var disabled = true
            }, object : UTSJSONObject() {
                var label = "项目9"
            }, object : UTSJSONObject() {
                var label = "项目10"
            }, object : UTSJSONObject() {
                var label = "项目11"
            }, object : UTSJSONObject() {
                var label = "项目12"
            }))
            val list4 = ref(_uA<UTSJSONObject>(object : UTSJSONObject() {
                var url = "https://unix.cool-js.com/images/demo/1.jpg"
            }, object : UTSJSONObject() {
                var url = "https://unix.cool-js.com/images/demo/2.jpg"
            }, object : UTSJSONObject() {
                var url = "https://unix.cool-js.com/images/demo/3.jpg"
            }, object : UTSJSONObject() {
                var url = "https://unix.cool-js.com/images/demo/4.jpg"
            }, object : UTSJSONObject() {
                var url = "https://unix.cool-js.com/images/demo/5.jpg"
            }, object : UTSJSONObject() {
                var url = "https://unix.cool-js.com/images/demo/6.jpg"
            }, object : UTSJSONObject() {
                var url = "https://unix.cool-js.com/images/demo/7.jpg"
            }))
            return fun(): Any? {
                val _component_cl_text = resolveEasyComponent("cl-text", GenUniModulesCoolUiComponentsClTextClTextClass)
                val _component_cl_draggable = resolveEasyComponent("cl-draggable", GenUniModulesCoolUiComponentsClDraggableClDraggableClass)
                val _component_cl_list_item = resolveEasyComponent("cl-list-item", GenUniModulesCoolUiComponentsClListItemClListItemClass)
                val _component_cl_list = resolveEasyComponent("cl-list", GenUniModulesCoolUiComponentsClListClListClass)
                val _component_cl_image = resolveEasyComponent("cl-image", GenUniModulesCoolUiComponentsClImageClImageClass)
                val _component_cl_page = resolveEasyComponent("cl-page", GenUniModulesCoolUiComponentsClPageClPageClass)
                return _cV(_component_cl_page, null, _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                    return _uA(
                        _cE("view", _uM("class" to "p-3 overflow-visible"), _uA(
                            _cV(unref(GenPagesDemoComponentsItemClass), _uM("label" to unref(t)("单列排序")), _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                                return _uA(
                                    _cV(_component_cl_draggable, _uM("modelValue" to list.value, "onUpdate:modelValue" to fun(`$event`: UTSArray<UTSJSONObject>){
                                        list.value = `$event`
                                    }
                                    ), _uM("item" to withScopedSlotCtx(fun(slotProps: GenUniModulesCoolUiComponentsClDraggableClDraggableSlotDataItem): UTSArray<Any> {
                                        val item = slotProps.item
                                        val index = slotProps.index
                                        return _uA(
                                            _cE("view", _uM("class" to _nC(_uA(
                                                "flex flex-row items-center p-3 bg-surface-100 rounded-lg mb-2",
                                                _uM("dark-colon--important-bg-surface-700" to unref(isDark), "opacity-50" to item["disabled"])
                                            ))), _uA(
                                                _cV(_component_cl_text, null, _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                                                    return _uA(
                                                        _tD((item as UTSJSONObject)["label"])
                                                    )
                                                }
                                                ), "_" to 2), 1024)
                                            ), 2)
                                        )
                                    }
                                    ), "_" to 1), 8, _uA(
                                        "modelValue",
                                        "onUpdate:modelValue"
                                    ))
                                )
                            }
                            ), "_" to 1), 8, _uA(
                                "label"
                            )),
                            _cV(unref(GenPagesDemoComponentsItemClass), _uM("label" to unref(t)("结合列表使用")), _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                                return _uA(
                                    _cV(_component_cl_list, _uM("border" to ""), _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                                        return _uA(
                                            _cV(_component_cl_draggable, _uM("modelValue" to list2.value, "onUpdate:modelValue" to fun(`$event`: UTSArray<UTSJSONObject>){
                                                list2.value = `$event`
                                            }
                                            ), _uM("item" to withScopedSlotCtx(fun(slotProps: GenUniModulesCoolUiComponentsClDraggableClDraggableSlotDataItem): UTSArray<Any> {
                                                val item = slotProps.item
                                                val index = slotProps.index
                                                val dragging = slotProps.dragging
                                                val dragIndex = slotProps.dragIndex
                                                return _uA(
                                                    _cV(_component_cl_list_item, _uM("icon" to "chat-thread-line", "label" to (item as UTSJSONObject)["label"], "arrow" to "", "pt" to object : UTSJSONObject() {
                                                        var inner = object : UTSJSONObject() {
                                                            var className = if (dragging && dragIndex == index) {
                                                                "-important-bg-surface-100"
                                                            } else {
                                                                ""
                                                            }
                                                        }
                                                    }), null, 8, _uA(
                                                        "label",
                                                        "pt"
                                                    ))
                                                )
                                            }
                                            ), "_" to 1), 8, _uA(
                                                "modelValue",
                                                "onUpdate:modelValue"
                                            ))
                                        )
                                    }
                                    ), "_" to 1))
                                )
                            }
                            ), "_" to 1), 8, _uA(
                                "label"
                            )),
                            _cV(unref(GenPagesDemoComponentsItemClass), _uM("label" to unref(t)("多列排序")), _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                                return _uA(
                                    _cV(_component_cl_draggable, _uM("modelValue" to list3.value, "onUpdate:modelValue" to fun(`$event`: UTSArray<UTSJSONObject>){
                                        list3.value = `$event`
                                    }
                                    , "columns" to 4), _uM("item" to withScopedSlotCtx(fun(slotProps: GenUniModulesCoolUiComponentsClDraggableClDraggableSlotDataItem): UTSArray<Any> {
                                        val item = slotProps.item
                                        val index = slotProps.index
                                        return _uA(
                                            _cE("view", _uM("class" to _nC(_uA(
                                                "flex flex-row items-center justify-center p-3 bg-surface-100 rounded-lg m-1",
                                                _uM("dark-colon--important-bg-surface-700" to unref(isDark), "opacity-50" to item["disabled"])
                                            ))), _uA(
                                                _cV(_component_cl_text, null, _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                                                    return _uA(
                                                        _tD((item as UTSJSONObject)["label"])
                                                    )
                                                }
                                                ), "_" to 2), 1024)
                                            ), 2)
                                        )
                                    }
                                    ), "_" to 1), 8, _uA(
                                        "modelValue",
                                        "onUpdate:modelValue"
                                    ))
                                )
                            }
                            ), "_" to 1), 8, _uA(
                                "label"
                            )),
                            _cV(unref(GenPagesDemoComponentsItemClass), _uM("label" to unref(t)("结合图片使用")), _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                                return _uA(
                                    _cV(_component_cl_draggable, _uM("modelValue" to list4.value, "onUpdate:modelValue" to fun(`$event`: UTSArray<UTSJSONObject>){
                                        list4.value = `$event`
                                    }
                                    , "columns" to 4), _uM("item" to withScopedSlotCtx(fun(slotProps: GenUniModulesCoolUiComponentsClDraggableClDraggableSlotDataItem): UTSArray<Any> {
                                        val item = slotProps.item
                                        val index = slotProps.index
                                        return _uA(
                                            _cE("view", _uM("class" to "p--bracket-start-2px-bracket-end-"), _uA(
                                                _cV(_component_cl_image, _uM("src" to (item as UTSJSONObject)["url"], "mode" to "widthFix", "pt" to object : UTSJSONObject() {
                                                    var className = "-important-w-full"
                                                }, "preview" to ""), null, 8, _uA(
                                                    "src"
                                                ))
                                            ))
                                        )
                                    }
                                    ), "_" to 1), 8, _uA(
                                        "modelValue",
                                        "onUpdate:modelValue"
                                    ))
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
