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
open class GenPagesDemoLayoutSticky : BasePage {
    constructor(__ins: ComponentInternalInstance, __renderer: String?) : super(__ins, __renderer) {
        onPageScroll(fun(e: OnPageScrollOptions) {
            scroller.emit(e.scrollTop)
        }
        , __ins)
        onPageShow(fun() {}, __ins)
    }
    companion object {
        @Suppress("UNUSED_PARAMETER", "UNUSED_VARIABLE")
        var setup: (__props: GenPagesDemoLayoutSticky) -> Any? = fun(__props): Any? {
            val __ins = getCurrentInstance()!!
            val _ctx = __ins.proxy as GenPagesDemoLayoutSticky
            val _cache = __ins.renderCache
            return fun(): Any? {
                val _component_cl_text = resolveEasyComponent("cl-text", GenUniModulesCoolUiComponentsClTextClTextClass)
                val _component_cl_sticky = resolveEasyComponent("cl-sticky", GenUniModulesCoolUiComponentsClStickyClStickyClass)
                val _component_cl_list_item = resolveEasyComponent("cl-list-item", GenUniModulesCoolUiComponentsClListItemClListItemClass)
                val _component_cl_list = resolveEasyComponent("cl-list", GenUniModulesCoolUiComponentsClListClListClass)
                val _component_cl_page = resolveEasyComponent("cl-page", GenUniModulesCoolUiComponentsClPageClPageClass)
                return _cV(_component_cl_page, _uM("back-top" to ""), _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                    return _uA(
                        _cV(_component_cl_sticky, null, _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                            return _uA(
                                _cE("view", _uM("class" to "bg-primary-500 p-3 h--bracket-start-40px-bracket-end- flex flex-row items-center"), _uA(
                                    _cV(_component_cl_text, _uM("color" to "white"), _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                                        return _uA(
                                            "Header - 1"
                                        )
                                    }
                                    ), "_" to 1))
                                ))
                            )
                        }
                        ), "_" to 1)),
                        _cE("view", _uM("class" to "p-3"), _uA(
                            _cV(_component_cl_list, null, _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                                return _uA(
                                    _cE(Fragment, null, RenderHelpers.renderList(50, fun(i, __key, __index, _cached): Any {
                                        return _cV(_component_cl_list_item, _uM("label" to ("" + i), "key" to i), null, 8, _uA(
                                            "label"
                                        ))
                                    }
                                    ), 64)
                                )
                            }
                            ), "_" to 1))
                        )),
                        _cV(_component_cl_sticky, _uM("offset-top" to 40), _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                            return _uA(
                                _cE("view", _uM("class" to "bg-red-500 p-3 h--bracket-start-40px-bracket-end- flex flex-row items-center"), _uA(
                                    _cV(_component_cl_text, _uM("color" to "white"), _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                                        return _uA(
                                            "Header - 2"
                                        )
                                    }
                                    ), "_" to 1))
                                ))
                            )
                        }
                        ), "_" to 1)),
                        _cE("view", _uM("class" to "p-3"), _uA(
                            _cV(_component_cl_list, null, _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                                return _uA(
                                    _cE(Fragment, null, RenderHelpers.renderList(50, fun(i, __key, __index, _cached): Any {
                                        return _cV(_component_cl_list_item, _uM("label" to ("" + i), "key" to i), null, 8, _uA(
                                            "label"
                                        ))
                                    }
                                    ), 64)
                                )
                            }
                            ), "_" to 1))
                        )),
                        _cV(_component_cl_sticky, _uM("offset-top" to 80), _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                            return _uA(
                                _cE("view", _uM("class" to "bg-purple-500 p-3 h--bracket-start-40px-bracket-end- flex flex-row items-center"), _uA(
                                    _cV(_component_cl_text, _uM("color" to "white"), _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                                        return _uA(
                                            "Header - 3"
                                        )
                                    }
                                    ), "_" to 1))
                                ))
                            )
                        }
                        ), "_" to 1)),
                        _cE("view", _uM("class" to "p-3"), _uA(
                            _cV(_component_cl_list, null, _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                                return _uA(
                                    _cE(Fragment, null, RenderHelpers.renderList(50, fun(i, __key, __index, _cached): Any {
                                        return _cV(_component_cl_list_item, _uM("label" to ("" + i), "key" to i), null, 8, _uA(
                                            "label"
                                        ))
                                    }
                                    ), 64)
                                )
                            }
                            ), "_" to 1))
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
