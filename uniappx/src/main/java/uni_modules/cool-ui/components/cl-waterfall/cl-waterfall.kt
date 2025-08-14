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
open class GenUniModulesCoolUiComponentsClWaterfallClWaterfall : VueComponent {
    constructor(__ins: ComponentInternalInstance) : super(__ins) {}
    open var pt: Any by `$props`
    open var column: Number by `$props`
    open var gutter: Number by `$props`
    open var nodeKey: String by `$props`
    open var append: (data: UTSArray<UTSJSONObject>) -> UTSPromise<Unit>
        get() {
            return unref(this.`$exposed`["append"]) as (data: UTSArray<UTSJSONObject>) -> UTSPromise<Unit>
        }
        set(value) {
            setRefValue(this.`$exposed`, "append", value)
        }
    open var remove: (id: Any) -> Unit
        get() {
            return unref(this.`$exposed`["remove"]) as (id: Any) -> Unit
        }
        set(value) {
            setRefValue(this.`$exposed`, "remove", value)
        }
    open var update: (id: Any, data: UTSJSONObject) -> Unit
        get() {
            return unref(this.`$exposed`["update"]) as (id: Any, data: UTSJSONObject) -> Unit
        }
        set(value) {
            setRefValue(this.`$exposed`, "update", value)
        }
    open var clear: () -> Unit
        get() {
            return unref(this.`$exposed`["clear"]) as () -> Unit
        }
        set(value) {
            setRefValue(this.`$exposed`, "clear", value)
        }
    companion object {
        @Suppress("UNUSED_PARAMETER", "UNUSED_VARIABLE")
        var setup: (__props: GenUniModulesCoolUiComponentsClWaterfallClWaterfall, _arg1: SetupContext) -> Any? = fun(__props, ref1): Any? {
            var __expose = ref1.expose
            val __ins = getCurrentInstance()!!
            val _ctx = __ins.proxy as GenUniModulesCoolUiComponentsClWaterfallClWaterfall
            val _cache = __ins.renderCache
            val props = __props
            val proxy = getCurrentInstance()!!.proxy
            val pt = computed(fun(): PassThrough44 {
                return parsePt<PassThrough44>(props.pt)
            }
            )
            val heights = ref(_uA<Number>())
            val columns = ref(_uA<UTSArray<UTSJSONObject>>())
            fun gen_getHeight_fn(): UTSPromise<Number> {
                return wrapUTSPromise(suspend w@{
                        await(nextTick())
                        return@w UTSPromise(fun(resolve, _reject){
                            uni_createSelectorQuery().`in`(proxy).selectAll(".cl-waterfall__column-inner").boundingClientRect().exec(fun(rect){
                                heights.value = (rect[0] as UTSArray<NodeInfo>).map(fun(e): Number {
                                    return e.height ?: 0
                                }
                                )
                                resolve(1)
                            }
                            )
                        }
                        )
                })
            }
            val getHeight = ::gen_getHeight_fn
            fun gen_append_fn(data: UTSArray<UTSJSONObject>): UTSPromise<Unit> {
                return wrapUTSPromise(suspend {
                        await(getHeight())
                        columns.value[0].push(*data.map(fun(e): UTSJSONObject {
                            return UTSJSONObject.assign<UTSJSONObject>(UTSJSONObject(), e, object : UTSJSONObject() {
                                var isVirtual = true
                            }) as UTSJSONObject
                        }
                        ).toTypedArray())
                        await(nextTick())
                        setTimeout(fun(){
                            uni_createSelectorQuery().`in`(proxy).selectAll(".is-virtual").boundingClientRect().exec(fun(rect){
                                (rect[0] as UTSArray<NodeInfo>).forEach(fun(e, i){
                                    val min = Math.min(*heights.value.toTypedArray())
                                    val index = heights.value.indexOf(min)
                                    columns.value[index].push(data[i])
                                    heights.value[index] += e.height ?: 0
                                    columns.value[0] = columns.value[0].filter(fun(e): Boolean {
                                        return e["isVirtual"] != true
                                    }
                                    )
                                }
                                )
                            }
                            )
                        }
                        , 300)
                })
            }
            val append = ::gen_append_fn
            fun remove(id: Any) {
                columns.value.forEach(fun(column, columnIndex){
                    columns.value[columnIndex] = column.filter(fun(e): Boolean {
                        return e[props.nodeKey] != id
                    }
                    )
                }
                )
            }
            fun update(id: Any, data: UTSJSONObject) {
                columns.value.forEach(fun(column){
                    column.forEach(fun(e){
                        if (e[props.nodeKey] == id) {
                            assign(e, data)
                        }
                    }
                    )
                }
                )
            }
            fun gen_clear_fn() {
                columns.value = _uA()
                run {
                    var i: Number = 0
                    while(i < props.column){
                        columns.value.push(_uA())
                        i++
                    }
                }
            }
            val clear = ::gen_clear_fn
            onMounted(fun(){
                watch(computed(fun(): Number {
                    return props.column
                }
                ), fun(){
                    clear()
                    getHeight()
                }
                , WatchOptions(immediate = true))
            }
            )
            __expose(_uM("append" to append, "remove" to ::remove, "update" to ::update, "clear" to clear))
            return fun(): Any? {
                return _cE("view", _uM("class" to _nC(_uA(
                    "cl-waterfall",
                    _uA(
                        _uM<String, Any?>(),
                        pt.value.classNames
                    )
                )), "style" to _nS(_uM("padding" to ("0 " + props.gutter / 2 + "rpx")))), _uA(
                    _cE(Fragment, null, RenderHelpers.renderList(columns.value, fun(column, columnIndex, __index, _cached): Any {
                        return _cE("view", _uM("class" to "cl-waterfall__column", "key" to columnIndex, "style" to _nS(_uM("margin" to ("0 " + props.gutter / 2 + "rpx")))), _uA(
                            _cE("view", _uM("class" to "cl-waterfall__column-inner"), _uA(
                                _cE(Fragment, null, RenderHelpers.renderList(column, fun(item, index, __index, _cached): Any {
                                    return _cE("view", _uM("key" to ("" + columnIndex + "-" + index + "-" + item[props.nodeKey]), "class" to _nC(_uA(
                                        "cl-waterfall__item",
                                        _uM("is-virtual" to item["isVirtual"])
                                    ))), _uA(
                                        renderSlot(_ctx.`$slots`, "item", GenUniModulesCoolUiComponentsClWaterfallClWaterfallSlotDataItem(item = item, index = index))
                                    ), 2)
                                }
                                ), 128)
                            ))
                        ), 4)
                    }
                    ), 128)
                ), 6)
            }
        }
        var name = "cl-waterfall"
        val styles: Map<String, Map<String, Map<String, Any>>> by lazy {
            _nCS(_uA(
                styles0
            ))
        }
        val styles0: Map<String, Map<String, Map<String, Any>>>
            get() {
                return _uM("cl-waterfall" to _pS(_uM("position" to "relative", "display" to "flex", "width" to "100%", "flexDirection" to "row")), "cl-waterfall__column" to _pS(_uM("flex" to 1)), "cl-waterfall__item" to _uM(".is-virtual" to _uM("position" to "absolute", "top" to 0, "width" to "100%", "left" to "-100%", "opacity" to 0)))
            }
        var inheritAttrs = true
        var inject: Map<String, Map<String, Any?>> = _uM()
        var emits: Map<String, Any?> = _uM()
        var props = _nP(_uM("pt" to _uM("default" to fun(): UTSJSONObject {
            return (UTSJSONObject())
        }
        ), "column" to _uM("type" to "Number", "default" to 2), "gutter" to _uM("type" to "Number", "default" to 12), "nodeKey" to _uM("type" to "String", "default" to "id")))
        var propsNeedCastKeys = _uA(
            "pt",
            "column",
            "gutter",
            "nodeKey"
        )
        var components: Map<String, CreateVueComponent> = _uM()
    }
}
