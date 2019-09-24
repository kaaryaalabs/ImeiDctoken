/*
* Notes: The @objc shows that this class & function should be exposed to Cordova.
*/
import UIKit
import Foundation
import DeviceCheck

@objc(ImeiDctoken) class ImeiDctoken : CDVPlugin {
  @objc(getDcToken:) // Declare your function name.
  func getDcToken(command: CDVInvokedUrlCommand) { // write the function code.
  
    var pluginResult;
    let curDevice = DCDevice.current
        if curDevice.isSupported
        {
            curDevice.generateToken(completionHandler: { (data, error) in
                if let tokenData = data
                {
                  pluginResult = CDVPluginResult(status: CDVCommandStatus_OK, messageAs:"\(tokenData)");
                }
                else
                {
                    pluginResult = CDVPluginResult (status: CDVCommandStatus_ERROR, messageAs: error!.localizedDescription);
                }
            })
        } else {
             pluginResult = CDVPluginResult (status: CDVCommandStatus_ERROR, messageAs: "Current device not supported");
        }
    self.commandDelegate!.send(pluginResult, callbackId: command.callbackId);
  }
  @objc(getImei:) // Declare your function name.
  func getImei(command: CDVInvokedUrlCommand) { 
    var pluginResult = pluginResult = CDVPluginResult (status: CDVCommandStatus_ERROR, messageAs: "this is not possible for iOS");
    self.commandDelegate!.send(pluginResult, callbackId: command.callbackId);
  }
}

