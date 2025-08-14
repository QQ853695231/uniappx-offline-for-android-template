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
open class GenUniModulesCoolUiComponentsClTimelineItemClTimelineItem : VueComponent {
    constructor(__ins: ComponentInternalInstance) : super(__ins) {}
    open var pt: Any by `$props`
    open var title: String by `$props`
    open var icon: String by `$props`
    open var content: String by `$props`
    open var date: String by `$props`
    open var hideLine: Boolean by `$props`
    companion object {
        @Suppress("UNUSED_PARAMETER", "UNUSED_VARIABLE")
        var setup: (__props: GenUniModulesCoolUiComponentsClTimelineItemClTimelineItem) -> Any? = fun(__props): Any? {
            val __ins = getCurrentInstance()!!
            val _ctx = __ins.proxy as GenUniModulesCoolUiComponentsClTimelineItemClTimelineItem
            val _cache = __ins.renderCache
            val props = __props
            val pt = computed(fun(): PassThrough47 {
                return parsePt<PassThrough47>(props.pt)
            }
            )
            return fun(): Any? {
                val _component_cl_icon = resolveEasyComponent("cl-icon", GenUniModulesCoolUiComponentsClIconClIconClass)
                val _component_cl_text = resolveEasyComponent("cl-text", GenUniModulesCoolUiComponentsClTextClTextClass)
                return _cE("view", _uM("class" to _nC(_uA(
                    "cl-timeline-item",
                    _uA(
                        _uM<String, Any?>(),
                        pt.value.classNames
                    )
                ))), _uA(
                    _cE("view", _uM("class" to "cl-timeline-item__left"), _uA(
                        if (_ctx.icon != "") {
                            _cV(_component_cl_icon, _uM("key" to 0, "name" to _ctx.icon, "size" to 34, "pt" to object : UTSJSONObject() {
                                var className = "" + pt.value.icon?.className
                            }), null, 8, _uA(
                                "name",
                                "pt"
                            ))
                        } else {
                            _cE("view", _uM("key" to 1, "class" to "cl-timeline-item__dot"))
                        }
                        ,
                        if (isTrue(!_ctx.hideLine)) {
                            _cE("view", _uM("key" to 2, "class" to "cl-timeline-item__line"))
                        } else {
                            _cC("v-if", true)
                        }
                    )),
                    _cE("view", _uM("class" to _nC(_uA(
                        "cl-timeline-item__right",
                        _uA(
                            _uM<String, Any?>(),
                            _uM("is-icon" to (_ctx.icon != ""), "is-title" to (_ctx.title != ""))
                        )
                    ))), _uA(
                        if (_ctx.title != "") {
                            _cV(_component_cl_text, _uM("key" to 0, "pt" to object : UTSJSONObject() {
                                var className = unref(parseClass)(_uA(
                                    "mb-1 -important-font-bold " + pt.value.title?.className,
                                    _uA(
                                        unref(isDark),
                                        "-important-text-white",
                                        "-important-text-surface-900"
                                    )
                                ))
                            }), _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                                return _uA(
                                    _tD(_ctx.title)
                                )
                            }), "_" to 1), 8, _uA(
                                "pt"
                            ))
                        } else {
                            _cC("v-if", true)
                        }
                        ,
                        if (_ctx.content != "") {
                            _cV(_component_cl_text, _uM("key" to 1, "pt" to object : UTSJSONObject() {
                                var className = "mb-2 -important-text-sm " + pt.value.content?.className
                            }), _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                                return _uA(
                                    _tD(_ctx.content)
                                )
                            }), "_" to 1), 8, _uA(
                                "pt"
                            ))
                        } else {
                            _cC("v-if", true)
                        }
                        ,
                        renderSlot(_ctx.`$slots`, "default"),
                        if (_ctx.date != "") {
                            _cV(_component_cl_text, _uM("key" to 2, "pt" to object : UTSJSONObject() {
                                var className = "-important-text-xs " + pt.value.date?.className
                            }, "color" to "info"), _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                                return _uA(
                                    _tD(_ctx.date)
                                )
                            }), "_" to 1), 8, _uA(
                                "pt"
                            ))
                        } else {
                            _cC("v-if", true)
                        }
                    ), 2)
                ), 2)
            }
        }
        var name = "cl-timeline-item"
        val styles: Map<String, Map<String, Map<String, Any>>> by lazy {
            _nCS(_uA(
                styles0
            ))
        }
        val styles0: Map<String, Map<String, Map<String, Any>>>
            get() {
                return _uM("cl-timeline-item" to _pS(_uM("display" to "flex", "width" to "100%", "flexDirection" to "row", "overflow" to "visible", "marginBottom" to "10rpx")), "cl-timeline-item__left" to _pS(_uM("position" to "relative", "display" to "flex", "height" to "100%", "flexDirection" to "column", "alignItems" to "center", "width" to "50rpx", "marginRight" to "10rpx", "overflow" to "visible")), "cl-timeline-item__dot" to _pS(_uM("borderTopLeftRadius" to 9999, "borderTopRightRadius" to 9999, "borderBottomRightRadius" to 9999, "borderBottomLeftRadius" to 9999, "backgroundColor" to "rgba(212,212,216,1)", "height" to "16rpx", "width" to "16rpx")), "cl-timeline-item__line" to _pS(_uM("backgroundColor" to "rgba(212,212,216,1)", "width" to "1rpx", "flex" to 1, "marginTop" to "10rpx")), "cl-timeline-item__right" to _uM("" to _uM("position" to "relative", "top" to "-12rpx", "flex" to 1, "marginBottom" to "40rpx"), ".is-title" to _uM("top" to "-12rpx"), ".is-icon" to _uM("top" to "-4rpx")))
            }
        var inheritAttrs = true
        var inject: Map<String, Map<String, Any?>> = _uM()
        var emits: Map<String, Any?> = _uM()
        var props = _nP(_uM("pt" to _uM("default" to fun(): UTSJSONObject {
            return (UTSJSONObject())
        }
        ), "title" to _uM("type" to "String", "default" to ""), "icon" to _uM("type" to "String", "default" to ""), "content" to _uM("type" to "String", "default" to ""), "date" to _uM("type" to "String", "default" to ""), "hideLine" to _uM("type" to "Boolean", "default" to false)))
        var propsNeedCastKeys = _uA(
            "pt",
            "title",
            "icon",
            "content",
            "date",
            "hideLine"
        )
        var components: Map<String, CreateVueComponent> = _uM()
    }
}
