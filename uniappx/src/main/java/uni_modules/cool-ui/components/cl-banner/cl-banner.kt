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
open class GenUniModulesCoolUiComponentsClBannerClBanner : VueComponent {
    constructor(__ins: ComponentInternalInstance) : super(__ins) {}
    open var pt: Any by `$props`
    open var list: UTSArray<String> by `$props`
    open var previousMargin: Number by `$props`
    open var nextMargin: Number by `$props`
    open var autoplay: Boolean by `$props`
    open var interval: Number by `$props`
    open var showDots: Boolean by `$props`
    open var disableTouch: Boolean by `$props`
    open var height: Any by `$props`
    companion object {
        @Suppress("UNUSED_PARAMETER", "UNUSED_VARIABLE")
        var setup: (__props: GenUniModulesCoolUiComponentsClBannerClBanner) -> Any? = fun(__props): Any? {
            val __ins = getCurrentInstance()!!
            val _ctx = __ins.proxy as GenUniModulesCoolUiComponentsClBannerClBanner
            val _cache = __ins.renderCache
            val props = __props
            fun emit(event: String, vararg do_not_transform_spread: Any?) {
                __ins.emit(event, *do_not_transform_spread)
            }
            val proxy = getCurrentInstance()!!.proxy
            val pt = computed(fun(): PassThrough45 {
                return parsePt<PassThrough45>(props.pt)
            }
            )
            val activeIndex = ref(0)
            val list = computed<UTSArray<Item4>>(fun(): UTSArray<Item4> {
                return props.list.map(fun(e, i): Item4 {
                    return Item4(url = e, isActive = i == activeIndex.value)
                }
                )
            }
            )
            val slideOffset = ref(0)
            val isAnimating = ref(false)
            val bannerWidth = ref(0)
            val slideWidth = ref(0)
            val touchStartPoint = ref(0)
            val touchStartTimestamp = ref(0)
            val initialOffset = ref(0)
            fun gen_updateSlidePosition_fn() {
                if (bannerWidth.value == 0) {
                    return
                }
                var totalOffset: Number = 0
                run {
                    var i: Number = 0
                    while(i < activeIndex.value){
                        val itemPreviousMargin = if (i == 0) {
                            0
                        } else {
                            props.previousMargin
                        }
                        val itemNextMargin = if (i == props.list.length - 1) {
                            0
                        } else {
                            props.nextMargin
                        }
                        val itemWidthAtIndex = bannerWidth.value - itemPreviousMargin - itemNextMargin
                        totalOffset += itemWidthAtIndex
                        i++
                    }
                }
                val currentPreviousMargin = if (activeIndex.value == 0) {
                    0
                } else {
                    props.previousMargin
                }
                slideOffset.value = -totalOffset + currentPreviousMargin
            }
            val updateSlidePosition = ::gen_updateSlidePosition_fn
            fun gen_getSlideWidth_fn(index: Number): Number {
                val itemPreviousMargin = if (index == 0) {
                    0
                } else {
                    props.previousMargin
                }
                val itemNextMargin = if (index == props.list.length - 1) {
                    0
                } else {
                    props.nextMargin
                }
                return bannerWidth.value - itemPreviousMargin - itemNextMargin
            }
            val getSlideWidth = ::gen_getSlideWidth_fn
            fun gen_calculateSlideWidth_fn() {
                val baseWidth = bannerWidth.value - props.previousMargin - props.nextMargin
                slideWidth.value = baseWidth
            }
            val calculateSlideWidth = ::gen_calculateSlideWidth_fn
            fun gen_getRect_fn() {
                uni_createSelectorQuery().`in`(proxy).select(".cl-banner").boundingClientRect(fun(node){
                    bannerWidth.value = (node as NodeInfo).width ?: 0
                    calculateSlideWidth()
                    updateSlidePosition()
                }
                ).exec()
            }
            val getRect = ::gen_getRect_fn
            var autoplayTimer: Number = 0
            fun gen_clearAutoplay_fn() {
                if (autoplayTimer != 0) {
                    clearInterval(autoplayTimer)
                    autoplayTimer = 0
                }
            }
            val clearAutoplay = ::gen_clearAutoplay_fn
            fun gen_startAutoplay_fn() {
                if (props.list.length <= 1) {
                    return
                }
                if (props.autoplay) {
                    clearAutoplay()
                }
                isAnimating.value = true
                autoplayTimer = setInterval(fun(){
                    if (activeIndex.value >= props.list.length - 1) {
                        activeIndex.value = 0
                    } else {
                        activeIndex.value++
                    }
                }
                , props.interval)
            }
            val startAutoplay = ::gen_startAutoplay_fn
            fun gen_onTouchStart_fn(e: UniTouchEvent) {
                if (props.disableTouch) {
                    return
                }
                if (props.list.length <= 1) {
                    return
                }
                clearAutoplay()
                isAnimating.value = false
                touchStartPoint.value = e.touches[0].clientX
                touchStartTimestamp.value = Date.now()
                initialOffset.value = slideOffset.value
            }
            val onTouchStart = ::gen_onTouchStart_fn
            fun gen_onTouchMove_fn(e: UniTouchEvent) {
                if (props.list.length <= 1 || props.disableTouch) {
                    return
                }
                val deltaX = e.touches[0].clientX - touchStartPoint.value
                slideOffset.value = initialOffset.value + deltaX
            }
            val onTouchMove = ::gen_onTouchMove_fn
            fun gen_onTouchEnd_fn() {
                if (props.list.length <= 1) {
                    return
                }
                isAnimating.value = true
                val deltaX = slideOffset.value - initialOffset.value
                val deltaTime = Date.now() - touchStartTimestamp.value
                val velocity = Math.abs(deltaX) / deltaTime
                var newIndex = activeIndex.value
                val currentSlideWidth = getSlideWidth(activeIndex.value)
                if (Math.abs(deltaX) > currentSlideWidth * 0.3 || velocity > 0.3) {
                    if (deltaX > 0 && activeIndex.value > 0) {
                        newIndex = activeIndex.value - 1
                    } else if (deltaX < 0 && activeIndex.value < props.list.length - 1) {
                        newIndex = activeIndex.value + 1
                    }
                }
                activeIndex.value = newIndex
                updateSlidePosition()
                setTimeout(fun(){
                    startAutoplay()
                }
                , 300)
            }
            val onTouchEnd = ::gen_onTouchEnd_fn
            fun gen_handleSlideClick_fn(index: Number) {
                emit("item-tap", index)
            }
            val handleSlideClick = ::gen_handleSlideClick_fn
            watch(activeIndex, fun(kVal: Number){
                updateSlidePosition()
                emit("change", kVal)
            }
            )
            onMounted(fun(){
                getRect()
                startAutoplay()
            }
            )
            return fun(): Any? {
                return _cE("view", _uM("class" to _nC(_uA(
                    "cl-banner",
                    _uA(
                        _uM<String, Any?>(),
                        pt.value.className
                    )
                )), "style" to _nS(_uM("height" to unref(parseRpx)(_ctx.height))), "onTouchstart" to onTouchStart, "onTouchmove" to onTouchMove, "onTouchend" to onTouchEnd, "onTouchcancel" to onTouchEnd), _uA(
                    _cE("view", _uM("class" to _nC(_uA(
                        "cl-banner__list",
                        _uM("is-transition" to isAnimating.value)
                    )), "style" to _nS(_uM("transform" to ("translateX(" + slideOffset.value + "px)")))), _uA(
                        _cE(Fragment, null, RenderHelpers.renderList(list.value, fun(item, index, __index, _cached): Any {
                            return _cE("view", _uM("class" to _nC(_uA(
                                "cl-banner__item",
                                _uA(
                                    _uM<String, Any?>(),
                                    pt.value.item?.className,
                                    "" + (if (item.isActive) {
                                        "" + pt.value.itemActive?.className
                                    } else {
                                        ""
                                    }
                                    )
                                )
                            )), "key" to index, "style" to _nS(_uM("width" to ("" + getSlideWidth(index) + "px"))), "onClick" to fun(){
                                handleSlideClick(index)
                            }
                            ), _uA(
                                renderSlot(_ctx.`$slots`, "default", _uM("item" to item, "index" to index), fun(): UTSArray<Any> {
                                    return _uA(
                                        _cE("image", _uM("src" to item.url, "mode" to "aspectFill", "class" to _nC(_uA(
                                            "cl-banner__item-image",
                                            _uA(
                                                _uM<String, Any?>(),
                                                pt.value.image?.className
                                            )
                                        ))), null, 10, _uA(
                                            "src"
                                        ))
                                    )
                                }
                                )
                            ), 14, _uA(
                                "onClick"
                            ))
                        }
                        ), 128)
                    ), 6),
                    if (isTrue(_ctx.showDots)) {
                        _cE("view", _uM("key" to 0, "class" to _nC(_uA(
                            "cl-banner__dots",
                            _uA(
                                _uM<String, Any?>(),
                                pt.value.dots?.className
                            )
                        ))), _uA(
                            _cE(Fragment, null, RenderHelpers.renderList(list.value, fun(item, index, __index, _cached): Any {
                                return _cE("view", _uM("class" to _nC(_uA(
                                    "cl-banner__dots-item",
                                    _uA(
                                        _uM<String, Any?>(),
                                        _uM("is-active" to item.isActive),
                                        pt.value.dot?.className,
                                        "" + (if (item.isActive) {
                                            "" + pt.value.dotActive?.className
                                        } else {
                                            ""
                                        })
                                    )
                                )), "key" to index), null, 2)
                            }), 128)
                        ), 2)
                    } else {
                        _cC("v-if", true)
                    }
                ), 38)
            }
        }
        var name = "cl-banner"
        val styles: Map<String, Map<String, Map<String, Any>>> by lazy {
            _nCS(_uA(
                styles0
            ))
        }
        val styles0: Map<String, Map<String, Map<String, Any>>>
            get() {
                return _uM("cl-banner" to _pS(_uM("position" to "relative", "zIndex" to 10, "borderTopLeftRadius" to "21rpx", "borderTopRightRadius" to "21rpx", "borderBottomRightRadius" to "21rpx", "borderBottomLeftRadius" to "21rpx")), "cl-banner__list" to _uM("" to _uM("display" to "flex", "height" to "100%", "width" to "100%", "flexDirection" to "row", "overflow" to "visible"), ".is-transition" to _uM("transitionProperty" to "transform", "transitionDuration" to "0.3s")), "cl-banner__item" to _pS(_uM("position" to "relative", "transitionProperty" to "transform", "transitionTimingFunction" to "cubic-bezier(0.4,0,0.2,1)", "transitionDuration" to "150ms")), "cl-banner__item-image" to _pS(_uM("height" to "100%", "width" to "100%", "borderTopLeftRadius" to "21rpx", "borderTopRightRadius" to "21rpx", "borderBottomRightRadius" to "21rpx", "borderBottomLeftRadius" to "21rpx")), "cl-banner__dots" to _pS(_uM("display" to "flex", "flexDirection" to "row", "alignItems" to "center", "justifyContent" to "center", "position" to "absolute", "bottom" to "21rpx", "left" to 0, "width" to "100%")), "cl-banner__dots-item" to _uM("" to _uM("marginLeft" to "7rpx", "marginRight" to "7rpx", "height" to "14rpx", "width" to "14rpx", "borderTopLeftRadius" to 9999, "borderTopRightRadius" to 9999, "borderBottomRightRadius" to 9999, "borderBottomLeftRadius" to 9999, "backgroundColor" to "rgba(255,255,255,0.3)", "transitionProperty" to "width,backgroundColor", "transitionDuration" to "0.3s"), ".is-active" to _uM("width" to "35rpx", "backgroundColor" to "rgba(255,255,255,1)")), "@TRANSITION" to _uM("cl-banner__list" to _uM("property" to "transform", "duration" to "0.3s"), "cl-banner__item" to _uM("property" to "transform", "timingFunction" to "cubic-bezier(0.4,0,0.2,1)", "duration" to "150ms"), "cl-banner__dots-item" to _uM("property" to "width,backgroundColor", "duration" to "0.3s")))
            }
        var inheritAttrs = true
        var inject: Map<String, Map<String, Any?>> = _uM()
        var emits: Map<String, Any?> = _uM("change" to null, "item-tap" to null)
        var props = _nP(_uM("pt" to _uM("default" to fun(): UTSJSONObject {
            return (UTSJSONObject())
        }
        ), "list" to _uM("type" to "Array", "default" to fun(): UTSArray<Any?> {
            return _uA()
        }
        ), "previousMargin" to _uM("type" to "Number", "default" to 0), "nextMargin" to _uM("type" to "Number", "default" to 0), "autoplay" to _uM("type" to "Boolean", "default" to true), "interval" to _uM("type" to "Number", "default" to 5000), "showDots" to _uM("type" to "Boolean", "default" to true), "disableTouch" to _uM("type" to "Boolean", "default" to false), "height" to _uM("type" to _uA(
            "Number",
            "String"
        ), "default" to 300)))
        var propsNeedCastKeys = _uA(
            "pt",
            "list",
            "previousMargin",
            "nextMargin",
            "autoplay",
            "interval",
            "showDots",
            "disableTouch",
            "height"
        )
        var components: Map<String, CreateVueComponent> = _uM()
    }
}
