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
open class GenUniModulesCoolUiComponentsClLoadmoreClLoadmore : VueComponent {
    constructor(__ins: ComponentInternalInstance) : super(__ins) {}
    open var pt: Any by `$props`
    open var loading: Boolean by `$props`
    open var loadingText: String by `$props`
    open var finish: Boolean by `$props`
    open var finishText: String by `$props`
    open var safeAreaBottom: Boolean by `$props`
    companion object {
        @Suppress("UNUSED_PARAMETER", "UNUSED_VARIABLE")
        var setup: (__props: GenUniModulesCoolUiComponentsClLoadmoreClLoadmore) -> Any? = fun(__props): Any? {
            val __ins = getCurrentInstance()!!
            val _ctx = __ins.proxy as GenUniModulesCoolUiComponentsClLoadmoreClLoadmore
            val _cache = __ins.renderCache
            val props = __props
            val pt = computed(fun(): PassThrough43 {
                return parsePt<PassThrough43>(props.pt)
            }
            )
            val message = computed(fun(): String {
                if (props.finish) {
                    return props.finishText
                }
                if (props.loading) {
                    return props.loadingText
                }
                return ""
            }
            )
            return fun(): Any? {
                val _component_cl_loading = resolveEasyComponent("cl-loading", GenUniModulesCoolUiComponentsClLoadingClLoadingClass)
                val _component_cl_text = resolveEasyComponent("cl-text", GenUniModulesCoolUiComponentsClTextClTextClass)
                val _component_cl_safe_area = resolveEasyComponent("cl-safe-area", GenUniModulesCoolUiComponentsClSafeAreaClSafeAreaClass)
                return _cE("view", _uM("class" to "cl-loadmore-wrapper"), _uA(
                    _cE("view", _uM("class" to "cl-loadmore"), _uA(
                        if (isTrue(_ctx.loading)) {
                            _cV(_component_cl_loading, _uM("key" to 0, "size" to 30, "pt" to object : UTSJSONObject() {
                                var className = "mr-2 " + pt.value.icon?.className
                            }), null, 8, _uA(
                                "pt"
                            ))
                        } else {
                            _cC("v-if", true)
                        }
                        ,
                        _cV(_component_cl_text, _uM("pt" to object : UTSJSONObject() {
                            var className = pt.value.text?.className
                        }), _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                            return _uA(
                                _tD(message.value)
                            )
                        }
                        ), "_" to 1), 8, _uA(
                            "pt"
                        ))
                    )),
                    if (isTrue(_ctx.safeAreaBottom)) {
                        _cV(_component_cl_safe_area, _uM("key" to 0, "type" to "bottom"))
                    } else {
                        _cC("v-if", true)
                    }
                ))
            }
        }
        var name = "cl-loadmore"
        val styles: Map<String, Map<String, Map<String, Any>>> by lazy {
            _nCS(_uA(
                styles0
            ))
        }
        val styles0: Map<String, Map<String, Map<String, Any>>>
            get() {
                return _uM("cl-loadmore-wrapper" to _pS(_uM("display" to "flex", "flexDirection" to "column", "alignItems" to "center", "justifyContent" to "center", "paddingTop" to "14rpx", "paddingBottom" to "14rpx")), "cl-loadmore" to _pS(_uM("display" to "flex", "flexDirection" to "row", "alignItems" to "center", "justifyContent" to "center")))
            }
        var inheritAttrs = true
        var inject: Map<String, Map<String, Any?>> = _uM()
        var emits: Map<String, Any?> = _uM()
        var props = _nP(_uM("pt" to _uM("default" to fun(): UTSJSONObject {
            return (UTSJSONObject())
        }
        ), "loading" to _uM("type" to "Boolean", "default" to false), "loadingText" to _uM("type" to "String", "default" to fun(): String {
            return t("加载中")
        }
        ), "finish" to _uM("type" to "Boolean", "default" to false), "finishText" to _uM("type" to "String", "default" to fun(): String {
            return t("没有更多了")
        }
        ), "safeAreaBottom" to _uM("type" to "Boolean", "default" to true)))
        var propsNeedCastKeys = _uA(
            "pt",
            "loading",
            "loadingText",
            "finish",
            "finishText",
            "safeAreaBottom"
        )
        var components: Map<String, CreateVueComponent> = _uM()
    }
}
