package kernel.database;

public class StringHolder
{
  private static String[] sInsertClient;
  private static String[] sInsertPerson;
  private static String[] sInsertTask;
  private static String[] sInsertTaskStatusHistory;
  private static String[] sInsertTaskViewers;
  
  static
  {
    String[] arrayOfString1 = new String[8];
    arrayOfString1[0] = "INSERT INTO Task ( ID,ServiceNo, ReporterClientNo, ReporterPersonNo, AssigneeClientNo, AssigneePersonNo, StatusNo, PriorityNo, ParentNo, Theme, Name, Description, StartDate, EndDate, CreationTime, ModificationTime, OwnerNo, Duration, ActualWork)               VALUES (5591450, NULL, 0, NULL, NULL, 5590242, 1206, 1102, NULL, 'Обучение', 'Обучение работы с задачами, сообщениями и т.д.', NULL, NULL, NULL, '2013-09-23', '2013-09-23', 5590242, NULL, NULL);";
    arrayOfString1[1] = "INSERT INTO Task ( ID,ServiceNo, ReporterClientNo, ReporterPersonNo, AssigneeClientNo, AssigneePersonNo, StatusNo, PriorityNo, ParentNo, Theme, Name, Description, StartDate, EndDate, CreationTime, ModificationTime, OwnerNo, Duration, ActualWork)               VALUES (5591728, NULL, 0, NULL, NULL, 5590242, 1207, 1102, NULL, 'На осн. задачи № 5591450', '<?>', '', '2013-09-23', '2013-09-23', '2013-09-23', '2013-09-23', 5590242, NULL, NULL);";
    arrayOfString1[2] = "INSERT INTO Task (ID, ServiceNo, ReporterClientNo, ReporterPersonNo, AssigneeClientNo, AssigneePersonNo, StatusNo, PriorityNo, ParentNo, Theme, Name, Description, StartDate, EndDate, CreationTime, ModificationTime, OwnerNo, Duration, ActualWork)               VALUES (5593144, NULL, 3147708, NULL, NULL, 5590242, 1203, 1102, NULL, 'Android', 'Разработать приложение на Android(скорее всего для планшета)', NULL, NULL, NULL, '2013-09-23', '2013-09-23', 5590242, NULL, NULL);";
    arrayOfString1[3] = "INSERT INTO Task (ID, ServiceNo, ReporterClientNo, ReporterPersonNo, AssigneeClientNo, AssigneePersonNo, StatusNo, PriorityNo, ParentNo, Theme, Name, Description, StartDate, EndDate, CreationTime, ModificationTime, OwnerNo, Duration, ActualWork)              VALUES (5593252, NULL, 3147708, NULL, NULL, 5590242, 1202, 1102, NULL, 'Веб-конференция', 'Доработка open-source проекта веб-конференции', NULL, NULL, NULL, '2013-09-23', '2013-09-23', 5590242, NULL, NULL);";
    arrayOfString1[4] = "INSERT INTO Task (ID, ServiceNo, ReporterClientNo, ReporterPersonNo, AssigneeClientNo, AssigneePersonNo, StatusNo, PriorityNo, ParentNo, Theme, Name, Description, StartDate, EndDate, CreationTime, ModificationTime, OwnerNo, Duration, ActualWork)              VALUES (5593323, NULL, 3147708, NULL, NULL, 5590242, 1206, 1102, NULL, 'На осн. задачи № 5593252', 'Ознакомиться с различными проектами', 'Рассмотреть  http://www.bigbluebutton.org/ и http://www.gvoconference.com/ru/features.php. . Установить их, разобраться в конфигурировании, собрать документацию, установить работоспособность.', '2013-09-23', '2013-09-23', '2013-09-23', '2013-09-23', 5590242, NULL, NULL);";
    arrayOfString1[5] = "INSERT INTO Task (ID, ServiceNo, ReporterClientNo, ReporterPersonNo, AssigneeClientNo, AssigneePersonNo, StatusNo, PriorityNo, ParentNo, Theme, Name, Description, StartDate, EndDate, CreationTime, ModificationTime, OwnerNo, Duration, ActualWork)              VALUES (5615084, NULL, 3147708, NULL, NULL, 5590242, 1205, 1102, NULL, 'На осн. задачи № 5593252', 'Поставить BigBlueButton на реальную машину', 'Максимально настроить, посмотреть и проанализировать функционал на практике', '2013-09-25', '2013-09-25', '2013-09-25', '2013-09-25', 5590242, NULL, NULL);";
    arrayOfString1[6] = "INSERT INTO Task (ID, ServiceNo, ReporterClientNo, ReporterPersonNo, AssigneeClientNo, AssigneePersonNo, StatusNo, PriorityNo, ParentNo, Theme, Name, Description, StartDate, EndDate, CreationTime, ModificationTime, OwnerNo, Duration, ActualWork)              VALUES (5615485, NULL, 3147708, NULL, NULL, 5590242, 1205, 1102, NULL, 'Приложения для конввертации img в PDF', 'Найти удобное приложения для конввертации img в PDF', NULL, NULL, NULL, '2013-09-25', '2013-09-25', 5590242, NULL, NULL);";
    arrayOfString1[7] = "INSERT INTO Task (ID, ServiceNo, ReporterClientNo, ReporterPersonNo, AssigneeClientNo, AssigneePersonNo, StatusNo, PriorityNo, ParentNo, Theme, Name, Description, StartDate, EndDate, CreationTime, ModificationTime, OwnerNo, Duration, ActualWork)              VALUES (5652751, NULL, 3147708, NULL, NULL, 5590242, 1206, 1102, NULL, 'Обучение FastReport', 'Обучение FastReport', NULL, NULL, NULL, '2013-10-02', '2013-10-02', 5590242, NULL, NULL);";
    sInsertTask = arrayOfString1;
    String[] arrayOfString2 = new String[41];
    arrayOfString2[0] = "INSERT INTO TaskStatusHistory (ID, CreatedAt, CreatedBy, Note, StatusNo, TaskNo, WorkTime)                           VALUES (5591498, '2013-09-23 11:10:34', 5590242, '', 1202, 5591450, NULL);";
    arrayOfString2[1] = "INSERT INTO TaskStatusHistory (ID, CreatedAt, CreatedBy, Note, StatusNo, TaskNo, WorkTime)                           VALUES (5591518, '2013-09-23 11:11:42', 5590242, '', 1203, 5591450, NULL);";
    arrayOfString2[2] = "INSERT INTO TaskStatusHistory (ID, CreatedAt, CreatedBy, Note, StatusNo, TaskNo, WorkTime)                           VALUES (5591594, '2013-09-23 11:18:57', 5590242, 'Тест', 1211, 5591450, '00:15:00');";
    arrayOfString2[3] = "INSERT INTO TaskStatusHistory (ID, CreatedAt, CreatedBy, Note, StatusNo, TaskNo, WorkTime)                           VALUES (5591785, '2013-09-23 11:30:03', 5590242, '', 1207, 5591728, NULL);";
    arrayOfString2[4] = "INSERT INTO TaskStatusHistory (ID, CreatedAt, CreatedBy, Note, StatusNo, TaskNo, WorkTime)                           VALUES (5592053, '2013-09-23 11:39:22', 5590242, '', 1205, 5591450, NULL);";
    arrayOfString2[5] = "INSERT INTO TaskStatusHistory (ID, CreatedAt, CreatedBy, Note, StatusNo, TaskNo, WorkTime)                           VALUES (5592376, '2013-09-23 11:41:08', 5590242, '', 1206, 5591450, '00:30:00');";
    arrayOfString2[6] = "INSERT INTO TaskStatusHistory (ID, CreatedAt, CreatedBy, Note, StatusNo, TaskNo, WorkTime)                           VALUES (5592412, '2013-09-23 11:42:36', 5590242, '', 1205, 5591450, NULL);";
    arrayOfString2[7] = "INSERT INTO TaskStatusHistory (ID, CreatedAt, CreatedBy, Note, StatusNo, TaskNo, WorkTime)                           VALUES (5592749, '2013-09-23 11:52:16', 5590242, '', 1206, 5591450, NULL);";
    arrayOfString2[8] = "INSERT INTO TaskStatusHistory (ID, CreatedAt, CreatedBy, Note, StatusNo, TaskNo, WorkTime)                           VALUES (5593291, '2013-09-23 12:05:19', 5590242, 'Ознакомление', 1202, 5593252, '00:10:00');";
    arrayOfString2[9] = "INSERT INTO TaskStatusHistory (ID, CreatedAt, CreatedBy, Note, StatusNo, TaskNo, WorkTime)                           VALUES (5593510, '2013-09-23 12:16:15', 5590242, 'Ознакомление с задачей', 1202, 5593323, '00:10:00');";
    arrayOfString2[10] = "INSERT INTO TaskStatusHistory (ID, CreatedAt, CreatedBy, Note, StatusNo, TaskNo, WorkTime)                           VALUES (5594013, '2013-09-23 12:52:30', 5590242, 'Скачивание VMPLAYER и bibluebutton-VM', 1210, 5593323, NULL);";
    arrayOfString2[11] = "INSERT INTO TaskStatusHistory (ID, CreatedAt, CreatedBy, Note, StatusNo, TaskNo, WorkTime)                           VALUES (5594048, '2013-09-23 12:54:04', 5590242, 'Скачивание VMPLAYER и bibluebutton-VM и winrar', 1211, 5593323, '01:00:00');";
    arrayOfString2[12] = "INSERT INTO TaskStatusHistory (ID, CreatedAt, CreatedBy, Note, StatusNo, TaskNo, WorkTime)                           VALUES (5595434, '2013-09-23 14:16:16', 5590242, 'Установка и конфигурирование bigbluebutton', 1211, 5593323, '02:00:00');";
    arrayOfString2[13] = "INSERT INTO TaskStatusHistory (ID, CreatedAt, CreatedBy, Note, StatusNo, TaskNo, WorkTime)                           VALUES (5595822, '2013-09-23 14:54:39', 5590242, 'Тестирование BBB', 1210, 5593323, NULL);";
    arrayOfString2[14] = "INSERT INTO TaskStatusHistory (ID, CreatedAt, CreatedBy, Note, StatusNo, TaskNo, WorkTime)                           VALUES (5602691, '2013-09-24 15:02:10', 5590242, 'Ознакомление с gvoconference', 1210, 5593323, NULL);";
    arrayOfString2[15] = "INSERT INTO TaskStatusHistory (ID, CreatedAt, CreatedBy, Note, StatusNo, TaskNo, WorkTime)                           VALUES (5603311, '2013-09-24 16:02:27', 5590242, 'Тестирование openmeetings', 1211, 5593323, '01:00:00');";
    arrayOfString2[16] = "INSERT INTO TaskStatusHistory (ID, CreatedAt, CreatedBy, Note, StatusNo, TaskNo, WorkTime)                           VALUES (5605749, '2013-09-24 18:09:08', 5590242, '3 системы веб-конференций готовыв к тестированию(установлены локально)', 1210, 5593323, NULL);";
    arrayOfString2[17] = "INSERT INTO TaskStatusHistory (ID, CreatedAt, CreatedBy, Note, StatusNo, TaskNo, WorkTime)                           VALUES (5615000, '2013-09-25 17:40:57', 5590242, '', 1203, 5593323, NULL);";
    arrayOfString2[18] = "INSERT INTO TaskStatusHistory (ID, CreatedAt, CreatedBy, Note, StatusNo, TaskNo, WorkTime)                           VALUES (5615025, '2013-09-25 17:41:13', 5590242, 'Для дальнейшего изучения и глубокого использования выбранно решение BigBlueButton!', 1205, 5593323, NULL);";
    arrayOfString2[19] = "INSERT INTO TaskStatusHistory (ID, CreatedAt, CreatedBy, Note, StatusNo, TaskNo, WorkTime)                           VALUES (5615058, '2013-09-25 17:43:40', 5590242, '', 1206, 5593323, NULL);";
    arrayOfString2[20] = "INSERT INTO TaskStatusHistory (ID, CreatedAt, CreatedBy, Note, StatusNo, TaskNo, WorkTime)                           VALUES (5615514, '2013-09-25 18:04:29', 5590242, '', 1202, 5615485, NULL);";
    arrayOfString2[21] = "INSERT INTO TaskStatusHistory (ID, CreatedAt, CreatedBy, Note, StatusNo, TaskNo, WorkTime)                           VALUES (5616186, '2013-09-25 18:28:16', 5590242, 'www.convert-jpg-to-pdf.netorpdf виртуальный принтер', 1210, 5615485, NULL);";
    arrayOfString2[22] = "INSERT INTO TaskStatusHistory (ID, CreatedAt, CreatedBy, Note, StatusNo, TaskNo, WorkTime)                           VALUES (5618239, '2013-09-26 11:49:36', 5590242, 'Формирование инструкции с 2-мя вариантами конвер', 1211, 5615485, '03:00:00');";
    arrayOfString2[23] = "INSERT INTO TaskStatusHistory (ID, CreatedAt, CreatedBy, Note, StatusNo, TaskNo, WorkTime)                           VALUES (5618254, '2013-09-26 11:51:09', 5590242, '', 1203, 5615485, NULL);";
    arrayOfString2[24] = "INSERT INTO TaskStatusHistory (ID, CreatedAt, CreatedBy, Note, StatusNo, TaskNo, WorkTime)                           VALUES (5618281, '2013-09-26 11:53:16', 5590242, '', 1205, 5615485, NULL);";
    arrayOfString2[25] = "INSERT INTO TaskStatusHistory (ID, CreatedAt, CreatedBy, Note, StatusNo, TaskNo, WorkTime)                           VALUES (5618316, '2013-09-26 11:53:43', 5590242, '', 1202, 5615084, NULL);";
    arrayOfString2[26] = "INSERT INTO TaskStatusHistory (ID, CreatedAt, CreatedBy, Note, StatusNo, TaskNo, WorkTime)                           VALUES (5618333, '2013-09-26 11:53:57', 5590242, '', 1203, 5615084, NULL);";
    arrayOfString2[27] = "INSERT INTO TaskStatusHistory (ID, CreatedAt, CreatedBy, Note, StatusNo, TaskNo, WorkTime)                           VALUES (5628189, '2013-09-27 14:14:16', 5590242, 'Поставил uubntu10.04 , различные утилиты для работы BBB, поставил BBB, демки,  все запустил и проверил, начал разбираться в устройстве и настройке', 1211, 5615084, NULL);";
    arrayOfString2[28] = "INSERT INTO TaskStatusHistory (ID, CreatedAt, CreatedBy, Note, StatusNo, TaskNo, WorkTime)                           VALUES (5631389, '2013-09-30 09:53:25', 5590242, 'Анализирование demo.jsp для интеграции bigbluebutton', 1210, 5615084, NULL);";
    arrayOfString2[29] = "INSERT INTO TaskStatusHistory (ID, CreatedAt, CreatedBy, Note, StatusNo, TaskNo, WorkTime)                           VALUES (5631423, '2013-09-30 09:54:27', 5590242, 'Запуск openmeetings из исходников и нахождение swf файлов для клиента', 1210, 5593252, NULL);";
    arrayOfString2[30] = "INSERT INTO TaskStatusHistory (ID, CreatedAt, CreatedBy, Note, StatusNo, TaskNo, WorkTime)                           VALUES (5652776, '2013-10-02 19:05:25', 5590242, 'Доделал отчет ControlGroupOborot', 1211, 5652751, '03:00:00');";
    arrayOfString2[31] = "INSERT INTO TaskStatusHistory (ID, CreatedAt, CreatedBy, Note, StatusNo, TaskNo, WorkTime)                           VALUES (5652791, '2013-10-02 19:05:58', 5590242, '', 1206, 5652751, NULL);";
    arrayOfString2[32] = "INSERT INTO TaskStatusHistory (ID, CreatedAt, CreatedBy, Note, StatusNo, TaskNo, WorkTime)                           VALUES (5652810, '2013-10-02 19:06:12', 5590242, '', 1202, 5593144, NULL);";
    arrayOfString2[33] = "INSERT INTO TaskStatusHistory (ID, CreatedAt, CreatedBy, Note, StatusNo, TaskNo, WorkTime)                           VALUES (5652823, '2013-10-02 19:06:21', 5590242, 'Реализация http get запроса, для получения Json строки', 1211, 5593144, '02:00:00');";
    arrayOfString2[34] = "INSERT INTO TaskStatusHistory (ID, CreatedAt, CreatedBy, Note, StatusNo, TaskNo, WorkTime)                           VALUES (5652841, '2013-10-02 19:07:08', 5590242, '', 1203, 5593144, NULL);";
    arrayOfString2[35] = "INSERT INTO TaskStatusHistory (ID, CreatedAt, CreatedBy, Note, StatusNo, TaskNo, WorkTime)                           VALUES (5660541, '2013-10-03 14:06:58', 5590242, 'Реализовано! перпедача Json массива объектов(строка в таблице задач) и вывод на экран', 1211, 5593144, '03:00:00');";
    arrayOfString2[36] = "INSERT INTO TaskStatusHistory (ID, CreatedAt, CreatedBy, Note, StatusNo, TaskNo, WorkTime)                           VALUES (5660569, '2013-10-03 14:08:47', 5590242, 'скрипты на сайте и сервере', 1211, 5615084, '02:00:00');";
    arrayOfString2[37] = "INSERT INTO TaskStatusHistory (ID, CreatedAt, CreatedBy, Note, StatusNo, TaskNo, WorkTime)                           VALUES (5693676, '2013-10-09 18:48:05', 5590242, 'Реализация навигации приложения', 1211, 5593144, '09:00:00');";
    arrayOfString2[38] = "INSERT INTO TaskStatusHistory (ID, CreatedAt, CreatedBy, Note, StatusNo, TaskNo, WorkTime)                           VALUES (5766345, '2013-10-18 12:31:24', 5590242, '', 1205, 5615084, '10:00:00');";
    arrayOfString2[39] = "INSERT INTO TaskStatusHistory (ID, CreatedAt, CreatedBy, Note, StatusNo, TaskNo, WorkTime)                           VALUES (5766368, '2013-10-18 12:31:53', 5590242, 'Дизайн списка задач , база данных', 1211, 5593144, '15:00:00');";
    arrayOfString2[40] = "INSERT INTO TaskStatusHistory (ID, CreatedAt, CreatedBy, Note, StatusNo, TaskNo, WorkTime)                           VALUES (5766585, '2013-10-18 12:50:28', 5590242, 'Установка на CentOS', 1211, 5615084, '04:00:00');";
    sInsertTaskStatusHistory = arrayOfString2;
    String[] arrayOfString3 = new String[8];
    arrayOfString3[0] = "INSERT INTO TaskViewers (ID, TaskID, PersonID, isApprove, isDirector)                     VALUES (5591452, 5591450, 2991174, 0, 0);";
    arrayOfString3[1] = "INSERT INTO TaskViewers (ID, TaskID, PersonID, isApprove, isDirector)                     VALUES (5591775, 5591728, 2991174, 0, 0);";
    arrayOfString3[2] = "INSERT INTO TaskViewers (ID, TaskID, PersonID, isApprove, isDirector)                     VALUES (5593146, 5593144, 2991174, 0, 0);";
    arrayOfString3[3] = "INSERT INTO TaskViewers (ID, TaskID, PersonID, isApprove, isDirector)                     VALUES (5593254, 5593252, 2991174, 0, 0);";
    arrayOfString3[4] = "INSERT INTO TaskViewers (ID, TaskID, PersonID, isApprove, isDirector)                     VALUES (5593490, 5593323, 2991174, 0, 0);";
    arrayOfString3[5] = "INSERT INTO TaskViewers (ID, TaskID, PersonID, isApprove, isDirector)                     VALUES (5615487, 5615485, 2991174, 0, 0);";
    arrayOfString3[6] = "INSERT INTO TaskViewers (ID, TaskID, PersonID, isApprove, isDirector)                     VALUES (5618303, 5615084, 2991174, 0, 0);";
    arrayOfString3[7] = "INSERT INTO TaskViewers (ID, TaskID, PersonID, isApprove, isDirector)                     VALUES (5652753, 5652751, 2991174, 0, 0);";
    sInsertTaskViewers = arrayOfString3;
    String[] arrayOfString4 = new String[2];
    arrayOfString4[0] = "INSERT INTO Client (ID, ClientUID, GroupNo, Alias, isReserved, isArdoClient, ClientPassword, isMailEnabled, EMail, PopServer, SmtpServer, EMailAccount, EMailPassword, Sender, isStatement, Catalog, isConfirm, Comment, MailBox, OwnerID, DepartmentID, ManagerID, CategoryNo, ClientVersionID, HoldingID, CodeEXT, StatusID, Active, ProfileNo, ActivityTypeNo, OwnerNo, ExtNo, BrokerNo, UCode, DateRegistered, ClientPassword2, WebPassword, WebCardPassword, WebDocNo, WebEdit, isBudgetControl, DateEnd, DateEndComment, WebOldestOrderDate)                VALUES (0, '0000', 10001, 'SPTECH', 0, 0, '???', 0, NULL, NULL, NULL, NULL, NULL, NULL, 0, '-', 1, NULL, 0, 0, 2261243, NULL, 1014, NULL, NULL, NULL, 302, 1, NULL, NULL, 0, NULL, NULL, '0000', '2000-01-01', NULL, NULL, NULL, 1, 0, 1, NULL, NULL, NULL);";
    arrayOfString4[1] = "INSERT INTO Client (ID, ClientUID, GroupNo, Alias, isReserved, isArdoClient, ClientPassword, isMailEnabled, EMail, PopServer, SmtpServer, EMailAccount, EMailPassword, Sender, isStatement, Catalog, isConfirm, Comment, MailBox, OwnerID, DepartmentID, ManagerID, CategoryNo, ClientVersionID, HoldingID, CodeEXT, StatusID, Active, ProfileNo, ActivityTypeNo, OwnerNo, ExtNo, BrokerNo, UCode, DateRegistered, ClientPassword2, WebPassword, WebCardPassword, WebDocNo, WebEdit, isBudgetControl, DateEnd, DateEndComment, WebOldestOrderDate)                VALUES (3147708, '0049', 10003, 'КОНОВАЛОВ', 0, 0, '?', 0, NULL, NULL, NULL, NULL, NULL, NULL, 0, '$(APPDIR)\\Outbox', 0, :h00000000_000001FE, 0, 0, 0, 0, 1014, NULL, NULL, NULL, 302, 1, NULL, NULL, 0, NULL, NULL, '0000', '2009-07-20', NULL, NULL, NULL, 1, 0, 0, NULL, NULL, NULL);";
    sInsertClient = arrayOfString4;
    String[] arrayOfString5 = new String[1];
    arrayOfString5[0] = "INSERT INTO Person (ID, LastName, FirstName, MiddleName, Birthday, IsPrivate, UserName, BirthPlace, TabNumber, INN, InsurenceNumber, Alphabet, GenderNo, MaritalStatusNo, Residance, Index1, RegistrationDate, Functioning, Citizenship, FormTypeNo, FormTypeProfNo, DriverLicense, BossNo, SecurityLevel, ResPermAddr, RegistrAddr)                VALUES (5590242, 'Кондратюк', 'Павел', 'Александрович', NULL, 1, 'TS_004', NULL, NULL, NULL, NULL, NULL, 303019, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 2991174, 0, NULL, NULL);";
    sInsertPerson = arrayOfString5;
  }
}


/* Location:           C:\Users\Павел\Documents\IdeaProjects\SpSystem\dex2jar-convert\dex2jar-convert\SpSystem.apk.dex2jar.jar
 * Qualified Name:     kernel.database.StringHolder
 * JD-Core Version:    0.7.0.1
 */