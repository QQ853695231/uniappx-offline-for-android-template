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
open class GenPagesDemoStatusSkeleton : BasePage {
    constructor(__ins: ComponentInternalInstance, __renderer: String?) : super(__ins, __renderer) {
        onPageScroll(fun(e: OnPageScrollOptions) {
            scroller.emit(e.scrollTop)
        }
        , __ins)
        onPageShow(fun() {}, __ins)
    }
    companion object {
        @Suppress("UNUSED_PARAMETER", "UNUSED_VARIABLE")
        var setup: (__props: GenPagesDemoStatusSkeleton) -> Any? = fun(__props): Any? {
            val __ins = getCurrentInstance()!!
            val _ctx = __ins.proxy as GenPagesDemoStatusSkeleton
            val _cache = __ins.renderCache
            val loading = ref(true)
            onReady(fun(){
                setTimeout(fun(){
                    loading.value = false
                }
                , 3000)
            }
            )
            return fun(): Any? {
                val _component_cl_text = resolveEasyComponent("cl-text", GenUniModulesCoolUiComponentsClTextClTextClass)
                val _component_cl_skeleton = resolveEasyComponent("cl-skeleton", GenUniModulesCoolUiComponentsClSkeletonClSkeletonClass)
                val _component_cl_button = resolveEasyComponent("cl-button", GenUniModulesCoolUiComponentsClButtonClButtonClass)
                val _component_cl_image = resolveEasyComponent("cl-image", GenUniModulesCoolUiComponentsClImageClImageClass)
                val _component_cl_page = resolveEasyComponent("cl-page", GenUniModulesCoolUiComponentsClPageClPageClass)
                return _cV(_component_cl_page, null, _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                    return _uA(
                        _cE("view", _uM("class" to "p-3"), _uA(
                            _cV(unref(GenPagesDemoComponentsItemClass), _uM("label" to unref(t)("文本")), _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                                return _uA(
                                    _cV(_component_cl_skeleton, _uM("loading" to loading.value), _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                                        return _uA(
                                            _cV(_component_cl_text, null, _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                                                return _uA(
                                                    "云想衣裳花想容，春风拂槛露华浓。"
                                                )
                                            }
                                            ), "_" to 1))
                                        )
                                    }
                                    ), "_" to 1), 8, _uA(
                                        "loading"
                                    ))
                                )
                            }
                            ), "_" to 1), 8, _uA(
                                "label"
                            )),
                            _cV(unref(GenPagesDemoComponentsItemClass), _uM("label" to unref(t)("按钮")), _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                                return _uA(
                                    _cE("view", _uM("class" to "flex flex-row"), _uA(
                                        _cV(_component_cl_skeleton, _uM("type" to "button", "loading" to loading.value), _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                                            return _uA(
                                                _cV(_component_cl_button, null, _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                                                    return _uA(
                                                        "立即购买"
                                                    )
                                                }
                                                ), "_" to 1))
                                            )
                                        }
                                        ), "_" to 1), 8, _uA(
                                            "loading"
                                        ))
                                    ))
                                )
                            }
                            ), "_" to 1), 8, _uA(
                                "label"
                            )),
                            _cV(unref(GenPagesDemoComponentsItemClass), _uM("label" to unref(t)("图片")), _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                                return _uA(
                                    _cV(_component_cl_skeleton, _uM("type" to "image", "loading" to loading.value), _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                                        return _uA(
                                            _cV(_component_cl_image, _uM("src" to "https://uni-docs.cool-js.com/demo/pages/demo/static/bg1.png"))
                                        )
                                    }
                                    ), "_" to 1), 8, _uA(
                                        "loading"
                                    ))
                                )
                            }
                            ), "_" to 1), 8, _uA(
                                "label"
                            )),
                            _cV(unref(GenPagesDemoComponentsItemClass), _uM("label" to unref(t)("圆形")), _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                                return _uA(
                                    _cV(_component_cl_skeleton, _uM("type" to "circle", "loading" to loading.value), _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                                        return _uA(
                                            _cV(_component_cl_image, _uM("radius" to 100, "src" to "https://uni-docs.cool-js.com/demo/pages/demo/static/bg1.png"))
                                        )
                                    }
                                    ), "_" to 1), 8, _uA(
                                        "loading"
                                    ))
                                )
                            }
                            ), "_" to 1), 8, _uA(
                                "label"
                            )),
                            _cV(unref(GenPagesDemoComponentsItemClass), _uM("label" to unref(t)("组合")), _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                                return _uA(
                                    _cE("view", _uM("class" to "flex flex-row"), _uA(
                                        _cV(_component_cl_skeleton, _uM("type" to "image", "loading" to "")),
                                        _cE("view", _uM("class" to "flex-1 ml-2"), _uA(
                                            _cV(_component_cl_skeleton, _uM("type" to "text", "loading" to "")),
                                            _cV(_component_cl_skeleton, _uM("type" to "text", "loading" to "", "class" to "mt-2 -important-w--bracket-start-160rpx-bracket-end-"))
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
