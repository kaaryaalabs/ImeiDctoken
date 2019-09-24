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
        final TelephonyManager mTelephony = (TelephonyManager) context.getSystemService(Context.TELEPHONY_SERVICE);
		String imei = mTelephony.getDeviceId();
        callbackContext.success(imei);
    }
}
