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
open class GenPagesUserEdit : BasePage {
    constructor(__ins: ComponentInternalInstance, __renderer: String?) : super(__ins, __renderer) {
        onPageScroll(fun(e: OnPageScrollOptions) {
            scroller.emit(e.scrollTop)
        }
        , __ins)
        onPageShow(fun() {}, __ins)
    }
    companion object {
        @Suppress("UNUSED_PARAMETER", "UNUSED_VARIABLE")
        var setup: (__props: GenPagesUserEdit) -> Any? = fun(__props): Any? {
            val __ins = getCurrentInstance()!!
            val _ctx = __ins.proxy as GenPagesUserEdit
            val _cache = __ins.renderCache
            val user = useStore().user
            val ui = useUi()
            val refs = useRefs()
            val today = dayUts().format("YYYY-MM-DD")
            val genderOptions = ref(_uA<ClSelectOption>(ClSelectOption(label = t("保密"), value = 0), ClSelectOption(label = t("男"), value = 1), ClSelectOption(label = t("女"), value = 2)))
            val genderText = computed(fun(): String {
                return _uA(
                    t("保密"),
                    t("男"),
                    t("女")
                )[user.info.gender!!]
            }
            )
            fun gen_onGenderChange_fn(kVal: Number) {
                user.update(UserInfoEntity(gender = kVal))
                ui.showToast(ClToastOptions(message = t("性别设置成功")))
            }
            val onGenderChange = ::gen_onGenderChange_fn
            fun gen_onBirthdayChange_fn(kVal: String) {
                user.update(UserInfoEntity(birthday = kVal))
                ui.showToast(ClToastOptions(message = t("生日设置成功")))
            }
            val onBirthdayChange = ::gen_onBirthdayChange_fn
            val regionOptions = useCascader(default1)
            val regionText = computed(fun(): String {
                return _uA(
                    user.info.province,
                    user.info.city,
                    user.info.district
                ).filter(fun(e): Boolean {
                    return e != null
                }
                ).join(" - ")
            }
            )
            fun gen_onRegionChange_fn(arr: UTSArray<String>) {
                user.update(UserInfoEntity(province = arr[0], city = arr[1], district = arr[2]))
                ui.showToast(ClToastOptions(message = t("地区设置成功")))
            }
            val onRegionChange = ::gen_onRegionChange_fn
            fun gen_open_fn(name: String) {
                refs.open(name)
            }
            val open = ::gen_open_fn
            fun gen_uploadAvatar_fn(e: UniEvent) {
                fun next(path: String) {
                    upload(path).then(fun(url){
                        ui.showToast(ClToastOptions(message = t("头像上传成功")))
                        user.update(UserInfoEntity(avatarUrl = url))
                    }
                    ).`catch`(fun(err){
                        ui.showToast(ClToastOptions(message = (err as Response).message!!))
                    }
                    )
                }
                uni_chooseImage(ChooseImageOptions(count = 1, success = fun(res) {
                    next(res.tempFiles[0].path)
                }
                ))
            }
            val uploadAvatar = ::gen_uploadAvatar_fn
            return fun(): Any? {
                val _component_cl_avatar = resolveEasyComponent("cl-avatar", GenUniModulesCoolUiComponentsClAvatarClAvatarClass)
                val _component_cl_icon = resolveEasyComponent("cl-icon", GenUniModulesCoolUiComponentsClIconClIconClass)
                val _component_cl_text = resolveEasyComponent("cl-text", GenUniModulesCoolUiComponentsClTextClTextClass)
                val _component_cl_list_item = resolveEasyComponent("cl-list-item", GenUniModulesCoolUiComponentsClListItemClListItemClass)
                val _component_cl_list = resolveEasyComponent("cl-list", GenUniModulesCoolUiComponentsClListClListClass)
                val _component_cl_select = resolveEasyComponent("cl-select", GenUniModulesCoolUiComponentsClSelectClSelectClass)
                val _component_cl_select_date = resolveEasyComponent("cl-select-date", GenUniModulesCoolUiComponentsClSelectDateClSelectDateClass)
                val _component_cl_cascader = resolveEasyComponent("cl-cascader", GenUniModulesCoolUiComponentsClCascaderClCascaderClass)
                val _component_cl_page = resolveEasyComponent("cl-page", GenUniModulesCoolUiComponentsClPageClPageClass)
                return _cV(_component_cl_page, null, _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                    return _uA(
                        _cE("view", _uM("class" to "p-3"), _uA(
                            _cE("view", _uM("class" to "flex flex-col justify-center items-center py-10 mb-3"), _uA(
                                _cE("view", _uM("class" to "relative overflow-visible"), _uA(
                                    _cV(_component_cl_avatar, _uM("src" to unref(user).info.avatarUrl, "size" to 150, "pt" to object : UTSJSONObject() {
                                        var className = "-important-rounded-3xl"
                                        var icon = object : UTSJSONObject() {
                                            var size: Number = 60
                                        }
                                    }, "onClick" to uploadAvatar), null, 8, _uA(
                                        "src"
                                    )),
                                    _cE("view", _uM("class" to "flex flex-col justify-center items-center absolute bottom-0 right--bracket-start--6rpx-bracket-end- bg-black rounded-full p-1 border border-solid border-white"), _uA(
                                        _cV(_component_cl_icon, _uM("name" to "edit-line", "color" to "white", "size" to 24))
                                    ))
                                ))
                            )),
                            _cV(_component_cl_list, _uM("pt" to object : UTSJSONObject() {
                                var className = "mb-3"
                            }), _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                                return _uA(
                                    _cV(_component_cl_list_item, _uM("label" to unref(t)("我的昵称"), "hoverable" to "", "arrow" to "", "justify" to "start", "onClick" to fun(){
                                        unref(router).to("/pages/user/edit-name")
                                    }
                                    ), _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                                        return _uA(
                                            _cV(_component_cl_text, null, _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                                                return _uA(
                                                    _tD(unref(user).info.nickName)
                                                )
                                            }
                                            ), "_" to 1))
                                        )
                                    }
                                    ), "_" to 1), 8, _uA(
                                        "label",
                                        "onClick"
                                    )),
                                    _cV(_component_cl_list_item, _uM("label" to "手机号", "hoverable" to "", "justify" to "start"), _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                                        return _uA(
                                            _cV(_component_cl_text, null, _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                                                return _uA(
                                                    _tD(unref(user).info.phone)
                                                )
                                            }
                                            ), "_" to 1))
                                        )
                                    }
                                    ), "_" to 1))
                                )
                            }
                            ), "_" to 1)),
                            _cV(_component_cl_list, _uM("pt" to object : UTSJSONObject() {
                                var className = "mb-3"
                            }), _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                                return _uA(
                                    _cV(_component_cl_list_item, _uM("label" to unref(t)("简介"), "hoverable" to "", "arrow" to "", "justify" to "start", "onClick" to fun(){
                                        unref(router).to("/pages/user/edit-description")
                                    }
                                    ), _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                                        return _uA(
                                            if (unref(user).info.description == null) {
                                                _cV(_component_cl_text, _uM("key" to 0, "color" to "info"), _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                                                    return _uA(
                                                        _tD(unref(t)("介绍一下自己"))
                                                    )
                                                }), "_" to 1))
                                            } else {
                                                _cV(_component_cl_text, _uM("key" to 1, "ellipsis" to ""), _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                                                    return _uA(
                                                        _tD(unref(user).info.description)
                                                    )
                                                }
                                                ), "_" to 1))
                                            }
                                        )
                                    }
                                    ), "_" to 1), 8, _uA(
                                        "label",
                                        "onClick"
                                    ))
                                )
                            }
                            ), "_" to 1)),
                            _cV(_component_cl_list, _uM("pt" to object : UTSJSONObject() {
                                var className = "mb-3"
                            }), _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                                return _uA(
                                    _cV(_component_cl_list_item, _uM("label" to unref(t)("性别"), "hoverable" to "", "arrow" to "", "justify" to "start", "onClick" to fun(){
                                        open("gender")
                                    }
                                    ), _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                                        return _uA(
                                            _cV(_component_cl_text, null, _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                                                return _uA(
                                                    _tD(genderText.value)
                                                )
                                            }
                                            ), "_" to 1)),
                                            if (genderText.value == "") {
                                                _cV(_component_cl_text, _uM("key" to 0, "color" to "info"), _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                                                    return _uA(
                                                        _tD(unref(t)("编辑性别"))
                                                    )
                                                }), "_" to 1))
                                            } else {
                                                _cC("v-if", true)
                                            }
                                        )
                                    }
                                    ), "_" to 1), 8, _uA(
                                        "label",
                                        "onClick"
                                    )),
                                    _cV(_component_cl_list_item, _uM("label" to unref(t)("生日"), "hoverable" to "", "arrow" to "", "justify" to "start", "onClick" to fun(){
                                        open("birthday")
                                    }
                                    ), _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                                        return _uA(
                                            _cV(_component_cl_text, null, _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                                                return _uA(
                                                    _tD(unref(user).info.birthday)
                                                )
                                            }
                                            ), "_" to 1)),
                                            if (unref(user).info["birthday"] == null) {
                                                _cV(_component_cl_text, _uM("key" to 0, "color" to "info"), _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                                                    return _uA(
                                                        _tD(unref(t)("选择生日"))
                                                    )
                                                }), "_" to 1))
                                            } else {
                                                _cC("v-if", true)
                                            }
                                        )
                                    }
                                    ), "_" to 1), 8, _uA(
                                        "label",
                                        "onClick"
                                    )),
                                    _cV(_component_cl_list_item, _uM("label" to unref(t)("地区"), "hoverable" to "", "arrow" to "", "justify" to "start", "onClick" to fun(){
                                        open("region")
                                    }
                                    ), _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                                        return _uA(
                                            _cV(_component_cl_text, null, _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                                                return _uA(
                                                    _tD(regionText.value)
                                                )
                                            }
                                            ), "_" to 1)),
                                            if (regionText.value == "") {
                                                _cV(_component_cl_text, _uM("key" to 0, "color" to "info"), _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                                                    return _uA(
                                                        _tD(unref(t)("选择所在的地区"))
                                                    )
                                                }), "_" to 1))
                                            } else {
                                                _cC("v-if", true)
                                            }
                                        )
                                    }
                                    ), "_" to 1), 8, _uA(
                                        "label",
                                        "onClick"
                                    ))
                                )
                            }
                            ), "_" to 1)),
                            _cV(_component_cl_select, _uM("title" to unref(t)("选择性别"), "model-value" to unref(user).info.gender, "ref" to unref(refs).set("gender"), "options" to genderOptions.value, "show-trigger" to false, "onChange" to onGenderChange), null, 8, _uA(
                                "title",
                                "model-value",
                                "options"
                            )),
                            _cV(_component_cl_select_date, _uM("title" to unref(t)("选择生日"), "model-value" to unref(user).info.birthday, "ref" to unref(refs).set("birthday"), "type" to "date", "end" to unref(today), "show-trigger" to false, "onChange" to onBirthdayChange), null, 8, _uA(
                                "title",
                                "model-value",
                                "end"
                            )),
                            _cV(_component_cl_cascader, _uM("title" to unref(t)("选择所在的地区"), "ref" to unref(refs).set("region"), "options" to unref(regionOptions), "show-trigger" to false, "onChange" to onRegionChange), null, 8, _uA(
                                "title",
                                "options"
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
