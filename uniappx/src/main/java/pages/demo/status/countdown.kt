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
open class GenPagesDemoStatusCountdown : BasePage {
    constructor(__ins: ComponentInternalInstance, __renderer: String?) : super(__ins, __renderer) {
        onPageScroll(fun(e: OnPageScrollOptions) {
            scroller.emit(e.scrollTop)
        }
        , __ins)
        onPageShow(fun() {}, __ins)
    }
    companion object {
        @Suppress("UNUSED_PARAMETER", "UNUSED_VARIABLE")
        var setup: (__props: GenPagesDemoStatusCountdown) -> Any? = fun(__props): Any? {
            val __ins = getCurrentInstance()!!
            val _ctx = __ins.proxy as GenPagesDemoStatusCountdown
            val _cache = __ins.renderCache
            val ui = useUi()
            val datetime = ref(dayUts().add(1, "minute").toDate())
            fun gen_onDone_fn() {
                ui.showToast(ClToastOptions(message = "倒计时完成"))
            }
            val onDone = ::gen_onDone_fn
            return fun(): Any? {
                val _component_cl_countdown = resolveEasyComponent("cl-countdown", GenUniModulesCoolUiComponentsClCountdownClCountdownClass)
                val _component_cl_page = resolveEasyComponent("cl-page", GenUniModulesCoolUiComponentsClPageClPageClass)
                return _cV(_component_cl_page, null, _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                    return _uA(
                        _cE("view", _uM("class" to "p-3"), _uA(
                            _cV(unref(GenPagesDemoComponentsItemClass), _uM("label" to unref(t)("基础用法")), _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                                return _uA(
                                    _cV(_component_cl_countdown, _uM("datetime" to datetime.value), null, 8, _uA(
                                        "datetime"
                                    ))
                                )
                            }
                            ), "_" to 1), 8, _uA(
                                "label"
                            )),
                            _cV(unref(GenPagesDemoComponentsItemClass), _uM("label" to unref(t)("隐藏为 00 的值")), _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                                return _uA(
                                    _cV(_component_cl_countdown, _uM("minute" to 60, "hide-zero" to ""))
                                )
                            }
                            ), "_" to 1), 8, _uA(
                                "label"
                            )),
                            _cV(unref(GenPagesDemoComponentsItemClass), _uM("label" to unref(t)("指定天数")), _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                                return _uA(
                                    _cV(_component_cl_countdown, _uM("day" to 2, "format" to "{d}天{h}:{m}:{s}"))
                                )
                            }
                            ), "_" to 1), 8, _uA(
                                "label"
                            )),
                            _cV(unref(GenPagesDemoComponentsItemClass), _uM("label" to unref(t)("自定义模板")), _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                                return _uA(
                                    _cV(_component_cl_countdown, _uM("day" to 1, "format" to "{d}天{h}时{m}分{s}秒"))
                                )
                            }
                            ), "_" to 1), 8, _uA(
                                "label"
                            )),
                            _cV(unref(GenPagesDemoComponentsItemClass), _uM("label" to unref(t)("指定小时")), _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                                return _uA(
                                    _cV(_component_cl_countdown, _uM("hour" to 2))
                                )
                            }
                            ), "_" to 1), 8, _uA(
                                "label"
                            )),
                            _cV(unref(GenPagesDemoComponentsItemClass), _uM("label" to unref(t)("指定分钟")), _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                                return _uA(
                                    _cV(_component_cl_countdown, _uM("minute" to 2))
                                )
                            }
                            ), "_" to 1), 8, _uA(
                                "label"
                            )),
                            _cV(unref(GenPagesDemoComponentsItemClass), _uM("label" to unref(t)("指定秒")), _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                                return _uA(
                                    _cV(_component_cl_countdown, _uM("second" to 10))
                                )
                            }
                            ), "_" to 1), 8, _uA(
                                "label"
                            )),
                            _cV(unref(GenPagesDemoComponentsItemClass), _uM("label" to unref(t)("完成后提示")), _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                                return _uA(
                                    _cV(_component_cl_countdown, _uM("second" to 5, "onDone" to onDone))
                                )
                            }
                            ), "_" to 1), 8, _uA(
                                "label"
                            )),
                            _cV(unref(GenPagesDemoComponentsItemClass), _uM("label" to unref(t)("自定义样式")), _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                                return _uA(
                                    _cV(_component_cl_countdown, _uM("hour" to 10, "pt" to object : UTSJSONObject() {
                                        var text = object : UTSJSONObject() {
                                            var className = unref(parseClass)(_uA(
                                                "px-2 py-1 rounded-md",
                                                _uA(
                                                    unref(isDark),
                                                    "bg-surface-700",
                                                    "bg-surface-100"
                                                )
                                            ))
                                        }
                                        var splitor = object : UTSJSONObject() {
                                            var className = "px-2"
                                        }
                                    }), null, 8, _uA(
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
