package com.tencent.av.sdk;

import android.util.Log;

public class AVVideoCtrl$EnableCameraCompleteCallback
{
  static final String TAG = "SdkJni";
  
  protected void onComplete(boolean paramBoolean, int paramInt)
  {
    Log.d("SdkJni", "EnableCameraCompleteCallback.OnComplete. result = " + paramInt);
  }
}


/* Location:              E:\apk\dazhihui2\classes-dex2jar.jar!\com\tencent\av\sdk\AVVideoCtrl$EnableCameraCompleteCallback.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */