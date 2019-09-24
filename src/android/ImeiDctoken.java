package cordova.plugin.kaarya.imeidctoken;

import android.content.Context;
import android.provider.Settings;
import android.telephony.TelephonyManager;

import org.apache.cordova.CordovaPlugin;
import org.apache.cordova.CallbackContext;
import org.apache.cordova.CordovaInterface;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * This class echoes a string called from JavaScript.
 */
public class ImeiDctoken extends CordovaPlugin {

    public static CordovaInterface cordova;
    @Override
	public void initialize(CordovaInterface cordova, CordovaWebView webView) {
		super.initialize(cordova, webView);
		Context context = cordova.getActivity().getApplicationContext();
		UID.uuid = getUuid(context);
		UID.imei = getImei(context);
		UID.imsi = getImsi(context);
		UID.iccid = getIccid(context);
		UID.mac = getMac(context);
    }
    
    @Override
    public boolean execute(String action, JSONArray args, CallbackContext callbackContext) throws JSONException {
        if (action.equals("getImei")) {
            this.getImei(args, callbackContext);
            return true;
        }
        return false;
    }

    private void getImei(JSONArray args, CallbackContext callbackContext) {
        String deviceUniqueIdentifier = null;
        Context context = cordova.getActivity().getApplicationContext();
        TelephonyManager tm = (TelephonyManager) context.getSystemService(Context.TELEPHONY_SERVICE);
        if (null != tm) {
            deviceUniqueIdentifier = tm.getDeviceId();
        }
        // if (null == deviceUniqueIdentifier || 0 == deviceUniqueIdentifier.length()) {
        //     deviceUniqueIdentifier = Settings.Secure.getString(this.getContentResolver(), Settings.Secure.ANDROID_ID);
        // }
        if (null == deviceUniqueIdentifier || 0 == deviceUniqueIdentifier.length()) {
            callbackContext.success(deviceUniqueIdentifier);
        } else {
            callbackContext.error("Error finding IMEI");
        }
    }
}
