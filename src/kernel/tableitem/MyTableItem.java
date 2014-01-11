package kernel.tableitem;

import org.json.JSONException;
import org.json.JSONObject;

public class MyTableItem
{
  public String Data;
  public int Id;
  public int PriorityNo;
  public int StatusNo;
  public String Task;
  public String Thema;
  public String Name;
  public int User_status;
  public String Worker;
  public int  ReporterClientNo;
  public int  AssigneePersonNo;

    public MyTableItem(String data, int id, int priority, int status, String task, String thema, int user_status, String worker,
                       int  reporterclientno, int  assigneepersonno, String name) {
        Data = data;
        Id = id;
        PriorityNo = priority;
        StatusNo = status;
        Task = task;
        Thema = thema;
        User_status = user_status;
        Worker = worker;
        ReporterClientNo = reporterclientno;
        AssigneePersonNo = assigneepersonno;
        Name = name;
    }

    public MyTableItem(JSONObject paramJSONObject)
  {
    try
    {
//      this.Id = paramJSONObject.getString("id");
      this.Data = paramJSONObject.getString("data");
//      this.PriorityNo = paramJSONObject.getString("priority");
//      this.StatusNo = paramJSONObject.getString("status");
      this.Thema = paramJSONObject.getString("Thema");
      this.Task = paramJSONObject.getString("Task");
      this.Worker = paramJSONObject.getString("worker");
      this.User_status = Integer.parseInt(paramJSONObject.getString("users_status"));
      return;
    }
    catch (JSONException localJSONException)
    {
      localJSONException.printStackTrace();
    }
  }
}



/* Location:           C:\Users\Павел\Documents\IdeaProjects\SpSystem\dex2jar-convert\dex2jar-convert\SpSystem.apk.dex2jar.jar

 * Qualified Name:     kernel.tableitem.MyTableItem

 * JD-Core Version:    0.7.0.1

 */