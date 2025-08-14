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
open class GenUniModulesCoolUiComponentsClRollingNumberClRollingNumber : VueComponent {
    constructor(__ins: ComponentInternalInstance) : super(__ins) {}
    open var pt: Any by `$props`
    open var value: Number by `$props`
    open var duration: Number by `$props`
    open var decimals: Number by `$props`
    open var start: () -> Unit
        get() {
            return unref(this.`$exposed`["start"]) as () -> Unit
        }
        set(value) {
            setRefValue(this.`$exposed`, "start", value)
        }
    open var stop: () -> Unit
        get() {
            return unref(this.`$exposed`["stop"]) as () -> Unit
        }
        set(value) {
            setRefValue(this.`$exposed`, "stop", value)
        }
    companion object {
        @Suppress("UNUSED_PARAMETER", "UNUSED_VARIABLE")
        var setup: (__props: GenUniModulesCoolUiComponentsClRollingNumberClRollingNumber, _arg1: SetupContext) -> Any? = fun(__props, ref1): Any? {
            var __expose = ref1.expose
            val __ins = getCurrentInstance()!!
            val _ctx = __ins.proxy as GenUniModulesCoolUiComponentsClRollingNumberClRollingNumber
            val _cache = __ins.renderCache
            val props = __props
            val pt = computed(fun(): PassThrough15 {
                return parsePt<PassThrough15>(props.pt)
            }
            )
            val currentNumber = ref<Number>(0)
            val displayNumber = ref<String>("0")
            var animationId: Number = 0
            var timerId: Number = 0
            var startValue: Number = 0
            var targetValue: Number = 0
            var startTime: Number = 0
            fun gen_easeOut_fn(t: Number): Number {
                return 1 - Math.pow(1 - t, 3)
            }
            val easeOut = ::gen_easeOut_fn
            fun gen_formatNumber_fn(num: Number): String {
                if (props.decimals == 0) {
                    return Math.round(num).toString(10)
                }
                return num.toFixed(props.decimals)
            }
            val formatNumber = ::gen_formatNumber_fn
            fun gen_animate_fn(timestamp: Number): Unit {
                if (startTime == 0) {
                    startTime = timestamp
                }
                val elapsed = timestamp - startTime
                val progress = Math.min(elapsed / props.duration, 1)
                val easedProgress = easeOut(progress)
                val currentValue = startValue + (targetValue - startValue) * easedProgress
                currentNumber.value = currentValue
                displayNumber.value = formatNumber(currentValue)
                if (progress < 1) {
                    animationId = requestAnimationFrame(fun(t){
                        return gen_animate_fn(t)
                    })
                } else {
                    currentNumber.value = targetValue
                    displayNumber.value = formatNumber(targetValue)
                    animationId = 0
                }
            }
            val animate = ::gen_animate_fn
            fun gen_animateWithTimeout_fn(): Unit {
                val frameRate: Number = 60
                val frameDuration = (1000 as Number) / frameRate
                val totalFrames = Math.ceil(props.duration / frameDuration)
                var currentFrame: Number = 0
                fun loop(): Unit {
                    currentFrame++
                    val progress = Math.min(currentFrame / totalFrames, 1)
                    val easedProgress = easeOut(progress)
                    val currentValue = startValue + (targetValue - startValue) * easedProgress
                    currentNumber.value = currentValue
                    displayNumber.value = formatNumber(currentValue)
                    if (progress < 1) {
                        timerId = setTimeout(fun(){
                            return loop()
                        }, frameDuration)
                    } else {
                        currentNumber.value = targetValue
                        displayNumber.value = formatNumber(targetValue)
                        timerId = 0
                    }
                }
                loop()
            }
            val animateWithTimeout = ::gen_animateWithTimeout_fn
            fun gen_stop_fn() {
                if (animationId != 0) {
                    cancelAnimationFrame(animationId)
                    animationId = 0
                }
                if (timerId != 0) {
                    clearTimeout(timerId)
                    timerId = 0
                }
            }
            val stop = ::gen_stop_fn
            fun gen_startAnimation_fn(from: Number, to: Number): Unit {
                stop()
                startValue = from
                targetValue = to
                startTime = 0
                animationId = requestAnimationFrame(animate)
            }
            val startAnimation = ::gen_startAnimation_fn
            fun gen_start_fn() {
                startAnimation(0, props.value)
            }
            val start = ::gen_start_fn
            watch(computed(fun(): Number {
                return props.value
            }
            ), fun(newValue: Number, oldValue: Number){
                if (newValue != oldValue) {
                    startAnimation(currentNumber.value, newValue)
                }
            }
            , WatchOptions(immediate = false))
            onMounted(fun(){
                start()
            }
            )
            __expose(_uM("start" to start, "stop" to stop))
            return fun(): Any? {
                val _component_cl_text = resolveEasyComponent("cl-text", GenUniModulesCoolUiComponentsClTextClTextClass)
                return _cV(_component_cl_text, _uM("color" to pt.value.color, "pt" to object : UTSJSONObject() {
                    var className = unref(parseClass)(_uA(
                        "cl-rolling-number",
                        pt.value.className
                    ))
                }), _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                    return _uA(
                        _tD(displayNumber.value)
                    )
                }
                ), "_" to 1), 8, _uA(
                    "color",
                    "pt"
                ))
            }
        }
        val styles: Map<String, Map<String, Map<String, Any>>> by lazy {
            _nCS(_uA())
        }
        var inheritAttrs = true
        var inject: Map<String, Map<String, Any?>> = _uM()
        var emits: Map<String, Any?> = _uM()
        var props = _nP(_uM("pt" to _uM("default" to fun(): UTSJSONObject {
            return (UTSJSONObject())
        }
        ), "value" to _uM("type" to "Number", "default" to 0), "duration" to _uM("type" to "Number", "default" to 1000), "decimals" to _uM("type" to "Number", "default" to 0)))
        var propsNeedCastKeys = _uA(
            "pt",
            "value",
            "duration",
            "decimals"
        )
        var components: Map<String, CreateVueComponent> = _uM()
    }
}
