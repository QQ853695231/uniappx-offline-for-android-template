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
import io.dcloud.uniapp.extapi.createSelectorQuery as uni_createSelectorQuery
open class GenUniModulesCoolUiComponentsClProgressClProgress : VueComponent {
    constructor(__ins: ComponentInternalInstance) : super(__ins) {}
    open var pt: Any by `$props`
    open var value: Number by `$props`
    open var strokeWidth: Number by `$props`
    open var showText: Boolean by `$props`
    open var color: String? by `$props`
    open var unColor: String? by `$props`
    companion object {
        @Suppress("UNUSED_PARAMETER", "UNUSED_VARIABLE")
        var setup: (__props: GenUniModulesCoolUiComponentsClProgressClProgress) -> Any? = fun(__props): Any? {
            val __ins = getCurrentInstance()!!
            val _ctx = __ins.proxy as GenUniModulesCoolUiComponentsClProgressClProgress
            val _cache = __ins.renderCache
            val props = __props
            val proxy = getCurrentInstance()!!.proxy
            val pt = computed(fun(): PassThrough31 {
                return parsePt<PassThrough31>(props.pt)
            }
            )
            val value = ref(0)
            val width = ref(0)
            val outerStyle = computed(fun(): UTSJSONObject {
                val style: UTSJSONObject = UTSJSONObject()
                style["height"] = parseRpx(props.strokeWidth)
                if (props.unColor != null) {
                    style["backgroundColor"] = props.unColor!!
                }
                return style
            }
            )
            val innerStyle = computed(fun(): UTSJSONObject {
                val style: UTSJSONObject = UTSJSONObject()
                style["width"] = "" + (value.value / 100) * width.value + "px"
                if (props.color != null) {
                    style["backgroundColor"] = props.color!!
                }
                return style
            }
            )
            fun gen_getWidth_fn() {
                uni_createSelectorQuery().`in`(proxy).select(".cl-progress__outer").boundingClientRect(fun(node){
                    width.value = (node as NodeInfo).width ?: 0
                }
                ).exec()
            }
            val getWidth = ::gen_getWidth_fn
            onMounted(fun(){
                watch(computed(fun(): Number {
                    return props.value
                }
                ), fun(kVal: Number){
                    getWidth()
                    setTimeout(fun(){
                        if (kVal > 100) {
                            value.value = 100
                        } else if (kVal < 0) {
                            value.value = 0
                        } else {
                            value.value = kVal
                        }
                    }
                    , 10)
                }
                , WatchOptions(immediate = true))
            }
            )
            return fun(): Any? {
                val _component_cl_rolling_number = resolveEasyComponent("cl-rolling-number", GenUniModulesCoolUiComponentsClRollingNumberClRollingNumberClass)
                return _cE("view", _uM("class" to _nC(_uA(
                    "cl-progress",
                    _uA(
                        _uM<String, Any?>(),
                        pt.value.className
                    )
                ))), _uA(
                    _cE("view", _uM("class" to _nC(_uA(
                        "cl-progress__outer",
                        _uA(
                            _uM<String, Any?>(),
                            _uM("-important-bg-surface-700" to (unref(isDark) && props.unColor == null)),
                            pt.value.outer?.className
                        )
                    )), "style" to _nS(outerStyle.value)), _uA(
                        _cE("view", _uM("class" to _nC(_uA(
                            "cl-progress__inner",
                            _uA(
                                _uM<String, Any?>(),
                                pt.value.inner?.className
                            )
                        )), "style" to _nS(innerStyle.value)), null, 6)
                    ), 6),
                    renderSlot(_ctx.`$slots`, "text", UTSJSONObject(), fun(): UTSArray<Any> {
                        return _uA(
                            if (isTrue(_ctx.showText)) {
                                _cV(_component_cl_rolling_number, _uM("key" to 0, "model-value" to value.value, "pt" to object : UTSJSONObject() {
                                    var className = unref(parseClass)(_uA(
                                        "w--bracket-start-100rpx-bracket-end- text-center",
                                        pt.value.text?.className
                                    ))
                                }, "unit" to "%"), null, 8, _uA(
                                    "model-value",
                                    "pt"
                                ))
                            } else {
                                _cC("v-if", true)
                            }
                        )
                    }
                    )
                ), 2)
            }
        }
        var name = "cl-progress"
        val styles: Map<String, Map<String, Map<String, Any>>> by lazy {
            _nCS(_uA(
                styles0
            ))
        }
        val styles0: Map<String, Map<String, Map<String, Any>>>
            get() {
                return _uM("cl-progress" to _pS(_uM("display" to "flex", "width" to "100%", "flexDirection" to "row", "alignItems" to "center", "borderTopLeftRadius" to "10.5rpx", "borderTopRightRadius" to "10.5rpx", "borderBottomRightRadius" to "10.5rpx", "borderBottomLeftRadius" to "10.5rpx")), "cl-progress__outer" to _pS(_uM("position" to "relative", "borderTopLeftRadius" to "10.5rpx", "borderTopRightRadius" to "10.5rpx", "borderBottomRightRadius" to "10.5rpx", "borderBottomLeftRadius" to "10.5rpx", "backgroundColor" to "rgba(244,244,245,1)", "flex" to 1)), "cl-progress__inner" to _pS(_uM("position" to "absolute", "top" to 0, "left" to 0, "zIndex" to 10, "height" to "100%", "borderTopLeftRadius" to "10.5rpx", "borderTopRightRadius" to "10.5rpx", "borderBottomRightRadius" to "10.5rpx", "borderBottomLeftRadius" to "10.5rpx", "backgroundColor" to "rgba(20,184,166,1)", "transitionProperty" to "width", "transitionDuration" to "0.5s")), "@TRANSITION" to _uM("cl-progress__inner" to _uM("property" to "width", "duration" to "0.5s")))
            }
        var inheritAttrs = true
        var inject: Map<String, Map<String, Any?>> = _uM()
        var emits: Map<String, Any?> = _uM()
        var props = _nP(_uM("pt" to _uM("default" to fun(): UTSJSONObject {
            return (UTSJSONObject())
        }
        ), "value" to _uM("type" to "Number", "default" to 0), "strokeWidth" to _uM("type" to "Number", "default" to 12), "showText" to _uM("type" to "Boolean", "default" to true), "color" to _uM("type" to "String", "default" to null), "unColor" to _uM("type" to "String", "default" to null)))
        var propsNeedCastKeys = _uA(
            "pt",
            "value",
            "strokeWidth",
            "showText",
            "color",
            "unColor"
        )
        var components: Map<String, CreateVueComponent> = _uM()
    }
}
