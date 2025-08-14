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
import uts.sdk.modules.coolOpenWeb.openWeb
import io.dcloud.uniapp.extapi.setNavigationBarTitle as uni_setNavigationBarTitle
open class GenPagesSetAbout : BasePage {
    constructor(__ins: ComponentInternalInstance, __renderer: String?) : super(__ins, __renderer) {
        onPageScroll(fun(e: OnPageScrollOptions) {
            scroller.emit(e.scrollTop)
        }
        , __ins)
        onPageShow(fun() {}, __ins)
    }
    companion object {
        @Suppress("UNUSED_PARAMETER", "UNUSED_VARIABLE")
        var setup: (__props: GenPagesSetAbout) -> Any? = fun(__props): Any? {
            val __ins = getCurrentInstance()!!
            val _ctx = __ins.proxy as GenPagesSetAbout
            val _cache = __ins.renderCache
            onReady(fun(){
                uni_setNavigationBarTitle(SetNavigationBarTitleOptions(title = `$t`("关于{name}", object : UTSJSONObject() {
                    var name = config1.name
                })))
            }
            )
            fun gen_toWebSite_fn() {
                openWeb(config1.website)
            }
            val toWebSite = ::gen_toWebSite_fn
            return fun(): Any? {
                val _component_cl_image = resolveEasyComponent("cl-image", GenUniModulesCoolUiComponentsClImageClImageClass)
                val _component_cl_text = resolveEasyComponent("cl-text", GenUniModulesCoolUiComponentsClTextClTextClass)
                val _component_cl_list_item = resolveEasyComponent("cl-list-item", GenUniModulesCoolUiComponentsClListItemClListItemClass)
                val _component_cl_list = resolveEasyComponent("cl-list", GenUniModulesCoolUiComponentsClListClListClass)
                val _component_cl_page = resolveEasyComponent("cl-page", GenUniModulesCoolUiComponentsClPageClPageClass)
                return _cV(_component_cl_page, null, _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                    return _uA(
                        _cE("view", _uM("class" to "p-3"), _uA(
                            _cE("view", _uM("class" to "flex flex-col items-center justify-center py-10"), _uA(
                                _cE("view", _uM("class" to "p-3 bg-primary-500 rounded-xl"), _uA(
                                    _cV(_component_cl_image, _uM("src" to "/static/logo.png", "height" to 80, "width" to 80))
                                )),
                                _cV(_component_cl_text, _uM("pt" to object : UTSJSONObject() {
                                    var className = "mt-3 mb-1"
                                }), _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                                    return _uA(
                                        _tD(unref(config1).name)
                                    )
                                }
                                ), "_" to 1)),
                                _cV(_component_cl_text, _uM("color" to "info", "pt" to object : UTSJSONObject() {
                                    var className = "-important-text-xs"
                                }), _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                                    return _uA(
                                        "version " + _tD(unref(config1).version)
                                    )
                                }
                                ), "_" to 1))
                            )),
                            _cV(_component_cl_list, null, _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                                return _uA(
                                    _cV(_component_cl_list_item, _uM("label" to unref(t)("访问官网"), "arrow" to "", "hoverable" to "", "onClick" to toWebSite), null, 8, _uA(
                                        "label"
                                    ))
                                )
                            }
                            ), "_" to 1))
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
