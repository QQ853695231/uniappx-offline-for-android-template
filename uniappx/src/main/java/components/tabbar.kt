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
import io.dcloud.uniapp.extapi.hideTabBar as uni_hideTabBar
open class GenComponentsTabbar : VueComponent {
    constructor(__ins: ComponentInternalInstance) : super(__ins) {}
    companion object {
        @Suppress("UNUSED_PARAMETER", "UNUSED_VARIABLE")
        var setup: (__props: GenComponentsTabbar) -> Any? = fun(__props): Any? {
            val __ins = getCurrentInstance()!!
            val _ctx = __ins.proxy as GenComponentsTabbar
            val _cache = __ins.renderCache
            val path = computed(fun(): String {
                return router.path()
            }
            )
            val list = computed<UTSArray<Item1>>(fun(): UTSArray<Item1> {
                return (ctx.tabBar.list ?: _uA()).map(fun(e): Item1 {
                    return Item1(icon = e.iconPath!!, icon2 = e.selectedIconPath!!, pagePath = e.pagePath, text = t(e.text?.replaceAll("%", "")!!))
                }
                )
            }
            )
            uni_hideTabBar(null)
            return fun(): Any? {
                val _component_cl_image = resolveEasyComponent("cl-image", GenUniModulesCoolUiComponentsClImageClImageClass)
                val _component_cl_text = resolveEasyComponent("cl-text", GenUniModulesCoolUiComponentsClTextClTextClass)
                val _component_cl_footer = resolveEasyComponent("cl-footer", GenUniModulesCoolUiComponentsClFooterClFooterClass)
                return _cV(_component_cl_footer, _uM("pt" to object : UTSJSONObject() {
                    var content = object : UTSJSONObject() {
                        var className = "-important-p-0 h--bracket-start-60px-bracket-end-"
                    }
                }), _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                    return _uA(
                        _cE("view", _uM("class" to _nC(_uA(
                            "tabbar",
                            _uM("is-dark" to unref(isDark))
                        ))), _uA(
                            _cE(Fragment, null, RenderHelpers.renderList(list.value, fun(item, __key, __index, _cached): Any {
                                return _cE("view", _uM("class" to "tabbar-item", "key" to item.pagePath, "onClick" to fun(){
                                    unref(router).to(item.pagePath)
                                }
                                ), _uA(
                                    _cV(_component_cl_image, _uM("src" to if (path.value == item.pagePath) {
                                        item.icon2
                                    } else {
                                        item.icon
                                    }
                                    , "height" to 56, "width" to 56), null, 8, _uA(
                                        "src"
                                    )),
                                    if (item.text != null) {
                                        _cV(_component_cl_text, _uM("key" to 0, "pt" to object : UTSJSONObject() {
                                            var className = unref(parseClass)(_uA(
                                                "-important-text-xs mt-1",
                                                _uA(
                                                    path.value == item.pagePath,
                                                    "-important-text-primary-500",
                                                    "-important-text-surface-400"
                                                )
                                            ))
                                        }), _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                                            return _uA(
                                                _tD(unref(t)(item.text!!))
                                            )
                                        }), "_" to 2), 1032, _uA(
                                            "pt"
                                        ))
                                    } else {
                                        _cC("v-if", true)
                                    }
                                ), 8, _uA(
                                    "onClick"
                                ))
                            }
                            ), 128)
                        ), 2)
                    )
                }
                ), "_" to 1))
            }
        }
        val styles: Map<String, Map<String, Map<String, Any>>> by lazy {
            _nCS(_uA(
                styles0
            ))
        }
        val styles0: Map<String, Map<String, Map<String, Any>>>
            get() {
                return _uM("tabbar" to _pS(_uM("display" to "flex", "flex" to 1, "flexDirection" to "row", "alignItems" to "center")), "tabbar-item" to _uM(".tabbar " to _uM("display" to "flex", "flex" to 1, "flexDirection" to "column", "alignItems" to "center", "justifyContent" to "center")))
            }
        var inheritAttrs = true
        var inject: Map<String, Map<String, Any?>> = _uM()
        var emits: Map<String, Any?> = _uM()
        var props = _nP(_uM())
        var propsNeedCastKeys: UTSArray<String> = _uA()
        var components: Map<String, CreateVueComponent> = _uM()
    }
}
