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
open class GenPagesUserLogin : BasePage {
    constructor(__ins: ComponentInternalInstance, __renderer: String?) : super(__ins, __renderer) {
        onPageScroll(fun(e: OnPageScrollOptions) {
            scroller.emit(e.scrollTop)
        }
        , __ins)
        onPageShow(fun() {}, __ins)
    }
    companion object {
        @Suppress("UNUSED_PARAMETER", "UNUSED_VARIABLE")
        var setup: (__props: GenPagesUserLogin) -> Any? = fun(__props): Any? {
            val __ins = getCurrentInstance()!!
            val _ctx = __ins.proxy as GenPagesUserLogin
            val _cache = __ins.renderCache
            val user = useStore().user
            val ui = useUi()
            val refs = useRefs()
            val form = reactive<LoginForm>(LoginForm(phone = "18000000000", smsCode = "6666"))
            val agree = ref(false)
            fun gen_toLogin_fn(res: Any) {
                user.setToken(parse<Token>(res)!!)
                router.home()
            }
            val toLogin = ::gen_toLogin_fn
            fun gen_toDoc_fn(name: String, path: String) {}
            val toDoc = ::gen_toDoc_fn
            fun gen_isAgree_fn(): Boolean {
                if (!agree.value) {
                    ui.showToast(ClToastOptions(message = t("请先阅读并同意《用户协议》和《隐私政策》")))
                    return false
                }
                return true
            }
            val isAgree = ::gen_isAgree_fn
            provide("isAgree", isAgree)
            return fun(): Any? {
                val _component_cl_topbar = resolveEasyComponent("cl-topbar", GenUniModulesCoolUiComponentsClTopbarClTopbarClass)
                val _component_cl_image = resolveEasyComponent("cl-image", GenUniModulesCoolUiComponentsClImageClImageClass)
                val _component_cl_text = resolveEasyComponent("cl-text", GenUniModulesCoolUiComponentsClTextClTextClass)
                val _component_cl_checkbox = resolveEasyComponent("cl-checkbox", GenUniModulesCoolUiComponentsClCheckboxClCheckboxClass)
                val _component_cl_icon = resolveEasyComponent("cl-icon", GenUniModulesCoolUiComponentsClIconClIconClass)
                val _component_cl_page = resolveEasyComponent("cl-page", GenUniModulesCoolUiComponentsClPageClPageClass)
                return _cV(_component_cl_page, null, _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                    return _uA(
                        _cV(_component_cl_topbar, _uM("safe-area-top" to "", "background-color" to "transparent")),
                        _cE("view", _uM("class" to "px-10"), _uA(
                            _cE("view", _uM("class" to "flex flex-col items-center justify-center py-20"), _uA(
                                _cE("view", _uM("class" to "p-3 bg-primary-500 rounded-2xl"), _uA(
                                    _cV(_component_cl_image, _uM("src" to "/static/logo.png", "mode" to "widthFix", "width" to 80, "height" to 80))
                                )),
                                _cV(_component_cl_text, _uM("pt" to object : UTSJSONObject() {
                                    var className = "-important-text-xl font-bold mt-3"
                                }), _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                                    return _uA(
                                        _tD(unref(config1).name)
                                    )
                                }
                                ), "_" to 1))
                            )),
                            _cV(unref(GenPagesUserComponentsLoginPhoneClass), _uM("form" to form, "onSuccess" to toLogin), null, 8, _uA(
                                "form"
                            )),
                            _cV(unref(GenPagesUserComponentsLoginWxClass), _uM("ref" to unref(refs).set("loginWx"), "onSuccess" to toLogin), null, 512),
                            _cE("view", _uM("class" to "mt-6 flex flex-row flex-wrap items-center justify-center"), _uA(
                                _cV(_component_cl_checkbox, _uM("modelValue" to agree.value, "onUpdate:modelValue" to fun(`$event`: Boolean){
                                    agree.value = `$event`
                                }
                                , "pt" to object : UTSJSONObject() {
                                    var icon = object : UTSJSONObject() {
                                        var size: Number = 28
                                    }
                                }, "active-icon" to "checkbox-circle-fill", "inactive-icon" to "checkbox-blank-circle-line"), null, 8, _uA(
                                    "modelValue",
                                    "onUpdate:modelValue"
                                )),
                                _cV(_component_cl_text, _uM("color" to "info", "pt" to object : UTSJSONObject() {
                                    var className = "-important-text-xs"
                                }), _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                                    return _uA(
                                        _tD(unref(t)("已阅读并同意"))
                                    )
                                }
                                ), "_" to 1)),
                                _cV(_component_cl_text, _uM("pt" to object : UTSJSONObject() {
                                    var className = "-important-text-xs"
                                }, "onClick" to withModifiers(fun(){
                                    toDoc(unref(t)("用户协议"), "userAgreement")
                                }
                                , _uA(
                                    "stop"
                                ))), _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                                    return _uA(
                                        " 《" + _tD(unref(t)("用户协议")) + "》 "
                                    )
                                }
                                ), "_" to 1), 8, _uA(
                                    "onClick"
                                )),
                                _cV(_component_cl_text, _uM("color" to "info", "pt" to object : UTSJSONObject() {
                                    var className = "-important-text-xs"
                                }), _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                                    return _uA(
                                        "、"
                                    )
                                }
                                ), "_" to 1)),
                                _cV(_component_cl_text, _uM("pt" to object : UTSJSONObject() {
                                    var className = "-important-text-xs"
                                }, "onClick" to withModifiers(fun(){
                                    toDoc(unref(t)("隐私政策"), "privacyPolicy")
                                }
                                , _uA(
                                    "stop"
                                ))), _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                                    return _uA(
                                        " 《" + _tD(unref(t)("隐私政策")) + "》 "
                                    )
                                }
                                ), "_" to 1), 8, _uA(
                                    "onClick"
                                ))
                            )),
                            _cE("view", _uM("class" to "flex flex-row justify-center mt-10 px-10"), _uA(
                                _cE("view", _uM("class" to _nC(_uA(
                                    "login-item",
                                    _uM("is-dark" to unref(isDark))
                                )), "onClick" to fun(){
                                    unref(refs).callMethod("loginWx", "login")
                                }
                                ), _uA(
                                    _cV(_component_cl_icon, _uM("name" to "wechat-fill", "size" to 38, "color" to "#00b223"))
                                ), 10, _uA(
                                    "onClick"
                                )),
                                _cE("view", _uM("class" to _nC(_uA(
                                    "login-item",
                                    _uM("is-dark" to unref(isDark))
                                ))), _uA(
                                    _cV(_component_cl_icon, _uM("name" to "apple-fill", "size" to 38))
                                ), 2)
                            ))
                        ))
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
                return _uM("login-item" to _uM("" to _uM("marginLeft" to "14rpx", "marginRight" to "14rpx", "display" to "flex", "alignItems" to "center", "justifyContent" to "center", "borderTopLeftRadius" to 9999, "borderTopRightRadius" to 9999, "borderBottomRightRadius" to 9999, "borderBottomLeftRadius" to 9999, "borderTopWidth" to 1, "borderRightWidth" to 1, "borderBottomWidth" to 1, "borderLeftWidth" to 1, "borderTopStyle" to "solid", "borderRightStyle" to "solid", "borderBottomStyle" to "solid", "borderLeftStyle" to "solid", "borderTopColor" to "rgba(244,244,245,1)", "borderRightColor" to "rgba(244,244,245,1)", "borderBottomColor" to "rgba(244,244,245,1)", "borderLeftColor" to "rgba(244,244,245,1)", "backgroundColor" to "rgba(255,255,255,1)", "paddingTop" to "14rpx", "paddingRight" to "14rpx", "paddingBottom" to "14rpx", "paddingLeft" to "14rpx"), ".is-dark" to _uM("borderTopColor" to "rgba(82,82,91,1)", "borderRightColor" to "rgba(82,82,91,1)", "borderBottomColor" to "rgba(82,82,91,1)", "borderLeftColor" to "rgba(82,82,91,1)", "backgroundColor" to "rgba(63,63,70,1)")))
            }
        var inheritAttrs = true
        var inject: Map<String, Map<String, Any?>> = _uM()
        var emits: Map<String, Any?> = _uM()
        var props = _nP(_uM())
        var propsNeedCastKeys: UTSArray<String> = _uA()
        var components: Map<String, CreateVueComponent> = _uM()
    }
}
