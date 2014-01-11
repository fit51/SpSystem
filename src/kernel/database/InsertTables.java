package kernel.database;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.os.AsyncTask;
import android.util.Log;
import kernel.Factory;

import java.util.logging.Logger;

public class InsertTables
  extends AsyncTask<Object, Void, Void>
{
  private static SQLiteDatabase db = Factory.MyDB.getDb();
  private static String[] sInsertClient;
  private static String[] sInsertPerson;
  private static String[] sInsertTask;
  private static String[] sInsertTaskStatusHistory;
  private static String[] sInsertTaskViewers;
  
  static
  {
    String[] arrayOfString1 ={"INSERT INTO Task (ID, ServiceNo, ReporterClientNo, ReporterPersonNo, AssigneeClientNo, AssigneePersonNo, StatusNo, PriorityNo, ParentNo, Theme, Name, Description, StartDate, EndDate, CreationTime, ModificationTime, OwnerNo, Duration, ActualWork)" +
            "              VALUES (5591450, NULL, 0, NULL, NULL, 5590242, 1206, 1102, NULL, 'Обучение', 'Обучение работы с задачами, сообщениями и т.д.', NULL, NULL, NULL, '2013-09-23', '2013-09-23', 5590242, NULL, NULL);" ,
            "INSERT INTO Task (ID, ServiceNo, ReporterClientNo, ReporterPersonNo, AssigneeClientNo, AssigneePersonNo, StatusNo, PriorityNo, ParentNo, Theme, Name, Description, StartDate, EndDate, CreationTime, ModificationTime, OwnerNo, Duration, ActualWork)" +
            "              VALUES (5591728, NULL, 0, NULL, NULL, 5590242, 1207, 1102, NULL, 'На осн. задачи № 5591450', '<?>', '', '2013-09-23', '2013-09-23', '2013-09-23', '2013-09-23', 5590242, NULL, NULL);" ,
            "INSERT INTO Task (ID, ServiceNo, ReporterClientNo, ReporterPersonNo, AssigneeClientNo, AssigneePersonNo, StatusNo, PriorityNo, ParentNo, Theme, Name, Description, StartDate, EndDate, CreationTime, ModificationTime, OwnerNo, Duration, ActualWork)" +
            "              VALUES (5593144, NULL, 3147708, NULL, NULL, 5590242, 1203, 1102, NULL, 'Android', 'Разработать приложение на Android(скорее всего для планшета)', NULL, NULL, NULL, '2013-09-23', '2013-09-23', 5590242, NULL, NULL);" ,
            "INSERT INTO Task (ID, ServiceNo, ReporterClientNo, ReporterPersonNo, AssigneeClientNo, AssigneePersonNo, StatusNo, PriorityNo, ParentNo, Theme, Name, Description, StartDate, EndDate, CreationTime, ModificationTime, OwnerNo, Duration, ActualWork)" +
            "              VALUES (5593252, NULL, 3147708, NULL, NULL, 5590242, 1202, 1102, NULL, 'Веб-конференция', 'Доработка open-source проекта веб-конференции', NULL, NULL, NULL, '2013-09-23', '2013-09-23', 5590242, NULL, NULL);" ,
            "INSERT INTO Task (ID, ServiceNo, ReporterClientNo, ReporterPersonNo, AssigneeClientNo, AssigneePersonNo, StatusNo, PriorityNo, ParentNo, Theme, Name, Description, StartDate, EndDate, CreationTime, ModificationTime, OwnerNo, Duration, ActualWork)" +
            "              VALUES (5593323, NULL, 3147708, NULL, NULL, 5590242, 1206, 1102, NULL, 'На осн. задачи № 5593252', 'Ознакомиться с различными проектами', 'Рассмотреть  http://www.bigbluebutton.org/ и http://www.gvoconference.com/ru/features.php. . Установить их, разобраться в конфигурировании, собрать документацию, установить работоспособность.', '2013-09-23', '2013-09-23', '2013-09-23', '2013-09-23', 5590242, NULL, NULL);" ,
            "INSERT INTO Task (ID, ServiceNo, ReporterClientNo, ReporterPersonNo, AssigneeClientNo, AssigneePersonNo, StatusNo, PriorityNo, ParentNo, Theme, Name, Description, StartDate, EndDate, CreationTime, ModificationTime, OwnerNo, Duration, ActualWork)" +
            "              VALUES (5615084, NULL, 3147708, NULL, NULL, 5590242, 1205, 1102, NULL, 'На осн. задачи № 5593252', 'Поставить BigBlueButton на реальную машину', 'Максимально настроить, посмотреть и проанализировать функционал на практике', '2013-09-25', '2013-09-25', '2013-09-25', '2013-09-25', 5590242, NULL, NULL);" ,
            "INSERT INTO Task (ID, ServiceNo, ReporterClientNo, ReporterPersonNo, AssigneeClientNo, AssigneePersonNo, StatusNo, PriorityNo, ParentNo, Theme, Name, Description, StartDate, EndDate, CreationTime, ModificationTime, OwnerNo, Duration, ActualWork)" +
            "              VALUES (5615485, NULL, 3147708, NULL, NULL, 5590242, 1205, 1102, NULL, 'Приложения для конввертации img в PDF', 'Найти удобное приложения для конввертации img в PDF', NULL, NULL, NULL, '2013-09-25', '2013-09-25', 5590242, NULL, NULL);" ,
            "INSERT INTO Task (ID, ServiceNo, ReporterClientNo, ReporterPersonNo, AssigneeClientNo, AssigneePersonNo, StatusNo, PriorityNo, ParentNo, Theme, Name, Description, StartDate, EndDate, CreationTime, ModificationTime, OwnerNo, Duration, ActualWork)" +
            "              VALUES (5652751, NULL, 3147708, NULL, NULL, 5590242, 1206, 1102, NULL, 'Обучение FastReport', 'Обучение FastReport', NULL, NULL, NULL, '2013-10-02', '2013-10-02', 5590242, NULL, NULL);"};
    sInsertTask = arrayOfString1;
    String[] arrayOfString2 = {"INSERT INTO TaskStatusHistory (ID, CreatedAt, CreatedBy, Note, StatusNo, TaskNo, WorkTime)" +
            "                           VALUES (5591498, '2013-09-23 11:10:34', 5590242, '', 1202, 5591450, NULL);" ,
            "INSERT INTO TaskStatusHistory (ID, CreatedAt, CreatedBy, Note, StatusNo, TaskNo, WorkTime)" +
            "                           VALUES (5591518, '2013-09-23 11:11:42', 5590242, '', 1203, 5591450, NULL);" ,
            "INSERT INTO TaskStatusHistory (ID, CreatedAt, CreatedBy, Note, StatusNo, TaskNo, WorkTime)" +
            "                           VALUES (5591594, '2013-09-23 11:18:57', 5590242, 'Тест', 1211, 5591450, '00:15:00');" ,
            "INSERT INTO TaskStatusHistory (ID, CreatedAt, CreatedBy, Note, StatusNo, TaskNo, WorkTime)" +
            "                           VALUES (5591785, '2013-09-23 11:30:03', 5590242, '', 1207, 5591728, NULL);" ,
            "INSERT INTO TaskStatusHistory (ID, CreatedAt, CreatedBy, Note, StatusNo, TaskNo, WorkTime)" +
            "                           VALUES (5592053, '2013-09-23 11:39:22', 5590242, '', 1205, 5591450, NULL);" ,
            "INSERT INTO TaskStatusHistory (ID, CreatedAt, CreatedBy, Note, StatusNo, TaskNo, WorkTime)" +
            "                           VALUES (5592376, '2013-09-23 11:41:08', 5590242, '', 1206, 5591450, '00:30:00');" ,
            "INSERT INTO TaskStatusHistory (ID, CreatedAt, CreatedBy, Note, StatusNo, TaskNo, WorkTime)" +
            "                           VALUES (5592412, '2013-09-23 11:42:36', 5590242, '', 1205, 5591450, NULL);" ,
            "INSERT INTO TaskStatusHistory (ID, CreatedAt, CreatedBy, Note, StatusNo, TaskNo, WorkTime)" +
            "                           VALUES (5592749, '2013-09-23 11:52:16', 5590242, '', 1206, 5591450, NULL);" ,
            "INSERT INTO TaskStatusHistory (ID, CreatedAt, CreatedBy, Note, StatusNo, TaskNo, WorkTime)" +
            "                           VALUES (5593291, '2013-09-23 12:05:19', 5590242, 'Ознакомление', 1202, 5593252, '00:10:00');" ,
            "INSERT INTO TaskStatusHistory (ID, CreatedAt, CreatedBy, Note, StatusNo, TaskNo, WorkTime)" +
            "                           VALUES (5593510, '2013-09-23 12:16:15', 5590242, 'Ознакомление с задачей', 1202, 5593323, '00:10:00');" ,
            "INSERT INTO TaskStatusHistory (ID, CreatedAt, CreatedBy, Note, StatusNo, TaskNo, WorkTime)" +
            "                           VALUES (5594013, '2013-09-23 12:52:30', 5590242, 'Скачивание VMPLAYER и bibluebutton-VM', 1210, 5593323, NULL);" ,
            "INSERT INTO TaskStatusHistory (ID, CreatedAt, CreatedBy, Note, StatusNo, TaskNo, WorkTime)" +
            "                           VALUES (5594048, '2013-09-23 12:54:04', 5590242, 'Скачивание VMPLAYER и bibluebutton-VM и winrar', 1211, 5593323, '01:00:00');" ,
            "INSERT INTO TaskStatusHistory (ID, CreatedAt, CreatedBy, Note, StatusNo, TaskNo, WorkTime)" +
            "                           VALUES (5595434, '2013-09-23 14:16:16', 5590242, 'Установка и конфигурирование bigbluebutton', 1211, 5593323, '02:00:00');" ,
            "INSERT INTO TaskStatusHistory (ID, CreatedAt, CreatedBy, Note, StatusNo, TaskNo, WorkTime)" +
            "                           VALUES (5595822, '2013-09-23 14:54:39', 5590242, 'Тестирование BBB', 1210, 5593323, NULL);" ,
            "INSERT INTO TaskStatusHistory (ID, CreatedAt, CreatedBy, Note, StatusNo, TaskNo, WorkTime)" +
            "                           VALUES (5602691, '2013-09-24 15:02:10', 5590242, 'Ознакомление с gvoconference', 1210, 5593323, NULL);" ,
            "INSERT INTO TaskStatusHistory (ID, CreatedAt, CreatedBy, Note, StatusNo, TaskNo, WorkTime)" +
            "                           VALUES (5603311, '2013-09-24 16:02:27', 5590242, 'Тестирование openmeetings', 1211, 5593323, '01:00:00');" ,
            "INSERT INTO TaskStatusHistory (ID, CreatedAt, CreatedBy, Note, StatusNo, TaskNo, WorkTime)" +
            "                           VALUES (5605749, '2013-09-24 18:09:08', 5590242, '3 системы веб-конференций готовыв к тестированию(установлены локально)', 1210, 5593323, NULL);" ,
            "INSERT INTO TaskStatusHistory (ID, CreatedAt, CreatedBy, Note, StatusNo, TaskNo, WorkTime)" +
            "                           VALUES (5615000, '2013-09-25 17:40:57', 5590242, '', 1203, 5593323, NULL);" ,
            "INSERT INTO TaskStatusHistory (ID, CreatedAt, CreatedBy, Note, StatusNo, TaskNo, WorkTime)" +
            "                           VALUES (5615025, '2013-09-25 17:41:13', 5590242, 'Для дальнейшего изучения и глубокого использования выбранно решение BigBlueButton!', 1205, 5593323, NULL);" ,
            "INSERT INTO TaskStatusHistory (ID, CreatedAt, CreatedBy, Note, StatusNo, TaskNo, WorkTime)" +
            "                           VALUES (5615058, '2013-09-25 17:43:40', 5590242, '', 1206, 5593323, NULL);" ,
            "INSERT INTO TaskStatusHistory (ID, CreatedAt, CreatedBy, Note, StatusNo, TaskNo, WorkTime)" +
            "                           VALUES (5615514, '2013-09-25 18:04:29', 5590242, '', 1202, 5615485, NULL);" ,
            "INSERT INTO TaskStatusHistory (ID, CreatedAt, CreatedBy, Note, StatusNo, TaskNo, WorkTime)" +
            "                           VALUES (5616186, '2013-09-25 18:28:16', 5590242, 'pdf виртуальный принтер', 1210, 5615485, NULL);" ,
            "INSERT INTO TaskStatusHistory (ID, CreatedAt, CreatedBy, Note, StatusNo, TaskNo, WorkTime)" +
            "                           VALUES (5618239, '2013-09-26 11:49:36', 5590242, 'Формирование инструкции с 2-мя вариантами конвер', 1211, 5615485, '03:00:00');" ,
            "INSERT INTO TaskStatusHistory (ID, CreatedAt, CreatedBy, Note, StatusNo, TaskNo, WorkTime)" +
            "                           VALUES (5618254, '2013-09-26 11:51:09', 5590242, '', 1203, 5615485, NULL);" ,
            "INSERT INTO TaskStatusHistory (ID, CreatedAt, CreatedBy, Note, StatusNo, TaskNo, WorkTime)" +
            "                           VALUES (5618281, '2013-09-26 11:53:16', 5590242, '', 1205, 5615485, NULL);" ,
            "INSERT INTO TaskStatusHistory (ID, CreatedAt, CreatedBy, Note, StatusNo, TaskNo, WorkTime)" +
            "                           VALUES (5618316, '2013-09-26 11:53:43', 5590242, '', 1202, 5615084, NULL);" ,
            "INSERT INTO TaskStatusHistory (ID, CreatedAt, CreatedBy, Note, StatusNo, TaskNo, WorkTime)" +
            "                           VALUES (5618333, '2013-09-26 11:53:57', 5590242, '', 1203, 5615084, NULL);" ,
            "INSERT INTO TaskStatusHistory (ID, CreatedAt, CreatedBy, Note, StatusNo, TaskNo, WorkTime)" +
            "                           VALUES (5628189, '2013-09-27 14:14:16', 5590242, 'Поставил uubntu10.04 , различные утилиты для работы BBB, поставил BBB, демки,  все запустил и проверил, начал разбираться в устройстве и настройке', 1211, 5615084, NULL);" ,
            "INSERT INTO TaskStatusHistory (ID, CreatedAt, CreatedBy, Note, StatusNo, TaskNo, WorkTime)" +
            "                           VALUES (5631389, '2013-09-30 09:53:25', 5590242, 'Анализирование demo.jsp для интеграции bigbluebutton', 1210, 5615084, NULL);" ,
            "INSERT INTO TaskStatusHistory (ID, CreatedAt, CreatedBy, Note, StatusNo, TaskNo, WorkTime)" +
            "                           VALUES (5631423, '2013-09-30 09:54:27', 5590242, 'Запуск openmeetings из исходников и нахождение swf файлов для клиента', 1210, 5593252, NULL);" ,
            "INSERT INTO TaskStatusHistory (ID, CreatedAt, CreatedBy, Note, StatusNo, TaskNo, WorkTime)" +
            "                           VALUES (5652776, '2013-10-02 19:05:25', 5590242, 'Доделал отчет ControlGroupOborot', 1211, 5652751, '03:00:00');" ,
            "INSERT INTO TaskStatusHistory (ID, CreatedAt, CreatedBy, Note, StatusNo, TaskNo, WorkTime)" +
            "                           VALUES (5652791, '2013-10-02 19:05:58', 5590242, '', 1206, 5652751, NULL);" ,
            "INSERT INTO TaskStatusHistory (ID, CreatedAt, CreatedBy, Note, StatusNo, TaskNo, WorkTime)" +
            "                           VALUES (5652810, '2013-10-02 19:06:12', 5590242, '', 1202, 5593144, NULL);" ,
            "INSERT INTO TaskStatusHistory (ID, CreatedAt, CreatedBy, Note, StatusNo, TaskNo, WorkTime)" +
            "                           VALUES (5652823, '2013-10-02 19:06:21', 5590242, 'Реализация http get запроса, для получения Json строки', 1211, 5593144, '02:00:00');" ,
            "INSERT INTO TaskStatusHistory (ID, CreatedAt, CreatedBy, Note, StatusNo, TaskNo, WorkTime)" +
            "                           VALUES (5652841, '2013-10-02 19:07:08', 5590242, '', 1203, 5593144, NULL);" ,
            "INSERT INTO TaskStatusHistory (ID, CreatedAt, CreatedBy, Note, StatusNo, TaskNo, WorkTime)" +
            "                           VALUES (5660541, '2013-10-03 14:06:58', 5590242, 'Реализовано! перпедача Json массива объектов(строка в таблице задач) и вывод на экран', 1211, 5593144, '03:00:00');" ,
            "INSERT INTO TaskStatusHistory (ID, CreatedAt, CreatedBy, Note, StatusNo, TaskNo, WorkTime)" +
            "                           VALUES (5660569, '2013-10-03 14:08:47', 5590242, 'скрипты на сайте и сервере', 1211, 5615084, '02:00:00');" ,
            "INSERT INTO TaskStatusHistory (ID, CreatedAt, CreatedBy, Note, StatusNo, TaskNo, WorkTime)" +
            "                           VALUES (5693676, '2013-10-09 18:48:05', 5590242, 'Реализация навигации приложения', 1211, 5593144, '09:00:00');" ,
            "INSERT INTO TaskStatusHistory (ID, CreatedAt, CreatedBy, Note, StatusNo, TaskNo, WorkTime)" +
            "                           VALUES (5766345, '2013-10-18 12:31:24', 5590242, '', 1205, 5615084, '10:00:00');" ,
            "INSERT INTO TaskStatusHistory (ID, CreatedAt, CreatedBy, Note, StatusNo, TaskNo, WorkTime)" +
            "                           VALUES (5766368, '2013-10-18 12:31:53', 5590242, 'Дизайн списка задач , база данных', 1211, 5593144, '15:00:00');" ,
            "INSERT INTO TaskStatusHistory (ID, CreatedAt, CreatedBy, Note, StatusNo, TaskNo, WorkTime)" +
            "                           VALUES (5766585, '2013-10-18 12:50:28', 5590242, 'Установка на CentOS', 1211, 5615084, '04:00:00');"};
    sInsertTaskStatusHistory = arrayOfString2;
    String[] arrayOfString3 = {"INSERT INTO TaskViewers (ID, TaskID, PersonID, isApprove, isDirector)" +
            "                     VALUES (5591452, 5591450, 2991174, 0, 0);" ,
            "INSERT INTO TaskViewers (ID, TaskID, PersonID, isApprove, isDirector)" +
            "                     VALUES (5591775, 5591728, 2991174, 0, 0);" ,
            "INSERT INTO TaskViewers (ID, TaskID, PersonID, isApprove, isDirector)" +
            "                     VALUES (5593146, 5593144, 2991174, 0, 0);" ,
            "INSERT INTO TaskViewers (ID, TaskID, PersonID, isApprove, isDirector)" +
            "                     VALUES (5593254, 5593252, 2991174, 0, 0);" ,
            "INSERT INTO TaskViewers (ID, TaskID, PersonID, isApprove, isDirector)" +
            "                     VALUES (5593490, 5593323, 2991174, 0, 0);" ,
            "INSERT INTO TaskViewers (ID, TaskID, PersonID, isApprove, isDirector)" +
            "                     VALUES (5615487, 5615485, 2991174, 0, 0);" ,
            "INSERT INTO TaskViewers (ID, TaskID, PersonID, isApprove, isDirector)" +
            "                     VALUES (5618303, 5615084, 2991174, 0, 0);" ,
            "INSERT INTO TaskViewers (ID, TaskID, PersonID, isApprove, isDirector)" +
            "                     VALUES (5652753, 5652751, 2991174, 0, 0);"};
    sInsertTaskViewers = arrayOfString3;
    String[] arrayOfString4 = {"INSERT INTO Client (ID, ClientUID, GroupNo, Alias, isReserved, isArdoClient, ClientPassword, isMailEnabled, EMail, PopServer, SmtpServer, EMailAccount, EMailPassword, Sender, isStatement, Catalog, isConfirm, Comment, MailBox, OwnerID, DepartmentID, ManagerID, CategoryNo, ClientVersionID, HoldingID, CodeEXT, StatusID, Active, ProfileNo, ActivityTypeNo, OwnerNo, ExtNo, BrokerNo, UCode, DateRegistered, ClientPassword2, WebPassword, WebCardPassword, WebDocNo, WebEdit, isBudgetControl, DateEnd, DateEndComment, WebOldestOrderDate)" +
            "                VALUES (0, '0000', 10001, 'SPTECH', 0, 0, '???', 0, NULL, NULL, NULL, NULL, NULL, NULL, 0, '-', 1, NULL, 0, 0, 2261243, NULL, 1014, NULL, NULL, NULL, 302, 1, NULL, NULL, 0, NULL, NULL, '0000', '2000-01-01', NULL, NULL, NULL, 1, 0, 1, NULL, NULL, NULL);" ,
            "INSERT INTO Client (ID, ClientUID, GroupNo, Alias, isReserved, isArdoClient, ClientPassword, isMailEnabled, EMail, PopServer, SmtpServer, EMailAccount, EMailPassword, Sender, isStatement, Catalog, isConfirm, Comment, MailBox, OwnerID, DepartmentID, ManagerID, CategoryNo, ClientVersionID, HoldingID, CodeEXT, StatusID, Active, ProfileNo, ActivityTypeNo, OwnerNo, ExtNo, BrokerNo, UCode, DateRegistered, ClientPassword2, WebPassword, WebCardPassword, WebDocNo, WebEdit, isBudgetControl, DateEnd, DateEndComment, WebOldestOrderDate)" +
            "                VALUES (3147708, '0049', 10003, 'КОНОВАЛОВ', 0, 0, '?', 0, NULL, NULL, NULL, NULL, NULL, NULL, 0, '$(APPDIR)\\Outbox', 0, :h00000000_000001FE, 0, 0, 0, 0, 1014, NULL, NULL, NULL, 302, 1, NULL, NULL, 0, NULL, NULL, '0000', '2009-07-20', NULL, NULL, NULL, 1, 0, 0, NULL, NULL, NULL);"};
    sInsertClient = arrayOfString4;
    String[] arrayOfString5 = {"INSERT INTO Person (ID, LastName, FirstName, MiddleName, Birthday, IsPrivate, UserName, BirthPlace, TabNumber, INN, InsurenceNumber, Alphabet, GenderNo, MaritalStatusNo, Residance, Index1, RegistrationDate, Functioning, Citizenship, FormTypeNo, FormTypeProfNo, DriverLicense, BossNo, SecurityLevel, ResPermAddr, RegistrAddr)                VALUES (5590242, 'Кондратюк', 'Павел', 'Александрович', NULL, 1, 'TS_004', NULL, NULL, NULL, NULL, NULL, 303019, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 2991174, 0, NULL, NULL);"};
    sInsertPerson = arrayOfString5;
  }
  
  public static void DeleteTableData()
  {
    try
    {
      db.delete("Task", null, null);
      db.delete("TaskStatusHistory", null, null);
      db.delete("TaskViewers", null, null);
      db.delete("Client", null, null);
      db.delete("Person", null, null);
      return;
    }
    catch (SQLiteException localSQLiteException)
    {
        localSQLiteException.printStackTrace();
    }
  }
  
  public static void InsertClient()
  {
    int i = 0;
    for (;;)
    {
      int j = sInsertClient.length;
      if (i >= j) {
        return;
      }
      try
      {
        SQLiteDatabase localSQLiteDatabase = db;
        String str = sInsertClient[i];
          i += 1;
        localSQLiteDatabase.execSQL(str);

      }
      catch (SQLiteException localSQLiteException)
      {
          localSQLiteException.printStackTrace();
      }
    }
  }
  
  public static void InsertPerson()
  {
    int i = 0;
    for (;;)
    {
      int j = sInsertPerson.length;
      if (i >= j) {
        return;
      }
      try
      {
        SQLiteDatabase localSQLiteDatabase = db;
        String str = sInsertPerson[i];
          i += 1;
        localSQLiteDatabase.execSQL(str);

      }
      catch (SQLiteException localSQLiteException)
      {
          localSQLiteException.printStackTrace();
      }
    }
  }
  
  public static void InsertTask()
  {
    int i = 0;
    for (;;)
    {
      int j = sInsertTask.length;
      if (i >= j) {
        return;
      }
      try
      {
        SQLiteDatabase localSQLiteDatabase = db;
        String str = sInsertTask[i];
          i += 1;
        localSQLiteDatabase.execSQL(str);

      }
      catch (SQLiteException localSQLiteException)
      {
          localSQLiteException.printStackTrace();
      }
    }
  }
  
  public static void InsertTaskStatusHistory()
  {
    int i = 0;
    for (;;)
    {
      int j = sInsertTaskStatusHistory.length;
      if (i >= j) {
        return;
      }
      try
      {
        SQLiteDatabase localSQLiteDatabase = db;
        String str = sInsertTaskStatusHistory[i];
          i += 1;
        localSQLiteDatabase.execSQL(str);

      }
      catch (SQLiteException localSQLiteException)
      {
          localSQLiteException.printStackTrace();
      }
    }
  }
  
  public static void InsertTaskViewers()
  {
    int i = 0;
    for (;;)
    {
      int j = sInsertTaskViewers.length;
      if (i >= j) {
        return;
      }
      try
      {
        SQLiteDatabase localSQLiteDatabase = db;
        String str = sInsertTaskViewers[i];
          i += 1;
        localSQLiteDatabase.execSQL(str);

      }
      catch (SQLiteException localSQLiteException)
      {
          localSQLiteException.printStackTrace();
      }
    }
  }
  
  public static void SelectIntoLog()
  {
    Cursor localCursor1 = db.rawQuery("SELECT Theme FROM TASK", null);
    localCursor1.moveToFirst();
    while (!localCursor1.isAfterLast())
    {
      String str1 = localCursor1.getString(0);
      Log.i("TASK  - Theme", str1);
      localCursor1.moveToNext();
    }
    Cursor localCursor2 = db.rawQuery("SELECT CreatedAt FROM TaskStatusHistory", null);
    localCursor2.moveToFirst();
    while (!localCursor2.isLast())
    {
      String str2 = localCursor2.getString(0);
      Log.i("TaskStatusHistory - CreatedAt", str2);
      localCursor2.moveToNext();
    }
    Cursor localCursor3 = db.rawQuery("SELECT PersonID FROM TaskViewers", null);
    localCursor3.moveToFirst();
    while (!localCursor3.isLast())
    {
      String str3 = localCursor3.getString(0);
      Log.i("TaskViewers - PersonID", str3);
      localCursor3.moveToNext();
    }
    Cursor localCursor4 = db.rawQuery("SELECT ClientUID FROM Client", null);
    while (localCursor4.moveToNext())
    {
      String str4 = localCursor4.getString(0);
      Log.i("Client - ClientUID", str4);
    }
    Cursor localCursor5 = db.rawQuery("SELECT ID FROM Person", null);
    localCursor5.moveToFirst();
    String str5 = localCursor5.getString(0);
    Log.i("Person - LastName", str5);
    localCursor5.moveToNext();
  }
  
  protected Void doInBackground(Object... paramVarArgs)
  {
    try
    {
//      SelectIntoLog();
//        InsertTask();
//        InsertPerson();
//        InsertClient();
//        InsertTaskViewers();
//        InsertTaskStatusHistory();
      return null;
    }
    catch (SQLiteException localSQLiteException)
    {
        localSQLiteException.printStackTrace();
    }
      return null;
  }
}



/* Location:           C:\Users\Павел\Documents\IdeaProjects\SpSystem\dex2jar-convert\dex2jar-convert\SpSystem.apk.dex2jar.jar

 * Qualified Name:     kernel.database.InsertTables

 * JD-Core Version:    0.7.0.1

 */