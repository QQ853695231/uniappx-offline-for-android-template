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
open class GenPagesDemoLayoutFloatView : BasePage {
    constructor(__ins: ComponentInternalInstance, __renderer: String?) : super(__ins, __renderer) {
        onPageScroll(fun(e: OnPageScrollOptions) {
            scroller.emit(e.scrollTop)
        }
        , __ins)
        onPageShow(fun() {}, __ins)
    }
    companion object {
        @Suppress("UNUSED_PARAMETER", "UNUSED_VARIABLE")
        var setup: (__props: GenPagesDemoLayoutFloatView) -> Any? = fun(__props): Any? {
            val __ins = getCurrentInstance()!!
            val _ctx = __ins.proxy as GenPagesDemoLayoutFloatView
            val _cache = __ins.renderCache
            val ui = useUi()
            fun gen_toAlert_fn() {
                ui.showToast(ClToastOptions(message = t("这是一个提示")))
            }
            val toAlert = ::gen_toAlert_fn
            return fun(): Any? {
                val _component_cl_icon = resolveEasyComponent("cl-icon", GenUniModulesCoolUiComponentsClIconClIconClass)
                val _component_cl_text = resolveEasyComponent("cl-text", GenUniModulesCoolUiComponentsClTextClTextClass)
                val _component_cl_float_view = resolveEasyComponent("cl-float-view", GenUniModulesCoolUiComponentsClFloatViewClFloatViewClass)
                val _component_cl_page = resolveEasyComponent("cl-page", GenUniModulesCoolUiComponentsClPageClPageClass)
                return _cV(_component_cl_page, null, _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                    return _uA(
                        _cE("view", _uM("class" to "p-3"), _uA(
                            _cV(unref(GenPagesDemoComponentsItemClass), null, _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                                return _uA(
                                    _cE("view", _uM("class" to "flex flex-row items-center"), _uA(
                                        _cV(_component_cl_icon, _uM("name" to "notification-4-fill", "class" to "mr-2")),
                                        _cV(_component_cl_text, null, _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                                            return _uA(
                                                _tD(unref(t)("禁用状态，无法拖拽"))
                                            )
                                        }
                                        ), "_" to 1))
                                    ))
                                )
                            }
                            ), "_" to 1)),
                            _cV(unref(GenPagesDemoComponentsItemClass), null, _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                                return _uA(
                                    _cE("view", _uM("class" to "flex flex-row items-center"), _uA(
                                        _cV(_component_cl_icon, _uM("name" to "heart-fill", "class" to "mr-2")),
                                        _cV(_component_cl_text, null, _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                                            return _uA(
                                                _tD(unref(t)("不吸附边缘，任意位置可拖拽"))
                                            )
                                        }
                                        ), "_" to 1))
                                    ))
                                )
                            }
                            ), "_" to 1)),
                            _cV(_component_cl_float_view, _uM("left" to 200, "bottom" to 50, "no-snapping" to true), _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                                return _uA(
                                    _cE("view", _uM("class" to "w--bracket-start-40px-bracket-end- h--bracket-start-40px-bracket-end- bg-primary-500 flex flex-row items-center justify-center", "onClick" to toAlert), _uA(
                                        _cV(_component_cl_icon, _uM("name" to "heart-fill", "color" to "white"))
                                    ))
                                )
                            }
                            ), "_" to 1)),
                            _cV(_component_cl_float_view, _uM("disabled" to "", "left" to 20, "bottom" to 400, "gap" to 10), _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                                return _uA(
                                    _cE("view", _uM("class" to "w--bracket-start-40px-bracket-end- h--bracket-start-40px-bracket-end- bg-surface-400 rounded-full flex flex-row items-center justify-center"), _uA(
                                        _cV(_component_cl_icon, _uM("name" to "notification-4-fill", "color" to "white"))
                                    ))
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
