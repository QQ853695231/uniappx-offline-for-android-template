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
open class GenUniModulesCoolUiComponentsClPageTheme : VueComponent {
    constructor(__ins: ComponentInternalInstance) : super(__ins) {}
    companion object {
        @Suppress("UNUSED_PARAMETER", "UNUSED_VARIABLE")
        var setup: (__props: GenUniModulesCoolUiComponentsClPageTheme) -> Any? = fun(__props): Any? {
            val __ins = getCurrentInstance()!!
            val _ctx = __ins.proxy as GenUniModulesCoolUiComponentsClPageTheme
            val _cache = __ins.renderCache
            val list = _uA(
                "moon-fill",
                "sun-fill"
            )
            return fun(): Any? {
                val _component_cl_icon = resolveEasyComponent("cl-icon", GenUniModulesCoolUiComponentsClIconClIconClass)
                val _component_cl_float_view = resolveEasyComponent("cl-float-view", GenUniModulesCoolUiComponentsClFloatViewClFloatViewClass)
                return if (isTrue(unref(config1).showDarkButton)) {
                    _cV(_component_cl_float_view, _uM("key" to 0, "size" to 40, "left" to 20, "bottom" to 20, "gap" to 20), _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                        return _uA(
                            _cE("view", _uM("class" to "theme-set", "onClick" to fun(){
                                unref(toggleTheme)()
                            }), _uA(
                                _cE("view", _uM("class" to _nC(_uA(
                                    "theme-set__inner",
                                    _uM("is-dark" to unref(isDark))
                                ))), _uA(
                                    _cE(Fragment, null, RenderHelpers.renderList(list, fun(item, __key, __index, _cached): Any {
                                        return _cE("view", _uM("class" to "theme-set__icon", "key" to item), _uA(
                                            _cV(_component_cl_icon, _uM("name" to item, "color" to "white", "size" to "18px"), null, 8, _uA(
                                                "name"
                                            ))
                                        ))
                                    }), 64)
                                ), 2)
                            ), 8, _uA(
                                "onClick"
                            ))
                        )
                    }), "_" to 1))
                } else {
                    _cC("v-if", true)
                }
            }
        }
        var name = "cl-page-theme"
        val styles: Map<String, Map<String, Map<String, Any>>> by lazy {
            _nCS(_uA(
                styles0
            ))
        }
        val styles0: Map<String, Map<String, Map<String, Any>>>
            get() {
                return _uM("theme-set" to _pS(_uM("display" to "flex", "height" to "100%", "width" to "100%", "flexDirection" to "column", "alignItems" to "center", "justifyContent" to "center", "borderTopLeftRadius" to 9999, "borderTopRightRadius" to 9999, "borderBottomRightRadius" to 9999, "borderBottomLeftRadius" to 9999, "backgroundColor" to "rgba(20,184,166,1)")), "theme-set__inner" to _uM("" to _uM("display" to "flex", "flexDirection" to "column", "transitionDuration" to "300ms", "transform" to "translateY(20px)", "transitionProperty" to "transform"), ".is-dark" to _uM("transform" to "translateY(-20px)")), "theme-set__icon" to _pS(_uM("display" to "flex", "alignItems" to "center", "justifyContent" to "center", "height" to 40, "width" to 40)), "@TRANSITION" to _uM("theme-set__inner" to _uM("duration" to "300ms", "property" to "transform")))
            }
        var inheritAttrs = true
        var inject: Map<String, Map<String, Any?>> = _uM()
        var emits: Map<String, Any?> = _uM()
        var props = _nP(_uM())
        var propsNeedCastKeys: UTSArray<String> = _uA()
        var components: Map<String, CreateVueComponent> = _uM()
    }
}
