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
open class GenPagesDemoFeedbackConfirm : BasePage {
    constructor(__ins: ComponentInternalInstance, __renderer: String?) : super(__ins, __renderer) {
        onPageScroll(fun(e: OnPageScrollOptions) {
            scroller.emit(e.scrollTop)
        }
        , __ins)
        onPageShow(fun() {}, __ins)
    }
    companion object {
        @Suppress("UNUSED_PARAMETER", "UNUSED_VARIABLE")
        var setup: (__props: GenPagesDemoFeedbackConfirm) -> Any? = fun(__props): Any? {
            val __ins = getCurrentInstance()!!
            val _ctx = __ins.proxy as GenPagesDemoFeedbackConfirm
            val _cache = __ins.renderCache
            val ui = useUi()
            fun gen_openPopup_fn() {
                ui.showConfirm(ClConfirmOptions(title = t("提示"), message = t("确定要删除吗？"), callback = fun(action) {
                    if (action == "confirm") {
                        ui.showToast(ClToastOptions(message = t("确定")))
                    } else {
                        ui.showToast(ClToastOptions(message = t("取消")))
                    }
                }
                ))
            }
            val openPopup = ::gen_openPopup_fn
            fun gen_openPopup2_fn() {
                ui.showConfirm(ClConfirmOptions(title = t("提示"), message = t("确定要删除吗？"), showCancel = false))
            }
            val openPopup2 = ::gen_openPopup2_fn
            fun gen_openPopup3_fn() {
                ui.showConfirm(ClConfirmOptions(title = t("提示"), message = t("确定要删除吗？"), cancelText = t("关闭"), confirmText = t("下一步")))
            }
            val openPopup3 = ::gen_openPopup3_fn
            fun gen_openPopup4_fn() {
                ui.showConfirm(ClConfirmOptions(title = t("提示"), message = t("确定要删除吗？"), beforeClose = fun(action, ref1){
                    var close = ref1.close
                    var showLoading = ref1.showLoading
                    var hideLoading = ref1.hideLoading
                    if (action == "confirm") {
                        showLoading()
                        setTimeout(fun(){
                            close()
                        }, 1000)
                    } else {
                        close()
                    }
                }
                ))
            }
            val openPopup4 = ::gen_openPopup4_fn
            fun gen_openPopup5_fn() {
                ui.showConfirm(ClConfirmOptions(title = t("提示"), message = t("确定要删除吗？3秒后自动关闭"), duration = 3000))
            }
            val openPopup5 = ::gen_openPopup5_fn
            return fun(): Any? {
                val _component_cl_button = resolveEasyComponent("cl-button", GenUniModulesCoolUiComponentsClButtonClButtonClass)
                val _component_cl_page = resolveEasyComponent("cl-page", GenUniModulesCoolUiComponentsClPageClPageClass)
                return _cV(_component_cl_page, null, _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                    return _uA(
                        _cE("view", _uM("class" to "p-3"), _uA(
                            _cV(unref(GenPagesDemoComponentsItemClass), _uM("label" to unref(t)("自定义")), _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                                return _uA(
                                    _cV(_component_cl_button, _uM("onClick" to openPopup), _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                                        return _uA(
                                            _tD(unref(t)("打开弹窗"))
                                        )
                                    }
                                    ), "_" to 1))
                                )
                            }
                            ), "_" to 1), 8, _uA(
                                "label"
                            )),
                            _cV(unref(GenPagesDemoComponentsItemClass), _uM("label" to unref(t)("隐藏取消按钮")), _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                                return _uA(
                                    _cV(_component_cl_button, _uM("onClick" to openPopup2), _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                                        return _uA(
                                            _tD(unref(t)("打开弹窗"))
                                        )
                                    }
                                    ), "_" to 1))
                                )
                            }
                            ), "_" to 1), 8, _uA(
                                "label"
                            )),
                            _cV(unref(GenPagesDemoComponentsItemClass), _uM("label" to unref(t)("自定义文本")), _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                                return _uA(
                                    _cV(_component_cl_button, _uM("onClick" to openPopup3), _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                                        return _uA(
                                            _tD(unref(t)("打开弹窗"))
                                        )
                                    }
                                    ), "_" to 1))
                                )
                            }
                            ), "_" to 1), 8, _uA(
                                "label"
                            )),
                            _cV(unref(GenPagesDemoComponentsItemClass), _uM("label" to unref(t)("关闭前钩子")), _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                                return _uA(
                                    _cV(_component_cl_button, _uM("onClick" to openPopup4), _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                                        return _uA(
                                            _tD(unref(t)("打开弹窗"))
                                        )
                                    }
                                    ), "_" to 1))
                                )
                            }
                            ), "_" to 1), 8, _uA(
                                "label"
                            )),
                            _cV(unref(GenPagesDemoComponentsItemClass), _uM("label" to unref(t)("显示时长")), _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                                return _uA(
                                    _cV(_component_cl_button, _uM("onClick" to openPopup5), _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                                        return _uA(
                                            _tD(unref(t)("打开弹窗"))
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
