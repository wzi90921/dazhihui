package com.squareup.okhttp.internal.http;

import java.util.Comparator;

class RawHeaders$1
  implements Comparator<String>
{
  public int compare(String paramString1, String paramString2)
  {
    if (paramString1 == paramString2) {
      return 0;
    }
    if (paramString1 == null) {
      return -1;
    }
    if (paramString2 == null) {
      return 1;
    }
    return String.CASE_INSENSITIVE_ORDER.compare(paramString1, paramString2);
  }
}


/* Location:              E:\apk\dazhihui2\classes-dex2jar.jar!\com\squareup\okhttp\internal\http\RawHeaders$1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */