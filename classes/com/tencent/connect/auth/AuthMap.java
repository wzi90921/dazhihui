package com.tencent.connect.auth;

import java.util.HashMap;

public class AuthMap
{
  private static int b;
  public static AuthMap sInstance;
  public final String KEY_CHAR_LIST = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
  public HashMap<String, AuthMap.Auth> authMap = new HashMap();
  
  static
  {
    if (!AuthMap.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      a = bool;
      b = 0;
      return;
    }
  }
  
  private String a(String paramString1, String paramString2)
  {
    int i = 0;
    if ((!a) && (paramString1.length() % 2 != 0)) {
      throw new AssertionError();
    }
    StringBuilder localStringBuilder = new StringBuilder();
    int k = paramString2.length();
    int m = paramString1.length() / 2;
    int j = 0;
    while (i < m)
    {
      localStringBuilder.append((char)(Integer.parseInt(paramString1.substring(i * 2, i * 2 + 2), 16) ^ paramString2.charAt(j)));
      j = (j + 1) % k;
      i += 1;
    }
    return localStringBuilder.toString();
  }
  
  public static AuthMap getInstance()
  {
    if (sInstance == null) {
      sInstance = new AuthMap();
    }
    return sInstance;
  }
  
  public static int getSerial()
  {
    int i = b + 1;
    b = i;
    return i;
  }
  
  public String decode(String paramString1, String paramString2)
  {
    return a(paramString1, paramString2);
  }
  
  public AuthMap.Auth get(String paramString)
  {
    return (AuthMap.Auth)this.authMap.get(paramString);
  }
  
  public String makeKey()
  {
    int j = (int)Math.ceil(Math.random() * 20.0D + 3.0D);
    char[] arrayOfChar = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789".toCharArray();
    int k = arrayOfChar.length;
    StringBuffer localStringBuffer = new StringBuffer();
    int i = 0;
    while (i < j)
    {
      localStringBuffer.append(arrayOfChar[((int)(Math.random() * k))]);
      i += 1;
    }
    return localStringBuffer.toString();
  }
  
  public void remove(String paramString)
  {
    this.authMap.remove(paramString);
  }
  
  public String set(AuthMap.Auth paramAuth)
  {
    int i = getSerial();
    try
    {
      this.authMap.put("" + i, paramAuth);
      return "" + i;
    }
    catch (Throwable paramAuth)
    {
      for (;;)
      {
        paramAuth.printStackTrace();
      }
    }
  }
}


/* Location:              E:\apk\dazhihui2\classes-dex2jar.jar!\com\tencent\connect\auth\AuthMap.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */