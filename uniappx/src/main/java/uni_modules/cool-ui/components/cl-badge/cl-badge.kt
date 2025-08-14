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
open class GenUniModulesCoolUiComponentsClBadgeClBadge : VueComponent {
    constructor(__ins: ComponentInternalInstance) : super(__ins) {}
    open var pt: Any by `$props`
    open var type: String by `$props`
    open var dot: Boolean by `$props`
    open var value: Any by `$props`
    open var position: Boolean by `$props`
    companion object {
        @Suppress("UNUSED_PARAMETER", "UNUSED_VARIABLE")
        var setup: (__props: GenUniModulesCoolUiComponentsClBadgeClBadge) -> Any? = fun(__props): Any? {
            val __ins = getCurrentInstance()!!
            val _ctx = __ins.proxy as GenUniModulesCoolUiComponentsClBadgeClBadge
            val _cache = __ins.renderCache
            val props = __props
            val getRpx = useSize().getRpx
            val pt = computed(fun(): PassThrough17 {
                return parsePt<PassThrough17>(props.pt)
            }
            )
            val badgeStyle = computed(fun(): UTSJSONObject {
                val style: UTSJSONObject = UTSJSONObject()
                if (props.dot) {
                    style["height"] = getRpx(10)
                    style["width"] = getRpx(10)
                    style["minWidth"] = getRpx(10)
                    style["padding"] = 0
                } else {
                    style["height"] = getRpx(30)
                    style["minWidth"] = getRpx(30)
                    style["padding"] = "0 " + getRpx(6)
                }
                if (props.position) {
                    style["transform"] = "translate(50%, -50%)"
                    if (props.dot) {
                        style["transform"] = "translate(-" + getRpx(5) + ", " + getRpx(5) + ")"
                    }
                }
                return style
            }
            )
            return fun(): Any? {
                val _component_cl_text = resolveEasyComponent("cl-text", GenUniModulesCoolUiComponentsClTextClTextClass)
                return _cE("view", _uM("class" to _nC(_uA(
                    "cl-badge",
                    _uA(
                        _uM<String, Any?>(),
                        _uM("bg-primary-500" to (_ctx.type == "primary"), "bg-green-500" to (_ctx.type == "success"), "bg-yellow-500" to (_ctx.type == "warn"), "bg-red-500" to (_ctx.type == "error"), "bg-surface-500" to (_ctx.type == "info"), "cl-badge--dot" to _ctx.dot, "cl-badge--position" to _ctx.position),
                        pt.value.className
                    )
                )), "style" to _nS(badgeStyle.value)), _uA(
                    if (isTrue(!_ctx.dot)) {
                        _cV(_component_cl_text, _uM("key" to 0, "pt" to object : UTSJSONObject() {
                            var className = unref(parseClass)(_uA(
                                "cl-badge__text",
                                pt.value.text?.className
                            ))
                        }), _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                            return _uA(
                                _tD(_ctx.value)
                            )
                        }), "_" to 1), 8, _uA(
                            "pt"
                        ))
                    } else {
                        _cC("v-if", true)
                    }
                    ,
                    renderSlot(_ctx.`$slots`, "default")
                ), 6)
            }
        }
        var name = "cl-badge"
        val styles: Map<String, Map<String, Map<String, Any>>> by lazy {
            _nCS(_uA(
                styles0
            ))
        }
        val styles0: Map<String, Map<String, Map<String, Any>>>
            get() {
                return _uM("cl-badge" to _pS(_uM("display" to "flex", "flexDirection" to "row", "alignItems" to "center", "justifyContent" to "center", "borderTopLeftRadius" to 9999, "borderTopRightRadius" to 9999, "borderBottomRightRadius" to 9999, "borderBottomLeftRadius" to 9999)), "cl-badge__text" to _pS(_uM("fontSize" to "24.5rpx", "lineHeight" to "35rpx", "color" to "rgba(255,255,255,1)")), "cl-badge--position" to _pS(_uM("position" to "absolute", "right" to 0, "top" to 0, "zIndex" to 10)))
            }
        var inheritAttrs = true
        var inject: Map<String, Map<String, Any?>> = _uM()
        var emits: Map<String, Any?> = _uM()
        var props = _nP(_uM("pt" to _uM("default" to fun(): UTSJSONObject {
            return (UTSJSONObject())
        }
        ), "type" to _uM("type" to "String", "default" to "error"), "dot" to _uM("type" to "Boolean", "default" to false), "value" to _uM("type" to _uA(
            "Number",
            "String"
        ), "default" to 0), "position" to _uM("type" to "Boolean", "default" to false)))
        var propsNeedCastKeys = _uA(
            "pt",
            "type",
            "dot",
            "value",
            "position"
        )
        var components: Map<String, CreateVueComponent> = _uM()
    }
}
