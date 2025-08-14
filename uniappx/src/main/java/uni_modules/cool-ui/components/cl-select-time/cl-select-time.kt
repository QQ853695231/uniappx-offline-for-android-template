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
open class GenUniModulesCoolUiComponentsClSelectTimeClSelectTime : VueComponent {
    constructor(__ins: ComponentInternalInstance) : super(__ins) {}
    open var pt: Any by `$props`
    open var modelValue: String by `$props`
    open var headers: UTSArray<String> by `$props`
    open var type: String by `$props`
    open var title: String by `$props`
    open var placeholder: String by `$props`
    open var showTrigger: Boolean by `$props`
    open var disabled: Boolean by `$props`
    open var confirmText: String by `$props`
    open var showConfirm: Boolean by `$props`
    open var cancelText: String by `$props`
    open var showCancel: Boolean by `$props`
    open var labelFormat: String? by `$props`
    open fun open(cb: ((value: String) -> Unit)? = null) {
        callKotlinFunction(this.`$exposed`["open"]!!, _uA(
            cb
        ))
    }
    open var close: () -> Unit
        get() {
            return unref(this.`$exposed`["close"]) as () -> Unit
        }
        set(value) {
            setRefValue(this.`$exposed`, "close", value)
        }
    companion object {
        @Suppress("UNUSED_PARAMETER", "UNUSED_VARIABLE")
        var setup: (__props: GenUniModulesCoolUiComponentsClSelectTimeClSelectTime, _arg1: SetupContext) -> Any? = fun(__props, ref1): Any? {
            var __expose = ref1.expose
            val __ins = getCurrentInstance()!!
            val _ctx = __ins.proxy as GenUniModulesCoolUiComponentsClSelectTimeClSelectTime
            val _cache = __ins.renderCache
            val props = __props
            fun emit(event: String, vararg do_not_transform_spread: Any?) {
                __ins.emit(event, *do_not_transform_spread)
            }
            val popupRef = ref<ClPopupComponentPublicInstance?>(null)
            val pt = computed(fun(): PassThrough41 {
                return parsePt<PassThrough41>(props.pt)
            }
            )
            val labelFormat = computed(fun(): String {
                if (props.labelFormat != null) {
                    return props.labelFormat!!
                }
                if (props.type == "hour") {
                    return "{H}"
                }
                if (props.type == "minute") {
                    return "{H}:{m}"
                }
                return "{H}:{m}:{s}"
            }
            )
            val value = ref(_uA<String>())
            val indexes = ref(_uA<Number>())
            val list = computed(fun(): UTSArray<UTSArray<ClSelectOption>> {
                val arr = _uA<UTSArray<ClSelectOption>>(_uA(), _uA(), _uA())
                run {
                    var i: Number = 0
                    while(i < 60){
                        val v = i.toString(10).padStart(2, "0")
                        val item = ClSelectOption(label = v, value = v)
                        if (i < 24) {
                            arr[0].push(item)
                        }
                        arr[1].push(item)
                        arr[2].push(item)
                        i++
                    }
                }
                return arr
            }
            )
            val columnNum = computed(fun(): Number {
                return _uA(
                    "hour",
                    "minute",
                    "second"
                ).findIndex(fun(e): Boolean {
                    return e == props.type
                }
                ) + 1
            }
            )
            val columns = computed(fun(): UTSArray<UTSArray<ClSelectOption>> {
                return list.value.slice(0, columnNum.value)
            }
            )
            val text = computed(fun(): String {
                val kVal = props.modelValue
                if (isEmpty(kVal) || isNull(kVal)) {
                    return ""
                }
                val _kVal_split = kVal.split(":")
                val h = _kVal_split[0]
                val m = _kVal_split[1]
                val s = _kVal_split[2]
                return labelFormat.value.replace("{H}", h).replace("{m}", m).replace("{s}", s)
            }
            )
            fun gen_onChange_fn(a: UTSArray<Number>) {
                val b = indexes.value.slice()
                run {
                    var i: Number = 0
                    while(i < a.length){
                        if (b[i] != a[i]) {
                            b[i] = a[i]
                        }
                        i++
                    }
                }
                indexes.value = b
                value.value = b.map(fun(e, i): String {
                    return list.value[i][e].value as String
                }
                )
            }
            val onChange = ::gen_onChange_fn
            val visible = ref(false)
            var callback: ((value: String) -> Unit)? = null
            fun open(cb: ((value: String) -> Unit)? = null) {
                if (props.disabled) {
                    return
                }
                visible.value = true
                callback = cb
            }
            fun gen_close_fn() {
                visible.value = false
            }
            val close = ::gen_close_fn
            fun gen_clear_fn() {
                emit("update:modelValue", "")
                emit("change", "")
            }
            val clear = ::gen_clear_fn
            fun gen_confirm_fn() {
                val kVal = value.value.join(":")
                emit("update:modelValue", kVal)
                emit("change", kVal)
                if (callback != null) {
                    callback!!(kVal)
                }
                close()
            }
            val confirm = ::gen_confirm_fn
            watch(computed(fun(): String {
                return props.modelValue
            }
            ), fun(kVal: String){
                var _value: UTSArray<String>
                if (isEmpty(kVal) || isNull(kVal)) {
                    _value = _uA()
                } else {
                    _value = kVal.split(":")
                }
                var _indexes = _uA<Number>()
                run {
                    var i: Number = 0
                    while(i < 3){
                        if (i >= _value.length) {
                            _indexes.push(0)
                            _value.push(list.value[i][0].value as String)
                        } else {
                            var index = list.value[i].findIndex(fun(e): Boolean {
                                return e.value == _value[i]
                            }
                            )
                            if (index < 0) {
                                index = 0
                            }
                            _indexes.push(index)
                        }
                        i++
                    }
                }
                value.value = _value
                indexes.value = _indexes
            }
            , WatchOptions(immediate = true))
            __expose(_uM("open" to ::open, "close" to close))
            return fun(): Any? {
                val _component_cl_select_trigger = resolveEasyComponent("cl-select-trigger", GenUniModulesCoolUiComponentsClSelectTriggerClSelectTriggerClass)
                val _component_cl_picker_view = resolveEasyComponent("cl-picker-view", GenUniModulesCoolUiComponentsClPickerViewClPickerViewClass)
                val _component_cl_button = resolveEasyComponent("cl-button", GenUniModulesCoolUiComponentsClButtonClButtonClass)
                val _component_cl_popup = resolveEasyComponent("cl-popup", GenUniModulesCoolUiComponentsClPopupClPopupClass)
                return _cE(Fragment, null, _uA(
                    if (isTrue(_ctx.showTrigger)) {
                        _cV(_component_cl_select_trigger, _uM("key" to 0, "pt" to object : UTSJSONObject() {
                            var className = pt.value.trigger?.className
                            var icon = pt.value.trigger?.icon
                        }, "placeholder" to _ctx.placeholder, "disabled" to _ctx.disabled, "focus" to popupRef.value?.isOpen, "text" to text.value, "arrow-icon" to "time-line", "onOpen" to fun(){
                            open()
                        }, "onClear" to clear), null, 8, _uA(
                            "pt",
                            "placeholder",
                            "disabled",
                            "focus",
                            "text",
                            "onOpen"
                        ))
                    } else {
                        _cC("v-if", true)
                    }
                    ,
                    _cV(_component_cl_popup, _uM("ref_key" to "popupRef", "ref" to popupRef, "modelValue" to visible.value, "onUpdate:modelValue" to fun(`$event`: Boolean){
                        visible.value = `$event`
                    }
                    , "title" to _ctx.title, "pt" to object : UTSJSONObject() {
                        var className = pt.value.popup?.className
                        var header = pt.value.popup?.header
                        var container = pt.value.popup?.container
                        var mask = pt.value.popup?.mask
                        var draw = pt.value.popup?.draw
                    }), _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                        return _uA(
                            _cE("view", _uM("class" to "cl-select-popup", "onTouchmove" to withModifiers(fun(){}, _uA(
                                "stop"
                            ))), _uA(
                                _cE("view", _uM("class" to "cl-select-popup__picker"), _uA(
                                    _cV(_component_cl_picker_view, _uM("value" to indexes.value, "headers" to _ctx.headers, "columns" to columns.value, "reset-on-change" to false, "onChangeIndex" to onChange), null, 8, _uA(
                                        "value",
                                        "headers",
                                        "columns"
                                    ))
                                )),
                                _cE("view", _uM("class" to "cl-select-popup__op"), _uA(
                                    if (isTrue(_ctx.showCancel)) {
                                        _cV(_component_cl_button, _uM("key" to 0, "size" to "large", "text" to "", "border" to "", "type" to "light", "pt" to object : UTSJSONObject() {
                                            var className = "flex-1 -important-rounded-xl h--bracket-start-80rpx-bracket-end-"
                                        }, "onClick" to close), _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                                            return _uA(
                                                _tD(_ctx.cancelText)
                                            )
                                        }), "_" to 1))
                                    } else {
                                        _cC("v-if", true)
                                    }
                                    ,
                                    if (isTrue(_ctx.showConfirm)) {
                                        _cV(_component_cl_button, _uM("key" to 1, "size" to "large", "pt" to object : UTSJSONObject() {
                                            var className = "flex-1 -important-rounded-xl h--bracket-start-80rpx-bracket-end-"
                                        }, "onClick" to confirm), _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                                            return _uA(
                                                _tD(_ctx.confirmText)
                                            )
                                        }), "_" to 1))
                                    } else {
                                        _cC("v-if", true)
                                    }
                                ))
                            ), 40, _uA(
                                "onTouchmove"
                            ))
                        )
                    }
                    ), "_" to 1), 8, _uA(
                        "modelValue",
                        "onUpdate:modelValue",
                        "title",
                        "pt"
                    ))
                ), 64)
            }
        }
        var name = "cl-select-time"
        val styles: Map<String, Map<String, Map<String, Any>>> by lazy {
            _nCS(_uA(
                styles0
            ))
        }
        val styles0: Map<String, Map<String, Map<String, Any>>>
            get() {
                return _uM("cl-select-popup__op" to _pS(_uM("display" to "flex", "flexDirection" to "row", "alignItems" to "center", "justifyContent" to "center", "paddingTop" to "24rpx", "paddingRight" to "24rpx", "paddingBottom" to "24rpx", "paddingLeft" to "24rpx")))
            }
        var inheritAttrs = true
        var inject: Map<String, Map<String, Any?>> = _uM()
        var emits: Map<String, Any?> = _uM("update:modelValue" to null, "change" to null)
        var props = _nP(_uM("pt" to _uM("default" to fun(): UTSJSONObject {
            return (UTSJSONObject())
        }
        ), "modelValue" to _uM("type" to "String", "default" to ""), "headers" to _uM("type" to "Array", "default" to fun(): UTSArray<String> {
            return _uA(
                t("小时"),
                t("分钟"),
                t("秒数")
            )
        }
        ), "type" to _uM("type" to "String", "default" to "second"), "title" to _uM("type" to "String", "default" to fun(): String {
            return t("请选择")
        }
        ), "placeholder" to _uM("type" to "String", "default" to fun(): String {
            return t("请选择")
        }
        ), "showTrigger" to _uM("type" to "Boolean", "default" to true), "disabled" to _uM("type" to "Boolean", "default" to false), "confirmText" to _uM("type" to "String", "default" to fun(): String {
            return t("确定")
        }
        ), "showConfirm" to _uM("type" to "Boolean", "default" to true), "cancelText" to _uM("type" to "String", "default" to fun(): String {
            return t("取消")
        }
        ), "showCancel" to _uM("type" to "Boolean", "default" to true), "labelFormat" to _uM("type" to "String", "default" to null)))
        var propsNeedCastKeys = _uA(
            "pt",
            "modelValue",
            "headers",
            "type",
            "title",
            "placeholder",
            "showTrigger",
            "disabled",
            "confirmText",
            "showConfirm",
            "cancelText",
            "showCancel",
            "labelFormat"
        )
        var components: Map<String, CreateVueComponent> = _uM()
    }
}
