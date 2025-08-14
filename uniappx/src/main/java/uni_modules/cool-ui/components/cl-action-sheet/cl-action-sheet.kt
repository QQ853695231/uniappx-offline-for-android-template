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
open class GenUniModulesCoolUiComponentsClActionSheetClActionSheet : VueComponent {
    constructor(__ins: ComponentInternalInstance) : super(__ins) {}
    open var pt: Any by `$props`
    open var open: (options: ClActionSheetOptions) -> Unit
        get() {
            return unref(this.`$exposed`["open"]) as (options: ClActionSheetOptions) -> Unit
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
        var setup: (__props: GenUniModulesCoolUiComponentsClActionSheetClActionSheet, _arg1: SetupContext) -> Any? = fun(__props, ref1): Any? {
            var __expose = ref1.expose
            val __ins = getCurrentInstance()!!
            val _ctx = __ins.proxy as GenUniModulesCoolUiComponentsClActionSheetClActionSheet
            val _cache = __ins.renderCache
            val props = __props
            val pt = computed(fun(): PassThrough54 {
                return parsePt<PassThrough54>(props.pt)
            }
            )
            val visible = ref(false)
            val config = reactive<ClActionSheetOptions>(ClActionSheetOptions(title = "", list = _uA()))
            fun gen_close_fn() {
                visible.value = false
            }
            val close = ::gen_close_fn
            fun gen_open_fn(options: ClActionSheetOptions) {
                visible.value = true
                config.title = options.title
                config.description = options.description ?: ""
                config.list = options.list
                config.cancelText = options.cancelText ?: t("取消")
                config.showCancel = options.showCancel ?: true
                config.maskClosable = options.maskClosable ?: true
                if (config.showCancel!!) {
                    config.list.push(ClActionSheetItem(label = config.cancelText!!, callback = fun() {
                        close()
                    }
                    ))
                }
            }
            val open = ::gen_open_fn
            fun gen_onItemTap_fn(item: ClActionSheetItem) {
                if (item.callback != null) {
                    item.callback!!()
                }
            }
            val onItemTap = ::gen_onItemTap_fn
            __expose(_uM("open" to open, "close" to close))
            return fun(): Any? {
                val _component_cl_text = resolveEasyComponent("cl-text", GenUniModulesCoolUiComponentsClTextClTextClass)
                val _component_cl_icon = resolveEasyComponent("cl-icon", GenUniModulesCoolUiComponentsClIconClIconClass)
                val _component_cl_popup = resolveEasyComponent("cl-popup", GenUniModulesCoolUiComponentsClPopupClPopupClass)
                return _cV(_component_cl_popup, _uM("modelValue" to visible.value, "onUpdate:modelValue" to fun(`$event`: Boolean){
                    visible.value = `$event`
                }
                , "show-close" to false, "swipe-close-threshold" to 50, "pt" to object : UTSJSONObject() {
                    var inner = object : UTSJSONObject() {
                        var className = unref(parseClass)(_uA(
                            _uA(
                                unref(isDark),
                                "-important-bg-surface-700",
                                "-important-bg-surface-100"
                            )
                        ))
                    }
                }, "mask-closable" to config.maskClosable, "title" to config.title), _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                    return _uA(
                        _cE("view", _uM("class" to _nC(_uA(
                            "cl-action-sheet",
                            _uA(
                                _uM<String, Any?>(),
                                pt.value.className
                            )
                        ))), _uA(
                            renderSlot(_ctx.`$slots`, "prepend"),
                            if (config.description != "") {
                                _cE("view", _uM("key" to 0, "class" to "cl-action-sheet__description"), _uA(
                                    _cV(_component_cl_text, _uM("pt" to object : UTSJSONObject() {
                                        var className = "-important-text-surface-400 -important-text-md text-center"
                                    }), _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                                        return _uA(
                                            _tD(config.description)
                                        )
                                    }), "_" to 1))
                                ))
                            } else {
                                _cC("v-if", true)
                            }
                            ,
                            _cE("view", _uM("class" to _nC(_uA(
                                "cl-action-sheet__list",
                                _uA(
                                    _uM<String, Any?>(),
                                    pt.value.list?.className
                                )
                            ))), _uA(
                                _cE(Fragment, null, RenderHelpers.renderList(config.list, fun(item, index, __index, _cached): Any {
                                    return _cE("view", _uM("class" to _nC(_uA(
                                        "cl-action-sheet__item",
                                        _uA(
                                            _uM<String, Any?>(),
                                            "" + (if (unref(isDark)) {
                                                "-important-bg-surface-800"
                                            } else {
                                                "bg-white"
                                            }
                                            ),
                                            pt.value.item?.className
                                        )
                                    )), "key" to index, "hover-class" to ("" + (if (unref(isDark)) {
                                        "-important-bg-surface-900"
                                    } else {
                                        "-important-bg-surface-50"
                                    }
                                    )), "hover-stay-time" to 100, "onClick" to fun(){
                                        onItemTap(item)
                                    }
                                    ), _uA(
                                        renderSlot(_ctx.`$slots`, "item", GenUniModulesCoolUiComponentsClActionSheetClActionSheetSlotDataItem(item = item), fun(): UTSArray<Any> {
                                            return _uA(
                                                if (item.icon != null) {
                                                    _cV(_component_cl_icon, _uM("key" to 0, "name" to item.icon, "pt" to object : UTSJSONObject() {
                                                        var className = "mr-2"
                                                    }, "color" to item.color), null, 8, _uA(
                                                        "name",
                                                        "color"
                                                    ))
                                                } else {
                                                    _cC("v-if", true)
                                                }
                                                ,
                                                _cV(_component_cl_text, _uM("color" to item.color), _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                                                    return _uA(
                                                        _tD(item.label)
                                                    )
                                                }
                                                ), "_" to 2), 1032, _uA(
                                                    "color"
                                                ))
                                            )
                                        }
                                        )
                                    ), 10, _uA(
                                        "hover-class",
                                        "onClick"
                                    ))
                                }
                                ), 128)
                            ), 2),
                            renderSlot(_ctx.`$slots`, "append")
                        ), 2)
                    )
                }
                ), "_" to 3), 8, _uA(
                    "modelValue",
                    "onUpdate:modelValue",
                    "pt",
                    "mask-closable",
                    "title"
                ))
            }
        }
        var name = "cl-action-sheet"
        val styles: Map<String, Map<String, Map<String, Any>>> by lazy {
            _nCS(_uA(
                styles0
            ))
        }
        val styles0: Map<String, Map<String, Map<String, Any>>>
            get() {
                return _uM("cl-action-sheet__description" to _pS(_uM("display" to "flex", "flexDirection" to "row", "alignItems" to "center", "justifyContent" to "center", "marginBottom" to "30rpx")), "cl-action-sheet__list" to _pS(_uM("paddingTop" to 0, "paddingRight" to "20rpx", "paddingBottom" to 0, "paddingLeft" to "20rpx")), "cl-action-sheet__item" to _pS(_uM("display" to "flex", "flexDirection" to "row", "alignItems" to "center", "justifyContent" to "center", "borderTopLeftRadius" to "14rpx", "borderTopRightRadius" to "14rpx", "borderBottomRightRadius" to "14rpx", "borderBottomLeftRadius" to "14rpx", "paddingTop" to "20rpx", "paddingRight" to "20rpx", "paddingBottom" to "20rpx", "paddingLeft" to "20rpx", "marginBottom" to "20rpx")))
            }
        var inheritAttrs = true
        var inject: Map<String, Map<String, Any?>> = _uM()
        var emits: Map<String, Any?> = _uM()
        var props = _nP(_uM("pt" to _uM("default" to fun(): UTSJSONObject {
            return (UTSJSONObject())
        }
        )))
        var propsNeedCastKeys = _uA(
            "pt"
        )
        var components: Map<String, CreateVueComponent> = _uM()
    }
}
