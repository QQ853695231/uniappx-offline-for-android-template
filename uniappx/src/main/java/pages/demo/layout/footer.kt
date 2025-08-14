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
open class GenPagesDemoLayoutFooter : BasePage {
    constructor(__ins: ComponentInternalInstance, __renderer: String?) : super(__ins, __renderer) {
        onPageScroll(fun(e: OnPageScrollOptions) {
            scroller.emit(e.scrollTop)
        }
        , __ins)
        onPageShow(fun() {}, __ins)
    }
    companion object {
        @Suppress("UNUSED_PARAMETER", "UNUSED_VARIABLE")
        var setup: (__props: GenPagesDemoLayoutFooter) -> Any? = fun(__props): Any? {
            val __ins = getCurrentInstance()!!
            val _ctx = __ins.proxy as GenPagesDemoLayoutFooter
            val _cache = __ins.renderCache
            val status = ref(0)
            val cache = useCache(fun(): UTSArray<Any> {
                return _uA(
                    status.value
                )
            }
            ).cache
            fun gen_cancel_fn() {
                status.value = 3
            }
            val cancel = ::gen_cancel_fn
            fun gen_buy_fn() {
                status.value = 1
            }
            val buy = ::gen_buy_fn
            fun gen_confirm_fn() {
                status.value = 2
            }
            val confirm = ::gen_confirm_fn
            fun gen_comment_fn() {
                status.value = 3
            }
            val comment = ::gen_comment_fn
            return fun(): Any? {
                val _component_cl_text = resolveEasyComponent("cl-text", GenUniModulesCoolUiComponentsClTextClTextClass)
                val _component_cl_list_item = resolveEasyComponent("cl-list-item", GenUniModulesCoolUiComponentsClListItemClListItemClass)
                val _component_cl_list = resolveEasyComponent("cl-list", GenUniModulesCoolUiComponentsClListClListClass)
                val _component_cl_button = resolveEasyComponent("cl-button", GenUniModulesCoolUiComponentsClButtonClButtonClass)
                val _component_cl_footer = resolveEasyComponent("cl-footer", GenUniModulesCoolUiComponentsClFooterClFooterClass)
                val _component_cl_page = resolveEasyComponent("cl-page", GenUniModulesCoolUiComponentsClPageClPageClass)
                return _cV(_component_cl_page, null, _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                    return _uA(
                        _cE("view", _uM("class" to "p-3"), _uA(
                            _cV(unref(GenPagesDemoComponentsItemClass), null, _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                                return _uA(
                                    _cV(_component_cl_text, null, _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                                        return _uA(
                                            "解决底部按钮隐藏时页面底部仍有空白间距"
                                        )
                                    }
                                    ), "_" to 1)),
                                    _cV(_component_cl_text, null, _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                                        return _uA(
                                            "解决固定定位时内容占位缺失"
                                        )
                                    }
                                    ), "_" to 1))
                                )
                            }
                            ), "_" to 1)),
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
                        _cV(_component_cl_footer, _uM("vt" to unref(cache).key), _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                            return _uA(
                                if (status.value == 0) {
                                    _cE("view", _uM("key" to 0, "class" to "flex flex-row"), _uA(
                                        _cV(_component_cl_button, _uM("pt" to object : UTSJSONObject() {
                                            var className = "flex-1"
                                        }, "text" to "", "border" to "", "size" to "large", "onClick" to cancel), _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                                            return _uA(
                                                _tD(unref(t)("取消订单"))
                                            )
                                        }), "_" to 1)),
                                        _cV(_component_cl_button, _uM("pt" to object : UTSJSONObject() {
                                            var className = "flex-1"
                                        }, "type" to "primary", "size" to "large", "onClick" to buy), _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                                            return _uA(
                                                _tD(unref(t)("立即购买"))
                                            )
                                        }), "_" to 1))
                                    ))
                                } else {
                                    _cC("v-if", true)
                                }
                                ,
                                if (status.value == 1) {
                                    _cV(_component_cl_button, _uM("key" to 1, "type" to "error", "size" to "large", "onClick" to confirm), _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                                        return _uA(
                                            _tD(unref(t)("确认收货"))
                                        )
                                    }), "_" to 1))
                                } else {
                                    _cC("v-if", true)
                                }
                                ,
                                if (status.value == 2) {
                                    _cV(_component_cl_button, _uM("key" to 2, "type" to "success", "size" to "large", "onClick" to comment), _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                                        return _uA(
                                            _tD(unref(t)("评价"))
                                        )
                                    }), "_" to 1))
                                } else {
                                    _cC("v-if", true)
                                }
                            )
                        }
                        ), "_" to 1), 8, _uA(
                            "vt"
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
