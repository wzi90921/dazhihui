package com.tencent.mobileqq.pb;

public final class PBFixed64Field
  extends PBPrimitiveField<Long>
{
  public static final PBFixed64Field __repeatHelper__ = new PBFixed64Field(0L, false);
  private long value = 0L;
  
  public PBFixed64Field(long paramLong, boolean paramBoolean)
  {
    set(paramLong, paramBoolean);
  }
  
  public void clear(Object paramObject)
  {
    if ((paramObject instanceof Long)) {}
    for (this.value = ((Long)paramObject).longValue();; this.value = 0L)
    {
      setHasFlag(false);
      return;
    }
  }
  
  public int computeSize(int paramInt)
  {
    if (has()) {
      return CodedOutputStreamMicro.computeFixed64Size(paramInt, this.value);
    }
    return 0;
  }
  
  protected int computeSizeDirectly(int paramInt, Long paramLong)
  {
    return CodedOutputStreamMicro.computeFixed64Size(paramInt, paramLong.longValue());
  }
  
  protected void copyFrom(PBField<Long> paramPBField)
  {
    paramPBField = (PBFixed64Field)paramPBField;
    set(paramPBField.value, paramPBField.has());
  }
  
  public long get()
  {
    return this.value;
  }
  
  public void readFrom(CodedInputStreamMicro paramCodedInputStreamMicro)
  {
    this.value = paramCodedInputStreamMicro.readFixed64();
    setHasFlag(true);
  }
  
  protected Long readFromDirectly(CodedInputStreamMicro paramCodedInputStreamMicro)
  {
    return Long.valueOf(paramCodedInputStreamMicro.readFixed64());
  }
  
  public void set(long paramLong)
  {
    set(paramLong, true);
  }
  
  public void set(long paramLong, boolean paramBoolean)
  {
    this.value = paramLong;
    setHasFlag(paramBoolean);
  }
  
  public void writeTo(CodedOutputStreamMicro paramCodedOutputStreamMicro, int paramInt)
  {
    if (has()) {
      paramCodedOutputStreamMicro.writeFixed64(paramInt, this.value);
    }
  }
  
  protected void writeToDirectly(CodedOutputStreamMicro paramCodedOutputStreamMicro, int paramInt, Long paramLong)
  {
    paramCodedOutputStreamMicro.writeFixed64(paramInt, paramLong.longValue());
  }
}


/* Location:              E:\apk\dazhihui2\classes2-dex2jar.jar!\com\tencent\mobileqq\pb\PBFixed64Field.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */