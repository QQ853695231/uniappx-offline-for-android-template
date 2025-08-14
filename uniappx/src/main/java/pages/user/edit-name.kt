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
open class GenPagesUserEditName : BasePage {
    constructor(__ins: ComponentInternalInstance, __renderer: String?) : super(__ins, __renderer) {
        onPageScroll(fun(e: OnPageScrollOptions) {
            scroller.emit(e.scrollTop)
        }
        , __ins)
        onPageShow(fun() {}, __ins)
    }
    companion object {
        @Suppress("UNUSED_PARAMETER", "UNUSED_VARIABLE")
        var setup: (__props: GenPagesUserEditName) -> Any? = fun(__props): Any? {
            val __ins = getCurrentInstance()!!
            val _ctx = __ins.proxy as GenPagesUserEditName
            val _cache = __ins.renderCache
            val ui = useUi()
            val user = useStore().user
            val content = ref("")
            fun gen_confirm_fn(): UTSPromise<Unit> {
                return wrapUTSPromise(suspend w@{
                        if (content.value.length < 2 || content.value.length > 20) {
                            ui.showToast(ClToastOptions(message = t("昵称长度需在2-20个字符之间")))
                            return@w
                        }
                        val reg = UTSRegExp("^[^@<>\\/]*\$", "")
                        if (!reg.test(content.value)) {
                            ui.showToast(ClToastOptions(message = t("昵称不能包含@<>/等特殊字符")))
                            return@w
                        }
                        await(user.update(UserInfoEntity(nickName = content.value)))
                        router.back()
                })
            }
            val confirm = ::gen_confirm_fn
            onReady(fun(){
                content.value = user.info.nickName ?: ""
            }
            )
            return fun(): Any? {
                val _component_cl_topbar = resolveEasyComponent("cl-topbar", GenUniModulesCoolUiComponentsClTopbarClTopbarClass)
                val _component_cl_text = resolveEasyComponent("cl-text", GenUniModulesCoolUiComponentsClTextClTextClass)
                val _component_cl_input = resolveEasyComponent("cl-input", GenUniModulesCoolUiComponentsClInputClInputClass)
                val _component_cl_button = resolveEasyComponent("cl-button", GenUniModulesCoolUiComponentsClButtonClButtonClass)
                val _component_cl_footer = resolveEasyComponent("cl-footer", GenUniModulesCoolUiComponentsClFooterClFooterClass)
                val _component_cl_page = resolveEasyComponent("cl-page", GenUniModulesCoolUiComponentsClPageClPageClass)
                return _cV(_component_cl_page, null, _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                    return _uA(
                        _cV(_component_cl_topbar, _uM("safe-area-top" to "", "title" to unref(t)("编辑昵称"), "background-color" to "transparent"), null, 8, _uA(
                            "title"
                        )),
                        _cE("view", _uM("class" to "p-3"), _uA(
                            _cV(_component_cl_input, _uM("modelValue" to content.value, "onUpdate:modelValue" to fun(`$event`: String){
                                content.value = `$event`
                            }
                            , "autofocus" to "", "placeholder" to unref(t)("请输入昵称"), "border" to false, "pt" to object : UTSJSONObject() {
                                var className = "-important-h--bracket-start-80rpx-bracket-end-"
                            }), _uM("append" to withSlotCtx(fun(): UTSArray<Any> {
                                return _uA(
                                    _cV(_component_cl_text, _uM("color" to "info", "pt" to object : UTSJSONObject() {
                                        var className = "-important-text-sm ml-2"
                                    }), _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                                        return _uA(
                                            _tD(content.value.length) + "/20"
                                        )
                                    }
                                    ), "_" to 1))
                                )
                            }
                            ), "_" to 1), 8, _uA(
                                "modelValue",
                                "onUpdate:modelValue",
                                "placeholder"
                            )),
                            _cE("view", _uM("class" to "p-3"), _uA(
                                _cV(_component_cl_text, _uM("color" to "info", "pt" to object : UTSJSONObject() {
                                    var className = "-important-text-sm"
                                }), _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                                    return _uA(
                                        _tD(unref(t)("请设置2-20个字符，不包括@<>/等无效字符"))
                                    )
                                }
                                ), "_" to 1))
                            ))
                        )),
                        _cV(_component_cl_footer, null, _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                            return _uA(
                                _cV(_component_cl_button, _uM("size" to "large", "disabled" to (content.value == ""), "onClick" to confirm), _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                                    return _uA(
                                        _tD(unref(t)("确认"))
                                    )
                                }
                                ), "_" to 1), 8, _uA(
                                    "disabled"
                                ))
                            )
                        }
                        ), "_" to 1))
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
