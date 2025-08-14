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
open class GenPagesDemoFormForm : BasePage {
    constructor(__ins: ComponentInternalInstance, __renderer: String?) : super(__ins, __renderer) {
        onPageScroll(fun(e: OnPageScrollOptions) {
            scroller.emit(e.scrollTop)
        }
        , __ins)
        onPageShow(fun() {}, __ins)
    }
    companion object {
        @Suppress("UNUSED_PARAMETER", "UNUSED_VARIABLE")
        var setup: (__props: GenPagesDemoFormForm) -> Any? = fun(__props): Any? {
            val __ins = getCurrentInstance()!!
            val _ctx = __ins.proxy as GenPagesDemoFormForm
            val _cache = __ins.renderCache
            val ui = useUi()
            val _useForm = useForm()
            val formRef = _useForm.formRef
            val validate = _useForm.validate
            val clearValidate = _useForm.clearValidate
            val genderOptions = _uA<ClSelectOption>(ClSelectOption(label = t("未知"), value = 0), ClSelectOption(label = t("男"), value = 1), ClSelectOption(label = t("女"), value = 2))
            val tagsOptions = _uA<ClSelectOption>(ClSelectOption(label = t("篮球"), value = 1), ClSelectOption(label = t("足球"), value = 2), ClSelectOption(label = t("羽毛球"), value = 3), ClSelectOption(label = t("乒乓球"), value = 4), ClSelectOption(label = t("游泳"), value = 5))
            val pcaOptions = useCascader(default1)
            val formData = ref<FormData>(FormData(avatarUrl = "", nickName = "神仙都没用", email = "", height = 180, weight = 70, gender = 0, description = "", pca = _uA(), tags = _uA(
                1,
                2
            ), birthday = "", isPublic = false)) as Ref<FormData>
            val rules = Map<String, UTSArray<ClFormRule>>(_uA(
                _uA(
                    "nickName",
                    _uA(
                        ClFormRule(required = true, message = t("用户名不能为空")),
                        ClFormRule(min = 3, max = 20, message = t("用户名长度在3-20个字符之间"))
                    )
                ),
                _uA(
                    "email",
                    _uA(
                        ClFormRule(required = true, message = t("邮箱不能为空")),
                        ClFormRule(pattern = UTSRegExp("^[^\\s@]+@[^\\s@]+\\.[^\\s@]+\$", ""), message = t("邮箱格式不正确"))
                    )
                ),
                _uA(
                    "height",
                    _uA(
                        ClFormRule(required = true, message = t("身高不能为空")),
                        ClFormRule(min = 160, max = 190, message = t("身高在160-190cm之间"))
                    )
                ),
                _uA(
                    "weight",
                    _uA(
                        ClFormRule(required = true, message = t("体重不能为空")),
                        ClFormRule(min = 40, max = 100, message = t("体重在40-100kg之间"))
                    )
                ),
                _uA(
                    "tags",
                    _uA(
                        ClFormRule(required = true, message = t("标签不能为空")),
                        ClFormRule(min = 1, max = 2, message = t("标签最多选择2个"))
                    )
                ),
                _uA(
                    "gender",
                    _uA(
                        ClFormRule(required = true, message = t("性别不能为空"))
                    )
                ),
                _uA(
                    "pca",
                    _uA(
                        ClFormRule(required = true, message = t("所在地区不能为空"))
                    )
                ),
                _uA(
                    "birthday",
                    _uA(
                        ClFormRule(required = true, message = t("出生年月不能为空")),
                        ClFormRule(validator = fun(value): Any {
                            if (dayUts(value).isAfter(dayUts("2010-01-01"))) {
                                return t("出生年月不大于2010-01-01")
                            }
                            return true
                        }
                        )
                    )
                )
            ))
            val saving = ref(false)
            fun gen_reset_fn() {
                formData.value.avatarUrl = ""
                formData.value.nickName = ""
                formData.value.email = ""
                formData.value.height = 180
                formData.value.weight = 70
                formData.value.gender = 0
                formData.value.description = ""
                formData.value.pca = _uA()
                formData.value.tags = _uA()
                formData.value.birthday = ""
                formData.value.isPublic = false
                clearValidate()
            }
            val reset = ::gen_reset_fn
            fun gen_submit_fn() {
                validate(fun(valid, errors){
                    if (valid) {
                        saving.value = true
                        setTimeout(fun(){
                            ui.showToast(ClToastOptions(message = t("提交成功"), icon = "check-line"))
                            saving.value = false
                            reset()
                        }, 2000)
                    } else {
                        ui.showToast(ClToastOptions(message = errors[0].message))
                    }
                }
                )
            }
            val submit = ::gen_submit_fn
            return fun(): Any? {
                val _component_cl_upload = resolveEasyComponent("cl-upload", GenUniModulesCoolUiComponentsClUploadClUploadClass)
                val _component_cl_form_item = resolveEasyComponent("cl-form-item", GenUniModulesCoolUiComponentsClFormItemClFormItemClass)
                val _component_cl_input = resolveEasyComponent("cl-input", GenUniModulesCoolUiComponentsClInputClInputClass)
                val _component_cl_text = resolveEasyComponent("cl-text", GenUniModulesCoolUiComponentsClTextClTextClass)
                val _component_cl_slider = resolveEasyComponent("cl-slider", GenUniModulesCoolUiComponentsClSliderClSliderClass)
                val _component_cl_checkbox = resolveEasyComponent("cl-checkbox", GenUniModulesCoolUiComponentsClCheckboxClCheckboxClass)
                val _component_cl_select = resolveEasyComponent("cl-select", GenUniModulesCoolUiComponentsClSelectClSelectClass)
                val _component_cl_cascader = resolveEasyComponent("cl-cascader", GenUniModulesCoolUiComponentsClCascaderClCascaderClass)
                val _component_cl_select_date = resolveEasyComponent("cl-select-date", GenUniModulesCoolUiComponentsClSelectDateClSelectDateClass)
                val _component_cl_textarea = resolveEasyComponent("cl-textarea", GenUniModulesCoolUiComponentsClTextareaClTextareaClass)
                val _component_cl_switch = resolveEasyComponent("cl-switch", GenUniModulesCoolUiComponentsClSwitchClSwitchClass)
                val _component_cl_form = resolveEasyComponent("cl-form", GenUniModulesCoolUiComponentsClFormClFormClass)
                val _component_cl_button = resolveEasyComponent("cl-button", GenUniModulesCoolUiComponentsClButtonClButtonClass)
                val _component_cl_footer = resolveEasyComponent("cl-footer", GenUniModulesCoolUiComponentsClFooterClFooterClass)
                val _component_cl_page = resolveEasyComponent("cl-page", GenUniModulesCoolUiComponentsClPageClPageClass)
                return _cV(_component_cl_page, null, _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                    return _uA(
                        _cE("view", _uM("class" to "p-3"), _uA(
                            _cV(unref(GenPagesDemoComponentsItemClass), null, _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                                return _uA(
                                    _cV(_component_cl_form, _uM("pt" to object : UTSJSONObject() {
                                        var className = "p-2 pb-0"
                                    }, "modelValue" to formData.value, "onUpdate:modelValue" to fun(`$event`: FormData){
                                        formData.value = `$event`
                                    }
                                    , "ref_key" to "formRef", "ref" to formRef, "rules" to unref(rules), "disabled" to saving.value, "label-position" to "top"), _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                                        return _uA(
                                            _cV(_component_cl_form_item, _uM("prop" to "avatarUrl"), _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                                                return _uA(
                                                    _cV(_component_cl_upload, _uM("modelValue" to formData.value.avatarUrl, "onUpdate:modelValue" to fun(`$event`: String){
                                                        formData.value.avatarUrl = `$event`
                                                    }
                                                    , "test" to ""), null, 8, _uA(
                                                        "modelValue",
                                                        "onUpdate:modelValue"
                                                    ))
                                                )
                                            }
                                            ), "_" to 1)),
                                            _cV(_component_cl_form_item, _uM("label" to unref(t)("用户名"), "prop" to "nickName", "required" to ""), _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                                                return _uA(
                                                    _cV(_component_cl_input, _uM("modelValue" to formData.value.nickName, "onUpdate:modelValue" to fun(`$event`: String){
                                                        formData.value.nickName = `$event`
                                                    }
                                                    , "placeholder" to unref(t)("请输入用户名"), "clearable" to ""), null, 8, _uA(
                                                        "modelValue",
                                                        "onUpdate:modelValue",
                                                        "placeholder"
                                                    ))
                                                )
                                            }
                                            ), "_" to 1), 8, _uA(
                                                "label"
                                            )),
                                            _cV(_component_cl_form_item, _uM("label" to unref(t)("邮箱"), "prop" to "email", "required" to ""), _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                                                return _uA(
                                                    _cV(_component_cl_input, _uM("modelValue" to formData.value.email, "onUpdate:modelValue" to fun(`$event`: String){
                                                        formData.value.email = `$event`
                                                    }
                                                    , "placeholder" to unref(t)("请输入邮箱地址")), null, 8, _uA(
                                                        "modelValue",
                                                        "onUpdate:modelValue",
                                                        "placeholder"
                                                    ))
                                                )
                                            }
                                            ), "_" to 1), 8, _uA(
                                                "label"
                                            )),
                                            _cV(_component_cl_form_item, _uM("label" to unref(t)("身高"), "prop" to "height", "required" to ""), _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                                                return _uA(
                                                    _cV(_component_cl_slider, _uM("modelValue" to formData.value.height, "onUpdate:modelValue" to fun(`$event`: Number){
                                                        formData.value.height = `$event`
                                                    }
                                                    , "max" to 220, "show-value" to ""), _uM("value" to withScopedSlotCtx(fun(slotProps: Record<String, Any?>): UTSArray<Any> {
                                                        val value = slotProps["value"]
                                                        return _uA(
                                                            _cV(_component_cl_text, _uM("pt" to object : UTSJSONObject() {
                                                                var className = "text-center w--bracket-start-120rpx-bracket-end-"
                                                            }), _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                                                                return _uA(
                                                                    _tD(value) + " cm"
                                                                )
                                                            }
                                                            ), "_" to 2), 1024)
                                                        )
                                                    }
                                                    ), "_" to 1), 8, _uA(
                                                        "modelValue",
                                                        "onUpdate:modelValue"
                                                    ))
                                                )
                                            }
                                            ), "_" to 1), 8, _uA(
                                                "label"
                                            )),
                                            _cV(_component_cl_form_item, _uM("label" to unref(t)("体重"), "prop" to "weight", "required" to ""), _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                                                return _uA(
                                                    _cV(_component_cl_slider, _uM("modelValue" to formData.value.weight, "onUpdate:modelValue" to fun(`$event`: Number){
                                                        formData.value.weight = `$event`
                                                    }
                                                    , "max" to 150, "show-value" to ""), _uM("value" to withScopedSlotCtx(fun(slotProps: Record<String, Any?>): UTSArray<Any> {
                                                        val value = slotProps["value"]
                                                        return _uA(
                                                            _cV(_component_cl_text, _uM("pt" to object : UTSJSONObject() {
                                                                var className = "text-center w--bracket-start-120rpx-bracket-end-"
                                                            }), _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                                                                return _uA(
                                                                    _tD(value) + " kg"
                                                                )
                                                            }
                                                            ), "_" to 2), 1024)
                                                        )
                                                    }
                                                    ), "_" to 1), 8, _uA(
                                                        "modelValue",
                                                        "onUpdate:modelValue"
                                                    ))
                                                )
                                            }
                                            ), "_" to 1), 8, _uA(
                                                "label"
                                            )),
                                            _cV(_component_cl_form_item, _uM("label" to unref(t)("标签"), "prop" to "tags", "required" to ""), _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                                                return _uA(
                                                    _cE("view", _uM("class" to "flex flex-row flex-wrap"), _uA(
                                                        _cE(Fragment, null, RenderHelpers.renderList(tagsOptions, fun(item, index, __index, _cached): Any {
                                                            return _cV(_component_cl_checkbox, _uM("modelValue" to formData.value.tags, "onUpdate:modelValue" to fun(`$event`: UTSArray<Number>){
                                                                formData.value.tags = `$event`
                                                            }
                                                            , "key" to index, "value" to index, "pt" to object : UTSJSONObject() {
                                                                var className = "mr-5 mt-2"
                                                            }), _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                                                                return _uA(
                                                                    _tD(item.label)
                                                                )
                                                            }
                                                            ), "_" to 2), 1032, _uA(
                                                                "modelValue",
                                                                "onUpdate:modelValue",
                                                                "value"
                                                            ))
                                                        }
                                                        ), 64)
                                                    ))
                                                )
                                            }
                                            ), "_" to 1), 8, _uA(
                                                "label"
                                            )),
                                            _cV(_component_cl_form_item, _uM("label" to unref(t)("性别"), "prop" to "gender", "required" to ""), _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                                                return _uA(
                                                    _cV(_component_cl_select, _uM("modelValue" to formData.value.gender, "onUpdate:modelValue" to fun(`$event`: Number){
                                                        formData.value.gender = `$event`
                                                    }
                                                    , "options" to genderOptions), null, 8, _uA(
                                                        "modelValue",
                                                        "onUpdate:modelValue"
                                                    ))
                                                )
                                            }
                                            ), "_" to 1), 8, _uA(
                                                "label"
                                            )),
                                            _cV(_component_cl_form_item, _uM("label" to unref(t)("所在地区"), "prop" to "pca", "required" to ""), _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                                                return _uA(
                                                    _cV(_component_cl_cascader, _uM("modelValue" to formData.value.pca, "onUpdate:modelValue" to fun(`$event`: UTSArray<String>){
                                                        formData.value.pca = `$event`
                                                    }
                                                    , "options" to unref(pcaOptions)), null, 8, _uA(
                                                        "modelValue",
                                                        "onUpdate:modelValue",
                                                        "options"
                                                    ))
                                                )
                                            }
                                            ), "_" to 1), 8, _uA(
                                                "label"
                                            )),
                                            _cV(_component_cl_form_item, _uM("label" to unref(t)("出生年月"), "prop" to "birthday", "required" to ""), _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                                                return _uA(
                                                    _cV(_component_cl_select_date, _uM("modelValue" to formData.value.birthday, "onUpdate:modelValue" to fun(`$event`: String){
                                                        formData.value.birthday = `$event`
                                                    }
                                                    , "type" to "date"), null, 8, _uA(
                                                        "modelValue",
                                                        "onUpdate:modelValue"
                                                    ))
                                                )
                                            }
                                            ), "_" to 1), 8, _uA(
                                                "label"
                                            )),
                                            _cV(_component_cl_form_item, _uM("label" to unref(t)("个人简介"), "prop" to "description"), _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                                                return _uA(
                                                    _cV(_component_cl_textarea, _uM("modelValue" to formData.value.description, "onUpdate:modelValue" to fun(`$event`: String){
                                                        formData.value.description = `$event`
                                                    }
                                                    , "placeholder" to unref(t)("请输入个人简介"), "maxlength" to 200), null, 8, _uA(
                                                        "modelValue",
                                                        "onUpdate:modelValue",
                                                        "placeholder"
                                                    ))
                                                )
                                            }
                                            ), "_" to 1), 8, _uA(
                                                "label"
                                            )),
                                            _cV(_component_cl_form_item, _uM("label" to unref(t)("公开状态")), _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                                                return _uA(
                                                    _cV(_component_cl_switch, _uM("modelValue" to formData.value.isPublic, "onUpdate:modelValue" to fun(`$event`: Boolean){
                                                        formData.value.isPublic = `$event`
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
                                    ), "_" to 1), 8, _uA(
                                        "modelValue",
                                        "onUpdate:modelValue",
                                        "rules",
                                        "disabled"
                                    ))
                                )
                            }
                            ), "_" to 1)),
                            _cV(unref(GenPagesDemoComponentsItemClass), null, _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                                return _uA(
                                    _cV(_component_cl_text, _uM("pre-wrap" to "", "pt" to object : UTSJSONObject() {
                                        var className = "-important-text-sm p-2"
                                    }), _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                                        return _uA(
                                            _tD(JSON.stringify(formData.value, null, 4))
                                        )
                                    }
                                    ), "_" to 1))
                                )
                            }
                            ), "_" to 1))
                        )),
                        _cV(_component_cl_footer, null, _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                            return _uA(
                                _cE("view", _uM("class" to "flex flex-row"), _uA(
                                    _cV(_component_cl_button, _uM("type" to "info", "pt" to object : UTSJSONObject() {
                                        var className = "flex-1"
                                    }, "onClick" to reset), _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                                        return _uA(
                                            _tD(unref(t)("重置"))
                                        )
                                    }
                                    ), "_" to 1)),
                                    _cV(_component_cl_button, _uM("type" to "primary", "loading" to saving.value, "pt" to object : UTSJSONObject() {
                                        var className = "flex-1"
                                    }, "onClick" to submit), _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                                        return _uA(
                                            _tD(unref(t)("提交"))
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
