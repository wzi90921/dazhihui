package com.android.dazhihui.ui.delegate.b;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.net.Uri;
import com.android.dazhihui.service.DownloadService;

final class t
  implements DialogInterface.OnClickListener
{
  t(Activity paramActivity) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (!DownloadService.a(this.a, o.C.toString(), false, false))
    {
      paramDialogInterface = new Intent("android.intent.action.VIEW", Uri.parse(o.C.toString()));
      this.a.startActivity(paramDialogInterface);
    }
  }
}


/* Location:              E:\apk\dazhihui2\classes-dex2jar.jar!\com\android\dazhihui\ui\delegate\b\t.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */