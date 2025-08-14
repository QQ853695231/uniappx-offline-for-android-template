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
open class GenPagesDemoBasicImage : BasePage {
    constructor(__ins: ComponentInternalInstance, __renderer: String?) : super(__ins, __renderer) {
        onPageScroll(fun(e: OnPageScrollOptions) {
            scroller.emit(e.scrollTop)
        }
        , __ins)
        onPageShow(fun() {}, __ins)
    }
    companion object {
        @Suppress("UNUSED_PARAMETER", "UNUSED_VARIABLE")
        var setup: (__props: GenPagesDemoBasicImage) -> Any? = fun(__props): Any? {
            val __ins = getCurrentInstance()!!
            val _ctx = __ins.proxy as GenPagesDemoBasicImage
            val _cache = __ins.renderCache
            val url = ref("https://unix.cool-js.com/images/demo/avatar.jpg")
            return fun(): Any? {
                val _component_cl_image = resolveEasyComponent("cl-image", GenUniModulesCoolUiComponentsClImageClImageClass)
                val _component_cl_text = resolveEasyComponent("cl-text", GenUniModulesCoolUiComponentsClTextClTextClass)
                val _component_cl_page = resolveEasyComponent("cl-page", GenUniModulesCoolUiComponentsClPageClPageClass)
                return _cV(_component_cl_page, null, _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                    return _uA(
                        _cE("view", _uM("class" to "p-3"), _uA(
                            _cV(unref(GenPagesDemoComponentsItemClass), _uM("label" to unref(t)("基础用法")), _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                                return _uA(
                                    _cV(_component_cl_image, _uM("src" to url.value), null, 8, _uA(
                                        "src"
                                    ))
                                )
                            }
                            ), "_" to 1), 8, _uA(
                                "label"
                            )),
                            _cV(unref(GenPagesDemoComponentsItemClass), _uM("label" to unref(t)("不同裁剪")), _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                                return _uA(
                                    _cE("view", _uM("class" to "flex flex-row justify-between"), _uA(
                                        _cE("view", _uM("class" to "flex flex-col items-center justify-center"), _uA(
                                            _cV(_component_cl_image, _uM("src" to url.value, "mode" to "aspectFill"), null, 8, _uA(
                                                "src"
                                            )),
                                            _cV(_component_cl_text, _uM("class" to "-important-text-sm mt-1"), _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                                                return _uA(
                                                    "aspectFill"
                                                )
                                            }
                                            ), "_" to 1))
                                        )),
                                        _cE("view", _uM("class" to "flex flex-col items-center justify-center"), _uA(
                                            _cV(_component_cl_image, _uM("src" to url.value, "mode" to "aspectFit"), null, 8, _uA(
                                                "src"
                                            )),
                                            _cV(_component_cl_text, _uM("class" to "-important-text-sm mt-1"), _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                                                return _uA(
                                                    "aspectFit"
                                                )
                                            }
                                            ), "_" to 1))
                                        )),
                                        _cE("view", _uM("class" to "flex flex-col items-center justify-center"), _uA(
                                            _cV(_component_cl_image, _uM("src" to url.value, "mode" to "heightFix"), null, 8, _uA(
                                                "src"
                                            )),
                                            _cV(_component_cl_text, _uM("class" to "-important-text-sm mt-1"), _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                                                return _uA(
                                                    "heightFix"
                                                )
                                            }
                                            ), "_" to 1))
                                        )),
                                        _cE("view", _uM("class" to "flex flex-col items-center justify-center"), _uA(
                                            _cV(_component_cl_image, _uM("src" to url.value, "mode" to "scaleToFill"), null, 8, _uA(
                                                "src"
                                            )),
                                            _cV(_component_cl_text, _uM("class" to "-important-text-sm mt-1"), _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                                                return _uA(
                                                    "scaleToFill"
                                                )
                                            }
                                            ), "_" to 1))
                                        ))
                                    ))
                                )
                            }
                            ), "_" to 1), 8, _uA(
                                "label"
                            )),
                            _cV(unref(GenPagesDemoComponentsItemClass), _uM("label" to unref(t)("点击可预览")), _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                                return _uA(
                                    _cV(_component_cl_image, _uM("src" to url.value, "preview" to ""), null, 8, _uA(
                                        "src"
                                    ))
                                )
                            }
                            ), "_" to 1), 8, _uA(
                                "label"
                            )),
                            _cV(unref(GenPagesDemoComponentsItemClass), _uM("label" to unref(t)("失败时显示")), _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                                return _uA(
                                    _cV(_component_cl_image, _uM("src" to "url"))
                                )
                            }
                            ), "_" to 1), 8, _uA(
                                "label"
                            )),
                            _cV(unref(GenPagesDemoComponentsItemClass), _uM("label" to unref(t)("加载中")), _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                                return _uA(
                                    _cV(_component_cl_image, _uM("src" to ""))
                                )
                            }
                            ), "_" to 1), 8, _uA(
                                "label"
                            )),
                            _cV(unref(GenPagesDemoComponentsItemClass), _uM("label" to unref(t)("自定义圆角")), _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                                return _uA(
                                    _cE("view", _uM("class" to "flex flex-row"), _uA(
                                        _cV(_component_cl_image, _uM("src" to url.value, "pt" to object : UTSJSONObject() {
                                            var inner = object : UTSJSONObject() {
                                                var className = "-important-rounded-none"
                                            }
                                        }), null, 8, _uA(
                                            "src"
                                        )),
                                        _cV(_component_cl_image, _uM("src" to url.value, "pt" to object : UTSJSONObject() {
                                            var className = "ml-3"
                                            var inner = object : UTSJSONObject() {
                                                var className = "-important-rounded-2xl"
                                            }
                                        }), null, 8, _uA(
                                            "src"
                                        )),
                                        _cV(_component_cl_image, _uM("src" to url.value, "pt" to object : UTSJSONObject() {
                                            var className = "ml-3"
                                            var inner = object : UTSJSONObject() {
                                                var className = "-important-rounded-3xl"
                                            }
                                        }), null, 8, _uA(
                                            "src"
                                        )),
                                        _cV(_component_cl_image, _uM("src" to url.value, "pt" to object : UTSJSONObject() {
                                            var className = "ml-3"
                                            var inner = object : UTSJSONObject() {
                                                var className = "-important-rounded-full"
                                            }
                                        }), null, 8, _uA(
                                            "src"
                                        ))
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
