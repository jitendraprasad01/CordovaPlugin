package com.francis.ecatpaperless.databasepath;

import java.io.IOException;
import java.net.URLConnection;

import org.apache.cordova.CallbackContext;
import org.json.JSONArray;
import org.json.JSONException;

import android.content.Intent;
import android.net.Uri;
import android.content.Context;
import android.os.Build;
import org.apache.cordova.CordovaPlugin;
import org.apache.cordova.CordovaInterface;


public class DatabasePath extends CordovaPlugin {

    @Override
    public boolean execute(String action, JSONArray args, CallbackContext callbackContext) throws JSONException {

        try {
            if (action.equals("getDatabasePath")) {
		//String databasePath = this.cordova.getActivity().getApplicationContext().getDir("database", Context.MODE_PRIVATE).getPath();
                //String databasePath = this.cordova.getActivity().getDatabasePath("ClinidataPHR_DB").getAbsolutePath();
                String databasePath = "";
                if (Build.VERSION.SDK_INT < Build.VERSION_CODES.KITKAT) {
                    databasePath = "file:///data/data/"+webView.getContext().getPackageName()+"/app_database/file__0/0000000000000001.db";		
		}else{
		    databasePath = "file:///data/data/"+webView.getContext().getPackageName()+"/app_webview/databases/file__0/1";
		}
                callbackContext.success(databasePath);
                return true;
            }
        } catch (RuntimeException e) {  // KLUDGE for Activity Not Found
            e.printStackTrace();
            callbackContext.error(e.getMessage());
        }
        return false;
    }

}
