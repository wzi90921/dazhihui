package android.support.v4.app;

import android.support.v4.c.d;
import android.support.v4.c.r;
import android.util.Log;
import java.io.FileDescriptor;
import java.io.PrintWriter;

class bd
  extends bb
{
  static boolean a = false;
  final r<be> b = new r();
  final r<be> c = new r();
  final String d;
  boolean e;
  boolean f;
  private ac g;
  
  bd(String paramString, ac paramac, boolean paramBoolean)
  {
    this.d = paramString;
    this.g = paramac;
    this.e = paramBoolean;
  }
  
  void a(ac paramac)
  {
    this.g = paramac;
  }
  
  void a(be parambe)
  {
    this.b.b(parambe.a, parambe);
    if (this.e) {
      parambe.a();
    }
  }
  
  public void a(String paramString, FileDescriptor paramFileDescriptor, PrintWriter paramPrintWriter, String[] paramArrayOfString)
  {
    int j = 0;
    String str;
    int i;
    be localbe;
    if (this.b.b() > 0)
    {
      paramPrintWriter.print(paramString);
      paramPrintWriter.println("Active Loaders:");
      str = paramString + "    ";
      i = 0;
      while (i < this.b.b())
      {
        localbe = (be)this.b.c(i);
        paramPrintWriter.print(paramString);
        paramPrintWriter.print("  #");
        paramPrintWriter.print(this.b.b(i));
        paramPrintWriter.print(": ");
        paramPrintWriter.println(localbe.toString());
        localbe.a(str, paramFileDescriptor, paramPrintWriter, paramArrayOfString);
        i += 1;
      }
    }
    if (this.c.b() > 0)
    {
      paramPrintWriter.print(paramString);
      paramPrintWriter.println("Inactive Loaders:");
      str = paramString + "    ";
      i = j;
      while (i < this.c.b())
      {
        localbe = (be)this.c.c(i);
        paramPrintWriter.print(paramString);
        paramPrintWriter.print("  #");
        paramPrintWriter.print(this.c.b(i));
        paramPrintWriter.print(": ");
        paramPrintWriter.println(localbe.toString());
        localbe.a(str, paramFileDescriptor, paramPrintWriter, paramArrayOfString);
        i += 1;
      }
    }
  }
  
  public boolean a()
  {
    int j = this.b.b();
    int i = 0;
    boolean bool2 = false;
    if (i < j)
    {
      be localbe = (be)this.b.c(i);
      if ((localbe.h) && (!localbe.f)) {}
      for (boolean bool1 = true;; bool1 = false)
      {
        bool2 |= bool1;
        i += 1;
        break;
      }
    }
    return bool2;
  }
  
  void b()
  {
    if (a) {
      Log.v("LoaderManager", "Starting in " + this);
    }
    if (this.e)
    {
      RuntimeException localRuntimeException = new RuntimeException("here");
      localRuntimeException.fillInStackTrace();
      Log.w("LoaderManager", "Called doStart when already started: " + this, localRuntimeException);
    }
    for (;;)
    {
      return;
      this.e = true;
      int i = this.b.b() - 1;
      while (i >= 0)
      {
        ((be)this.b.c(i)).a();
        i -= 1;
      }
    }
  }
  
  void c()
  {
    if (a) {
      Log.v("LoaderManager", "Stopping in " + this);
    }
    if (!this.e)
    {
      RuntimeException localRuntimeException = new RuntimeException("here");
      localRuntimeException.fillInStackTrace();
      Log.w("LoaderManager", "Called doStop when not started: " + this, localRuntimeException);
      return;
    }
    int i = this.b.b() - 1;
    while (i >= 0)
    {
      ((be)this.b.c(i)).e();
      i -= 1;
    }
    this.e = false;
  }
  
  void d()
  {
    if (a) {
      Log.v("LoaderManager", "Retaining in " + this);
    }
    if (!this.e)
    {
      RuntimeException localRuntimeException = new RuntimeException("here");
      localRuntimeException.fillInStackTrace();
      Log.w("LoaderManager", "Called doRetain when not started: " + this, localRuntimeException);
    }
    for (;;)
    {
      return;
      this.f = true;
      this.e = false;
      int i = this.b.b() - 1;
      while (i >= 0)
      {
        ((be)this.b.c(i)).b();
        i -= 1;
      }
    }
  }
  
  void e()
  {
    if (this.f)
    {
      if (a) {
        Log.v("LoaderManager", "Finished Retaining in " + this);
      }
      this.f = false;
      int i = this.b.b() - 1;
      while (i >= 0)
      {
        ((be)this.b.c(i)).c();
        i -= 1;
      }
    }
  }
  
  void f()
  {
    int i = this.b.b() - 1;
    while (i >= 0)
    {
      ((be)this.b.c(i)).k = true;
      i -= 1;
    }
  }
  
  void g()
  {
    int i = this.b.b() - 1;
    while (i >= 0)
    {
      ((be)this.b.c(i)).d();
      i -= 1;
    }
  }
  
  void h()
  {
    if (!this.f)
    {
      if (a) {
        Log.v("LoaderManager", "Destroying Active in " + this);
      }
      i = this.b.b() - 1;
      while (i >= 0)
      {
        ((be)this.b.c(i)).f();
        i -= 1;
      }
      this.b.c();
    }
    if (a) {
      Log.v("LoaderManager", "Destroying Inactive in " + this);
    }
    int i = this.c.b() - 1;
    while (i >= 0)
    {
      ((be)this.c.c(i)).f();
      i -= 1;
    }
    this.c.c();
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder(128);
    localStringBuilder.append("LoaderManager{");
    localStringBuilder.append(Integer.toHexString(System.identityHashCode(this)));
    localStringBuilder.append(" in ");
    d.a(this.g, localStringBuilder);
    localStringBuilder.append("}}");
    return localStringBuilder.toString();
  }
}


/* Location:              E:\apk\dazhihui2\classes-dex2jar.jar!\android\support\v4\app\bd.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */