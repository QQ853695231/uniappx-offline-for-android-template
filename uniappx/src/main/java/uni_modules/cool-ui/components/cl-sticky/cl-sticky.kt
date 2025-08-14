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
open class GenUniModulesCoolUiComponentsClStickyClSticky : VueComponent {
    constructor(__ins: ComponentInternalInstance) : super(__ins) {}
    open var offsetTop: Number by `$props`
    open var zIndex: Number by `$props`
    open var scrollTop: Number by `$props`
    open var getRect: () -> Unit
        get() {
            return unref(this.`$exposed`["getRect"]) as () -> Unit
        }
        set(value) {
            setRefValue(this.`$exposed`, "getRect", value)
        }
    companion object {
        @Suppress("UNUSED_PARAMETER", "UNUSED_VARIABLE")
        var setup: (__props: GenUniModulesCoolUiComponentsClStickyClSticky, _arg1: SetupContext) -> Any? = fun(__props, ref1): Any? {
            var __expose = ref1.expose
            val __ins = getCurrentInstance()!!
            val _ctx = __ins.proxy as GenUniModulesCoolUiComponentsClStickyClSticky
            val _cache = __ins.renderCache
            val props = __props
            val proxy = getCurrentInstance()!!.proxy
            val onScroll = usePage().onScroll
            val rect = reactive<Rect1>(Rect1(height = 0, width = 0, left = 0, top = 0))
            val scrollTop = ref(0)
            val isSticky = computed(fun(): Boolean {
                if (rect.height == 0) {
                    return false
                }
                return scrollTop.value >= rect.top
            }
            )
            val stickyTop = computed(fun(): Number {
                if (isSticky.value) {
                    var v: Number = 0
                    return v + props.offsetTop
                } else {
                    return 0
                }
            }
            )
            fun gen_getRect_fn() {
                nextTick(fun(){
                    uni_createSelectorQuery().`in`(proxy).select(".cl-sticky").boundingClientRect().exec(fun(nodes){
                        if (isEmpty(nodes)) {
                            return
                        }
                        val node = nodes[0] as NodeInfo
                        rect.height = node.height ?: 0
                        rect.width = node.width ?: 0
                        rect.left = node.left ?: 0
                        rect.top = (node.top ?: 0) - props.offsetTop + scrollTop.value
                    }
                    )
                }
                )
            }
            val getRect = ::gen_getRect_fn
            onMounted(fun(){
                getRect()
                onScroll(fun(top){
                    scrollTop.value = top
                }
                )
                watch(computed(fun(): Number {
                    return props.scrollTop
                }
                ), fun(top: Number){
                    scrollTop.value = top
                }
                , WatchOptions(immediate = true))
            }
            )
            __expose(_uM("getRect" to getRect))
            return fun(): Any? {
                return _cE("view", _uM("class" to "cl-sticky-wrapper", "style" to _nS(_uM("height" to if (rect.height == 0) {
                    "auto"
                } else {
                    rect.height + "px"
                }
                , "zIndex" to _ctx.zIndex))), _uA(
                    _cE("view", _uM("class" to _nC(_uA(
                        "cl-sticky",
                        _uA(
                            _uM<String, Any?>(),
                            _uM("is-active" to isSticky.value)
                        )
                    )), "style" to _nS(_uM("width" to if (isSticky.value) {
                        rect.width + "px"
                    } else {
                        "100%"
                    }
                    , "left" to if (isSticky.value) {
                        rect.left + "px"
                    } else {
                        0
                    }
                    , "top" to (stickyTop.value + "px")))), _uA(
                        renderSlot(_ctx.`$slots`, "default"),
                        renderSlot(_ctx.`$slots`, "content", GenUniModulesCoolUiComponentsClStickyClStickySlotDataContent(isSticky = isSticky.value))
                    ), 6)
                ), 4)
            }
        }
        var name = "cl-sticky"
        val styles: Map<String, Map<String, Map<String, Any>>> by lazy {
            _nCS(_uA(
                styles0
            ))
        }
        val styles0: Map<String, Map<String, Map<String, Any>>>
            get() {
                return _uM("cl-sticky" to _uM("" to _uM("position" to "relative"), ".is-active" to _uM("position" to "fixed")))
            }
        var inheritAttrs = true
        var inject: Map<String, Map<String, Any?>> = _uM()
        var emits: Map<String, Any?> = _uM()
        var props = _nP(_uM("offsetTop" to _uM("type" to "Number", "default" to 0), "zIndex" to _uM("type" to "Number", "default" to 100), "scrollTop" to _uM("type" to "Number", "default" to 0)))
        var propsNeedCastKeys = _uA(
            "offsetTop",
            "zIndex",
            "scrollTop"
        )
        var components: Map<String, CreateVueComponent> = _uM()
    }
}
