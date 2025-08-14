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
import io.dcloud.uniapp.extapi.createSelectorQuery as uni_createSelectorQuery
open class GenUniModulesCoolUiComponentsClSliderClSlider : VueComponent {
    constructor(__ins: ComponentInternalInstance) : super(__ins) {}
    open var pt: Any by `$props`
    open var modelValue: Number by `$props`
    open var values: UTSArray<Number> by `$props`
    open var min: Number by `$props`
    open var max: Number by `$props`
    open var step: Number by `$props`
    open var disabled: Boolean by `$props`
    open var blockSize: Number by `$props`
    open var trackHeight: Number by `$props`
    open var showValue: Boolean by `$props`
    open var range: Boolean by `$props`
    companion object {
        @Suppress("UNUSED_PARAMETER", "UNUSED_VARIABLE")
        var setup: (__props: GenUniModulesCoolUiComponentsClSliderClSlider) -> Any? = fun(__props): Any? {
            val __ins = getCurrentInstance()!!
            val _ctx = __ins.proxy as GenUniModulesCoolUiComponentsClSliderClSlider
            val _cache = __ins.renderCache
            val props = __props
            fun emit(event: String, vararg do_not_transform_spread: Any?) {
                __ins.emit(event, *do_not_transform_spread)
            }
            val proxy = getCurrentInstance()!!.proxy
            val pt = computed(fun(): PassThrough33 {
                return parsePt<PassThrough33>(props.pt)
            }
            )
            val disabled = useForm().disabled
            val isDisabled = computed(fun(): Boolean {
                return props.disabled || disabled.value
            }
            )
            val value = ref<Number>(props.modelValue)
            val rangeValue = ref<UTSArray<Number>>(props.values.slice())
            val trackWidth = ref<Number>(0)
            val trackLeft = ref<Number>(0)
            val activeThumbIndex = ref<Number>(0)
            val percentage = computed(fun(): Number {
                if (props.range) {
                    return 0
                }
                return ((value.value - props.min) / (props.max - props.min)) * 100
            }
            )
            val rangePercentage = computed<RangePercentage>(fun(): RangePercentage {
                if (!props.range) {
                    return RangePercentage(min = 0, max = 0)
                }
                val currentValues = rangeValue.value
                val valueRange = props.max - props.min
                val minPercent = ((currentValues[0] - props.min) / valueRange) * 100
                val maxPercent = ((currentValues[1] - props.min) / valueRange) * 100
                return RangePercentage(min = minPercent, max = maxPercent)
            }
            )
            val progressStyle = computed(fun(): UTSJSONObject {
                val style: UTSJSONObject = UTSJSONObject()
                if (props.range) {
                    val _rangePercentage_value = rangePercentage.value
                    val min = _rangePercentage_value.min
                    val max = _rangePercentage_value.max
                    style["left"] = "" + min + "%"
                    style["width"] = "" + (max - min) + "%"
                } else {
                    style["width"] = "" + percentage.value + "%"
                }
                return style
            }
            )
            fun gen_createThumbStyle_fn(percentPosition: Number): UTSJSONObject {
                val style: UTSJSONObject = UTSJSONObject()
                val effectiveTrackWidth = trackWidth.value - rpx2px(props.blockSize) + 1
                val leftPosition = (percentPosition / 100) * effectiveTrackWidth
                val finalLeftPosition = Math.max(0, Math.min(effectiveTrackWidth, leftPosition))
                style["left"] = "" + finalLeftPosition + "px"
                style["width"] = "" + rpx2px(props.blockSize) + "px"
                style["height"] = "" + rpx2px(props.blockSize) + "px"
                return style
            }
            val createThumbStyle = ::gen_createThumbStyle_fn
            val singleThumbStyle = computed(fun(): UTSJSONObject {
                return createThumbStyle(percentage.value)
            }
            )
            val minThumbStyle = computed(fun(): UTSJSONObject {
                return createThumbStyle(rangePercentage.value.min)
            }
            )
            val maxThumbStyle = computed(fun(): UTSJSONObject {
                return createThumbStyle(rangePercentage.value.max)
            }
            )
            val displayValue = computed<String>(fun(): String {
                if (props.range) {
                    val currentValues = rangeValue.value
                    return "" + currentValues[0] + " - " + currentValues[1]
                }
                return "" + value.value
            }
            )
            fun gen_getTrackInfo_fn(): UTSPromise<Unit> {
                return UTSPromise(fun(resolve, _reject){
                    uni_createSelectorQuery().`in`(proxy).select(".cl-slider__track").boundingClientRect(fun(node){
                        trackWidth.value = (node as NodeInfo).width ?: 0
                        trackLeft.value = (node as NodeInfo).left ?: 0
                        resolve(Unit)
                    }
                    ).exec()
                }
                )
            }
            val getTrackInfo = ::gen_getTrackInfo_fn
            fun gen_calculateValue_fn(clientX: Number): Number {
                if (trackWidth.value == 0) {
                    return props.min
                }
                val touchOffset = clientX - trackLeft.value
                val progressPercentage = Math.max(0, Math.min(1, touchOffset / trackWidth.value))
                val valueRange = props.max - props.min
                var calculatedValue = props.min + progressPercentage * valueRange
                if (props.step > 0) {
                    calculatedValue = Math.round((calculatedValue - props.min) / props.step) * props.step + props.min
                }
                return Math.max(props.min, Math.min(props.max, calculatedValue))
            }
            val calculateValue = ::gen_calculateValue_fn
            fun gen_determineActiveThumb_fn(clientX: Number): Number {
                if (!props.range) {
                    return 0
                }
                val currentValues = rangeValue.value
                val touchValue = calculateValue(clientX)
                val distanceToMinThumb = Math.abs(touchValue - currentValues[0])
                val distanceToMaxThumb = Math.abs(touchValue - currentValues[1])
                return if (distanceToMinThumb <= distanceToMaxThumb) {
                    0
                } else {
                    1
                }
            }
            val determineActiveThumb = ::gen_determineActiveThumb_fn
            fun updateValue(newValue: Any) {
                if (props.range) {
                    val newRangeValues = newValue as UTSArray<Number>
                    val currentRangeValues = rangeValue.value
                    if (newRangeValues[0] > newRangeValues[1]) {
                        activeThumbIndex.value = 1 - activeThumbIndex.value
                    }
                    val sortedValues = _uA(
                        Math.min(newRangeValues[0], newRangeValues[1]),
                        Math.max(newRangeValues[0], newRangeValues[1])
                    )
                    if (JSON.stringify(currentRangeValues) !== JSON.stringify(sortedValues)) {
                        rangeValue.value = sortedValues
                        emit("update:values", sortedValues)
                        emit("changing", sortedValues)
                    }
                } else {
                    val newSingleValue = newValue as Number
                    val currentSingleValue = value.value
                    if (currentSingleValue !== newSingleValue) {
                        value.value = newSingleValue
                        emit("update:modelValue", newSingleValue)
                        emit("changing", newSingleValue)
                    }
                }
            }
            fun gen_onTouchStart_fn(e: TouchEvent): UTSPromise<Unit> {
                return wrapUTSPromise(suspend w@{
                        if (isDisabled.value) {
                            return@w
                        }
                        await(getTrackInfo())
                        nextTick(fun(){
                            val clientX = e.touches[0].clientX
                            val calculatedValue = calculateValue(clientX)
                            if (props.range) {
                                activeThumbIndex.value = determineActiveThumb(clientX)
                                val updatedValues = rangeValue.value.slice()
                                updatedValues[activeThumbIndex.value] = calculatedValue
                                updateValue(updatedValues)
                            } else {
                                updateValue(calculatedValue)
                            }
                        }
                        )
                })
            }
            val onTouchStart = ::gen_onTouchStart_fn
            fun gen_onTouchMove_fn(e: TouchEvent) {
                if (isDisabled.value) {
                    return
                }
                val clientX = e.touches[0].clientX
                val calculatedValue = calculateValue(clientX)
                if (props.range) {
                    val updatedValues = rangeValue.value.slice()
                    updatedValues[activeThumbIndex.value] = calculatedValue
                    updateValue(updatedValues)
                } else {
                    updateValue(calculatedValue)
                }
            }
            val onTouchMove = ::gen_onTouchMove_fn
            fun gen_onTouchEnd_fn() {
                if (isDisabled.value) {
                    return
                }
                if (props.range) {
                    emit("change", rangeValue.value)
                } else {
                    emit("change", value.value)
                }
            }
            val onTouchEnd = ::gen_onTouchEnd_fn
            watch(computed(fun(): Number {
                return props.modelValue
            }
            ), fun(newModelValue: Number){
                if (newModelValue !== value.value) {
                    value.value = Math.max(props.min, Math.min(props.max, newModelValue))
                }
            }
            , WatchOptions(immediate = true))
            watch(computed(fun(): UTSArray<Number> {
                return props.values
            }
            ), fun(newValues: UTSArray<Number>){
                rangeValue.value = newValues.map(fun(singleValue): Number {
                    return Math.max(props.min, Math.min(props.max, singleValue))
                }
                )
            }
            , WatchOptions(immediate = true))
            watch(computed(fun(): Number {
                return props.max
            }
            ), fun(newMaxValue: Number){
                if (props.range) {
                    val currentRangeValues = rangeValue.value
                    if (currentRangeValues[0] > newMaxValue || currentRangeValues[1] > newMaxValue) {
                        updateValue(_uA(
                            Math.min(currentRangeValues[0], newMaxValue),
                            Math.min(currentRangeValues[1], newMaxValue)
                        ))
                    }
                } else {
                    val currentSingleValue = value.value
                    if (currentSingleValue > newMaxValue) {
                        updateValue(newMaxValue)
                    }
                }
            }
            , WatchOptions(immediate = true))
            watch(computed(fun(): Number {
                return props.min
            }
            ), fun(newMinValue: Number){
                if (props.range) {
                    val currentRangeValues = rangeValue.value
                    if (currentRangeValues[0] < newMinValue || currentRangeValues[1] < newMinValue) {
                        updateValue(_uA(
                            Math.max(currentRangeValues[0], newMinValue),
                            Math.max(currentRangeValues[1], newMinValue)
                        ))
                    }
                } else {
                    val currentSingleValue = value.value
                    if (currentSingleValue < newMinValue) {
                        updateValue(newMinValue)
                    }
                }
            }
            , WatchOptions(immediate = true))
            onMounted(fun(){
                watch(computed(fun(): UTSArray<Boolean> {
                    return _uA(
                        props.showValue
                    )
                }
                ), fun(){
                    nextTick(fun(){
                        getTrackInfo()
                    }
                    )
                }
                )
                getTrackInfo()
            }
            )
            return fun(): Any? {
                val _component_cl_text = resolveEasyComponent("cl-text", GenUniModulesCoolUiComponentsClTextClTextClass)
                return _cE("view", _uM("class" to _nC(_uA(
                    "cl-slider",
                    _uA(
                        _uM<String, Any?>(),
                        _uM("cl-slider--disabled" to isDisabled.value),
                        pt.value.className
                    )
                ))), _uA(
                    _cE("view", _uM("class" to "cl-slider__inner", "style" to _nS(_uM("height" to (_ctx.blockSize + 8 + "rpx")))), _uA(
                        _cE("view", _uM("class" to _nC(_uA(
                            "cl-slider__track",
                            _uA(
                                _uM<String, Any?>(),
                                pt.value.track?.className
                            )
                        )), "style" to _nS(_uM("height" to (_ctx.trackHeight + "rpx")))), _uA(
                            _cE("view", _uM("class" to _nC(_uA(
                                "cl-slider__progress",
                                _uA(
                                    _uM<String, Any?>(),
                                    pt.value.progress?.className
                                )
                            )), "style" to _nS(progressStyle.value)), null, 6),
                            if (isTrue(!_ctx.range)) {
                                _cE("view", _uM("key" to 0, "class" to _nC(_uA(
                                    "cl-slider__thumb",
                                    _uA(
                                        _uM<String, Any?>(),
                                        pt.value.thumb?.className
                                    )
                                )), "style" to _nS(singleThumbStyle.value)), null, 6)
                            } else {
                                _cC("v-if", true)
                            }
                            ,
                            if (isTrue(_ctx.range)) {
                                _cE(Fragment, _uM("key" to 1), _uA(
                                    _cE("view", _uM("class" to _nC(_uA(
                                        "cl-slider__thumb cl-slider__thumb--min",
                                        _uA(
                                            _uM<String, Any?>(),
                                            pt.value.thumb?.className
                                        )
                                    )), "style" to _nS(minThumbStyle.value)), null, 6),
                                    _cE("view", _uM("class" to _nC(_uA(
                                        "cl-slider__thumb cl-slider__thumb--max",
                                        _uA(
                                            _uM<String, Any?>(),
                                            pt.value.thumb?.className
                                        )
                                    )), "style" to _nS(maxThumbStyle.value)), null, 6)
                                ), 64)
                            } else {
                                _cC("v-if", true)
                            }
                        ), 6),
                        _cE("view", _uM("class" to "cl-slider__picker", "style" to _nS(_uM("height" to (_ctx.blockSize * 1.5 + "rpx"))), "onTouchstart" to withModifiers(onTouchStart, _uA(
                            "prevent"
                        )), "onTouchmove" to withModifiers(onTouchMove, _uA(
                            "prevent"
                        )), "onTouchend" to onTouchEnd, "onTouchcancel" to onTouchEnd), null, 36)
                    ), 4),
                    renderSlot(_ctx.`$slots`, "value", _uM("value" to displayValue.value), fun(): UTSArray<Any> {
                        return _uA(
                            if (isTrue(_ctx.showValue)) {
                                _cV(_component_cl_text, _uM("key" to 0, "pt" to object : UTSJSONObject() {
                                    var className = unref(parseClass)(_uA(
                                        "text-center w--bracket-start-100rpx-bracket-end-",
                                        pt.value.value?.className
                                    ))
                                }), _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                                    return _uA(
                                        _tD(displayValue.value)
                                    )
                                }), "_" to 1), 8, _uA(
                                    "pt"
                                ))
                            } else {
                                _cC("v-if", true)
                            }
                        )
                    }
                    )
                ), 2)
            }
        }
        var name = "cl-slider"
        val styles: Map<String, Map<String, Map<String, Any>>> by lazy {
            _nCS(_uA(
                styles0
            ))
        }
        val styles0: Map<String, Map<String, Map<String, Any>>>
            get() {
                return _uM("cl-slider" to _pS(_uM("display" to "flex", "width" to "100%", "flexDirection" to "row", "alignItems" to "center", "overflow" to "visible")), "cl-slider--disabled" to _pS(_uM("opacity" to 0.5)), "cl-slider__inner" to _pS(_uM("position" to "relative", "display" to "flex", "height" to "100%", "flex" to 1, "flexDirection" to "row", "alignItems" to "center", "overflow" to "visible")), "cl-slider__picker" to _pS(_uM("position" to "absolute", "left" to 0, "width" to "100%")), "cl-slider__track" to _pS(_uM("position" to "relative", "width" to "100%", "overflow" to "visible", "borderTopLeftRadius" to 9999, "borderTopRightRadius" to 9999, "borderBottomRightRadius" to 9999, "borderBottomLeftRadius" to 9999, "backgroundColor" to "rgba(228,228,231,1)")), "cl-slider__progress" to _pS(_uM("position" to "absolute", "top" to 0, "height" to "100%", "borderTopLeftRadius" to 9999, "borderTopRightRadius" to 9999, "borderBottomRightRadius" to 9999, "borderBottomLeftRadius" to 9999, "backgroundColor" to "rgba(45,212,191,1)")), "cl-slider__thumb" to _pS(_uM("position" to "absolute", "top" to "50%", "borderTopLeftRadius" to 9999, "borderTopRightRadius" to 9999, "borderBottomRightRadius" to 9999, "borderBottomLeftRadius" to 9999, "borderTopWidth" to "4rpx", "borderRightWidth" to "4rpx", "borderBottomWidth" to "4rpx", "borderLeftWidth" to "4rpx", "borderTopStyle" to "solid", "borderRightStyle" to "solid", "borderBottomStyle" to "solid", "borderLeftStyle" to "solid", "borderTopColor" to "rgba(255,255,255,1)", "borderRightColor" to "rgba(255,255,255,1)", "borderBottomColor" to "rgba(255,255,255,1)", "borderLeftColor" to "rgba(255,255,255,1)", "backgroundColor" to "rgba(20,184,166,1)", "transform" to "translateY(-50%)", "pointerEvents" to "none", "zIndex" to 1, "boxShadow" to "0 0 2rpx 2rpx rgba(100, 100, 100, 0.1)")), "cl-slider__thumb--min" to _pS(_uM("zIndex" to 2)), "cl-slider__thumb--max" to _pS(_uM("zIndex" to 2)))
            }
        var inheritAttrs = true
        var inject: Map<String, Map<String, Any?>> = _uM()
        var emits: Map<String, Any?> = _uM("update:modelValue" to null, "update:values" to null, "change" to null, "changing" to null)
        var props = _nP(_uM("pt" to _uM("default" to fun(): UTSJSONObject {
            return (UTSJSONObject())
        }
        ), "modelValue" to _uM("type" to "Number", "default" to 0), "values" to _uM("type" to "Array", "default" to fun(): UTSArray<Number> {
            return _uA(
                0,
                0
            )
        }
        ), "min" to _uM("type" to "Number", "default" to 0), "max" to _uM("type" to "Number", "default" to 100), "step" to _uM("type" to "Number", "default" to 1), "disabled" to _uM("type" to "Boolean", "default" to false), "blockSize" to _uM("type" to "Number", "default" to 40), "trackHeight" to _uM("type" to "Number", "default" to 8), "showValue" to _uM("type" to "Boolean", "default" to false), "range" to _uM("type" to "Boolean", "default" to false)))
        var propsNeedCastKeys = _uA(
            "pt",
            "modelValue",
            "values",
            "min",
            "max",
            "step",
            "disabled",
            "blockSize",
            "trackHeight",
            "showValue",
            "range"
        )
        var components: Map<String, CreateVueComponent> = _uM()
    }
}
