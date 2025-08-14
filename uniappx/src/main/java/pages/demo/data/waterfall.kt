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
open class GenPagesDemoDataWaterfall : BasePage {
    constructor(__ins: ComponentInternalInstance, __renderer: String?) : super(__ins, __renderer) {
        onPageScroll(fun(e: OnPageScrollOptions) {
            scroller.emit(e.scrollTop)
        }
        , __ins)
        onPageShow(fun() {}, __ins)
    }
    companion object {
        @Suppress("UNUSED_PARAMETER", "UNUSED_VARIABLE")
        var setup: (__props: GenPagesDemoDataWaterfall) -> Any? = fun(__props): Any? {
            val __ins = getCurrentInstance()!!
            val _ctx = __ins.proxy as GenPagesDemoDataWaterfall
            val _cache = __ins.renderCache
            val waterfallRef = ref<ClWaterfallComponentPublicInstance?>(null)
            val loading = ref(false)
            var id: Number = 0
            fun gen_refresh_fn() {
                val items = _uA<UTSJSONObject>(object : UTSJSONObject() {
                    var id = id++
                    var likeCount = random(100, 1000)
                    var title = "春日樱花盛开时节，粉色花瓣如诗如画般飘洒"
                    var image = "https://unix.cool-js.com/images/demo/1.jpg"
                }, object : UTSJSONObject() {
                    var id = id++
                    var likeCount = random(100, 1000)
                    var title = "夕阳西下的海滩边，金色阳光温柔地洒在波光粼粼的海面上，构成令人心旷神怡的日落美景"
                    var image = "https://unix.cool-js.com/images/demo/2.jpg"
                }, object : UTSJSONObject() {
                    var id = id++
                    var likeCount = random(100, 1000)
                    var title = "寒冬腊月时分，洁白雪花纷纷扬扬地覆盖着整个世界，感受冬日的宁静与美好"
                    var image = "https://unix.cool-js.com/images/demo/3.jpg"
                }, object : UTSJSONObject() {
                    var id = id++
                    var image = "https://unix.cool-js.com/images/demo/4.jpg"
                    var isAd = true
                }, object : UTSJSONObject() {
                    var id = id++
                    var likeCount = random(100, 1000)
                    var title = "都市夜景霓虹闪烁，五彩斑斓光芒照亮城市营造梦幻般景象"
                    var image = "https://unix.cool-js.com/images/demo/5.jpg"
                }, object : UTSJSONObject() {
                    var id = id++
                    var likeCount = random(100, 1000)
                    var title = "云雾缭绕的山间风光如诗如画让人心旷神怡，微风轻抚树梢带来阵阵清香，鸟儿在林间自由歌唱"
                    var image = "https://unix.cool-js.com/images/demo/6.jpg"
                }, object : UTSJSONObject() {
                    var id = id++
                    var likeCount = random(100, 1000)
                    var title = "古老建筑与现代摩天大楼交相辉映，传统与现代完美融合创造独特城市景观"
                    var image = "https://unix.cool-js.com/images/demo/7.jpg"
                }, object : UTSJSONObject() {
                    var id = id++
                    var likeCount = random(100, 1000)
                    var title = "广袤田野绿意盎然风光无限，金黄麦浪在微风中轻柔摇曳，农家炊烟袅袅升起"
                    var image = "https://unix.cool-js.com/images/demo/8.jpg"
                }, object : UTSJSONObject() {
                    var id = id++
                    var likeCount = random(100, 1000)
                    var title = "璀璨星空下银河横跨天际，繁星闪烁神秘光芒营造浪漫夜空美景"
                    var image = "https://unix.cool-js.com/images/demo/9.jpg"
                }, object : UTSJSONObject() {
                    var id = id++
                    var likeCount = random(100, 1000)
                    var title = "雄伟瀑布从高耸悬崖飞流直下激起千层浪花，彩虹在水雾中若隐若现如梦如幻"
                    var image = "https://unix.cool-js.com/images/demo/10.jpg"
                })
                waterfallRef.value!!.append(items)
            }
            val refresh = ::gen_refresh_fn
            fun gen_del_fn(id: Number) {
                waterfallRef.value!!.remove(id)
            }
            val del = ::gen_del_fn
            onReachBottom(fun(){
                if (loading.value) {
                    return
                }
                loading.value = true
                setTimeout(fun(){
                    refresh()
                    loading.value = false
                }
                , 1000)
            }
            )
            onMounted(fun(){
                refresh()
            }
            )
            return fun(): Any? {
                val _component_cl_tag = resolveEasyComponent("cl-tag", GenUniModulesCoolUiComponentsClTagClTagClass)
                val _component_cl_icon = resolveEasyComponent("cl-icon", GenUniModulesCoolUiComponentsClIconClIconClass)
                val _component_cl_text = resolveEasyComponent("cl-text", GenUniModulesCoolUiComponentsClTextClTextClass)
                val _component_cl_row = resolveEasyComponent("cl-row", GenUniModulesCoolUiComponentsClRowClRowClass)
                val _component_cl_waterfall = resolveEasyComponent("cl-waterfall", GenUniModulesCoolUiComponentsClWaterfallClWaterfallClass)
                val _component_cl_loadmore = resolveEasyComponent("cl-loadmore", GenUniModulesCoolUiComponentsClLoadmoreClLoadmoreClass)
                val _component_cl_page = resolveEasyComponent("cl-page", GenUniModulesCoolUiComponentsClPageClPageClass)
                return _cV(_component_cl_page, _uM("back-top" to ""), _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                    return _uA(
                        _cE("view", _uM("class" to "py-2"), _uA(
                            _cV(_component_cl_waterfall, _uM("ref_key" to "waterfallRef", "ref" to waterfallRef, "column" to 2, "gutter" to 16), _uM("item" to withScopedSlotCtx(fun(slotProps: GenUniModulesCoolUiComponentsClWaterfallClWaterfallSlotDataItem): UTSArray<Any> {
                                val item = slotProps.item
                                val index = slotProps.index
                                return _uA(
                                    _cE("view", _uM("class" to _nC(_uA(
                                        "bg-white mb-3 rounded-xl relative",
                                        _uM("dark-colon--important-bg-gray-800" to unref(isDark))
                                    ))), _uA(
                                        _cE("image", _uM("src" to item["image"], "mode" to "widthFix", "class" to "w-full rounded-xl"), null, 8, _uA(
                                            "src"
                                        )),
                                        if (isTrue(item["isAd"])) {
                                            _cE(Fragment, _uM("key" to 0), _uA(
                                                _cV(_component_cl_tag, _uM("pt" to object : UTSJSONObject() {
                                                    var className = "absolute left-1 top-1 scale-75"
                                                }), _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                                                    return _uA(
                                                        "广告"
                                                    )
                                                }), "_" to 1)),
                                                _cV(_component_cl_icon, _uM("color" to "white", "name" to "close-line", "pt" to object : UTSJSONObject() {
                                                    var className = "absolute right-2 top-2"
                                                }, "onClick" to fun(){
                                                    del(item["id"] as Number)
                                                }), null, 8, _uA(
                                                    "onClick"
                                                ))
                                            ), 64)
                                        } else {
                                            _cE("view", _uM("key" to 1, "class" to "p-3"), _uA(
                                                _cV(_component_cl_text, null, _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                                                    return _uA(
                                                        _tD(item["title"])
                                                    )
                                                }
                                                ), "_" to 2), 1024),
                                                _cV(_component_cl_row, _uM("class" to "mt-2", "pt" to object : UTSJSONObject() {
                                                    var className = "justify-end items-center"
                                                }), _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                                                    return _uA(
                                                        _cV(_component_cl_icon, _uM("name" to "heart-line")),
                                                        _cV(_component_cl_text, _uM("pt" to object : UTSJSONObject() {
                                                            var className = "-important-text-sm ml-1"
                                                        }), _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                                                            return _uA(
                                                                _tD(item["likeCount"])
                                                            )
                                                        }
                                                        ), "_" to 2), 1024)
                                                    )
                                                }
                                                ), "_" to 2), 1024)
                                            ))
                                        }
                                    ), 2)
                                )
                            }
                            ), "_" to 1), 512),
                            _cV(_component_cl_loadmore, _uM("loading" to true))
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
