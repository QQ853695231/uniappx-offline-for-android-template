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
open class GenUniModulesCoolUiComponentsClIconClIcon : VueComponent {
    constructor(__ins: ComponentInternalInstance) : super(__ins) {}
    open var pt: Any by `$props`
    open var name: String by `$props`
    open var size: Any? by `$props`
    open var height: Any? by `$props`
    open var width: Any? by `$props`
    open var color: String by `$props`
    companion object {
        @Suppress("UNUSED_PARAMETER", "UNUSED_VARIABLE")
        var setup: (__props: GenUniModulesCoolUiComponentsClIconClIcon) -> Any? = fun(__props): Any? {
            val __ins = getCurrentInstance()!!
            val _ctx = __ins.proxy as GenUniModulesCoolUiComponentsClIconClIcon
            val _cache = __ins.renderCache
            val props = __props
            val cache = useCache(fun(): UTSArray<Any> {
                return _uA(
                    props.color
                )
            }
            ).cache
            val getRpx = useSize().getRpx
            val pt = computed(fun(): PassThrough1 {
                return parsePt<PassThrough1>(props.pt)
            }
            )
            val icon = computed<Icon>(fun(): Icon {
                var font = ""
                var text = ""
                try {
                    var code = ""
                    forInObject(icons, fun(value, key){
                        if (has(value, props.name)) {
                            font = key
                            code = get(value, props.name) as String
                        }
                    }
                    )
                    text = String(Character.toChars(parseInt(code, 16).toInt()))
                }
                 catch (e: Throwable) {
                    console.error("\u56FE\u6807 " + props.name + " \u4E0D\u5B58\u5728", e)
                }
                return Icon(font = font, text = text)
            }
            )
            val iconStyle = computed(fun(): UTSJSONObject {
                val style: UTSJSONObject = UTSJSONObject()
                if (props.color != "") {
                    style["color"] = props.color
                }
                if (icon.value.font != "") {
                    style["fontFamily"] = icon.value.font
                }
                style["fontSize"] = getRpx(props.size!!)
                style["height"] = getRpx(props.height ?: props.size!!)
                style["width"] = getRpx(props.width ?: props.size!!)
                style["lineHeight"] = getRpx(props.size!!)
                return style
            }
            )
            return fun(): Any? {
                return _cE("text", _uM("class" to _nC(_uA(
                    "cl-icon",
                    _uA(
                        _uM("dark-colon-text-surface-50" to unref(isDark)),
                        if (unref(isDark)) {
                            "text-white"
                        } else {
                            "text-surface-700"
                        }
                        ,
                        _uM("-important-text-primary-500" to (_ctx.color == "primary"), "-important-text-green-500" to (_ctx.color == "success"), "-important-text-yellow-500" to (_ctx.color == "warn"), "-important-text-red-500" to (_ctx.color == "error"), "-important-text-surface-500" to (_ctx.color == "info"), "-important-text-surface-700" to (_ctx.color == "dark"), "-important-text-surface-50" to (_ctx.color == "light"), "-important-text-surface-300" to (_ctx.color == "disabled")),
                        pt.value.className
                    )
                )), "style" to _nS(iconStyle.value), "key" to unref(cache).key), _tD(icon.value.text), 7)
            }
        }
        var name = "cl-icon"
        val styles: Map<String, Map<String, Map<String, Any>>> by lazy {
            _nCS(_uA())
        }
        var inheritAttrs = true
        var inject: Map<String, Map<String, Any?>> = _uM()
        var emits: Map<String, Any?> = _uM()
        var props = _nP(_uM("pt" to _uM("default" to fun(): UTSJSONObject {
            return (UTSJSONObject())
        }
        ), "name" to _uM("type" to "String", "default" to ""), "size" to _uM("default" to 32), "height" to _uM("default" to null), "width" to _uM("default" to null), "color" to _uM("type" to "String", "default" to "")))
        var propsNeedCastKeys = _uA(
            "pt",
            "name",
            "size",
            "height",
            "width",
            "color"
        )
        var components: Map<String, CreateVueComponent> = _uM()
    }
}
