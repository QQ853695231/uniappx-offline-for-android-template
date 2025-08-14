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
open class GenPagesDemoDataBanner : BasePage {
    constructor(__ins: ComponentInternalInstance, __renderer: String?) : super(__ins, __renderer) {
        onPageScroll(fun(e: OnPageScrollOptions) {
            scroller.emit(e.scrollTop)
        }
        , __ins)
        onPageShow(fun() {}, __ins)
    }
    companion object {
        @Suppress("UNUSED_PARAMETER", "UNUSED_VARIABLE")
        var setup: (__props: GenPagesDemoDataBanner) -> Any? = fun(__props): Any? {
            val __ins = getCurrentInstance()!!
            val _ctx = __ins.proxy as GenPagesDemoDataBanner
            val _cache = __ins.renderCache
            val list = ref(_uA<String>("https://uni-docs.cool-js.com/demo/pages/demo/static/bg1.png", "https://uni-docs.cool-js.com/demo/pages/demo/static/bg2.png", "https://uni-docs.cool-js.com/demo/pages/demo/static/bg3.png"))
            return fun(): Any? {
                val _component_cl_banner = resolveEasyComponent("cl-banner", GenUniModulesCoolUiComponentsClBannerClBannerClass)
                val _component_cl_page = resolveEasyComponent("cl-page", GenUniModulesCoolUiComponentsClPageClPageClass)
                return _cV(_component_cl_page, null, _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                    return _uA(
                        _cE("view", _uM("class" to "p-3"), _uA(
                            _cV(unref(GenPagesDemoComponentsItemClass), _uM("label" to unref(t)("基础用法")), _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                                return _uA(
                                    _cV(_component_cl_banner, _uM("list" to list.value), null, 8, _uA(
                                        "list"
                                    ))
                                )
                            }
                            ), "_" to 1), 8, _uA(
                                "label"
                            )),
                            _cV(unref(GenPagesDemoComponentsItemClass), _uM("label" to unref(t)("禁用手势")), _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                                return _uA(
                                    _cV(_component_cl_banner, _uM("list" to list.value, "disable-touch" to true), null, 8, _uA(
                                        "list"
                                    ))
                                )
                            }
                            ), "_" to 1), 8, _uA(
                                "label"
                            )),
                            _cV(unref(GenPagesDemoComponentsItemClass), _uM("label" to unref(t)("自定义样式")), _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                                return _uA(
                                    _cV(_component_cl_banner, _uM("list" to list.value, "pt" to object : UTSJSONObject() {
                                        var className = "mx--bracket-start--12rpx-bracket-end-"
                                        var item = object : UTSJSONObject() {
                                            var className = unref(parseClass)(_uA(
                                                "scale-y-80 -important-px--bracket-start-12rpx-bracket-end-"
                                            ))
                                        }
                                        var itemActive = object : UTSJSONObject() {
                                            var className = unref(parseClass)(_uA(
                                                "-important-scale-y-100"
                                            ))
                                        }
                                    }, "previous-margin" to 40, "next-margin" to 40), null, 8, _uA(
                                        "list",
                                        "pt"
                                    ))
                                )
                            }
                            ), "_" to 1), 8, _uA(
                                "label"
                            )),
                            _cV(unref(GenPagesDemoComponentsItemClass), _uM("label" to unref(t)("自定义样式2")), _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                                return _uA(
                                    _cV(_component_cl_banner, _uM("list" to list.value, "pt" to object : UTSJSONObject() {
                                        var className = "mx--bracket-start--12rpx-bracket-end-"
                                        var item = object : UTSJSONObject() {
                                            var className = unref(parseClass)(_uA(
                                                "px--bracket-start-12rpx-bracket-end-"
                                            ))
                                        }
                                    }, "next-margin" to 40), null, 8, _uA(
                                        "list",
                                        "pt"
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
