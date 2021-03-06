package org.apache.http.impl.entity;

import org.apache.http.Header;
import org.apache.http.HeaderElement;
import org.apache.http.HttpMessage;
import org.apache.http.ParseException;
import org.apache.http.ProtocolException;
import org.apache.http.annotation.Immutable;
import org.apache.http.entity.ContentLengthStrategy;
import org.apache.http.util.Args;

@Immutable
public class LaxContentLengthStrategy
  implements ContentLengthStrategy
{
  public static final LaxContentLengthStrategy INSTANCE = new LaxContentLengthStrategy();
  private final int implicitLen;
  
  public LaxContentLengthStrategy()
  {
    this(-1);
  }
  
  public LaxContentLengthStrategy(int paramInt)
  {
    this.implicitLen = paramInt;
  }
  
  public long determineLength(HttpMessage paramHttpMessage)
  {
    Args.notNull(paramHttpMessage, "HTTP message");
    Header localHeader = paramHttpMessage.getFirstHeader("Transfer-Encoding");
    int i;
    if (localHeader != null)
    {
      do
      {
        try
        {
          paramHttpMessage = localHeader.getElements();
          i = paramHttpMessage.length;
          if ("identity".equalsIgnoreCase(localHeader.getValue())) {
            return -1L;
          }
        }
        catch (ParseException paramHttpMessage)
        {
          throw new ProtocolException("Invalid Transfer-Encoding header value: " + localHeader, paramHttpMessage);
        }
      } while ((i <= 0) || (!"chunked".equalsIgnoreCase(paramHttpMessage[(i - 1)].getName())));
      return -2L;
    }
    if (paramHttpMessage.getFirstHeader("Content-Length") != null)
    {
      paramHttpMessage = paramHttpMessage.getHeaders("Content-Length");
      i = paramHttpMessage.length - 1;
      label128:
      if (i < 0) {
        break label171;
      }
      localHeader = paramHttpMessage[i];
    }
    for (;;)
    {
      try
      {
        l = Long.parseLong(localHeader.getValue());
        if (l < 0L) {
          break;
        }
        return l;
      }
      catch (NumberFormatException localNumberFormatException)
      {
        i -= 1;
      }
      break label128;
      return this.implicitLen;
      label171:
      long l = -1L;
    }
  }
}


/* Location:              E:\apk\dazhihui2\classes2-dex2jar.jar!\org\apache\http\impl\entity\LaxContentLengthStrategy.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */