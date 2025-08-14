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
open class GenPagesDemoLayoutFlex : BasePage {
    constructor(__ins: ComponentInternalInstance, __renderer: String?) : super(__ins, __renderer) {
        onPageScroll(fun(e: OnPageScrollOptions) {
            scroller.emit(e.scrollTop)
        }
        , __ins)
        onPageShow(fun() {}, __ins)
    }
    companion object {
        @Suppress("UNUSED_PARAMETER", "UNUSED_VARIABLE")
        var setup: (__props: GenPagesDemoLayoutFlex) -> Any? = fun(__props): Any? {
            val __ins = getCurrentInstance()!!
            val _ctx = __ins.proxy as GenPagesDemoLayoutFlex
            val _cache = __ins.renderCache
            return fun(): Any? {
                val _component_cl_text = resolveEasyComponent("cl-text", GenUniModulesCoolUiComponentsClTextClTextClass)
                val _component_cl_col = resolveEasyComponent("cl-col", GenUniModulesCoolUiComponentsClColClColClass)
                val _component_cl_row = resolveEasyComponent("cl-row", GenUniModulesCoolUiComponentsClRowClRowClass)
                val _component_cl_page = resolveEasyComponent("cl-page", GenUniModulesCoolUiComponentsClPageClPageClass)
                return _cV(_component_cl_page, null, _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                    return _uA(
                        _cE("view", _uM("class" to _nC(_uA(
                            "p-3",
                            _uM("is-dark" to unref(isDark))
                        ))), _uA(
                            _cV(unref(GenPagesDemoComponentsItemClass), _uM("label" to unref(t)("基础用法")), _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                                return _uA(
                                    _cV(_component_cl_row, _uM("gutter" to 12), _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                                        return _uA(
                                            _cV(_component_cl_col, _uM("span" to 8), _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                                                return _uA(
                                                    _cE("view", _uM("class" to "item"), _uA(
                                                        _cV(_component_cl_text, _uM("pt" to object : UTSJSONObject() {
                                                            var className = "text"
                                                        }), _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                                                            return _uA(
                                                                "1"
                                                            )
                                                        }
                                                        ), "_" to 1))
                                                    ))
                                                )
                                            }
                                            ), "_" to 1)),
                                            _cV(_component_cl_col, _uM("span" to 8), _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                                                return _uA(
                                                    _cE("view", _uM("class" to "item"), _uA(
                                                        _cV(_component_cl_text, _uM("pt" to object : UTSJSONObject() {
                                                            var className = "text"
                                                        }), _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                                                            return _uA(
                                                                "2"
                                                            )
                                                        }
                                                        ), "_" to 1))
                                                    ))
                                                )
                                            }
                                            ), "_" to 1)),
                                            _cV(_component_cl_col, _uM("span" to 8), _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                                                return _uA(
                                                    _cE("view", _uM("class" to "item"), _uA(
                                                        _cV(_component_cl_text, _uM("pt" to object : UTSJSONObject() {
                                                            var className = "text"
                                                        }), _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                                                            return _uA(
                                                                "3"
                                                            )
                                                        }
                                                        ), "_" to 1))
                                                    ))
                                                )
                                            }
                                            ), "_" to 1))
                                        )
                                    }
                                    ), "_" to 1)),
                                    _cV(_component_cl_row, _uM("gutter" to 12, "pt" to object : UTSJSONObject() {
                                        var className = "mt-3"
                                    }), _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                                        return _uA(
                                            _cV(_component_cl_col, _uM("span" to 12), _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                                                return _uA(
                                                    _cE("view", _uM("class" to "item"), _uA(
                                                        _cV(_component_cl_text, _uM("pt" to object : UTSJSONObject() {
                                                            var className = "text"
                                                        }), _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                                                            return _uA(
                                                                "1"
                                                            )
                                                        }
                                                        ), "_" to 1))
                                                    ))
                                                )
                                            }
                                            ), "_" to 1)),
                                            _cV(_component_cl_col, _uM("span" to 12), _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                                                return _uA(
                                                    _cE("view", _uM("class" to "item"), _uA(
                                                        _cV(_component_cl_text, _uM("pt" to object : UTSJSONObject() {
                                                            var className = "text"
                                                        }), _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                                                            return _uA(
                                                                "2"
                                                            )
                                                        }
                                                        ), "_" to 1))
                                                    ))
                                                )
                                            }
                                            ), "_" to 1))
                                        )
                                    }
                                    ), "_" to 1)),
                                    _cV(_component_cl_row, _uM("gutter" to 12, "pt" to object : UTSJSONObject() {
                                        var className = "mt-3"
                                    }), _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                                        return _uA(
                                            _cV(_component_cl_col, _uM("span" to 6), _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                                                return _uA(
                                                    _cE("view", _uM("class" to "item"), _uA(
                                                        _cV(_component_cl_text, _uM("pt" to object : UTSJSONObject() {
                                                            var className = "text"
                                                        }), _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                                                            return _uA(
                                                                "1"
                                                            )
                                                        }
                                                        ), "_" to 1))
                                                    ))
                                                )
                                            }
                                            ), "_" to 1)),
                                            _cV(_component_cl_col, _uM("span" to 6), _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                                                return _uA(
                                                    _cE("view", _uM("class" to "item"), _uA(
                                                        _cV(_component_cl_text, _uM("pt" to object : UTSJSONObject() {
                                                            var className = "text"
                                                        }), _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                                                            return _uA(
                                                                "2"
                                                            )
                                                        }
                                                        ), "_" to 1))
                                                    ))
                                                )
                                            }
                                            ), "_" to 1)),
                                            _cV(_component_cl_col, _uM("span" to 6), _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                                                return _uA(
                                                    _cE("view", _uM("class" to "item"), _uA(
                                                        _cV(_component_cl_text, _uM("pt" to object : UTSJSONObject() {
                                                            var className = "text"
                                                        }), _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                                                            return _uA(
                                                                "3"
                                                            )
                                                        }
                                                        ), "_" to 1))
                                                    ))
                                                )
                                            }
                                            ), "_" to 1)),
                                            _cV(_component_cl_col, _uM("span" to 6), _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                                                return _uA(
                                                    _cE("view", _uM("class" to "item"), _uA(
                                                        _cV(_component_cl_text, _uM("pt" to object : UTSJSONObject() {
                                                            var className = "text"
                                                        }), _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                                                            return _uA(
                                                                "4"
                                                            )
                                                        }
                                                        ), "_" to 1))
                                                    ))
                                                )
                                            }
                                            ), "_" to 1))
                                        )
                                    }
                                    ), "_" to 1))
                                )
                            }
                            ), "_" to 1), 8, _uA(
                                "label"
                            )),
                            _cV(unref(GenPagesDemoComponentsItemClass), _uM("label" to unref(t)("左间隔")), _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                                return _uA(
                                    _cV(_component_cl_row, _uM("gutter" to 12), _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                                        return _uA(
                                            _cV(_component_cl_col, _uM("span" to 6), _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                                                return _uA(
                                                    _cE("view", _uM("class" to "item"), _uA(
                                                        _cV(_component_cl_text, _uM("pt" to object : UTSJSONObject() {
                                                            var className = "text"
                                                        }), _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                                                            return _uA(
                                                                "1"
                                                            )
                                                        }
                                                        ), "_" to 1))
                                                    ))
                                                )
                                            }
                                            ), "_" to 1)),
                                            _cV(_component_cl_col, _uM("span" to 6, "offset" to 6), _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                                                return _uA(
                                                    _cE("view", _uM("class" to "item active"), _uA(
                                                        _cV(_component_cl_text, _uM("pt" to object : UTSJSONObject() {
                                                            var className = "text"
                                                        }), _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                                                            return _uA(
                                                                "2"
                                                            )
                                                        }
                                                        ), "_" to 1))
                                                    ))
                                                )
                                            }
                                            ), "_" to 1)),
                                            _cV(_component_cl_col, _uM("span" to 6), _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                                                return _uA(
                                                    _cE("view", _uM("class" to "item"), _uA(
                                                        _cV(_component_cl_text, _uM("pt" to object : UTSJSONObject() {
                                                            var className = "text"
                                                        }), _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                                                            return _uA(
                                                                "3"
                                                            )
                                                        }
                                                        ), "_" to 1))
                                                    ))
                                                )
                                            }
                                            ), "_" to 1))
                                        )
                                    }
                                    ), "_" to 1))
                                )
                            }
                            ), "_" to 1), 8, _uA(
                                "label"
                            )),
                            _cV(unref(GenPagesDemoComponentsItemClass), _uM("label" to unref(t)("右移动")), _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                                return _uA(
                                    _cV(_component_cl_row, _uM("gutter" to 12), _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                                        return _uA(
                                            _cV(_component_cl_col, _uM("span" to 6), _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                                                return _uA(
                                                    _cE("view", _uM("class" to "item"), _uA(
                                                        _cV(_component_cl_text, _uM("pt" to object : UTSJSONObject() {
                                                            var className = "text"
                                                        }), _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                                                            return _uA(
                                                                "1"
                                                            )
                                                        }
                                                        ), "_" to 1))
                                                    ))
                                                )
                                            }
                                            ), "_" to 1)),
                                            _cV(_component_cl_col, _uM("span" to 6), _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                                                return _uA(
                                                    _cE("view", _uM("class" to "item"), _uA(
                                                        _cV(_component_cl_text, _uM("pt" to object : UTSJSONObject() {
                                                            var className = "text"
                                                        }), _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                                                            return _uA(
                                                                "2"
                                                            )
                                                        }
                                                        ), "_" to 1))
                                                    ))
                                                )
                                            }
                                            ), "_" to 1)),
                                            _cV(_component_cl_col, _uM("span" to 6, "push" to 6), _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                                                return _uA(
                                                    _cE("view", _uM("class" to "item active"), _uA(
                                                        _cV(_component_cl_text, _uM("pt" to object : UTSJSONObject() {
                                                            var className = "text"
                                                        }), _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                                                            return _uA(
                                                                "3"
                                                            )
                                                        }
                                                        ), "_" to 1))
                                                    ))
                                                )
                                            }
                                            ), "_" to 1))
                                        )
                                    }
                                    ), "_" to 1))
                                )
                            }
                            ), "_" to 1), 8, _uA(
                                "label"
                            )),
                            _cV(unref(GenPagesDemoComponentsItemClass), _uM("label" to unref(t)("左移动")), _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                                return _uA(
                                    _cV(_component_cl_row, _uM("gutter" to 12), _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                                        return _uA(
                                            _cV(_component_cl_col, _uM("span" to 6), _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                                                return _uA(
                                                    _cE("view", _uM("class" to "item"), _uA(
                                                        _cV(_component_cl_text, _uM("pt" to object : UTSJSONObject() {
                                                            var className = "text"
                                                        }), _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                                                            return _uA(
                                                                "1"
                                                            )
                                                        }
                                                        ), "_" to 1))
                                                    ))
                                                )
                                            }
                                            ), "_" to 1)),
                                            _cV(_component_cl_col, _uM("span" to 6), _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                                                return _uA(
                                                    _cE("view", _uM("class" to "item"), _uA(
                                                        _cV(_component_cl_text, _uM("pt" to object : UTSJSONObject() {
                                                            var className = "text"
                                                        }), _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                                                            return _uA(
                                                                "2"
                                                            )
                                                        }
                                                        ), "_" to 1))
                                                    ))
                                                )
                                            }
                                            ), "_" to 1)),
                                            _cV(_component_cl_col, _uM("span" to 6), _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                                                return _uA(
                                                    _cE("view", _uM("class" to "item"), _uA(
                                                        _cV(_component_cl_text, _uM("pt" to object : UTSJSONObject() {
                                                            var className = "text"
                                                        }), _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                                                            return _uA(
                                                                "3"
                                                            )
                                                        }
                                                        ), "_" to 1))
                                                    ))
                                                )
                                            }
                                            ), "_" to 1)),
                                            _cV(_component_cl_col, _uM("span" to 6, "pull" to 6), _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                                                return _uA(
                                                    _cE("view", _uM("class" to "item active"), _uA(
                                                        _cV(_component_cl_text, _uM("pt" to object : UTSJSONObject() {
                                                            var className = "text"
                                                        }), _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                                                            return _uA(
                                                                "4"
                                                            )
                                                        }
                                                        ), "_" to 1))
                                                    ))
                                                )
                                            }
                                            ), "_" to 1))
                                        )
                                    }
                                    ), "_" to 1))
                                )
                            }
                            ), "_" to 1), 8, _uA(
                                "label"
                            )),
                            _cV(unref(GenPagesDemoComponentsItemClass), _uM("label" to unref(t)("多个数据")), _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                                return _uA(
                                    _cV(_component_cl_row, _uM("gutter" to 12), _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                                        return _uA(
                                            _cE(Fragment, null, RenderHelpers.renderList(20, fun(item, __key, __index, _cached): Any {
                                                return _cV(_component_cl_col, _uM("span" to 4, "key" to item), _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                                                    return _uA(
                                                        _cE("view", _uM("class" to "item mb-2"), _uA(
                                                            _cV(_component_cl_text, _uM("pt" to object : UTSJSONObject() {
                                                                var className = "text"
                                                            }), _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                                                                return _uA(
                                                                    _tD(item)
                                                                )
                                                            }
                                                            ), "_" to 2), 1024)
                                                        ))
                                                    )
                                                }
                                                ), "_" to 2), 1024)
                                            }
                                            ), 64)
                                        )
                                    }
                                    ), "_" to 1))
                                )
                            }
                            ), "_" to 1), 8, _uA(
                                "label"
                            ))
                        ), 2)
                    )
                }
                ), "_" to 1))
            }
        }
        val styles: Map<String, Map<String, Map<String, Any>>> by lazy {
            _nCS(_uA(
                styles0
            ), _uA(
                GenApp.styles
            ))
        }
        val styles0: Map<String, Map<String, Map<String, Any>>>
            get() {
                return _uM("item" to _uM("" to _uM("display" to "flex", "height" to "56rpx", "flexDirection" to "row", "alignItems" to "center", "justifyContent" to "center", "borderTopLeftRadius" to "10.5rpx", "borderTopRightRadius" to "10.5rpx", "borderBottomRightRadius" to "10.5rpx", "borderBottomLeftRadius" to "10.5rpx", "backgroundColor" to "rgba(244,244,245,1)"), ".active" to _uM("backgroundColor" to "rgba(20,184,166,1)"), ".is-dark " to _uM("backgroundColor" to "rgba(63,63,70,1)"), ".is-dark .active" to _uM("backgroundColor" to "rgba(20,184,166,1)")), "text" to _uM(".item " to _uM("fontSize" to "24.5rpx", "lineHeight" to "35rpx", "color" to "rgba(63,63,70,1)"), ".item.active " to _uM("color" to "rgba(255,255,255,1)"), ".is-dark .item " to _uM("color" to "rgba(244,244,245,1)"), ".is-dark .item.active " to _uM("color" to "rgba(255,255,255,1)")))
            }
        var inheritAttrs = true
        var inject: Map<String, Map<String, Any?>> = _uM()
        var emits: Map<String, Any?> = _uM()
        var props = _nP(_uM())
        var propsNeedCastKeys: UTSArray<String> = _uA()
        var components: Map<String, CreateVueComponent> = _uM()
    }
}
