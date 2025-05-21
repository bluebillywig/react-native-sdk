package expo.modules.bbplayer.extensions

import com.bluebillywig.bbnativeshared.model.AdUnit
import com.bluebillywig.bbnativeshared.model.Audiotrack
import com.bluebillywig.bbnativeshared.model.Chapter
import com.bluebillywig.bbnativeshared.model.Dates
import com.bluebillywig.bbnativeshared.model.Highlight
import com.bluebillywig.bbnativeshared.model.LineItem_
import com.bluebillywig.bbnativeshared.model.MediaAsset
import com.bluebillywig.bbnativeshared.model.MediaClip
import com.bluebillywig.bbnativeshared.model.MediaClipList
import com.bluebillywig.bbnativeshared.model.Player
import com.bluebillywig.bbnativeshared.model.Playout
import com.bluebillywig.bbnativeshared.model.Project
import com.bluebillywig.bbnativeshared.model.Step
import com.bluebillywig.bbnativeshared.model.Subtitle
import com.bluebillywig.bbnativeshared.model.Thumbnail
import com.bluebillywig.bbnativeshared.model.Timeline
import expo.modules.bbplayer.records.AdUnitRecord
import expo.modules.bbplayer.records.AudiotrackRecord
import expo.modules.bbplayer.records.ChapterRecord
import expo.modules.bbplayer.records.DatesRecord
import expo.modules.bbplayer.records.HighlightRecord
import expo.modules.bbplayer.records.LineItemRecord
import expo.modules.bbplayer.records.MediaAssetRecord
import expo.modules.bbplayer.records.MediaClipListRecord
import expo.modules.bbplayer.records.MediaClipRecord
import expo.modules.bbplayer.records.PlayerRecord
import expo.modules.bbplayer.records.PlayoutRecord
import expo.modules.bbplayer.records.ProjectRecord
import expo.modules.bbplayer.records.StepRecord
import expo.modules.bbplayer.records.SubtitleRecord
import expo.modules.bbplayer.records.ThumbnailRecord
import expo.modules.bbplayer.records.TimelineRecord


fun Project.toRecord() = ProjectRecord(
    id = this.id,
    title = this.title,
    deeplink = this.deeplink,
    status = this.status,
    createddate = this.createddate,
    thumbnails = this.thumbnails?.map { it.toRecord() },
    name = this.name,
    createdBy = this.createdBy,
    updateddate = this.updateddate,
    updatedBy = this.updatedBy,
    subtype = this.subtype,
    cat = this.cat,
    clipCount = this.clipCount,
    publisheddate = this.publisheddate,
    useGaplessPlayback = this.useGaplessPlayback,
    distribution = this.distribution,
    goal = this.goal,
    useGaplessMetadata = this.useGaplessMetadata,
    useThumbsFromMetadata = this.useThumbsFromMetadata,
    noIntroClip = this.noIntroClip,
    analysis = this.analysis,
    description = this.description,
    author = this.author,
    copyright = this.copyright,
    transcript = this.transcript,
    label = this.label,
    chapters = this.chapters?.map { it.toRecord() },
    timelineId = this.timelineId,
    timelines = this.timelines?.map { it.toRecord() },
    mainMediaClipId = this.mainMediaClipId,
    mainMediaClipData = this.mainMediaClipData?.toRecord()
)

fun MediaClip.toRecord() = MediaClipRecord(
    id = this.id,
    title = this.title,
    deeplink = this.deeplink,
    gendeeplink = this.gendeeplink,
    sourcetype = this.sourcetype,
    length = this.length,
    mediatype = this.mediatype,
    mediatype_override = this.mediatype_override,
    fitmode = this.fitmode,
    usetype = this.usetype,
    useThumbsFromMetadata = this.useThumbsFromMetadata,
    location = this.location,
    originalfilename = this.originalfilename,
    sourceid = this.sourceid,
    description = this.description,
    copyright = this.copyright,
    author = this.author,
    status = this.status,
    createddate = this.createddate,
    updateddate = this.updateddate,
    publisheddate = this.publisheddate,
    width = this.width,
    height = this.height,
    dar = this.dar,
    originalWidth = this.originalWidth,
    originalHeight = this.originalHeight,
    date = DatesRecord(
        created = this.createddate,
        updated = this.updateddate,
        published = this.publisheddate
    ),
    src = this.src,
    cat = this.cat,
    thumbnails = this.thumbnails?.map { it.toRecord() },
    movingThumbnails = this.movingThumbnails?.map { it.toRecord() },
    assets = this.assets?.map { it.toRecord() },
    hasJobs = this.hasJobs,
    hasFailedJobs = this.hasFailedJobs,
    hasRunningJobs = this.hasRunningJobs,
    hasNewJobs = this.hasNewJobs,
    transcodingFinished = this.transcodingFinished,
    isYoutubeImport = this.isYoutubeImport,
    subtitles = this.subtitles?.map { it.toRecord() },
    subtitletracks = this.subtitletracks?.map { it.toRecord() },
    transcript = this.transcript,
    timelineId = this.timelineId,
    timelines = this.timelines?.map { it.toRecord() },
    audiotracks = this.audiotracks?.map { it.toRecord() },
    youtubeImportID = this.youtubeImportID,
    importSource = this.importSource,
    importURL = this.importURL,
    disablecommercials = this.disablecommercials,
    isDynamic = this.isDynamic,
    checkbox = this.checkbox,
    comment = this.comment,
    chapters = this.chapters?.map { it.toRecord() },
    highlights = this.highlights?.map { it.toRecord() },
    softEmbargo = this.softEmbargo,
    isOutro = this.isOutro,
    projectId = this.projectId
)

fun Thumbnail.toRecord() = ThumbnailRecord(
    src = this.src,
    width = this.width,
    height = this.height,
    main = this.main
)

fun MediaAsset.toRecord() = MediaAssetRecord(
    mediatype = this.mediatype,
    id = this.id,
    status = this.status,
    src = this.src,
    length = this.length,
    exactlength = this.exactlength,
    width = this.width,
    height = this.height,
    bandwidth = this.bandwidth,
    jobdefid = this.jobdefid,
    languageId = this.languageId,
    languageName = this.languageName,
    languageIsocode = this.languageIsocode,
    isDefaultLanguage = this.isDefaultLanguage,
    title = this.title
)

fun Audiotrack.toRecord() = AudiotrackRecord(
    id = this.id,
    type = this.type,
    status = this.status,
    createddate = this.createddate,
    name = this.name,
    createdBy = this.createdBy,
    updateddate = this.updateddate,
    updatedBy = this.updatedBy,
    audioId = this.audioId,
    isocode = this.isocode,
    roleFlags = this.roleFlags,
    mediaclipid = this.mediaclipid,
    originalfilename = this.originalfilename,
    languageid = this.languageid,
    src = this.src,
    remotesrc = this.remotesrc,
    exactlength = this.exactlength,
    publisheddate = this.publisheddate,
    label = this.label,
    uri = this.uri,
    isDefaultLanguage = this.isDefaultLanguage,
    isSelected = this.isSelected,
    origId = this.origId
)

fun Highlight.toRecord() = HighlightRecord(
    id = this.id,
    title = this.title,
    timeOffset = this.timeOffset
)

fun Timeline.toRecord() = TimelineRecord(id = this.id)

fun Chapter.toRecord() = ChapterRecord(
    id = this.id,
    title = this.title,
    timeOffset = this.timeOffset,
    steps = this.steps?.map { it.toRecord() }
)

fun Step.toRecord() = StepRecord(
    id = this.id,
    mediaClipId = this.mediaClipId,
    isStart = this.isStart,
    entityType = this.entityType,
    entityId = this.entityId
)

fun Dates.toRecord() = DatesRecord(
    created = this.created,
    updated = this.updated,
    published = this.published
)

fun Subtitle.toRecord() = SubtitleRecord(
    languageid = this.languageid,
    languagename = this.languagename,
    id = this.id,
    name = this.name,
    default = this.default,
    isocode = this.isocode,
    roleFlags = this.roleFlags,
    status = this.status,
    isSelected = this.isSelected
)

fun Playout.toRecord() = PlayoutRecord(
    id = this.id,
    main = this.main,
    type = this.type,
    name = this.name,
    status = this.status,
    createddate = this.createddate,
    updateddate = this.updateddate,
    label = this.label,
    publication = this.publication,
    player = this.player?.toRecord(),
    playerid = this.playerid,
    centerButtonType = this.centerButtonType,
    cornerRadius = this.cornerRadius,
    responsiveSizing = this.responsiveSizing,
    aspectRatio = this.aspectRatio,
    width = this.width,
    height = this.height,
    autoHeight = this.autoHeight,
    alphaControlBar = this.alphaControlBar,
    skin_backgroundColor = this.skin_backgroundColor,
    skin_foregroundColor = this.skin_foregroundColor,
    skin_widgetColor = this.skin_widgetColor,
    bgColor = this.bgColor,
    logoId = this.logoId,
    logoAlign = this.logoAlign,
    controlBar = this.controlBar,
    controlBarPlacement = this.controlBarPlacement,
    timeDisplay = this.timeDisplay,
    timeLine = this.timeLine,
    muteButton = this.muteButton,
    volume = this.volume,
    volumeOrientation = this.volumeOrientation,
    languageSelect = this.languageSelect,
    qualitySelector = this.qualitySelector,
    playbackRateSelector = this.playbackRateSelector,
    fullScreen = this.fullScreen,
    showStartControlBar = this.showStartControlBar,
    shareButton = this.shareButton,
    shareButtonPause = this.shareButtonPause,
    shareButtonEnd = this.shareButtonEnd,
    shareButtonEmbedCode = this.shareButtonEmbedCode,
    shareButtonEmail = this.shareButtonEmail,
    shareButtonFacebook = this.shareButtonFacebook,
    shareButtonLinkedIn = this.shareButtonLinkedIn,
    shareButtonPinterest = this.shareButtonPinterest,
    shareButtonTwitter = this.shareButtonTwitter,
    shareButtonWhatsApp = this.shareButtonWhatsApp,
    castButton = this.castButton,
    showBigPlayButton = this.showBigPlayButton,
    showBigReplayButton = this.showBigReplayButton,
    title = this.title,
    date = this.date,
    authorCopyright = this.authorCopyright,
    authorCopyrightAlign = this.authorCopyrightAlign,
    authorCopyrightPrefixText = this.authorCopyrightPrefixText,
    autoPlayNext = this.autoPlayNext,
    relatedItems = this.relatedItems,
    relatedItemsPause = this.relatedItemsPause,
    useDeeplinkForRelatedItems = this.useDeeplinkForRelatedItems,
    useDeeplinkForRelatedItemsPause = this.useDeeplinkForRelatedItemsPause,
    exitscreenItemsListId = this.exitscreenItemsListId,
    randomizeRelatedItems = this.randomizeRelatedItems,
    useDeeplinkForFacebook = this.useDeeplinkForFacebook,
    shareTwitterText = this.shareTwitterText,
    sharePlayout = this.sharePlayout,
    skinBehaviour = this.skinBehaviour,
    skinOnTimeline = this.skinOnTimeline,
    nativeControls = this.nativeControls,
    youTubeHosting = this.youTubeHosting,
    youTubeSkinInMainPhase = this.youTubeSkinInMainPhase,
    forceNativeFullscreen = this.forceNativeFullscreen,
    preferHD = this.preferHD,
    nedStatLoggerUrl = this.nedStatLoggerUrl,
    googleAnalyticsId = this.googleAnalyticsId,
    piwikUrl = this.piwikUrl,
    piwikSiteId = this.piwikSiteId,
    disableCookies = this.disableCookies,
    disableContextMenuNavigate = this.disableContextMenuNavigate,
    playerSignature = this.playerSignature,
    playerSignatureLink = this.playerSignatureLink,
    autoPlay = this.autoPlay,
    autoMute = this.autoMute,
    autoMuteIfNeededForAutoPlay = this.autoMuteIfNeededForAutoPlay,
    autoLoop = this.autoLoop,
    floatPlayer = this.floatPlayer,
    interactivityInView = this.interactivityInView,
    interactivityOutView = this.interactivityOutView,
    inviewMargin = this.inviewMargin,
    textAbovePlayer = this.textAbovePlayer,
    textCommercialSkip = this.textCommercialSkip,
    startCollapsed = this.startCollapsed,
    playInOverlay = this.playInOverlay,
    hidePlayerOnEnd = this.hidePlayerOnEnd,
    waitForApproval = this.waitForApproval,
    interactivityMouseIn = this.interactivityMouseIn,
    interactivityMouseOut = this.interactivityMouseOut,
    interactivityOnClick = this.interactivityOnClick,
    clickURL = this.clickURL,
    nsiNoAutoPlay = this.nsiNoAutoPlay,
    nsiNoPlayer = this.nsiNoPlayer,
    placementOption = this.placementOption,
    placementDOMSelector = this.placementDOMSelector,
    iframeBreakout = this.iframeBreakout,
    clearBothOption = this.clearBothOption,
    forceInview = this.forceInview,
    customCode = this.customCode,
    preferFlashPlayback = this.preferFlashPlayback,
    preloadMainroll = this.preloadMainroll,
    disableHtml5VPAID = this.disableHtml5VPAID,
    enableHtml5VPAID = this.enableHtml5VPAID,
    commercialPauseButton = this.commercialPauseButton,
    commercialMuteButton = this.commercialMuteButton,
    commercialAdIcon = this.commercialAdIcon,
    commercialProgressBar = this.commercialProgressBar,
    commercialProgressBarColor = this.commercialProgressBarColor,
    commercials = this.commercials,
    textCommercialTimeRemaining = this.textCommercialTimeRemaining,
    commercialBehaviour = this.commercialBehaviour,
    minClipDurationPreroll = this.minClipDurationPreroll,
    minClipDurationPostroll = this.minClipDurationPostroll,
    allowBBIma = this.allowBBIma,
    fitmode = this.fitmode,
    mobileRotateOnFullScreenMismatch = this.mobileRotateOnFullScreenMismatch,
    noStats = this.noStats,
    forceAndroidNativeVideo = this.forceAndroidNativeVideo,
    forceIOSNativeVideo = this.forceIOSNativeVideo,
    use2018Skin = this.use2018Skin,
    useThumbsFromMetadata = this.useThumbsFromMetadata,
    audioTrackSelect = this.audioTrackSelect,
    shareText = this.shareText,
    shareButtonDirectLink = this.shareButtonDirectLink,
    googleAnalyticsCustomVars = this.googleAnalyticsCustomVars,
    supportIABConsent = this.supportIABConsent,
    restrictionNpaOnly = this.restrictionNpaOnly,
    restrictionNpcOnly = this.restrictionNpcOnly,
    defaultSubtitle = this.defaultSubtitle,
    defaultSubtitleOnlyIfMuted = this.defaultSubtitleOnlyIfMuted,
    defaultAudioTrack = this.defaultAudioTrack,
    forceCanAutoPlay = this.forceCanAutoPlay,
    avoidMutedAutoplay = this.avoidMutedAutoplay,
    stickyMode = this.stickyMode,
    disableKeyboardControls = this.disableKeyboardControls,
    taggingDisabled = this.taggingDisabled,
    skipOffset = this.skipOffset,
    skipCounterText = this.skipCounterText,
    skipButtonText = this.skipButtonText,
    blockInsecureVPAID = this.blockInsecureVPAID,
    shareButtonGooglePlus = this.shareButtonGooglePlus,
    timelineId = this.timelineId,
    templateId = this.templateId,
    hasAdunits = this.hasAdunits,
    ignoreSingleMediaResource = this.ignoreSingleMediaResource,
    ignoreProjectMetadata = this.ignoreProjectMetadata,
    noPosterInExitPhase = this.noPosterInExitPhase,
    logProgressAsQuartiles = this.logProgressAsQuartiles,
    autoPauseAfterPrePhase = this.autoPauseAfterPrePhase,
    autoPlayOnlyWithPrerollAd = this.autoPlayOnlyWithPrerollAd,
    showOnlyWhenPrerollAvailable = this.showOnlyWhenPrerollAvailable,
    showBigPauseButtons = this.showBigPauseButtons,
    titlePause = this.titlePause,
    authorCopyrightPause = this.authorCopyrightPause,
    authorCopyrightAlignPause = this.authorCopyrightAlignPause,
    authorCopyrightPrefixTextPause = this.authorCopyrightPrefixTextPause,
    showStartDuration = this.showStartDuration,
    disableMovingThumbnail = this.disableMovingThumbnail,
    shareButtonHover = this.shareButtonHover,
    showBigHoverButtons = this.showBigHoverButtons,
    titleHover = this.titleHover,
    authorCopyrightHover = this.authorCopyrightHover,
    titleEnd = this.titleEnd,
    authorCopyrightEnd = this.authorCopyrightEnd,
    softEmbargoCustomPosterClipId = this.softEmbargoCustomPosterClipId,
    softEmbargoFontColor = this.softEmbargoFontColor,
    softEmbargoHasCustomPoster = this.softEmbargoHasCustomPoster,
    softEmbargoText = this.softEmbargoText,
    softEmbargoTimerHidden = this.softEmbargoTimerHidden,
    adsystem_buid = this.adsystem_buid,
    adsystem_rdid = this.adsystem_rdid,
    adsystem_idtype = this.adsystem_idtype,
    adsystem_is_lat = this.adsystem_is_lat,
    swipeDirection = this.swipeDirection,
    hideSwipeControls = this.hideSwipeControls,
    descriptionShowHide = this.descriptionShowHide,
    showPlayButton = this.showPlayButton,
    autoLoopClip = this.autoLoopClip,
    shortsId = this.shortsId,
    adunitId = this.adunitId,
    clipAdInterval = this.clipAdInterval,
    assetPreloadWindow = this.assetPreloadWindow,
    ctaUrlField = this.ctaUrlField,
    ctaButtonText = this.ctaButtonText,
    ctaButtonUseAccentColor = this.ctaButtonUseAccentColor,
    ctaButtonPosition = this.ctaButtonPosition,
)


fun Player.toRecord() = PlayerRecord(
    id = this.id,
    name = this.name,
    type = this.type,
    src = this.src,
    updateddate = this.updateddate
)


fun AdUnit.toRecord() = AdUnitRecord(
    id = this.id,
    type = this.type,
    status = this.status,
    createddate = this.createddate,
    createdBy = this.createdBy,
    updateddate = this.updateddate,
    updatedBy = this.updatedBy,
    positionType = this.positionType,
    positionDisplayType = this.positionDisplayType,
    playoutCode = this.playoutCode,
    title = this.title,
    code = this.code,
    assignedLineitems = this.assignedLineitems,
    label = this.label,
    lineitems = this.lineitems?.map { it.toRecord() }
)

fun LineItem_.toRecord() = LineItemRecord(
    id = this.id,
    type = this.type,
    status = this.status,
    createddate = this.createddate,
    createdBy = this.createdBy,
    updateddate = this.updateddate,
    updatedBy = this.updatedBy,
    creativeType = this.creativeType,
    creativeId = this.creativeId,
    timeout = this.timeout,
    preferredPlayMode = this.preferredPlayMode,
    playout = this.playout,
    title = this.title,
    code = this.code,
    vastUrl = this.vastUrl,
    vastSubtype = this.vastSubtype,
    label = this.label,
)

fun MediaClipList.toRecord() = MediaClipListRecord(
    id = this.id,
    title = this.title,
    deeplink = this.deeplink,
    numfound = this.numfound,
    offset = this.offset,
    parentid = this.parentid,
    status = this.status,
    publication = this.publication,
    parentpublicationid = this.parentpublicationid,
    mediatype = this.mediatype,
    usetype = this.usetype,
    modifieddate = this.modifieddate,
    createddate = this.createddate,
    publishedDate = this.publishedDate,
    listtypeString = this.listtypeString,
    isEmptyBoolean = this.isEmptyBoolean,
    filtersString = this.filtersString,
    createdbyString = this.createdbyString,
    updatedbyString = this.updatedbyString,
    allowDatasource = this.allowDatasource,
    allowDatasource_boolean = this.allowDatasource_boolean,
    score = this.score,
    count = this.count,
    items = this.items?.mapNotNull { item ->
        when (item) {
            is MediaClip -> item.toRecord()
            is Project -> item.toRecord()
            else -> null
        }
    },
)


fun MediaClipListRecord.toMediaClipList() = MediaClipList(
    id = this.id,
    title = this.title,
    deeplink = this.deeplink,
    numfound = this.numfound,
    offset = this.offset,
    parentid = this.parentid,
    status = this.status,
    publication = this.publication,
    parentpublicationid = this.parentpublicationid,
    mediatype = this.mediatype,
    usetype = this.usetype,
    modifieddate = this.modifieddate,
    createddate = this.createddate,
    publishedDate = this.publishedDate,
    listtypeString = this.listtypeString,
    isEmptyBoolean = this.isEmptyBoolean,
    filtersString = this.filtersString,
    createdbyString = this.createdbyString,
    updatedbyString = this.updatedbyString,
    allowDatasource = this.allowDatasource,
    allowDatasource_boolean = this.allowDatasource_boolean,
    score = this.score,
    count = this.count,
    items = this.items?.mapNotNull { item ->
        when (item) {
            is MediaClipRecord -> item.toMediaClip()
            is ProjectRecord -> item.toProject()
            else -> null
        }
    },
)

fun MediaClipRecord.toMediaClip() = MediaClip(
    id = this.id,
    title = this.title,
    deeplink = this.deeplink,
    gendeeplink = this.gendeeplink,
    sourcetype = this.sourcetype,
    length = this.length,
    mediatype = this.mediatype,
    mediatype_override = this.mediatype_override,
    fitmode = this.fitmode,
    usetype = this.usetype,
    useThumbsFromMetadata = this.useThumbsFromMetadata,
    location = this.location,
    originalfilename = this.originalfilename,
    sourceid = this.sourceid,
    description = this.description,
    copyright = this.copyright,
    author = this.author,
    status = this.status,
    createddate = this.createddate,
    updateddate = this.updateddate,
    publisheddate = this.publisheddate,
    width = this.width,
    height = this.height,
    dar = this.dar,
    originalWidth = this.originalWidth,
    originalHeight = this.originalHeight,
    date = Dates(
        created = this.createddate,
        updated = this.updateddate,
        published = this.publisheddate
    ),
    src = this.src,
    cat = this.cat,
    thumbnails = this.thumbnails?.map { Thumbnail(it.src, it.width, it.height, it.main) },
    movingThumbnails = this.movingThumbnails?.map {
        Thumbnail(
            it.src,
            it.width,
            it.height,
            it.main
        )
    },
    assets = this.assets?.map {
        MediaAsset(
            it.mediatype,
            it.id,
            it.status,
            it.src,
            it.length,
            it.exactlength,
            it.width,
            it.height,
            it.bandwidth,
            it.jobdefid,
            it.languageId,
            it.languageName,
            it.languageIsocode,
            it.isDefaultLanguage,
            it.title
        )
    },
    hasJobs = this.hasJobs,
    hasFailedJobs = this.hasFailedJobs,
    hasRunningJobs = this.hasRunningJobs,
    hasNewJobs = this.hasNewJobs,
    transcodingFinished = this.transcodingFinished,
    isYoutubeImport = this.isYoutubeImport,
    subtitles = this.subtitles?.map {
        Subtitle(
            it.languageid,
            it.languagename,
            it.id,
            it.name,
            it.default,
            it.isocode,
            it.roleFlags,
            it.status,
            it.isSelected
        )
    },
    subtitletracks = this.subtitletracks?.map {
        Subtitle(
            it.languageid,
            it.languagename,
            it.id,
            it.name,
            it.default,
            it.isocode,
            it.roleFlags,
            it.status,
            it.isSelected
        )
    },
    transcript = this.transcript,
    timelineId = this.timelineId,
    timelines = this.timelines?.map { Timeline(it.id) },
    audiotracks = this.audiotracks?.map {
        Audiotrack(
            it.id,
            it.type,
            it.status,
            it.createddate,
            it.name,
            it.createdBy,
            it.updateddate,
            it.updatedBy,
            it.audioId,
            it.isocode,
            it.roleFlags,
            it.mediaclipid,
            it.originalfilename,
            it.languageid,
            it.src,
            it.remotesrc,
            it.exactlength,
            it.publisheddate,
            it.label,
            it.uri,
            it.isDefaultLanguage,
            it.isSelected,
            it.origId
        )
    },
    youtubeImportID = this.youtubeImportID,
    importSource = this.importSource,
    importURL = this.importURL,
    disablecommercials = this.disablecommercials,
    isDynamic = this.isDynamic,
    checkbox = this.checkbox,
    comment = this.comment,
    chapters = this.chapters?.map {
        Chapter(
            it.id,
            it.title,
            it.timeOffset,
            it.steps?.map { Step(it.id, it.mediaClipId, it.isStart, it.entityType, it.entityId) })
    },
    highlights = this.highlights?.map { Highlight(it.id, it.title, it.timeOffset) },
    softEmbargo = this.softEmbargo,
    isOutro = this.isOutro,
    projectId = this.projectId
)


fun ProjectRecord.toProject() = Project(
    id = this.id,
    title = this.title,
    deeplink = this.deeplink,
    status = this.status,
    createddate = this.createddate,
    thumbnails = this.thumbnails?.map { Thumbnail(it.src, it.width, it.height, it.main) },
    name = this.name,
    createdBy = this.createdBy,
    updateddate = this.updateddate,
    updatedBy = this.updatedBy,
    subtype = this.subtype,
    cat = this.cat,
    clipCount = this.clipCount,
    publisheddate = this.publisheddate,
    useGaplessPlayback = this.useGaplessPlayback,
    distribution = this.distribution,
    goal = this.goal,
    useGaplessMetadata = this.useGaplessMetadata,
    useThumbsFromMetadata = this.useThumbsFromMetadata,
    noIntroClip = this.noIntroClip,
    analysis = this.analysis,
    description = this.description,
    author = this.author,
    copyright = this.copyright,
    transcript = this.transcript,
    label = this.label,
    chapters = this.chapters?.map {
        Chapter(
            it.id,
            it.title,
            it.timeOffset,
            it.steps?.map { Step(it.id, it.mediaClipId, it.isStart, it.entityType, it.entityId) })
    },
    timelineId = this.timelineId,
    timelines = this.timelines?.map { Timeline(it.id) },
    mainMediaClipId = this.mainMediaClipId,
    mainMediaClipData = this.mainMediaClipData?.toMediaClip()
)
