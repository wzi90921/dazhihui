package com.android.dazhihui.ui.delegate.screen;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;

class bz
  implements View.OnClickListener
{
  bz(EntrustTable_history paramEntrustTable_history) {}
  
  public void onClick(View paramView)
  {
    if ((this.a.f.getText().toString().length() == 0) || (this.a.g.getText().toString().length() == 0))
    {
      this.a.a(0);
      return;
    }
    if ((this.a.f.getText().toString().length() != 8) || (this.a.g.getText().toString().length() != 8))
    {
      this.a.a(1);
      return;
    }
    if (this.a.f.getText().toString().compareTo(this.a.g.getText().toString()) > 0)
    {
      this.a.a(2);
      return;
    }
    this.a.a(true);
    EntrustTable_history.c(this.a);
  }
}


/* Location:              E:\apk\dazhihui2\classes-dex2jar.jar!\com\android\dazhihui\ui\delegate\screen\bz.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */