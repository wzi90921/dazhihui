import com.android.thinkive.framework.compatible.MessageAction;
import com.android.thinkive.framework.network.ResponseListener;
import com.android.volley.VolleyError;
import org.json.JSONObject;

final class bd
  implements ResponseListener<JSONObject>
{
  bd(bc parambc, MessageAction paramMessageAction, af paramaf) {}
  
  public final void onErrorResponse(Exception paramException)
  {
    if ((paramException instanceof VolleyError)) {
      this.b.transferAction(2, null, this.c.a());
    }
  }
}


/* Location:              E:\apk\dazhihui2\classes-dex2jar.jar!\bd.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */