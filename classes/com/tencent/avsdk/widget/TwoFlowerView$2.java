package com.tencent.avsdk.widget;

import android.os.Handler;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;

class TwoFlowerView$2
  implements Animation.AnimationListener
{
  TwoFlowerView$2(TwoFlowerView paramTwoFlowerView) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    this.this$0.handler.sendEmptyMessage(0);
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
}


/* Location:              E:\apk\dazhihui2\classes-dex2jar.jar!\com\tencent\avsdk\widget\TwoFlowerView$2.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */