package com.android.dazhihui.ui.delegate.screen.fund;

import android.app.DatePickerDialog.OnDateSetListener;
import android.widget.DatePicker;

class bj
  implements DatePickerDialog.OnDateSetListener
{
  bj(FundMutualAIPOpen paramFundMutualAIPOpen) {}
  
  public void onDateSet(DatePicker paramDatePicker, int paramInt1, int paramInt2, int paramInt3)
  {
    FundMutualAIPOpen.d(this.a, paramInt1);
    FundMutualAIPOpen.e(this.a, paramInt2);
    FundMutualAIPOpen.f(this.a, paramInt3);
    FundMutualAIPOpen.g(this.a);
  }
}


/* Location:              E:\apk\dazhihui2\classes-dex2jar.jar!\com\android\dazhihui\ui\delegate\screen\fund\bj.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */