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
import io.dcloud.uniapp.extapi.chooseImage as uni_chooseImage
import io.dcloud.uniapp.extapi.previewImage as uni_previewImage
open class GenPagesDemoOtherCropper : BasePage {
    constructor(__ins: ComponentInternalInstance, __renderer: String?) : super(__ins, __renderer) {
        onPageScroll(fun(e: OnPageScrollOptions) {
            scroller.emit(e.scrollTop)
        }
        , __ins)
        onPageShow(fun() {}, __ins)
    }
    companion object {
        @Suppress("UNUSED_PARAMETER", "UNUSED_VARIABLE")
        var setup: (__props: GenPagesDemoOtherCropper) -> Any? = fun(__props): Any? {
            val __ins = getCurrentInstance()!!
            val _ctx = __ins.proxy as GenPagesDemoOtherCropper
            val _cache = __ins.renderCache
            val cropperRef = ref<ClCropperComponentPublicInstance?>(null)
            val resizable = ref(true)
            fun gen_chooseImage_fn() {
                uni_chooseImage(ChooseImageOptions(count = 1, sizeType = _uA(
                    "original",
                    "compressed"
                ), sourceType = _uA(
                    "album",
                    "camera"
                ), success = fun(res){
                    if (res.tempFilePaths.length > 0) {
                        cropperRef.value!!.open(res.tempFilePaths[0])
                    }
                }
                ))
            }
            val chooseImage = ::gen_chooseImage_fn
            fun gen_onCrop_fn(url: String) {
                uni_previewImage(PreviewImageOptions(urls = _uA(
                    url
                )))
            }
            val onCrop = ::gen_onCrop_fn
            fun gen_onImageLoad_fn(e: UniImageLoadEvent) {
                console.log("onImageLoad", e)
            }
            val onImageLoad = ::gen_onImageLoad_fn
            return fun(): Any? {
                val _component_cl_button = resolveEasyComponent("cl-button", GenUniModulesCoolUiComponentsClButtonClButtonClass)
                val _component_cl_switch = resolveEasyComponent("cl-switch", GenUniModulesCoolUiComponentsClSwitchClSwitchClass)
                val _component_cl_list_item = resolveEasyComponent("cl-list-item", GenUniModulesCoolUiComponentsClListItemClListItemClass)
                val _component_cl_list = resolveEasyComponent("cl-list", GenUniModulesCoolUiComponentsClListClListClass)
                val _component_cl_page = resolveEasyComponent("cl-page", GenUniModulesCoolUiComponentsClPageClPageClass)
                val _component_cl_cropper = resolveEasyComponent("cl-cropper", GenUniModulesCoolUiComponentsClCropperClCropperClass)
                return _cE(Fragment, null, _uA(
                    _cV(_component_cl_page, null, _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                        return _uA(
                            _cE("view", _uM("class" to "p-3"), _uA(
                                _cV(unref(GenPagesDemoComponentsItemClass), _uM("label" to unref(t)("自定义")), _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                                    return _uA(
                                        _cV(_component_cl_button, _uM("onClick" to chooseImage), _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                                            return _uA(
                                                _tD(unref(t)("选择图片"))
                                            )
                                        }
                                        ), "_" to 1)),
                                        _cV(_component_cl_list, _uM("border" to "", "pt" to object : UTSJSONObject() {
                                            var className = "mt-5"
                                        }), _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                                            return _uA(
                                                _cV(_component_cl_list_item, _uM("label" to unref(t)("可调节裁剪框大小")), _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                                                    return _uA(
                                                        _cV(_component_cl_switch, _uM("modelValue" to resizable.value, "onUpdate:modelValue" to fun(`$event`: Boolean){
                                                            resizable.value = `$event`
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
                                    )
                                }
                                ), "_" to 1), 8, _uA(
                                    "label"
                                ))
                            ))
                        )
                    }
                    ), "_" to 1)),
                    _cV(_component_cl_cropper, _uM("ref_key" to "cropperRef", "ref" to cropperRef, "resizable" to resizable.value, "onCrop" to onCrop, "onLoad" to onImageLoad), null, 8, _uA(
                        "resizable"
                    ))
                ), 64)
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
