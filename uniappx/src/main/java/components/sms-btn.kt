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
open class GenComponentsSmsBtn : VueComponent {
    constructor(__ins: ComponentInternalInstance) : super(__ins) {}
    open var phone: String? by `$props`
    open var open: () -> Unit
        get() {
            return unref(this.`$exposed`["open"]) as () -> Unit
        }
        set(value) {
            setRefValue(this.`$exposed`, "open", value)
        }
    open var send: () -> UTSPromise<Unit>
        get() {
            return unref(this.`$exposed`["send"]) as () -> UTSPromise<Unit>
        }
        set(value) {
            setRefValue(this.`$exposed`, "send", value)
        }
    open var getCaptcha: () -> UTSPromise<Unit>
        get() {
            return unref(this.`$exposed`["getCaptcha"]) as () -> UTSPromise<Unit>
        }
        set(value) {
            setRefValue(this.`$exposed`, "getCaptcha", value)
        }
    open var startCountdown: () -> Unit
        get() {
            return unref(this.`$exposed`["startCountdown"]) as () -> Unit
        }
        set(value) {
            setRefValue(this.`$exposed`, "startCountdown", value)
        }
    companion object {
        @Suppress("UNUSED_PARAMETER", "UNUSED_VARIABLE")
        var setup: (__props: GenComponentsSmsBtn, _arg1: SetupContext) -> Any? = fun(__props, ref1): Any? {
            var __expose = ref1.expose
            val __ins = getCurrentInstance()!!
            val _ctx = __ins.proxy as GenComponentsSmsBtn
            val _cache = __ins.renderCache
            val props = __props
            fun emit(event: String, vararg do_not_transform_spread: Any?) {
                __ins.emit(event, *do_not_transform_spread)
            }
            val popupRef = ref<ClPopupComponentPublicInstance?>(null)
            val ui = useUi()
            val captcha = reactive<Captcha>(Captcha(visible = false, loading = false, sending = false, img = ""))
            val countdown = ref(0)
            val isDisabled = computed(fun(): Boolean {
                return countdown.value > 0 || props.phone == ""
            }
            )
            val btnText = computed(fun(): String {
                return if (countdown.value > 0) {
                    `$t`("{n}s后重新获取", object : UTSJSONObject() {
                        var n = countdown.value
                    })
                } else {
                    t("获取验证码")
                }
            }
            )
            val code = ref("")
            val captchaId = ref("")
            fun gen_clear_fn() {
                code.value = ""
                captchaId.value = ""
            }
            val clear = ::gen_clear_fn
            fun gen_close_fn() {
                captcha.visible = false
                captcha.img = ""
                clear()
            }
            val close = ::gen_close_fn
            fun gen_startCountdown_fn() {
                countdown.value = 60
                var timer: Number = 0
                fun fn() {
                    countdown.value--
                    if (countdown.value < 1) {
                        clearInterval(timer)
                    }
                }
                timer = setInterval(fun(){
                    fn()
                }
                , 1000)
                fn()
            }
            val startCountdown = ::gen_startCountdown_fn
            fun gen_getCaptcha_fn(): UTSPromise<Unit> {
                return wrapUTSPromise(suspend {
                        clear()
                        captcha.loading = true
                        open class Res (
                            @JsonNotNull
                            open var captchaId: String,
                            @JsonNotNull
                            open var data: String,
                        ) : UTSObject()
                        await(service.user.login.captcha(object : UTSJSONObject() {
                            var color = if (isDark.value) {
                                "#ffffff"
                            } else {
                                "#2c3142"
                            }
                            var phone = props.phone
                        }).then(fun(res){
                            val data = parse<Res>(res)!!
                            captchaId.value = data.captchaId
                            captcha.img = data.data
                        }
                        ).`catch`(fun(err){
                            ui.showToast(ClToastOptions(message = (err as Response).message!!))
                        }
                        ))
                        captcha.loading = false
                })
            }
            val getCaptcha = ::gen_getCaptcha_fn
            fun gen_send_fn(): UTSPromise<Unit> {
                return wrapUTSPromise(suspend {
                        if (code.value != "") {
                            captcha.sending = true
                            await(service.user.login.smsCode(object : UTSJSONObject() {
                                var phone = props.phone
                                var code = code.value
                                var captchaId = captchaId.value
                            }).then(fun(){
                                ui.showToast(ClToastOptions(message = t("短信已发送，请查收")))
                                startCountdown()
                                close()
                                emit("success")
                            }).`catch`(fun(err){
                                ui.showToast(ClToastOptions(message = (err as Response).message!!))
                                getCaptcha()
                            }))
                            captcha.sending = false
                        } else {
                            ui.showToast(ClToastOptions(message = t("请填写验证码")))
                        }
                })
            }
            val send = ::gen_send_fn
            fun gen_open_fn() {
                if (props.phone != "") {
                    if (UTSRegExp("^(?:(?:\\+|00)86)?1[3-9]\\d{9}\$", "").test(props.phone!!)) {
                        captcha.visible = true
                        getCaptcha()
                    } else {
                        ui.showToast(ClToastOptions(message = t("请填写正确的手机号格式")))
                    }
                }
            }
            val open = ::gen_open_fn
            __expose(_uM("open" to open, "send" to send, "getCaptcha" to getCaptcha, "startCountdown" to startCountdown))
            return fun(): Any? {
                val _component_cl_button = resolveEasyComponent("cl-button", GenUniModulesCoolUiComponentsClButtonClButtonClass)
                val _component_cl_input = resolveEasyComponent("cl-input", GenUniModulesCoolUiComponentsClInputClInputClass)
                val _component_cl_image = resolveEasyComponent("cl-image", GenUniModulesCoolUiComponentsClImageClImageClass)
                val _component_cl_popup = resolveEasyComponent("cl-popup", GenUniModulesCoolUiComponentsClPopupClPopupClass)
                return _cE(Fragment, null, _uA(
                    renderSlot(_ctx.`$slots`, "default", _uM("disabled" to isDisabled.value, "countdown" to countdown.value, "btnText" to btnText.value), fun(): UTSArray<Any> {
                        return _uA(
                            _cV(_component_cl_button, _uM("text" to "", "disabled" to isDisabled.value, "onClick" to open), _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                                return _uA(
                                    _tD(btnText.value)
                                )
                            }
                            ), "_" to 1), 8, _uA(
                                "disabled"
                            ))
                        )
                    }
                    ),
                    _cV(_component_cl_popup, _uM("modelValue" to captcha.visible, "onUpdate:modelValue" to fun(`$event`: Boolean){
                        captcha.visible = `$event`
                    }
                    , "ref_key" to "popupRef", "ref" to popupRef, "direction" to "center", "title" to unref(t)("获取短信验证码")), _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                        return _uA(
                            if (isTrue(captcha.visible)) {
                                _cE("view", _uM("key" to 0, "class" to "p-3 pt-2 pb-4 w--bracket-start-460rpx-bracket-end-"), _uA(
                                    _cE("view", _uM("class" to "flex flex-row items-center"), _uA(
                                        _cV(_component_cl_input, _uM("modelValue" to code.value, "onUpdate:modelValue" to fun(`$event`: String){
                                            code.value = `$event`
                                        }, "placeholder" to unref(t)("验证码"), "maxlength" to 4, "autofocus" to "", "clearable" to false, "pt" to object : UTSJSONObject() {
                                            var className = "flex-1 mr-2 -important-h--bracket-start-70rpx-bracket-end-"
                                        }, "onConfirm" to send), null, 8, _uA(
                                            "modelValue",
                                            "onUpdate:modelValue",
                                            "placeholder"
                                        )),
                                        _cV(_component_cl_image, _uM("src" to captcha.img, "height" to 70, "width" to 200, "pt" to object : UTSJSONObject() {
                                            var className = "-important-rounded-lg"
                                            var error = object : UTSJSONObject() {
                                                var className = unref(parseClass)(_uA(
                                                    _uA(
                                                        unref(isDark),
                                                        "-important-bg-surface-800",
                                                        "-important-bg-surface-200"
                                                    )
                                                ))
                                                var name = "refresh-line"
                                            }
                                        }, "onClick" to getCaptcha), null, 8, _uA(
                                            "src",
                                            "pt"
                                        ))
                                    )),
                                    _cV(_component_cl_button, _uM("type" to "primary", "disabled" to (code.value == ""), "loading" to captcha.sending, "pt" to object : UTSJSONObject() {
                                        var className = "-important-h--bracket-start-70rpx-bracket-end- mt-3"
                                    }, "onClick" to send), _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                                        return _uA(
                                            _tD(unref(t)("发送短信"))
                                        )
                                    }), "_" to 1), 8, _uA(
                                        "disabled",
                                        "loading"
                                    ))
                                ))
                            } else {
                                _cC("v-if", true)
                            }
                        )
                    }
                    ), "_" to 1), 8, _uA(
                        "modelValue",
                        "onUpdate:modelValue",
                        "title"
                    ))
                ), 64)
            }
        }
        val styles: Map<String, Map<String, Map<String, Any>>> by lazy {
            _nCS(_uA())
        }
        var inheritAttrs = true
        var inject: Map<String, Map<String, Any?>> = _uM()
        var emits: Map<String, Any?> = _uM("success" to null)
        var props = _nP(_uM("phone" to _uM("type" to "String")))
        var propsNeedCastKeys: UTSArray<String> = _uA()
        var components: Map<String, CreateVueComponent> = _uM()
    }
}
