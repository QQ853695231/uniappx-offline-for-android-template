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
open class GenPagesDemoDataTimeline : BasePage {
    constructor(__ins: ComponentInternalInstance, __renderer: String?) : super(__ins, __renderer) {
        onPageScroll(fun(e: OnPageScrollOptions) {
            scroller.emit(e.scrollTop)
        }
        , __ins)
        onPageShow(fun() {}, __ins)
    }
    companion object {
        @Suppress("UNUSED_PARAMETER", "UNUSED_VARIABLE")
        var setup: (__props: GenPagesDemoDataTimeline) -> Any? = fun(__props): Any? {
            val __ins = getCurrentInstance()!!
            val _ctx = __ins.proxy as GenPagesDemoDataTimeline
            val _cache = __ins.renderCache
            return fun(): Any? {
                val _component_cl_timeline_item = resolveEasyComponent("cl-timeline-item", GenUniModulesCoolUiComponentsClTimelineItemClTimelineItemClass)
                val _component_cl_image = resolveEasyComponent("cl-image", GenUniModulesCoolUiComponentsClImageClImageClass)
                val _component_cl_text = resolveEasyComponent("cl-text", GenUniModulesCoolUiComponentsClTextClTextClass)
                val _component_cl_button = resolveEasyComponent("cl-button", GenUniModulesCoolUiComponentsClButtonClButtonClass)
                val _component_cl_timeline = resolveEasyComponent("cl-timeline", GenUniModulesCoolUiComponentsClTimelineClTimelineClass)
                val _component_cl_page = resolveEasyComponent("cl-page", GenUniModulesCoolUiComponentsClPageClPageClass)
                return _cV(_component_cl_page, null, _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                    return _uA(
                        _cE("view", _uM("class" to "p-3"), _uA(
                            _cV(unref(GenPagesDemoComponentsItemClass), _uM("label" to unref(t)("基础用法")), _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                                return _uA(
                                    _cV(_component_cl_timeline, null, _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                                        return _uA(
                                            _cV(_component_cl_timeline_item, _uM("icon" to "account-box-line", "title" to unref(t)("开通账号"), "date" to "2025-01-01", "content" to unref(t)("赠送500元")), null, 8, _uA(
                                                "title",
                                                "content"
                                            )),
                                            _cV(_component_cl_timeline_item, _uM("icon" to "id-card-line", "title" to unref(t)("完成实名认证"), "date" to "2025-01-02", "content" to unref(t)("通过身份证认证")), null, 8, _uA(
                                                "title",
                                                "content"
                                            )),
                                            _cV(_component_cl_timeline_item, _uM("icon" to "bank-card-line", "title" to unref(t)("绑定银行卡"), "date" to "2025-01-03", "content" to unref(t)("绑定招商银行储蓄卡")), null, 8, _uA(
                                                "title",
                                                "content"
                                            )),
                                            _cV(_component_cl_timeline_item, _uM("icon" to "money-cny-box-line", "title" to unref(t)("首次充值"), "date" to "2025-01-04", "content" to unref(t)("充值1000元")), null, 8, _uA(
                                                "title",
                                                "content"
                                            )),
                                            _cV(_component_cl_timeline_item, _uM("icon" to "checkbox-line", "title" to unref(t)("完成首笔交易"), "date" to "2025-01-05", "hide-line" to true), _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                                                return _uA(
                                                    _cE("view", _uM("class" to "flex flex-row mb-3 mt-1"), _uA(
                                                        _cV(_component_cl_image, _uM("src" to "https://uni-docs.cool-js.com/demo/pages/demo/static/bg1.png")),
                                                        _cE("view", _uM("class" to "flex-1 px-3"), _uA(
                                                            _cV(_component_cl_text, null, _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                                                                return _uA(
                                                                    _tD(unref(t)("优选灵活配置混合A"))
                                                                )
                                                            }
                                                            ), "_" to 1)),
                                                            _cV(_component_cl_text, _uM("class" to "mr-5 mt-1 -important-text-sm"), _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                                                                return _uA(
                                                                    _tD(unref(t)("1000元起"))
                                                                )
                                                            }
                                                            ), "_" to 1)),
                                                            _cE("view", _uM("class" to "flex flex-row mt-2 items-center"), _uA(
                                                                _cV(_component_cl_button, _uM("size" to "small", "type" to "light"), _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                                                                    return _uA(
                                                                        _tD(unref(t)("立即购买"))
                                                                    )
                                                                }
                                                                ), "_" to 1))
                                                            ))
                                                        ))
                                                    ))
                                                )
                                            }
                                            ), "_" to 1), 8, _uA(
                                                "title"
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
