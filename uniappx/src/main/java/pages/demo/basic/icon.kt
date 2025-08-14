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
import io.dcloud.uniapp.extapi.setClipboardData as uni_setClipboardData
open class GenPagesDemoBasicIcon : BasePage {
    constructor(__ins: ComponentInternalInstance, __renderer: String?) : super(__ins, __renderer) {
        onPageScroll(fun(e: OnPageScrollOptions) {
            scroller.emit(e.scrollTop)
        }
        , __ins)
        onPageShow(fun() {}, __ins)
    }
    companion object {
        @Suppress("UNUSED_PARAMETER", "UNUSED_VARIABLE")
        var setup: (__props: GenPagesDemoBasicIcon) -> Any? = fun(__props): Any? {
            val __ins = getCurrentInstance()!!
            val _ctx = __ins.proxy as GenPagesDemoBasicIcon
            val _cache = __ins.renderCache
            val ui = useUi()
            val remixicon = ref(_uA<String>())
            val iconfont = ref(_uA<String>())
            forInObject(icons, fun(value, key){
                if (key == "iconfont") {
                    iconfont.value = keys(value).slice(0, 100)
                } else {
                    remixicon.value = keys(value).slice(0, 100)
                }
            }
            )
            fun gen_copy_fn(data: String) {
                uni_setClipboardData(SetClipboardDataOptions(data = data, showToast = false, success = fun(_) {
                    ui.showToast(ClToastOptions(message = t("复制成功")))
                }
                ))
            }
            val copy = ::gen_copy_fn
            return fun(): Any? {
                val _component_cl_icon = resolveEasyComponent("cl-icon", GenUniModulesCoolUiComponentsClIconClIconClass)
                val _component_cl_text = resolveEasyComponent("cl-text", GenUniModulesCoolUiComponentsClTextClTextClass)
                val _component_cl_col = resolveEasyComponent("cl-col", GenUniModulesCoolUiComponentsClColClColClass)
                val _component_cl_row = resolveEasyComponent("cl-row", GenUniModulesCoolUiComponentsClRowClRowClass)
                val _component_cl_page = resolveEasyComponent("cl-page", GenUniModulesCoolUiComponentsClPageClPageClass)
                return _cV(_component_cl_page, null, _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                    return _uA(
                        _cE("view", _uM("class" to "p-3"), _uA(
                            _cV(unref(GenPagesDemoComponentsItemClass), _uM("label" to unref(t)("设置颜色")), _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                                return _uA(
                                    _cE("view", _uM("class" to "flex flex-row"), _uA(
                                        _cV(_component_cl_icon, _uM("name" to "heart-fill", "color" to "primary", "class" to "mr-2")),
                                        _cV(_component_cl_icon, _uM("name" to "heart-fill", "color" to "success", "class" to "mr-2")),
                                        _cV(_component_cl_icon, _uM("name" to "heart-fill", "color" to "error", "class" to "mr-2")),
                                        _cV(_component_cl_icon, _uM("name" to "heart-fill", "color" to "warn", "class" to "mr-2")),
                                        _cV(_component_cl_icon, _uM("name" to "heart-fill", "color" to "info", "class" to "mr-2")),
                                        _cV(_component_cl_icon, _uM("name" to "heart-fill", "color" to "#428bca", "class" to "mr-2")),
                                        _cV(_component_cl_icon, _uM("name" to "heart-fill", "color" to "purple"))
                                    ))
                                )
                            }
                            ), "_" to 1), 8, _uA(
                                "label"
                            )),
                            _cV(unref(GenPagesDemoComponentsItemClass), _uM("label" to unref(t)("设置大小")), _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                                return _uA(
                                    _cE("view", _uM("class" to "flex flex-row"), _uA(
                                        _cV(_component_cl_icon, _uM("name" to "heart-fill", "class" to "mr-2", "size" to 50)),
                                        _cV(_component_cl_icon, _uM("name" to "heart-fill", "class" to "mr-2", "size" to 40)),
                                        _cV(_component_cl_icon, _uM("name" to "heart-fill", "class" to "mr-2", "size" to 30)),
                                        _cV(_component_cl_icon, _uM("name" to "heart-fill", "class" to "mr-2", "size" to 20))
                                    ))
                                )
                            }
                            ), "_" to 1), 8, _uA(
                                "label"
                            )),
                            _cV(unref(GenPagesDemoComponentsItemClass), null, _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                                return _uA(
                                    _cV(_component_cl_text, null, _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                                        return _uA(
                                            _tD(unref(t)("集成 iconfont 与 remixicon 图标库，展示部分示例"))
                                        )
                                    }
                                    ), "_" to 1))
                                )
                            }
                            ), "_" to 1)),
                            _cV(unref(GenPagesDemoComponentsItemClass), _uM("label" to unref(t)("iconfont")), _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                                return _uA(
                                    _cV(_component_cl_row, _uM("gutter" to 10), _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                                        return _uA(
                                            _cE(Fragment, null, RenderHelpers.renderList(iconfont.value, fun(item, __key, __index, _cached): Any {
                                                return _cV(_component_cl_col, _uM("span" to 4, "key" to item), _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                                                    return _uA(
                                                        _cE("view", _uM("class" to "flex flex-col items-center justify-center h--bracket-start-100rpx-bracket-end- rounded-lg", "hover-class" to "opacity-60", "hover-stay-time" to 100, "onClick" to fun(){
                                                            copy(item)
                                                        }
                                                        ), _uA(
                                                            _cV(_component_cl_icon, _uM("name" to item), null, 8, _uA(
                                                                "name"
                                                            ))
                                                        ), 8, _uA(
                                                            "onClick"
                                                        ))
                                                    )
                                                }
                                                ), "_" to 2), 1024)
                                            }
                                            ), 128)
                                        )
                                    }
                                    ), "_" to 1))
                                )
                            }
                            ), "_" to 1), 8, _uA(
                                "label"
                            )),
                            _cV(unref(GenPagesDemoComponentsItemClass), _uM("label" to unref(t)("remixicon")), _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                                return _uA(
                                    _cV(_component_cl_row, _uM("gutter" to 10), _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                                        return _uA(
                                            _cE(Fragment, null, RenderHelpers.renderList(remixicon.value, fun(item, __key, __index, _cached): Any {
                                                return _cV(_component_cl_col, _uM("span" to 4, "key" to item), _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                                                    return _uA(
                                                        _cE("view", _uM("class" to "flex flex-col items-center justify-center h--bracket-start-100rpx-bracket-end-", "hover-class" to "opacity-60", "hover-stay-time" to 100, "onClick" to fun(){
                                                            copy(item)
                                                        }
                                                        ), _uA(
                                                            _cV(_component_cl_icon, _uM("name" to item), null, 8, _uA(
                                                                "name"
                                                            ))
                                                        ), 8, _uA(
                                                            "onClick"
                                                        ))
                                                    )
                                                }
                                                ), "_" to 2), 1024)
                                            }
                                            ), 128)
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
