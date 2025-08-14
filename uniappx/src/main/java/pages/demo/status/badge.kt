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
open class GenPagesDemoStatusBadge : BasePage {
    constructor(__ins: ComponentInternalInstance, __renderer: String?) : super(__ins, __renderer) {
        onPageScroll(fun(e: OnPageScrollOptions) {
            scroller.emit(e.scrollTop)
        }
        , __ins)
        onPageShow(fun() {}, __ins)
    }
    companion object {
        @Suppress("UNUSED_PARAMETER", "UNUSED_VARIABLE")
        var setup: (__props: GenPagesDemoStatusBadge) -> Any? = fun(__props): Any? {
            val __ins = getCurrentInstance()!!
            val _ctx = __ins.proxy as GenPagesDemoStatusBadge
            val _cache = __ins.renderCache
            return fun(): Any? {
                val _component_cl_badge = resolveEasyComponent("cl-badge", GenUniModulesCoolUiComponentsClBadgeClBadgeClass)
                val _component_cl_button = resolveEasyComponent("cl-button", GenUniModulesCoolUiComponentsClButtonClButtonClass)
                val _component_cl_image = resolveEasyComponent("cl-image", GenUniModulesCoolUiComponentsClImageClImageClass)
                val _component_cl_icon = resolveEasyComponent("cl-icon", GenUniModulesCoolUiComponentsClIconClIconClass)
                val _component_cl_page = resolveEasyComponent("cl-page", GenUniModulesCoolUiComponentsClPageClPageClass)
                return _cV(_component_cl_page, null, _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                    return _uA(
                        _cE("view", _uM("class" to "p-3"), _uA(
                            _cV(unref(GenPagesDemoComponentsItemClass), _uM("label" to unref(t)("基础用法")), _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                                return _uA(
                                    _cE("view", _uM("class" to "flex flex-row"), _uA(
                                        _cV(_component_cl_badge, _uM("type" to "primary", "value" to "1", "class" to "mr-2")),
                                        _cV(_component_cl_badge, _uM("type" to "success", "value" to "12", "class" to "mr-2")),
                                        _cV(_component_cl_badge, _uM("type" to "warn", "value" to "31", "class" to "mr-2")),
                                        _cV(_component_cl_badge, _uM("type" to "error", "value" to "24", "class" to "mr-2")),
                                        _cV(_component_cl_badge, _uM("type" to "info", "value" to "17", "class" to "mr-2")),
                                        _cV(_component_cl_badge, _uM("type" to "primary", "value" to "41", "class" to "mr-2")),
                                        _cV(_component_cl_badge, _uM("type" to "success", "value" to "56", "class" to "mr-2"))
                                    ))
                                )
                            }
                            ), "_" to 1), 8, _uA(
                                "label"
                            )),
                            _cV(unref(GenPagesDemoComponentsItemClass), _uM("label" to unref(t)("结合按钮")), _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                                return _uA(
                                    _cE("view", _uM("class" to "flex flex-row overflow-visible"), _uA(
                                        _cV(_component_cl_button, null, _uM("content" to withSlotCtx(fun(): UTSArray<Any> {
                                            return _uA(
                                                _cV(_component_cl_badge, _uM("type" to "error", "value" to "1", "position" to ""))
                                            )
                                        }
                                        ), "default" to withSlotCtx(fun(): UTSArray<Any> {
                                            return _uA(
                                                _tD(unref(t)("购买")) + " "
                                            )
                                        }
                                        ), "_" to 1)),
                                        _cV(_component_cl_button, _uM("pt" to object : UTSJSONObject() {
                                            var className = "-important-ml-5"
                                        }), _uM("content" to withSlotCtx(fun(): UTSArray<Any> {
                                            return _uA(
                                                _cV(_component_cl_badge, _uM("type" to "error", "dot" to "", "position" to ""))
                                            )
                                        }
                                        ), "default" to withSlotCtx(fun(): UTSArray<Any> {
                                            return _uA(
                                                _tD(unref(t)("消息")) + " "
                                            )
                                        }
                                        ), "_" to 1))
                                    ))
                                )
                            }
                            ), "_" to 1), 8, _uA(
                                "label"
                            )),
                            _cV(unref(GenPagesDemoComponentsItemClass), _uM("label" to unref(t)("结合图片")), _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                                return _uA(
                                    _cE("view", _uM("class" to "flex flex-row overflow-visible"), _uA(
                                        _cV(_component_cl_image, _uM("pt" to object : UTSJSONObject() {
                                            var className = "overflow-visible"
                                        }, "src" to "https://uni-docs.cool-js.com/demo/pages/demo/static/bg1.png"), _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                                            return _uA(
                                                _cV(_component_cl_badge, _uM("type" to "error", "value" to "+9", "position" to ""))
                                            )
                                        }
                                        ), "_" to 1))
                                    ))
                                )
                            }
                            ), "_" to 1), 8, _uA(
                                "label"
                            )),
                            _cV(unref(GenPagesDemoComponentsItemClass), _uM("label" to unref(t)("结合图标")), _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                                return _uA(
                                    _cE("view", _uM("class" to "flex flex-row overflow-visible"), _uA(
                                        _cE("view", _uM("class" to "relative overflow-visible"), _uA(
                                            _cV(_component_cl_icon, _uM("name" to "mail-line")),
                                            _cV(_component_cl_badge, _uM("type" to "error", "dot" to "", "position" to "", "pt" to object : UTSJSONObject() {
                                                var className = "-important-top--bracket-start--6rpx-bracket-end- -important-right--bracket-start--6rpx-bracket-end-"
                                            }))
                                        ))
                                    ))
                                )
                            }
                            ), "_" to 1), 8, _uA(
                                "label"
                            )),
                            _cV(unref(GenPagesDemoComponentsItemClass), _uM("label" to unref(t)("自定义样式")), _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                                return _uA(
                                    _cE("view", _uM("class" to "flex flex-row"), _uA(
                                        _cV(_component_cl_badge, _uM("type" to "info", "pt" to object : UTSJSONObject() {
                                            var className = "-important-rounded-bl-none"
                                        }, "value" to "1"))
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
