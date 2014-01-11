package kernel;

import android.content.Context;
import android.os.AsyncTask;
import com.example.android.SpSystem.R;
import kernel.database.MyDB;

public class Factory
  extends AsyncTask<Context, Void, Void>
{
  public static MyDB MyDB;
  public static Context _context;
  
  public static void InitFactory(Context paramContext)
  {
    _context = paramContext;
    MyDB = new MyDB();
    MyDB.CreateTable(_context.getString(R.string.t_Task));
    MyDB.CreateTable(_context.getString(R.string.t_TaskStatusHistory));
    MyDB.CreateTable(_context.getString(R.string.t_TaskViewers));
    MyDB.CreateTable(_context.getString(R.string.t_Person));
    MyDB.CreateTable(_context.getString(R.string.t_Client));
  }
  
  protected Void doInBackground(Context... paramVarArgs)
  {
    InitFactory(paramVarArgs[0]);
    return null;
  }
}



/* Location:           C:\Users\Павел\Documents\IdeaProjects\SpSystem\dex2jar-convert\dex2jar-convert\SpSystem.apk.dex2jar.jar

 * Qualified Name:     kernel.Factory

 * JD-Core Version:    0.7.0.1

 */