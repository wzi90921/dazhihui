package com.android.dazhihui.ui.widget.a;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;

final class p
{
  private final String b;
  private final long[] c;
  private boolean d;
  private n e;
  private long f;
  
  private p(l paraml, String paramString)
  {
    this.b = paramString;
    this.c = new long[l.e(paraml)];
  }
  
  private void a(String[] paramArrayOfString)
  {
    if (paramArrayOfString.length != l.e(this.a)) {
      throw b(paramArrayOfString);
    }
    int i = 0;
    try
    {
      while (i < paramArrayOfString.length)
      {
        this.c[i] = Long.parseLong(paramArrayOfString[i]);
        i += 1;
      }
      return;
    }
    catch (NumberFormatException localNumberFormatException)
    {
      throw b(paramArrayOfString);
    }
  }
  
  private IOException b(String[] paramArrayOfString)
  {
    throw new IOException("unexpected journal line: " + Arrays.toString(paramArrayOfString));
  }
  
  public File a(int paramInt)
  {
    return new File(l.f(this.a), this.b + "." + paramInt);
  }
  
  public String a()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    long[] arrayOfLong = this.c;
    int j = arrayOfLong.length;
    int i = 0;
    while (i < j)
    {
      long l = arrayOfLong[i];
      localStringBuilder.append(' ').append(l);
      i += 1;
    }
    return localStringBuilder.toString();
  }
  
  public File b(int paramInt)
  {
    return new File(l.f(this.a), this.b + "." + paramInt + ".tmp");
  }
}


/* Location:              E:\apk\dazhihui2\classes-dex2jar.jar!\com\android\dazhihui\ui\widget\a\p.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */