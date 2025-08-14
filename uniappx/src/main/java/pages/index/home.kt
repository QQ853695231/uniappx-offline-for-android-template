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
open class GenPagesIndexHome : BasePage {
    constructor(__ins: ComponentInternalInstance, __renderer: String?) : super(__ins, __renderer) {
        onPageScroll(fun(e: OnPageScrollOptions) {
            scroller.emit(e.scrollTop)
        }
        , __ins)
        onPageShow(fun() {}, __ins)
    }
    companion object {
        @Suppress("UNUSED_PARAMETER", "UNUSED_VARIABLE")
        var setup: (__props: GenPagesIndexHome) -> Any? = fun(__props): Any? {
            val __ins = getCurrentInstance()!!
            val _ctx = __ins.proxy as GenPagesIndexHome
            val _cache = __ins.renderCache
            val ui = useUi()
            val refs = useRefs()
            val data = computed<UTSArray<Item2>>(fun(): UTSArray<Item2> {
                return _uA(
                    Item2(label = t("基础组件"), children = _uA(
                        Item2(label = t("文本"), icon = "text", path = "/pages/demo/basic/text"),
                        Item2(label = t("按钮"), icon = "mouse-line", path = "/pages/demo/basic/button"),
                        Item2(label = t("图片"), icon = "image-line", path = "/pages/demo/basic/image"),
                        Item2(label = t("图标"), icon = "puzzle-2-line", path = "/pages/demo/basic/icon"),
                        Item2(label = t("标签"), icon = "price-tag-3-line", path = "/pages/demo/basic/tag")
                    )),
                    Item2(label = t("表单组件"), children = _uA(
                        Item2(label = t("表单验证"), icon = "draft-line", path = "/pages/demo/form/form"),
                        Item2(label = t("输入框"), icon = "input-field", path = "/pages/demo/form/input"),
                        Item2(label = t("文本域"), icon = "text-block", path = "/pages/demo/form/textarea"),
                        Item2(label = t("计数器"), icon = "increase-decrease-line", path = "/pages/demo/form/input-number"),
                        Item2(label = t("口令输入"), icon = "input-method-line", path = "/pages/demo/form/input-otp"),
                        Item2(label = t("键盘"), icon = "keyboard-box-line", path = "/pages/demo/form/keyboard"),
                        Item2(label = t("单选框"), icon = "radio-button-line", path = "/pages/demo/form/radio"),
                        Item2(label = t("多选框"), icon = "checkbox-line", path = "/pages/demo/form/checkbox"),
                        Item2(label = t("开关"), icon = "toggle-line", path = "/pages/demo/form/switch"),
                        Item2(label = t("评分"), icon = "star-line", path = "/pages/demo/form/rate"),
                        Item2(label = t("滑块"), icon = "equalizer-2-line", path = "/pages/demo/form/slider"),
                        Item2(label = t("选择器"), icon = "dropdown-list", path = "/pages/demo/form/select"),
                        Item2(label = t("日期选择器"), icon = "calendar-line", path = "/pages/demo/form/select-date"),
                        Item2(label = t("时间选择器"), icon = "time-line", path = "/pages/demo/form/select-time"),
                        Item2(label = t("级联选择器"), icon = "stacked-view", path = "/pages/demo/form/cascader"),
                        Item2(label = t("文件上传"), icon = "file-upload-line", path = "/pages/demo/form/upload")
                    )),
                    Item2(label = t("布局组件"), children = _uA(
                        Item2(label = t("弹性布局"), icon = "layout-2-line", path = "/pages/demo/layout/flex"),
                        Item2(label = t("标签页"), icon = "function-add-line", path = "/pages/demo/layout/tabs"),
                        Item2(label = t("折叠面板"), icon = "collapse-vertical-line", path = "/pages/demo/layout/collapse"),
                        Item2(label = t("吸顶"), icon = "align-top", path = "/pages/demo/layout/sticky"),
                        Item2(label = t("导航栏"), icon = "layout-top-line", path = "/pages/demo/layout/topbar"),
                        Item2(label = t("底部视图"), icon = "layout-bottom-line", path = "/pages/demo/layout/footer"),
                        Item2(label = t("悬浮视图"), icon = "picture-in-picture-line", path = "/pages/demo/layout/float-view")
                    )),
                    Item2(label = t("数据展示"), children = _uA(
                        Item2(label = t("头像"), icon = "account-circle-line", path = "/pages/demo/data/avatar"),
                        Item2(label = t("列表"), icon = "list-check", path = "/pages/demo/data/list"),
                        Item2(label = t("列表视图"), icon = "list-view", path = "/pages/demo/data/list-view"),
                        Item2(label = t("列表刷新"), icon = "refresh-line", path = "/pages/demo/data/list-view-refresh", disabled = false),
                        Item2(label = t("瀑布流"), icon = "layout-column-line", path = "/pages/demo/data/waterfall"),
                        Item2(label = t("轮播图"), icon = "carousel-view", path = "/pages/demo/data/banner"),
                        Item2(label = t("分页"), icon = "page-separator", path = "/pages/demo/data/pagination"),
                        Item2(label = t("时间轴"), icon = "timeline-view", path = "/pages/demo/data/timeline"),
                        Item2(label = t("拖拽"), icon = "drag-move-line", path = "/pages/demo/data/draggable")
                    )),
                    Item2(label = t("状态组件"), children = _uA(
                        Item2(label = t("角标"), icon = "notification-badge-line", path = "/pages/demo/status/badge"),
                        Item2(label = t("通知栏"), icon = "error-warning-line", path = "/pages/demo/status/noticebar"),
                        Item2(label = t("倒计时"), icon = "timer-line", path = "/pages/demo/status/countdown"),
                        Item2(label = t("数字滚动"), icon = "arrow-up-box-line", path = "/pages/demo/status/rolling-number"),
                        Item2(label = t("进度条"), icon = "subtract-line", path = "/pages/demo/status/progress"),
                        Item2(label = t("圆形进度条"), icon = "circle-line", path = "/pages/demo/status/progress-circle"),
                        Item2(label = t("骨架图"), icon = "shadow-line", path = "/pages/demo/status/skeleton"),
                        Item2(label = t("加载更多"), icon = "loader-4-line", path = "/pages/demo/status/loadmore")
                    )),
                    Item2(label = t("反馈组件"), children = _uA(
                        Item2(label = t("操作菜单"), icon = "menu-line", path = "/pages/demo/feedback/action-sheet"),
                        Item2(label = t("弹窗"), icon = "chat-4-line", path = "/pages/demo/feedback/popup"),
                        Item2(label = t("确认框"), icon = "chat-check-line", path = "/pages/demo/feedback/confirm"),
                        Item2(label = t("提示框"), icon = "message-2-line", path = "/pages/demo/feedback/toast")
                    )),
                    Item2(label = "其他", children = _uA(
                        Item2(label = "QRCode", icon = "qr-code-line", path = "/pages/demo/other/qrcode"),
                        Item2(label = t("签名"), icon = "sketching", path = "/pages/demo/other/sign"),
                        Item2(label = t("图片裁剪"), icon = "crop-line", path = "/pages/demo/other/cropper"),
                        Item2(label = t("富文本"), icon = "text-snippet", path = "/pages/demo/other/rict-text", disabled = true),
                        Item2(label = "DayUts", icon = "timer-2-line", path = "/pages/demo/other/day-uts"),
                        Item2(label = "Vibrate", icon = "volume-vibrate-line", path = "/pages/demo/other/vibrate")
                    ))
                )
            }
            )
            fun gen_toPath_fn(item: Item2) {
                if (item.disabled == true) {
                    return ui.showToast(ClToastOptions(message = t("该功能正在开发中")))
                }
                router.to(item.path!!)
            }
            val toPath = ::gen_toPath_fn
            fun gen_setLocale_fn() {
                refs.open("localeSet")
            }
            val setLocale = ::gen_setLocale_fn
            fun gen_setSize_fn() {
                refs.open("sizeSet")
            }
            val setSize = ::gen_setSize_fn
            return fun(): Any? {
                val _component_cl_image = resolveEasyComponent("cl-image", GenUniModulesCoolUiComponentsClImageClImageClass)
                val _component_cl_text = resolveEasyComponent("cl-text", GenUniModulesCoolUiComponentsClTextClTextClass)
                val _component_cl_icon = resolveEasyComponent("cl-icon", GenUniModulesCoolUiComponentsClIconClIconClass)
                val _component_cl_topbar = resolveEasyComponent("cl-topbar", GenUniModulesCoolUiComponentsClTopbarClTopbarClass)
                val _component_cl_col = resolveEasyComponent("cl-col", GenUniModulesCoolUiComponentsClColClColClass)
                val _component_cl_row = resolveEasyComponent("cl-row", GenUniModulesCoolUiComponentsClRowClRowClass)
                val _component_cl_page = resolveEasyComponent("cl-page", GenUniModulesCoolUiComponentsClPageClPageClass)
                return _cV(_component_cl_page, null, _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                    return _uA(
                        _cV(_component_cl_topbar, _uM("fixed" to "", "show-back" to false, "safe-area-top" to "", "height" to if (unref(isMp)()) {
                            null
                        } else {
                            100
                        }
                        ), _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                            return _uA(
                                _cE("view", _uM("class" to _nC(_uA(
                                    "flex flex-row items-center p-3 flex-1 w-full",
                                    _uM("pt-0" to unref(isMp)())
                                ))), _uA(
                                    _cE("view", _uM("class" to "bg-primary-500 rounded-lg p--bracket-start-12rpx-bracket-end-"), _uA(
                                        _cV(_component_cl_image, _uM("src" to "/static/logo.png", "width" to 32, "height" to 32, "show-loading" to false))
                                    )),
                                    _cV(_component_cl_text, _uM("color" to "primary", "pt" to object : UTSJSONObject() {
                                        var className = "-important-text-xl mr-auto ml-2 flex-1"
                                    }), _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                                        return _uA(
                                            _tD(unref(config1).name)
                                        )
                                    }
                                    ), "_" to 1)),
                                    _cE("view", _uM("class" to "bg-surface-500 h-8 w-8 rounded-full flex flex-row items-center justify-center mr-3", "onClick" to setSize), _uA(
                                        _cV(_component_cl_icon, _uM("name" to "font-size", "color" to "white"))
                                    )),
                                    _cE("view", _uM("class" to _nC(_uA(
                                        "bg-primary-500 h-8 w-8 rounded-full flex flex-row items-center justify-center",
                                        _uM("mr-24" to unref(isMp)())
                                    )), "onClick" to setLocale), _uA(
                                        _cV(_component_cl_icon, _uM("name" to "translate", "color" to "white"))
                                    ), 2)
                                ), 2)
                            )
                        }
                        ), "_" to 1), 8, _uA(
                            "height"
                        )),
                        _cE("view", _uM("class" to "p-3"), _uA(
                            _cE(Fragment, null, RenderHelpers.renderList(data.value, fun(item, __key, __index, _cached): Any {
                                return _cE("view", _uM("class" to "group", "key" to item.label), _uA(
                                    _cV(_component_cl_text, _uM("pt" to object : UTSJSONObject() {
                                        var className = "-important-text-sm -important-text-surface-400 mb-2 ml-1"
                                    }), _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                                        return _uA(
                                            _tD(item.label)
                                        )
                                    }
                                    ), "_" to 2), 1024),
                                    _cE("view", _uM("class" to "list"), _uA(
                                        _cV(_component_cl_row, _uM("gutter" to 10), _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                                            return _uA(
                                                _cE(Fragment, null, RenderHelpers.renderList(item.children, fun(child, __key, __index, _cached): Any {
                                                    return _cV(_component_cl_col, _uM("span" to 6, "key" to child.label), _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                                                        return _uA(
                                                            _cE("view", _uM("class" to _nC(_uA(
                                                                "item",
                                                                _uM("dark-colon--important-bg-surface-800" to unref(isDark))
                                                            )), "hover-class" to "opacity-80", "hover-stay-time" to 50, "onClick" to fun(){
                                                                toPath(child)
                                                            }
                                                            ), _uA(
                                                                _cV(_component_cl_icon, _uM("name" to child.icon, "size" to 36), null, 8, _uA(
                                                                    "name"
                                                                )),
                                                                _cV(_component_cl_text, _uM("pt" to object : UTSJSONObject() {
                                                                    var className = "mt-1 -important-text-xs text-center"
                                                                }), _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                                                                    return _uA(
                                                                        _tD(child.label)
                                                                    )
                                                                }
                                                                ), "_" to 2), 1024)
                                                            ), 10, _uA(
                                                                "onClick"
                                                            ))
                                                        )
                                                    }
                                                    ), "_" to 2), 1024)
                                                }
                                                ), 128)
                                            )
                                        }
                                        ), "_" to 2), 1024)
                                    ))
                                ))
                            }
                            ), 128)
                        )),
                        _cV(unref(GenComponentsTabbarClass)),
                        _cV(unref(GenComponentsLocaleSetClass), _uM("ref" to unref(refs).set("localeSet")), null, 512),
                        _cV(unref(GenComponentsSizeSetClass), _uM("ref" to unref(refs).set("sizeSet")), null, 512)
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
                return _uM("group" to _pS(_uM("marginBottom" to "70rpx")), "item" to _uM(".group .list " to _uM("display" to "flex", "flexDirection" to "column", "alignItems" to "center", "borderTopLeftRadius" to "21rpx", "borderTopRightRadius" to "21rpx", "borderBottomRightRadius" to "21rpx", "borderBottomLeftRadius" to "21rpx", "backgroundColor" to "rgba(255,255,255,1)", "paddingLeft" to "14rpx", "paddingRight" to "14rpx", "height" to "140rpx", "marginBottom" to "10rpx", "paddingTop" to "36rpx")))
            }
        var inheritAttrs = true
        var inject: Map<String, Map<String, Any?>> = _uM()
        var emits: Map<String, Any?> = _uM()
        var props = _nP(_uM())
        var propsNeedCastKeys: UTSArray<String> = _uA()
        var components: Map<String, CreateVueComponent> = _uM()
    }
}
