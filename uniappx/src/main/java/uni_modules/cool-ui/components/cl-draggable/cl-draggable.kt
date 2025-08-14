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
open class GenUniModulesCoolUiComponentsClDraggableClDraggable : VueComponent {
    constructor(__ins: ComponentInternalInstance) : super(__ins) {}
    open var pt: Any by `$props`
    open var modelValue: UTSArray<UTSJSONObject> by `$props`
    open var disabled: Boolean by `$props`
    open var animation: Number by `$props`
    open var columns: Number by `$props`
    companion object {
        @Suppress("UNUSED_PARAMETER", "UNUSED_VARIABLE")
        var setup: (__props: GenUniModulesCoolUiComponentsClDraggableClDraggable) -> Any? = fun(__props): Any? {
            val __ins = getCurrentInstance()!!
            val _ctx = __ins.proxy as GenUniModulesCoolUiComponentsClDraggableClDraggable
            val _cache = __ins.renderCache
            val props = __props
            fun emit(event: String, vararg do_not_transform_spread: Any?) {
                __ins.emit(event, *do_not_transform_spread)
            }
            val proxy = getCurrentInstance()!!.proxy
            val pt = computed(fun(): PassThrough49 {
                return parsePt<PassThrough49>(props.pt)
            }
            )
            val list = ref(_uA<UTSJSONObject>())
            val dragging = ref(false)
            val dragIndex = ref(-1)
            val insertIndex = ref(-1)
            val startY = ref(0)
            val startX = ref(0)
            val offsetY = ref(0)
            val offsetX = ref(0)
            val dragItem = ref(UTSJSONObject())
            val itemPositions = ref(_uA<ItemPosition>())
            val dropping = ref(false)
            val itemHeight = ref(0)
            val itemWidth = ref(0)
            val sortingStarted = ref(false)
            fun gen_reset_fn() {
                dragging.value = false
                dropping.value = false
                dragIndex.value = -1
                insertIndex.value = -1
                offsetX.value = 0
                offsetY.value = 0
                dragItem.value = UTSJSONObject()
                itemPositions.value = _uA()
                itemHeight.value = 0
                itemWidth.value = 0
                sortingStarted.value = false
            }
            val reset = ::gen_reset_fn
            fun gen_calculateGridOffset_fn(index: Number, dragIdx: Number, insertIdx: Number): TranslateOffset {
                val cols = props.columns
                val currentRow = Math.floor(index / cols)
                val currentCol = index % cols
                var newIndex = index
                if (dragIdx < insertIdx) {
                    if (index > dragIdx && index <= insertIdx) {
                        newIndex = index - 1
                    }
                } else if (dragIdx > insertIdx) {
                    if (index >= insertIdx && index < dragIdx) {
                        newIndex = index + 1
                    }
                }
                val newRow = Math.floor(newIndex / cols)
                val newCol = newIndex % cols
                val cellWidth = itemWidth.value
                val cellHeight = itemHeight.value
                val offsetX = (newCol - currentCol) * cellWidth
                val offsetY = (newRow - currentRow) * cellHeight
                return TranslateOffset(x = offsetX, y = offsetY)
            }
            val calculateGridOffset = ::gen_calculateGridOffset_fn
            fun gen_calculateGridInsertIndex_fn(dragCenterX: Number, dragCenterY: Number): Number {
                if (itemPositions.value.length == 0) {
                    return dragIndex.value
                }
                var closestIndex = dragIndex.value
                var minDistance = Infinity
                run {
                    var i: Number = 0
                    while(i < itemPositions.value.length){
                        val position = itemPositions.value[i]
                        val centerX = position.left + position.width / 2
                        val centerY = position.top + position.height / 2
                        val distance = Math.sqrt(Math.pow(dragCenterX - centerX, 2) + Math.pow(dragCenterY - centerY, 2))
                        if (distance < minDistance) {
                            minDistance = distance
                            closestIndex = i
                        }
                        i++
                    }
                }
                return closestIndex
            }
            val calculateGridInsertIndex = ::gen_calculateGridInsertIndex_fn
            fun gen_calculateSingleColumnInsertIndex_fn(clientY: Number): Number {
                var closestIndex = dragIndex.value
                var minDistance = Infinity
                run {
                    var i: Number = 0
                    while(i < itemPositions.value.length){
                        val position = itemPositions.value[i]
                        val itemCenter = position.top + position.height / 2
                        val distance = Math.abs(clientY - itemCenter)
                        if (distance < minDistance) {
                            minDistance = distance
                            closestIndex = i
                        }
                        i++
                    }
                }
                return closestIndex
            }
            val calculateSingleColumnInsertIndex = ::gen_calculateSingleColumnInsertIndex_fn
            fun gen_calculateInsertIndex_fn(clientPosition: Number): Number {
                if (itemPositions.value.length == 0) {
                    return dragIndex.value
                }
                if (props.columns > 1) {
                    val dragPos = itemPositions.value[dragIndex.value]
                    val dragCenterX = dragPos.left + dragPos.width / 2 + offsetX.value
                    val dragCenterY = dragPos.top + dragPos.height / 2 + offsetY.value
                    return calculateGridInsertIndex(dragCenterX, dragCenterY)
                } else {
                    return calculateSingleColumnInsertIndex(clientPosition)
                }
            }
            val calculateInsertIndex = ::gen_calculateInsertIndex_fn
            fun gen_calculateSingleColumnOffset_fn(index: Number, dragIdx: Number, insertIdx: Number): TranslateOffset {
                if (dragIdx < insertIdx) {
                    if (index > dragIdx && index <= insertIdx) {
                        return TranslateOffset(x = 0, y = -itemHeight.value)
                    }
                } else if (dragIdx > insertIdx) {
                    if (index >= insertIdx && index < dragIdx) {
                        return TranslateOffset(x = 0, y = itemHeight.value)
                    }
                }
                return TranslateOffset(x = 0, y = 0)
            }
            val calculateSingleColumnOffset = ::gen_calculateSingleColumnOffset_fn
            fun gen_getItemTranslateOffset_fn(index: Number): TranslateOffset {
                if (!dragging.value || dropping.value || !sortingStarted.value) {
                    return TranslateOffset(x = 0, y = 0)
                }
                val dragIdx = dragIndex.value
                val insertIdx = insertIndex.value
                if (index == dragIdx) {
                    return TranslateOffset(x = 0, y = 0)
                }
                if (dragIdx == insertIdx) {
                    return TranslateOffset(x = 0, y = 0)
                }
                if (props.columns > 1) {
                    return calculateGridOffset(index, dragIdx, insertIdx)
                } else {
                    return calculateSingleColumnOffset(index, dragIdx, insertIdx)
                }
            }
            val getItemTranslateOffset = ::gen_getItemTranslateOffset_fn
            fun gen_getItemStyle_fn(index: Number): UTSJSONObject {
                val style: UTSJSONObject = UTSJSONObject()
                val isCurrent = dragIndex.value == index
                if (props.columns > 1) {
                    val widthPercent = (100 as Number) / props.columns
                    style["flex-basis"] = "" + widthPercent + "%"
                    style["width"] = "" + widthPercent + "%"
                    style["box-sizing"] = "border-box"
                }
                if (dropping.value) {
                    return style
                }
                if (props.animation > 0 && !isCurrent) {
                    style["transition-property"] = "transform"
                    style["transition-duration"] = "" + props.animation + "ms"
                }
                if (dragging.value) {
                    if (isCurrent) {
                        style["transform"] = "translate(" + offsetX.value + "px, " + offsetY.value + "px)"
                        style["z-index"] = "100"
                    } else {
                        val translateOffset = getItemTranslateOffset(index)
                        if (translateOffset.x != 0 || translateOffset.y != 0) {
                            style["transform"] = "translate(" + translateOffset.x + "px, " + translateOffset.y + "px)"
                        }
                    }
                }
                return style
            }
            val getItemStyle = ::gen_getItemStyle_fn
            fun gen_getItemPosition_fn(): UTSPromise<Unit> {
                return wrapUTSPromise(suspend w@{
                        return@w UTSPromise(fun(resolve, _reject){
                            uni_createSelectorQuery().`in`(proxy).select(".cl-draggable").boundingClientRect().exec(fun(res){
                                val box = res[0] as NodeInfo
                                itemWidth.value = (box.width ?: 0) / props.columns
                                uni_createSelectorQuery().`in`(proxy).selectAll(".cl-draggable__item").boundingClientRect().exec(fun(res){
                                    val rects = res[0] as UTSArray<NodeInfo>
                                    val positions: UTSArray<ItemPosition> = _uA()
                                    run {
                                        var i: Number = 0
                                        while(i < rects.length){
                                            val rect = rects[i]
                                            if (i == 0) {
                                                itemHeight.value = rect.height ?: 0
                                            }
                                            positions.push(ItemPosition(top = rect.top ?: 0, left = rect.left ?: 0, width = itemWidth.value, height = itemHeight.value))
                                            i++
                                        }
                                    }
                                    itemPositions.value = positions
                                    resolve(Unit)
                                }
                                )
                            }
                            )
                        }
                        )
                })
            }
            val getItemPosition = ::gen_getItemPosition_fn
            fun gen_getItemDisabled_fn(index: Number): Boolean {
                return !isNull(list.value[index]["disabled"]) && (list.value[index]["disabled"] as Boolean)
            }
            val getItemDisabled = ::gen_getItemDisabled_fn
            fun gen_checkMovedToOtherElement_fn(): Boolean {
                if (itemPositions.value.length == 0) {
                    return false
                }
                val dragIdx = dragIndex.value
                val dragPosition = itemPositions.value[dragIdx]
                val dragCenterX = dragPosition.left + dragPosition.width / 2 + offsetX.value
                val dragCenterY = dragPosition.top + dragPosition.height / 2 + offsetY.value
                if (props.columns > 1) {
                    run {
                        var i: Number = 0
                        while(i < itemPositions.value.length){
                            if (i == dragIdx) {
                                i++
                                continue
                            }
                            val otherPosition = itemPositions.value[i]
                            val isOverlapping = dragCenterX >= otherPosition.left && dragCenterX <= otherPosition.left + otherPosition.width && dragCenterY >= otherPosition.top && dragCenterY <= otherPosition.top + otherPosition.height
                            if (isOverlapping) {
                                return true
                            }
                            i++
                        }
                    }
                } else {
                    if (dragIdx > 0) {
                        val prevPosition = itemPositions.value[dragIdx - 1]
                        val prevCenterY = prevPosition.top + prevPosition.height / 2
                        if (dragCenterY <= prevCenterY) {
                            return true
                        }
                    }
                    if (dragIdx < itemPositions.value.length - 1) {
                        val nextPosition = itemPositions.value[dragIdx + 1]
                        val nextCenterY = nextPosition.top + nextPosition.height / 2
                        if (dragCenterY >= nextCenterY) {
                            return true
                        }
                    }
                }
                return false
            }
            val checkMovedToOtherElement = ::gen_checkMovedToOtherElement_fn
            fun gen_onTouchStart_fn(event: UniTouchEvent, index: Number): UTSPromise<Unit> {
                return wrapUTSPromise(suspend w@{
                        if (props.disabled) {
                            return@w
                        }
                        if (getItemDisabled(index)) {
                            return@w
                        }
                        if (index < 0 || index >= list.value.length) {
                            return@w
                        }
                        val touch = event.touches[0]
                        dragging.value = true
                        dragIndex.value = index
                        insertIndex.value = index
                        startX.value = touch.clientX
                        startY.value = touch.clientY
                        offsetX.value = 0
                        offsetY.value = 0
                        dragItem.value = list.value[index]
                        await(getItemPosition())
                        emit("start", index)
                })
            }
            val onTouchStart = ::gen_onTouchStart_fn
            fun gen_onTouchMove_fn(event: TouchEvent): Unit {
                if (!dragging.value) {
                    return
                }
                val touch = event.touches[0]
                offsetX.value = touch.clientX - startX.value
                offsetY.value = touch.clientY - startY.value
                if (!sortingStarted.value) {
                    if (checkMovedToOtherElement()) {
                        sortingStarted.value = true
                    }
                }
                if (sortingStarted.value) {
                    val dragPos = itemPositions.value[dragIndex.value]
                    val dragCenterX = dragPos.left + dragPos.width / 2 + offsetX.value
                    val dragCenterY = dragPos.top + dragPos.height / 2 + offsetY.value
                    val dragCenter = if (props.columns > 1) {
                        dragCenterX
                    } else {
                        dragCenterY
                    }
                    val newIndex = calculateInsertIndex(dragCenter)
                    if (newIndex != insertIndex.value) {
                        insertIndex.value = newIndex
                    }
                }
                event.preventDefault()
            }
            val onTouchMove = ::gen_onTouchMove_fn
            fun gen_onTouchEnd_fn(): Unit {
                if (!dragging.value) {
                    return
                }
                val oldIndex = dragIndex.value
                val newIndex = insertIndex.value
                if (oldIndex != newIndex && newIndex >= 0) {
                    val newList = list.value.slice()
                    val item = newList.splice(oldIndex, 1)[0]
                    newList.splice(newIndex, 0, item)
                    list.value = newList
                    emit("update:modelValue", list.value)
                    emit("change", list.value)
                }
                dropping.value = true
                dragging.value = false
                offsetX.value = 0
                offsetY.value = 0
                setTimeout(fun(){
                    emit("end", if (newIndex >= 0) {
                        newIndex
                    } else {
                        oldIndex
                    }
                    )
                    reset()
                }
                , 10)
            }
            val onTouchEnd = ::gen_onTouchEnd_fn
            fun gen_getItemKey_fn(item: UTSJSONObject, index: Number): String {
                return item["uid"] as String
            }
            val getItemKey = ::gen_getItemKey_fn
            watch(computed(fun(): UTSArray<UTSJSONObject> {
                return props.modelValue
            }
            ), fun(kVal: UTSArray<UTSJSONObject>){
                list.value = kVal.map(fun(e): UTSJSONObject {
                    return UTSJSONObject.assign(object : UTSJSONObject() {
                        var uid = e["uid"] ?: uuid()
                    }, e)
                }
                )
            }
            , WatchOptions(immediate = true))
            return fun(): Any? {
                return _cE("view", _uM("class" to _nC(_uA(
                    "cl-draggable",
                    _uA(
                        _uM("cl-draggable--grid" to (props.columns > 1)),
                        pt.value.className
                    )
                ))), _uA(
                    _cE(Fragment, null, RenderHelpers.renderList(list.value, fun(item, index, __index, _cached): Any {
                        return _cE("view", _uM("key" to getItemKey(item, index), "class" to _nC(_uA(
                            "cl-draggable__item",
                            _uA(
                                _uM<String, Any?>(),
                                _uM("cl-draggable__item--disabled" to _ctx.disabled),
                                if (dragging.value && dragIndex.value == index) {
                                    "opacity-80 " + pt.value.ghost?.className
                                } else {
                                    ""
                                }
                            )
                        )), "style" to _nS(getItemStyle(index)), "onTouchstart" to fun(event: UniTouchEvent){
                            onTouchStart(event, index)
                        }
                        , "onTouchmove" to withModifiers(onTouchMove, _uA(
                            "stop",
                            "prevent"
                        )), "onTouchend" to onTouchEnd), _uA(
                            renderSlot(_ctx.`$slots`, "item", GenUniModulesCoolUiComponentsClDraggableClDraggableSlotDataItem(item = item, index = index, dragging = dragging.value, dragIndex = dragIndex.value, insertIndex = insertIndex.value))
                        ), 46, _uA(
                            "onTouchstart"
                        ))
                    }
                    ), 128)
                ), 2)
            }
        }
        var name = "cl-draggable"
        val styles: Map<String, Map<String, Map<String, Any>>> by lazy {
            _nCS(_uA(
                styles0
            ))
        }
        val styles0: Map<String, Map<String, Map<String, Any>>>
            get() {
                return _uM("cl-draggable" to _pS(_uM("position" to "relative", "flexDirection" to "column", "overflow" to "visible")), "cl-draggable--grid" to _pS(_uM("flexDirection" to "row", "flexWrap" to "wrap")), "cl-draggable__item" to _pS(_uM("position" to "relative")), "cl-draggable__item--dragging" to _pS(_uM("opacity" to 0.8)), "cl-draggable__item--disabled" to _pS(_uM("opacity" to 0.6)))
            }
        var inheritAttrs = true
        var inject: Map<String, Map<String, Any?>> = _uM()
        var emits: Map<String, Any?> = _uM("update:modelValue" to null, "change" to null, "start" to null, "end" to null)
        var props = _nP(_uM("pt" to _uM("default" to fun(): UTSJSONObject {
            return (UTSJSONObject())
        }
        ), "modelValue" to _uM("type" to "Array", "default" to fun(): UTSArray<Any?> {
            return _uA()
        }
        ), "disabled" to _uM("type" to "Boolean", "default" to false), "animation" to _uM("type" to "Number", "default" to 150), "columns" to _uM("type" to "Number", "default" to 1)))
        var propsNeedCastKeys = _uA(
            "pt",
            "modelValue",
            "disabled",
            "animation",
            "columns"
        )
        var components: Map<String, CreateVueComponent> = _uM()
    }
}
