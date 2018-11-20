package org.mozilla.focus.gecko

import android.util.Log
import org.mozilla.geckoview.GeckoSession

class GeckoViewPermissionHandler: GeckoSession.PermissionDelegate {
    protected val LOGTAG = "GeckoViewPrompt"

    override fun onAndroidPermissionsRequest(session: GeckoSession?, permissions: Array<out String>?, callback: GeckoSession.PermissionDelegate.Callback?) {
        Log.d("permissionBug", "androidRequest")

        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.

    }

    override fun onMediaPermissionRequest(session: GeckoSession?, uri: String?, video: Array<out GeckoSession.PermissionDelegate.MediaSource>?, audio: Array<out GeckoSession.PermissionDelegate.MediaSource>?, callback: GeckoSession.PermissionDelegate.MediaCallback?) {
        Log.d("permissionBug", "mediaRequest")

        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onContentPermissionRequest(session: GeckoSession?, uri: String?, type: Int, access: String?, callback: GeckoSession.PermissionDelegate.Callback?) {
        Log.d("permissionBug", "request: " + type)
        if (type == GeckoSession.PermissionDelegate.PERMISSION_AUTOPLAY_MEDIA) {
            Log.d("permissionBug", "autoPlay!")
            callback?.reject()
            return
        } else if (type == GeckoSession.PermissionDelegate.PERMISSION_GEOLOCATION){
            Log.e("permissionBug", "location permission")
            callback?.grant()
        } else {
            Log.e("permissionBug", "onContentPermissionRequest unknown permission: " + type);
            callback?.reject()
        }

    }
}


