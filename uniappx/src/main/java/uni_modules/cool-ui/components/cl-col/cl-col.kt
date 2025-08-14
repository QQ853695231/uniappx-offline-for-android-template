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
open class GenUniModulesCoolUiComponentsClColClCol : VueComponent {
    constructor(__ins: ComponentInternalInstance) : super(__ins) {}
    open var pt: Any by `$props`
    open var span: Number by `$props`
    open var offset: Number by `$props`
    open var push: Number by `$props`
    open var pull: Number by `$props`
    companion object {
        @Suppress("UNUSED_PARAMETER", "UNUSED_VARIABLE")
        var setup: (__props: GenUniModulesCoolUiComponentsClColClCol) -> Any? = fun(__props): Any? {
            val __ins = getCurrentInstance()!!
            val _ctx = __ins.proxy as GenUniModulesCoolUiComponentsClColClCol
            val _cache = __ins.renderCache
            val props = __props
            val parent = useParent<ClRowComponentPublicInstance>("cl-row")
            val pt = computed(fun(): PassThrough10 {
                return parsePt<PassThrough10>(props.pt)
            }
            )
            val padding = computed(fun(): String {
                return if (parent == null) {
                    "0"
                } else {
                    parseRpx(parent.gutter / 2)
                }
            }
            )
            return fun(): Any? {
                return _cE("view", _uM("class" to _nC(_uA(
                    "cl-col",
                    _uA(
                        _uM<String, Any?>(),
                        "cl-col-" + _ctx.span,
                        "cl-col-offset-" + _ctx.offset,
                        "cl-col-push-" + _ctx.push,
                        "cl-col-pull-" + _ctx.pull,
                        pt.value.className
                    )
                )), "style" to _nS(_uM("paddingLeft" to padding.value, "paddingRight" to padding.value))), _uA(
                    renderSlot(_ctx.`$slots`, "default")
                ), 6)
            }
        }
        var name = "cl-col"
        val styles: Map<String, Map<String, Map<String, Any>>> by lazy {
            _nCS(_uA(
                styles0
            ))
        }
        val styles0: Map<String, Map<String, Map<String, Any>>>
            get() {
                return _uM("cl-col" to _pS(_uM("width" to "100%", "overflow" to "visible")), "cl-col-push-1" to _pS(_uM("position" to "relative", "left" to "4.1666666667%")), "cl-col-pull-1" to _pS(_uM("position" to "relative", "right" to "4.1666666667%")), "cl-col-push-2" to _pS(_uM("position" to "relative", "left" to "8.3333333333%")), "cl-col-pull-2" to _pS(_uM("position" to "relative", "right" to "8.3333333333%")), "cl-col-push-3" to _pS(_uM("position" to "relative", "left" to "12.5%")), "cl-col-pull-3" to _pS(_uM("position" to "relative", "right" to "12.5%")), "cl-col-push-4" to _pS(_uM("position" to "relative", "left" to "16.6666666667%")), "cl-col-pull-4" to _pS(_uM("position" to "relative", "right" to "16.6666666667%")), "cl-col-push-5" to _pS(_uM("position" to "relative", "left" to "20.8333333333%")), "cl-col-pull-5" to _pS(_uM("position" to "relative", "right" to "20.8333333333%")), "cl-col-push-6" to _pS(_uM("position" to "relative", "left" to "25%")), "cl-col-pull-6" to _pS(_uM("position" to "relative", "right" to "25%")), "cl-col-push-7" to _pS(_uM("position" to "relative", "left" to "29.1666666667%")), "cl-col-pull-7" to _pS(_uM("position" to "relative", "right" to "29.1666666667%")), "cl-col-push-8" to _pS(_uM("position" to "relative", "left" to "33.3333333333%")), "cl-col-pull-8" to _pS(_uM("position" to "relative", "right" to "33.3333333333%")), "cl-col-push-9" to _pS(_uM("position" to "relative", "left" to "37.5%")), "cl-col-pull-9" to _pS(_uM("position" to "relative", "right" to "37.5%")), "cl-col-push-10" to _pS(_uM("position" to "relative", "left" to "41.6666666667%")), "cl-col-pull-10" to _pS(_uM("position" to "relative", "right" to "41.6666666667%")), "cl-col-push-11" to _pS(_uM("position" to "relative", "left" to "45.8333333333%")), "cl-col-pull-11" to _pS(_uM("position" to "relative", "right" to "45.8333333333%")), "cl-col-push-12" to _pS(_uM("position" to "relative", "left" to "50%")), "cl-col-pull-12" to _pS(_uM("position" to "relative", "right" to "50%")), "cl-col-push-13" to _pS(_uM("position" to "relative", "left" to "54.1666666667%")), "cl-col-pull-13" to _pS(_uM("position" to "relative", "right" to "54.1666666667%")), "cl-col-push-14" to _pS(_uM("position" to "relative", "left" to "58.3333333333%")), "cl-col-pull-14" to _pS(_uM("position" to "relative", "right" to "58.3333333333%")), "cl-col-push-15" to _pS(_uM("position" to "relative", "left" to "62.5%")), "cl-col-pull-15" to _pS(_uM("position" to "relative", "right" to "62.5%")), "cl-col-push-16" to _pS(_uM("position" to "relative", "left" to "66.6666666667%")), "cl-col-pull-16" to _pS(_uM("position" to "relative", "right" to "66.6666666667%")), "cl-col-push-17" to _pS(_uM("position" to "relative", "left" to "70.8333333333%")), "cl-col-pull-17" to _pS(_uM("position" to "relative", "right" to "70.8333333333%")), "cl-col-push-18" to _pS(_uM("position" to "relative", "left" to "75%")), "cl-col-pull-18" to _pS(_uM("position" to "relative", "right" to "75%")), "cl-col-push-19" to _pS(_uM("position" to "relative", "left" to "79.1666666667%")), "cl-col-pull-19" to _pS(_uM("position" to "relative", "right" to "79.1666666667%")), "cl-col-push-20" to _pS(_uM("position" to "relative", "left" to "83.3333333333%")), "cl-col-pull-20" to _pS(_uM("position" to "relative", "right" to "83.3333333333%")), "cl-col-push-21" to _pS(_uM("position" to "relative", "left" to "87.5%")), "cl-col-pull-21" to _pS(_uM("position" to "relative", "right" to "87.5%")), "cl-col-push-22" to _pS(_uM("position" to "relative", "left" to "91.6666666667%")), "cl-col-pull-22" to _pS(_uM("position" to "relative", "right" to "91.6666666667%")), "cl-col-push-23" to _pS(_uM("position" to "relative", "left" to "95.8333333333%")), "cl-col-pull-23" to _pS(_uM("position" to "relative", "right" to "95.8333333333%")), "cl-col-push-24" to _pS(_uM("position" to "relative", "left" to "100%")), "cl-col-pull-24" to _pS(_uM("position" to "relative", "right" to "100%")), "cl-col-1" to _pS(_uM("width" to "4.1666666667%")), "cl-col-offset-1" to _pS(_uM("marginLeft" to "4.1666666667%")), "cl-col-2" to _pS(_uM("width" to "8.3333333333%")), "cl-col-offset-2" to _pS(_uM("marginLeft" to "8.3333333333%")), "cl-col-3" to _pS(_uM("width" to "12.5%")), "cl-col-offset-3" to _pS(_uM("marginLeft" to "12.5%")), "cl-col-4" to _pS(_uM("width" to "16.6666666667%")), "cl-col-offset-4" to _pS(_uM("marginLeft" to "16.6666666667%")), "cl-col-5" to _pS(_uM("width" to "20.8333333333%")), "cl-col-offset-5" to _pS(_uM("marginLeft" to "20.8333333333%")), "cl-col-6" to _pS(_uM("width" to "25%")), "cl-col-offset-6" to _pS(_uM("marginLeft" to "25%")), "cl-col-7" to _pS(_uM("width" to "29.1666666667%")), "cl-col-offset-7" to _pS(_uM("marginLeft" to "29.1666666667%")), "cl-col-8" to _pS(_uM("width" to "33.3333333333%")), "cl-col-offset-8" to _pS(_uM("marginLeft" to "33.3333333333%")), "cl-col-9" to _pS(_uM("width" to "37.5%")), "cl-col-offset-9" to _pS(_uM("marginLeft" to "37.5%")), "cl-col-10" to _pS(_uM("width" to "41.6666666667%")), "cl-col-offset-10" to _pS(_uM("marginLeft" to "41.6666666667%")), "cl-col-11" to _pS(_uM("width" to "45.8333333333%")), "cl-col-offset-11" to _pS(_uM("marginLeft" to "45.8333333333%")), "cl-col-12" to _pS(_uM("width" to "50%")), "cl-col-offset-12" to _pS(_uM("marginLeft" to "50%")), "cl-col-13" to _pS(_uM("width" to "54.1666666667%")), "cl-col-offset-13" to _pS(_uM("marginLeft" to "54.1666666667%")), "cl-col-14" to _pS(_uM("width" to "58.3333333333%")), "cl-col-offset-14" to _pS(_uM("marginLeft" to "58.3333333333%")), "cl-col-15" to _pS(_uM("width" to "62.5%")), "cl-col-offset-15" to _pS(_uM("marginLeft" to "62.5%")), "cl-col-16" to _pS(_uM("width" to "66.6666666667%")), "cl-col-offset-16" to _pS(_uM("marginLeft" to "66.6666666667%")), "cl-col-17" to _pS(_uM("width" to "70.8333333333%")), "cl-col-offset-17" to _pS(_uM("marginLeft" to "70.8333333333%")), "cl-col-18" to _pS(_uM("width" to "75%")), "cl-col-offset-18" to _pS(_uM("marginLeft" to "75%")), "cl-col-19" to _pS(_uM("width" to "79.1666666667%")), "cl-col-offset-19" to _pS(_uM("marginLeft" to "79.1666666667%")), "cl-col-20" to _pS(_uM("width" to "83.3333333333%")), "cl-col-offset-20" to _pS(_uM("marginLeft" to "83.3333333333%")), "cl-col-21" to _pS(_uM("width" to "87.5%")), "cl-col-offset-21" to _pS(_uM("marginLeft" to "87.5%")), "cl-col-22" to _pS(_uM("width" to "91.6666666667%")), "cl-col-offset-22" to _pS(_uM("marginLeft" to "91.6666666667%")), "cl-col-23" to _pS(_uM("width" to "95.8333333333%")), "cl-col-offset-23" to _pS(_uM("marginLeft" to "95.8333333333%")), "cl-col-24" to _pS(_uM("width" to "100%")), "cl-col-offset-24" to _pS(_uM("marginLeft" to "100%")))
            }
        var inheritAttrs = true
        var inject: Map<String, Map<String, Any?>> = _uM()
        var emits: Map<String, Any?> = _uM()
        var props = _nP(_uM("pt" to _uM("default" to fun(): UTSJSONObject {
            return (UTSJSONObject())
        }
        ), "span" to _uM("type" to "Number", "default" to 24), "offset" to _uM("type" to "Number", "default" to 0), "push" to _uM("type" to "Number", "default" to 0), "pull" to _uM("type" to "Number", "default" to 0)))
        var propsNeedCastKeys = _uA(
            "pt",
            "span",
            "offset",
            "push",
            "pull"
        )
        var components: Map<String, CreateVueComponent> = _uM()
    }
}
