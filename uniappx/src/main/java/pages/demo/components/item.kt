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
open class GenPagesDemoComponentsItem : VueComponent {
    constructor(__ins: ComponentInternalInstance) : super(__ins) {}
    open var label: String by `$props`
    companion object {
        @Suppress("UNUSED_PARAMETER", "UNUSED_VARIABLE")
        var setup: (__props: GenPagesDemoComponentsItem) -> Any? = fun(__props): Any? {
            val __ins = getCurrentInstance()!!
            val _ctx = __ins.proxy as GenPagesDemoComponentsItem
            val _cache = __ins.renderCache
            return fun(): Any? {
                val _component_cl_text = resolveEasyComponent("cl-text", GenUniModulesCoolUiComponentsClTextClTextClass)
                return _cE("view", _uM("class" to _nC(_uA(
                    "demo-item",
                    _uM("dark-colon--important-bg-surface-800" to unref(isDark))
                ))), _uA(
                    if (_ctx.label != "") {
                        _cV(_component_cl_text, _uM("key" to 0, "pt" to object : UTSJSONObject() {
                            var className = "-important-text-sm -important-text-surface-400 mb-2"
                        }), _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                            return _uA(
                                _tD(_ctx.label)
                            )
                        }), "_" to 1))
                    } else {
                        _cC("v-if", true)
                    }
                    ,
                    renderSlot(_ctx.`$slots`, "default")
                ), 2)
            }
        }
        var name = "demo-item"
        val styles: Map<String, Map<String, Map<String, Any>>> by lazy {
            _nCS(_uA(
                styles0
            ))
        }
        val styles0: Map<String, Map<String, Map<String, Any>>>
            get() {
                return _uM("demo-item" to _pS(_uM("marginBottom" to "21rpx", "borderTopLeftRadius" to "21rpx", "borderTopRightRadius" to "21rpx", "borderBottomRightRadius" to "21rpx", "borderBottomLeftRadius" to "21rpx", "backgroundColor" to "rgba(255,255,255,1)", "paddingTop" to "21rpx", "paddingRight" to "21rpx", "paddingBottom" to "21rpx", "paddingLeft" to "21rpx")))
            }
        var inheritAttrs = true
        var inject: Map<String, Map<String, Any?>> = _uM()
        var emits: Map<String, Any?> = _uM()
        var props = _nP(_uM("label" to _uM("type" to "String", "default" to "")))
        var propsNeedCastKeys = _uA(
            "label"
        )
        var components: Map<String, CreateVueComponent> = _uM()
    }
}
