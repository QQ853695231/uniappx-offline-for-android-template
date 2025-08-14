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
import io.dcloud.uniapp.extapi.createCanvasContextAsync as uni_createCanvasContextAsync
open class GenUniModulesCoolUiComponentsClProgressCircleClProgressCircle : VueComponent {
    constructor(__ins: ComponentInternalInstance) : super(__ins) {}
    open var pt: Any by `$props`
    open var value: Number by `$props`
    open var size: Number by `$props`
    open var strokeWidth: Number by `$props`
    open var color: String? by `$props`
    open var unColor: String? by `$props`
    open var showText: Boolean by `$props`
    open var unit: String by `$props`
    open var startAngle: Number by `$props`
    open var clockwise: Boolean by `$props`
    open var duration: Number by `$props`
    open var animate: (targetValue: Number) -> Unit
        get() {
            return unref(this.`$exposed`["animate"]) as (targetValue: Number) -> Unit
        }
        set(value) {
            setRefValue(this.`$exposed`, "animate", value)
        }
    companion object {
        @Suppress("UNUSED_PARAMETER", "UNUSED_VARIABLE")
        var setup: (__props: GenUniModulesCoolUiComponentsClProgressCircleClProgressCircle, _arg1: SetupContext) -> Any? = fun(__props, ref1): Any? {
            var __expose = ref1.expose
            val __ins = getCurrentInstance()!!
            val _ctx = __ins.proxy as GenUniModulesCoolUiComponentsClProgressCircleClProgressCircle
            val _cache = __ins.renderCache
            val props = __props
            val proxy = getCurrentInstance()!!.proxy
            val dpr = getDevicePixelRatio()
            val pt = computed(fun(): PassThrough52 {
                return parsePt<PassThrough52>(props.pt)
            }
            )
            var canvasCtx: CanvasContext? = null
            var drawCtx: CanvasRenderingContext2D? = null
            val canvasId = "cl-progress-circle__" + uuid()
            val value = ref(0)
            fun gen_drawProgress_fn() {
                if (drawCtx == null) {
                    return
                }
                val centerX = (props.size / 2) * dpr
                val centerY = (props.size / 2) * dpr
                val radius = ((props.size - props.strokeWidth) / 2) * dpr
                drawCtx!!.reset()
                drawCtx!!.textBaseline = "middle"
                drawCtx!!.textAlign = "center"
                drawCtx!!.miterLimit = 10
                drawCtx!!.save()
                val drawCircle = fun(startAngle: Number, endAngle: Number, color: String){
                    if (drawCtx == null) {
                        return
                    }
                    drawCtx!!.beginPath()
                    drawCtx!!.arc(centerX, centerY, radius, startAngle, endAngle, false)
                    drawCtx!!.strokeStyle = color
                    drawCtx!!.lineWidth = props.strokeWidth * dpr
                    drawCtx!!.lineCap = "round"
                    drawCtx!!.lineJoin = "round"
                    drawCtx!!.stroke()
                }
                drawCircle(0, 2 * Math.PI, props.unColor ?: (if (isDark.value) {
                    getColor("surface-700")
                } else {
                    getColor("surface-200")
                }
                ))
                if (value.value > 0) {
                    val progress = Math.max(0, Math.min(100, value.value)) / 100
                    val endAngle = props.startAngle + (if (props.clockwise) {
                        1
                    } else {
                        -1
                    }
                    ) * 2 * Math.PI * progress
                    drawCircle(props.startAngle, endAngle, props.color ?: getColor("primary-500"))
                }
            }
            val drawProgress = ::gen_drawProgress_fn
            fun gen_animate_fn(targetValue: Number) {
                val startValue = value.value
                val startTime = Date.now()
                fun update() {
                    val currentTime = Date.now()
                    val elapsed = currentTime - startTime
                    val progress = Math.min(elapsed / props.duration, 1)
                    val easedProgress = 1 - Math.pow(1 - progress, 3)
                    value.value = Math.round(startValue + (targetValue - startValue) * easedProgress)
                    drawProgress()
                    if (progress < 1) {
                        if (canvasCtx != null) {
                            canvasCtx!!.requestAnimationFrame(fun(_time){
                                update()
                            }
                            )
                        }
                    }
                }
                update()
            }
            val animate = ::gen_animate_fn
            fun gen_initCanvas_fn() {
                uni_createCanvasContextAsync(CreateCanvasContextAsyncOptions(id = canvasId, component = proxy, success = fun(context: CanvasContext){
                    canvasCtx = context
                    drawCtx = context.getContext("2d")!!
                    drawCtx!!.canvas.width = props.size * dpr
                    drawCtx!!.canvas.height = props.size * dpr
                    animate(props.value)
                }
                ))
            }
            val initCanvas = ::gen_initCanvas_fn
            onMounted(fun(){
                initCanvas()
                watch(computed(fun(): Number {
                    return props.value
                }
                ), fun(kVal: Number){
                    animate(Math.max(0, Math.min(100, kVal)))
                }
                , WatchOptions(immediate = true))
                watch(computed(fun(): UTSArray<Any?> {
                    return _uA(
                        props.color,
                        props.unColor,
                        isDark.value
                    )
                }
                ), fun(){
                    drawProgress()
                }
                )
            }
            )
            __expose(_uM("animate" to animate))
            return fun(): Any? {
                val _component_cl_text = resolveEasyComponent("cl-text", GenUniModulesCoolUiComponentsClTextClTextClass)
                return _cE("view", _uM("class" to _nC(_uA(
                    "cl-progress-circle",
                    _uA(
                        _uM<String, Any?>(),
                        pt.value.className
                    )
                ))), _uA(
                    _cE("canvas", _uM("class" to "cl-progress-circle__canvas", "id" to canvasId, "style" to _nS(_uM("height" to ("" + props.size + "px"), "width" to ("" + props.size + "px")))), null, 4),
                    renderSlot(_ctx.`$slots`, "text", UTSJSONObject(), fun(): UTSArray<Any> {
                        return _uA(
                            if (isTrue(_ctx.showText)) {
                                _cV(_component_cl_text, _uM("key" to 0, "value" to ("" + value.value + _ctx.unit), "pt" to object : UTSJSONObject() {
                                    var className = unref(parseClass)(_uA(
                                        "absolute",
                                        pt.value.text?.className
                                    ))
                                }), null, 8, _uA(
                                    "value",
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
        var name = "cl-progress-circle"
        val styles: Map<String, Map<String, Map<String, Any>>> by lazy {
            _nCS(_uA(
                styles0
            ))
        }
        val styles0: Map<String, Map<String, Map<String, Any>>>
            get() {
                return _uM("cl-progress-circle" to _pS(_uM("position" to "relative", "display" to "flex", "flexDirection" to "column", "alignItems" to "center", "justifyContent" to "center")))
            }
        var inheritAttrs = true
        var inject: Map<String, Map<String, Any?>> = _uM()
        var emits: Map<String, Any?> = _uM()
        var props = _nP(_uM("pt" to _uM("default" to fun(): UTSJSONObject {
            return (UTSJSONObject())
        }
        ), "value" to _uM("type" to "Number", "default" to 0), "size" to _uM("type" to "Number", "default" to 120), "strokeWidth" to _uM("type" to "Number", "default" to 8), "color" to _uM("type" to "String", "default" to null), "unColor" to _uM("type" to "String", "default" to null), "showText" to _uM("type" to "Boolean", "default" to true), "unit" to _uM("type" to "String", "default" to "%"), "startAngle" to _uM("type" to "Number", "default" to (-Math.PI / 2)), "clockwise" to _uM("type" to "Boolean", "default" to true), "duration" to _uM("type" to "Number", "default" to 500)))
        var propsNeedCastKeys = _uA(
            "pt",
            "value",
            "size",
            "strokeWidth",
            "color",
            "unColor",
            "showText",
            "unit",
            "startAngle",
            "clockwise",
            "duration"
        )
        var components: Map<String, CreateVueComponent> = _uM()
    }
}
