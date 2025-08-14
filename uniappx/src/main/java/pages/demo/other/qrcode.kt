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
import io.dcloud.uniapp.extapi.previewImage as uni_previewImage
open class GenPagesDemoOtherQrcode : BasePage {
    constructor(__ins: ComponentInternalInstance, __renderer: String?) : super(__ins, __renderer) {
        onPageScroll(fun(e: OnPageScrollOptions) {
            scroller.emit(e.scrollTop)
        }
        , __ins)
        onPageShow(fun() {}, __ins)
    }
    companion object {
        @Suppress("UNUSED_PARAMETER", "UNUSED_VARIABLE")
        var setup: (__props: GenPagesDemoOtherQrcode) -> Any? = fun(__props): Any? {
            val __ins = getCurrentInstance()!!
            val _ctx = __ins.proxy as GenPagesDemoOtherQrcode
            val _cache = __ins.renderCache
            val isLogo = ref(true)
            val isPdRadius = ref(true)
            val isPadding = ref(false)
            val isColor = ref(false)
            val qrcodeRef = ref<ClQrcodeComponentPublicInstance?>(null)
            val mode = ref<ClQrcodeMode>("circular")
            val modeList = _uA<ClTabsItem>(ClTabsItem(label = t("矩形"), value = "rect"), ClTabsItem(label = t("点"), value = "circular"), ClTabsItem(label = t("线性"), value = "line"), ClTabsItem(label = t("小方格"), value = "rectSmall"))
            fun gen_save_fn() {
                qrcodeRef.value!!.toPng().then(fun(url){
                    uni_previewImage(PreviewImageOptions(urls = _uA(
                        url
                    )))
                }
                )
            }
            val save = ::gen_save_fn
            return fun(): Any? {
                val _component_cl_qrcode = resolveEasyComponent("cl-qrcode", GenUniModulesCoolUiComponentsClQrcodeClQrcodeClass)
                val _component_cl_switch = resolveEasyComponent("cl-switch", GenUniModulesCoolUiComponentsClSwitchClSwitchClass)
                val _component_cl_list_item = resolveEasyComponent("cl-list-item", GenUniModulesCoolUiComponentsClListItemClListItemClass)
                val _component_cl_button = resolveEasyComponent("cl-button", GenUniModulesCoolUiComponentsClButtonClButtonClass)
                val _component_cl_tabs = resolveEasyComponent("cl-tabs", GenUniModulesCoolUiComponentsClTabsClTabsClass)
                val _component_cl_list = resolveEasyComponent("cl-list", GenUniModulesCoolUiComponentsClListClListClass)
                val _component_cl_page = resolveEasyComponent("cl-page", GenUniModulesCoolUiComponentsClPageClPageClass)
                return _cV(_component_cl_page, null, _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                    return _uA(
                        _cE("view", _uM("class" to "p-3"), _uA(
                            _cV(unref(GenPagesDemoComponentsItemClass), _uM("label" to unref(t)("自定义")), _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                                return _uA(
                                    _cE("view", _uM("class" to "flex flex-row justify-center py-3"), _uA(
                                        _cV(_component_cl_qrcode, _uM("ref_key" to "qrcodeRef", "ref" to qrcodeRef, "text" to "https://cool-js.com/", "logo" to if (isLogo.value) {
                                            "https://unix.cool-js.com/logo.png"
                                        } else {
                                            ""
                                        }
                                        , "pd-radius" to if (isPdRadius.value) {
                                            50
                                        } else {
                                            0
                                        }
                                        , "padding" to if (isPadding.value) {
                                            10
                                        } else {
                                            5
                                        }
                                        , "foreground" to if (isColor.value) {
                                            "#14b8a6"
                                        } else {
                                            "#000000"
                                        }
                                        , "pd-color" to if (isColor.value) {
                                            "#0d9488"
                                        } else {
                                            "#000000"
                                        }
                                        , "mode" to mode.value), null, 8, _uA(
                                            "logo",
                                            "pd-radius",
                                            "padding",
                                            "foreground",
                                            "pd-color",
                                            "mode"
                                        ))
                                    )),
                                    _cV(_component_cl_list, _uM("border" to "", "class" to "mt-3"), _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                                        return _uA(
                                            _cV(_component_cl_list_item, _uM("label" to unref(t)("添加LOGO")), _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                                                return _uA(
                                                    _cV(_component_cl_switch, _uM("modelValue" to isLogo.value, "onUpdate:modelValue" to fun(`$event`: Boolean){
                                                        isLogo.value = `$event`
                                                    }
                                                    ), null, 8, _uA(
                                                        "modelValue",
                                                        "onUpdate:modelValue"
                                                    ))
                                                )
                                            }
                                            ), "_" to 1), 8, _uA(
                                                "label"
                                            )),
                                            _cV(_component_cl_list_item, _uM("label" to unref(t)("圆角定位点")), _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                                                return _uA(
                                                    _cV(_component_cl_switch, _uM("modelValue" to isPdRadius.value, "onUpdate:modelValue" to fun(`$event`: Boolean){
                                                        isPdRadius.value = `$event`
                                                    }
                                                    ), null, 8, _uA(
                                                        "modelValue",
                                                        "onUpdate:modelValue"
                                                    ))
                                                )
                                            }
                                            ), "_" to 1), 8, _uA(
                                                "label"
                                            )),
                                            _cV(_component_cl_list_item, _uM("label" to unref(t)("内间距")), _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                                                return _uA(
                                                    _cV(_component_cl_switch, _uM("modelValue" to isPadding.value, "onUpdate:modelValue" to fun(`$event`: Boolean){
                                                        isPadding.value = `$event`
                                                    }
                                                    ), null, 8, _uA(
                                                        "modelValue",
                                                        "onUpdate:modelValue"
                                                    ))
                                                )
                                            }
                                            ), "_" to 1), 8, _uA(
                                                "label"
                                            )),
                                            _cV(_component_cl_list_item, _uM("label" to unref(t)("自定义颜色")), _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                                                return _uA(
                                                    _cV(_component_cl_switch, _uM("modelValue" to isColor.value, "onUpdate:modelValue" to fun(`$event`: Boolean){
                                                        isColor.value = `$event`
                                                    }
                                                    ), null, 8, _uA(
                                                        "modelValue",
                                                        "onUpdate:modelValue"
                                                    ))
                                                )
                                            }
                                            ), "_" to 1), 8, _uA(
                                                "label"
                                            )),
                                            _cV(_component_cl_list_item, _uM("label" to unref(t)("导出图片")), _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                                                return _uA(
                                                    _cV(_component_cl_button, _uM("onClick" to save), _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
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
                                            _cE("view", _uM("class" to "p-2"), _uA(
                                                _cV(_component_cl_tabs, _uM("modelValue" to mode.value, "onUpdate:modelValue" to fun(`$event`: ClQrcodeMode){
                                                    mode.value = `$event`
                                                }
                                                , "height" to 66, "list" to modeList, "show-slider" to ""), null, 8, _uA(
                                                    "modelValue",
                                                    "onUpdate:modelValue"
                                                ))
                                            ))
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
