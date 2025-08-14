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
open class GenPagesDemoFormKeyboard : BasePage {
    constructor(__ins: ComponentInternalInstance, __renderer: String?) : super(__ins, __renderer) {
        onPageScroll(fun(e: OnPageScrollOptions) {
            scroller.emit(e.scrollTop)
        }
        , __ins)
        onPageShow(fun() {}, __ins)
    }
    companion object {
        @Suppress("UNUSED_PARAMETER", "UNUSED_VARIABLE")
        var setup: (__props: GenPagesDemoFormKeyboard) -> Any? = fun(__props): Any? {
            val __ins = getCurrentInstance()!!
            val _ctx = __ins.proxy as GenPagesDemoFormKeyboard
            val _cache = __ins.renderCache
            val keyboardNumberRef = ref<ClKeyboardNumberComponentPublicInstance?>(null)
            val isShowValue = ref(true)
            val isInputImmediate = ref(false)
            val isIdcard = ref(false)
            val content = ref("")
            fun gen_openKeyboardNumber_fn() {
                keyboardNumberRef.value!!.open()
            }
            val openKeyboardNumber = ::gen_openKeyboardNumber_fn
            val keyboardPasswordRef = ref<ClKeyboardPasswordComponentPublicInstance?>(null)
            val isEncrypt = ref(false)
            fun gen_openKeyboardPassword_fn() {
                keyboardPasswordRef.value!!.open()
            }
            val openKeyboardPassword = ::gen_openKeyboardPassword_fn
            val keyboardCarRef = ref<ClKeyboardCarComponentPublicInstance?>(null)
            val carNumber = ref("")
            fun gen_openKeyboardCar_fn() {
                keyboardCarRef.value!!.open()
            }
            val openKeyboardCar = ::gen_openKeyboardCar_fn
            return fun(): Any? {
                val _component_cl_input = resolveEasyComponent("cl-input", GenUniModulesCoolUiComponentsClInputClInputClass)
                val _component_cl_button = resolveEasyComponent("cl-button", GenUniModulesCoolUiComponentsClButtonClButtonClass)
                val _component_cl_switch = resolveEasyComponent("cl-switch", GenUniModulesCoolUiComponentsClSwitchClSwitchClass)
                val _component_cl_list_item = resolveEasyComponent("cl-list-item", GenUniModulesCoolUiComponentsClListItemClListItemClass)
                val _component_cl_list = resolveEasyComponent("cl-list", GenUniModulesCoolUiComponentsClListClListClass)
                val _component_cl_input_otp = resolveEasyComponent("cl-input-otp", GenUniModulesCoolUiComponentsClInputOtpClInputOtpClass)
                val _component_cl_keyboard_number = resolveEasyComponent("cl-keyboard-number", GenUniModulesCoolUiComponentsClKeyboardNumberClKeyboardNumberClass)
                val _component_cl_keyboard_car = resolveEasyComponent("cl-keyboard-car", GenUniModulesCoolUiComponentsClKeyboardCarClKeyboardCarClass)
                val _component_cl_keyboard_password = resolveEasyComponent("cl-keyboard-password", GenUniModulesCoolUiComponentsClKeyboardPasswordClKeyboardPasswordClass)
                val _component_cl_page = resolveEasyComponent("cl-page", GenUniModulesCoolUiComponentsClPageClPageClass)
                return _cV(_component_cl_page, null, _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                    return _uA(
                        _cE("view", _uM("class" to "p-3"), _uA(
                            _cV(unref(GenPagesDemoComponentsItemClass), _uM("label" to unref(t)("数字键盘")), _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                                return _uA(
                                    _cE("view", _uM("class" to "mb-3"), _uA(
                                        _cV(_component_cl_input, _uM("type" to "number", "modelValue" to content.value, "onUpdate:modelValue" to fun(`$event`: String){
                                            content.value = `$event`
                                        }
                                        ), null, 8, _uA(
                                            "modelValue",
                                            "onUpdate:modelValue"
                                        ))
                                    )),
                                    _cV(_component_cl_button, _uM("onClick" to openKeyboardNumber), _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                                        return _uA(
                                            _tD(unref(t)("打开键盘"))
                                        )
                                    }
                                    ), "_" to 1)),
                                    _cV(_component_cl_list, _uM("border" to "", "pt" to object : UTSJSONObject() {
                                        var className = "mt-3"
                                    }), _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                                        return _uA(
                                            _cV(_component_cl_list_item, _uM("label" to unref(t)("是否显示输入值")), _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                                                return _uA(
                                                    _cV(_component_cl_switch, _uM("modelValue" to isShowValue.value, "onUpdate:modelValue" to fun(`$event`: Boolean){
                                                        isShowValue.value = `$event`
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
                                            _cV(_component_cl_list_item, _uM("label" to unref(t)("输入即绑定")), _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                                                return _uA(
                                                    _cV(_component_cl_switch, _uM("modelValue" to isInputImmediate.value, "onUpdate:modelValue" to fun(`$event`: Boolean){
                                                        isInputImmediate.value = `$event`
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
                                            _cV(_component_cl_list_item, _uM("label" to unref(t)("身份证键盘")), _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                                                return _uA(
                                                    _cV(_component_cl_switch, _uM("modelValue" to isIdcard.value, "onUpdate:modelValue" to fun(`$event`: Boolean){
                                                        isIdcard.value = `$event`
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
                            )),
                            _cV(unref(GenPagesDemoComponentsItemClass), _uM("label" to unref(t)("密码键盘")), _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                                return _uA(
                                    _cV(_component_cl_button, _uM("onClick" to openKeyboardPassword), _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                                        return _uA(
                                            _tD(unref(t)("打开键盘"))
                                        )
                                    }
                                    ), "_" to 1)),
                                    _cV(_component_cl_list, _uM("border" to "", "pt" to object : UTSJSONObject() {
                                        var className = "mt-3"
                                    }), _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                                        return _uA(
                                            _cV(_component_cl_list_item, _uM("label" to unref(t)("是否加密")), _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                                                return _uA(
                                                    _cV(_component_cl_switch, _uM("modelValue" to isEncrypt.value, "onUpdate:modelValue" to fun(`$event`: Boolean){
                                                        isEncrypt.value = `$event`
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
                            )),
                            _cV(unref(GenPagesDemoComponentsItemClass), _uM("label" to unref(t)("车牌号键盘")), _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                                return _uA(
                                    _cE("view", _uM("class" to "flex mb-3 justify-center flex-row"), _uA(
                                        _cV(_component_cl_input_otp, _uM("input-type" to "text", "length" to 8, "pt" to object : UTSJSONObject() {
                                            var className = "w-full"
                                            var list = object : UTSJSONObject() {
                                                var className = "justify-between"
                                            }
                                            var item = object : UTSJSONObject() {
                                                var className = "-important-h-9 -important-w-9"
                                            }
                                            var cursor = object : UTSJSONObject() {
                                                var className = "-important-h-3"
                                            }
                                        }, "modelValue" to carNumber.value, "onUpdate:modelValue" to fun(`$event`: String){
                                            carNumber.value = `$event`
                                        }
                                        ), null, 8, _uA(
                                            "modelValue",
                                            "onUpdate:modelValue"
                                        ))
                                    )),
                                    _cV(_component_cl_button, _uM("onClick" to openKeyboardCar), _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                                        return _uA(
                                            _tD(unref(t)("打开键盘"))
                                        )
                                    }
                                    ), "_" to 1))
                                )
                            }
                            ), "_" to 1), 8, _uA(
                                "label"
                            ))
                        )),
                        _cV(_component_cl_keyboard_number, _uM("modelValue" to content.value, "onUpdate:modelValue" to fun(`$event`: String){
                            content.value = `$event`
                        }
                        , "ref_key" to "keyboardNumberRef", "ref" to keyboardNumberRef, "show-value" to isShowValue.value, "input-immediate" to isInputImmediate.value, "type" to if (isIdcard.value) {
                            "idcard"
                        } else {
                            "number"
                        }
                        ), null, 8, _uA(
                            "modelValue",
                            "onUpdate:modelValue",
                            "show-value",
                            "input-immediate",
                            "type"
                        )),
                        _cV(_component_cl_keyboard_car, _uM("modelValue" to carNumber.value, "onUpdate:modelValue" to fun(`$event`: String){
                            carNumber.value = `$event`
                        }
                        , "ref_key" to "keyboardCarRef", "ref" to keyboardCarRef), null, 8, _uA(
                            "modelValue",
                            "onUpdate:modelValue"
                        )),
                        _cV(_component_cl_keyboard_password, _uM("ref_key" to "keyboardPasswordRef", "ref" to keyboardPasswordRef, "encrypt" to isEncrypt.value), null, 8, _uA(
                            "encrypt"
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
