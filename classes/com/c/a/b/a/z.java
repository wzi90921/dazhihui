package com.c.a.b.a;

import com.c.a.al;
import com.c.a.d.a;
import com.c.a.d.c;
import com.c.a.d.d;

final class z
  extends al<Class>
{
  public Class a(a parama)
  {
    if (parama.f() == c.i)
    {
      parama.j();
      return null;
    }
    throw new UnsupportedOperationException("Attempted to deserialize a java.lang.Class. Forgot to register a type adapter?");
  }
  
  public void a(d paramd, Class paramClass)
  {
    if (paramClass == null)
    {
      paramd.f();
      return;
    }
    throw new UnsupportedOperationException("Attempted to serialize java.lang.Class: " + paramClass.getName() + ". Forgot to register a type adapter?");
  }
}


/* Location:              E:\apk\dazhihui2\classes-dex2jar.jar!\com\c\a\b\a\z.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */