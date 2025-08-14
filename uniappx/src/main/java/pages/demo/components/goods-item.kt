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
open class GenPagesDemoComponentsGoodsItem : VueComponent {
    constructor(__ins: ComponentInternalInstance) : super(__ins) {}
    open var value: Any by `$props`
    companion object {
        @Suppress("UNUSED_PARAMETER", "UNUSED_VARIABLE")
        var setup: (__props: GenPagesDemoComponentsGoodsItem) -> Any? = fun(__props): Any? {
            val __ins = getCurrentInstance()!!
            val _ctx = __ins.proxy as GenPagesDemoComponentsGoodsItem
            val _cache = __ins.renderCache
            val props = __props
            val item = computed(fun(): GoodsItem? {
                return parse<GoodsItem>(props.value)
            }
            )
            return fun(): Any? {
                val _component_cl_image = resolveEasyComponent("cl-image", GenUniModulesCoolUiComponentsClImageClImageClass)
                val _component_cl_text = resolveEasyComponent("cl-text", GenUniModulesCoolUiComponentsClTextClTextClass)
                return _cE("view", _uM("class" to "p-3 pb-0"), _uA(
                    _cE("view", _uM("class" to _nC(_uA(
                        "w-full p-3 bg-white rounded-xl",
                        _uM("dark-colon-bg-surface-800" to unref(isDark))
                    ))), _uA(
                        _cV(_component_cl_image, _uM("src" to item.value?.image, "mode" to "aspectFill", "width" to "100%", "height" to "280rpx"), null, 8, _uA(
                            "src"
                        )),
                        _cV(_component_cl_text, _uM("pt" to object : UTSJSONObject() {
                            var className = "mt-2"
                        }), _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                            return _uA(
                                _tD(item.value?.title)
                            )
                        }
                        ), "_" to 1))
                    ), 2)
                ))
            }
        }
        var name = "goods-item"
        val styles: Map<String, Map<String, Map<String, Any>>> by lazy {
            _nCS(_uA())
        }
        var inheritAttrs = true
        var inject: Map<String, Map<String, Any?>> = _uM()
        var emits: Map<String, Any?> = _uM()
        var props = _nP(_uM("value" to _uM("default" to fun(): UTSJSONObject {
            return (UTSJSONObject())
        }
        )))
        var propsNeedCastKeys = _uA(
            "value"
        )
        var components: Map<String, CreateVueComponent> = _uM()
    }
}
