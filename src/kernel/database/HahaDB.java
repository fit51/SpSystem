package kernel.database;

import android.os.AsyncTask;
import kernel.tableitem.MyTableItem;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class HahaDB
  extends AsyncTask<Object, Void, Void>
{
  public static MyTableItem[] list1;
  
  public static void createList1(String paramString)
    throws JSONException
  {
    JSONArray localJSONArray = new JSONArray(paramString);
    list1 = new MyTableItem[localJSONArray.length()];
    int i = 0;
    for (;;)
    {
      int j = localJSONArray.length();
      if (i >= j) {
        return;
      }
      JSONObject localJSONObject = localJSONArray.getJSONObject(i);
      MyTableItem[] arrayOfMyTableItem = list1;
      MyTableItem localMyTableItem = new MyTableItem(localJSONObject);
      arrayOfMyTableItem[i] = localMyTableItem;
      i += 1;
    }
  }
  
  public static void createListFromBase()
  {
    list1 = new MyTableItem[15];
    int i = 0;
    for (;;)
    {
      if (i >= 15) {
        return;
      }
      MyTableItem[] arrayOfMyTableItem = list1;
      JSONObject localJSONObject = new JSONObject();
      MyTableItem localMyTableItem = new MyTableItem(localJSONObject);
      arrayOfMyTableItem[i] = localMyTableItem;
      i += 1;
    }
  }
  
  protected Void doInBackground(Object... paramVarArgs)
  {
    createListFromBase();
    return null;
  }
}


/* Location:           C:\Users\Павел\Documents\IdeaProjects\SpSystem\dex2jar-convert\dex2jar-convert\SpSystem.apk.dex2jar.jar
 * Qualified Name:     kernel.database.HahaDB
 * JD-Core Version:    0.7.0.1
 */