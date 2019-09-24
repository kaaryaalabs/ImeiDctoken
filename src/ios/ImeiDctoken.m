/********* ImeiDctoken.m Cordova Plugin Implementation *******/

#import <Cordova/CDV.h>

@interface ImeiDctoken : CDVPlugin {
  // Member variables go here.
}

- (void)getDcToken:(CDVInvokedUrlCommand*)command;
@end

@implementation ImeiDctoken

- (void)getDcToken:(CDVInvokedUrlCommand*)command
{
    CDVPluginResult* pluginResult = nil;
    NSString* echo = [command.arguments objectAtIndex:0];

     pluginResult = [CDVPluginResult resultWithStatus:CDVCommandStatus_OK messageAsString:@"not now"];

    [self.commandDelegate sendPluginResult:pluginResult callbackId:command.callbackId];
}

@end
