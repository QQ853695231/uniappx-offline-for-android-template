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
open class GenPagesDemoDataListViewRefresh : BasePage {
    constructor(__ins: ComponentInternalInstance, __renderer: String?) : super(__ins, __renderer) {
        onPageScroll(fun(e: OnPageScrollOptions) {
            scroller.emit(e.scrollTop)
        }
        , __ins)
        onPageShow(fun() {}, __ins)
    }
    companion object {
        @Suppress("UNUSED_PARAMETER", "UNUSED_VARIABLE")
        var setup: (__props: GenPagesDemoDataListViewRefresh) -> Any? = fun(__props): Any? {
            val __ins = getCurrentInstance()!!
            val _ctx = __ins.proxy as GenPagesDemoDataListViewRefresh
            val _cache = __ins.renderCache
            val ui = useUi()
            val listViewRef = ref<ClListViewComponentPublicInstance?>(null)
            var id: Number = 0
            val _usePager = usePager(fun(params): UTSPromise<UTSJSONObject> {
                return UTSPromise(fun(resolve, _reject){
                    setTimeout(fun(){
                        resolve(object : UTSJSONObject() {
                            var list = _uA(
                                object : UTSJSONObject() {
                                    var id = id++
                                    var title = "春日樱花盛开时节，粉色花瓣如诗如画般飘洒"
                                    var image = "https://unix.cool-js.com/images/demo/1.jpg"
                                },
                                object : UTSJSONObject() {
                                    var id = id++
                                    var title = "夕阳西下的海滩边，金色阳光温柔地洒在波光粼粼的海面上，构成令人心旷神怡的日落美景"
                                    var image = "https://unix.cool-js.com/images/demo/2.jpg"
                                },
                                object : UTSJSONObject() {
                                    var id = id++
                                    var title = "寒冬腊月时分，洁白雪花纷纷扬扬地覆盖着整个世界，感受冬日的宁静与美好"
                                    var image = "https://unix.cool-js.com/images/demo/3.jpg"
                                },
                                object : UTSJSONObject() {
                                    var id = id++
                                    var title = "都市夜景霓虹闪烁，五彩斑斓光芒照亮城市营造梦幻般景象"
                                    var image = "https://unix.cool-js.com/images/demo/5.jpg"
                                },
                                object : UTSJSONObject() {
                                    var id = id++
                                    var title = "云雾缭绕的山间风光如诗如画让人心旷神怡，微风轻抚树梢带来阵阵清香，鸟儿在林间自由歌唱"
                                    var image = "https://unix.cool-js.com/images/demo/6.jpg"
                                },
                                object : UTSJSONObject() {
                                    var id = id++
                                    var title = "古老建筑与现代摩天大楼交相辉映，传统与现代完美融合创造独特城市景观"
                                    var image = "https://unix.cool-js.com/images/demo/7.jpg"
                                },
                                object : UTSJSONObject() {
                                    var id = id++
                                    var title = "广袤田野绿意盎然风光无限，金黄麦浪在微风中轻柔摇曳，农家炊烟袅袅升起"
                                    var image = "https://unix.cool-js.com/images/demo/8.jpg"
                                },
                                object : UTSJSONObject() {
                                    var id = id++
                                    var title = "璀璨星空下银河横跨天际，繁星闪烁神秘光芒营造浪漫夜空美景"
                                    var image = "https://unix.cool-js.com/images/demo/9.jpg"
                                },
                                object : UTSJSONObject() {
                                    var id = id++
                                    var title = "雄伟瀑布从高耸悬崖飞流直下激起千层浪花，彩虹在水雾中若隐若现如梦如幻"
                                    var image = "https://unix.cool-js.com/images/demo/10.jpg"
                                }
                            )
                            var pagination = object : UTSJSONObject() {
                                var page = params["page"]
                                var size = params["size"]
                                var total: Number = 100
                            }
                        })
                        ui.hideLoading()
                    }
                    , 1000)
                }
                )
            }
            )
            val refresh = _usePager.refresh
            val list = _usePager.list
            val listView = _usePager.listView
            val loading = _usePager.loading
            val loadMore = _usePager.loadMore
            fun gen_onPull_fn(): UTSPromise<Unit> {
                return wrapUTSPromise(suspend {
                        await(refresh(object : UTSJSONObject() {
                            var page: Number = 1
                        }))
                        listViewRef.value!!.stopRefresh()
                })
            }
            val onPull = ::gen_onPull_fn
            onReady(fun(){
                ui.showLoading(t("加载中"))
                refresh(UTSJSONObject())
            }
            )
            return fun(): Any? {
                val _component_cl_loadmore = resolveEasyComponent("cl-loadmore", GenUniModulesCoolUiComponentsClLoadmoreClLoadmoreClass)
                val _component_cl_list_view = resolveEasyComponent("cl-list-view", GenUniModulesCoolUiComponentsClListViewClListViewClass)
                val _component_cl_page = resolveEasyComponent("cl-page", GenUniModulesCoolUiComponentsClPageClPageClass)
                return _cV(_component_cl_page, null, _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                    return _uA(
                        _cV(_component_cl_list_view, _uM("ref_key" to "listViewRef", "ref" to listViewRef, "data" to unref(listView), "virtual" to false, "pt" to object : UTSJSONObject() {
                            var refresher = object : UTSJSONObject() {
                                var className = "pt-3"
                            }
                        }, "refresher-enabled" to true, "onPull" to onPull, "onBottom" to unref(loadMore)), _uM("item" to withScopedSlotCtx(fun(slotProps: GenUniModulesCoolUiComponentsClListViewClListViewSlotDataItem): UTSArray<Any> {
                            val value = slotProps.value
                            return _uA(
                                _cV(unref(GenPagesDemoComponentsGoodsItemClass), _uM("value" to value), null, 8, _uA(
                                    "value"
                                ))
                            )
                        }
                        ), "bottom" to withSlotCtx(fun(): UTSArray<Any> {
                            return _uA(
                                _cE("view", _uM("class" to "py-3"), _uA(
                                    if (unref(list).length > 0) {
                                        _cV(_component_cl_loadmore, _uM("key" to 0, "loading" to unref(loading)), null, 8, _uA(
                                            "loading"
                                        ))
                                    } else {
                                        _cC("v-if", true)
                                    }
                                ))
                            )
                        }
                        ), "_" to 1), 8, _uA(
                            "data",
                            "onBottom"
                        ))
                    )
                }
                ), "_" to 1))
            }
        }
        val styles: Map<String, Map<String, Map<String, Any>>> by lazy {
            _nCS(_uA(), _uA(
                GenApp.styles
            ))
        }
        var inheritAttrs = true
        var inject: Map<String, Map<String, Any?>> = _uM()
        var emits: Map<String, Any?> = _uM()
        var props = _nP(_uM())
        var propsNeedCastKeys: UTSArray<String> = _uA()
        var components: Map<String, CreateVueComponent> = _uM()
    }
}
