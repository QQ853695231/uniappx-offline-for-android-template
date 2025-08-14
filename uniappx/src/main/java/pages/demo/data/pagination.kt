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
open class GenPagesDemoDataPagination : BasePage {
    constructor(__ins: ComponentInternalInstance, __renderer: String?) : super(__ins, __renderer) {
        onPageScroll(fun(e: OnPageScrollOptions) {
            scroller.emit(e.scrollTop)
        }
        , __ins)
        onPageShow(fun() {}, __ins)
    }
    companion object {
        @Suppress("UNUSED_PARAMETER", "UNUSED_VARIABLE")
        var setup: (__props: GenPagesDemoDataPagination) -> Any? = fun(__props): Any? {
            val __ins = getCurrentInstance()!!
            val _ctx = __ins.proxy as GenPagesDemoDataPagination
            val _cache = __ins.renderCache
            val page1 = ref(1)
            val page2 = ref(13)
            val page3 = ref(1)
            val page4 = ref(1)
            return fun(): Any? {
                val _component_cl_pagination = resolveEasyComponent("cl-pagination", GenUniModulesCoolUiComponentsClPaginationClPaginationClass)
                val _component_cl_text = resolveEasyComponent("cl-text", GenUniModulesCoolUiComponentsClTextClTextClass)
                val _component_cl_page = resolveEasyComponent("cl-page", GenUniModulesCoolUiComponentsClPageClPageClass)
                return _cV(_component_cl_page, null, _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                    return _uA(
                        _cE("view", _uM("class" to "p-3"), _uA(
                            _cV(unref(GenPagesDemoComponentsItemClass), _uM("label" to unref(t)("基础用法")), _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                                return _uA(
                                    _cV(_component_cl_pagination, _uM("modelValue" to page1.value, "onUpdate:modelValue" to fun(`$event`: Number){
                                        page1.value = `$event`
                                    }
                                    , "total" to 24), null, 8, _uA(
                                        "modelValue",
                                        "onUpdate:modelValue"
                                    ))
                                )
                            }
                            ), "_" to 1), 8, _uA(
                                "label"
                            )),
                            _cV(unref(GenPagesDemoComponentsItemClass), _uM("label" to unref(t)("多页数")), _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                                return _uA(
                                    _cV(_component_cl_pagination, _uM("modelValue" to page2.value, "onUpdate:modelValue" to fun(`$event`: Number){
                                        page2.value = `$event`
                                    }
                                    , "total" to 500), null, 8, _uA(
                                        "modelValue",
                                        "onUpdate:modelValue"
                                    ))
                                )
                            }
                            ), "_" to 1), 8, _uA(
                                "label"
                            )),
                            _cV(unref(GenPagesDemoComponentsItemClass), _uM("label" to unref(t)("自定义样式")), _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                                return _uA(
                                    _cV(_component_cl_pagination, _uM("modelValue" to page3.value, "onUpdate:modelValue" to fun(`$event`: Number){
                                        page3.value = `$event`
                                    }
                                    , "total" to 100, "pt" to object : UTSJSONObject() {
                                        var item = object : UTSJSONObject() {
                                            var className = "-important-rounded-none -important-mx--bracket-start-2rpx-bracket-end-"
                                        }
                                    }), null, 8, _uA(
                                        "modelValue",
                                        "onUpdate:modelValue"
                                    ))
                                )
                            }
                            ), "_" to 1), 8, _uA(
                                "label"
                            )),
                            _cV(unref(GenPagesDemoComponentsItemClass), _uM("label" to unref(t)("自定义文本")), _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                                return _uA(
                                    _cV(_component_cl_pagination, _uM("modelValue" to page4.value, "onUpdate:modelValue" to fun(`$event`: Number){
                                        page4.value = `$event`
                                    }
                                    , "total" to 24, "pt" to object : UTSJSONObject() {
                                        var prev = object : UTSJSONObject() {
                                            var className = "-important-w-auto px-3"
                                        }
                                        var next = object : UTSJSONObject() {
                                            var className = "-important-w-auto px-3"
                                        }
                                    }), _uM("prev" to withSlotCtx(fun(): UTSArray<Any> {
                                        return _uA(
                                            _cV(_component_cl_text, _uM("pt" to object : UTSJSONObject() {
                                                var className = "-important-text-sm"
                                            }), _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                                                return _uA(
                                                    _tD(unref(t)("上一页"))
                                                )
                                            }
                                            ), "_" to 1))
                                        )
                                    }
                                    ), "next" to withSlotCtx(fun(): UTSArray<Any> {
                                        return _uA(
                                            _cV(_component_cl_text, _uM("pt" to object : UTSJSONObject() {
                                                var className = "-important-text-sm"
                                            }), _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                                                return _uA(
                                                    _tD(unref(t)("下一页"))
                                                )
                                            }
                                            ), "_" to 1))
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
