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
import io.dcloud.uniapp.extapi.getWindowInfo as uni_getWindowInfo
import io.dcloud.uniapp.extapi.previewImage as uni_previewImage
open class GenPagesDemoOtherSign : BasePage {
    constructor(__ins: ComponentInternalInstance, __renderer: String?) : super(__ins, __renderer) {
        onPageScroll(fun(e: OnPageScrollOptions) {
            scroller.emit(e.scrollTop)
        }
        , __ins)
        onPageShow(fun() {}, __ins)
    }
    companion object {
        @Suppress("UNUSED_PARAMETER", "UNUSED_VARIABLE")
        var setup: (__props: GenPagesDemoOtherSign) -> Any? = fun(__props): Any? {
            val __ins = getCurrentInstance()!!
            val _ctx = __ins.proxy as GenPagesDemoOtherSign
            val _cache = __ins.renderCache
            val height = ref(200)
            val width = ref(0)
            val isFullscreen = ref(false)
            val isBrush = ref(true)
            val signRef = ref<ClSignComponentPublicInstance?>(null)
            fun gen_clear_fn() {
                signRef.value!!.clear()
            }
            val clear = ::gen_clear_fn
            fun gen_preview_fn() {
                signRef.value!!.toPng().then(fun(url){
                    uni_previewImage(PreviewImageOptions(urls = _uA(
                        url
                    )))
                }
                )
            }
            val preview = ::gen_preview_fn
            fun gen_onFullscreenChange_fn() {
                height.value = if (isFullscreen.value) {
                    uni_getWindowInfo().windowHeight - 200
                } else {
                    200
                }
            }
            val onFullscreenChange = ::gen_onFullscreenChange_fn
            onReady(fun(){
                width.value = uni_getWindowInfo().windowWidth
            }
            )
            return fun(): Any? {
                val _component_cl_sign = resolveEasyComponent("cl-sign", GenUniModulesCoolUiComponentsClSignClSignClass)
                val _component_cl_button = resolveEasyComponent("cl-button", GenUniModulesCoolUiComponentsClButtonClButtonClass)
                val _component_cl_list_item = resolveEasyComponent("cl-list-item", GenUniModulesCoolUiComponentsClListItemClListItemClass)
                val _component_cl_switch = resolveEasyComponent("cl-switch", GenUniModulesCoolUiComponentsClSwitchClSwitchClass)
                val _component_cl_list = resolveEasyComponent("cl-list", GenUniModulesCoolUiComponentsClListClListClass)
                val _component_cl_page = resolveEasyComponent("cl-page", GenUniModulesCoolUiComponentsClPageClPageClass)
                return _cV(_component_cl_page, null, _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                    return _uA(
                        _cV(_component_cl_sign, _uM("ref_key" to "signRef", "ref" to signRef, "height" to height.value, "width" to width.value, "enable-brush" to isBrush.value), null, 8, _uA(
                            "height",
                            "width",
                            "enable-brush"
                        )),
                        _cE("view", _uM("class" to "p-3"), _uA(
                            _cV(_component_cl_list, null, _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                                return _uA(
                                    _cV(_component_cl_list_item, _uM("label" to unref(t)("操作")), _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                                        return _uA(
                                            _cV(_component_cl_button, _uM("type" to "info", "onClick" to clear), _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                                                return _uA(
                                                    _tD(unref(t)("清空"))
                                                )
                                            }
                                            ), "_" to 1)),
                                            _cV(_component_cl_button, _uM("onClick" to preview), _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                                                return _uA(
                                                    _tD(unref(t)("预览"))
                                                )
                                            }
                                            ), "_" to 1))
                                        )
                                    }
                                    ), "_" to 1), 8, _uA(
                                        "label"
                                    )),
                                    _cV(_component_cl_list_item, _uM("label" to unref(t)("设置高度")), _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                                        return _uA(
                                            _cV(_component_cl_switch, _uM("modelValue" to isFullscreen.value, "onUpdate:modelValue" to fun(`$event`: Boolean){
                                                isFullscreen.value = `$event`
                                            }
                                            , "onChange" to onFullscreenChange), null, 8, _uA(
                                                "modelValue",
                                                "onUpdate:modelValue"
                                            ))
                                        )
                                    }
                                    ), "_" to 1), 8, _uA(
                                        "label"
                                    )),
                                    _cV(_component_cl_list_item, _uM("label" to unref(t)("毛笔效果")), _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                                        return _uA(
                                            _cV(_component_cl_switch, _uM("modelValue" to isBrush.value, "onUpdate:modelValue" to fun(`$event`: Boolean){
                                                isBrush.value = `$event`
                                            }
                                            ), null, 8, _uA(
                                                "modelValue",
                                                "onUpdate:modelValue"
                                            ))
                                        )
                                    }
                                    ), "_" to 1), 8, _uA(
                                        "label"
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
