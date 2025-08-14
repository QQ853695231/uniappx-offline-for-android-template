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
open class GenUniModulesCoolUiComponentsClSkeletonClSkeleton : VueComponent {
    constructor(__ins: ComponentInternalInstance) : super(__ins) {}
    open var pt: Any by `$props`
    open var loading: Boolean by `$props`
    open var type: String by `$props`
    companion object {
        @Suppress("UNUSED_PARAMETER", "UNUSED_VARIABLE")
        var setup: (__props: GenUniModulesCoolUiComponentsClSkeletonClSkeleton) -> Any? = fun(__props): Any? {
            val __ins = getCurrentInstance()!!
            val _ctx = __ins.proxy as GenUniModulesCoolUiComponentsClSkeletonClSkeleton
            val _cache = __ins.renderCache
            val props = __props
            val pt = computed(fun(): PassThrough53 {
                return parsePt<PassThrough53>(props.pt)
            }
            )
            val opacity = ref(0.3)
            var animationId: Number = 0
            var startTime: Number
            fun gen_start_fn() {
                if (!props.loading) {
                    return
                }
                startTime = 0
                fun animate(currentTime: Number) {
                    if (startTime == 0) {
                        startTime = currentTime
                    }
                    val elapsed = currentTime - startTime
                    val progress = (elapsed % 2000) / 2000
                    val minOpacity: Number = 0.3
                    val maxOpacity: Number = 1.0
                    opacity.value = minOpacity + (maxOpacity - minOpacity) * (Math.sin(progress * Math.PI * 2) * 0.5 + 0.5)
                    if (props.loading) {
                        animationId = requestAnimationFrame(fun(time){
                            animate(time)
                        }
                        )
                    }
                }
                animationId = requestAnimationFrame(fun(time){
                    animate(time)
                }
                )
            }
            val start = ::gen_start_fn
            fun gen_stop_fn() {
                if (animationId != 0) {
                    cancelAnimationFrame(animationId)
                    animationId = 0
                    startTime = 0
                }
            }
            val stop = ::gen_stop_fn
            onMounted(fun(){
                watch(computed(fun(): Boolean {
                    return props.loading
                }
                ), fun(kVal: Boolean){
                    if (kVal) {
                        start()
                    } else {
                        stop()
                    }
                }
                , WatchOptions(immediate = true))
            }
            )
            return fun(): Any? {
                val _component_cl_icon = resolveEasyComponent("cl-icon", GenUniModulesCoolUiComponentsClIconClIconClass)
                return _cE("view", _uM("class" to _nC(_uA(
                    "cl-skeleton",
                    _uA(
                        _uM<String, Any?>(),
                        _uM("is-loading" to _ctx.loading, "is-dark" to unref(isDark)),
                        pt.value.className,
                        "cl-skeleton--" + props.type,
                        "" + (if (_ctx.loading) {
                            "" + pt.value.loading?.className
                        } else {
                            ""
                        }
                        )
                    )
                )), "style" to _nS(_uM("opacity" to if (_ctx.loading) {
                    opacity.value
                } else {
                    1
                }
                ))), _uA(
                    if (isTrue(_ctx.loading)) {
                        _cE(Fragment, _uM("key" to 0), _uA(
                            if (_ctx.type == "image") {
                                _cV(_component_cl_icon, _uM("key" to 0, "name" to "image-line", "pt" to object : UTSJSONObject() {
                                    var className = "-important-text-surface-400"
                                }, "size" to 40))
                            } else {
                                _cC("v-if", true)
                            }
                        ), 64)
                    } else {
                        renderSlot(_ctx.`$slots`, "default", _uM("key" to 1))
                    }
                ), 6)
            }
        }
        var name = "cl-skeleton"
        val styles: Map<String, Map<String, Map<String, Any>>> by lazy {
            _nCS(_uA(
                styles0
            ))
        }
        val styles0: Map<String, Map<String, Map<String, Any>>>
            get() {
                return _uM("cl-skeleton" to _uM(".is-loading" to _uM("borderTopLeftRadius" to "10.5rpx", "borderTopRightRadius" to "10.5rpx", "borderBottomRightRadius" to "10.5rpx", "borderBottomLeftRadius" to "10.5rpx", "backgroundColor" to "rgba(244,244,245,1)"), ".is-loading.is-dark" to _uM("backgroundColor" to "rgba(82,82,91,1)"), ".is-loading.cl-skeleton--text" to _uM("height" to "40rpx", "width" to "300rpx"), ".is-loading.cl-skeleton--image" to _uM("display" to "flex", "flexDirection" to "row", "alignItems" to "center", "justifyContent" to "center", "width" to "120rpx", "height" to "120rpx", "borderTopLeftRadius" to "16rpx", "borderTopRightRadius" to "16rpx", "borderBottomRightRadius" to "16rpx", "borderBottomLeftRadius" to "16rpx"), ".is-loading.cl-skeleton--circle" to _uM("borderTopLeftRadius" to 9999, "borderTopRightRadius" to 9999, "borderBottomRightRadius" to 9999, "borderBottomLeftRadius" to 9999, "width" to "120rpx", "height" to "120rpx"), ".is-loading.cl-skeleton--button" to _uM("borderTopLeftRadius" to "14rpx", "borderTopRightRadius" to "14rpx", "borderBottomRightRadius" to "14rpx", "borderBottomLeftRadius" to "14rpx", "height" to "66rpx", "width" to "150rpx")))
            }
        var inheritAttrs = true
        var inject: Map<String, Map<String, Any?>> = _uM()
        var emits: Map<String, Any?> = _uM()
        var props = _nP(_uM("pt" to _uM("default" to fun(): UTSJSONObject {
            return (UTSJSONObject())
        }
        ), "loading" to _uM("type" to "Boolean", "default" to true), "type" to _uM("type" to "String", "default" to "text")))
        var propsNeedCastKeys = _uA(
            "pt",
            "loading",
            "type"
        )
        var components: Map<String, CreateVueComponent> = _uM()
    }
}
