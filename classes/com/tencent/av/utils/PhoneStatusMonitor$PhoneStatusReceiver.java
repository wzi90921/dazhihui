package com.tencent.av.utils;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

class PhoneStatusMonitor$PhoneStatusReceiver
  extends BroadcastReceiver
{
  PhoneStatusMonitor$PhoneStatusReceiver(PhoneStatusMonitor paramPhoneStatusMonitor) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if (paramIntent.getAction().equals("android.intent.action.NEW_OUTGOING_CALL")) {
      if (QLog.isColorLevel()) {
        QLog.d("PhoneStatusMonitor", 0, "onReceive NEW_OUTGOING_CALL");
      }
    }
    do
    {
      do
      {
        do
        {
          return;
          if (QLog.isColorLevel()) {
            QLog.d("PhoneStatusMonitor", 0, "onReceive PHONE_STATE");
          }
          if ((!this.this$0.mIsCalling) || (PhoneStatusTools.isCalling(this.this$0.mContext))) {
            break;
          }
          this.this$0.mIsCalling = false;
        } while (this.this$0.mPhoneStatusListener == null);
        this.this$0.mPhoneStatusListener.onCallStateChanged(false);
        return;
      } while ((this.this$0.mIsCalling) || (!PhoneStatusTools.isCalling(this.this$0.mContext)));
      this.this$0.mIsCalling = true;
    } while (this.this$0.mPhoneStatusListener == null);
    this.this$0.mPhoneStatusListener.onCallStateChanged(true);
  }
}


/* Location:              E:\apk\dazhihui2\classes-dex2jar.jar!\com\tencent\av\utils\PhoneStatusMonitor$PhoneStatusReceiver.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */