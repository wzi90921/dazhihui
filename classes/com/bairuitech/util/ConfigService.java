package com.bairuitech.util;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;

public class ConfigService
{
  public static ConfigEntity LoadConfig(Context paramContext)
  {
    ConfigEntity localConfigEntity = new ConfigEntity();
    paramContext = paramContext.getSharedPreferences("perference", 2);
    localConfigEntity.name = paramContext.getString("name", "");
    localConfigEntity.password = paramContext.getString("password", "");
    if (paramContext.getString("IsSaveNameAndPw", "").equals("1")) {}
    for (boolean bool = true;; bool = false)
    {
      localConfigEntity.IsSaveNameAndPw = bool;
      localConfigEntity.ip = paramContext.getString("ip", "demo.anychat.cn");
      localConfigEntity.port = paramContext.getInt("port", 8906);
      localConfigEntity.configMode = paramContext.getInt("configMode", 1);
      localConfigEntity.resolution_width = paramContext.getInt("resolution_width", 320);
      localConfigEntity.resolution_height = paramContext.getInt("resolution_height", 240);
      localConfigEntity.videoBitrate = paramContext.getInt("videoBitrate", 150000);
      localConfigEntity.videoFps = paramContext.getInt("videoFps", 10);
      localConfigEntity.videoQuality = paramContext.getInt("videoQuality", 3);
      localConfigEntity.videoPreset = paramContext.getInt("videoPreset", 3);
      localConfigEntity.videoOverlay = paramContext.getInt("videoOverlay", 1);
      localConfigEntity.videorotatemode = paramContext.getInt("VideoRotateMode", 0);
      localConfigEntity.fixcolordeviation = paramContext.getInt("FixColorDeviation", 0);
      localConfigEntity.videoShowGPURender = paramContext.getInt("videoShowGPURender", 0);
      localConfigEntity.videoAutoRotation = paramContext.getInt("videoAutoRotation", 1);
      localConfigEntity.enableP2P = paramContext.getInt("enableP2P", 1);
      localConfigEntity.useARMv6Lib = paramContext.getInt("useARMv6Lib", 0);
      localConfigEntity.enableAEC = paramContext.getInt("enableAEC", 1);
      localConfigEntity.useHWCodec = paramContext.getInt("useHWCodec", 0);
      return localConfigEntity;
    }
  }
  
  public static void SaveConfig(Context paramContext, ConfigEntity paramConfigEntity)
  {
    SharedPreferences.Editor localEditor = paramContext.getSharedPreferences("perference", 2).edit();
    localEditor.putString("name", paramConfigEntity.name);
    localEditor.putString("password", paramConfigEntity.password);
    if (paramConfigEntity.IsSaveNameAndPw) {}
    for (paramContext = "1";; paramContext = "0")
    {
      localEditor.putString("IsSaveNameAndPw", paramContext);
      localEditor.putString("ip", paramConfigEntity.ip);
      localEditor.putInt("port", paramConfigEntity.port);
      localEditor.putInt("configMode", paramConfigEntity.configMode);
      localEditor.putInt("resolution_width", paramConfigEntity.resolution_width);
      localEditor.putInt("resolution_height", paramConfigEntity.resolution_height);
      localEditor.putInt("videoBitrate", paramConfigEntity.videoBitrate);
      localEditor.putInt("videoFps", paramConfigEntity.videoFps);
      localEditor.putInt("videoQuality", paramConfigEntity.videoQuality);
      localEditor.putInt("videoPreset", paramConfigEntity.videoPreset);
      localEditor.putInt("videoOverlay", paramConfigEntity.videoOverlay);
      localEditor.putInt("VideoRotateMode", paramConfigEntity.videorotatemode);
      localEditor.putInt("FixColorDeviation", paramConfigEntity.fixcolordeviation);
      localEditor.putInt("videoShowGPURender", paramConfigEntity.videoShowGPURender);
      localEditor.putInt("videoAutoRotation", paramConfigEntity.videoAutoRotation);
      localEditor.putInt("enableP2P", paramConfigEntity.enableP2P);
      localEditor.putInt("useARMv6Lib", paramConfigEntity.useARMv6Lib);
      localEditor.putInt("enableAEC", paramConfigEntity.enableAEC);
      localEditor.putInt("useHWCodec", paramConfigEntity.useHWCodec);
      localEditor.commit();
      return;
    }
  }
}


/* Location:              E:\apk\dazhihui2\classes-dex2jar.jar!\com\bairuitech\util\ConfigService.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */