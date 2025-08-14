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
open class GenUniModulesCoolUiComponentsClTextClText : VueComponent {
    constructor(__ins: ComponentInternalInstance) : super(__ins) {}
    open var pt: Any by `$props`
    open var value: Any? by `$props`
    open var color: String by `$props`
    open var size: Any? by `$props`
    open var type: String by `$props`
    open var mask: Boolean by `$props`
    open var currency: String by `$props`
    open var precision: Number by `$props`
    open var maskStart: Number by `$props`
    open var maskEnd: Number by `$props`
    open var maskChar: String by `$props`
    open var ellipsis: Boolean by `$props`
    open var selectable: Boolean by `$props`
    open var space: String by `$props`
    open var decode: Boolean by `$props`
    open var preWrap: Boolean by `$props`
    companion object {
        @Suppress("UNUSED_PARAMETER", "UNUSED_VARIABLE")
        var setup: (__props: GenUniModulesCoolUiComponentsClTextClText) -> Any? = fun(__props): Any? {
            val __ins = getCurrentInstance()!!
            val _ctx = __ins.proxy as GenUniModulesCoolUiComponentsClTextClText
            val _cache = __ins.renderCache
            val props = __props
            val cache = useCache(fun(): UTSArray<Any> {
                return _uA(
                    props.color,
                    props
                )
            }
            ).cache
            val pt = computed(fun(): PassThrough2 {
                return parsePt<PassThrough2>(props.pt)
            }
            )
            val _useSize = useSize(fun(): String {
                return pt.value.className ?: ""
            }
            )
            val getSize = _useSize.getSize
            val getLineHeight = _useSize.getLineHeight
            val ptClassName = _useSize.ptClassName
            val textStyle = computed(fun(): UTSJSONObject {
                val style: UTSJSONObject = UTSJSONObject()
                if (props.color != "") {
                    style["color"] = props.color
                }
                val fontSize = getSize(props.size)
                if (fontSize != null) {
                    style["fontSize"] = fontSize
                }
                val lineHeight = getLineHeight()
                if (lineHeight != null) {
                    style["lineHeight"] = lineHeight
                }
                return style
            }
            )
            fun gen_formatPhone_fn(phone: String): String {
                if (phone.length != 11 || !props.mask) {
                    return phone
                }
                return phone.replace(UTSRegExp("(\\d{3})\\d{4}(\\d{4})", ""), "\$1" + props.maskChar.repeat(4) + "\$2")
            }
            val formatPhone = ::gen_formatPhone_fn
            fun gen_formatName_fn(name: String): String {
                if (name.length <= 1 || !props.mask) {
                    return name
                }
                if (name.length == 2) {
                    return name[0] + props.maskChar
                }
                return name[0] + props.maskChar.repeat(name.length - 2) + name[name.length - 1]
            }
            val formatName = ::gen_formatName_fn
            fun formatAmount(amount: Any): String {
                var num: Number
                if (UTSAndroid.`typeof`(amount) == "number") {
                    num = amount as Number
                } else {
                    num = parseFloat(amount as String)
                }
                val formatted = num.toFixed(props.precision)
                val parts = formatted.split(".")
                parts[0] = parts[0].replace(UTSRegExp("\\B(?=(\\d{3})+(?!\\d))", "g"), ",")
                return props.currency + parts.join(".")
            }
            fun gen_formatCard_fn(card: String): String {
                if (card.length < 8 || !props.mask) {
                    return card
                }
                val start = card.substring(0, props.maskStart)
                val end = card.substring(card.length - props.maskEnd)
                val middle = props.maskChar.repeat(card.length - props.maskStart - props.maskEnd)
                return start + middle + end
            }
            val formatCard = ::gen_formatCard_fn
            fun gen_formatEmail_fn(email: String): String {
                if (!props.mask) {
                    return email
                }
                val atIndex = email.indexOf("@")
                if (atIndex == -1) {
                    return email
                }
                val username = email.substring(0, atIndex)
                val domain = email.substring(atIndex)
                if (username.length <= 2) {
                    return email
                }
                val maskedUsername = username[0] + props.maskChar.repeat(username.length - 2) + username[username.length - 1]
                return maskedUsername + domain
            }
            val formatEmail = ::gen_formatEmail_fn
            val content = computed(fun(): Any {
                val kVal = props.value ?: ""
                when (props.type) {
                    "phone" -> 
                        return formatPhone(kVal as String)
                    "name" -> 
                        return formatName(kVal as String)
                    "amount" -> 
                        return formatAmount(kVal as Number)
                    "card" -> 
                        return formatCard(kVal as String)
                    "email" -> 
                        return formatEmail(kVal as String)
                    else -> 
                        return kVal
                }
            }
            )
            return fun(): Any? {
                return _cE("text", _uM("class" to _nC(_uA(
                    "cl-text",
                    _uA(
                        _uM("dark-colon-text-surface-50" to unref(isDark)),
                        if (unref(isDark)) {
                            "text-surface-50"
                        } else {
                            "text-surface-700"
                        }
                        ,
                        _uM("truncate w-full" to _ctx.ellipsis, "cl-text--pre-wrap" to _ctx.preWrap),
                        _uM("-important-text-primary-500" to (_ctx.color == "primary"), "-important-text-green-500" to (_ctx.color == "success"), "-important-text-yellow-500" to (_ctx.color == "warn"), "-important-text-red-500" to (_ctx.color == "error"), if (unref(isDark)) {
                            "-important-text-surface-300"
                        } else {
                            "-important-text-surface-500"
                        }
                         to (_ctx.color == "info"), "-important-text-surface-700" to (_ctx.color == "dark"), "-important-text-surface-50" to (_ctx.color == "light"), "-important-text-surface-400" to (_ctx.color == "disabled")),
                        unref(ptClassName)
                    )
                )), "style" to _nS(textStyle.value), "selectable" to _ctx.selectable, "space" to _ctx.space, "decode" to _ctx.decode, "key" to unref(cache).key), _uA(
                    renderSlot(_ctx.`$slots`, "default", UTSJSONObject(), fun(): UTSArray<Any> {
                        return _uA(
                            _tD(content.value)
                        )
                    }
                    )
                ), 14, _uA(
                    "selectable",
                    "space",
                    "decode"
                ))
            }
        }
        var name = "cl-text"
        val styles: Map<String, Map<String, Map<String, Any>>> by lazy {
            _nCS(_uA(
                styles0
            ))
        }
        val styles0: Map<String, Map<String, Map<String, Any>>>
            get() {
                return _uM("cl-text" to _pS(_uM("fontSize" to "28rpx", "lineHeight" to "42rpx")))
            }
        var inheritAttrs = true
        var inject: Map<String, Map<String, Any?>> = _uM()
        var emits: Map<String, Any?> = _uM()
        var props = _nP(_uM("pt" to _uM("default" to fun(): UTSJSONObject {
            return (UTSJSONObject())
        }
        ), "value" to _uM("default" to null), "color" to _uM("type" to "String", "default" to ""), "size" to _uM("default" to null), "type" to _uM("type" to "String", "default" to "default"), "mask" to _uM("type" to "Boolean", "default" to false), "currency" to _uM("type" to "String", "default" to "¥"), "precision" to _uM("type" to "Number", "default" to 2), "maskStart" to _uM("type" to "Number", "default" to 3), "maskEnd" to _uM("type" to "Number", "default" to 4), "maskChar" to _uM("type" to "String", "default" to "*"), "ellipsis" to _uM("type" to "Boolean", "default" to false), "selectable" to _uM("type" to "Boolean", "default" to false), "space" to _uM("type" to "String", "default" to ""), "decode" to _uM("type" to "Boolean", "default" to false), "preWrap" to _uM("type" to "Boolean", "default" to false)))
        var propsNeedCastKeys = _uA(
            "pt",
            "value",
            "color",
            "size",
            "type",
            "mask",
            "currency",
            "precision",
            "maskStart",
            "maskEnd",
            "maskChar",
            "ellipsis",
            "selectable",
            "space",
            "decode",
            "preWrap"
        )
        var components: Map<String, CreateVueComponent> = _uM()
    }
}
