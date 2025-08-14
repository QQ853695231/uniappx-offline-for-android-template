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
open class GenUniModulesCoolUiComponentsClLoadingClLoading : VueComponent {
    constructor(__ins: ComponentInternalInstance) : super(__ins) {}
    open var pt: Any by `$props`
    open var loading: Boolean by `$props`
    open var size: Any by `$props`
    open var color: String by `$props`
    companion object {
        @Suppress("UNUSED_PARAMETER", "UNUSED_VARIABLE")
        var setup: (__props: GenUniModulesCoolUiComponentsClLoadingClLoading) -> Any? = fun(__props): Any? {
            val __ins = getCurrentInstance()!!
            val _ctx = __ins.proxy as GenUniModulesCoolUiComponentsClLoadingClLoading
            val _cache = __ins.renderCache
            val props = __props
            val getRpx = useSize().getRpx
            val pt = computed(fun(): PassThrough4 {
                return parsePt<PassThrough4>(props.pt)
            }
            )
            val rotate = ref(0)
            fun gen_start_fn() {
                requestAnimationFrame(fun(_task){
                    rotate.value += 1
                    if (props.loading) {
                        gen_start_fn()
                    }
                }
                )
            }
            val start = ::gen_start_fn
            onMounted(fun(){
                watch(computed(fun(): Boolean {
                    return props.loading
                }
                ), fun(kVal: Boolean){
                    if (kVal) {
                        start()
                    }
                }
                , WatchOptions(immediate = true))
            }
            )
            return fun(): Any? {
                return if (isTrue(_ctx.loading)) {
                    _cE("view", _uM("key" to 0, "class" to _nC(_uA(
                        "cl-loading",
                        _uA(
                            _uM<String, Any?>(),
                            _uM("cl-loading--dark" to (unref(isDark) && _ctx.color == ""), "cl-loading--spin" to _ctx.loading, "-important-border-primary-500" to (_ctx.color == "primary"), "-important-border-green-500" to (_ctx.color == "success"), "-important-border-yellow-500" to (_ctx.color == "warn"), "-important-border-red-500" to (_ctx.color == "error"), "-important-border-surface-500" to (_ctx.color == "info"), "-important-border-surface-700" to (_ctx.color == "dark"), "-important-border-white" to (_ctx.color == "light"), "-important-border-surface-300" to (_ctx.color == "disabled"), "-important-border-r-transparent" to true),
                            pt.value.className
                        )
                    )), "style" to _nS(_uM("transform" to ("rotate(" + rotate.value + "deg)"), "height" to unref(getRpx)(_ctx.size!!), "width" to unref(getRpx)(_ctx.size!!), "borderWidth" to unref(getRpx)(2), "borderTopColor" to _ctx.color, "borderRightColor" to "transparent", "borderBottomColor" to _ctx.color, "borderLeftColor" to _ctx.color))), null, 6)
                } else {
                    _cC("v-if", true)
                }
            }
        }
        var name = "cl-loading"
        val styles: Map<String, Map<String, Map<String, Any>>> by lazy {
            _nCS(_uA(
                styles0
            ))
        }
        val styles0: Map<String, Map<String, Map<String, Any>>>
            get() {
                return _uM("cl-loading" to _pS(_uM("display" to "flex", "flexDirection" to "row", "alignItems" to "center", "justifyContent" to "center", "borderTopLeftRadius" to 9999, "borderTopRightRadius" to 9999, "borderBottomRightRadius" to 9999, "borderBottomLeftRadius" to 9999, "borderTopStyle" to "solid", "borderRightStyle" to "solid", "borderBottomStyle" to "solid", "borderLeftStyle" to "solid", "borderTopColor" to "rgba(63,63,70,1)", "borderRightColor" to "rgba(63,63,70,1)", "borderBottomColor" to "rgba(63,63,70,1)", "borderLeftColor" to "rgba(63,63,70,1)")), "cl-loading--dark" to _pS(_uM("!borderTopColor" to "#FFFFFF", "!borderRightColor" to "rgba(0,0,0,0)", "!borderBottomColor" to "#FFFFFF", "!borderLeftColor" to "#FFFFFF")))
            }
        var inheritAttrs = true
        var inject: Map<String, Map<String, Any?>> = _uM()
        var emits: Map<String, Any?> = _uM()
        var props = _nP(_uM("pt" to _uM("default" to fun(): UTSJSONObject {
            return (UTSJSONObject())
        }
        ), "loading" to _uM("type" to "Boolean", "default" to true), "size" to _uM("type" to _uA(
            "Number",
            "String"
        ), "default" to 24), "color" to _uM("type" to "String", "default" to "")))
        var propsNeedCastKeys = _uA(
            "pt",
            "loading",
            "size",
            "color"
        )
        var components: Map<String, CreateVueComponent> = _uM()
    }
}
