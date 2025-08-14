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
open class GenUniModulesCoolUiComponentsClListItemClListItem : VueComponent {
    constructor(__ins: ComponentInternalInstance) : super(__ins) {}
    open var pt: Any by `$props`
    open var icon: String by `$props`
    open var label: String by `$props`
    open var justify: String by `$props`
    open var arrow: Boolean by `$props`
    open var swipeable: Boolean by `$props`
    open var hoverable: Boolean by `$props`
    open var disabled: Boolean by `$props`
    open var collapse: Boolean by `$props`
    open var initSwipe: () -> Unit
        get() {
            return unref(this.`$exposed`["initSwipe"]) as () -> Unit
        }
        set(value) {
            setRefValue(this.`$exposed`, "initSwipe", value)
        }
    open var resetSwipe: () -> Unit
        get() {
            return unref(this.`$exposed`["resetSwipe"]) as () -> Unit
        }
        set(value) {
            setRefValue(this.`$exposed`, "resetSwipe", value)
        }
    companion object {
        @Suppress("UNUSED_PARAMETER", "UNUSED_VARIABLE")
        var setup: (__props: GenUniModulesCoolUiComponentsClListItemClListItem, _arg1: SetupContext) -> Any? = fun(__props, ref1): Any? {
            var __expose = ref1.expose
            val __ins = getCurrentInstance()!!
            val _ctx = __ins.proxy as GenUniModulesCoolUiComponentsClListItemClListItem
            val _cache = __ins.renderCache
            val props = __props
            val proxy = getCurrentInstance()!!.proxy
            val slots = useSlots()
            val pt = computed(fun(): PassThrough19 {
                return parsePt<PassThrough19>(props.pt)
            }
            )
            val swipe = reactive<Swipe1>(Swipe1(width = 0, maxX = 0, startX = 0, endX = 0, offsetX = 0, direction = "left", moveDirection = "left"))
            fun gen_initSwipe_fn() {
                if (!props.swipeable) {
                    return
                }
                swipe.direction = if (slots["swipe-left"] != null) {
                    "right"
                } else {
                    "left"
                }
                uni_createSelectorQuery().`in`(proxy).select(".cl-list-item__swipe").boundingClientRect(fun(node){
                    swipe.width = (node as NodeInfo).width ?: 0
                    swipe.maxX = swipe.width * (if (swipe.direction == "left") {
                        -1
                    } else {
                        1
                    }
                    )
                }
                ).exec()
            }
            val initSwipe = ::gen_initSwipe_fn
            fun gen_resetSwipe_fn() {
                swipe.startX = 0
                swipe.endX = 0
                swipe.offsetX = 0
            }
            val resetSwipe = ::gen_resetSwipe_fn
            fun gen_swipeTo_fn(num: Number) {
                fun next() {
                    requestAnimationFrame(fun(_task){
                        if (swipe.offsetX != num) {
                            val step: Number = 2
                            val direction = if (swipe.offsetX < num) {
                                1
                            } else {
                                -1
                            }
                            swipe.offsetX += step * direction
                            if (if (direction > 0) {
                                swipe.offsetX > num
                            } else {
                                swipe.offsetX < num
                            }) {
                                swipe.offsetX = num
                            }
                            next()
                        } else {
                            swipe.endX = swipe.offsetX
                        }
                    }
                    )
                }
                next()
            }
            val swipeTo = ::gen_swipeTo_fn
            val isHover = ref(false)
            fun gen_onTouchStart_fn(e: UniTouchEvent) {
                isHover.value = true
                if (props.swipeable) {
                    swipe.startX = (e.touches[0] as UniTouch).pageX
                }
            }
            val onTouchStart = ::gen_onTouchStart_fn
            fun gen_onTouchEnd_fn() {
                if (isHover.value) {
                    val threshold = if (swipe.width / 2 > 50) {
                        50
                    } else {
                        swipe.width / 2
                    }
                    val offset = Math.abs(swipe.offsetX - swipe.endX)
                    isHover.value = false
                    if (offset > threshold) {
                        if (swipe.direction == swipe.moveDirection) {
                            swipeTo(swipe.maxX)
                        } else {
                            swipeTo(0)
                        }
                    } else {
                        swipeTo(if (swipe.endX == 0) {
                            0
                        } else {
                            swipe.maxX
                        }
                        )
                    }
                }
            }
            val onTouchEnd = ::gen_onTouchEnd_fn
            fun gen_onTouchCancel_fn() {
                isHover.value = false
            }
            val onTouchCancel = ::gen_onTouchCancel_fn
            fun gen_onTouchMove_fn(e: UniTouchEvent) {
                if (isHover.value) {
                    val offsetX = (e.touches[0] as UniTouch).pageX - swipe.startX
                    swipe.moveDirection = if (offsetX > 0) {
                        "right"
                    } else {
                        "left"
                    }
                    var x = offsetX + swipe.endX
                    if (swipe.direction == "right") {
                        if (x > swipe.maxX) {
                            x = swipe.maxX
                        }
                        if (x < 0) {
                            x = 0
                        }
                    }
                    if (swipe.direction == "left") {
                        if (x < swipe.maxX) {
                            x = swipe.maxX
                        }
                        if (x > 0) {
                            x = 0
                        }
                    }
                    swipe.offsetX = x
                }
            }
            val onTouchMove = ::gen_onTouchMove_fn
            val isCollapse = ref(false)
            fun gen_onTap_fn() {
                if (props.collapse) {
                    isCollapse.value = !isCollapse.value
                }
            }
            val onTap = ::gen_onTap_fn
            onMounted(fun(){
                setTimeout(fun(){
                    initSwipe()
                }
                , if (isHarmony()) {
                    50
                } else {
                    0
                }
                )
            }
            )
            __expose(_uM("initSwipe" to initSwipe, "resetSwipe" to resetSwipe))
            return fun(): Any? {
                val _component_cl_icon = resolveEasyComponent("cl-icon", GenUniModulesCoolUiComponentsClIconClIconClass)
                val _component_cl_text = resolveEasyComponent("cl-text", GenUniModulesCoolUiComponentsClTextClTextClass)
                val _component_cl_collapse = resolveEasyComponent("cl-collapse", GenUniModulesCoolUiComponentsClCollapseClCollapseClass)
                return _cE("view", _uM("class" to _nC(_uA(
                    "cl-list-item",
                    _uA(
                        _uM<String, Any?>(),
                        _uM("cl-list-item--disabled" to _ctx.disabled),
                        pt.value.className
                    )
                )), "onTouchstart" to onTouchStart, "onTouchend" to onTouchEnd, "onTouchmove" to onTouchMove, "onTouchcancel" to onTouchCancel), _uA(
                    _cE("view", _uM("class" to _nC(_uA(
                        "cl-list-item__wrapper",
                        _uA(
                            _uM<String, Any?>(),
                            _uM("is-transition" to !isHover.value, if (unref(isDark)) {
                                "bg-surface-800"
                            } else {
                                "bg-white"
                            }
                             to true, if (unref(isDark)) {
                                "-important-bg-surface-700"
                            } else {
                                "-important-bg-surface-50"
                            }
                             to (_ctx.hoverable && isHover.value))
                        )
                    )), "style" to _nS(_uM("transform" to ("translateX(" + swipe.offsetX + "px)"))), "onClick" to onTap), _uA(
                        _cE("view", _uM("class" to _nC(_uA(
                            "cl-list-item__inner",
                            _uA(
                                _uM<String, Any?>(),
                                pt.value.inner?.className
                            )
                        ))), _uA(
                            if (isTrue(_ctx.icon)) {
                                _cV(_component_cl_icon, _uM("key" to 0, "name" to _ctx.icon, "size" to (pt.value.icon?.size ?: 36), "color" to pt.value.icon?.color, "pt" to object : UTSJSONObject() {
                                    var className = "mr-3 " + pt.value.icon?.className
                                }), null, 8, _uA(
                                    "name",
                                    "size",
                                    "color",
                                    "pt"
                                ))
                            } else {
                                _cC("v-if", true)
                            }
                            ,
                            if (isTrue(_ctx.label)) {
                                _cV(_component_cl_text, _uM("key" to 1, "pt" to object : UTSJSONObject() {
                                    var className = unref(parseClass)(_uA(
                                        "cl-list-item__label w-24 whitespace-nowrap overflow-visible",
                                        pt.value.label?.className
                                    ))
                                }), _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                                    return _uA(
                                        _tD(_ctx.label)
                                    )
                                }), "_" to 1), 8, _uA(
                                    "pt"
                                ))
                            } else {
                                _cC("v-if", true)
                            }
                            ,
                            _cE("view", _uM("class" to _nC(_uA(
                                "cl-list-item__content",
                                _uA(
                                    _uM<String, Any?>(),
                                    _uM("justify-start" to (_ctx.justify == "start"), "justify-center" to (_ctx.justify == "center"), "justify-end" to (_ctx.justify == "end")),
                                    pt.value.content?.className
                                )
                            ))), _uA(
                                renderSlot(_ctx.`$slots`, "default")
                            ), 2),
                            if (isTrue(_ctx.arrow)) {
                                _cV(_component_cl_icon, _uM("key" to 2, "name" to "arrow-right-s-line", "size" to 36, "pt" to object : UTSJSONObject() {
                                    var className = unref(parseClass)(_uA(
                                        "-important-text-surface-400 ml-1 duration-200",
                                        object : UTSJSONObject() {
                                            var `rotate-90` = isCollapse.value
                                        }
                                    ))
                                }), null, 8, _uA(
                                    "pt"
                                ))
                            } else {
                                _cC("v-if", true)
                            }
                        ), 2),
                        if (isTrue(_ctx.swipeable)) {
                            _cE("view", _uM("key" to 0, "class" to _nC(_uA(
                                _uM<String, Any?>(),
                                "cl-list-item__swipe",
                                "cl-list-item__swipe-" + swipe.direction
                            ))), _uA(
                                renderSlot(_ctx.`$slots`, "swipe-left"),
                                renderSlot(_ctx.`$slots`, "swipe-right")
                            ), 2)
                        } else {
                            _cC("v-if", true)
                        }
                    ), 6),
                    _cV(_component_cl_collapse, _uM("modelValue" to isCollapse.value, "onUpdate:modelValue" to fun(`$event`: Boolean){
                        isCollapse.value = `$event`
                    }
                    , "pt" to object : UTSJSONObject() {
                        var className = unref(parseClass)(_uA(
                            "p--bracket-start-24rpx-bracket-end-",
                            pt.value.collapse?.className
                        ))
                    }), _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                        return _uA(
                            renderSlot(_ctx.`$slots`, "collapse")
                        )
                    }
                    ), "_" to 3), 8, _uA(
                        "modelValue",
                        "onUpdate:modelValue",
                        "pt"
                    ))
                ), 34)
            }
        }
        var name = "cl-list-item"
        val styles: Map<String, Map<String, Map<String, Any>>> by lazy {
            _nCS(_uA(
                styles0
            ))
        }
        val styles0: Map<String, Map<String, Map<String, Any>>>
            get() {
                return _uM("cl-list-item" to _pS(_uM("position" to "relative", "display" to "flex", "width" to "100%", "flexDirection" to "column")), "cl-list-item__wrapper" to _pS(_uM("width" to "100%", "overflow" to "visible")), "cl-list-item__inner" to _pS(_uM("display" to "flex", "flexDirection" to "row", "alignItems" to "center", "paddingTop" to "24rpx", "paddingRight" to "24rpx", "paddingBottom" to "24rpx", "paddingLeft" to "24rpx")), "cl-list-item__content" to _pS(_uM("display" to "flex", "flexDirection" to "row", "alignItems" to "center", "flex" to 1)), "cl-list-item__swipe" to _pS(_uM("position" to "absolute", "height" to "100%")), "cl-list-item__swipe-left" to _pS(_uM("left" to "100%", "transform" to "translateX(1rpx)")), "cl-list-item__swipe-right" to _pS(_uM("right" to "100%")), "cl-list-item--disabled" to _pS(_uM("opacity" to 0.5)))
            }
        var inheritAttrs = true
        var inject: Map<String, Map<String, Any?>> = _uM()
        var emits: Map<String, Any?> = _uM()
        var props = _nP(_uM("pt" to _uM("default" to fun(): UTSJSONObject {
            return (UTSJSONObject())
        }
        ), "icon" to _uM("type" to "String", "default" to ""), "label" to _uM("type" to "String", "default" to ""), "justify" to _uM("type" to "String", "default" to "end"), "arrow" to _uM("type" to "Boolean", "default" to false), "swipeable" to _uM("type" to "Boolean", "default" to false), "hoverable" to _uM("type" to "Boolean", "default" to false), "disabled" to _uM("type" to "Boolean", "default" to false), "collapse" to _uM("type" to "Boolean", "default" to false)))
        var propsNeedCastKeys = _uA(
            "pt",
            "icon",
            "label",
            "justify",
            "arrow",
            "swipeable",
            "hoverable",
            "disabled",
            "collapse"
        )
        var components: Map<String, CreateVueComponent> = _uM()
    }
}
