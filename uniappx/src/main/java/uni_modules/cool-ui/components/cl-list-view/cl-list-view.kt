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
open class GenUniModulesCoolUiComponentsClListViewClListView : VueComponent {
    constructor(__ins: ComponentInternalInstance) : super(__ins) {}
    open var pt: Any by `$props`
    open var data: UTSArray<ClListViewItem> by `$props`
    open var itemHeight: Number by `$props`
    open var headerHeight: Number by `$props`
    open var topHeight: Number by `$props`
    open var bottomHeight: Number by `$props`
    open var bufferSize: Number by `$props`
    open var virtual: Boolean by `$props`
    open var scrollIntoView: String by `$props`
    open var scrollWithAnimation: Boolean by `$props`
    open var showScrollbar: Boolean by `$props`
    open var refresherEnabled: Boolean by `$props`
    open var refresherThreshold: Number by `$props`
    open var refresherBackground: String by `$props`
    open var refresherDefaultText: String by `$props`
    open var refresherPullingText: String by `$props`
    open var refresherRefreshingText: String by `$props`
    open var showBackTop: Boolean by `$props`
    open var stopRefresh: () -> Unit
        get() {
            return unref(this.`$exposed`["stopRefresh"]) as () -> Unit
        }
        set(value) {
            setRefValue(this.`$exposed`, "stopRefresh", value)
        }
    companion object {
        @Suppress("UNUSED_PARAMETER", "UNUSED_VARIABLE")
        var setup: (__props: GenUniModulesCoolUiComponentsClListViewClListView, _arg1: SetupContext) -> Any? = fun(__props, ref1): Any? {
            var __expose = ref1.expose
            val __ins = getCurrentInstance()!!
            val _ctx = __ins.proxy as GenUniModulesCoolUiComponentsClListViewClListView
            val _cache = __ins.renderCache
            val props = __props
            fun emit(event: String, vararg do_not_transform_spread: Any?) {
                __ins.emit(event, *do_not_transform_spread)
            }
            val proxy = getCurrentInstance()!!.proxy
            val pt = computed(fun(): PassThrough25 {
                return parsePt<PassThrough25>(props.pt)
            }
            )
            val activeIndex = ref(0)
            val noData = computed(fun(): Boolean {
                return isEmpty(props.data)
            }
            )
            val hasIndex = computed(fun(): Boolean {
                return props.data.every(fun(e): Boolean {
                    return e.index != null
                }
                ) && !noData.value
            }
            )
            val data = computed<UTSArray<ClListViewGroup>>(fun(): UTSArray<ClListViewGroup> {
                val group: UTSArray<ClListViewGroup> = _uA()
                props.data.forEach(fun(item){
                    val index = group.findIndex(fun(group): Boolean {
                        return group.index == item.index
                    }
                    )
                    if (index != -1) {
                        group[index].children.push(item)
                    } else {
                        group.push(ClListViewGroup(index = item.index ?: "", children = _uA(
                            item
                        )))
                    }
                }
                )
                return group
            }
            )
            val indexList = computed<UTSArray<String>>(fun(): UTSArray<String> {
                return data.value.map(fun(item): String {
                    return item.index
                }
                )
            }
            )
            val virtualItems = computed<UTSArray<ClListViewVirtualItem>>(fun(): UTSArray<ClListViewVirtualItem> {
                val items: UTSArray<ClListViewVirtualItem> = _uA()
                var top = props.topHeight
                var index: Number = 0
                data.value.forEach(fun(group, groupIndex){
                    if (group.index != "") {
                        items.push(ClListViewVirtualItem(key = "header-" + groupIndex, type = "header", index = index++, top = top, height = props.headerHeight, data = ClListViewItem(label = group.index!!, index = group.index)))
                        top += props.headerHeight
                    }
                    group.children.forEach(fun(item, itemIndex){
                        items.push(ClListViewVirtualItem(key = "item-" + groupIndex + "-" + itemIndex, type = "item", index = index++, top = top, height = props.itemHeight, data = item))
                        top += props.itemHeight
                    }
                    )
                }
                )
                return items
            }
            )
            val listHeight = computed<Number>(fun(): Number {
                return (virtualItems.value.reduce(fun(total, item): Number {
                    return total + item.height
                }
                , 0) + props.topHeight + props.bottomHeight)
            }
            )
            val scrollTop = ref(0)
            val targetScrollTop = ref(0)
            val scrollerHeight = ref(0)
            val visibleItems = computed<UTSArray<ClListViewVirtualItem>>(fun(): UTSArray<ClListViewVirtualItem> {
                if (isEmpty(virtualItems.value)) {
                    return _uA()
                }
                if (!props.virtual) {
                    return virtualItems.value
                }
                val bufferHeight = props.bufferSize * props.itemHeight
                val viewportTop = scrollTop.value - bufferHeight
                val viewportBottom = scrollTop.value + scrollerHeight.value + bufferHeight
                val visible: UTSArray<ClListViewVirtualItem> = _uA()
                var startIndex: Number = 0
                var endIndex = virtualItems.value.length - 1
                while(startIndex < endIndex){
                    val mid = Math.floor((startIndex + endIndex) / 2)
                    val item = virtualItems.value[mid]
                    if (item.top + item.height <= viewportTop) {
                        startIndex = mid + 1
                    } else {
                        endIndex = mid
                    }
                }
                run {
                    var i = startIndex
                    while(i < virtualItems.value.length){
                        val item = virtualItems.value[i]
                        if (item.top >= viewportBottom) {
                            break
                        }
                        if (item.top + item.height > viewportTop) {
                            visible.push(item)
                        }
                        i++
                    }
                }
                return visible
            }
            )
            val spacerTopHeight = computed<Number>(fun(): Number {
                if (isEmpty(visibleItems.value)) {
                    return 0
                }
                return visibleItems.value[0].top
            }
            )
            val spacerBottomHeight = computed<Number>(fun(): Number {
                if (isEmpty(visibleItems.value)) {
                    return 0
                }
                val lastItem = visibleItems.value[visibleItems.value.length - 1]
                return listHeight.value - (lastItem.top + lastItem.height)
            }
            )
            val listStyle = computed(fun(): UTSJSONObject {
                return object : UTSJSONObject() {
                    var height = if (props.virtual) {
                        "" + listHeight.value + "px"
                    } else {
                        "auto"
                    }
                }
            }
            )
            val spacerTopStyle = computed(fun(): UTSJSONObject {
                return object : UTSJSONObject() {
                    var height = if (props.virtual) {
                        "" + spacerTopHeight.value + "px"
                    } else {
                        "auto"
                    }
                }
            }
            )
            val spacerBottomStyle = computed(fun(): UTSJSONObject {
                return object : UTSJSONObject() {
                    var height = if (props.virtual) {
                        "" + spacerBottomHeight.value + "px"
                    } else {
                        "auto"
                    }
                }
            }
            )
            val tops = ref(_uA<Number>())
            fun gen_getTops_fn() {
                val arr = _uA<Number>()
                var top: Number = 0
                data.value.forEach(fun(group){
                    arr.push(top)
                    top += props.headerHeight + group.children.length * props.itemHeight
                }
                )
                tops.value = arr
            }
            val getTops = ::gen_getTops_fn
            val refreshTriggered = ref(false)
            val refresherStatus = ref<String>("default")
            val refresherText = computed(fun(): String {
                when (refresherStatus.value) {
                    "pulling" -> 
                        return props.refresherPullingText
                    "refreshing" -> 
                        return props.refresherRefreshingText
                    else -> 
                        return props.refresherDefaultText
                }
            }
            )
            fun gen_stopRefresh_fn() {
                refreshTriggered.value = false
                refresherStatus.value = "default"
            }
            val stopRefresh = ::gen_stopRefresh_fn
            fun gen_onScrollToUpper_fn(e: UniScrollToUpperEvent) {
                emit("scrolltoupper", e)
                emit("top")
            }
            val onScrollToUpper = ::gen_onScrollToUpper_fn
            fun gen_onScrollToLower_fn(e: UniScrollToLowerEvent) {
                emit("scrolltolower", e)
                emit("bottom")
            }
            val onScrollToLower = ::gen_onScrollToLower_fn
            var scrollLock = false
            fun gen_onScroll_fn(e: UniScrollEvent) {
                scrollTop.value = Math.floor(e.detail.scrollTop)
                if (scrollLock) {
                    return
                }
                tops.value.forEach(fun(top, index){
                    if (scrollTop.value >= top) {
                        activeIndex.value = index
                    }
                }
                )
                emit("scroll", e)
            }
            val onScroll = ::gen_onScroll_fn
            fun gen_onScrollEnd_fn(e: UniScrollEvent) {
                emit("scrollend", e)
            }
            val onScrollEnd = ::gen_onScrollEnd_fn
            fun gen_onItemTap_fn(item: ClListViewVirtualItem) {
                emit("item-tap", item.data)
            }
            val onItemTap = ::gen_onItemTap_fn
            fun gen_onIndexChange_fn(index: Number) {
                scrollLock = true
                targetScrollTop.value = tops.value[index]
                setTimeout(fun(){
                    scrollLock = false
                }
                , 300)
            }
            val onIndexChange = ::gen_onIndexChange_fn
            fun gen_onRefresherPulling_fn(e: UniRefresherEvent) {
                if (e.detail.dy > props.refresherThreshold) {
                    refresherStatus.value = "pulling"
                }
                emit("refresher-pulling", e)
            }
            val onRefresherPulling = ::gen_onRefresherPulling_fn
            fun gen_onRefresherRefresh_fn(e: UniRefresherEvent) {
                refresherStatus.value = "refreshing"
                refreshTriggered.value = true
                emit("refresher-refresh", e)
                emit("pull", e)
            }
            val onRefresherRefresh = ::gen_onRefresherRefresh_fn
            fun gen_onRefresherRestore_fn(e: UniRefresherEvent) {
                refresherStatus.value = "default"
                emit("refresher-restore", e)
            }
            val onRefresherRestore = ::gen_onRefresherRestore_fn
            fun gen_onRefresherAbort_fn(e: UniRefresherEvent) {
                refresherStatus.value = "default"
                emit("refresher-abort", e)
            }
            val onRefresherAbort = ::gen_onRefresherAbort_fn
            fun gen_scrollToTop_fn() {
                targetScrollTop.value = 0.01
                nextTick(fun(){
                    targetScrollTop.value = 0
                }
                )
            }
            val scrollToTop = ::gen_scrollToTop_fn
            fun gen_getScrollerHeight_fn() {
                setTimeout(fun(){
                    uni_createSelectorQuery().`in`(proxy).select(".cl-list-view__scroller").boundingClientRect().exec(fun(res){
                        if (isEmpty(res)) {
                            return
                        }
                        scrollerHeight.value = (res[0] as NodeInfo).height ?: 0
                    }
                    )
                }
                , 100)
            }
            val getScrollerHeight = ::gen_getScrollerHeight_fn
            onMounted(fun(){
                getScrollerHeight()
                watch(computed(fun(): UTSArray<ClListViewItem> {
                    return props.data
                }
                ), fun(){
                    getTops()
                }
                , WatchOptions(immediate = true))
            }
            )
            __expose(_uM("data" to data, "stopRefresh" to stopRefresh))
            return fun(): Any? {
                val _component_cl_loading = resolveEasyComponent("cl-loading", GenUniModulesCoolUiComponentsClLoadingClLoadingClass)
                val _component_cl_text = resolveEasyComponent("cl-text", GenUniModulesCoolUiComponentsClTextClTextClass)
                val _component_cl_empty = resolveEasyComponent("cl-empty", GenUniModulesCoolUiComponentsClEmptyClEmptyClass)
                val _component_cl_index_bar = resolveEasyComponent("cl-index-bar", GenUniModulesCoolUiComponentsClIndexBarClIndexBarClass)
                val _component_cl_back_top = resolveEasyComponent("cl-back-top", GenUniModulesCoolUiComponentsClBackTopClBackTopClass)
                return _cE("view", _uM("class" to _nC(_uA(
                    "cl-list-view",
                    _uA(
                        _uM<String, Any?>(),
                        pt.value.className
                    )
                ))), _uA(
                    _cE("scroll-view", _uM("class" to _nC(_uA(
                        "cl-list-view__scroller",
                        _uA(
                            _uM<String, Any?>(),
                            pt.value.scroller?.className
                        )
                    )), "scroll-top" to targetScrollTop.value, "scroll-into-view" to _ctx.scrollIntoView, "scroll-with-animation" to _ctx.scrollWithAnimation, "show-scrollbar" to _ctx.showScrollbar, "refresher-triggered" to refreshTriggered.value, "refresher-enabled" to _ctx.refresherEnabled, "refresher-threshold" to _ctx.refresherThreshold, "refresher-background" to _ctx.refresherBackground, "refresher-default-style" to "none", "direction" to "vertical", "onScrolltoupper" to onScrollToUpper, "onScrolltolower" to onScrollToLower, "onScroll" to onScroll, "onScrollend" to onScrollEnd, "onRefresherpulling" to onRefresherPulling, "onRefresherrefresh" to onRefresherRefresh, "onRefresherrestore" to onRefresherRestore, "onRefresherabort" to onRefresherAbort), _uA(
                        _cE("view", _uM("slot" to "refresher", "class" to _nC(_uA(
                            "cl-list-view__refresher",
                            _uA(
                                _uM<String, Any?>(),
                                _uM("is-pulling" to (refresherStatus.value === "pulling"), "is-refreshing" to (refresherStatus.value === "refreshing")),
                                pt.value.refresher?.className
                            )
                        )), "style" to _nS(_uM("height" to (_ctx.refresherThreshold + "px")))), _uA(
                            renderSlot(_ctx.`$slots`, "refresher", GenUniModulesCoolUiComponentsClListViewClListViewSlotDataRefresher(status = refresherStatus.value, text = refresherText.value), fun(): UTSArray<Any> {
                                return _uA(
                                    if (refresherStatus.value === "refreshing") {
                                        _cV(_component_cl_loading, _uM("key" to 0, "size" to 28, "pt" to object : UTSJSONObject() {
                                            var className = "mr-2"
                                        }))
                                    } else {
                                        _cC("v-if", true)
                                    }
                                    ,
                                    _cV(_component_cl_text, null, _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                                        return _uA(
                                            _tD(refresherText.value)
                                        )
                                    }
                                    ), "_" to 1))
                                )
                            }
                            )
                        ), 6),
                        _cE("view", _uM("class" to _nC(_uA(
                            "cl-list-view__virtual-list",
                            _uA(
                                _uM<String, Any?>(),
                                pt.value.list?.className
                            )
                        )), "style" to _nS(listStyle.value)), _uA(
                            _cE("view", _uM("class" to "cl-list-view__spacer-top", "style" to _nS(spacerTopStyle.value)), _uA(
                                renderSlot(_ctx.`$slots`, "top")
                            ), 4),
                            _cE(Fragment, null, RenderHelpers.renderList(visibleItems.value, fun(item, index, __index, _cached): Any {
                                return _cE("view", _uM("key" to item.key, "class" to "cl-list-view__virtual-item"), _uA(
                                    if (item.type == "header") {
                                        _cE("view", _uM("key" to 0, "class" to _nC(_uA(
                                            "cl-list-view__header",
                                            _uA(
                                                _uM<String, Any?>(),
                                                _uM("is-dark" to unref(isDark))
                                            )
                                        )), "style" to _nS(_uM("height" to (_ctx.headerHeight + "px")))), _uA(
                                            renderSlot(_ctx.`$slots`, "header", GenUniModulesCoolUiComponentsClListViewClListViewSlotDataHeader(index = item.data.index!!), fun(): UTSArray<Any> {
                                                return _uA(
                                                    _cV(_component_cl_text, null, _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                                                        return _uA(
                                                            _tD(item.data.label)
                                                        )
                                                    }), "_" to 2), 1024)
                                                )
                                            })
                                        ), 6)
                                    } else {
                                        _cE("view", _uM("key" to 1, "class" to _nC(_uA(
                                            "cl-list-view__item",
                                            _uA(
                                                _uM<String, Any?>(),
                                                _uM("is-dark" to unref(isDark)),
                                                pt.value.item?.className
                                            )
                                        )), "hover-class" to pt.value.itemHover?.className, "style" to _nS(_uM("height" to if (_ctx.virtual) {
                                            _ctx.itemHeight + "px"
                                        } else {
                                            "auto"
                                        }
                                        )), "onClick" to fun(){
                                            onItemTap(item)
                                        }
                                        ), _uA(
                                            renderSlot(_ctx.`$slots`, "item", GenUniModulesCoolUiComponentsClListViewClListViewSlotDataItem(item = item, data = item.data, value = item.data.value, index = index), fun(): UTSArray<Any> {
                                                return _uA(
                                                    _cE("view", _uM("class" to "cl-list-view__item-inner"), _uA(
                                                        _cV(_component_cl_text, null, _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                                                            return _uA(
                                                                _tD(item.data.label)
                                                            )
                                                        }
                                                        ), "_" to 2), 1024)
                                                    ))
                                                )
                                            }
                                            )
                                        ), 14, _uA(
                                            "hover-class",
                                            "onClick"
                                        ))
                                    }
                                ))
                            }
                            ), 128),
                            _cE("view", _uM("class" to "cl-list-view__spacer-bottom", "style" to _nS(spacerBottomStyle.value)), _uA(
                                renderSlot(_ctx.`$slots`, "bottom")
                            ), 4)
                        ), 6),
                        if (isTrue(noData.value)) {
                            _cV(_component_cl_empty, _uM("key" to 0, "fixed" to false))
                        } else {
                            _cC("v-if", true)
                        }
                    ), 42, _uA(
                        "scroll-top",
                        "scroll-into-view",
                        "scroll-with-animation",
                        "show-scrollbar",
                        "refresher-triggered",
                        "refresher-enabled",
                        "refresher-threshold",
                        "refresher-background"
                    )),
                    if (isTrue(hasIndex.value)) {
                        _cV(_component_cl_index_bar, _uM("key" to 0, "modelValue" to activeIndex.value, "onUpdate:modelValue" to fun(`$event`: Number){
                            activeIndex.value = `$event`
                        }, "list" to indexList.value, "pt" to object : UTSJSONObject() {
                            var className = unref(parseClass)(_uA(
                                pt.value.indexBar?.className
                            ))
                        }, "onChange" to onIndexChange), null, 8, _uA(
                            "modelValue",
                            "onUpdate:modelValue",
                            "list",
                            "pt"
                        ))
                    } else {
                        _cC("v-if", true)
                    }
                    ,
                    if (isTrue(hasIndex.value)) {
                        _cE("view", _uM("key" to 1, "class" to _nC(_uA(
                            "cl-list-view__index",
                            _uA(
                                _uM<String, Any?>(),
                                _uM("is-dark" to unref(isDark))
                            )
                        )), "style" to _nS(_uM("height" to (_ctx.headerHeight + "px")))), _uA(
                            renderSlot(_ctx.`$slots`, "index", GenUniModulesCoolUiComponentsClListViewClListViewSlotDataIndex(index = indexList.value[activeIndex.value]), fun(): UTSArray<Any> {
                                return _uA(
                                    _cV(_component_cl_text, null, _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                                        return _uA(
                                            _tD(indexList.value[activeIndex.value])
                                        )
                                    }), "_" to 1))
                                )
                            })
                        ), 6)
                    } else {
                        _cC("v-if", true)
                    }
                    ,
                    if (isTrue(_ctx.showBackTop)) {
                        _cV(_component_cl_back_top, _uM("key" to 2, "top" to scrollTop.value, "onBackTop" to scrollToTop), null, 8, _uA(
                            "top"
                        ))
                    } else {
                        _cC("v-if", true)
                    }
                ), 2)
            }
        }
        var name = "cl-list-view"
        val styles: Map<String, Map<String, Map<String, Any>>> by lazy {
            _nCS(_uA(
                styles0
            ))
        }
        val styles0: Map<String, Map<String, Map<String, Any>>>
            get() {
                return _uM("cl-list-view" to _pS(_uM("position" to "relative", "height" to "100%", "width" to "100%")), "cl-list-view__scroller" to _pS(_uM("height" to "100%", "width" to "100%")), "cl-list-view__virtual-list" to _pS(_uM("position" to "relative", "width" to "100%")), "cl-list-view__spacer-top" to _pS(_uM("width" to "100%")), "cl-list-view__spacer-bottom" to _pS(_uM("width" to "100%")), "cl-list-view__index" to _uM("" to _uM("display" to "flex", "flexDirection" to "row", "alignItems" to "center", "backgroundColor" to "rgba(255,255,255,1)", "position" to "absolute", "top" to 0, "left" to 0, "zIndex" to 20, "width" to "100%", "paddingLeft" to "20rpx", "paddingRight" to "20rpx"), ".is-dark" to _uM("borderTopStyle" to "none", "borderRightStyle" to "none", "borderBottomStyle" to "none", "borderLeftStyle" to "none", "backgroundColor" to "rgba(82,82,91,1)")), "cl-list-view__virtual-item" to _pS(_uM("width" to "100%")), "cl-list-view__header" to _pS(_uM("position" to "relative", "zIndex" to 10, "display" to "flex", "flexDirection" to "row", "alignItems" to "center", "paddingLeft" to "20rpx", "paddingRight" to "20rpx")), "cl-list-view__item-inner" to _pS(_uM("display" to "flex", "height" to "100%", "flexDirection" to "row", "alignItems" to "center", "paddingLeft" to "20rpx", "paddingRight" to "20rpx")), "cl-list-view__refresher" to _pS(_uM("display" to "flex", "height" to "100%", "width" to "100%", "flexDirection" to "row", "alignItems" to "center", "justifyContent" to "center")))
            }
        var inheritAttrs = true
        var inject: Map<String, Map<String, Any?>> = _uM()
        var emits: Map<String, Any?> = _uM("item-tap" to null, "refresher-pulling" to null, "refresher-refresh" to null, "refresher-restore" to null, "refresher-abort" to null, "scrolltoupper" to null, "scrolltolower" to null, "scroll" to null, "scrollend" to null, "pull" to null, "top" to null, "bottom" to null)
        var props = _nP(_uM("pt" to _uM("default" to fun(): UTSJSONObject {
            return (UTSJSONObject())
        }
        ), "data" to _uM("type" to "Array", "default" to fun(): UTSArray<Any?> {
            return _uA()
        }
        ), "itemHeight" to _uM("type" to "Number", "default" to 50), "headerHeight" to _uM("type" to "Number", "default" to 32), "topHeight" to _uM("type" to "Number", "default" to 0), "bottomHeight" to _uM("type" to "Number", "default" to 0), "bufferSize" to _uM("type" to "Number", "default" to if (isApp()) {
            5
        } else {
            15
        }
        ), "virtual" to _uM("type" to "Boolean", "default" to true), "scrollIntoView" to _uM("type" to "String", "default" to ""), "scrollWithAnimation" to _uM("type" to "Boolean", "default" to false), "showScrollbar" to _uM("type" to "Boolean", "default" to false), "refresherEnabled" to _uM("type" to "Boolean", "default" to false), "refresherThreshold" to _uM("type" to "Number", "default" to 50), "refresherBackground" to _uM("type" to "String", "default" to "transparent"), "refresherDefaultText" to _uM("type" to "String", "default" to fun(): String {
            return t("下拉刷新")
        }
        ), "refresherPullingText" to _uM("type" to "String", "default" to fun(): String {
            return t("释放立即刷新")
        }
        ), "refresherRefreshingText" to _uM("type" to "String", "default" to fun(): String {
            return t("加载中")
        }
        ), "showBackTop" to _uM("type" to "Boolean", "default" to true)))
        var propsNeedCastKeys = _uA(
            "pt",
            "data",
            "itemHeight",
            "headerHeight",
            "topHeight",
            "bottomHeight",
            "bufferSize",
            "virtual",
            "scrollIntoView",
            "scrollWithAnimation",
            "showScrollbar",
            "refresherEnabled",
            "refresherThreshold",
            "refresherBackground",
            "refresherDefaultText",
            "refresherPullingText",
            "refresherRefreshingText",
            "showBackTop"
        )
        var components: Map<String, CreateVueComponent> = _uM()
    }
}
