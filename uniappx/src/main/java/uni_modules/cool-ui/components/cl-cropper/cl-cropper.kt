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
import io.dcloud.uniapp.extapi.chooseImage as uni_chooseImage
import io.dcloud.uniapp.extapi.createCanvasContextAsync as uni_createCanvasContextAsync
import io.dcloud.uniapp.extapi.getWindowInfo as uni_getWindowInfo
open class GenUniModulesCoolUiComponentsClCropperClCropper : VueComponent {
    constructor(__ins: ComponentInternalInstance) : super(__ins) {}
    open var pt: Any by `$props`
    open var cropWidth: Number by `$props`
    open var cropHeight: Number by `$props`
    open var maxScale: Number by `$props`
    open var resizable: Boolean by `$props`
    open var open: (url: String) -> Unit
        get() {
            return unref(this.`$exposed`["open"]) as (url: String) -> Unit
        }
        set(value) {
            setRefValue(this.`$exposed`, "open", value)
        }
    open var close: () -> Unit
        get() {
            return unref(this.`$exposed`["close"]) as () -> Unit
        }
        set(value) {
            setRefValue(this.`$exposed`, "close", value)
        }
    open var chooseImage: () -> Unit
        get() {
            return unref(this.`$exposed`["chooseImage"]) as () -> Unit
        }
        set(value) {
            setRefValue(this.`$exposed`, "chooseImage", value)
        }
    open var toPng: () -> UTSPromise<String>
        get() {
            return unref(this.`$exposed`["toPng"]) as () -> UTSPromise<String>
        }
        set(value) {
            setRefValue(this.`$exposed`, "toPng", value)
        }
    companion object {
        @Suppress("UNUSED_PARAMETER", "UNUSED_VARIABLE")
        var setup: (__props: GenUniModulesCoolUiComponentsClCropperClCropper, _arg1: SetupContext) -> Any? = fun(__props, ref1): Any? {
            var __expose = ref1.expose
            val __ins = getCurrentInstance()!!
            val _ctx = __ins.proxy as GenUniModulesCoolUiComponentsClCropperClCropper
            val _cache = __ins.renderCache
            val props = __props
            fun emit(event: String, vararg do_not_transform_spread: Any?) {
                __ins.emit(event, *do_not_transform_spread)
            }
            val proxy = getCurrentInstance()!!.proxy
            val canvasId = "cl-cropper__" + uuid()
            val canvasRef = ref<UniElement?>(null)
            fun gen_toPixel_fn(value: Number): Number {
                return Math.round(value)
            }
            val toPixel = ::gen_toPixel_fn
            val pt = computed(fun(): PassThrough56 {
                return parsePt<PassThrough56>(props.pt)
            }
            )
            val container = reactive<Size2>(Size2(height = 0, width = 0))
            val imageInfo = reactive<ImageInfo>(ImageInfo(width = 0, height = 0, isLoaded = false))
            val transform = reactive<Transform>(Transform(translateX = 0, translateY = 0))
            val imageSize = reactive<Size2>(Size2(width = 0, height = 0))
            val cropBox = reactive<CropBox>(CropBox(x = 0, y = 0, width = props.cropWidth, height = props.cropHeight))
            val touch = reactive<TouchState>(TouchState(startX = 0, startY = 0, startDistance = 0, startImageWidth = 0, startImageHeight = 0, startTranslateX = 0, startTranslateY = 0, startCropBoxWidth = 0, startCropBoxHeight = 0, isTouching = false, mode = "", direction = ""))
            val isResizing = ref(false)
            val showGuideLines = ref(false)
            val flipHorizontal = ref(false)
            val flipVertical = ref(false)
            val rotate = ref(0)
            val imageStyle = computed(fun(): UTSJSONObject {
                val flipX = if (flipHorizontal.value) {
                    "scaleX(-1)"
                } else {
                    "scaleX(1)"
                }
                val flipY = if (flipVertical.value) {
                    "scaleY(-1)"
                } else {
                    "scaleY(1)"
                }
                val style: UTSJSONObject = object : UTSJSONObject() {
                    var transform = "translate(" + toPixel(transform.translateX) + "px, " + toPixel(transform.translateY) + "px) " + flipX + " " + flipY + " rotate(" + rotate.value + "deg)"
                    var height = toPixel(imageSize.height) + "px"
                    var width = toPixel(imageSize.width) + "px"
                }
                if (!touch.isTouching) {
                    style["transitionDuration"] = "0.3s"
                }
                return style
            }
            )
            val cropBoxStyle = computed(fun(): UTSJSONObject {
                return object : UTSJSONObject() {
                    var left = "" + toPixel(cropBox.x) + "px"
                    var top = "" + toPixel(cropBox.y) + "px"
                    var width = "" + toPixel(cropBox.width) + "px"
                    var height = "" + toPixel(cropBox.height) + "px"
                }
            }
            )
            val maskStyle = computed<MaskStyle>(fun(): MaskStyle {
                return MaskStyle(top = object : UTSJSONObject() {
                    var height = "" + toPixel(cropBox.y) + "px"
                    var width = "" + toPixel(cropBox.width) + "px"
                    var left = "" + toPixel(cropBox.x) + "px"
                }, right = object : UTSJSONObject() {
                    var width = "" + toPixel(container.width - cropBox.x - cropBox.width) + "px"
                    var height = "100%"
                    var top: Number = 0
                    var left = "" + toPixel(cropBox.x + cropBox.width) + "px"
                }, bottom = object : UTSJSONObject() {
                    var height = "" + toPixel(container.height - cropBox.y - cropBox.height) + "px"
                    var width = "" + toPixel(cropBox.width) + "px"
                    var bottom: Number = 0
                    var left = "" + toPixel(cropBox.x) + "px"
                }, left = object : UTSJSONObject() {
                    var width = "" + toPixel(cropBox.x) + "px"
                    var height = "100%"
                    var left: Number = 0
                })
            }
            )
            val opStyle = computed(fun(): UTSJSONObject {
                var bottom = getSafeAreaHeight("bottom")
                if (bottom == 0) {
                    bottom = 10
                }
                return object : UTSJSONObject() {
                    var bottom = bottom + "px"
                }
            }
            )
            fun gen_getRotatedImageSize_fn(): Size2 {
                val angle = ((rotate.value % 360) + 360) % 360
                if (angle == 90 || angle == 270) {
                    return Size2(width = imageSize.height, height = imageSize.width)
                }
                return Size2(width = imageSize.width, height = imageSize.height)
            }
            val getRotatedImageSize = ::gen_getRotatedImageSize_fn
            fun gen_getMinImageSizeForPinch_fn(): Size2 {
                if (!imageInfo.isLoaded) {
                    return Size2(width = 0, height = 0)
                }
                val originalRatio = imageInfo.width / imageInfo.height
                val angle = ((rotate.value % 360) + 360) % 360
                var requiredW: Number
                var requiredH: Number
                if (angle == 90 || angle == 270) {
                    requiredW = cropBox.height
                    requiredH = cropBox.width
                } else {
                    requiredW = cropBox.width
                    requiredH = cropBox.height
                }
                var minW: Number
                var minH: Number
                if (requiredW / originalRatio > requiredH) {
                    minW = requiredW
                    minH = requiredW / originalRatio
                } else {
                    minH = requiredH
                    minW = requiredH * originalRatio
                }
                return Size2(width = toPixel(minW), height = toPixel(minH))
            }
            val getMinImageSizeForPinch = ::gen_getMinImageSizeForPinch_fn
            fun gen_getMinImageSize_fn(): Size2 {
                if (!imageInfo.isLoaded || imageInfo.width == 0 || imageInfo.height == 0) {
                    return Size2(width = 0, height = 0)
                }
                val angle = ((rotate.value % 360) + 360) % 360
                var effectiveWidth = imageInfo.width
                var effectiveHeight = imageInfo.height
                if (angle == 90 || angle == 270) {
                    effectiveWidth = imageInfo.height
                    effectiveHeight = imageInfo.width
                }
                val ratio = effectiveWidth / effectiveHeight
                val containerRatio = container.width / container.height
                var baseW: Number
                var baseH: Number
                if (ratio > containerRatio) {
                    baseW = container.width
                    baseH = container.width / ratio
                } else {
                    baseH = container.height
                    baseW = container.height * ratio
                }
                val scaleW = cropBox.width / baseW
                val scaleH = cropBox.height / baseH
                val minScale = Math.max(scaleW, scaleH)
                val finalScale = minScale * 1.01
                return Size2(width = toPixel(baseW * finalScale), height = toPixel(baseH * finalScale))
            }
            val getMinImageSize = ::gen_getMinImageSize_fn
            fun gen_initCrop_fn() {
                val _uni_getWindowInfo = uni_getWindowInfo()
                val windowHeight = _uni_getWindowInfo.windowHeight
                val windowWidth = _uni_getWindowInfo.windowWidth
                container.height = windowHeight
                container.width = windowWidth
                cropBox.width = props.cropWidth
                cropBox.height = props.cropHeight
                cropBox.x = toPixel((container.width - cropBox.width) / 2)
                cropBox.y = toPixel((container.height - cropBox.height) / 2)
                if (imageInfo.isLoaded) {
                    val minSize = getMinImageSize()
                    if (imageSize.width < minSize.width || imageSize.height < minSize.height) {
                        imageSize.width = toPixel(minSize.width)
                        imageSize.height = toPixel(minSize.height)
                    }
                }
            }
            val initCrop = ::gen_initCrop_fn
            fun gen_setInitialImageSize_fn() {
                if (!imageInfo.isLoaded || imageInfo.width == 0 || imageInfo.height == 0) {
                    return
                }
                val ratio = imageInfo.width / imageInfo.height
                val containerRatio = container.width / container.height
                var baseW: Number
                var baseH: Number
                if (ratio > containerRatio) {
                    baseW = container.width
                    baseH = container.width / ratio
                } else {
                    baseH = container.height
                    baseW = container.height * ratio
                }
                val scaleW = cropBox.width / baseW
                val scaleH = cropBox.height / baseH
                val scale = Math.max(scaleW, scaleH)
                imageSize.width = toPixel(baseW * scale)
                imageSize.height = toPixel(baseH * scale)
            }
            val setInitialImageSize = ::gen_setInitialImageSize_fn
            fun gen_adjustBounds_fn() {
                if (!imageInfo.isLoaded) {
                    return
                }
                val rotatedSize = getRotatedImageSize()
                val centerX = container.width / 2 + transform.translateX
                val centerY = container.height / 2 + transform.translateY
                val imgLeft = centerX - rotatedSize.width / 2
                val imgRight = centerX + rotatedSize.width / 2
                val imgTop = centerY - rotatedSize.height / 2
                val imgBottom = centerY + rotatedSize.height / 2
                val cropLeft = cropBox.x
                val cropRight = cropBox.x + cropBox.width
                val cropTop = cropBox.y
                val cropBottom = cropBox.y + cropBox.height
                var x = transform.translateX
                var y = transform.translateY
                if (imgLeft > cropLeft) {
                    x -= imgLeft - cropLeft
                } else if (imgRight < cropRight) {
                    x += cropRight - imgRight
                }
                if (imgTop > cropTop) {
                    y -= imgTop - cropTop
                } else if (imgBottom < cropBottom) {
                    y += cropBottom - imgBottom
                }
                transform.translateX = toPixel(x)
                transform.translateY = toPixel(y)
            }
            val adjustBounds = ::gen_adjustBounds_fn
            fun gen_onResizeStart_fn(e: TouchEvent, direction: String) {
                touch.isTouching = true
                touch.mode = "resizing"
                touch.direction = direction
                isResizing.value = true
                showGuideLines.value = true
                if (e.touches.length == 1) {
                    touch.startX = e.touches[0].clientX
                    touch.startY = e.touches[0].clientY
                    touch.startCropBoxWidth = cropBox.width
                    touch.startCropBoxHeight = cropBox.height
                }
            }
            val onResizeStart = ::gen_onResizeStart_fn
            fun gen_onResizeMove_fn(e: TouchEvent) {
                if (!touch.isTouching || touch.mode != "resizing") {
                    return
                }
                if (e.touches.length == 1) {
                    val dx = e.touches[0].clientX - touch.startX
                    val dy = e.touches[0].clientY - touch.startY
                    val MIN_SIZE: Number = 50
                    var anchorX: Number = 0
                    var anchorY: Number = 0
                    var newX = cropBox.x
                    var newY = cropBox.y
                    var newW = cropBox.width
                    var newH = cropBox.height
                    when (touch.direction) {
                        "tl" -> 
                            {
                                anchorX = cropBox.x + cropBox.width
                                anchorY = cropBox.y + cropBox.height
                                newW = anchorX - (cropBox.x + dx)
                                newH = anchorY - (cropBox.y + dy)
                                newX = anchorX - newW
                                newY = anchorY - newH
                            }
                        "tr" -> 
                            {
                                anchorX = cropBox.x
                                anchorY = cropBox.y + cropBox.height
                                newW = cropBox.width + dx
                                newH = anchorY - (cropBox.y + dy)
                                newX = anchorX
                                newY = anchorY - newH
                            }
                        "bl" -> 
                            {
                                anchorX = cropBox.x + cropBox.width
                                anchorY = cropBox.y
                                newW = anchorX - (cropBox.x + dx)
                                newH = cropBox.height + dy
                                newX = anchorX - newW
                                newY = anchorY
                            }
                        "br" -> 
                            {
                                anchorX = cropBox.x
                                anchorY = cropBox.y
                                newW = cropBox.width + dx
                                newH = cropBox.height + dy
                                newX = anchorX
                                newY = anchorY
                            }
                    }
                    if (newW < MIN_SIZE) {
                        newW = MIN_SIZE
                        if (touch.direction == "tl" || touch.direction == "bl") {
                            newX = anchorX - newW
                        }
                    }
                    if (newH < MIN_SIZE) {
                        newH = MIN_SIZE
                        if (touch.direction == "tl" || touch.direction == "tr") {
                            newY = anchorY - newH
                        }
                    }
                    newX = toPixel(Math.max(0, Math.min(newX, container.width - newW)))
                    newY = toPixel(Math.max(0, Math.min(newY, container.height - newH)))
                    if (newX == 0 && (touch.direction == "tl" || touch.direction == "bl")) {
                        newW = anchorX
                    }
                    if (newY == 0 && (touch.direction == "tl" || touch.direction == "tr")) {
                        newH = anchorY
                    }
                    if (newX + newW >= container.width && (touch.direction == "tr" || touch.direction == "br")) {
                        newW = container.width - newX
                    }
                    if (newY + newH >= container.height && (touch.direction == "bl" || touch.direction == "br")) {
                        newH = container.height - newY
                    }
                    cropBox.x = toPixel(newX)
                    cropBox.y = toPixel(newY)
                    cropBox.width = toPixel(newW)
                    cropBox.height = toPixel(newH)
                    touch.startX = e.touches[0].clientX
                    touch.startY = e.touches[0].clientY
                }
            }
            val onResizeMove = ::gen_onResizeMove_fn
            fun gen_centerAndAdjust_fn() {
                if (!imageInfo.isLoaded) {
                    return
                }
                val currentW = imageSize.width
                val currentH = imageSize.height
                val scaleX = cropBox.width / touch.startCropBoxWidth
                val scaleY = cropBox.height / touch.startCropBoxHeight
                val cropScale = Math.max(scaleX, scaleY)
                var imgScale = (1 as Number) / cropScale
                var newW = currentW * imgScale
                var newH = currentH * imgScale
                val getRotatedSize = fun(w: Number, h: Number): Size2 {
                    val angle = ((rotate.value % 360) + 360) % 360
                    if (angle == 90 || angle == 270) {
                        return Size2(width = h, height = w)
                    }
                    return Size2(width = w, height = h)
                }
                val rotatedSize = getRotatedSize(newW, newH)
                val minScaleW = cropBox.width / rotatedSize.width
                val minScaleH = cropBox.height / rotatedSize.height
                val minScale = Math.max(minScaleW, minScaleH)
                if (minScale > 1) {
                    imgScale *= minScale
                    newW = currentW * imgScale
                    newH = currentH * imgScale
                }
                val maxW = container.width * props.maxScale
                val maxH = container.height * props.maxScale
                val maxScaleW = maxW / newW
                val maxScaleH = maxH / newH
                val maxScaleConstraint = Math.min(maxScaleW, maxScaleH, 1)
                newW = newW * maxScaleConstraint
                newH = newH * maxScaleConstraint
                imageSize.width = toPixel(newW)
                imageSize.height = toPixel(newH)
                cropBox.x = toPixel((container.width - cropBox.width) / 2)
                cropBox.y = toPixel((container.height - cropBox.height) / 2)
                transform.translateX = 0
                transform.translateY = 0
                adjustBounds()
            }
            val centerAndAdjust = ::gen_centerAndAdjust_fn
            fun gen_onResizeEnd_fn() {
                touch.isTouching = false
                touch.mode = ""
                touch.direction = ""
                isResizing.value = false
                centerAndAdjust()
                setTimeout(fun(){
                    showGuideLines.value = false
                }
                , 200)
            }
            val onResizeEnd = ::gen_onResizeEnd_fn
            fun gen_onTouchStart_fn(e: TouchEvent) {
                if (!imageInfo.isLoaded) {
                    return
                }
                touch.isTouching = true
                touch.mode = "image"
                if (e.touches.length == 1) {
                    touch.startX = e.touches[0].clientX
                    touch.startY = e.touches[0].clientY
                    touch.startTranslateX = transform.translateX
                    touch.startTranslateY = transform.translateY
                } else if (e.touches.length == 2) {
                    val t1 = e.touches[0]
                    val t2 = e.touches[1]
                    touch.startDistance = Math.sqrt(Math.pow(t2.clientX - t1.clientX, 2) + Math.pow(t2.clientY - t1.clientY, 2))
                    touch.startImageWidth = imageSize.width
                    touch.startImageHeight = imageSize.height
                    touch.startX = (t1.clientX + t2.clientX) / 2
                    touch.startY = (t1.clientY + t2.clientY) / 2
                    touch.startTranslateX = transform.translateX
                    touch.startTranslateY = transform.translateY
                }
            }
            val onTouchStart = ::gen_onTouchStart_fn
            fun gen_onTouchMove_fn(e: TouchEvent) {
                if (!touch.isTouching) {
                    return
                }
                if (touch.mode == "resizing") {
                    onResizeMove(e)
                    return
                }
                if (e.touches.length == 1) {
                    val dx = e.touches[0].clientX - touch.startX
                    val dy = e.touches[0].clientY - touch.startY
                    transform.translateX = toPixel(touch.startTranslateX + dx)
                    transform.translateY = toPixel(touch.startTranslateY + dy)
                } else if (e.touches.length == 2) {
                    val t1 = e.touches[0]
                    val t2 = e.touches[1]
                    val distance = Math.sqrt(Math.pow(t2.clientX - t1.clientX, 2) + Math.pow(t2.clientY - t1.clientY, 2))
                    val scale = distance / touch.startDistance
                    val newW = touch.startImageWidth * scale
                    val newH = touch.startImageHeight * scale
                    val minSize = getMinImageSizeForPinch()
                    val maxW = container.width * props.maxScale
                    val maxH = container.height * props.maxScale
                    val minScaleW = minSize.width / newW
                    val minScaleH = minSize.height / newH
                    val maxScaleW = maxW / newW
                    val maxScaleH = maxH / newH
                    val minScale = Math.max(minScaleW, minScaleH)
                    val maxScale = Math.min(maxScaleW, maxScaleH)
                    val finalScale = Math.max(minScale, Math.min(maxScale, 1))
                    val finalW = newW * finalScale
                    val finalH = newH * finalScale
                    val centerX = (t1.clientX + t2.clientX) / 2
                    val centerY = (t1.clientY + t2.clientY) / 2
                    val dw = finalW - touch.startImageWidth
                    val dh = finalH - touch.startImageHeight
                    val offsetX = ((centerX - container.width / 2) * dw) / (2 * touch.startImageWidth)
                    val offsetY = ((centerY - container.height / 2) * dh) / (2 * touch.startImageHeight)
                    imageSize.width = toPixel(finalW)
                    imageSize.height = toPixel(finalH)
                    transform.translateX = toPixel(touch.startTranslateX - offsetX)
                    transform.translateY = toPixel(touch.startTranslateY - offsetY)
                }
            }
            val onTouchMove = ::gen_onTouchMove_fn
            fun gen_onTouchEnd_fn() {
                if (touch.mode == "resizing") {
                    onResizeEnd()
                    return
                }
                touch.isTouching = false
                touch.mode = ""
                adjustBounds()
            }
            val onTouchEnd = ::gen_onTouchEnd_fn
            fun gen_reset_fn() {
                initCrop()
                flipHorizontal.value = false
                flipVertical.value = false
                rotate.value = 0
                transform.translateX = 0
                transform.translateY = 0
                if (imageInfo.isLoaded) {
                    setInitialImageSize()
                    adjustBounds()
                } else {
                    imageSize.width = toPixel(0)
                    imageSize.height = toPixel(0)
                    transform.translateX = toPixel(0)
                    transform.translateY = toPixel(0)
                }
            }
            val reset = ::gen_reset_fn
            val visible = ref(false)
            val imageUrl = ref("")
            fun gen_open_fn(url: String) {
                visible.value = true
                nextTick(fun(){
                    imageUrl.value = url
                }
                )
            }
            val open = ::gen_open_fn
            fun gen_close_fn() {
                visible.value = false
            }
            val close = ::gen_close_fn
            fun gen_chooseImage_fn() {
                uni_chooseImage(ChooseImageOptions(count = 1, sizeType = _uA(
                    "original",
                    "compressed"
                ), sourceType = _uA(
                    "album",
                    "camera"
                ), success = fun(res){
                    if (res.tempFilePaths.length > 0) {
                        open(res.tempFilePaths[0])
                    }
                }
                ))
            }
            val chooseImage = ::gen_chooseImage_fn
            fun gen_onImageLoaded_fn(e: UniImageLoadEvent) {
                imageInfo.width = e.detail.width
                imageInfo.height = e.detail.height
                imageInfo.isLoaded = true
                reset()
                emit("load", e)
            }
            val onImageLoaded = ::gen_onImageLoaded_fn
            fun gen_toggleHorizontalFlip_fn() {
                flipHorizontal.value = !flipHorizontal.value
            }
            val toggleHorizontalFlip = ::gen_toggleHorizontalFlip_fn
            fun gen_toggleVerticalFlip_fn() {
                flipVertical.value = !flipVertical.value
            }
            val toggleVerticalFlip = ::gen_toggleVerticalFlip_fn
            fun gen_rotate90_fn() {
                rotate.value -= 90
                if (imageInfo.isLoaded) {
                    val rotatedSize = getRotatedImageSize()
                    val scaleW = cropBox.width / rotatedSize.width
                    val scaleH = cropBox.height / rotatedSize.height
                    val requiredScale = Math.max(scaleW, scaleH)
                    if (requiredScale > 1) {
                        imageSize.width = toPixel(imageSize.width * requiredScale)
                        imageSize.height = toPixel(imageSize.height * requiredScale)
                    }
                    adjustBounds()
                }
            }
            val rotate90 = ::gen_rotate90_fn
            fun gen_toPng_fn(): UTSPromise<String> {
                return wrapUTSPromise(suspend w@{
                        return@w UTSPromise(fun(resolve, _reject){
                            uni_createCanvasContextAsync(CreateCanvasContextAsyncOptions(id = canvasId, component = proxy, success = fun(context: CanvasContext){
                                val dpr = getDevicePixelRatio()
                                val ctx = context.getContext("2d")!!
                                ctx!!.canvas.width = cropBox.width * dpr
                                ctx!!.canvas.height = cropBox.height * dpr
                                ctx!!.reset()
                                var img: Image
                                img = Image()
                                img.src = imageUrl.value
                                img.onload = fun(){
                                    var x: Number
                                    var y: Number
                                    when (Math.abs(rotate.value) % 360) {
                                        270 -> 
                                            {
                                                x = (imageSize.width - cropBox.height) / 2 - transform.translateY
                                                y = (imageSize.height + cropBox.width) / 2 + transform.translateX
                                            }
                                        180 -> 
                                            {
                                                x = (imageSize.width + cropBox.width) / 2 + transform.translateX
                                                y = (imageSize.height + cropBox.height) / 2 + transform.translateY
                                            }
                                        90 -> 
                                            {
                                                x = (imageSize.width + cropBox.height) / 2 + transform.translateY
                                                y = (imageSize.height - cropBox.width) / 2 - transform.translateX
                                            }
                                        else -> 
                                            {
                                                x = (imageSize.width - cropBox.width) / 2 - transform.translateX
                                                y = (imageSize.height - cropBox.height) / 2 - transform.translateY
                                            }
                                    }
                                    if (x < 0) {
                                        x = 0
                                    }
                                    if (y < 0) {
                                        y = 0
                                    }
                                    ctx!!.rotate((rotate.value * Math.PI) / 180)
                                    ctx!!.drawImage(img, -x * dpr, -y * dpr, imageSize.width * dpr, imageSize.height * dpr)
                                    setTimeout(fun(){
                                        canvasToPng(canvasRef.value!!).then(fun(url){
                                            emit("crop", url)
                                            resolve(url)
                                        }
                                        )
                                    }
                                    , 10)
                                }
                            }
                            ))
                        }
                        )
                })
            }
            val toPng = ::gen_toPng_fn
            __expose(_uM("open" to open, "close" to close, "chooseImage" to chooseImage, "toPng" to toPng))
            return fun(): Any? {
                val _component_cl_text = resolveEasyComponent("cl-text", GenUniModulesCoolUiComponentsClTextClTextClass)
                val _component_cl_icon = resolveEasyComponent("cl-icon", GenUniModulesCoolUiComponentsClIconClIconClass)
                return if (isTrue(visible.value)) {
                    _cE("view", _uM("key" to 0, "class" to _nC(_uA(
                        "cl-cropper",
                        _uA(
                            _uM<String, Any?>(),
                            pt.value.className
                        )
                    )), "onTouchstart" to onTouchStart, "onTouchmove" to withModifiers(onTouchMove, _uA(
                        "stop",
                        "prevent"
                    )), "onTouchend" to onTouchEnd, "onTouchcancel" to onTouchEnd), _uA(
                        _cE("view", _uM("class" to "cl-cropper__image"), _uA(
                            _cE("image", _uM("class" to _nC(_uA(
                                "cl-cropper__image-inner",
                                _uA(
                                    _uM<String, Any?>(),
                                    pt.value.image?.className
                                )
                            )), "src" to imageUrl.value, "style" to _nS(imageStyle.value), "onLoad" to onImageLoaded), null, 46, _uA(
                                "src"
                            ))
                        )),
                        _cE("view", _uM("class" to _nC(_uA(
                            "cl-cropper__mask",
                            _uA(
                                _uM<String, Any?>(),
                                pt.value.mask?.className
                            )
                        ))), _uA(
                            _cE(Fragment, null, RenderHelpers.renderList(_uA(
                                "top",
                                "right",
                                "bottom",
                                "left"
                            ), fun(item, index, __index, _cached): Any {
                                return _cE("view", _uM("key" to index, "class" to _nC("cl-cropper__mask-item cl-cropper__mask-item--" + item), "style" to _nS(maskStyle.value[item]!!)), null, 6)
                            }), 64)
                        ), 2),
                        _cE("view", _uM("class" to _nC(_uA(
                            "cl-cropper__crop-box",
                            _uA(
                                _uM<String, Any?>(),
                                pt.value.cropBox?.className
                            )
                        )), "style" to _nS(cropBoxStyle.value)), _uA(
                            _cE("view", _uM("class" to _nC(_uA(
                                "cl-cropper__crop-area",
                                _uM("is-resizing" to isResizing.value)
                            ))), _uA(
                                _cE("view", _uM("class" to _nC(_uA(
                                    "cl-cropper__guide-lines",
                                    _uM("is-show" to showGuideLines.value)
                                ))), _uA(
                                    _cE("view", _uM("class" to "cl-cropper__guide-line cl-cropper__guide-line--h1")),
                                    _cE("view", _uM("class" to "cl-cropper__guide-line cl-cropper__guide-line--h2")),
                                    _cE("view", _uM("class" to "cl-cropper__guide-line cl-cropper__guide-line--v1")),
                                    _cE("view", _uM("class" to "cl-cropper__guide-line cl-cropper__guide-line--v2")),
                                    _cE("view", _uM("class" to "cl-cropper__guide-text"), _uA(
                                        _cV(_component_cl_text, _uM("pt" to object : UTSJSONObject() {
                                            var className = "-important-text-xl"
                                        }, "color" to "white"), _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                                            return _uA(
                                                _tD(cropBox.width)
                                            )
                                        }), "_" to 1)),
                                        _cV(_component_cl_icon, _uM("name" to "close-line", "color" to "white")),
                                        _cV(_component_cl_text, _uM("pt" to object : UTSJSONObject() {
                                            var className = "-important-text-xl"
                                        }, "color" to "white"), _uM("default" to withSlotCtx(fun(): UTSArray<Any> {
                                            return _uA(
                                                _tD(cropBox.height)
                                            )
                                        }), "_" to 1))
                                    ))
                                ), 2)
                            ), 2),
                            if (isTrue(_ctx.resizable)) {
                                _cE(Fragment, _uM("key" to 0), RenderHelpers.renderList(_uA(
                                    "tl",
                                    "tr",
                                    "bl",
                                    "br"
                                ), fun(item, __key, __index, _cached): Any {
                                    return _cE("view", _uM("key" to item, "class" to _nC(_uA(
                                        "cl-cropper__drag-point",
                                        _uA(
                                            _uM<String, Any?>(),
                                            "cl-cropper__drag-point--" + item
                                        )
                                    )), "onTouchstart" to withModifiers(fun(`$event`: Any){
                                        onResizeStart(`$event` as TouchEvent, item)
                                    }, _uA(
                                        "stop"
                                    ))), _uA(
                                        _cE("view", _uM("class" to "cl-cropper__corner-indicator"))
                                    ), 42, _uA(
                                        "onTouchstart"
                                    ))
                                }), 64)
                            } else {
                                _cC("v-if", true)
                            }
                        ), 6),
                        _cE("view", _uM("class" to _nC(_uA(
                            "cl-cropper__op",
                            _uA(
                                _uM<String, Any?>(),
                                pt.value.op?.className
                            )
                        )), "style" to _nS(opStyle.value), "onTouchmove" to withModifiers(fun(){}, _uA(
                            "stop"
                        ))), _uA(
                            _cE("view", _uM("class" to _nC(_uA(
                                "cl-cropper__op-item",
                                _uA(
                                    _uM<String, Any?>(),
                                    pt.value.opItem?.className
                                )
                            ))), _uA(
                                _cV(_component_cl_icon, _uM("name" to "close-line", "color" to "white", "size" to 50, "onClick" to close))
                            ), 2),
                            _cE("view", _uM("class" to _nC(_uA(
                                "cl-cropper__op-item",
                                _uA(
                                    _uM<String, Any?>(),
                                    pt.value.opItem?.className
                                )
                            ))), _uA(
                                _cV(_component_cl_icon, _uM("name" to "anticlockwise-line", "color" to "white", "size" to 40, "onClick" to rotate90))
                            ), 2),
                            _cE("view", _uM("class" to _nC(_uA(
                                "cl-cropper__op-item",
                                _uA(
                                    _uM<String, Any?>(),
                                    pt.value.opItem?.className
                                )
                            ))), _uA(
                                _cV(_component_cl_icon, _uM("name" to "reset-right-line", "color" to "white", "size" to 40, "onClick" to reset))
                            ), 2),
                            _cE("view", _uM("class" to _nC(_uA(
                                "cl-cropper__op-item",
                                _uA(
                                    _uM<String, Any?>(),
                                    pt.value.opItem?.className
                                )
                            ))), _uA(
                                _cV(_component_cl_icon, _uM("name" to "image-line", "color" to "white", "size" to 40, "onClick" to chooseImage))
                            ), 2),
                            _cE("view", _uM("class" to _nC(_uA(
                                "cl-cropper__op-item",
                                _uA(
                                    _uM<String, Any?>(),
                                    pt.value.opItem?.className
                                )
                            ))), _uA(
                                _cV(_component_cl_icon, _uM("name" to "check-line", "color" to "white", "size" to 50, "onClick" to toPng))
                            ), 2)
                        ), 46, _uA(
                            "onTouchmove"
                        )),
                        _cE("view", _uM("class" to "cl-cropper__canvas"), _uA(
                            _cE("canvas", _uM("ref_key" to "canvasRef", "ref" to canvasRef, "id" to canvasId, "style" to _nS(_uM("height" to ("" + cropBox.height + "px"), "width" to ("" + cropBox.width + "px")))), null, 4)
                        ))
                    ), 34)
                } else {
                    _cC("v-if", true)
                }
            }
        }
        var name = "cl-cropper"
        val styles: Map<String, Map<String, Map<String, Any>>> by lazy {
            _nCS(_uA(
                styles0
            ))
        }
        val styles0: Map<String, Map<String, Map<String, Any>>>
            get() {
                return _uM("cl-cropper" to _pS(_uM("position" to "absolute", "left" to 0, "top" to 0, "height" to "100%", "width" to "100%", "backgroundColor" to "rgba(0,0,0,1)", "zIndex" to 510)), "cl-cropper__image" to _pS(_uM("pointerEvents" to "none", "position" to "absolute", "top" to 0, "left" to 0, "display" to "flex", "height" to "100%", "width" to "100%", "alignItems" to "center", "justifyContent" to "center")), "cl-cropper__mask" to _pS(_uM("pointerEvents" to "none", "position" to "absolute", "top" to 0, "left" to 0, "zIndex" to 10, "height" to "100%", "width" to "100%")), "cl-cropper__mask-item" to _pS(_uM("position" to "absolute", "backgroundColor" to "rgba(0,0,0,0.4)")), "cl-cropper__crop-box" to _pS(_uM("position" to "absolute", "overflow" to "visible", "zIndex" to 10)), "cl-cropper__crop-area" to _uM("" to _uM("pointerEvents" to "none", "position" to "relative", "height" to "100%", "width" to "100%", "overflow" to "visible", "transitionDuration" to "200ms", "borderTopWidth" to 1, "borderRightWidth" to 1, "borderBottomWidth" to 1, "borderLeftWidth" to 1, "borderTopStyle" to "solid", "borderRightStyle" to "solid", "borderBottomStyle" to "solid", "borderLeftStyle" to "solid", "borderTopColor" to "rgba(255,255,255,0.5)", "borderRightColor" to "rgba(255,255,255,0.5)", "borderBottomColor" to "rgba(255,255,255,0.5)", "borderLeftColor" to "rgba(255,255,255,0.5)"), ".is-resizing" to _uM("borderTopColor" to "rgba(20,184,166,1)", "borderRightColor" to "rgba(20,184,166,1)", "borderBottomColor" to "rgba(20,184,166,1)", "borderLeftColor" to "rgba(20,184,166,1)")), "cl-cropper__guide-lines" to _uM("" to _uM("display" to "flex", "alignItems" to "center", "justifyContent" to "center", "pointerEvents" to "none", "position" to "absolute", "top" to 0, "left" to 0, "height" to "100%", "width" to "100%", "opacity" to 0, "transitionDuration" to "200ms"), ".is-show" to _uM("opacity" to 1)), "cl-cropper__guide-line" to _pS(_uM("position" to "absolute", "backgroundColor" to "rgba(255,255,255,1)", "opacity" to 0.7)), "cl-cropper__guide-line--h1" to _pS(_uM("top" to "33.333333%", "left" to 0, "width" to "100%", "height" to 1)), "cl-cropper__guide-line--h2" to _pS(_uM("top" to "66.666667%", "left" to 0, "width" to "100%", "height" to 1)), "cl-cropper__guide-line--v1" to _pS(_uM("left" to "33.333333%", "top" to 0, "height" to "100%", "width" to 1)), "cl-cropper__guide-line--v2" to _pS(_uM("left" to "66.666667%", "top" to 0, "height" to "100%", "width" to 1)), "cl-cropper__guide-text" to _pS(_uM("position" to "absolute", "display" to "flex", "flexDirection" to "row", "alignItems" to "center", "justifyContent" to "center")), "cl-cropper__corner-indicator" to _uM("" to _uM("position" to "absolute", "borderTopStyle" to "solid", "borderRightStyle" to "solid", "borderBottomStyle" to "solid", "borderLeftStyle" to "solid", "borderTopColor" to "rgba(255,255,255,1)", "borderRightColor" to "rgba(255,255,255,1)", "borderBottomColor" to "rgba(0,0,0,0)", "borderLeftColor" to "rgba(0,0,0,0)", "transitionDuration" to "200ms", "width" to 20, "height" to 20, "borderTopWidth" to 1, "borderRightWidth" to 1, "borderBottomWidth" to 1, "borderLeftWidth" to 1), ".cl-cropper__drag-point--tl " to _uM("transform" to "rotate(-90deg)", "left" to -1, "top" to -1), ".cl-cropper__drag-point--tr " to _uM("transform" to "rotate(0deg)", "right" to -1, "top" to -1), ".cl-cropper__drag-point--bl " to _uM("transform" to "rotate(180deg)", "bottom" to -1, "left" to -1), ".cl-cropper__drag-point--br " to _uM("transform" to "rotate(90deg)", "bottom" to -1, "right" to -1)), "cl-cropper__drag-point" to _pS(_uM("position" to "absolute", "display" to "flex", "alignItems" to "center", "justifyContent" to "center", "overflow" to "visible", "transitionDuration" to "200ms", "width" to 40, "height" to 40)), "cl-cropper__drag-point--tl" to _pS(_uM("top" to 0, "left" to 0)), "cl-cropper__drag-point--tr" to _pS(_uM("top" to 0, "right" to 0)), "cl-cropper__drag-point--bl" to _pS(_uM("bottom" to 0, "left" to 0)), "cl-cropper__drag-point--br" to _pS(_uM("bottom" to 0, "right" to 0)), "cl-cropper__op" to _pS(_uM("position" to "absolute", "left" to 0, "bottom" to 0, "display" to "flex", "width" to "100%", "flexDirection" to "row", "justifyContent" to "space-between", "zIndex" to 30, "height" to 40)), "cl-cropper__op-item" to _pS(_uM("display" to "flex", "height" to "100%", "flex" to 1, "flexDirection" to "row", "alignItems" to "center", "justifyContent" to "center")), "cl-cropper__canvas" to _pS(_uM("position" to "absolute", "top" to 0, "left" to -10000)), "@TRANSITION" to _uM("cl-cropper__crop-area" to _uM("duration" to "200ms"), "cl-cropper__guide-lines" to _uM("duration" to "200ms"), "cl-cropper__corner-indicator" to _uM("duration" to "200ms"), "cl-cropper__drag-point" to _uM("duration" to "200ms")))
            }
        var inheritAttrs = true
        var inject: Map<String, Map<String, Any?>> = _uM()
        var emits: Map<String, Any?> = _uM("crop" to null, "load" to null, "error" to null)
        var props = _nP(_uM("pt" to _uM("default" to fun(): UTSJSONObject {
            return (UTSJSONObject())
        }
        ), "cropWidth" to _uM("type" to "Number", "default" to 300), "cropHeight" to _uM("type" to "Number", "default" to 300), "maxScale" to _uM("type" to "Number", "default" to 3), "resizable" to _uM("type" to "Boolean", "default" to false)))
        var propsNeedCastKeys = _uA(
            "pt",
            "cropWidth",
            "cropHeight",
            "maxScale",
            "resizable"
        )
        var components: Map<String, CreateVueComponent> = _uM()
    }
}
