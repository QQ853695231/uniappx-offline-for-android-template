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
open class GenUniModulesCoolUiComponentsClCountdownClCountdown : VueComponent {
    constructor(__ins: ComponentInternalInstance) : super(__ins) {}
    open var pt: Any by `$props`
    open var format: String by `$props`
    open var hideZero: Boolean by `$props`
    open var day: Number by `$props`
    open var hour: Number by `$props`
    open var minute: Number by `$props`
    open var second: Number by `$props`
    open var datetime: Any? by `$props`
    open fun start(options: Options? = null) {
        callKotlinFunction(this.`$exposed`["start"]!!, _uA(
            options
        ))
    }
    open var stop: () -> Unit
        get() {
            return unref(this.`$exposed`["stop"]) as () -> Unit
        }
        set(value) {
            setRefValue(this.`$exposed`, "stop", value)
        }
    open var done: () -> Unit
        get() {
            return unref(this.`$exposed`["done"]) as () -> Unit
        }
        set(value) {
            setRefValue(this.`$exposed`, "done", value)
        }
    open var isRunning: Boolean
        get() {
            return unref(this.`$exposed`["isRunning"]) as Boolean
        }
        set(value) {
            setRefValue(this.`$exposed`, "isRunning", value)
        }
    companion object {
        @Suppress("UNUSED_PARAMETER", "UNUSED_VARIABLE")
        var setup: (__props: GenUniModulesCoolUiComponentsClCountdownClCountdown, _arg1: SetupContext) -> Any? = fun(__props, ref1): Any? {
            var __expose = ref1.expose
            val __ins = getCurrentInstance()!!
            val _ctx = __ins.proxy as GenUniModulesCoolUiComponentsClCountdownClCountdown
            val _cache = __ins.renderCache
            val props = __props
            fun emit(event: String, vararg do_not_transform_spread: Any?) {
                __ins.emit(event, *do_not_transform_spread)
            }
            val pt = computed(fun(): PassThrough51 {
                return parsePt<PassThrough51>(props.pt)
            }
            )
            var timer: Number = 0
            val seconds = ref(0)
            val isRunning = ref(false)
            val list = ref(_uA<Item5>())
            fun gen_toSeconds_fn(ref1: Options): Number {
                var day = ref1.day
                var hour = ref1.hour
                var minute = ref1.minute
                var second = ref1.second
                var datetime = ref1.datetime
                if (datetime != null) {
                    val diff = dayUts(datetime).diff(dayUts())
                    return Math.max(0, Math.floor(diff / 1000))
                } else {
                    return Math.max(0, (day ?: 0) * 86400 + (hour ?: 0) * 3600 + (minute ?: 0) * 60 + (second ?: 0))
                }
            }
            val toSeconds = ::gen_toSeconds_fn
            fun gen_countDown_fn() {
                val totalSeconds = Math.floor(seconds.value)
                val day = Math.floor(totalSeconds / 86400)
                val hour = Math.floor((totalSeconds % 86400) / 3600)
                val minute = Math.floor((totalSeconds % 3600) / 60)
                val second = totalSeconds % 60
                val t: UTSJSONObject = object : UTSJSONObject() {
                    var d = day.toString(10)
                    var h = hour.toString(10).padStart(2, "0")
                    var m = minute.toString(10).padStart(2, "0")
                    var s = second.toString(10).padStart(2, "0")
                }
                var isHide = true
                var start: Number = -1
                list.value = (props.format.split(UTSRegExp("[{,}]", "")) as UTSArray<String>).map(fun(e, i): Item5 {
                    val value = if (has(t, e)) {
                        (get(t, e) as String)
                    } else {
                        e
                    }
                    val isSplitor = UTSRegExp("^\\D+\$", "").test(value)
                    if (props.hideZero) {
                        if (isHide && !isSplitor) {
                            if (value == "00" || value == "0" || isEmpty(value)) {
                                start = i
                                isHide = true
                            } else {
                                isHide = false
                            }
                        }
                    }
                    return Item5(value = value, isSplitor = isSplitor)
                }
                ).filter(fun(e, i): Boolean {
                    return !isEmpty(e.value) && (if (start == -1) {
                        true
                    } else {
                        start < i
                    }
                    )
                }
                ).filter(fun(e, i): Boolean {
                    if (i == 0 && e.isSplitor) {
                        return false
                    }
                    return true
                }
                )
                emit("change", list.value)
            }
            val countDown = ::gen_countDown_fn
            fun gen_clear_fn() {
                clearTimeout(timer)
                timer = 0
                isRunning.value = false
            }
            val clear = ::gen_clear_fn
            fun gen_stop_fn() {
                clear()
                emit("stop")
            }
            val stop = ::gen_stop_fn
            fun gen_done_fn() {
                clear()
                emit("done")
            }
            val done = ::gen_done_fn
            fun gen_next_fn() {
                if (seconds.value <= 0 || isRunning.value) {
                    return
                }
                isRunning.value = true
                fun loop() {
                    countDown()
                    if (seconds.value <= 0) {
                        done()
                        return
                    } else {
                        seconds.value--
                        timer = setTimeout(fun(){
                            return loop()
                        }
                        , 1000)
                    }
                }
                loop()
            }
            val next = ::gen_next_fn
            fun start(options: Options? = null) {
                nextTick(fun(){
                    seconds.value = toSeconds(Options(day = options?.day ?: props.day, hour = options?.hour ?: props.hour, minute = options?.minute ?: props.minute, second = options?.second ?: props.second, datetime = options?.datetime ?: props.datetime))
                    next()
                }
                )
            }
            watch(computed(fun(): UTSArray<Number> {
                return _uA<Number>(props.day, props.hour, props.minute, props.second)
            }
            ), fun(){
                start()
            }
            )
            watch(computed(fun(): Any? {
                return props.datetime
            }
            ), fun(){
                start()
            }
            )
            onBeforeUnmount(fun(){
                return stop()
            }
            )
            onBeforeMount(fun(){
                return start()
            }
            )
            __expose(_uM("start" to ::start, "stop" to stop, "done" to done, "isRunning" to isRunning))
            return fun(): Any? {
                val _component_cl_text = resolveEasyComponent("cl-text", GenUniModulesCoolUiComponentsClTextClTextClass)
                return _cE("view", _uM("class" to _nC(_uA(
                    "cl-countdown",
                    _uA(
                        _uM<String, Any?>(),
                        pt.value.className
                    )
                ))), _uA(
                    _cE(Fragment, null, RenderHelpers.renderList(list.value, fun(item, index, __index, _cached): Any {
                        return _cE("view", _uM("class" to _nC(_uA(
                            "cl-countdown__item",
                            _uA(
                                _uM<String, Any?>(),
                                "" + (if (item.isSplitor) {
                                    pt.value.splitor?.className
                                } else {
                                    pt.value.text?.className
                                }
                                )
                            )
                        )), "key" to index), _uA(
                            renderSlot(_ctx.`$slots`, "item", GenUniModulesCoolUiComponentsClCountdownClCountdownSlotDataItem(item = item), fun(): UTSArray<Any> {
                                return _uA(
                                    _cV(_component_cl_text, null, _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                                        return _uA(
                                            _tD(item.value)
                                        )
                                    }
                                    ), "_" to 2), 1024)
                                )
                            }
                            )
                        ), 2)
                    }
                    ), 128)
                ), 2)
            }
        }
        var name = "cl-countdown"
        val styles: Map<String, Map<String, Map<String, Any>>> by lazy {
            _nCS(_uA(
                styles0
            ))
        }
        val styles0: Map<String, Map<String, Map<String, Any>>>
            get() {
                return _uM("cl-countdown" to _pS(_uM("display" to "flex", "flexDirection" to "row", "alignItems" to "center")), "cl-countdown__item" to _pS(_uM("display" to "flex", "flexDirection" to "row", "alignItems" to "center", "justifyContent" to "center")))
            }
        var inheritAttrs = true
        var inject: Map<String, Map<String, Any?>> = _uM()
        var emits: Map<String, Any?> = _uM("stop" to null, "done" to null, "change" to null)
        var props = _nP(_uM("pt" to _uM("default" to fun(): UTSJSONObject {
            return (UTSJSONObject())
        }
        ), "format" to _uM("type" to "String", "default" to "{h}:{m}:{s}"), "hideZero" to _uM("type" to "Boolean", "default" to false), "day" to _uM("type" to "Number", "default" to 0), "hour" to _uM("type" to "Number", "default" to 0), "minute" to _uM("type" to "Number", "default" to 0), "second" to _uM("type" to "Number", "default" to 0), "datetime" to _uM("default" to null)))
        var propsNeedCastKeys = _uA(
            "pt",
            "format",
            "hideZero",
            "day",
            "hour",
            "minute",
            "second",
            "datetime"
        )
        var components: Map<String, CreateVueComponent> = _uM()
    }
}
