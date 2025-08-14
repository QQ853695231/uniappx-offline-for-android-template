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
open class GenUniModulesCoolUiComponentsClPaginationClPagination : VueComponent {
    constructor(__ins: ComponentInternalInstance) : super(__ins) {}
    open var pt: Any by `$props`
    open var modelValue: Number by `$props`
    open var total: Number by `$props`
    open var size: Number by `$props`
    open var prev: () -> Unit
        get() {
            return unref(this.`$exposed`["prev"]) as () -> Unit
        }
        set(value) {
            setRefValue(this.`$exposed`, "prev", value)
        }
    open var next: () -> Unit
        get() {
            return unref(this.`$exposed`["next"]) as () -> Unit
        }
        set(value) {
            setRefValue(this.`$exposed`, "next", value)
        }
    companion object {
        @Suppress("UNUSED_PARAMETER", "UNUSED_VARIABLE")
        var setup: (__props: GenUniModulesCoolUiComponentsClPaginationClPagination, _arg1: SetupContext) -> Any? = fun(__props, ref1): Any? {
            var __expose = ref1.expose
            val __ins = getCurrentInstance()!!
            val _ctx = __ins.proxy as GenUniModulesCoolUiComponentsClPaginationClPagination
            val _cache = __ins.renderCache
            val props = __props
            fun emit(event: String, vararg do_not_transform_spread: Any?) {
                __ins.emit(event, *do_not_transform_spread)
            }
            val pt = computed(fun(): PassThrough46 {
                return parsePt<PassThrough46>(props.pt)
            }
            )
            val totalPage = computed(fun(): Number {
                return Math.ceil(props.total / props.size)
            }
            )
            val value = ref(props.modelValue)
            val list = computed(fun(): UTSArray<Any> {
                val total = totalPage.value
                val list: UTSArray<Any> = _uA()
                if (total <= 7) {
                    run {
                        var i: Number = 1
                        while(i <= total){
                            list.push(i)
                            i++
                        }
                    }
                } else {
                    list.push(1)
                    if (value.value <= 4) {
                        run {
                            var i: Number = 2
                            while(i <= 5){
                                list.push(i)
                                i++
                            }
                        }
                        list.push("...")
                        list.push(total)
                    } else if (value.value >= total - 3) {
                        list.push("...")
                        run {
                            var i = total - 4
                            while(i <= total){
                                list.push(i)
                                i++
                            }
                        }
                    } else {
                        list.push("...")
                        run {
                            var i = value.value - 1
                            while(i <= value.value + 1){
                                list.push(i)
                                i++
                            }
                        }
                        list.push("...")
                        list.push(total)
                    }
                }
                return list
            }
            )
            fun toPage(item: Any) {
                if (item == "..." || UTSAndroid.`typeof`(item) !== "number") {
                    return
                }
                if (UTSAndroid.`typeof`(item) == "number") {
                    if (item as Number > totalPage.value) {
                        return
                    }
                    if ((item as Number) < 1) {
                        return
                    }
                }
                value.value = item as Number
                emit("update:modelValue", item)
                emit("change", item)
            }
            fun gen_prev_fn() {
                toPage(value.value - 1)
            }
            val prev = ::gen_prev_fn
            fun gen_next_fn() {
                toPage(value.value + 1)
            }
            val next = ::gen_next_fn
            watch(computed(fun(): Number {
                return props.modelValue
            }
            ), fun(kVal: Number){
                value.value = kVal
            }
            , WatchOptions(immediate = true))
            __expose(_uM("prev" to prev, "next" to next))
            return fun(): Any? {
                val _component_cl_icon = resolveEasyComponent("cl-icon", GenUniModulesCoolUiComponentsClIconClIconClass)
                val _component_cl_text = resolveEasyComponent("cl-text", GenUniModulesCoolUiComponentsClTextClTextClass)
                return _cE("view", _uM("class" to "cl-pagination"), _uA(
                    _cE("view", _uM("class" to _nC(_uA(
                        "cl-pagination__prev",
                        _uA(
                            _uM<String, Any?>(),
                            _uM("is-disabled" to (value.value == 1), "is-dark" to unref(isDark)),
                            pt.value.item?.className,
                            pt.value.prev?.className
                        )
                    )), "onClick" to prev), _uA(
                        renderSlot(_ctx.`$slots`, "prev", _uM("disabled" to (value.value == 1)), fun(): UTSArray<Any> {
                            return _uA(
                                _cV(_component_cl_icon, _uM("name" to "arrow-left-s-line"))
                            )
                        }
                        )
                    ), 2),
                    _cE(Fragment, null, RenderHelpers.renderList(list.value, fun(item, index, __index, _cached): Any {
                        return _cE("view", _uM("key" to index, "class" to _nC(_uA(
                            "cl-pagination__item",
                            _uA(
                                _uM<String, Any?>(),
                                _uM("is-active" to (item == value.value), "is-dark" to unref(isDark)),
                                pt.value.item?.className
                            )
                        )), "onClick" to fun(){
                            toPage(item)
                        }
                        ), _uA(
                            _cV(_component_cl_text, _uM("pt" to object : UTSJSONObject() {
                                var className = unref(parseClass)(_uA(
                                    "cl-pagination__item-text",
                                    object : UTSJSONObject() {
                                        var `is-active` = item == value.value
                                        var `is-dark` = unref(isDark)
                                    }
                                ))
                            }), _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                                return _uA(
                                    _tD(item)
                                )
                            }
                            ), "_" to 2), 1032, _uA(
                                "pt"
                            ))
                        ), 10, _uA(
                            "onClick"
                        ))
                    }
                    ), 128),
                    _cE("view", _uM("class" to _nC(_uA(
                        "cl-pagination__next",
                        _uA(
                            _uM<String, Any?>(),
                            _uM("is-disabled" to (value.value == totalPage.value), "is-dark" to unref(isDark)),
                            pt.value.item?.className,
                            pt.value.next?.className
                        )
                    )), "onClick" to next), _uA(
                        renderSlot(_ctx.`$slots`, "next", _uM("disabled" to (value.value == totalPage.value)), fun(): UTSArray<Any> {
                            return _uA(
                                _cV(_component_cl_icon, _uM("name" to "arrow-right-s-line"))
                            )
                        }
                        )
                    ), 2)
                ))
            }
        }
        var name = "cl-pagination"
        val styles: Map<String, Map<String, Map<String, Any>>> by lazy {
            _nCS(_uA(
                styles0
            ))
        }
        val styles0: Map<String, Map<String, Map<String, Any>>>
            get() {
                return _uM("cl-pagination" to _pS(_uM("display" to "flex", "width" to "100%", "flexDirection" to "row", "justifyContent" to "center")), "cl-pagination__prev" to _uM("" to _uM("display" to "flex", "flexDirection" to "row", "alignItems" to "center", "justifyContent" to "center", "borderTopLeftRadius" to "14rpx", "borderTopRightRadius" to "14rpx", "borderBottomRightRadius" to "14rpx", "borderBottomLeftRadius" to "14rpx", "backgroundColor" to "rgba(244,244,245,1)", "height" to "60rpx", "width" to "60rpx", "marginRight" to "5rpx"), ".is-disabled" to _uM("opacity" to 0.5), ".is-dark" to _uM("backgroundColor" to "rgba(63,63,70,1)", "color" to "rgba(255,255,255,1)")), "cl-pagination__next" to _uM("" to _uM("display" to "flex", "flexDirection" to "row", "alignItems" to "center", "justifyContent" to "center", "borderTopLeftRadius" to "14rpx", "borderTopRightRadius" to "14rpx", "borderBottomRightRadius" to "14rpx", "borderBottomLeftRadius" to "14rpx", "backgroundColor" to "rgba(244,244,245,1)", "height" to "60rpx", "width" to "60rpx", "marginLeft" to "5rpx"), ".is-disabled" to _uM("opacity" to 0.5), ".is-dark" to _uM("backgroundColor" to "rgba(63,63,70,1)", "color" to "rgba(255,255,255,1)")), "cl-pagination__item" to _uM("" to _uM("display" to "flex", "flexDirection" to "row", "alignItems" to "center", "justifyContent" to "center", "borderTopLeftRadius" to "14rpx", "borderTopRightRadius" to "14rpx", "borderBottomRightRadius" to "14rpx", "borderBottomLeftRadius" to "14rpx", "backgroundColor" to "rgba(244,244,245,1)", "height" to "60rpx", "width" to "60rpx", "marginTop" to 0, "marginRight" to "5rpx", "marginBottom" to 0, "marginLeft" to "5rpx"), ".is-disabled" to _uM("opacity" to 0.5), ".is-dark" to _uM("backgroundColor" to "rgba(63,63,70,1)", "color" to "rgba(255,255,255,1)"), ".is-active" to _uM("backgroundColor" to "rgba(20,184,166,1)")), "cl-pagination__item-text" to _uM("" to _uM("fontSize" to "28rpx", "lineHeight" to "42rpx", "color" to "rgba(63,63,70,1)"), ".is-dark" to _uM("color" to "rgba(255,255,255,1)"), ".is-active" to _uM("color" to "rgba(255,255,255,1)")))
            }
        var inheritAttrs = true
        var inject: Map<String, Map<String, Any?>> = _uM()
        var emits: Map<String, Any?> = _uM("update:modelValue" to null, "change" to null)
        var props = _nP(_uM("pt" to _uM("default" to fun(): UTSJSONObject {
            return (UTSJSONObject())
        }
        ), "modelValue" to _uM("type" to "Number", "default" to 1), "total" to _uM("type" to "Number", "default" to 0), "size" to _uM("type" to "Number", "default" to 10)))
        var propsNeedCastKeys = _uA(
            "pt",
            "modelValue",
            "total",
            "size"
        )
        var components: Map<String, CreateVueComponent> = _uM()
    }
}
