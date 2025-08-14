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
open class GenPagesUserComponentsLoginWx : VueComponent {
    constructor(__ins: ComponentInternalInstance) : super(__ins) {}
    open var login: () -> UTSPromise<Unit>
        get() {
            return unref(this.`$exposed`["login"]) as () -> UTSPromise<Unit>
        }
        set(value) {
            setRefValue(this.`$exposed`, "login", value)
        }
    open var editOpen: () -> Unit
        get() {
            return unref(this.`$exposed`["editOpen"]) as () -> Unit
        }
        set(value) {
            setRefValue(this.`$exposed`, "editOpen", value)
        }
    open var editClose: () -> Unit
        get() {
            return unref(this.`$exposed`["editClose"]) as () -> Unit
        }
        set(value) {
            setRefValue(this.`$exposed`, "editClose", value)
        }
    companion object {
        @Suppress("UNUSED_PARAMETER", "UNUSED_VARIABLE")
        var setup: (__props: GenPagesUserComponentsLoginWx, _arg1: SetupContext) -> Any? = fun(__props, ref1): Any? {
            var __expose = ref1.expose
            val __ins = getCurrentInstance()!!
            val _ctx = __ins.proxy as GenPagesUserComponentsLoginWx
            val _cache = __ins.renderCache
            fun emit(event: String, vararg do_not_transform_spread: Any?) {
                __ins.emit(event, *do_not_transform_spread)
            }
            val user = useStore().user
            val ui = useUi()
            val editVisible = ref(false)
            val editLoading = ref(false)
            val editForm = reactive<EditForm>(EditForm(avatarUrl = "", nickName = ""))
            fun gen_editOpen_fn() {
                editVisible.value = true
            }
            val editOpen = ::gen_editOpen_fn
            fun gen_editClose_fn() {
                editVisible.value = false
            }
            val editClose = ::gen_editClose_fn
            fun gen_editSave_fn(): UTSPromise<Unit> {
                return wrapUTSPromise(suspend w@{
                        if (editForm.avatarUrl == "") {
                            ui.showToast(ClToastOptions(message = t("请上传头像")))
                            return@w
                        }
                        if (editForm.nickName == "") {
                            ui.showToast(ClToastOptions(message = t("请输入昵称")))
                            return@w
                        }
                        editLoading.value = true
                        await(upload(editForm.avatarUrl).then(fun(url){
                            user.update(UserInfoEntity(nickName = editForm.nickName, avatarUrl = url))
                            editClose()
                        }
                        ).`catch`(fun(err){
                            ui.showToast(ClToastOptions(message = (err as Response).message!!))
                        }
                        ))
                        editLoading.value = false
                })
            }
            val editSave = ::gen_editSave_fn
            fun gen_onEditChooseAvatar_fn(e: UniEvent) {}
            val onEditChooseAvatar = ::gen_onEditChooseAvatar_fn
            fun gen_onEditClose_fn() {
                editVisible.value = false
            }
            val onEditClose = ::gen_onEditClose_fn
            fun gen_miniLogin_fn(): UTSPromise<Unit> {
                return wrapUTSPromise(suspend {
                        await(service.user.login.mini(UTSJSONObject()).then(fun(res){
                            emit("success", res)
                        }
                        ).`catch`(fun(err){
                            ui.showToast(ClToastOptions(message = (err as Response).message!!))
                        }
                        ))
                })
            }
            val miniLogin = ::gen_miniLogin_fn
            fun gen_appLogin_fn() {}
            val appLogin = ::gen_appLogin_fn
            fun gen_login_fn(): UTSPromise<Unit> {
                return wrapUTSPromise(suspend w@{
                        ui.showToast(ClToastOptions(message = t("开发中，敬请期待")))
                        return@w
                })
            }
            val login = ::gen_login_fn
            __expose(_uM("login" to login, "editOpen" to editOpen, "editClose" to editClose))
            return fun(): Any? {
                val _component_cl_text = resolveEasyComponent("cl-text", GenUniModulesCoolUiComponentsClTextClTextClass)
                val _component_cl_avatar = resolveEasyComponent("cl-avatar", GenUniModulesCoolUiComponentsClAvatarClAvatarClass)
                val _component_cl_input = resolveEasyComponent("cl-input", GenUniModulesCoolUiComponentsClInputClInputClass)
                val _component_cl_button = resolveEasyComponent("cl-button", GenUniModulesCoolUiComponentsClButtonClButtonClass)
                val _component_div = resolveComponent("div")
                val _component_cl_popup = resolveEasyComponent("cl-popup", GenUniModulesCoolUiComponentsClPopupClPopupClass)
                return _cV(_component_cl_popup, _uM("modelValue" to editVisible.value, "onUpdate:modelValue" to fun(`$event`: Boolean){
                    editVisible.value = `$event`
                }
                , "direction" to "center", "title" to unref(t)("提示"), "size" to "80%", "onClose" to onEditClose), _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                    return _uA(
                        _cV(_component_div, _uM("class" to "p-4 pt-0"), _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                            return _uA(
                                _cV(_component_cl_text, _uM("color" to "info", "pt" to object : UTSJSONObject() {
                                    var className = "-important-text-sm"
                                }), _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                                    return _uA(
                                        _tD(unref(t)("为提供更好的服务，我们邀请您填写昵称、头像等公开信息"))
                                    )
                                }
                                ), "_" to 1)),
                                _cE("view", _uM("class" to "flex flex-row justify-between items-center bg-surface-100 rounded-xl p-2 px-3 mt-3 h--bracket-start-95rpx-bracket-end-"), _uA(
                                    _cV(_component_cl_text, null, _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                                        return _uA(
                                            _tD(unref(t)("头像"))
                                        )
                                    }
                                    ), "_" to 1)),
                                    _cE("view", _uM("class" to "relative"), _uA(
                                        _cV(_component_cl_avatar, _uM("size" to 60, "src" to editForm.avatarUrl), null, 8, _uA(
                                            "src"
                                        )),
                                        _cE("button", _uM("class" to "absolute top-0 right-0 h-10 w-10 z-10 opacity-0 p-0 m-0", "open-type" to "chooseAvatar", "onChooseavatar" to onEditChooseAvatar), null, 32)
                                    ))
                                )),
                                _cE("view", _uM("class" to "flex flex-row justify-between items-center bg-surface-100 rounded-xl p-2 px-3 mt-3 h--bracket-start-95rpx-bracket-end-"), _uA(
                                    _cV(_component_cl_text, null, _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                                        return _uA(
                                            _tD(unref(t)("昵称"))
                                        )
                                    }
                                    ), "_" to 1)),
                                    _cV(_component_cl_input, _uM("modelValue" to editForm.nickName, "onUpdate:modelValue" to fun(`$event`: String){
                                        editForm.nickName = `$event`
                                    }
                                    , "type" to "nickname", "border" to false, "placeholder" to unref(t)("点击输入昵称"), "maxlength" to 16, "pt" to object : UTSJSONObject() {
                                        var className = "-important-bg-transparent -important-px-0 flex-1"
                                        var inner = object : UTSJSONObject() {
                                            var className = "text-right"
                                        }
                                    }), null, 8, _uA(
                                        "modelValue",
                                        "onUpdate:modelValue",
                                        "placeholder"
                                    ))
                                )),
                                _cE("view", _uM("class" to "flex flex-row mt-4"), _uA(
                                    _cV(_component_cl_button, _uM("size" to "large", "text" to "", "border" to "", "type" to "light", "pt" to object : UTSJSONObject() {
                                        var className = "flex-1 -important-rounded-xl h--bracket-start-80rpx-bracket-end-"
                                    }, "onClick" to editClose), _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                                        return _uA(
                                            _tD(unref(t)("取消"))
                                        )
                                    }
                                    ), "_" to 1)),
                                    _cV(_component_cl_button, _uM("size" to "large", "pt" to object : UTSJSONObject() {
                                        var className = "flex-1 -important-rounded-xl h--bracket-start-80rpx-bracket-end-"
                                    }, "loading" to editLoading.value, "onClick" to editSave), _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                                        return _uA(
                                            _tD(unref(t)("确认"))
                                        )
                                    }
                                    ), "_" to 1), 8, _uA(
                                        "loading"
                                    ))
                                ))
                            )
                        }
                        ), "_" to 1))
                    )
                }
                ), "_" to 1), 8, _uA(
                    "modelValue",
                    "onUpdate:modelValue",
                    "title"
                ))
            }
        }
        val styles: Map<String, Map<String, Map<String, Any>>> by lazy {
            _nCS(_uA())
        }
        var inheritAttrs = true
        var inject: Map<String, Map<String, Any?>> = _uM()
        var emits: Map<String, Any?> = _uM("success" to null)
        var props = _nP(_uM())
        var propsNeedCastKeys: UTSArray<String> = _uA()
        var components: Map<String, CreateVueComponent> = _uM()
    }
}
