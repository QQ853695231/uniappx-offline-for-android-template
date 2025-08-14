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
open class GenPagesDemoFeedbackActionSheet : BasePage {
    constructor(__ins: ComponentInternalInstance, __renderer: String?) : super(__ins, __renderer) {
        onPageScroll(fun(e: OnPageScrollOptions) {
            scroller.emit(e.scrollTop)
        }
        , __ins)
        onPageShow(fun() {}, __ins)
    }
    companion object {
        @Suppress("UNUSED_PARAMETER", "UNUSED_VARIABLE")
        var setup: (__props: GenPagesDemoFeedbackActionSheet) -> Any? = fun(__props): Any? {
            val __ins = getCurrentInstance()!!
            val _ctx = __ins.proxy as GenPagesDemoFeedbackActionSheet
            val _cache = __ins.renderCache
            val ui = useUi()
            val actionSheetRef = ref<ClActionSheetComponentPublicInstance?>(null)
            fun gen_openActionSheet_fn() {
                actionSheetRef.value!!.open(ClActionSheetOptions(list = _uA(
                    ClActionSheetItem(label = t("反馈"))
                )))
            }
            val openActionSheet = ::gen_openActionSheet_fn
            val actionSheetRef2 = ref<ClActionSheetComponentPublicInstance?>(null)
            fun gen_openActionSheet2_fn() {
                actionSheetRef.value!!.open(ClActionSheetOptions(list = _uA(
                    ClActionSheetItem(label = t("反馈"), icon = "error-warning-line")
                )))
            }
            val openActionSheet2 = ::gen_openActionSheet2_fn
            val actionSheetRef3 = ref<ClActionSheetComponentPublicInstance?>(null)
            fun gen_openActionSheet3_fn() {
                actionSheetRef.value!!.open(ClActionSheetOptions(title = t("提示"), description = t("删除好友会同时删除所有聊天记录"), list = _uA(
                    ClActionSheetItem(label = t("删除好友"), color = "error", callback = fun() {
                        ui.showConfirm(ClConfirmOptions(title = t("提示"), message = t("确定要删除好友吗？"), callback = fun(action) {
                            if (action == "confirm") {
                                ui.showToast(ClToastOptions(message = t("删除成功")))
                            }
                            actionSheetRef.value!!.close()
                        }
                        ))
                    }
                    )
                )))
            }
            val openActionSheet3 = ::gen_openActionSheet3_fn
            val actionSheetRef4 = ref<ClActionSheetComponentPublicInstance?>(null)
            fun gen_openActionSheet4_fn() {
                actionSheetRef.value!!.open(ClActionSheetOptions(maskClosable = false, description = t("无法点击遮罩关闭"), list = _uA()))
            }
            val openActionSheet4 = ::gen_openActionSheet4_fn
            val actionSheetRef5 = ref<ClActionSheetComponentPublicInstance?>(null)
            fun gen_openActionSheet5_fn() {
                actionSheetRef.value!!.open(ClActionSheetOptions(showCancel = false, list = _uA(
                    ClActionSheetItem(label = t("点我关闭"), callback = fun() {
                        ui.showConfirm(ClConfirmOptions(title = t("提示"), message = t("确定要关闭吗？"), callback = fun(action) {
                            if (action == "confirm") {
                                actionSheetRef.value!!.close()
                            }
                        }
                        ))
                    }
                    )
                )))
            }
            val openActionSheet5 = ::gen_openActionSheet5_fn
            val agree = ref(false)
            val actionSheetRef6 = ref<ClActionSheetComponentPublicInstance?>(null)
            fun gen_openActionSheet6_fn() {
                fun done() {
                    if (!agree.value) {
                        ui.showToast(ClToastOptions(message = "请阅读并同意《会员服务协议》"))
                        return
                    }
                    ui.showToast(ClToastOptions(message = t("支付成功")))
                    agree.value = false
                    actionSheetRef6.value!!.close()
                }
                actionSheetRef6.value!!.open(ClActionSheetOptions(showCancel = false, list = _uA(
                    ClActionSheetItem(label = t("支付宝"), icon = "alipay-line", callback = fun() {
                        done()
                    }
                    ),
                    ClActionSheetItem(label = t("微信"), icon = "wechat-line", callback = fun() {
                        done()
                    }
                    )
                )))
            }
            val openActionSheet6 = ::gen_openActionSheet6_fn
            return fun(): Any? {
                val _component_cl_button = resolveEasyComponent("cl-button", GenUniModulesCoolUiComponentsClButtonClButtonClass)
                val _component_cl_action_sheet = resolveEasyComponent("cl-action-sheet", GenUniModulesCoolUiComponentsClActionSheetClActionSheetClass)
                val _component_cl_text = resolveEasyComponent("cl-text", GenUniModulesCoolUiComponentsClTextClTextClass)
                val _component_cl_checkbox = resolveEasyComponent("cl-checkbox", GenUniModulesCoolUiComponentsClCheckboxClCheckboxClass)
                val _component_cl_icon = resolveEasyComponent("cl-icon", GenUniModulesCoolUiComponentsClIconClIconClass)
                val _component_cl_page = resolveEasyComponent("cl-page", GenUniModulesCoolUiComponentsClPageClPageClass)
                return _cV(_component_cl_page, null, _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                    return _uA(
                        _cE("view", _uM("class" to "p-3"), _uA(
                            _cV(unref(GenPagesDemoComponentsItemClass), _uM("label" to unref(t)("基础用法")), _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                                return _uA(
                                    _cV(_component_cl_button, _uM("onClick" to openActionSheet), _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                                        return _uA(
                                            _tD(unref(t)("打开"))
                                        )
                                    }
                                    ), "_" to 1))
                                )
                            }
                            ), "_" to 1), 8, _uA(
                                "label"
                            )),
                            _cV(unref(GenPagesDemoComponentsItemClass), _uM("label" to unref(t)("带图标")), _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                                return _uA(
                                    _cV(_component_cl_button, _uM("onClick" to openActionSheet2), _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                                        return _uA(
                                            _tD(unref(t)("打开"))
                                        )
                                    }
                                    ), "_" to 1))
                                )
                            }
                            ), "_" to 1), 8, _uA(
                                "label"
                            )),
                            _cV(unref(GenPagesDemoComponentsItemClass), _uM("label" to unref(t)("带标题、描述")), _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                                return _uA(
                                    _cV(_component_cl_button, _uM("onClick" to openActionSheet3), _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                                        return _uA(
                                            _tD(unref(t)("打开"))
                                        )
                                    }
                                    ), "_" to 1))
                                )
                            }
                            ), "_" to 1), 8, _uA(
                                "label"
                            )),
                            _cV(unref(GenPagesDemoComponentsItemClass), _uM("label" to unref(t)("无法点击遮罩关闭")), _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                                return _uA(
                                    _cV(_component_cl_button, _uM("onClick" to openActionSheet4), _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                                        return _uA(
                                            _tD(unref(t)("打开"))
                                        )
                                    }
                                    ), "_" to 1))
                                )
                            }
                            ), "_" to 1), 8, _uA(
                                "label"
                            )),
                            _cV(unref(GenPagesDemoComponentsItemClass), _uM("label" to unref(t)("不需要取消按钮")), _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                                return _uA(
                                    _cV(_component_cl_button, _uM("onClick" to openActionSheet5), _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                                        return _uA(
                                            _tD(unref(t)("打开"))
                                        )
                                    }
                                    ), "_" to 1))
                                )
                            }
                            ), "_" to 1), 8, _uA(
                                "label"
                            )),
                            _cV(unref(GenPagesDemoComponentsItemClass), _uM("label" to unref(t)("插槽用法")), _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                                return _uA(
                                    _cV(_component_cl_button, _uM("onClick" to openActionSheet6), _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                                        return _uA(
                                            _tD(unref(t)("打开"))
                                        )
                                    }
                                    ), "_" to 1))
                                )
                            }
                            ), "_" to 1), 8, _uA(
                                "label"
                            ))
                        )),
                        _cV(_component_cl_action_sheet, _uM("ref_key" to "actionSheetRef", "ref" to actionSheetRef), null, 512),
                        _cV(_component_cl_action_sheet, _uM("ref_key" to "actionSheetRef2", "ref" to actionSheetRef2), null, 512),
                        _cV(_component_cl_action_sheet, _uM("ref_key" to "actionSheetRef3", "ref" to actionSheetRef3), null, 512),
                        _cV(_component_cl_action_sheet, _uM("ref_key" to "actionSheetRef4", "ref" to actionSheetRef4), null, 512),
                        _cV(_component_cl_action_sheet, _uM("ref_key" to "actionSheetRef5", "ref" to actionSheetRef5), null, 512),
                        _cV(_component_cl_action_sheet, _uM("ref_key" to "actionSheetRef6", "ref" to actionSheetRef6, "pt" to object : UTSJSONObject() {
                            var list = object : UTSJSONObject() {
                                var className = "flex-row mx--bracket-start--10rpx-bracket-end-"
                            }
                            var item = object : UTSJSONObject() {
                                var className = "flex-1 mx--bracket-start-10rpx-bracket-end- -important-rounded-xl"
                            }
                        }), _uM("prepend" to withSlotCtx(fun(): UTSArray<Any> {
                            return _uA(
                                _cE("view", _uM("class" to "px-3 mb-3"), _uA(
                                    _cV(_component_cl_text, null, _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                                        return _uA(
                                            "开通会员享受更多特权和服务，包括无广告体验、专属客服等"
                                        )
                                    }
                                    ), "_" to 1))
                                ))
                            )
                        }
                        ), "append" to withSlotCtx(fun(): UTSArray<Any> {
                            return _uA(
                                _cE("view", _uM("class" to "pb-5 pt-2 px-3 flex flex-row items-center"), _uA(
                                    _cV(_component_cl_checkbox, _uM("modelValue" to agree.value, "onUpdate:modelValue" to fun(`$event`: Boolean){
                                        agree.value = `$event`
                                    }
                                    ), _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                                        return _uA(
                                            "请阅读并同意"
                                        )
                                    }
                                    ), "_" to 1), 8, _uA(
                                        "modelValue",
                                        "onUpdate:modelValue"
                                    )),
                                    _cV(_component_cl_text, _uM("color" to "primary"), _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                                        return _uA(
                                            "《会员服务协议》"
                                        )
                                    }
                                    ), "_" to 1))
                                ))
                            )
                        }
                        ), "item" to withScopedSlotCtx(fun(slotProps: GenUniModulesCoolUiComponentsClActionSheetClActionSheetSlotDataItem): UTSArray<Any> {
                            val item = slotProps.item
                            return _uA(
                                _cE("view", _uM("class" to "flex flex-col justify-center items-center"), _uA(
                                    _cV(_component_cl_icon, _uM("name" to item.icon, "size" to 46), null, 8, _uA(
                                        "name"
                                    )),
                                    _cV(_component_cl_text, _uM("pt" to object : UTSJSONObject() {
                                        var className = "-important-text-sm mt-1"
                                    }), _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                                        return _uA(
                                            _tD(item.label)
                                        )
                                    }
                                    ), "_" to 2), 1024)
                                ))
                            )
                        }
                        ), "_" to 1), 512)
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
