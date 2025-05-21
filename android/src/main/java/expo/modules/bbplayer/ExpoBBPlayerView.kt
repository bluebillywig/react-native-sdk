package expo.modules.bbplayer

import android.app.Activity
import android.content.Context
import android.content.res.Resources
import android.util.Log
import com.bluebillywig.bbnativeplayersdk.BBNativePlayer
import com.bluebillywig.bbnativeplayersdk.BBNativePlayerView
import com.bluebillywig.bbnativeplayersdk.BBNativePlayerViewDelegate
import com.bluebillywig.bbnativeshared.enums.ApiMethod
import com.bluebillywig.bbnativeshared.enums.Phase
import com.bluebillywig.bbnativeshared.enums.State
import com.bluebillywig.bbnativeshared.model.MediaClip
import com.bluebillywig.bbnativeshared.model.MediaClipList
import com.bluebillywig.bbnativeshared.model.Project
import expo.modules.bbplayer.extensions.toRecord
import expo.modules.bbplayer.records.ContentItemRecordInterface
import expo.modules.bbplayer.records.CustomStatisticsRecord
import expo.modules.bbplayer.records.MediaClipListRecord
import expo.modules.bbplayer.records.MediaClipRecord
import expo.modules.bbplayer.records.PlayoutRecord
import expo.modules.bbplayer.records.ProjectRecord
import expo.modules.kotlin.AppContext
import expo.modules.kotlin.viewevent.EventDispatcher
import expo.modules.kotlin.views.ExpoView


class ExpoBBPlayerView(context: Context, appContext: AppContext) : ExpoView(context, appContext),
    BBNativePlayerViewDelegate {
    override val shouldUseAndroidLayout = true
    private val currentActivity: Activity
        get() = appContext.throwingActivity

    private var jsonUrl: String = ""
    private var options = HashMap<String, Any?>()

    private var playerReady: Boolean = false
    private var playerSetup: Boolean = false

    lateinit var playerView: BBNativePlayerView

    private val onDidFailWithError by EventDispatcher<String?>()
    private val onDidRequestCollapse by EventDispatcher<Unit>()
    private val onDidRequestExpand by EventDispatcher<Unit>()
    private val onDidRequestOpenUrl by EventDispatcher<String?>()
    private val onDidSetupWithJsonUrl by EventDispatcher<String?>()
    private val onDidTriggerAdError by EventDispatcher<String?>()
    private val onDidTriggerAdFinished by EventDispatcher<Unit>()
    private val onDidTriggerAdLoaded by EventDispatcher<Unit>()
    private val onDidTriggerAdLoadStart by EventDispatcher<Unit>()
    private val onDidTriggerAdNotFound by EventDispatcher<Unit>()
    private val onDidTriggerAdQuartile1 by EventDispatcher<Unit>()
    private val onDidTriggerAdQuartile2 by EventDispatcher<Unit>()
    private val onDidTriggerAdQuartile3 by EventDispatcher<Unit>()
    private val onDidTriggerAdStarted by EventDispatcher<Unit>()
    private val onDidTriggerAllAdsCompleted by EventDispatcher<Unit>()
    private val onDidTriggerAutoPause by EventDispatcher<String?>()
    private val onDidTriggerAutoPausePlay by EventDispatcher<String?>()
    private val onDidTriggerCanPlay by EventDispatcher<Unit>()
    private val onDidTriggerCustomStatistics by EventDispatcher<CustomStatisticsRecord>()
    private val onDidTriggerDurationChange by EventDispatcher<Double?>()
    private val onDidTriggerEnded by EventDispatcher<Unit>()
    private val onDidTriggerFullscreen by EventDispatcher<Unit>()
    private val onDidTriggerMediaClipFailed by EventDispatcher<Unit>()
    private val onDidTriggerMediaClipLoaded by EventDispatcher<MediaClipRecord?>()
    private val onDidTriggerModeChange by EventDispatcher<String?>()
    private val onDidTriggerPause by EventDispatcher<Unit>()
    private val onDidTriggerPhaseChange by EventDispatcher<Phase?>()
    private val onDidTriggerPlay by EventDispatcher<Unit>()
    private val onDidTriggerPlaying by EventDispatcher<Unit>()
    private val onDidTriggerProjectLoaded by EventDispatcher<ProjectRecord?>()
    private val onDidTriggerRetractFullscreen by EventDispatcher<Unit>()
    private val onDidTriggerSeeked by EventDispatcher<Double?>()
    private val onDidTriggerSeeking by EventDispatcher<Unit>()
    private val onDidTriggerStall by EventDispatcher<Unit>()
    private val onDidTriggerStateChange by EventDispatcher<State?>()
    private val onDidTriggerViewFinished by EventDispatcher<Unit>()
    private val onDidTriggerViewStarted by EventDispatcher<Unit>()
    private val onDidTriggerVolumeChange by EventDispatcher<Double?>()

    override fun onLayout(changed: Boolean, left: Int, top: Int, right: Int, bottom: Int) {
        super.onLayout(changed, left, top, right, bottom)

        if (changed && playerReady) {
            val density = Resources.getSystem().displayMetrics.density
            val height = playerView.height / density;

            this.shadowNodeProxy.setViewSize(Double.NaN, height.toDouble())
        }
    }

    fun setupPlayer() {
        if (playerSetup) {
            removePlayer()
        }

        playerView = BBNativePlayer.createPlayerView(currentActivity, jsonUrl)
        playerView.delegate = this@ExpoBBPlayerView
        addView(playerView, LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT))

        playerSetup = true
    }

    private fun removePlayer() {
        this.shadowNodeProxy.setViewSize(Double.NaN, Double.NaN)
        playerReady = false
        playerSetup = false
        removeAllViews()
        playerView.callApiMethod(ApiMethod.pause, null)
        playerView.__destruct()
    }

    fun setJsonUrl(url: String) {
        this.jsonUrl = url
    }

    fun setOptions(options: HashMap<String, Any?>) {
        this.options = options
    }

    fun adMediaHeight(): Int? {
        return playerView.player?.adMediaHeight
    }

    fun adMediaWidth(): Int? {
        return playerView.player?.adMediaWidth
    }

    fun adMediaClip(): MediaClipRecord? {
        return playerView.player?.clipData?.toRecord()
    }

    fun controls(): Boolean? {
        return playerView.player?.controls
    }

    fun duration(): Double? {
        return playerView.player?.duration
    }

    fun inView(): Boolean? {
        return playerView.player?.inView
    }

    fun mode(): String? {
        return playerView.player?.mode
    }

    fun muted(): Boolean? {
        return playerView.player?.muted
    }

    fun phase(): Phase? {
        return playerView.player?.phase
    }

    fun playoutData(): PlayoutRecord? {
        return playerView.player?.playoutData?.toRecord()
    }

    fun projectData(): ProjectRecord? {
        return playerView.player?.projectData?.toRecord()
    }

    fun state(): State? {
        return playerView.player?.state
    }

    fun volume(): Double? {
        return playerView.player?.volume
    }

    fun autoPlayNextCancel() {
        playerView.player?.autoPlayNextCancel()
    }

    fun collapse() {
        playerView.player?.collapse()
    }

    fun expand() {
        playerView.player?.expand()
    }

    fun enterFullscreen() {
        playerView.player?.enterFullScreen()
    }

    fun exitFullscreen() {
        playerView.player?.exitFullScreen()
    }

    fun pause() {
        playerView.player?.pause()
    }

    fun play() {
        playerView.player?.play()
    }

    fun seek(offsetInSeconds: Int) {
        playerView.player?.seek(offsetInSeconds)
    }

    fun setMuted(muted: Boolean) {
        playerView.player?.setMuted(muted, true)
    }

    fun setVolume(volume: Double) {
        playerView.player?.setVolume(volume, true)
    }

    override fun didFailWithError(playerView: BBNativePlayerView, error: String?) {
        onDidFailWithError(error)
    }

    override fun didRequestCollapse(playerView: BBNativePlayerView) {
        this.shadowNodeProxy.setViewSize(Double.NaN, 0.0)
        onDidRequestCollapse(Unit)
    }

    override fun didRequestExpand(playerView: BBNativePlayerView) {
        val density = Resources.getSystem().displayMetrics.density
        val height = playerView.height / density
        this.shadowNodeProxy.setViewSize(Double.NaN, height.toDouble())

        onDidRequestExpand(Unit)
    }

    override fun didRequestOpenUrl(playerView: BBNativePlayerView, url: String?) {
        onDidRequestOpenUrl(url)
    }

    override fun didSetupWithJsonUrl(playerView: BBNativePlayerView, url: String?) {
        onDidSetupWithJsonUrl(url)
    }

    override fun didTriggerAdError(playerView: BBNativePlayerView, error: String?) {
        onDidTriggerAdError(error)
    }

    override fun didTriggerAdFinished(playerView: BBNativePlayerView) {
        onDidTriggerAdFinished(Unit)
    }

    override fun didTriggerAdLoaded(playerView: BBNativePlayerView) {
        onDidTriggerAdLoaded(Unit)
    }

    override fun didTriggerAdLoadStart(playerView: BBNativePlayerView) {
        onDidTriggerAdLoadStart(Unit)
    }

    override fun didTriggerAdNotFound(playerView: BBNativePlayerView) {
        onDidTriggerAdNotFound(Unit)
    }

    override fun didTriggerAdQuartile1(playerView: BBNativePlayerView) {
        onDidTriggerAdQuartile1(Unit)
    }

    override fun didTriggerAdQuartile2(playerView: BBNativePlayerView) {
        onDidTriggerAdQuartile2(Unit)
    }

    override fun didTriggerAdQuartile3(playerView: BBNativePlayerView) {
        onDidTriggerAdQuartile3(Unit)
    }

    override fun didTriggerAdStarted(playerView: BBNativePlayerView) {
        onDidTriggerAdStarted(Unit)
    }

    override fun didTriggerAllAdsCompleted(playerView: BBNativePlayerView) {
        onDidTriggerAllAdsCompleted(Unit)
    }

    override fun didTriggerAutoPause(playerView: BBNativePlayerView, why: String?) {
        onDidTriggerAutoPause(why)
    }

    override fun didTriggerAutoPausePlay(playerView: BBNativePlayerView, why: String?) {
        onDidTriggerAutoPausePlay(why)
    }

    override fun didTriggerCanPlay(playerView: BBNativePlayerView) {
        playerReady = true
        onDidTriggerCanPlay(Unit)
    }

    override fun didTriggerCustomStatistics(
        playerView: BBNativePlayerView,
        ident: String,
        ev: String,
        aux: Map<String, String>
    ) {
        val statistics = CustomStatisticsRecord(
            ident = ident,
            ev = ev,
            aux = aux
        )

        onDidTriggerCustomStatistics(statistics)
    }

    override fun didTriggerDurationChange(playerView: BBNativePlayerView, duration: Double?) {
        onDidTriggerDurationChange(duration)
    }

    override fun didTriggerEnded(playerView: BBNativePlayerView) {
        onDidTriggerEnded(Unit)
    }

    override fun didTriggerFullscreen(playerView: BBNativePlayerView) {
        onDidTriggerFullscreen(Unit)
    }

    override fun didTriggerMediaClipFailed(playerView: BBNativePlayerView) {
        onDidTriggerMediaClipFailed(Unit)
    }

    override fun didTriggerMediaClipLoaded(playerView: BBNativePlayerView, clipData: MediaClip?) {
        onDidTriggerMediaClipLoaded(clipData?.toRecord())
    }

    override fun didTriggerModeChange(playerView: BBNativePlayerView, mode: String?) {
        onDidTriggerModeChange(mode)
    }

    override fun didTriggerPause(playerView: BBNativePlayerView) {
        onDidTriggerPause(Unit)
    }

    override fun didTriggerPhaseChange(playerView: BBNativePlayerView, phase: Phase?) {
        onDidTriggerPhaseChange(phase)
    }

    override fun didTriggerPlay(playerView: BBNativePlayerView) {
        onDidTriggerPlay(Unit)
    }

    override fun didTriggerPlaying(playerView: BBNativePlayerView) {
        onDidTriggerPlaying(Unit)
    }

    override fun didTriggerProjectLoaded(playerView: BBNativePlayerView, projectData: Project?) {
        onDidTriggerProjectLoaded(projectData?.toRecord())
    }

    override fun didTriggerRetractFullscreen(playerView: BBNativePlayerView) {
        onDidTriggerRetractFullscreen(Unit)
    }

    override fun didTriggerSeeked(playerView: BBNativePlayerView, seekOffset: Double?) {
        onDidTriggerSeeked(seekOffset)
    }

    override fun didTriggerSeeking(playerView: BBNativePlayerView) {
        onDidTriggerSeeking(Unit)
    }

    override fun didTriggerStall(playerView: BBNativePlayerView) {
        onDidTriggerStall(Unit)
    }

    override fun didTriggerStateChange(playerView: BBNativePlayerView, state: State?) {
        onDidTriggerStateChange(state)
    }

    override fun didTriggerViewFinished(playerView: BBNativePlayerView) {
        onDidTriggerViewFinished(Unit)
    }

    override fun didTriggerViewStarted(playerView: BBNativePlayerView) {
        onDidTriggerViewStarted(Unit)
    }

    override fun didTriggerVolumeChange(playerView: BBNativePlayerView, volume: Double?) {
        onDidTriggerVolumeChange(volume)
    }

    override fun onDetachedFromWindow() {
        removePlayer()
        super.onDetachedFromWindow()
    }
}
