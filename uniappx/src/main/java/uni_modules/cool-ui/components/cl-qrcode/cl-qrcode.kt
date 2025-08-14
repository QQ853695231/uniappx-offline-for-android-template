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
import io.dcloud.uniapp.extapi.createCanvasContextAsync as uni_createCanvasContextAsync
open class GenUniModulesCoolUiComponentsClQrcodeClQrcode : VueComponent {
    constructor(__ins: ComponentInternalInstance) : super(__ins) {}
    open var width: String by `$props`
    open var height: String by `$props`
    open var foreground: String by `$props`
    open var background: String by `$props`
    open var pdColor: String? by `$props`
    open var pdRadius: Number by `$props`
    open var text: String by `$props`
    open var logo: String by `$props`
    open var logoSize: String by `$props`
    open var padding: Number by `$props`
    open var mode: String by `$props`
    open var toPng: () -> UTSPromise<String>
        get() {
            return unref(this.`$exposed`["toPng"]) as () -> UTSPromise<String>
        }
        set(value) {
            setRefValue(this.`$exposed`, "toPng", value)
        }
    companion object {
        @Suppress("UNUSED_PARAMETER", "UNUSED_VARIABLE")
        var setup: (__props: GenUniModulesCoolUiComponentsClQrcodeClQrcode, _arg1: SetupContext) -> Any? = fun(__props, ref1): Any? {
            var __expose = ref1.expose
            val __ins = getCurrentInstance()!!
            val _ctx = __ins.proxy as GenUniModulesCoolUiComponentsClQrcodeClQrcode
            val _cache = __ins.renderCache
            val props = __props
            val proxy = getCurrentInstance()!!.proxy
            val qrcodeId = ref<String>("cl-qrcode-" + uuid())
            val canvasRef = shallowRef<UniElement?>(null)
            fun gen_drawer_fn() {
                val data = QrcodeOptions(text = props.text, size = getPx(props.width), foreground = props.foreground, background = props.background, padding = props.padding, logo = props.logo, logoSize = getPx(props.logoSize), ecc = "H", mode = props.mode, pdColor = props.pdColor, pdRadius = props.pdRadius)
                nextTick(fun(){
                    uni_createCanvasContextAsync(CreateCanvasContextAsyncOptions(id = qrcodeId.value, component = proxy, success = fun(context) {
                        drawQrcode(context, data)
                    }
                    , fail = fun(err) {
                        console.error(err)
                    }
                    ))
                }
                )
            }
            val drawer = ::gen_drawer_fn
            fun gen_toPng_fn(): UTSPromise<String> {
                return canvasToPng(canvasRef.value!!)
            }
            val toPng = ::gen_toPng_fn
            val stopWatch = watch(computed(fun(): UTSArray<Any?> {
                return _uA(
                    props.pdColor,
                    props.pdRadius,
                    props.foreground,
                    props.background,
                    props.text,
                    props.logo,
                    props.logoSize,
                    props.mode,
                    props.padding
                )
            }
            ), fun(){
                drawer()
            }
            )
            onMounted(fun(){
                setTimeout(fun(){
                    drawer()
                }
                , if (isHarmony()) {
                    50
                } else {
                    0
                }
                )
            }
            )
            onUnmounted(fun(){
                stopWatch()
            }
            )
            __expose(_uM("toPng" to toPng))
            return fun(): Any? {
                return _cE("view", _uM("style" to _nS(_uM("width" to (unref(getPx)(props.width) + "px"), "height" to (unref(getPx)(props.height) + "px")))), _uA(
                    _cE("canvas", _uM("ref_key" to "canvasRef", "ref" to canvasRef, "canvas-id" to qrcodeId.value, "type" to "2d", "id" to qrcodeId.value, "style" to _nS(_uM("width" to (unref(getPx)(props.width) + "px"), "height" to (unref(getPx)(props.height) + "px")))), null, 12, _uA(
                        "canvas-id",
                        "id"
                    ))
                ), 4)
            }
        }
        var name = "cl-qrcode"
        val styles: Map<String, Map<String, Map<String, Any>>> by lazy {
            _nCS(_uA())
        }
        var inheritAttrs = true
        var inject: Map<String, Map<String, Any?>> = _uM()
        var emits: Map<String, Any?> = _uM()
        var props = _nP(_uM("width" to _uM("type" to "String", "default" to "200px"), "height" to _uM("type" to "String", "default" to "200px"), "foreground" to _uM("type" to "String", "default" to "#131313"), "background" to _uM("type" to "String", "default" to "#FFFFFF"), "pdColor" to _uM("type" to "String", "default" to null), "pdRadius" to _uM("type" to "Number", "default" to 10), "text" to _uM("type" to "String", "default" to "https://cool-js.com/"), "logo" to _uM("type" to "String", "default" to ""), "logoSize" to _uM("type" to "String", "default" to "50px"), "padding" to _uM("type" to "Number", "default" to 5), "mode" to _uM("type" to "String", "default" to "circular")))
        var propsNeedCastKeys = _uA(
            "width",
            "height",
            "foreground",
            "background",
            "pdColor",
            "pdRadius",
            "text",
            "logo",
            "logoSize",
            "padding",
            "mode"
        )
        var components: Map<String, CreateVueComponent> = _uM()
    }
}
