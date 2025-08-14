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
open class GenUniModulesCoolUiComponentsClIndexBarClIndexBar : VueComponent {
    constructor(__ins: ComponentInternalInstance) : super(__ins) {}
    open var pt: Any by `$props`
    open var modelValue: Number by `$props`
    open var list: UTSArray<String> by `$props`
    companion object {
        @Suppress("UNUSED_PARAMETER", "UNUSED_VARIABLE")
        var setup: (__props: GenUniModulesCoolUiComponentsClIndexBarClIndexBar) -> Any? = fun(__props): Any? {
            val __ins = getCurrentInstance()!!
            val _ctx = __ins.proxy as GenUniModulesCoolUiComponentsClIndexBarClIndexBar
            val _cache = __ins.renderCache
            val props = __props
            fun emit(event: String, vararg do_not_transform_spread: Any?) {
                __ins.emit(event, *do_not_transform_spread)
            }
            val proxy = getCurrentInstance()!!.proxy
            val pt = computed(fun(): PassThrough24 {
                return parsePt<PassThrough24>(props.pt)
            }
            )
            val barRect = ref(NodeInfo(height = 0, width = 0, left = 0, top = 0))
            val itemsRect = ref(_uA<NodeInfo>())
            val isTouching = ref(false)
            val showAlert = ref(false)
            val alertText = ref("")
            val activeIndex = ref(-1)
            fun gen_getRect_fn() {
                nextTick(fun(){
                    setTimeout(fun(){
                        uni_createSelectorQuery().`in`(proxy).select(".cl-index-bar").boundingClientRect().exec(fun(bar){
                            if (isEmpty(bar)) {
                                return
                            }
                            barRect.value = bar[0] as NodeInfo
                            uni_createSelectorQuery().`in`(proxy).selectAll(".cl-index-bar__item").boundingClientRect().exec(fun(items){
                                if (isEmpty(items)) {
                                    gen_getRect_fn()
                                    return
                                }
                                itemsRect.value = items[0] as UTSArray<NodeInfo>
                            }
                            )
                        }
                        )
                    }
                    , 350)
                }
                )
            }
            val getRect = ::gen_getRect_fn
            fun gen_getIndex_fn(clientY: Number): Number {
                if (itemsRect.value.length == 0) {
                    return 0
                }
                var closestIndex: Number = 0
                var minDistance = UTSNumber.MAX_VALUE
                run {
                    var i: Number = 0
                    while(i < itemsRect.value.length){
                        val item = itemsRect.value[i]
                        val itemCenterY = (item.top ?: 0) + (item.height ?: 0) / 2
                        val distance = Math.abs(clientY - itemCenterY)
                        if (distance < minDistance) {
                            minDistance = distance
                            closestIndex = i
                        }
                        i++
                    }
                }
                if (closestIndex < 0) {
                    closestIndex = 0
                } else if (closestIndex >= props.list.length) {
                    closestIndex = props.list.length - 1
                }
                return closestIndex
            }
            val getIndex = ::gen_getIndex_fn
            fun gen_updateActive_fn(index: Number) {
                activeIndex.value = index
                alertText.value = props.list[index]
            }
            val updateActive = ::gen_updateActive_fn
            fun gen_onTouchStart_fn(e: TouchEvent) {
                isTouching.value = true
                showAlert.value = true
                val touch = e.touches[0]
                val index = getIndex(touch.clientY)
                updateActive(index)
            }
            val onTouchStart = ::gen_onTouchStart_fn
            fun gen_onTouchMove_fn(e: TouchEvent) {
                if (!isTouching.value) {
                    return
                }
                val touch = e.touches[0]
                val index = getIndex(touch.clientY)
                updateActive(index)
            }
            val onTouchMove = ::gen_onTouchMove_fn
            fun gen_onTouchEnd_fn() {
                isTouching.value = false
                if (props.modelValue != activeIndex.value) {
                    emit("update:modelValue", activeIndex.value)
                    emit("change", activeIndex.value)
                }
                setTimeout(fun(){
                    showAlert.value = false
                }
                , 500)
            }
            val onTouchEnd = ::gen_onTouchEnd_fn
            watch(computed(fun(): Number {
                return props.modelValue
            }
            ), fun(kVal: Number){
                activeIndex.value = kVal
            }
            , WatchOptions(immediate = true))
            onMounted(fun(){
                watch(computed(fun(): UTSArray<String> {
                    return props.list
                }
                ), fun(){
                    getRect()
                }
                , WatchOptions(immediate = true))
            }
            )
            return fun(): Any? {
                return _cE(Fragment, null, _uA(
                    _cE("view", _uM("class" to _nC(_uA(
                        "cl-index-bar",
                        _uA(
                            _uM<String, Any?>(),
                            pt.value.className
                        )
                    ))), _uA(
                        _cE("view", _uM("class" to "cl-index-bar__list", "onTouchstart" to onTouchStart, "onTouchmove" to withModifiers(onTouchMove, _uA(
                            "stop",
                            "prevent"
                        )), "onTouchend" to onTouchEnd), _uA(
                            _cE(Fragment, null, RenderHelpers.renderList(_ctx.list, fun(item, index, __index, _cached): Any {
                                return _cE("view", _uM("class" to "cl-index-bar__item", "key" to index), _uA(
                                    _cE("view", _uM("class" to _nC(_uA(
                                        "cl-index-bar__item-inner",
                                        _uM("is-active" to (activeIndex.value == index))
                                    ))), _uA(
                                        _cE("text", _uM("class" to _nC(_uA(
                                            "cl-index-bar__item-text",
                                            _uM("dark-colon-text-surface-50" to unref(isDark), "is-active" to (activeIndex.value == index || unref(isDark)))
                                        ))), _tD(item), 3)
                                    ), 2)
                                ))
                            }
                            ), 128)
                        ), 32)
                    ), 2),
                    withDirectives(_cE("view", _uM("class" to "cl-index-bar__alert"), _uA(
                        _cE("view", _uM("class" to _nC(_uA(
                            "cl-index-bar__alert-icon",
                            _uM("dark-colon--important-bg-surface-800" to unref(isDark))
                        ))), _uA(
                            _cE("view", _uM("class" to _nC(_uA(
                                "cl-index-bar__alert-arrow",
                                _uM("dark-colon--important-bg-surface-800" to unref(isDark))
                            ))), null, 2),
                            _cE("text", _uM("class" to _nC(_uA(
                                "cl-index-bar__alert-text",
                                _uM("dark-colon-text-surface-50" to unref(isDark), "dark-colon--important-text-white" to unref(isDark))
                            ))), _tD(alertText.value), 3)
                        ), 2)
                    ), 512), _uA(
                        _uA(
                            vShow,
                            showAlert.value
                        )
                    ))
                ), 64)
            }
        }
        var name = "cl-index-bar"
        val styles: Map<String, Map<String, Map<String, Any>>> by lazy {
            _nCS(_uA(
                styles0
            ))
        }
        val styles0: Map<String, Map<String, Map<String, Any>>>
            get() {
                return _uM("cl-index-bar" to _pS(_uM("display" to "flex", "flexDirection" to "column", "alignItems" to "center", "justifyContent" to "center", "position" to "absolute", "bottom" to 0, "right" to 0, "height" to "100%", "zIndex" to 110)), "cl-index-bar__item" to _pS(_uM("display" to "flex", "flexDirection" to "column", "alignItems" to "center", "justifyContent" to "center", "width" to "50rpx", "height" to "34rpx")), "cl-index-bar__item-inner" to _uM("" to _uM("display" to "flex", "flexDirection" to "row", "alignItems" to "center", "justifyContent" to "center", "borderTopLeftRadius" to 9999, "borderTopRightRadius" to 9999, "borderBottomRightRadius" to 9999, "borderBottomLeftRadius" to 9999, "width" to "30rpx", "height" to "30rpx"), ".is-active" to _uM("backgroundColor" to "rgba(20,184,166,1)")), "cl-index-bar__item-text" to _uM("" to _uM("fontSize" to "21rpx", "lineHeight" to "28rpx", "color" to "rgba(113,113,122,1)"), ".is-active" to _uM("color" to "rgba(255,255,255,1)")), "cl-index-bar__alert" to _pS(_uM("position" to "absolute", "bottom" to 0, "right" to "56rpx", "display" to "flex", "height" to "100%", "flexDirection" to "column", "alignItems" to "center", "justifyContent" to "center", "width" to "120rpx", "zIndex" to 110)), "cl-index-bar__alert-icon" to _pS(_uM("display" to "flex", "flexDirection" to "row", "alignItems" to "center", "justifyContent" to "center", "borderTopLeftRadius" to 9999, "borderTopRightRadius" to 9999, "borderBottomRightRadius" to 9999, "borderBottomLeftRadius" to 9999, "backgroundColor" to "rgba(212,212,216,1)", "height" to "80rpx", "width" to "80rpx", "overflow" to "visible")), "cl-index-bar__alert-arrow" to _pS(_uM("position" to "absolute", "backgroundColor" to "rgba(212,212,216,1)", "right" to "-8rpx", "height" to "40rpx", "width" to "40rpx", "transform" to "rotate(45deg)")), "cl-index-bar__alert-text" to _pS(_uM("fontSize" to "42rpx", "lineHeight" to "56rpx", "color" to "rgba(255,255,255,1)")))
            }
        var inheritAttrs = true
        var inject: Map<String, Map<String, Any?>> = _uM()
        var emits: Map<String, Any?> = _uM("update:modelValue" to null, "change" to null)
        var props = _nP(_uM("pt" to _uM("default" to fun(): UTSJSONObject {
            return (UTSJSONObject())
        }
        ), "modelValue" to _uM("type" to "Number", "default" to 0), "list" to _uM("type" to "Array", "default" to fun(): UTSArray<Any?> {
            return _uA()
        }
        )))
        var propsNeedCastKeys = _uA(
            "pt",
            "modelValue",
            "list"
        )
        var components: Map<String, CreateVueComponent> = _uM()
    }
}
