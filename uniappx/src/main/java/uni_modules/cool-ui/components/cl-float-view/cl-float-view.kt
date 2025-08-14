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
import io.dcloud.uniapp.extapi.getWindowInfo as uni_getWindowInfo
open class GenUniModulesCoolUiComponentsClFloatViewClFloatView : VueComponent {
    constructor(__ins: ComponentInternalInstance) : super(__ins) {}
    open var zIndex: Number by `$props`
    open var size: Number by `$props`
    open var left: Number by `$props`
    open var bottom: Number by `$props`
    open var gap: Number by `$props`
    open var disabled: Boolean by `$props`
    open var noSnapping: Boolean by `$props`
    companion object {
        @Suppress("UNUSED_PARAMETER", "UNUSED_VARIABLE")
        var setup: (__props: GenUniModulesCoolUiComponentsClFloatViewClFloatView) -> Any? = fun(__props): Any? {
            val __ins = getCurrentInstance()!!
            val _ctx = __ins.proxy as GenUniModulesCoolUiComponentsClFloatViewClFloatView
            val _cache = __ins.renderCache
            val props = __props
            val _uni_getWindowInfo = uni_getWindowInfo()
            val screenWidth = _uni_getWindowInfo.screenWidth
            val statusBarHeight = _uni_getWindowInfo.statusBarHeight
            val screenHeight = _uni_getWindowInfo.screenHeight
            val position = reactive<Position>(Position(x = props.left, y = props.bottom, isDragging = false))
            val dragState = reactive<DragState>(DragState(startX = 0, startY = 0))
            val viewStyle = computed(fun(): UTSJSONObject {
                val style: UTSJSONObject = UTSJSONObject()
                var bottomOffset: Number = 0
                if (hasCustomTabBar()) {
                    bottomOffset += getTabBarHeight()
                }
                style["left"] = "" + position.x + "px"
                style["bottom"] = "" + (bottomOffset + position.y) + "px"
                style["z-index"] = props.zIndex
                style["width"] = "" + props.size + "px"
                style["height"] = "" + props.size + "px"
                if (!position.isDragging) {
                    style["transition-duration"] = "300ms"
                }
                return style
            }
            )
            fun gen_calculateMaxY_fn(): Number {
                var maxY = screenHeight - props.size
                if (router.isCustomNavbarPage()) {
                    maxY -= statusBarHeight
                } else {
                    maxY -= 44 + statusBarHeight
                }
                if (router.isTabPage()) {
                    maxY -= getTabBarHeight()
                }
                return maxY
            }
            val calculateMaxY = ::gen_calculateMaxY_fn
            val maxY = calculateMaxY()
            fun gen_onTouchStart_fn(e: TouchEvent) {
                if (props.disabled) {
                    return
                }
                if (e.touches.length > 0) {
                    val touch = e.touches[0]
                    dragState.startX = touch.clientX
                    dragState.startY = touch.clientY
                    position.isDragging = true
                }
            }
            val onTouchStart = ::gen_onTouchStart_fn
            fun gen_onTouchMove_fn(e: TouchEvent) {
                if (!position.isDragging || e.touches.length == 0) {
                    return
                }
                e.preventDefault()
                val touch = e.touches[0]
                val deltaX = touch.clientX - dragState.startX
                val deltaY = dragState.startY - touch.clientY
                var newX = position.x + deltaX
                var newY = position.y + deltaY
                newX = Math.max(0, Math.min(screenWidth - props.size, newX))
                var minY: Number = 0
                if (!router.isTabPage()) {
                    minY += getSafeAreaHeight("bottom")
                }
                newY = Math.max(minY, Math.min(maxY, newY))
                position.x = newX
                position.y = newY
                dragState.startX = touch.clientX
                dragState.startY = touch.clientY
            }
            val onTouchMove = ::gen_onTouchMove_fn
            fun gen_performEdgeSnapping_fn() {
                val edgeThreshold: Number = 60
                val edgePadding = props.gap
                val centerX = screenWidth / 2
                val isLeftSide = position.x < centerX
                if (position.x < edgeThreshold) {
                    position.x = edgePadding
                } else if (position.x > screenWidth - props.size - edgeThreshold) {
                    position.x = screenWidth - props.size - edgePadding
                } else if (isLeftSide) {
                    position.x = edgePadding
                } else {
                    position.x = screenWidth - props.size - edgePadding
                }
                val verticalPadding = props.gap
                if (position.y > maxY - verticalPadding) {
                    position.y = maxY - verticalPadding
                }
                if (position.y < verticalPadding) {
                    position.y = verticalPadding
                }
            }
            val performEdgeSnapping = ::gen_performEdgeSnapping_fn
            fun gen_onTouchEnd_fn() {
                if (!position.isDragging) {
                    return
                }
                position.isDragging = false
                if (!props.noSnapping) {
                    performEdgeSnapping()
                }
            }
            val onTouchEnd = ::gen_onTouchEnd_fn
            return fun(): Any? {
                return _cE("view", _uM("class" to "cl-float-view", "style" to _nS(viewStyle.value), "onTouchstart" to onTouchStart, "onTouchmove" to withModifiers(onTouchMove, _uA(
                    "stop",
                    "prevent"
                )), "onTouchend" to onTouchEnd, "onTouchcancel" to onTouchEnd), _uA(
                    renderSlot(_ctx.`$slots`, "default")
                ), 36)
            }
        }
        var name = "cl-float-view"
        val styles: Map<String, Map<String, Map<String, Any>>> by lazy {
            _nCS(_uA(
                styles0
            ))
        }
        val styles0: Map<String, Map<String, Map<String, Any>>>
            get() {
                return _uM("cl-float-view" to _pS(_uM("position" to "fixed")))
            }
        var inheritAttrs = true
        var inject: Map<String, Map<String, Any?>> = _uM()
        var emits: Map<String, Any?> = _uM()
        var props = _nP(_uM("zIndex" to _uM("type" to "Number", "default" to 500), "size" to _uM("type" to "Number", "default" to 40), "left" to _uM("type" to "Number", "default" to 10), "bottom" to _uM("type" to "Number", "default" to 10), "gap" to _uM("type" to "Number", "default" to 10), "disabled" to _uM("type" to "Boolean", "default" to false), "noSnapping" to _uM("type" to "Boolean", "default" to false)))
        var propsNeedCastKeys = _uA(
            "zIndex",
            "size",
            "left",
            "bottom",
            "gap",
            "disabled",
            "noSnapping"
        )
        var components: Map<String, CreateVueComponent> = _uM()
    }
}
