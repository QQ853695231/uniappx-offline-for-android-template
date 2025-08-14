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
open class GenUniModulesCoolUiComponentsClSafeAreaClSafeArea : VueComponent {
    constructor(__ins: ComponentInternalInstance) : super(__ins) {}
    open var pt: Any by `$props`
    open var type: String by `$props`
    companion object {
        @Suppress("UNUSED_PARAMETER", "UNUSED_VARIABLE")
        var setup: (__props: GenUniModulesCoolUiComponentsClSafeAreaClSafeArea) -> Any? = fun(__props): Any? {
            val __ins = getCurrentInstance()!!
            val _ctx = __ins.proxy as GenUniModulesCoolUiComponentsClSafeAreaClSafeArea
            val _cache = __ins.renderCache
            val props = __props
            val pt = computed(fun(): PassThrough42 {
                return parsePt<PassThrough42>(props.pt)
            }
            )
            val height = computed(fun(): String {
                return getSafeAreaHeight(props.type) + "px"
            }
            )
            return fun(): Any? {
                return _cE("view", _uM("class" to _nC(_uA(
                    "cl-safe-area",
                    _uA(
                        _uM<String, Any?>(),
                        _uM("is-dark" to unref(isDark)),
                        pt.value.className
                    )
                )), "style" to _nS(_uM("height" to (height.value + "px")))), _uA(
                    renderSlot(_ctx.`$slots`, "default")
                ), 6)
            }
        }
        var name = "cl-safe-area"
        val styles: Map<String, Map<String, Map<String, Any>>> by lazy {
            _nCS(_uA(
                styles0
            ))
        }
        val styles0: Map<String, Map<String, Map<String, Any>>>
            get() {
                return _uM("cl-safe-area" to _uM("" to _uM("backgroundColor" to "rgba(255,255,255,1)"), ".is-dark" to _uM("backgroundColor" to "rgba(24,24,27,1)")))
            }
        var inheritAttrs = true
        var inject: Map<String, Map<String, Any?>> = _uM()
        var emits: Map<String, Any?> = _uM()
        var props = _nP(_uM("pt" to _uM("default" to fun(): UTSJSONObject {
            return (UTSJSONObject())
        }
        ), "type" to _uM("type" to "String", "default" to "top")))
        var propsNeedCastKeys = _uA(
            "pt",
            "type"
        )
        var components: Map<String, CreateVueComponent> = _uM()
    }
}
