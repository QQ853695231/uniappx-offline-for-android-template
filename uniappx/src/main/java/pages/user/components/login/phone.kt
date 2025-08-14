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
open class GenPagesUserComponentsLoginPhone : VueComponent {
    constructor(__ins: ComponentInternalInstance) : super(__ins) {}
    open var form: LoginForm by `$props`
    companion object {
        @Suppress("UNUSED_PARAMETER", "UNUSED_VARIABLE")
        var setup: (__props: GenPagesUserComponentsLoginPhone) -> Any? = fun(__props): Any? {
            val __ins = getCurrentInstance()!!
            val _ctx = __ins.proxy as GenPagesUserComponentsLoginPhone
            val _cache = __ins.renderCache
            val props = __props
            fun emit(event: String, vararg do_not_transform_spread: Any?) {
                __ins.emit(event, *do_not_transform_spread)
            }
            val ui = useUi()
            val refs = useRefs()
            val isAgree = inject("isAgree") as () -> Boolean
            val showCode = ref(false)
            val loading = ref(false)
            val disabled = computed(fun(): Boolean {
                return props.form.phone == "" || props.form.smsCode == ""
            }
            )
            fun gen_toLogin_fn(): UTSPromise<Unit> {
                return wrapUTSPromise(suspend w@{
                        if (!isAgree()) {
                            return@w
                        }
                        val _props_form = props.form
                        val phone = _props_form.phone
                        val smsCode = _props_form.smsCode
                        loading.value = true
                        await(service.user.login.phone(_uO("phone" to phone, "smsCode" to smsCode)).then(fun(res){
                            emit("success", res)
                        }
                        ).`catch`(fun(err){
                            ui.showToast(ClToastOptions(message = (err as Response).message!!))
                        }
                        ))
                        loading.value = false
                })
            }
            val toLogin = ::gen_toLogin_fn
            return fun(): Any? {
                val _component_cl_text = resolveEasyComponent("cl-text", GenUniModulesCoolUiComponentsClTextClTextClass)
                val _component_cl_input = resolveEasyComponent("cl-input", GenUniModulesCoolUiComponentsClInputClInputClass)
                val _component_cl_button = resolveEasyComponent("cl-button", GenUniModulesCoolUiComponentsClButtonClButtonClass)
                return _cE(Fragment, null, _uA(
                    _cE("view", _uM("class" to "flex flex-col mb-5"), _uA(
                        _cV(_component_cl_text, _uM("pt" to object : UTSJSONObject() {
                            var className = "-important-text-lg font-bold"
                        }), _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                            return _uA(
                                _tD(unref(t)("手机登录"))
                            )
                        }
                        ), "_" to 1)),
                        _cV(_component_cl_text, _uM("pt" to object : UTSJSONObject() {
                            var className = "-important-text-sm mt-2"
                        }, "color" to "info"), _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                            return _uA(
                                _tD(unref(t)("未注册的手机号登录成功后将自动注册"))
                            )
                        }
                        ), "_" to 1))
                    )),
                    _cE("view", _uM("class" to "flex flex-col"), _uA(
                        _cE("view", _uM("class" to "mb-3 flex flex-row"), _uA(
                            _cV(_component_cl_input, _uM("modelValue" to _ctx.form.phone, "onUpdate:modelValue" to fun(`$event`: String){
                                _ctx.form.phone = `$event`
                            }
                            , "prefix-icon" to "device-fill", "placeholder" to unref(t)("请输入手机号"), "border" to false, "pt" to object : UTSJSONObject() {
                                var className = unref(parseClass)(_uA(
                                    "-important-h--bracket-start-90rpx-bracket-end- flex-1 -important-rounded-xl -important-px-4",
                                    _uA(
                                        unref(isDark),
                                        "-important-bg-surface-70",
                                        "-important-bg-white"
                                    )
                                ))
                                var prefixIcon = object : UTSJSONObject() {
                                    var className = "mr-1"
                                }
                            }), null, 8, _uA(
                                "modelValue",
                                "onUpdate:modelValue",
                                "placeholder",
                                "pt"
                            ))
                        )),
                        _cE("view", _uM("class" to "relative flex flex-row items-center mb-5"), _uA(
                            _cV(_component_cl_input, _uM("modelValue" to _ctx.form.smsCode, "onUpdate:modelValue" to fun(`$event`: String){
                                _ctx.form.smsCode = `$event`
                            }
                            , "clearable" to false, "type" to "number", "prefix-icon" to "shield-check-fill", "placeholder" to unref(t)("请输入验证码"), "maxlength" to 4, "border" to false, "pt" to object : UTSJSONObject() {
                                var className = unref(parseClass)(_uA(
                                    "-important-h--bracket-start-90rpx-bracket-end- flex-1 -important-rounded-xl -important-px-4",
                                    _uA(
                                        unref(isDark),
                                        "-important-bg-surface-70",
                                        "-important-bg-white"
                                    )
                                ))
                                var prefixIcon = object : UTSJSONObject() {
                                    var className = "mr-1"
                                }
                            }), null, 8, _uA(
                                "modelValue",
                                "onUpdate:modelValue",
                                "placeholder",
                                "pt"
                            )),
                            _cE("view", _uM("class" to "absolute right-0"), _uA(
                                _cV(unref(GenComponentsSmsBtnClass), _uM("ref" to unref(refs).set("smsBtn"), "phone" to _ctx.form.phone, "onSuccess" to fun(){
                                    showCode.value = true
                                }
                                ), null, 8, _uA(
                                    "phone",
                                    "onSuccess"
                                ))
                            ))
                        )),
                        _cV(_component_cl_button, _uM("pt" to object : UTSJSONObject() {
                            var className = "-important-h--bracket-start-90rpx-bracket-end- -important-rounded-xl"
                        }, "loading" to loading.value, "disabled" to disabled.value, "onClick" to toLogin), _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                            return _uA(
                                _tD(unref(t)("登录"))
                            )
                        }
                        ), "_" to 1), 8, _uA(
                            "loading",
                            "disabled"
                        ))
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
        var props = _nP(_uM("form" to _uM("type" to "Object", "default" to fun(): UTSJSONObject {
            return (UTSJSONObject())
        }
        )))
        var propsNeedCastKeys = _uA(
            "form"
        )
        var components: Map<String, CreateVueComponent> = _uM()
    }
}
