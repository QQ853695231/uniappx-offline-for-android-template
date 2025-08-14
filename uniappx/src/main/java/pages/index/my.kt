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
open class GenPagesIndexMy : BasePage {
    constructor(__ins: ComponentInternalInstance, __renderer: String?) : super(__ins, __renderer) {
        onPageScroll(fun(e: OnPageScrollOptions) {
            scroller.emit(e.scrollTop)
        }
        , __ins)
        onPageShow(fun() {}, __ins)
    }
    companion object {
        @Suppress("UNUSED_PARAMETER", "UNUSED_VARIABLE")
        var setup: (__props: GenPagesIndexMy) -> Any? = fun(__props): Any? {
            val __ins = getCurrentInstance()!!
            val _ctx = __ins.proxy as GenPagesIndexMy
            val _cache = __ins.renderCache
            val user = useStore().user
            val ui = useUi()
            fun gen_toTest_fn() {
                ui.showToast(ClToastOptions(message = t("开发中，敬请期待")))
            }
            val toTest = ::gen_toTest_fn
            fun gen_toSet_fn() {
                router.to("/pages/set/index")
            }
            val toSet = ::gen_toSet_fn
            fun gen_toEdit_fn() {
                router.to("/pages/user/edit")
            }
            val toEdit = ::gen_toEdit_fn
            onReady(fun(){
                user.get()
            }
            )
            return fun(): Any? {
                val _component_cl_icon = resolveEasyComponent("cl-icon", GenUniModulesCoolUiComponentsClIconClIconClass)
                val _component_cl_topbar = resolveEasyComponent("cl-topbar", GenUniModulesCoolUiComponentsClTopbarClTopbarClass)
                val _component_cl_avatar = resolveEasyComponent("cl-avatar", GenUniModulesCoolUiComponentsClAvatarClAvatarClass)
                val _component_cl_text = resolveEasyComponent("cl-text", GenUniModulesCoolUiComponentsClTextClTextClass)
                val _component_cl_rolling_number = resolveEasyComponent("cl-rolling-number", GenUniModulesCoolUiComponentsClRollingNumberClRollingNumberClass)
                val _component_cl_col = resolveEasyComponent("cl-col", GenUniModulesCoolUiComponentsClColClColClass)
                val _component_cl_row = resolveEasyComponent("cl-row", GenUniModulesCoolUiComponentsClRowClRowClass)
                val _component_cl_switch = resolveEasyComponent("cl-switch", GenUniModulesCoolUiComponentsClSwitchClSwitchClass)
                val _component_cl_badge = resolveEasyComponent("cl-badge", GenUniModulesCoolUiComponentsClBadgeClBadgeClass)
                val _component_cl_list_item = resolveEasyComponent("cl-list-item", GenUniModulesCoolUiComponentsClListItemClListItemClass)
                val _component_cl_list = resolveEasyComponent("cl-list", GenUniModulesCoolUiComponentsClListClListClass)
                val _component_cl_page = resolveEasyComponent("cl-page", GenUniModulesCoolUiComponentsClPageClPageClass)
                return _cV(_component_cl_page, null, _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                    return _uA(
                        _cV(_component_cl_topbar, _uM("fixed" to "", "height" to 100, "show-back" to false, "safe-area-top" to "", "background-color" to "transparent"), _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                            return _uA(
                                _cE("view", _uM("class" to "flex flex-row items-center w-full flex-1 px-3"), _uA(
                                    _cE("view", _uM("class" to _nC(_uA(
                                        "top-icon",
                                        _uM("dark-colon--important-bg-surface-700" to unref(isDark))
                                    )), "onClick" to toSet), _uA(
                                        _cV(_component_cl_icon, _uM("name" to "settings-line"))
                                    ), 2),
                                    _cE("view", _uM("class" to _nC(_uA(
                                        "top-icon",
                                        _uM("dark-colon--important-bg-surface-700" to unref(isDark))
                                    )), "onClick" to toTest), _uA(
                                        _cV(_component_cl_icon, _uM("name" to "notification-4-line"))
                                    ), 2)
                                ))
                            )
                        }
                        ), "_" to 1)),
                        _cE("view", _uM("class" to "p-3"), _uA(
                            _cE("view", _uM("class" to "flex flex-col justify-center items-center pt-6 pb-3"), _uA(
                                _cE("view", _uM("class" to "relative overflow-visible", "onClick" to toEdit), _uA(
                                    _cV(_component_cl_avatar, _uM("src" to unref(user).info.avatarUrl, "size" to 150, "pt" to object : UTSJSONObject() {
                                        var className = "-important-rounded-3xl"
                                        var icon = object : UTSJSONObject() {
                                            var size: Number = 60
                                        }
                                    }), null, 8, _uA(
                                        "src"
                                    )),
                                    if (isTrue(!unref(user).isNull())) {
                                        _cE("view", _uM("key" to 0, "class" to "flex flex-col justify-center items-center absolute bottom-0 right--bracket-start--6rpx-bracket-end- bg-black rounded-full p-1"), _uA(
                                            _cV(_component_cl_icon, _uM("name" to "edit-line", "color" to "white", "size" to 24))
                                        ))
                                    } else {
                                        _cC("v-if", true)
                                    }
                                )),
                                _cE("view", _uM("class" to "flex-1 flex flex-col justify-center items-center w-full", "onClick" to toEdit), _uA(
                                    _cV(_component_cl_text, _uM("pt" to object : UTSJSONObject() {
                                        var className = "-important-text-xl mt-5 mb-1 font-bold"
                                    }), _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                                        return _uA(
                                            _tD(unref(user).info.nickName ?: unref(t)("未登录"))
                                        )
                                    }
                                    ), "_" to 1)),
                                    if (isTrue(!unref(user).isNull())) {
                                        _cV(_component_cl_text, _uM("key" to 0, "color" to "info"), _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                                            return _uA(
                                                _tD(unref(user).info.phone)
                                            )
                                        }), "_" to 1))
                                    } else {
                                        _cC("v-if", true)
                                    }
                                ))
                            )),
                            _cV(_component_cl_row, _uM("pt" to object : UTSJSONObject() {
                                var className = "pt-3 pb-6"
                            }), _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                                return _uA(
                                    _cV(_component_cl_col, _uM("span" to 6), _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                                        return _uA(
                                            _cE("view", _uM("class" to "flex flex-col items-center justify-center"), _uA(
                                                _cV(_component_cl_rolling_number, _uM("pt" to object : UTSJSONObject() {
                                                    var className = "-important-text-xl"
                                                }, "value" to 171)),
                                                _cV(_component_cl_text, _uM("pt" to object : UTSJSONObject() {
                                                    var className = "mt-1 -important-text-xs"
                                                }, "color" to "info"), _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                                                    return _uA(
                                                        _tD(unref(t)("总点击"))
                                                    )
                                                }
                                                ), "_" to 1))
                                            ))
                                        )
                                    }
                                    ), "_" to 1)),
                                    _cV(_component_cl_col, _uM("span" to 6), _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                                        return _uA(
                                            _cE("view", _uM("class" to "flex flex-col items-center justify-center"), _uA(
                                                _cV(_component_cl_rolling_number, _uM("pt" to object : UTSJSONObject() {
                                                    var className = "-important-text-xl"
                                                }, "value" to 24)),
                                                _cV(_component_cl_text, _uM("pt" to object : UTSJSONObject() {
                                                    var className = "mt-1 -important-text-xs"
                                                }, "color" to "info"), _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                                                    return _uA(
                                                        _tD(unref(t)("赞"))
                                                    )
                                                }
                                                ), "_" to 1))
                                            ))
                                        )
                                    }
                                    ), "_" to 1)),
                                    _cV(_component_cl_col, _uM("span" to 6), _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                                        return _uA(
                                            _cE("view", _uM("class" to "flex flex-col items-center justify-center"), _uA(
                                                _cV(_component_cl_rolling_number, _uM("pt" to object : UTSJSONObject() {
                                                    var className = "-important-text-xl"
                                                }, "value" to 89)),
                                                _cV(_component_cl_text, _uM("pt" to object : UTSJSONObject() {
                                                    var className = "mt-1 -important-text-xs"
                                                }, "color" to "info"), _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                                                    return _uA(
                                                        _tD(unref(t)("收藏"))
                                                    )
                                                }
                                                ), "_" to 1))
                                            ))
                                        )
                                    }
                                    ), "_" to 1)),
                                    _cV(_component_cl_col, _uM("span" to 6), _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                                        return _uA(
                                            _cE("view", _uM("class" to "flex flex-col items-center justify-center"), _uA(
                                                _cV(_component_cl_rolling_number, _uM("pt" to object : UTSJSONObject() {
                                                    var className = "-important-text-xl"
                                                }, "value" to 653)),
                                                _cV(_component_cl_text, _uM("pt" to object : UTSJSONObject() {
                                                    var className = "mt-1 -important-text-xs"
                                                }, "color" to "info"), _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                                                    return _uA(
                                                        _tD(unref(t)("粉丝"))
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
                            _cV(_component_cl_row, _uM("gutter" to 20, "pt" to object : UTSJSONObject() {
                                var className = "mb-3"
                            }), _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                                return _uA(
                                    _cV(_component_cl_col, _uM("span" to 12), _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                                        return _uA(
                                            _cE("view", _uM("class" to _nC(_uA(
                                                "bg-white p-4 rounded-2xl flex flex-row",
                                                _uM("dark-colon--important-bg-surface-800" to unref(isDark))
                                            ))), _uA(
                                                _cE("view", _uM("class" to "flex flex-col mr-auto"), _uA(
                                                    _cV(_component_cl_text, _uM("ellipsis" to "", "pt" to object : UTSJSONObject() {
                                                        var className = "-important-w--bracket-start-180rpx-bracket-end-"
                                                    }), _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                                                        return _uA(
                                                            _tD(unref(t)("接单模式"))
                                                        )
                                                    }
                                                    ), "_" to 1)),
                                                    _cV(_component_cl_text, _uM("pt" to object : UTSJSONObject() {
                                                        var className = "-important-text-xs mt-1"
                                                    }, "color" to "info"), _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                                                        return _uA(
                                                            _tD(unref(t)("已关闭"))
                                                        )
                                                    }
                                                    ), "_" to 1))
                                                )),
                                                _cV(_component_cl_switch)
                                            ), 2)
                                        )
                                    }
                                    ), "_" to 1)),
                                    _cV(_component_cl_col, _uM("span" to 12), _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                                        return _uA(
                                            _cE("view", _uM("class" to _nC(_uA(
                                                "bg-white p-4 rounded-2xl flex flex-row",
                                                _uM("dark-colon--important-bg-surface-800" to unref(isDark))
                                            ))), _uA(
                                                _cE("view", _uM("class" to "flex flex-col mr-auto"), _uA(
                                                    _cV(_component_cl_text, _uM("ellipsis" to "", "pt" to object : UTSJSONObject() {
                                                        var className = "-important-w--bracket-start-180rpx-bracket-end-"
                                                    }), _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                                                        return _uA(
                                                            _tD(unref(t)("消息通知"))
                                                        )
                                                    }
                                                    ), "_" to 1)),
                                                    _cV(_component_cl_text, _uM("pt" to object : UTSJSONObject() {
                                                        var className = "-important-text-xs mt-1"
                                                    }, "color" to "info"), _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                                                        return _uA(
                                                            _tD(unref(t)("已关闭"))
                                                        )
                                                    }
                                                    ), "_" to 1))
                                                )),
                                                _cV(_component_cl_switch)
                                            ), 2)
                                        )
                                    }
                                    ), "_" to 1))
                                )
                            }
                            ), "_" to 1)),
                            _cE("view", _uM("class" to _nC(_uA(
                                "bg-white py-5 rounded-2xl mb-3 h--bracket-start-160rpx-bracket-end-",
                                _uM("dark-colon--important-bg-surface-800" to unref(isDark))
                            ))), _uA(
                                _cV(_component_cl_row, _uM("pt" to object : UTSJSONObject() {
                                    var className = "overflow-visible"
                                }), _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                                    return _uA(
                                        _cV(_component_cl_col, _uM("span" to 6), _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                                            return _uA(
                                                _cE("view", _uM("class" to "flex flex-col justify-center items-center px-2"), _uA(
                                                    _cV(_component_cl_icon, _uM("name" to "money-cny-circle-line", "size" to 46)),
                                                    _cV(_component_cl_text, _uM("pt" to object : UTSJSONObject() {
                                                        var className = "-important-text-xs mt-2 text-center"
                                                    }, "color" to "info"), _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                                                        return _uA(
                                                            _tD(unref(t)("待支付"))
                                                        )
                                                    }
                                                    ), "_" to 1))
                                                ))
                                            )
                                        }
                                        ), "_" to 1)),
                                        _cV(_component_cl_col, _uM("span" to 6), _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                                            return _uA(
                                                _cE("view", _uM("class" to "flex flex-col justify-center items-center px-2"), _uA(
                                                    _cV(_component_cl_icon, _uM("name" to "box-1-line", "size" to 46)),
                                                    _cV(_component_cl_text, _uM("pt" to object : UTSJSONObject() {
                                                        var className = "-important-text-xs mt-2 text-center"
                                                    }, "color" to "info"), _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                                                        return _uA(
                                                            _tD(unref(t)("未发货"))
                                                        )
                                                    }
                                                    ), "_" to 1))
                                                ))
                                            )
                                        }
                                        ), "_" to 1)),
                                        _cV(_component_cl_col, _uM("span" to 6), _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                                            return _uA(
                                                _cE("view", _uM("class" to "flex flex-col justify-center items-center relative overflow-visible px-2"), _uA(
                                                    _cV(_component_cl_icon, _uM("name" to "flight-takeoff-line", "size" to 46)),
                                                    _cV(_component_cl_text, _uM("pt" to object : UTSJSONObject() {
                                                        var className = "-important-text-xs mt-2 text-center"
                                                    }, "color" to "info"), _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                                                        return _uA(
                                                            _tD(unref(t)("已发货"))
                                                        )
                                                    }
                                                    ), "_" to 1)),
                                                    _cV(_component_cl_badge, _uM("type" to "primary", "value" to 3, "position" to "", "pt" to object : UTSJSONObject() {
                                                        var className = "-important-right-6"
                                                    }))
                                                ))
                                            )
                                        }
                                        ), "_" to 1)),
                                        _cV(_component_cl_col, _uM("span" to 6), _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                                            return _uA(
                                                _cE("view", _uM("class" to "flex flex-col justify-center items-center px-2"), _uA(
                                                    _cV(_component_cl_icon, _uM("name" to "exchange-cny-line", "size" to 46)),
                                                    _cV(_component_cl_text, _uM("pt" to object : UTSJSONObject() {
                                                        var className = "-important-text-xs mt-2 text-center"
                                                    }, "color" to "info"), _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                                                        return _uA(
                                                            _tD(unref(t)("售后 / 退款"))
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
                            ), 2),
                            _cV(_component_cl_list, _uM("pt" to object : UTSJSONObject() {
                                var className = "mb-3"
                            }), _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                                return _uA(
                                    _cV(_component_cl_list_item, _uM("label" to unref(t)("我的钱包"), "icon" to "wallet-line", "arrow" to "", "hoverable" to "", "onClick" to toTest), null, 8, _uA(
                                        "label"
                                    )),
                                    _cV(_component_cl_list_item, _uM("label" to unref(t)("数据看板"), "icon" to "pie-chart-line", "arrow" to "", "hoverable" to "", "onClick" to toTest), null, 8, _uA(
                                        "label"
                                    )),
                                    _cV(_component_cl_list_item, _uM("label" to unref(t)("历史记录"), "icon" to "history-line", "arrow" to "", "hoverable" to "", "onClick" to toTest), null, 8, _uA(
                                        "label"
                                    )),
                                    _cV(_component_cl_list_item, _uM("label" to unref(t)("邀请好友"), "icon" to "share-line", "arrow" to "", "hoverable" to "", "onClick" to toTest), null, 8, _uA(
                                        "label"
                                    ))
                                )
                            }
                            ), "_" to 1)),
                            _cV(_component_cl_list, null, _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                                return _uA(
                                    _cV(_component_cl_list_item, _uM("label" to unref(t)("设置"), "icon" to "settings-line", "arrow" to "", "hoverable" to "", "onClick" to toSet), null, 8, _uA(
                                        "label"
                                    ))
                                )
                            }
                            ), "_" to 1))
                        )),
                        _cV(unref(GenComponentsTabbarClass))
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
                return _uM("top-icon" to _pS(_uM("marginRight" to "21rpx", "display" to "flex", "alignItems" to "center", "justifyContent" to "center", "borderTopLeftRadius" to "14rpx", "borderTopRightRadius" to "14rpx", "borderBottomRightRadius" to "14rpx", "borderBottomLeftRadius" to "14rpx", "backgroundColor" to "rgba(255,255,255,1)", "paddingTop" to "14rpx", "paddingRight" to "14rpx", "paddingBottom" to "14rpx", "paddingLeft" to "14rpx")))
            }
        var inheritAttrs = true
        var inject: Map<String, Map<String, Any?>> = _uM()
        var emits: Map<String, Any?> = _uM()
        var props = _nP(_uM())
        var propsNeedCastKeys: UTSArray<String> = _uA()
        var components: Map<String, CreateVueComponent> = _uM()
    }
}
