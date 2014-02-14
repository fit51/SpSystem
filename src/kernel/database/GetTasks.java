package kernel.database;

import android.database.Cursor;
import android.database.CursorIndexOutOfBoundsException;
import android.database.sqlite.SQLiteDatabase;
import com.example.android.SpSystem.R;
import kernel.Factory;
import kernel.tableitem.MyTableItem;

import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Created with IntelliJ IDEA.
 * User: Павел
 * Date: 05.01.14
 * Time: 0:06
 * To change this template use File | Settings | File Templates.
 */
public class GetTasks {
    public static MyTableItem[] alltasks;
    public static void getAllTasks(){
        ArrayList<MyTableItem> list = new ArrayList<MyTableItem>();

        SQLiteDatabase db = Factory.MyDB.getDb();
        String[] columns = {"ID", "Theme","Name", "Description", "CreationTime", "AssigneePersonNo", "ReporterClientNo", "PriorityNo", "StatusNo"};
        String[] columns2 = {"LastName", "FirstName" , "MiddleName"};
        Cursor c = db.query(Factory._context.getString(R.string.t_Task),columns,null,null,null,null,null);
        if(c!=null && c.getCount()>0){
        int iId = c.getColumnIndex("ID");
        int iTheme = c.getColumnIndex("Theme");
        int iName = c.getColumnIndex("Name");
        int iDescription = c.getColumnIndex("Description");
        int iStartDate = c.getColumnIndex("CreationTime");
        int iAssigneePersonNo = c.getColumnIndex("AssigneePersonNo");
        int iReporterClientNo = c.getColumnIndex("ReporterClientNo");
        int iPriorityNo = c.getColumnIndex("PriorityNo");
        int iStatusNo = c.getColumnIndex("StatusNo");
        for (c.moveToFirst(); !c.isAfterLast(); c.moveToNext()) {
            String[] args =  {String.valueOf(c.getInt(iAssigneePersonNo))};
            Cursor c2 = db.query(Factory._context.getString(R.string.t_Person),columns2,"ID=?",args,null,null,null,null);
            c2.moveToFirst();
            String worker = "";
            try{
            if(!c2.isAfterLast()){
//                String lname, fname, mname;
//                lname = c2.getString(c2.getColumnIndex("LastName"));
//                fname = c2.getString(c2.getColumnIndex("FirstName"));
//                mname = c2.getString(c2.getColumnIndex("MiddleName"));
             worker = c2.getString(c2.getColumnIndex("LastName"))+ " "+ c2.getString(c2.getColumnIndex("FirstName"))+ " "+c2.getString(c2.getColumnIndex("MiddleName"));
            }

            MyTableItem item = new MyTableItem(c.getString(iStartDate),c.getInt(iId),c.getInt(iPriorityNo),
                    c.getInt(iStatusNo),c.getString(iDescription),c.getString(iTheme),0,worker,c.getInt(iReporterClientNo),c.getInt(iAssigneePersonNo), c.getString(iName));

            list.add(item);
            } catch (CursorIndexOutOfBoundsException e){
                e.printStackTrace();
            }
        }
            MyTableItem[] it  = new MyTableItem[list.size()];
            alltasks = list.toArray(it);
        }

    }
}
