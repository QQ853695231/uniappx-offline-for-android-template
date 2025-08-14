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
open class GenPagesDemoDataListView : BasePage {
    constructor(__ins: ComponentInternalInstance, __renderer: String?) : super(__ins, __renderer) {
        onPageScroll(fun(e: OnPageScrollOptions) {
            scroller.emit(e.scrollTop)
        }
        , __ins)
        onPageShow(fun() {}, __ins)
    }
    companion object {
        @Suppress("UNUSED_PARAMETER", "UNUSED_VARIABLE")
        var setup: (__props: GenPagesDemoDataListView) -> Any? = fun(__props): Any? {
            val __ins = getCurrentInstance()!!
            val _ctx = __ins.proxy as GenPagesDemoDataListView
            val _cache = __ins.renderCache
            val ui = useUi()
            val data = ref(_uA<ClListViewItem>())
            onReady(fun(){
                ui.showLoading()
                request<UTSArray<UTSJSONObject>>(RequestOptions1(url = "https://unix.cool-js.com/data/pca_flat.json")).then(fun(res){
                    data.value = useListView(res)
                }
                ).`catch`(fun(err){
                    console.error(err)
                }
                ).`finally`(fun(){
                    ui.hideLoading()
                }
                )
            }
            )
            return fun(): Any? {
                val _component_cl_text = resolveEasyComponent("cl-text", GenUniModulesCoolUiComponentsClTextClTextClass)
                val _component_cl_list_view = resolveEasyComponent("cl-list-view", GenUniModulesCoolUiComponentsClListViewClListViewClass)
                val _component_cl_page = resolveEasyComponent("cl-page", GenUniModulesCoolUiComponentsClPageClPageClass)
                return _cV(_component_cl_page, null, _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                    return _uA(
                        _cE("view", _uM("class" to "page"), _uA(
                            _cE("view", _uM("class" to "p-3 pb-0"), _uA(
                                _cV(unref(GenPagesDemoComponentsItemClass), null, _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                                    return _uA(
                                        _cV(_component_cl_text, null, _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                                            return _uA(
                                                "采用虚拟列表技术实现高性能渲染，支持海量数据无限滚动，当前演示数据规模：" + _tD(data.value.length) + "条"
                                            )
                                        }
                                        ), "_" to 1))
                                    )
                                }
                                ), "_" to 1))
                            )),
                            _cE("view", _uM("class" to "list"), _uA(
                                _cV(_component_cl_list_view, _uM("data" to data.value, "pt" to object : UTSJSONObject() {
                                    var indexBar = object : UTSJSONObject() {
                                        var className = "-important-fixed"
                                    }
                                    var itemHover = object : UTSJSONObject() {
                                        var className = "bg-gray-200"
                                    }
                                }), null, 8, _uA(
                                    "data"
                                ))
                            ))
                        ))
                    )
                }
                ), "_" to 1))
            }
        }
        val styles: Map<String, Map<String, Map<String, Any>>> by lazy {
            _nCS(_uA(
                styles0
            ), _uA(
                GenApp.styles
            ))
        }
        val styles0: Map<String, Map<String, Map<String, Any>>>
            get() {
                return _uM("page" to _pS(_uM("height" to "100%")), "list" to _uM(".page " to _uM("flex" to 1)))
            }
        var inheritAttrs = true
        var inject: Map<String, Map<String, Any?>> = _uM()
        var emits: Map<String, Any?> = _uM()
        var props = _nP(_uM())
        var propsNeedCastKeys: UTSArray<String> = _uA()
        var components: Map<String, CreateVueComponent> = _uM()
    }
}
