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
open class GenPagesDemoFeedbackToast : BasePage {
    constructor(__ins: ComponentInternalInstance, __renderer: String?) : super(__ins, __renderer) {
        onPageScroll(fun(e: OnPageScrollOptions) {
            scroller.emit(e.scrollTop)
        }
        , __ins)
        onPageShow(fun() {}, __ins)
    }
    companion object {
        @Suppress("UNUSED_PARAMETER", "UNUSED_VARIABLE")
        var setup: (__props: GenPagesDemoFeedbackToast) -> Any? = fun(__props): Any? {
            val __ins = getCurrentInstance()!!
            val _ctx = __ins.proxy as GenPagesDemoFeedbackToast
            val _cache = __ins.renderCache
            val ui = useUi()
            fun open(position: String = "center") {
                ui.showToast(ClToastOptions(message = t("不同位置提示"), position = position))
            }
            fun gen_openType_fn(type: ClToastType) {
                ui.showToast(ClToastOptions(message = t("不同类型提示"), type = type))
            }
            val openType = ::gen_openType_fn
            fun gen_openIcon_fn(icon: String) {
                ui.showToast(ClToastOptions(message = t("带图标提示"), icon = icon))
            }
            val openIcon = ::gen_openIcon_fn
            fun gen_openClear_fn() {
                ui.showToast(ClToastOptions(message = t("移除其他已存在的提示"), clear = true))
            }
            val openClear = ::gen_openClear_fn
            return fun(): Any? {
                val _component_cl_button = resolveEasyComponent("cl-button", GenUniModulesCoolUiComponentsClButtonClButtonClass)
                val _component_cl_page = resolveEasyComponent("cl-page", GenUniModulesCoolUiComponentsClPageClPageClass)
                return _cV(_component_cl_page, null, _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                    return _uA(
                        _cE("view", _uM("class" to "p-3"), _uA(
                            _cV(unref(GenPagesDemoComponentsItemClass), _uM("label" to unref(t)("基础用法")), _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                                return _uA(
                                    _cV(_component_cl_button, _uM("onClick" to fun(){
                                        open()
                                    }
                                    ), _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                                        return _uA(
                                            _tD(unref(t)("打开"))
                                        )
                                    }
                                    ), "_" to 1), 8, _uA(
                                        "onClick"
                                    ))
                                )
                            }
                            ), "_" to 1), 8, _uA(
                                "label"
                            )),
                            _cV(unref(GenPagesDemoComponentsItemClass), _uM("label" to unref(t)("不同位置")), _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                                return _uA(
                                    _cE("view", _uM("class" to "flex flex-row"), _uA(
                                        _cV(_component_cl_button, _uM("type" to "light", "onClick" to fun(){
                                            open("top")
                                        }
                                        ), _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                                            return _uA(
                                                _tD(unref(t)("顶部"))
                                            )
                                        }
                                        ), "_" to 1), 8, _uA(
                                            "onClick"
                                        )),
                                        _cV(_component_cl_button, _uM("type" to "light", "onClick" to fun(){
                                            open("center")
                                        }
                                        ), _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                                            return _uA(
                                                _tD(unref(t)("中间"))
                                            )
                                        }
                                        ), "_" to 1), 8, _uA(
                                            "onClick"
                                        )),
                                        _cV(_component_cl_button, _uM("type" to "light", "onClick" to fun(){
                                            open("bottom")
                                        }
                                        ), _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                                            return _uA(
                                                _tD(unref(t)("底部"))
                                            )
                                        }
                                        ), "_" to 1), 8, _uA(
                                            "onClick"
                                        ))
                                    ))
                                )
                            }
                            ), "_" to 1), 8, _uA(
                                "label"
                            )),
                            _cV(unref(GenPagesDemoComponentsItemClass), _uM("label" to unref(t)("不同类型")), _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                                return _uA(
                                    _cE("view", _uM("class" to "flex flex-row flex-wrap mb-2"), _uA(
                                        _cV(_component_cl_button, _uM("type" to "light", "onClick" to fun(){
                                            openType("success")
                                        }
                                        ), _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                                            return _uA(
                                                _tD(unref(t)("成功"))
                                            )
                                        }
                                        ), "_" to 1), 8, _uA(
                                            "onClick"
                                        )),
                                        _cV(_component_cl_button, _uM("type" to "light", "onClick" to fun(){
                                            openType("error")
                                        }
                                        ), _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                                            return _uA(
                                                _tD(unref(t)("失败"))
                                            )
                                        }
                                        ), "_" to 1), 8, _uA(
                                            "onClick"
                                        )),
                                        _cV(_component_cl_button, _uM("type" to "light", "onClick" to fun(){
                                            openType("warn")
                                        }
                                        ), _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                                            return _uA(
                                                _tD(unref(t)("警告"))
                                            )
                                        }
                                        ), "_" to 1), 8, _uA(
                                            "onClick"
                                        )),
                                        _cV(_component_cl_button, _uM("type" to "light", "onClick" to fun(){
                                            openType("question")
                                        }
                                        ), _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                                            return _uA(
                                                _tD(unref(t)("问题"))
                                            )
                                        }
                                        ), "_" to 1), 8, _uA(
                                            "onClick"
                                        )),
                                        _cV(_component_cl_button, _uM("type" to "light", "onClick" to fun(){
                                            openType("disabled")
                                        }
                                        ), _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                                            return _uA(
                                                _tD(unref(t)("禁用"))
                                            )
                                        }
                                        ), "_" to 1), 8, _uA(
                                            "onClick"
                                        ))
                                    )),
                                    _cE("view", _uM("class" to "flex flex-row flex-wrap"), _uA(
                                        _cV(_component_cl_button, _uM("type" to "light", "onClick" to fun(){
                                            openType("stop")
                                        }
                                        ), _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                                            return _uA(
                                                _tD(unref(t)("停止"))
                                            )
                                        }
                                        ), "_" to 1), 8, _uA(
                                            "onClick"
                                        ))
                                    ))
                                )
                            }
                            ), "_" to 1), 8, _uA(
                                "label"
                            )),
                            _cV(unref(GenPagesDemoComponentsItemClass), _uM("label" to unref(t)("自定义图标")), _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                                return _uA(
                                    _cE("view", _uM("class" to "flex flex-row"), _uA(
                                        _cV(_component_cl_button, _uM("type" to "light", "icon" to "star-line", "onClick" to fun(){
                                            openIcon("star-line")
                                        }
                                        ), null, 8, _uA(
                                            "onClick"
                                        )),
                                        _cV(_component_cl_button, _uM("type" to "light", "icon" to "mail-line", "onClick" to fun(){
                                            openIcon("mail-line")
                                        }
                                        ), null, 8, _uA(
                                            "onClick"
                                        )),
                                        _cV(_component_cl_button, _uM("type" to "light", "icon" to "file-line", "onClick" to fun(){
                                            openIcon("file-line")
                                        }
                                        ), null, 8, _uA(
                                            "onClick"
                                        ))
                                    ))
                                )
                            }
                            ), "_" to 1), 8, _uA(
                                "label"
                            )),
                            _cV(unref(GenPagesDemoComponentsItemClass), _uM("label" to unref(t)("只存在一个")), _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                                return _uA(
                                    _cV(_component_cl_button, _uM("onClick" to fun(){
                                        openClear()
                                    }
                                    ), _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                                        return _uA(
                                            _tD(unref(t)("打开"))
                                        )
                                    }
                                    ), "_" to 1), 8, _uA(
                                        "onClick"
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
