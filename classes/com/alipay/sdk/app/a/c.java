package com.alipay.sdk.app.a;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Build.VERSION;
import android.text.TextUtils;
import com.alipay.sdk.j.a;
import java.text.SimpleDateFormat;
import java.util.Date;

public final class c
{
  String a = String.format("123456789,%s", new Object[] { new SimpleDateFormat("yyyy-MM-dd-HH:mm:ss").format(new Date()) });
  String b;
  String c;
  String d;
  String e;
  String f;
  String g;
  String h;
  String i = "";
  String j;
  
  public c(Context paramContext)
  {
    this.c = a(paramContext);
    this.d = String.format("android,3,%s,%s,com.alipay.mcpay,5.0,-,-,-", new Object[] { a("15.2.2"), a("h.a.3.2.2") });
    this.e = String.format("%s,%s,-,-,-", new Object[] { a(com.alipay.sdk.i.b.a().a), a(com.alipay.sdk.h.b.a().c()) });
    this.f = String.format("%s,%s,%s,%s,%s,%s,%s,%s,%s,-", new Object[] { a(a.d(paramContext)), "android", a(Build.VERSION.RELEASE), a(Build.MODEL), "-", a(a.a(paramContext).a()), a(a.b(paramContext).p), "gw", a(a.a(paramContext).b()) });
    this.g = "-";
    this.h = "-";
    this.j = "-";
  }
  
  private static String a(Context paramContext)
  {
    String str1 = "-";
    str2 = "-";
    localObject2 = str2;
    Object localObject1 = str1;
    if (paramContext != null) {
      localObject1 = str1;
    }
    try
    {
      localObject2 = paramContext.getApplicationContext();
      localObject1 = str1;
      paramContext = ((Context)localObject2).getPackageName();
      localObject1 = paramContext;
      localObject2 = ((Context)localObject2).getPackageManager().getPackageInfo(paramContext, 0).versionName;
      localObject1 = paramContext;
    }
    catch (Throwable paramContext)
    {
      for (;;)
      {
        localObject2 = str2;
      }
    }
    return String.format("%s,%s,-,-,-", new Object[] { localObject1, localObject2 });
  }
  
  static String a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return "";
    }
    return paramString.replace("[", "【").replace("]", "】").replace("(", "（").replace(")", "）").replace(",", "，").replace("-", "=").replace("^", "~");
  }
  
  static String a(Throwable paramThrowable)
  {
    if (paramThrowable == null) {
      return "";
    }
    localStringBuffer = new StringBuffer();
    try
    {
      localStringBuffer.append(paramThrowable.getClass().getName()).append(":");
      localStringBuffer.append(paramThrowable.getMessage());
      localStringBuffer.append(" 》 ");
      paramThrowable = paramThrowable.getStackTrace();
      if (paramThrowable != null)
      {
        int k = 0;
        while (k < paramThrowable.length)
        {
          localStringBuffer.append(paramThrowable[k].toString() + " 》 ");
          k += 1;
        }
      }
      return localStringBuffer.toString();
    }
    catch (Throwable paramThrowable) {}
  }
  
  public final void a(String paramString1, String paramString2, String paramString3)
  {
    a(paramString1, paramString2, paramString3, "-");
  }
  
  public final void a(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    String str = "";
    if (!TextUtils.isEmpty(this.i)) {
      str = "" + "^";
    }
    paramString1 = str + String.format("%s,%s,%s,%s", new Object[] { paramString1, paramString2, a(paramString3), paramString4 });
    this.i += paramString1;
  }
  
  public final void a(String paramString1, String paramString2, Throwable paramThrowable)
  {
    a(paramString1, paramString2, a(paramThrowable));
  }
}


/* Location:              E:\apk\dazhihui2\classes-dex2jar.jar!\com\alipay\sdk\app\a\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */