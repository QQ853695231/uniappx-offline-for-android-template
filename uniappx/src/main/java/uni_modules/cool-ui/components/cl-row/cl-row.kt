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
open class GenUniModulesCoolUiComponentsClRowClRow : VueComponent {
    constructor(__ins: ComponentInternalInstance) : super(__ins) {}
    open var pt: Any by `$props`
    open var gutter: Number by `$props`
    companion object {
        @Suppress("UNUSED_PARAMETER", "UNUSED_VARIABLE")
        var setup: (__props: GenUniModulesCoolUiComponentsClRowClRow, _arg1: SetupContext) -> Any? = fun(__props, ref1): Any? {
            var __expose = ref1.expose
            val __ins = getCurrentInstance()!!
            val _ctx = __ins.proxy as GenUniModulesCoolUiComponentsClRowClRow
            val _cache = __ins.renderCache
            val props = __props
            val pt = computed(fun(): PassThrough9 {
                return parsePt<PassThrough9>(props.pt)
            }
            )
            val margin = computed(fun(): String {
                return "-" + parseRpx(props.gutter / 2)
            }
            )
            __expose(_uM("gutter" to computed(fun(): Number {
                return props.gutter
            }
            )))
            return fun(): Any? {
                return _cE("view", _uM("class" to _nC(_uA(
                    "cl-row",
                    _uA(
                        _uM<String, Any?>(),
                        pt.value.className
                    )
                )), "style" to _nS(_uM("marginLeft" to margin.value, "marginRight" to margin.value))), _uA(
                    renderSlot(_ctx.`$slots`, "default")
                ), 6)
            }
        }
        var name = "cl-row"
        val styles: Map<String, Map<String, Map<String, Any>>> by lazy {
            _nCS(_uA(
                styles0
            ))
        }
        val styles0: Map<String, Map<String, Map<String, Any>>>
            get() {
                return _uM("cl-row" to _pS(_uM("position" to "relative", "display" to "flex", "flexDirection" to "row", "flexWrap" to "wrap")))
            }
        var inheritAttrs = true
        var inject: Map<String, Map<String, Any?>> = _uM()
        var emits: Map<String, Any?> = _uM()
        var props = _nP(_uM("pt" to _uM("default" to fun(): UTSJSONObject {
            return (UTSJSONObject())
        }
        ), "gutter" to _uM("type" to "Number", "default" to 0)))
        var propsNeedCastKeys = _uA(
            "pt",
            "gutter"
        )
        var components: Map<String, CreateVueComponent> = _uM()
    }
}
