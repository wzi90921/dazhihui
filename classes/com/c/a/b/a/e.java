package com.c.a.b.a;

import com.c.a.ae;
import com.c.a.al;
import com.c.a.am;
import com.c.a.d.a;
import com.c.a.d.c;
import com.c.a.d.d;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

public final class e
  extends al<Date>
{
  public static final am a = new f();
  private final DateFormat b = DateFormat.getDateTimeInstance(2, 2, Locale.US);
  private final DateFormat c = DateFormat.getDateTimeInstance(2, 2);
  private final DateFormat d = a();
  
  private static DateFormat a()
  {
    SimpleDateFormat localSimpleDateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'", Locale.US);
    localSimpleDateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
    return localSimpleDateFormat;
  }
  
  private Date a(String paramString)
  {
    try
    {
      Date localDate1 = this.c.parse(paramString);
      paramString = localDate1;
    }
    catch (ParseException localParseException1)
    {
      try
      {
        Date localDate2 = this.b.parse(paramString);
        paramString = localDate2;
      }
      catch (ParseException localParseException2)
      {
        try
        {
          Date localDate3 = this.d.parse(paramString);
          paramString = localDate3;
        }
        catch (ParseException localParseException3)
        {
          throw new ae(paramString, localParseException3);
        }
      }
    }
    finally {}
    return paramString;
  }
  
  public Date a(a parama)
  {
    if (parama.f() == c.i)
    {
      parama.j();
      return null;
    }
    return a(parama.h());
  }
  
  public void a(d paramd, Date paramDate)
  {
    if (paramDate == null) {}
    for (;;)
    {
      try
      {
        paramd.f();
        return;
      }
      finally {}
      paramd.b(this.b.format(paramDate));
    }
  }
}


/* Location:              E:\apk\dazhihui2\classes-dex2jar.jar!\com\c\a\b\a\e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */