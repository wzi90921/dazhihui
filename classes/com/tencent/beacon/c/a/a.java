package com.tencent.beacon.c.a;

import com.tencent.beacon.f.b;
import com.tencent.beacon.f.c;
import java.util.HashMap;
import java.util.Map;

public final class a
  extends c
  implements Cloneable
{
  private static Map<Integer, byte[]> b;
  public Map<Integer, byte[]> a = null;
  
  public final void a(com.tencent.beacon.f.a parama)
  {
    if (b == null)
    {
      b = new HashMap();
      byte[] arrayOfByte = (byte[])new byte[1];
      ((byte[])arrayOfByte)[0] = 0;
      b.put(Integer.valueOf(0), arrayOfByte);
    }
    this.a = ((Map)parama.a(b, 0, true));
  }
  
  public final void a(b paramb)
  {
    paramb.a(this.a, 0);
  }
}


/* Location:              E:\apk\dazhihui2\classes-dex2jar.jar!\com\tencent\beacon\c\a\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */