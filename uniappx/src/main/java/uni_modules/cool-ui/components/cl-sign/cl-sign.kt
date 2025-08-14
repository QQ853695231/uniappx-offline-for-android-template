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
open class GenUniModulesCoolUiComponentsClSignClSign : VueComponent {
    constructor(__ins: ComponentInternalInstance) : super(__ins) {}
    open var pt: Any by `$props`
    open var width: Number by `$props`
    open var height: Number by `$props`
    open var strokeColor: String by `$props`
    open var strokeWidth: Number by `$props`
    open var backgroundColor: String by `$props`
    open var enableBrush: Boolean by `$props`
    open var minStrokeWidth: Number by `$props`
    open var maxStrokeWidth: Number by `$props`
    open var velocitySensitivity: Number by `$props`
    open var clear: () -> Unit
        get() {
            return unref(this.`$exposed`["clear"]) as () -> Unit
        }
        set(value) {
            setRefValue(this.`$exposed`, "clear", value)
        }
    open var toPng: () -> UTSPromise<String>
        get() {
            return unref(this.`$exposed`["toPng"]) as () -> UTSPromise<String>
        }
        set(value) {
            setRefValue(this.`$exposed`, "toPng", value)
        }
    companion object {
        @Suppress("UNUSED_PARAMETER", "UNUSED_VARIABLE")
        var setup: (__props: GenUniModulesCoolUiComponentsClSignClSign, _arg1: SetupContext) -> Any? = fun(__props, ref1): Any? {
            var __expose = ref1.expose
            val __ins = getCurrentInstance()!!
            val _ctx = __ins.proxy as GenUniModulesCoolUiComponentsClSignClSign
            val _cache = __ins.renderCache
            val props = __props
            fun emit(event: String, vararg do_not_transform_spread: Any?) {
                __ins.emit(event, *do_not_transform_spread)
            }
            val proxy = getCurrentInstance()!!.proxy
            val dpr = getDevicePixelRatio()
            val pt = computed(fun(): PassThrough55 {
                return parsePt<PassThrough55>(props.pt)
            }
            )
            val canvasRef = shallowRef<UniElement?>(null)
            var drawCtx: CanvasRenderingContext2D? = null
            val canvasId = "cl-sign__" + uuid()
            val isDrawing = ref(false)
            var lastPoint: Point? = null
            var currentStrokeWidth = ref(3)
            val velocityBuffer: UTSArray<Number> = _uA()
            var canvasRect: Rect2? = null
            fun gen_getCanvasRect_fn(): UTSPromise<Rect2> {
                return UTSPromise(fun(resolve, _reject){
                    canvasRect = Rect2(left = 0, top = 0)
                    resolve(canvasRect!!)
                }
                )
            }
            val getCanvasRect = ::gen_getCanvasRect_fn
            fun gen_getTouchPos_fn(e: TouchEvent): Point {
                val touch = e.touches[0]
                val left = canvasRect?.left ?: 0
                val top = canvasRect?.top ?: 0
                return Point(x = touch.clientX - left, y = touch.clientY - top, time = Date.now())
            }
            val getTouchPos = ::gen_getTouchPos_fn
            fun gen_calculateStrokeWidth_fn(currentPoint: Point): Number {
                if (lastPoint == null || !props.enableBrush) {
                    return props.strokeWidth
                }
                val distance = Math.sqrt(Math.pow(currentPoint.x - lastPoint!!.x, 2) + Math.pow(currentPoint.y - lastPoint!!.y, 2))
                val timeDelta = currentPoint.time - lastPoint!!.time
                if (timeDelta <= 0) {
                    return currentStrokeWidth.value
                }
                val velocity = distance / timeDelta
                velocityBuffer.push(velocity)
                if (velocityBuffer.length > 5) {
                    velocityBuffer.shift()
                }
                val avgVelocity = velocityBuffer.reduce(fun(sum, v): Number {
                    return sum + v
                }
                , 0) / velocityBuffer.length
                val normalizedVelocity = Math.min(avgVelocity * props.velocitySensitivity, 1)
                val widthRange = props.maxStrokeWidth - props.minStrokeWidth
                val targetWidth = props.maxStrokeWidth - normalizedVelocity * widthRange
                val smoothFactor: Number = 0.3
                return currentStrokeWidth.value + (targetWidth - currentStrokeWidth.value) * smoothFactor
            }
            val calculateStrokeWidth = ::gen_calculateStrokeWidth_fn
            fun gen_onTouchStart_fn(e: TouchEvent): UTSPromise<Unit> {
                return wrapUTSPromise(suspend {
                        e.preventDefault()
                        isDrawing.value = true
                        lastPoint = getTouchPos(e)
                        currentStrokeWidth.value = if (props.enableBrush) {
                            props.maxStrokeWidth
                        } else {
                            props.strokeWidth
                        }
                        velocityBuffer.length = 0
                })
            }
            val onTouchStart = ::gen_onTouchStart_fn
            fun gen_onTouchMove_fn(e: TouchEvent) {
                e.preventDefault()
                if (!isDrawing.value || lastPoint == null || drawCtx == null) {
                    return
                }
                val currentPoint = getTouchPos(e)
                val strokeWidth = calculateStrokeWidth(currentPoint)
                currentStrokeWidth.value = strokeWidth
                drawCtx!!.beginPath()
                drawCtx!!.moveTo(lastPoint!!.x * dpr, lastPoint!!.y * dpr)
                drawCtx!!.lineTo(currentPoint.x * dpr, currentPoint.y * dpr)
                drawCtx!!.strokeStyle = props.strokeColor
                drawCtx!!.lineWidth = strokeWidth * dpr
                drawCtx!!.lineCap = "round"
                drawCtx!!.lineJoin = "round"
                drawCtx!!.stroke()
                lastPoint = currentPoint
                emit("change")
            }
            val onTouchMove = ::gen_onTouchMove_fn
            fun gen_onTouchEnd_fn(e: TouchEvent) {
                e.preventDefault()
                isDrawing.value = false
                lastPoint = null
            }
            val onTouchEnd = ::gen_onTouchEnd_fn
            fun gen_clear_fn() {
                if (drawCtx == null) {
                    return
                }
                drawCtx!!.reset()
                drawCtx!!.fillStyle = props.backgroundColor
                drawCtx!!.fillRect(0, 0, props.width * dpr, props.height * dpr)
                emit("clear")
            }
            val clear = ::gen_clear_fn
            fun gen_toPng_fn(): UTSPromise<String> {
                return canvasToPng(canvasRef.value!!)
            }
            val toPng = ::gen_toPng_fn
            fun gen_initCanvas_fn() {
                uni_createCanvasContextAsync(CreateCanvasContextAsyncOptions(id = canvasId, component = proxy, success = fun(context: CanvasContext){
                    drawCtx = context.getContext("2d")!!
                    drawCtx!!.canvas.width = props.width * dpr
                    drawCtx!!.canvas.height = props.height * dpr
                    drawCtx!!.textBaseline = "middle"
                    drawCtx!!.textAlign = "center"
                    drawCtx!!.miterLimit = 10
                    clear()
                }
                ))
            }
            val initCanvas = ::gen_initCanvas_fn
            onMounted(fun(){
                initCanvas()
                watch(computed(fun(): UTSArray<Number> {
                    return _uA(
                        props.width,
                        props.height
                    )
                }
                ), fun(){
                    nextTick(fun(){
                        initCanvas()
                    }
                    )
                }
                )
            }
            )
            __expose(_uM("clear" to clear, "toPng" to toPng))
            return fun(): Any? {
                return _cE("view", _uM("class" to _nC(_uA(
                    "cl-sign",
                    _uA(
                        _uM<String, Any?>(),
                        pt.value.className
                    )
                ))), _uA(
                    _cE("canvas", _uM("class" to "cl-sign__canvas", "ref_key" to "canvasRef", "ref" to canvasRef, "id" to canvasId, "style" to _nS(_uM("height" to ("" + _ctx.height + "px"), "width" to ("" + _ctx.width + "px"))), "onTouchstart" to onTouchStart, "onTouchmove" to withModifiers(onTouchMove, _uA(
                        "stop",
                        "prevent"
                    )), "onTouchend" to onTouchEnd), null, 36)
                ), 2)
            }
        }
        var name = "cl-sign"
        val styles: Map<String, Map<String, Map<String, Any>>> by lazy {
            _nCS(_uA())
        }
        var inheritAttrs = true
        var inject: Map<String, Map<String, Any?>> = _uM()
        var emits: Map<String, Any?> = _uM("change" to null, "clear" to null)
        var props = _nP(_uM("pt" to _uM("default" to fun(): UTSJSONObject {
            return (UTSJSONObject())
        }
        ), "width" to _uM("type" to "Number", "default" to 300), "height" to _uM("type" to "Number", "default" to 200), "strokeColor" to _uM("type" to "String", "default" to "#000000"), "strokeWidth" to _uM("type" to "Number", "default" to 3), "backgroundColor" to _uM("type" to "String", "default" to "#ffffff"), "enableBrush" to _uM("type" to "Boolean", "default" to true), "minStrokeWidth" to _uM("type" to "Number", "default" to 1), "maxStrokeWidth" to _uM("type" to "Number", "default" to 6), "velocitySensitivity" to _uM("type" to "Number", "default" to 0.7)))
        var propsNeedCastKeys = _uA(
            "pt",
            "width",
            "height",
            "strokeColor",
            "strokeWidth",
            "backgroundColor",
            "enableBrush",
            "minStrokeWidth",
            "maxStrokeWidth",
            "velocitySensitivity"
        )
        var components: Map<String, CreateVueComponent> = _uM()
    }
}
