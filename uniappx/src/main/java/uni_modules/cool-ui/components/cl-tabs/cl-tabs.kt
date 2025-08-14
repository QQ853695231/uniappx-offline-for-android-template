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
open class GenUniModulesCoolUiComponentsClTabsClTabs : VueComponent {
    constructor(__ins: ComponentInternalInstance) : super(__ins) {}
    open var pt: Any by `$props`
    open var modelValue: Any? by `$props`
    open var height: Any? by `$props`
    open var list: UTSArray<ClTabsItem> by `$props`
    open var fill: Boolean by `$props`
    open var gutter: Number by `$props`
    open var color: String by `$props`
    open var unColor: String by `$props`
    open var showLine: Boolean by `$props`
    open var showSlider: Boolean by `$props`
    open var disabled: Boolean by `$props`
    companion object {
        @Suppress("UNUSED_PARAMETER", "UNUSED_VARIABLE")
        var setup: (__props: GenUniModulesCoolUiComponentsClTabsClTabs) -> Any? = fun(__props): Any? {
            val __ins = getCurrentInstance()!!
            val _ctx = __ins.proxy as GenUniModulesCoolUiComponentsClTabsClTabs
            val _cache = __ins.renderCache
            val props = __props
            fun emit(event: String, vararg do_not_transform_spread: Any?) {
                __ins.emit(event, *do_not_transform_spread)
            }
            val proxy = getCurrentInstance()!!.proxy
            val pt = computed(fun(): PassThrough30 {
                return parsePt<PassThrough30>(props.pt)
            }
            )
            val active = ref(props.modelValue)
            val list = computed(fun(): UTSArray<Item3> {
                return props.list.map(fun(e): Item3 {
                    return Item3(label = e.label, value = e.value, disabled = e.disabled ?: false, isActive = e.value == active.value)
                }
                )
            }
            )
            fun gen_change_fn(index: Number): UTSPromise<Any> {
                return wrapUTSPromise(suspend w@{
                        if (props.disabled) {
                            return@w false
                        }
                        val _list_value_index = list.value[index]
                        val value = _list_value_index.value
                        val disabled = _list_value_index.disabled
                        if (disabled) {
                            return@w false
                        }
                        emit("update:modelValue", value)
                        emit("change", value)
                })
            }
            val change = ::gen_change_fn
            fun gen_getIndex_fn(): Number {
                val index = list.value.findIndex(fun(e): Boolean {
                    return e.isActive
                }
                )
                return if (index == -1) {
                    0
                } else {
                    index
                }
            }
            val getIndex = ::gen_getIndex_fn
            fun gen_getColor_fn(isActive: Boolean): String? {
                var color: String
                if (isActive) {
                    color = props.color
                } else {
                    color = props.unColor
                }
                return if (isEmpty(color)) {
                    null
                } else {
                    color
                }
            }
            val getColor = ::gen_getColor_fn
            val tabWidth = ref(0)
            val tabLeft = ref(0)
            val lineLeft = ref(0)
            val sliderLeft = ref(0)
            val sliderWidth = ref(0)
            val scrollLeft = ref(0)
            val itemRects = ref(_uA<ItemRect>())
            val lineStyle = computed(fun(): UTSJSONObject {
                val style: UTSJSONObject = UTSJSONObject()
                style["transform"] = "translateX(" + lineLeft.value + "px)"
                val bgColor = getColor(true)
                if (bgColor != null) {
                    style["backgroundColor"] = bgColor
                }
                return style
            }
            )
            val sliderStyle = computed(fun(): UTSJSONObject {
                val style: UTSJSONObject = UTSJSONObject()
                style["transform"] = "translateX(" + sliderLeft.value + "px)"
                style["width"] = sliderWidth.value + "px"
                val bgColor = getColor(true)
                if (bgColor != null) {
                    style["backgroundColor"] = bgColor
                }
                return style
            }
            )
            fun gen_getTextStyle_fn(item: Item3): UTSJSONObject {
                val style: UTSJSONObject = UTSJSONObject()
                val color = getColor(item.isActive)
                if (color != null) {
                    style["color"] = color
                }
                return style
            }
            val getTextStyle = ::gen_getTextStyle_fn
            fun gen_updatePosition_fn() {
                nextTick(fun(){
                    if (!isEmpty(itemRects.value)) {
                        val item = itemRects.value[getIndex()]
                        if (!isNull(item)) {
                            var x = item.left - (tabWidth.value - item.width) / 2 - tabLeft.value
                            if (x < 0) {
                                x = 0
                            }
                            scrollLeft.value = x
                            lineLeft.value = item.left + item.width / 2 - rpx2px(16) - tabLeft.value
                            sliderLeft.value = item.left - tabLeft.value
                            sliderWidth.value = item.width
                        }
                    }
                }
                )
            }
            val updatePosition = ::gen_updatePosition_fn
            fun gen_getRects_fn() {
                uni_createSelectorQuery().`in`(proxy).selectAll(".cl-tabs__item").fields(NodeField(rect = true, size = true), fun(_result){}).exec(fun(nodes){
                    itemRects.value = (nodes[0] as UTSArray<NodeInfo>).map(fun(e): ItemRect {
                        return ItemRect(left = e.left ?: 0, width = e.width ?: 0)
                    }
                    )
                    updatePosition()
                }
                )
            }
            val getRects = ::gen_getRects_fn
            fun gen_refresh_fn() {
                setTimeout(fun(){
                    uni_createSelectorQuery().`in`(proxy).select(".cl-tabs").boundingClientRect(fun(node){
                        tabLeft.value = (node as NodeInfo).left ?: 0
                        tabWidth.value = (node as NodeInfo).width ?: 0
                        getRects()
                    }
                    ).exec()
                }
                , if (isHarmony()) {
                    50
                } else {
                    0
                }
                )
            }
            val refresh = ::gen_refresh_fn
            watch(computed(fun(): Any {
                return props.modelValue!!
            }
            ), fun(kVal: Any){
                active.value = kVal
                updatePosition()
            }
            , WatchOptions(immediate = true))
            watch(computed(fun(): UTSArray<ClTabsItem> {
                return props.list
            }
            ), fun(){
                nextTick(fun(){
                    refresh()
                }
                )
            }
            )
            onMounted(fun(){
                refresh()
            }
            )
            return fun(): Any? {
                val _component_cl_text = resolveEasyComponent("cl-text", GenUniModulesCoolUiComponentsClTextClTextClass)
                return _cE("view", _uM("class" to _nC(_uA(
                    "cl-tabs",
                    _uA(
                        _uM<String, Any?>(),
                        _uM("cl-tabs--line" to _ctx.showLine, "cl-tabs--slider" to _ctx.showSlider, "cl-tabs--fill" to _ctx.fill, "cl-tabs--disabled" to _ctx.disabled, "is-dark" to unref(isDark)),
                        pt.value.className
                    )
                )), "style" to _nS(_uM("height" to unref(parseRpx)(_ctx.height!!)))), _uA(
                    _cE("scroll-view", _uM("class" to "cl-tabs__scrollbar", "scroll-with-animation" to true, "scroll-x" to true, "direction" to "horizontal", "scroll-left" to scrollLeft.value, "show-scrollbar" to false), _uA(
                        _cE("view", _uM("class" to "cl-tabs__inner"), _uA(
                            _cE(Fragment, null, RenderHelpers.renderList(list.value, fun(item, index, __index, _cached): Any {
                                return _cE("view", _uM("class" to _nC(_uA(
                                    "cl-tabs__item",
                                    _uA(
                                        _uM<String, Any?>(),
                                        pt.value.item?.className
                                    )
                                )), "key" to index, "style" to _nS(_uM("padding" to ("0 " + unref(parseRpx)(_ctx.gutter)))), "onClick" to fun(){
                                    change(index)
                                }
                                ), _uA(
                                    renderSlot(_ctx.`$slots`, "item", GenUniModulesCoolUiComponentsClTabsClTabsSlotDataItem(item = item, active = item.isActive), fun(): UTSArray<Any> {
                                        return _uA(
                                            _cV(_component_cl_text, _uM("pt" to object : UTSJSONObject() {
                                                var className = unref(parseClass)(_uA(
                                                    "cl-tabs__item-label",
                                                    object : UTSJSONObject() {
                                                        var `is-active` = item.isActive
                                                        var `is-disabled` = item.disabled
                                                        var `is-dark` = unref(isDark)
                                                        var `is-fill` = _ctx.fill
                                                    },
                                                    pt.value.text?.className
                                                ))
                                            }, "style" to _nS(getTextStyle(item))), _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                                                return _uA(
                                                    _tD(item.label)
                                                )
                                            }
                                            ), "_" to 2), 1032, _uA(
                                                "pt",
                                                "style"
                                            ))
                                        )
                                    }
                                    )
                                ), 14, _uA(
                                    "onClick"
                                ))
                            }
                            ), 128),
                            if (lineLeft.value > 0) {
                                _cE(Fragment, _uM("key" to 0), _uA(
                                    if (isTrue(_ctx.showLine)) {
                                        _cE("view", _uM("key" to 0, "class" to _nC(_uA(
                                            "cl-tabs__line",
                                            _uA(
                                                _uM<String, Any?>(),
                                                pt.value.line?.className
                                            )
                                        )), "style" to _nS(lineStyle.value)), null, 6)
                                    } else {
                                        _cC("v-if", true)
                                    },
                                    if (isTrue(_ctx.showSlider)) {
                                        _cE("view", _uM("key" to 1, "class" to _nC(_uA(
                                            "cl-tabs__slider",
                                            _uA(
                                                _uM<String, Any?>(),
                                                pt.value.slider?.className
                                            )
                                        )), "style" to _nS(sliderStyle.value)), null, 6)
                                    } else {
                                        _cC("v-if", true)
                                    }
                                ), 64)
                            } else {
                                _cC("v-if", true)
                            }
                        ))
                    ), 8, _uA(
                        "scroll-left"
                    ))
                ), 6)
            }
        }
        var name = "cl-tabs"
        val styles: Map<String, Map<String, Map<String, Any>>> by lazy {
            _nCS(_uA(
                styles0
            ))
        }
        val styles0: Map<String, Map<String, Map<String, Any>>>
            get() {
                return _uM("cl-tabs__scrollbar" to _pS(_uM("display" to "flex", "height" to "100%", "width" to "100%", "flexDirection" to "row")), "cl-tabs__inner" to _uM("" to _uM("position" to "relative", "display" to "flex", "flexDirection" to "row"), ".cl-tabs--fill " to _uM("width" to "100%")), "cl-tabs__item" to _uM("" to _uM("position" to "relative", "zIndex" to 10, "display" to "flex", "height" to "100%", "flexDirection" to "row", "alignItems" to "center", "justifyContent" to "center"), ".cl-tabs--fill " to _uM("flex" to 1)), "cl-tabs__item-label" to _uM("" to _uM("fontSize" to "28rpx", "lineHeight" to "42rpx", "color" to "rgba(63,63,70,1)"), ".is-dark" to _uM("color" to "rgba(255,255,255,1)"), ".is-active" to _uM("color" to "rgba(20,184,166,1)"), ".is-disabled" to _uM("color" to "rgba(161,161,170,1)"), ".cl-tabs--slider .is-active" to _uM("color" to "rgba(255,255,255,1)"), ".cl-tabs--fill " to _uM("textAlign" to "center")), "cl-tabs__line" to _pS(_uM("position" to "absolute", "borderTopLeftRadius" to "10.5rpx", "borderTopRightRadius" to "10.5rpx", "borderBottomRightRadius" to "10.5rpx", "borderBottomLeftRadius" to "10.5rpx", "backgroundColor" to "rgba(20,184,166,1)", "height" to "4rpx", "width" to 16, "bottom" to "2rpx", "left" to 0, "transitionProperty" to "transform", "transitionDuration" to "0.3s")), "cl-tabs__slider" to _pS(_uM("position" to "absolute", "height" to "100%", "width" to "100%", "borderTopLeftRadius" to "14rpx", "borderTopRightRadius" to "14rpx", "borderBottomRightRadius" to "14rpx", "borderBottomLeftRadius" to "14rpx", "backgroundColor" to "rgba(20,184,166,1)", "top" to 0, "left" to 0, "transitionProperty" to "transform", "transitionDuration" to "0.3s")), "cl-tabs--slider" to _uM("" to _uM("borderTopLeftRadius" to "14rpx", "borderTopRightRadius" to "14rpx", "borderBottomRightRadius" to "14rpx", "borderBottomLeftRadius" to "14rpx", "backgroundColor" to "rgba(250,250,250,1)"), ".is-dark" to _uM("backgroundColor" to "rgba(63,63,70,1)")), "cl-tabs--disabled" to _pS(_uM("opacity" to 0.5)), "@TRANSITION" to _uM("cl-tabs__line" to _uM("property" to "transform", "duration" to "0.3s"), "cl-tabs__slider" to _uM("property" to "transform", "duration" to "0.3s")))
            }
        var inheritAttrs = true
        var inject: Map<String, Map<String, Any?>> = _uM()
        var emits: Map<String, Any?> = _uM("update:modelValue" to null, "change" to null)
        var props = _nP(_uM("pt" to _uM("default" to fun(): UTSJSONObject {
            return (UTSJSONObject())
        }
        ), "modelValue" to _uM("default" to ""), "height" to _uM("default" to 80), "list" to _uM("type" to "Array", "default" to fun(): UTSArray<Any?> {
            return _uA()
        }
        ), "fill" to _uM("type" to "Boolean", "default" to false), "gutter" to _uM("type" to "Number", "default" to 30), "color" to _uM("type" to "String", "default" to ""), "unColor" to _uM("type" to "String", "default" to ""), "showLine" to _uM("type" to "Boolean", "default" to true), "showSlider" to _uM("type" to "Boolean", "default" to false), "disabled" to _uM("type" to "Boolean", "default" to false)))
        var propsNeedCastKeys = _uA(
            "pt",
            "modelValue",
            "height",
            "list",
            "fill",
            "gutter",
            "color",
            "unColor",
            "showLine",
            "showSlider",
            "disabled"
        )
        var components: Map<String, CreateVueComponent> = _uM()
    }
}
