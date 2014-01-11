package kernel.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import kernel.Factory;

public class MyDB
{
  private static SQLiteHelper dbHelper;
  public String CREATE_TABLE;
  public String TABLE_COLUMN_ID = "ID";
  public String TABLE_NAME;
  private Cursor cursor;
  private SQLiteDatabase db;
  
  public MyDB()
  {
    if (dbHelper == null)
    {
        dbHelper = new SQLiteHelper(Factory._context);
    }
    SQLiteDatabase localSQLiteDatabase = dbHelper.getWritableDatabase();
    this.db = localSQLiteDatabase;
  }
  
  public boolean AddRecordTask(int paramInt, ContentValues paramContentValues)
  {
    SQLiteDatabase localSQLiteDatabase = this.db;
    String str = this.TABLE_NAME;
    return (localSQLiteDatabase.insert(str, null, paramContentValues)>0);

  }
  
  public void CreateTable(String paramString)
  {
    this.TABLE_NAME = paramString;
    if (paramString.equalsIgnoreCase("Task"))
    {
      String str = "create table if not exists "+ this.TABLE_NAME + "("+this.TABLE_COLUMN_ID
            + " integer unique not null, " + "ServiceNo integer, " + "OwnerNo integer not null, " + "ReporterClientNo integer, " + "ReporterPersonNo integer, " + "AssigneeClientNo integer, " + "AssigneePersonNo integer, " + "StatusNo integer, " + "PriorityNo integer, " + "ParentNo integer, " + "Theme VARCHAR(255), " + "Name VARCHAR(255) NOT NULL, " + "Description VARCHAR(4096), " + "StartDate DATE, " + "EndDate DATE, " + "Duration NUMERIC(8,2), " + "ActualWork NUMERIC(8,2), " + "CreationTime DATE NOT NULL, " + "ModificationTime DATE NOT NULL); ";
      this.CREATE_TABLE = str;
    }
      if (paramString.equalsIgnoreCase("TaskStatusHistory"))
      {
        String str = ("create table if not exists ");
        str += this.TABLE_NAME + "("+this.TABLE_COLUMN_ID+" integer unique not null, "
                + "CreatedAt TIMESTAMP not null, " + "CreatedBy integer not null, " + "Note BLOB, " + "StatusNo integer not null, " + "TaskNo integer not null, " + "WorkTime TIME, " + "DocID integer); ";
        this.CREATE_TABLE = str;
      }
      else if (paramString.equalsIgnoreCase("TaskViewers"))
      {
          String str = ("create table if not exists ")+this.TABLE_NAME+"("+ this.TABLE_COLUMN_ID+ " integer unique not null, " + "TaskID integer default 0 not null, " + "PersonID integer default 0 not null, " + "isApprove smallint default 0 not null, " + "isDirector smallint default 0 not null); ";
        this.CREATE_TABLE = str;
      }
      else if (paramString.equalsIgnoreCase("Person"))
      {
          String str = ("create table if NOT exists ")+this.TABLE_NAME+"("+this.TABLE_COLUMN_ID+" integer unique not null, " + "LastName varchar(100) not null, " + "FirstName varchar(100) default '', " + "MiddleName varchar(100) default '', " + "Birthday DATE, " + "IsPrivate SMALLINT DEFAULT 0 NOT NULL," + "Photo             BLOB ," + "Comment           BLOB ," + "UserName          VARCHAR(20) ," + "BirthPlace        VARCHAR(255) ," + "TabNumber         VARCHAR(7)," + "INN                 VARCHAR(12)," + "InsurenceNumber   VARCHAR(14)," + "Alphabet          VARCHAR(20)," + "GenderNo          INTEGER ," + "MaritalStatusNo   INTEGER ," + "Residance         VARCHAR(100), " + "Index1             VARCHAR(7)," + "RegistrationDate  DATE," + "Functioning       VARCHAR(50)," + "    Citizenship       VARCHAR(50)," + "    FormTypeNo        INTEGER ," + "    FormTypeProfNo    INTEGER ," + "    DriverLicense     VARCHAR(50)," + "    BossNo            INTEGER ," + "    SecurityLevel     INTEGER DEFAULT 0 NOT NULL ," + "    ResPermAddr       VARCHAR(255) ," + "    RegistrAddr       VARCHAR(255) ," + "    ntID              INTEGER DEFAULT 0 ," + "    OwnerNo           INTEGER DEFAULT 0 NOT NULL ," + "    AgentType         SMALLINT ," + "    Doc               VARCHAR(100) ," + "    Seria             VARCHAR(10) ," + "    No                VARCHAR(20) ," + "    DocDate           DATE ," + "    DocWho            VARCHAR(255) ," + "    Country           SMALLINT ," + "    DepartmentNo      INTEGER" + "); ";
        this.CREATE_TABLE = str;
      }
      else if (paramString.equalsIgnoreCase("Client"))
      {
          String str = "create table if not exists "+ this.TABLE_NAME+ "("+this.TABLE_COLUMN_ID+ " integer unique not null, " + "ClientUID           VARCHAR(4) NOT NULL," + "    GroupNo             INTEGER NOT NULL," + "    Alias               VARCHAR(25) NOT NULL," + "    isReserved          SMALLINT DEFAULT 0 NOT NULL," + "    isArdoClient        SMALLINT DEFAULT 1 NOT NULL," + "    ClientPassword      VARCHAR(50)," + "    isMailEnabled       SMALLINT DEFAULT 1 NOT NULL," + "    EMail               VARCHAR(50)," + "    PopServer           VARCHAR(50)," + "    SmtpServer          VARCHAR(50)," + "    EMailAccount        VARCHAR(50)," + "    EMailPassword       VARCHAR(50)," + "    Sender              VARCHAR(50)," + "    isStatement         SMALLINT DEFAULT 1 NOT NULL," + "    Catalog             VARCHAR(250)," + "    isConfirm           SMALLINT DEFAULT 1 NOT NULL," + "    Comment             BLOB," + "    MailBox             INTEGER DEFAULT 0 NOT NULL," + "    OwnerID             INTEGER DEFAULT 0 NOT NULL," + "    DepartmentID        INTEGER ," + "    ManagerID           INTEGER ," + "    CategoryNo          INTEGER DEFAULT 0 NOT NULL," + "    ClientVersionID     INTEGER ," + "    HoldingID           INTEGER ," + "    CodeEXT             VARCHAR(20) ," + "    StatusID            INTEGER DEFAULT 0 ," + "    Active              SMALLINT DEFAULT 1 NOT NULL," + "    ProfileNo           INTEGER ," + "    ActivityTypeNo      INTEGER," + "    OwnerNo             INTEGER DEFAULT 0 NOT NULL ," + "    ExtNo               VARCHAR(50) ," + "    BrokerNo            INTEGER ," + "    UCode               CHAR(4) DEFAULT '0000' NOT NULL," + "    DateRegistered      DATE ," + "    ClientPassword2     VARCHAR(50) ," + "    WebPassword         VARCHAR(50) ," + "    WebCardPassword     VARCHAR(50) ," + "    WebDocNo            INTEGER DEFAULT 1 NOT NULL," + "    WebEdit             SMALLINT DEFAULT 0 NOT NULL," + "    isBudgetControl     SMALLINT DEFAULT 0 NOT NULL," + "    DateEnd             DATE ," + "    DateEndComment     VARCHAR(1000)," + "    WebOldestOrderDate   DATE " + "); ";
        this.CREATE_TABLE = str;
      }
      try{
          db.execSQL(CREATE_TABLE);
      } catch (SQLiteException E) {
          E.printStackTrace();
      }
    }
//  }
  
  public void ExecSQL(String paramString)
  {
    this.db.execSQL(paramString);
  }
  
  public SQLiteDatabase getDb()
  {
    return this.db;
  }

    private class SQLiteHelper extends SQLiteOpenHelper {
        private static final String DATABASE_NAME = "SpSystem.db";
        private static final int DATABASE_VERSION = 1;

        private SQLiteHelper(Context c) {
            super(c, DATABASE_NAME, null, DATABASE_VERSION);
        }

        @Override
        public void onCreate(SQLiteDatabase db) {
        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            Log.w(SQLiteHelper.class.getName(), "Upgrading database from version " + oldVersion + " to " + newVersion + ", which will destroy all old data");
            db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
            onCreate(db);
        }
    }
}



/* Location:           C:\Users\Павел\Documents\IdeaProjects\SpSystem\dex2jar-convert\dex2jar-convert\SpSystem.apk.dex2jar.jar

 * Qualified Name:     kernel.database.MyDB

 * JD-Core Version:    0.7.0.1

 */