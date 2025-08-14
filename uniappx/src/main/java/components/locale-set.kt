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
open class GenComponentsLocaleSet : VueComponent {
    constructor(__ins: ComponentInternalInstance) : super(__ins) {}
    open var visible: Boolean
        get() {
            return unref(this.`$exposed`["visible"]) as Boolean
        }
        set(value) {
            setRefValue(this.`$exposed`, "visible", value)
        }
    open var open: () -> Unit
        get() {
            return unref(this.`$exposed`["open"]) as () -> Unit
        }
        set(value) {
            setRefValue(this.`$exposed`, "open", value)
        }
    open var close: () -> Unit
        get() {
            return unref(this.`$exposed`["close"]) as () -> Unit
        }
        set(value) {
            setRefValue(this.`$exposed`, "close", value)
        }
    companion object {
        @Suppress("UNUSED_PARAMETER", "UNUSED_VARIABLE")
        var setup: (__props: GenComponentsLocaleSet, _arg1: SetupContext) -> Any? = fun(__props, ref1): Any? {
            var __expose = ref1.expose
            val __ins = getCurrentInstance()!!
            val _ctx = __ins.proxy as GenComponentsLocaleSet
            val _cache = __ins.renderCache
            val list = _uA<Item>(Item(label = "简体中文", value = "zh-cn"), Item(label = "English", value = "en"), Item(label = "Español", value = "es"))
            val active = ref(locale.value)
            val visible = ref(false)
            fun gen_open_fn() {
                visible.value = true
                active.value = locale.value
                if (_uA(
                    "zh-Hans",
                    "zh"
                ).some(fun(e): Boolean {
                    return e == locale.value
                }
                )) {
                    active.value = "zh-cn"
                }
            }
            val open = ::gen_open_fn
            fun gen_close_fn() {
                visible.value = false
            }
            val close = ::gen_close_fn
            fun gen_change_fn(value: String) {
                active.value = value
            }
            val change = ::gen_change_fn
            fun gen_confirm_fn() {
                setLocale(active.value)
                close()
            }
            val confirm = ::gen_confirm_fn
            __expose(_uM("visible" to visible, "open" to open, "close" to close))
            return fun(): Any? {
                val _component_cl_text = resolveEasyComponent("cl-text", GenUniModulesCoolUiComponentsClTextClTextClass)
                val _component_cl_icon = resolveEasyComponent("cl-icon", GenUniModulesCoolUiComponentsClIconClIconClass)
                val _component_cl_button = resolveEasyComponent("cl-button", GenUniModulesCoolUiComponentsClButtonClButtonClass)
                val _component_cl_popup = resolveEasyComponent("cl-popup", GenUniModulesCoolUiComponentsClPopupClPopupClass)
                return _cV(_component_cl_popup, _uM("modelValue" to visible.value, "onUpdate:modelValue" to fun(`$event`: Boolean){
                    visible.value = `$event`
                }
                , "direction" to "center", "title" to unref(t)("切换语言"), "pt" to object : UTSJSONObject() {
                    var className = "-important-rounded-3xl"
                }), _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                    return _uA(
                        _cE("view", _uM("class" to "locale-set w--bracket-start-500rpx-bracket-end- p-4 pt-0"), _uA(
                            _cE(Fragment, null, RenderHelpers.renderList(list, fun(item, __key, __index, _cached): Any {
                                return _cE("view", _uM("key" to item.value, "class" to _nC(_uA(
                                    "p-2 px-3 my-1 rounded-xl flex flex-row items-center border border-solid border-surface-200",
                                    _uM("-important-border-surface-600" to unref(isDark), "-important-bg-primary-500 -important-border-primary-500" to (active.value == item.value))
                                )), "onClick" to fun(){
                                    change(item.value)
                                }
                                ), _uA(
                                    _cV(_component_cl_text, _uM("pt" to object : UTSJSONObject() {
                                        var className = unref(parseClass)(_uA(
                                            "flex-1",
                                            _uA(
                                                unref(isDark) || active.value == item.value,
                                                "-important-text-white",
                                                "-important-text-surface-700"
                                            )
                                        ))
                                    }), _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                                        return _uA(
                                            _tD(item.label)
                                        )
                                    }
                                    ), "_" to 2), 1032, _uA(
                                        "pt"
                                    )),
                                    if (active.value == item.value) {
                                        _cV(_component_cl_icon, _uM("key" to 0, "name" to "checkbox-circle-line", "color" to "white"))
                                    } else {
                                        _cC("v-if", true)
                                    }
                                ), 10, _uA(
                                    "onClick"
                                ))
                            }
                            ), 64),
                            _cE("view", _uM("class" to "flex flex-row mt-4"), _uA(
                                _cV(_component_cl_button, _uM("size" to "large", "text" to "", "border" to "", "type" to "light", "pt" to object : UTSJSONObject() {
                                    var className = "flex-1 -important-rounded-full h--bracket-start-80rpx-bracket-end-"
                                }, "onClick" to close), _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                                    return _uA(
                                        _tD(unref(t)("取消"))
                                    )
                                }
                                ), "_" to 1)),
                                _cV(_component_cl_button, _uM("size" to "large", "pt" to object : UTSJSONObject() {
                                    var className = "flex-1 -important-rounded-full h--bracket-start-80rpx-bracket-end-"
                                }, "onClick" to confirm), _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                                    return _uA(
                                        _tD(unref(t)("确定"))
                                    )
                                }
                                ), "_" to 1))
                            ))
                        ))
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
        var emits: Map<String, Any?> = _uM()
        var props = _nP(_uM())
        var propsNeedCastKeys: UTSArray<String> = _uA()
        var components: Map<String, CreateVueComponent> = _uM()
    }
}
