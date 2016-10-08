package com.qq.jce.wup;

import com.qq.taf.RequestPacket;
import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceUtil;
import java.nio.ByteBuffer;
import java.util.HashMap;

public class UniPacket
  extends UniAttribute
{
  public static final int UniPacketHeadSize = 4;
  static HashMap<String, HashMap<String, byte[]>> cache__tempdata = null;
  static HashMap<String, byte[]> newCache__tempdata = null;
  protected RequestPacket _package = new RequestPacket();
  private int oldRespIret = 0;
  
  public UniPacket()
  {
    this._package.iVersion = 2;
  }
  
  public UniPacket(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      useVersion3();
      return;
    }
    this._package.iVersion = 2;
  }
  
  public byte[] createOldRespEncode()
  {
    Object localObject = new JceOutputStream(0);
    ((JceOutputStream)localObject).setServerEncoding(this.encodeName);
    ((JceOutputStream)localObject).write(this._data, 0);
    localObject = JceUtil.getJceBufArray(((JceOutputStream)localObject).getByteBuffer());
    JceOutputStream localJceOutputStream = new JceOutputStream(0);
    localJceOutputStream.setServerEncoding(this.encodeName);
    localJceOutputStream.write(this._package.iVersion, 1);
    localJceOutputStream.write(this._package.cPacketType, 2);
    localJceOutputStream.write(this._package.iRequestId, 3);
    localJceOutputStream.write(this._package.iMessageType, 4);
    localJceOutputStream.write(this.oldRespIret, 5);
    localJceOutputStream.write((byte[])localObject, 6);
    localJceOutputStream.write(this._package.status, 7);
    return JceUtil.getJceBufArray(localJceOutputStream.getByteBuffer());
  }
  
  public UniPacket createResponse()
  {
    UniPacket localUniPacket = new UniPacket();
    localUniPacket.setRequestId(getRequestId());
    localUniPacket.setServantName(getServantName());
    localUniPacket.setFuncName(getFuncName());
    localUniPacket.setEncodeName(this.encodeName);
    localUniPacket._package.iVersion = this._package.iVersion;
    return localUniPacket;
  }
  
  public void decode(byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte.length < 4) {
      throw new IllegalArgumentException("decode package must include size head");
    }
    try
    {
      paramArrayOfByte = new JceInputStream(paramArrayOfByte, 4);
      paramArrayOfByte.setServerEncoding(this.encodeName);
      readFrom(paramArrayOfByte);
      if (this._package.iVersion == 3)
      {
        paramArrayOfByte = new JceInputStream(this._package.sBuffer);
        paramArrayOfByte.setServerEncoding(this.encodeName);
        if (newCache__tempdata == null)
        {
          newCache__tempdata = new HashMap();
          newCache__tempdata.put("", new byte[0]);
        }
        this._newData = paramArrayOfByte.readMap(newCache__tempdata, 0, false);
        return;
      }
      this._newData = null;
      paramArrayOfByte = new JceInputStream(this._package.sBuffer);
      paramArrayOfByte.setServerEncoding(this.encodeName);
      if (cache__tempdata == null)
      {
        cache__tempdata = new HashMap();
        HashMap localHashMap = new HashMap();
        localHashMap.put("", new byte[0]);
        cache__tempdata.put("", localHashMap);
      }
      this._data = paramArrayOfByte.readMap(cache__tempdata, 0, false);
      this.cachedClassName = new HashMap();
      return;
    }
    catch (Exception paramArrayOfByte)
    {
      throw new RuntimeException(paramArrayOfByte);
    }
  }
  
  public void decodeVersion2(byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte.length < 4) {
      throw new IllegalArgumentException("decode package must include size head");
    }
    try
    {
      paramArrayOfByte = new JceInputStream(paramArrayOfByte, 4);
      paramArrayOfByte.setServerEncoding(this.encodeName);
      readFrom(paramArrayOfByte);
      paramArrayOfByte = new JceInputStream(this._package.sBuffer);
      paramArrayOfByte.setServerEncoding(this.encodeName);
      if (cache__tempdata == null)
      {
        cache__tempdata = new HashMap();
        HashMap localHashMap = new HashMap();
        localHashMap.put("", new byte[0]);
        cache__tempdata.put("", localHashMap);
      }
      this._data = paramArrayOfByte.readMap(cache__tempdata, 0, false);
      this.cachedClassName = new HashMap();
      return;
    }
    catch (Exception paramArrayOfByte)
    {
      throw new RuntimeException(paramArrayOfByte);
    }
  }
  
  public void decodeVersion3(byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte.length < 4) {
      throw new IllegalArgumentException("decode package must include size head");
    }
    try
    {
      paramArrayOfByte = new JceInputStream(paramArrayOfByte, 4);
      paramArrayOfByte.setServerEncoding(this.encodeName);
      readFrom(paramArrayOfByte);
      paramArrayOfByte = new JceInputStream(this._package.sBuffer);
      paramArrayOfByte.setServerEncoding(this.encodeName);
      if (newCache__tempdata == null)
      {
        newCache__tempdata = new HashMap();
        newCache__tempdata.put("", new byte[0]);
      }
      this._newData = paramArrayOfByte.readMap(newCache__tempdata, 0, false);
      return;
    }
    catch (Exception paramArrayOfByte)
    {
      throw new RuntimeException(paramArrayOfByte);
    }
  }
  
  public void display(StringBuilder paramStringBuilder, int paramInt)
  {
    this._package.display(paramStringBuilder, paramInt);
  }
  
  public byte[] encode()
  {
    if (this._package.iVersion == 2)
    {
      if ((this._package.sServantName == null) || (this._package.sServantName.equals(""))) {
        throw new IllegalArgumentException("servantName can not is null");
      }
      if ((this._package.sFuncName == null) || (this._package.sFuncName.equals(""))) {
        throw new IllegalArgumentException("funcName can not is null");
      }
    }
    else
    {
      if (this._package.sServantName == null) {
        this._package.sServantName = "";
      }
      if (this._package.sFuncName == null) {
        this._package.sFuncName = "";
      }
    }
    Object localObject = new JceOutputStream(0);
    ((JceOutputStream)localObject).setServerEncoding(this.encodeName);
    if (this._package.iVersion == 2) {
      ((JceOutputStream)localObject).write(this._data, 0);
    }
    for (;;)
    {
      this._package.sBuffer = JceUtil.getJceBufArray(((JceOutputStream)localObject).getByteBuffer());
      localObject = new JceOutputStream(0);
      ((JceOutputStream)localObject).setServerEncoding(this.encodeName);
      writeTo((JceOutputStream)localObject);
      localObject = JceUtil.getJceBufArray(((JceOutputStream)localObject).getByteBuffer());
      int i = localObject.length;
      ByteBuffer localByteBuffer = ByteBuffer.allocate(i + 4);
      localByteBuffer.putInt(i + 4).put((byte[])localObject).flip();
      return localByteBuffer.array();
      ((JceOutputStream)localObject).write(this._newData, 0);
    }
  }
  
  public String getFuncName()
  {
    return this._package.sFuncName;
  }
  
  public int getOldRespIret()
  {
    return this.oldRespIret;
  }
  
  public int getPackageVersion()
  {
    return this._package.iVersion;
  }
  
  public int getRequestId()
  {
    return this._package.iRequestId;
  }
  
  public String getServantName()
  {
    return this._package.sServantName;
  }
  
  public <T> void put(String paramString, T paramT)
  {
    if (paramString.startsWith(".")) {
      throw new IllegalArgumentException("put name can not startwith . , now is " + paramString);
    }
    super.put(paramString, paramT);
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this._package.readFrom(paramJceInputStream);
  }
  
  public void setFuncName(String paramString)
  {
    this._package.sFuncName = paramString;
  }
  
  public void setOldRespIret(int paramInt)
  {
    this.oldRespIret = paramInt;
  }
  
  public void setRequestId(int paramInt)
  {
    this._package.iRequestId = paramInt;
  }
  
  public void setServantName(String paramString)
  {
    this._package.sServantName = paramString;
  }
  
  public void useVersion3()
  {
    super.useVersion3();
    this._package.iVersion = 3;
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    this._package.writeTo(paramJceOutputStream);
  }
}


/* Location:              E:\apk\dazhihui2\classes-dex2jar.jar!\com\qq\jce\wup\UniPacket.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */