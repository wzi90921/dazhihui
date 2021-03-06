package com.tencent.open.utils;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Proxy;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.SystemClock;
import android.text.TextUtils;
import com.tencent.connect.a.a;
import com.tencent.connect.auth.QQToken;
import com.tencent.open.a.f;
import com.tencent.open.b.g;
import com.tencent.tauth.IRequestListener;
import java.io.ByteArrayOutputStream;
import java.io.CharConversionException;
import java.io.EOFException;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InvalidClassException;
import java.io.InvalidObjectException;
import java.io.NotActiveException;
import java.io.NotSerializableException;
import java.io.OptionalDataException;
import java.io.StreamCorruptedException;
import java.io.SyncFailedException;
import java.io.UTFDataFormatException;
import java.io.UnsupportedEncodingException;
import java.io.WriteAbortedException;
import java.net.BindException;
import java.net.ConnectException;
import java.net.HttpRetryException;
import java.net.MalformedURLException;
import java.net.NoRouteToHostException;
import java.net.PortUnreachableException;
import java.net.ProtocolException;
import java.net.SocketTimeoutException;
import java.net.URLEncoder;
import java.net.UnknownHostException;
import java.net.UnknownServiceException;
import java.nio.channels.ClosedChannelException;
import java.nio.channels.FileLockInterruptionException;
import java.nio.charset.MalformedInputException;
import java.nio.charset.UnmappableCharacterException;
import java.security.KeyStore;
import java.util.InvalidPropertiesFormatException;
import java.util.Iterator;
import java.util.Set;
import java.util.zip.GZIPInputStream;
import java.util.zip.ZipException;
import javax.net.ssl.SSLHandshakeException;
import javax.net.ssl.SSLKeyException;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLProtocolException;
import org.apache.http.ConnectionClosedException;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpHost;
import org.apache.http.HttpResponse;
import org.apache.http.HttpVersion;
import org.apache.http.MalformedChunkCodingException;
import org.apache.http.NoHttpResponseException;
import org.apache.http.StatusLine;
import org.apache.http.client.HttpClient;
import org.apache.http.client.HttpResponseException;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.conn.ConnectTimeoutException;
import org.apache.http.conn.scheme.PlainSocketFactory;
import org.apache.http.conn.scheme.Scheme;
import org.apache.http.conn.scheme.SchemeRegistry;
import org.apache.http.conn.scheme.SocketFactory;
import org.apache.http.conn.ssl.SSLSocketFactory;
import org.apache.http.entity.ByteArrayEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.conn.tsccm.ThreadSafeClientConnManager;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpParams;
import org.apache.http.params.HttpProtocolParams;
import org.json.JSONException;
import org.json.JSONObject;

public class HttpUtils
{
  private static int a(Context paramContext)
  {
    int i = -1;
    if (Build.VERSION.SDK_INT < 11) {
      if (paramContext != null)
      {
        int j = Proxy.getPort(paramContext);
        i = j;
        if (j < 0) {
          i = Proxy.getDefaultPort();
        }
      }
    }
    do
    {
      return i;
      return Proxy.getDefaultPort();
      paramContext = System.getProperty("http.proxyPort");
    } while (TextUtils.isEmpty(paramContext));
    try
    {
      i = Integer.parseInt(paramContext);
      return i;
    }
    catch (NumberFormatException paramContext) {}
    return -1;
  }
  
  private static String a(HttpResponse paramHttpResponse)
  {
    Object localObject = paramHttpResponse.getEntity().getContent();
    ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
    paramHttpResponse = paramHttpResponse.getFirstHeader("Content-Encoding");
    if ((paramHttpResponse != null) && (paramHttpResponse.getValue().toLowerCase().indexOf("gzip") > -1)) {}
    for (paramHttpResponse = new GZIPInputStream((InputStream)localObject);; paramHttpResponse = (HttpResponse)localObject)
    {
      localObject = new byte['Ȁ'];
      for (;;)
      {
        int i = paramHttpResponse.read((byte[])localObject);
        if (i == -1) {
          break;
        }
        localByteArrayOutputStream.write((byte[])localObject, 0, i);
      }
      localObject = new String(localByteArrayOutputStream.toByteArray(), "UTF-8");
      paramHttpResponse.close();
      return (String)localObject;
    }
  }
  
  private static void a(Context paramContext, QQToken paramQQToken, String paramString)
  {
    if ((paramString.indexOf("add_share") > -1) || (paramString.indexOf("upload_pic") > -1) || (paramString.indexOf("add_topic") > -1) || (paramString.indexOf("set_user_face") > -1) || (paramString.indexOf("add_t") > -1) || (paramString.indexOf("add_pic_t") > -1) || (paramString.indexOf("add_pic_url") > -1) || (paramString.indexOf("add_video") > -1)) {
      a.a(paramContext, paramQQToken, "requireApi", new String[] { paramString });
    }
  }
  
  private static String b(Context paramContext)
  {
    if (Build.VERSION.SDK_INT < 11)
    {
      if (paramContext != null)
      {
        String str = Proxy.getHost(paramContext);
        paramContext = str;
        if (TextUtils.isEmpty(str)) {
          paramContext = Proxy.getDefaultHost();
        }
        return paramContext;
      }
      return Proxy.getDefaultHost();
    }
    return System.getProperty("http.proxyHost");
  }
  
  public static String encodePostBody(Bundle paramBundle, String paramString)
  {
    if (paramBundle == null) {
      return "";
    }
    StringBuilder localStringBuilder = new StringBuilder();
    int j = paramBundle.size();
    Iterator localIterator = paramBundle.keySet().iterator();
    int i = -1;
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      i += 1;
      Object localObject = paramBundle.get(str);
      if ((localObject instanceof String))
      {
        localStringBuilder.append("Content-Disposition: form-data; name=\"" + str + "\"" + "\r\n" + "\r\n" + (String)localObject);
        if (i < j - 1) {
          localStringBuilder.append("\r\n--" + paramString + "\r\n");
        }
      }
    }
    return localStringBuilder.toString();
  }
  
  public static String encodeUrl(Bundle paramBundle)
  {
    if (paramBundle == null) {
      return "";
    }
    StringBuilder localStringBuilder = new StringBuilder();
    Iterator localIterator = paramBundle.keySet().iterator();
    int i = 1;
    while (localIterator.hasNext())
    {
      Object localObject1 = (String)localIterator.next();
      Object localObject2 = paramBundle.get((String)localObject1);
      if (((localObject2 instanceof String)) || ((localObject2 instanceof String[]))) {
        if ((localObject2 instanceof String[]))
        {
          int j;
          if (i != 0)
          {
            j = 0;
            localStringBuilder.append(URLEncoder.encode((String)localObject1) + "=");
            localObject1 = paramBundle.getStringArray((String)localObject1);
            i = j;
            if (localObject1 == null) {
              continue;
            }
            i = 0;
            label130:
            if (i >= localObject1.length) {
              break label210;
            }
            if (i != 0) {
              break label177;
            }
            localStringBuilder.append(URLEncoder.encode(localObject1[i]));
          }
          for (;;)
          {
            i += 1;
            break label130;
            localStringBuilder.append("&");
            j = i;
            break;
            label177:
            localStringBuilder.append(URLEncoder.encode("," + localObject1[i]));
          }
          label210:
          i = j;
        }
        else
        {
          if (i != 0) {
            i = 0;
          }
          for (;;)
          {
            localStringBuilder.append(URLEncoder.encode((String)localObject1) + "=" + URLEncoder.encode(paramBundle.getString((String)localObject1)));
            break;
            localStringBuilder.append("&");
          }
        }
      }
    }
    return localStringBuilder.toString();
  }
  
  public static int getErrorCodeFromException(IOException paramIOException)
  {
    if ((paramIOException instanceof CharConversionException)) {
      return -20;
    }
    if ((paramIOException instanceof MalformedInputException)) {
      return -21;
    }
    if ((paramIOException instanceof UnmappableCharacterException)) {
      return -22;
    }
    if ((paramIOException instanceof HttpResponseException)) {
      return -23;
    }
    if ((paramIOException instanceof ClosedChannelException)) {
      return -24;
    }
    if ((paramIOException instanceof ConnectionClosedException)) {
      return -25;
    }
    if ((paramIOException instanceof EOFException)) {
      return -26;
    }
    if ((paramIOException instanceof FileLockInterruptionException)) {
      return -27;
    }
    if ((paramIOException instanceof FileNotFoundException)) {
      return -28;
    }
    if ((paramIOException instanceof HttpRetryException)) {
      return -29;
    }
    if ((paramIOException instanceof ConnectTimeoutException)) {
      return -7;
    }
    if ((paramIOException instanceof SocketTimeoutException)) {
      return -8;
    }
    if ((paramIOException instanceof InvalidPropertiesFormatException)) {
      return -30;
    }
    if ((paramIOException instanceof MalformedChunkCodingException)) {
      return -31;
    }
    if ((paramIOException instanceof MalformedURLException)) {
      return -3;
    }
    if ((paramIOException instanceof NoHttpResponseException)) {
      return -32;
    }
    if ((paramIOException instanceof InvalidClassException)) {
      return -33;
    }
    if ((paramIOException instanceof InvalidObjectException)) {
      return -34;
    }
    if ((paramIOException instanceof NotActiveException)) {
      return -35;
    }
    if ((paramIOException instanceof NotSerializableException)) {
      return -36;
    }
    if ((paramIOException instanceof OptionalDataException)) {
      return -37;
    }
    if ((paramIOException instanceof StreamCorruptedException)) {
      return -38;
    }
    if ((paramIOException instanceof WriteAbortedException)) {
      return -39;
    }
    if ((paramIOException instanceof ProtocolException)) {
      return -40;
    }
    if ((paramIOException instanceof SSLHandshakeException)) {
      return -41;
    }
    if ((paramIOException instanceof SSLKeyException)) {
      return -42;
    }
    if ((paramIOException instanceof SSLPeerUnverifiedException)) {
      return -43;
    }
    if ((paramIOException instanceof SSLProtocolException)) {
      return -44;
    }
    if ((paramIOException instanceof BindException)) {
      return -45;
    }
    if ((paramIOException instanceof ConnectException)) {
      return -46;
    }
    if ((paramIOException instanceof NoRouteToHostException)) {
      return -47;
    }
    if ((paramIOException instanceof PortUnreachableException)) {
      return -48;
    }
    if ((paramIOException instanceof SyncFailedException)) {
      return -49;
    }
    if ((paramIOException instanceof UTFDataFormatException)) {
      return -50;
    }
    if ((paramIOException instanceof UnknownHostException)) {
      return -51;
    }
    if ((paramIOException instanceof UnknownServiceException)) {
      return -52;
    }
    if ((paramIOException instanceof UnsupportedEncodingException)) {
      return -53;
    }
    if ((paramIOException instanceof ZipException)) {
      return -54;
    }
    return -2;
  }
  
  public static HttpClient getHttpClient(Context paramContext, String paramString1, String paramString2)
  {
    int i = 0;
    paramString2 = new SchemeRegistry();
    paramString2.register(new Scheme("http", PlainSocketFactory.getSocketFactory(), 80));
    if (Build.VERSION.SDK_INT < 16) {}
    for (;;)
    {
      try
      {
        Object localObject = KeyStore.getInstance(KeyStore.getDefaultType());
        ((KeyStore)localObject).load(null, null);
        localObject = new HttpUtils.CustomSSLSocketFactory((KeyStore)localObject);
        ((SSLSocketFactory)localObject).setHostnameVerifier(SSLSocketFactory.STRICT_HOSTNAME_VERIFIER);
        paramString2.register(new Scheme("https", (SocketFactory)localObject, 443));
        localObject = new BasicHttpParams();
        if (paramContext == null) {
          break label346;
        }
        paramString1 = OpenConfig.getInstance(paramContext, paramString1);
        if (paramString1 == null) {
          break label340;
        }
        j = paramString1.getInt("Common_HttpConnectionTimeout");
        i = paramString1.getInt("Common_SocketConnectionTimeout");
        int k = j;
        if (j == 0) {
          k = 15000;
        }
        j = i;
        if (i == 0) {
          j = 30000;
        }
        HttpConnectionParams.setConnectionTimeout((HttpParams)localObject, k);
        HttpConnectionParams.setSoTimeout((HttpParams)localObject, j);
        HttpProtocolParams.setVersion((HttpParams)localObject, HttpVersion.HTTP_1_1);
        HttpProtocolParams.setContentCharset((HttpParams)localObject, "UTF-8");
        HttpProtocolParams.setUserAgent((HttpParams)localObject, "AndroidSDK_" + Build.VERSION.SDK + "_" + Build.DEVICE + "_" + Build.VERSION.RELEASE);
        paramString1 = new DefaultHttpClient(new ThreadSafeClientConnManager((HttpParams)localObject, paramString2), (HttpParams)localObject);
        paramContext = getProxy(paramContext);
        if (paramContext != null)
        {
          paramContext = new HttpHost(paramContext.host, paramContext.port);
          paramString1.getParams().setParameter("http.route.default-proxy", paramContext);
        }
        return paramString1;
      }
      catch (Exception localException)
      {
        paramString2.register(new Scheme("https", SSLSocketFactory.getSocketFactory(), 443));
        continue;
      }
      paramString2.register(new Scheme("https", SSLSocketFactory.getSocketFactory(), 443));
      continue;
      label340:
      int j = 0;
      continue;
      label346:
      paramString1 = null;
    }
  }
  
  public static HttpUtils.NetworkProxy getProxy(Context paramContext)
  {
    if (paramContext == null) {
      return null;
    }
    Object localObject = (ConnectivityManager)paramContext.getSystemService("connectivity");
    if (localObject == null) {
      return null;
    }
    localObject = ((ConnectivityManager)localObject).getActiveNetworkInfo();
    if (localObject == null) {
      return null;
    }
    if (((NetworkInfo)localObject).getType() == 0)
    {
      localObject = b(paramContext);
      int i = a(paramContext);
      if ((!TextUtils.isEmpty((CharSequence)localObject)) && (i >= 0)) {
        return new HttpUtils.NetworkProxy((String)localObject, i, null);
      }
    }
    return null;
  }
  
  public static Util.Statistic openUrl2(Context paramContext, String paramString1, String paramString2, Bundle paramBundle)
  {
    Object localObject1;
    if (paramContext != null)
    {
      localObject1 = (ConnectivityManager)paramContext.getSystemService("connectivity");
      if (localObject1 != null)
      {
        localObject1 = ((ConnectivityManager)localObject1).getActiveNetworkInfo();
        if ((localObject1 == null) || (!((NetworkInfo)localObject1).isAvailable())) {
          throw new HttpUtils.NetworkUnavailableException("network unavailable");
        }
      }
    }
    int i;
    if (paramBundle != null)
    {
      paramBundle = new Bundle(paramBundle);
      localObject1 = paramBundle.getString("appid_for_getting_config");
      paramBundle.remove("appid_for_getting_config");
      localObject1 = getHttpClient(paramContext, (String)localObject1, paramString1);
      if (!paramString2.equals("GET")) {
        break label326;
      }
      paramString2 = encodeUrl(paramBundle);
      i = paramString2.length();
      f.a("openSDK_LOG.HttpUtils", "-->openUrl2 before url =" + paramString1);
      if (paramString1.indexOf("?") != -1) {
        break label303;
      }
      paramContext = paramString1 + "?";
      label169:
      f.a("openSDK_LOG.HttpUtils", "-->openUrl2 encodedParam =" + paramString2 + " -- url = " + paramContext);
      paramContext = new HttpGet(paramContext + paramString2);
      paramContext.addHeader("Accept-Encoding", "gzip");
      i = 0 + i;
    }
    for (;;)
    {
      paramContext = ((HttpClient)localObject1).execute(paramContext);
      int j = paramContext.getStatusLine().getStatusCode();
      if (j == 200)
      {
        return new Util.Statistic(a(paramContext), i);
        paramBundle = new Bundle();
        break;
        label303:
        paramContext = paramString1 + "&";
        break label169;
        label326:
        if (!paramString2.equals("POST")) {
          break label736;
        }
        paramContext = new HttpPost(paramString1);
        paramContext.addHeader("Accept-Encoding", "gzip");
        paramString1 = new Bundle();
        Object localObject2 = paramBundle.keySet().iterator();
        while (((Iterator)localObject2).hasNext())
        {
          String str = (String)((Iterator)localObject2).next();
          Object localObject3 = paramBundle.get(str);
          if ((localObject3 instanceof byte[])) {
            paramString1.putByteArray(str, (byte[])localObject3);
          }
        }
        if (!paramBundle.containsKey("method")) {
          paramBundle.putString("method", paramString2);
        }
        paramContext.setHeader("Content-Type", "multipart/form-data; boundary=3i2ndDfv2rTHiSisAbouNdArYfORhtTPEefj3q2f");
        paramContext.setHeader("Connection", "Keep-Alive");
        paramString2 = new ByteArrayOutputStream();
        paramString2.write(Util.getBytesUTF8("--3i2ndDfv2rTHiSisAbouNdArYfORhtTPEefj3q2f\r\n"));
        paramString2.write(Util.getBytesUTF8(encodePostBody(paramBundle, "3i2ndDfv2rTHiSisAbouNdArYfORhtTPEefj3q2f")));
        if (!paramString1.isEmpty())
        {
          int k = paramString1.size();
          paramString2.write(Util.getBytesUTF8("\r\n--3i2ndDfv2rTHiSisAbouNdArYfORhtTPEefj3q2f\r\n"));
          paramBundle = paramString1.keySet().iterator();
          i = -1;
          while (paramBundle.hasNext())
          {
            localObject2 = (String)paramBundle.next();
            j = i + 1;
            paramString2.write(Util.getBytesUTF8("Content-Disposition: form-data; name=\"" + (String)localObject2 + "\"; filename=\"" + (String)localObject2 + "\"" + "\r\n"));
            paramString2.write(Util.getBytesUTF8("Content-Type: content/unknown\r\n\r\n"));
            localObject2 = paramString1.getByteArray((String)localObject2);
            if (localObject2 != null) {
              paramString2.write((byte[])localObject2);
            }
            i = j;
            if (j < k - 1)
            {
              paramString2.write(Util.getBytesUTF8("\r\n--3i2ndDfv2rTHiSisAbouNdArYfORhtTPEefj3q2f\r\n"));
              i = j;
            }
          }
        }
        paramString2.write(Util.getBytesUTF8("\r\n--3i2ndDfv2rTHiSisAbouNdArYfORhtTPEefj3q2f--\r\n"));
        paramString1 = paramString2.toByteArray();
        i = paramString1.length + 0;
        paramString2.close();
        paramContext.setEntity(new ByteArrayEntity(paramString1));
        continue;
      }
      throw new HttpUtils.HttpStatusException("http status code error:" + j);
      label736:
      paramContext = null;
      i = 0;
    }
  }
  
  public static JSONObject request(QQToken paramQQToken, Context paramContext, String paramString1, Bundle paramBundle, String paramString2)
  {
    f.a("openSDK_LOG.HttpUtils", "OpenApi request");
    String str2;
    String str1;
    if (!paramString1.toLowerCase().startsWith("http"))
    {
      str2 = ServerSetting.getInstance().getEnvUrl(paramContext, "https://openmobile.qq.com/") + paramString1;
      str1 = ServerSetting.getInstance().getEnvUrl(paramContext, "https://openmobile.qq.com/") + paramString1;
    }
    for (;;)
    {
      a(paramContext, paramQQToken, paramString1);
      long l1 = SystemClock.elapsedRealtime();
      int j = OpenConfig.getInstance(paramContext, paramQQToken.getAppId()).getInt("Common_HttpRetryCount");
      f.a("OpenConfig_test", "config 1:Common_HttpRetryCount            config_value:" + j + "   appid:" + paramQQToken.getAppId() + "     url:" + str1);
      int i;
      if (j == 0)
      {
        j = 3;
        f.a("OpenConfig_test", "config 1:Common_HttpRetryCount            result_value:" + j + "   appid:" + paramQQToken.getAppId() + "     url:" + str1);
        i = 0;
        paramQQToken = null;
      }
      int k;
      label257:
      label271:
      label327:
      label543:
      for (;;)
      {
        k = i + 1;
        try
        {
          localStatistic = openUrl2(paramContext, str2, paramString2, paramBundle);
          paramString1 = Util.parseJson(localStatistic.response);
        }
        catch (HttpUtils.HttpStatusException paramQQToken)
        {
          Util.Statistic localStatistic;
          long l2;
          long l3;
          paramQQToken.printStackTrace();
          paramContext = paramQQToken.getMessage();
          try
          {
            i = Integer.parseInt(paramContext.replace("http status code error:", ""));
            g.a().a(str1, l1, 0L, 0L, i);
            throw paramQQToken;
          }
          catch (Exception paramContext)
          {
            for (;;)
            {
              paramContext.printStackTrace();
              i = -9;
            }
          }
        }
        catch (HttpUtils.NetworkUnavailableException paramQQToken)
        {
          paramQQToken.printStackTrace();
          throw paramQQToken;
        }
        catch (MalformedURLException paramQQToken)
        {
          paramQQToken.printStackTrace();
          g.a().a(str1, l1, 0L, 0L, -3);
          throw paramQQToken;
        }
        catch (IOException paramQQToken)
        {
          paramQQToken.printStackTrace();
          i = getErrorCodeFromException(paramQQToken);
          g.a().a(str1, l1, 0L, 0L, i);
          throw paramQQToken;
        }
        catch (JSONException paramQQToken)
        {
          paramQQToken.printStackTrace();
          g.a().a(str1, l1, 0L, 0L, -4);
          throw paramQQToken;
        }
        catch (SocketTimeoutException paramString1)
        {
          for (;;) {}
        }
        catch (ConnectTimeoutException paramString1)
        {
          for (;;) {}
          i = k;
        }
        try
        {
          i = paramString1.getInt("ret");
          l2 = localStatistic.reqSize;
          l3 = localStatistic.rspSize;
          g.a().a(str1, l1, l2, l3, i);
          return paramString1;
        }
        catch (JSONException paramQQToken)
        {
          i = -4;
          break label257;
        }
        catch (ConnectTimeoutException localConnectTimeoutException)
        {
          paramQQToken = paramString1;
          paramString1 = localConnectTimeoutException;
          paramString1.printStackTrace();
          i = -7;
          if (k < j)
          {
            l1 = SystemClock.elapsedRealtime();
            l3 = 0L;
            if (k < j) {
              break label543;
            }
            l2 = 0L;
            paramString1 = paramQQToken;
            break label271;
          }
          g.a().a(str1, l1, 0L, 0L, -7);
          throw paramString1;
        }
        catch (SocketTimeoutException localSocketTimeoutException)
        {
          paramQQToken = paramString1;
          paramString1 = localSocketTimeoutException;
          paramString1.printStackTrace();
          i = -8;
          if (k < j)
          {
            l1 = SystemClock.elapsedRealtime();
            break label327;
          }
          g.a().a(str1, l1, 0L, 0L, -8);
          throw paramString1;
        }
      }
      str1 = paramString1;
      str2 = paramString1;
    }
  }
  
  public static void requestAsync(QQToken paramQQToken, Context paramContext, String paramString1, Bundle paramBundle, String paramString2, IRequestListener paramIRequestListener)
  {
    f.a("openSDK_LOG.HttpUtils", "OpenApi requestAsync");
    new HttpUtils.1(paramQQToken, paramContext, paramString1, paramBundle, paramString2, paramIRequestListener).start();
  }
  
  public static JSONObject upload(QQToken paramQQToken, Context paramContext, String paramString, Bundle paramBundle)
  {
    String str2;
    String str1;
    if (!paramString.toLowerCase().startsWith("http"))
    {
      str2 = ServerSetting.getInstance().getEnvUrl(paramContext, "https://openmobile.qq.com/") + paramString;
      str1 = ServerSetting.getInstance().getEnvUrl(paramContext, "https://openmobile.qq.com/") + paramString;
    }
    for (;;)
    {
      a(paramContext, paramQQToken, paramString);
      long l1 = SystemClock.elapsedRealtime();
      int j = OpenConfig.getInstance(paramContext, paramQQToken.getAppId()).getInt("Common_HttpRetryCount");
      f.a("OpenConfig_test", "config 1:Common_HttpRetryCount            config_value:" + j + "   appid:" + paramQQToken.getAppId() + "     url:" + str1);
      int i;
      if (j == 0)
      {
        j = 3;
        f.a("OpenConfig_test", "config 1:Common_HttpRetryCount            result_value:" + j + "   appid:" + paramQQToken.getAppId() + "     url:" + str1);
        i = 0;
        paramQQToken = null;
      }
      int k;
      label246:
      label260:
      label316:
      label532:
      for (;;)
      {
        k = i + 1;
        try
        {
          localStatistic = Util.upload(paramContext, str2, paramBundle);
          paramString = Util.parseJson(localStatistic.response);
        }
        catch (HttpUtils.HttpStatusException paramQQToken)
        {
          Util.Statistic localStatistic;
          long l2;
          long l3;
          paramQQToken.printStackTrace();
          paramContext = paramQQToken.getMessage();
          try
          {
            i = Integer.parseInt(paramContext.replace("http status code error:", ""));
            g.a().a(str1, l1, 0L, 0L, i);
            throw paramQQToken;
          }
          catch (Exception paramContext)
          {
            for (;;)
            {
              paramContext.printStackTrace();
              i = -9;
            }
          }
        }
        catch (HttpUtils.NetworkUnavailableException paramQQToken)
        {
          paramQQToken.printStackTrace();
          throw paramQQToken;
        }
        catch (MalformedURLException paramQQToken)
        {
          paramQQToken.printStackTrace();
          g.a().a(str1, l1, 0L, 0L, -3);
          throw paramQQToken;
        }
        catch (IOException paramQQToken)
        {
          paramQQToken.printStackTrace();
          i = getErrorCodeFromException(paramQQToken);
          g.a().a(str1, l1, 0L, 0L, i);
          throw paramQQToken;
        }
        catch (JSONException paramQQToken)
        {
          paramQQToken.printStackTrace();
          g.a().a(str1, l1, 0L, 0L, -4);
          throw paramQQToken;
        }
        catch (SocketTimeoutException paramString)
        {
          for (;;) {}
        }
        catch (ConnectTimeoutException paramString)
        {
          for (;;) {}
          i = k;
        }
        try
        {
          i = paramString.getInt("ret");
          l2 = localStatistic.reqSize;
          l3 = localStatistic.rspSize;
          g.a().a(str1, l1, l2, l3, i);
          return paramString;
        }
        catch (JSONException paramQQToken)
        {
          i = -4;
          break label246;
        }
        catch (ConnectTimeoutException localConnectTimeoutException)
        {
          paramQQToken = paramString;
          paramString = localConnectTimeoutException;
          paramString.printStackTrace();
          i = -7;
          if (k < j)
          {
            l1 = SystemClock.elapsedRealtime();
            l3 = 0L;
            if (k < j) {
              break label532;
            }
            l2 = 0L;
            paramString = paramQQToken;
            break label260;
          }
          g.a().a(str1, l1, 0L, 0L, -7);
          throw paramString;
        }
        catch (SocketTimeoutException localSocketTimeoutException)
        {
          paramQQToken = paramString;
          paramString = localSocketTimeoutException;
          paramString.printStackTrace();
          i = -8;
          if (k < j)
          {
            l1 = SystemClock.elapsedRealtime();
            break label316;
          }
          g.a().a(str1, l1, 0L, 0L, -8);
          throw paramString;
        }
      }
      str1 = paramString;
      str2 = paramString;
    }
  }
}


/* Location:              E:\apk\dazhihui2\classes2-dex2jar.jar!\com\tencent\open\utils\HttpUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */