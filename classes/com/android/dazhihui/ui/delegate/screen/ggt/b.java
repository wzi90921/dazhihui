package com.android.dazhihui.ui.delegate.screen.ggt;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;

class b
  implements View.OnClickListener
{
  b(GgtCaptialHolding paramGgtCaptialHolding) {}
  
  public void onClick(View paramView)
  {
    GgtCaptialHolding.a(this.a, 1);
    this.a.a();
    GgtCaptialHolding.e(this.a).setTextColor(GgtCaptialHolding.a(this.a));
    GgtCaptialHolding.b(this.a).setTextColor(GgtCaptialHolding.d(this.a));
    GgtCaptialHolding.g(this.a).setTextColor(GgtCaptialHolding.d(this.a));
    GgtCaptialHolding.c(this.a).setBackgroundColor(-1);
    GgtCaptialHolding.f(this.a).setBackgroundResource(2130838694);
    GgtCaptialHolding.h(this.a).setBackgroundColor(-1);
  }
}


/* Location:              E:\apk\dazhihui2\classes-dex2jar.jar!\com\android\dazhihui\ui\delegate\screen\ggt\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */