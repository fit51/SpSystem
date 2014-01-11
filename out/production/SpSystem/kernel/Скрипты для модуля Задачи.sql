CREATE TABLE "t_Task" (
    ID                  INTEGER NOT NULL,
    "ServiceNo"         INTEGER,
    "ReporterClientNo"  INTEGER,
    "ReporterPersonNo"  INTEGER,
    "AssigneeClientNo"  INTEGER,
    "AssigneePersonNo"  INTEGER,
    "StatusNo"          INTEGER,
    "PriorityNo"        INTEGER,
    "ParentNo"          INTEGER,
    "Theme"             VARCHAR(255),
    "Name"              VARCHAR(255) NOT NULL,
    "Description"       VARCHAR(4096),
    "StartDate"         DATE,
    "EndDate"           DATE,
    "CreationTime"      DATE NOT NULL,
    "ModificationTime"  DATE NOT NULL,
    "OwnerNo"           INTEGER NOT NULL,
    "Duration"          NUMERIC(8,2),
    "ActualWork"        NUMERIC(8,2)
);
commit;


ALTER TABLE "t_Task" ADD CONSTRAINT PK_T_TASK PRIMARY KEY (ID);
commit;





CREATE TABLE "t_TaskStatusHistory" (
    ID           INTEGER NOT NULL,
    "CreatedAt"  TIMESTAMP NOT NULL,
    "CreatedBy"  INTEGER NOT NULL,
    "Note"       DOM_BLOB_TEXT /* DOM_BLOB_TEXT = BLOB SUB_TYPE 1 SEGMENT SIZE 100 */,
    "StatusNo"   INTEGER NOT NULL,
    "TaskNo"     INTEGER NOT NULL,
    "WorkTime"   DOM_TIMENULL /* DOM_TIMENULL = TIME */,
    "DocID"      DOM_IDNULL /* DOM_IDNULL = INTEGER */
);
commit;


ALTER TABLE "t_TaskStatusHistory" ADD CONSTRAINT PK_T_TASKSTATUSHISTORY PRIMARY KEY (ID);
commit;




CREATE TABLE "t_TaskViewers" (
    ID            DOM_ID /* DOM_ID = INTEGER DEFAULT 0 NOT NULL */,
    "TaskID"      DOM_ID /* DOM_ID = INTEGER DEFAULT 0 NOT NULL */,
    "PersonID"    DOM_ID /* DOM_ID = INTEGER DEFAULT 0 NOT NULL */,
    "isApprove"   DOM_BOOLFALSE /* DOM_BOOLFALSE = SMALLINT DEFAULT 0 NOT NULL CHECK (value in (0,1)) */,
    "isDirector"  DOM_BOOLFALSE /* DOM_BOOLFALSE = SMALLINT DEFAULT 0 NOT NULL CHECK (value in (0,1)) */
);
commit;



ALTER TABLE "t_TaskViewers" ADD CONSTRAINT "PK_t_TaskViewers" PRIMARY KEY (ID);
commit;




CREATE TABLE "l_Person" (
    ID                  DOM_ID NOT NULL /* DOM_ID = INTEGER DEFAULT 0 NOT NULL */,
    "LastName"          DOM_STR100 NOT NULL /* DOM_STR100 = VARCHAR(100) */,
    "FirstName"         DOM_STR100 DEFAULT '' /* DOM_STR100 = VARCHAR(100) */,
    "MiddleName"        DOM_STR100 DEFAULT '' /* DOM_STR100 = VARCHAR(100) */,
    "Birthday"          DOM_DATENULL /* DOM_DATENULL = DATE */,
    "IsPrivate"         DOM_BOOLFALSE NOT NULL /* DOM_BOOLFALSE = SMALLINT DEFAULT 0 NOT NULL CHECK (value in (0,1)) */,
    "Photo"             DOM_BLOB /* DOM_BLOB = BLOB SUB_TYPE 0 SEGMENT SIZE 100 */,
    "Comment"           DOM_TEXT /* DOM_TEXT = BLOB SUB_TYPE 1 SEGMENT SIZE 100 */,
    "UserName"          DOM_STR20 /* DOM_STR20 = VARCHAR(20) */,
    "BirthPlace"        DOM_STR255 /* DOM_STR255 = VARCHAR(255) */,
    "TabNumber"         VARCHAR(7),
    INN                 VARCHAR(12),
    "InsurenceNumber"   VARCHAR(14),
    "Alphabet"          VARCHAR(20),
    "GenderNo"          DOM_IDNULL /* DOM_IDNULL = INTEGER */,
    "MaritalStatusNo"   DOM_IDNULL /* DOM_IDNULL = INTEGER */,
    "Residance"         VARCHAR(100),
    "Index"             VARCHAR(7),
    "RegistrationDate"  DATE,
    "Functioning"       VARCHAR(50),
    "Citizenship"       VARCHAR(50),
    "FormTypeNo"        DOM_IDNULL /* DOM_IDNULL = INTEGER */,
    "FormTypeProfNo"    DOM_IDNULL /* DOM_IDNULL = INTEGER */,
    "DriverLicense"     VARCHAR(50),
    "BossNo"            DOM_IDNULL /* DOM_IDNULL = INTEGER */,
    "SecurityLevel"     DOM_INT0 /* DOM_INT0 = INTEGER DEFAULT 0 NOT NULL */,
    "ResPermAddr"       DOM_STR255 /* DOM_STR255 = VARCHAR(255) */,
    "RegistrAddr"       DOM_STR255 /* DOM_STR255 = VARCHAR(255) */,
    "ntID"              DOM_INTEGER /* DOM_INTEGER = INTEGER DEFAULT 0 */,
    "OwnerNo"           DOM_ID /* DOM_ID = INTEGER DEFAULT 0 NOT NULL */,
    "AgentType"         DOM_BOOLNULL /* DOM_BOOLNULL = INTEGER CHECK (value in (0, 1) or value is null) */,
    "Doc"               DOM_STR100 /* DOM_STR100 = VARCHAR(100) */,
    "Seria"             DOM_STR10 /* DOM_STR10 = VARCHAR(10) */,
    "No"                DOM_STR20 /* DOM_STR20 = VARCHAR(20) */,
    "DocDate"           DOM_DATENULL /* DOM_DATENULL = DATE */,
    "DocWho"            DOM_HINT /* DOM_HINT = VARCHAR(255) */,
    "Country"           DOM_SMALLINTNULL /* DOM_SMALLINTNULL = SMALLINT */,
    "DepartmentNo"      DOM_IDNULL /* DOM_IDNULL = INTEGER */
);
commit;

ALTER TABLE "l_Person" ADD CONSTRAINT "PK_l_Person" PRIMARY KEY (ID);
commit;



CREATE TABLE "l_Client" (
    ID                    INTEGER NOT NULL,
    "ClientUID"           VARCHAR(4) NOT NULL,
    "GroupNo"             INTEGER NOT NULL,
    "Alias"               VARCHAR(25) NOT NULL,
    "isReserved"          SMALLINT DEFAULT 0 NOT NULL,
    "isArdoClient"        SMALLINT DEFAULT 1 NOT NULL,
    "ClientPassword"      VARCHAR(50),
    "isMailEnabled"       SMALLINT DEFAULT 1 NOT NULL,
    "EMail"               VARCHAR(50),
    "PopServer"           VARCHAR(50),
    "SmtpServer"          VARCHAR(50),
    "EMailAccount"        VARCHAR(50),
    "EMailPassword"       VARCHAR(50),
    "Sender"              VARCHAR(50),
    "isStatement"         SMALLINT DEFAULT 1 NOT NULL,
    "Catalog"             VARCHAR(250),
    "isConfirm"           SMALLINT DEFAULT 1 NOT NULL,
    "Comment"             BLOB SUB_TYPE 1 SEGMENT SIZE 80,
    "MailBox"             INTEGER DEFAULT 0 NOT NULL,
    "OwnerID"             INTEGER DEFAULT 0 NOT NULL,
    "DepartmentID"        DOM_IDNULL /* DOM_IDNULL = INTEGER */,
    "ManagerID"           DOM_IDNULL /* DOM_IDNULL = INTEGER */,
    "CategoryNo"          INTEGER DEFAULT 0 NOT NULL,
    "ClientVersionID"     DOM_IDNULL /* DOM_IDNULL = INTEGER */,
    "HoldingID"           DOM_IDNULL /* DOM_IDNULL = INTEGER */,
    "CodeEXT"             DOM_STR20 /* DOM_STR20 = VARCHAR(20) */,
    "StatusID"            DOM_IDNULL DEFAULT 0 /* DOM_IDNULL = INTEGER */,
    "Active"              DOM_BOOLTRUE NOT NULL /* DOM_BOOLTRUE = SMALLINT DEFAULT 1 NOT NULL CHECK (value in (0,1)) */,
    "ProfileNo"           DOM_IDNULL /* DOM_IDNULL = INTEGER */,
    "ActivityTypeNo"      DOM_IDNULL /* DOM_IDNULL = INTEGER */,
    "OwnerNo"             DOM_ID /* DOM_ID = INTEGER DEFAULT 0 NOT NULL */,
    "ExtNo"               DOM_STR50 /* DOM_STR50 = VARCHAR(50) */,
    "BrokerNo"            DOM_IDNULL /* DOM_IDNULL = INTEGER */,
    "UCode"               DOM_CODE4 NOT NULL /* DOM_CODE4 = CHAR(4) DEFAULT '0000' NOT NULL */,
    "DateRegistered"      DOM_DATENULL /* DOM_DATENULL = DATE */,
    "ClientPassword2"     DOM_STR50 /* DOM_STR50 = VARCHAR(50) */,
    "WebPassword"         DOM_STR50 /* DOM_STR50 = VARCHAR(50) */,
    "WebCardPassword"     DOM_STR50 /* DOM_STR50 = VARCHAR(50) */,
    "WebDocNo"            INTEGER DEFAULT 1 NOT NULL,
    "WebEdit"             DOM_BOOLFALSE DEFAULT 0 /* DOM_BOOLFALSE = SMALLINT DEFAULT 0 NOT NULL CHECK (value in (0,1)) */,
    "isBudgetControl"     DOM_BOOLFALSE /* DOM_BOOLFALSE = SMALLINT DEFAULT 0 NOT NULL CHECK (value in (0,1)) */,
    "DateEnd"             DOM_DATENULL /* DOM_DATENULL = DATE */,
    "DateEndComment"      DOM_STR1000 /* DOM_STR1000 = VARCHAR(1000) */,
    "WebOldestOrderDate"  DOM_DATENULL /* DOM_DATENULL = DATE */
);


ALTER TABLE "l_Client" ADD CONSTRAINT PK_CLIENT PRIMARY KEY (ID);
commit;








INSERT INTO "t_Task" (ID, "ServiceNo", "ReporterClientNo", "ReporterPersonNo", "AssigneeClientNo", "AssigneePersonNo", "StatusNo", "PriorityNo", "ParentNo", "Theme", "Name", "Description", "StartDate", "EndDate", "CreationTime", "ModificationTime", "OwnerNo", "Duration", "ActualWork")
              VALUES (5591450, NULL, 0, NULL, NULL, 5590242, 1206, 1102, NULL, 'Обучение', 'Обучение работы с задачами, сообщениями и т.д.', NULL, NULL, NULL, '2013-09-23', '2013-09-23', 5590242, NULL, NULL);
INSERT INTO "t_Task" (ID, "ServiceNo", "ReporterClientNo", "ReporterPersonNo", "AssigneeClientNo", "AssigneePersonNo", "StatusNo", "PriorityNo", "ParentNo", "Theme", "Name", "Description", "StartDate", "EndDate", "CreationTime", "ModificationTime", "OwnerNo", "Duration", "ActualWork")
              VALUES (5591728, NULL, 0, NULL, NULL, 5590242, 1207, 1102, NULL, 'На осн. задачи № 5591450', '<?>', '', '2013-09-23', '2013-09-23', '2013-09-23', '2013-09-23', 5590242, NULL, NULL);
INSERT INTO "t_Task" (ID, "ServiceNo", "ReporterClientNo", "ReporterPersonNo", "AssigneeClientNo", "AssigneePersonNo", "StatusNo", "PriorityNo", "ParentNo", "Theme", "Name", "Description", "StartDate", "EndDate", "CreationTime", "ModificationTime", "OwnerNo", "Duration", "ActualWork")
              VALUES (5593144, NULL, 3147708, NULL, NULL, 5590242, 1203, 1102, NULL, 'Android', 'Разработать приложение на Android(скорее всего для планшета)', NULL, NULL, NULL, '2013-09-23', '2013-09-23', 5590242, NULL, NULL);
INSERT INTO "t_Task" (ID, "ServiceNo", "ReporterClientNo", "ReporterPersonNo", "AssigneeClientNo", "AssigneePersonNo", "StatusNo", "PriorityNo", "ParentNo", "Theme", "Name", "Description", "StartDate", "EndDate", "CreationTime", "ModificationTime", "OwnerNo", "Duration", "ActualWork")
              VALUES (5593252, NULL, 3147708, NULL, NULL, 5590242, 1202, 1102, NULL, 'Веб-конференция', 'Доработка open-source проекта веб-конференции', NULL, NULL, NULL, '2013-09-23', '2013-09-23', 5590242, NULL, NULL);
INSERT INTO "t_Task" (ID, "ServiceNo", "ReporterClientNo", "ReporterPersonNo", "AssigneeClientNo", "AssigneePersonNo", "StatusNo", "PriorityNo", "ParentNo", "Theme", "Name", "Description", "StartDate", "EndDate", "CreationTime", "ModificationTime", "OwnerNo", "Duration", "ActualWork")
              VALUES (5593323, NULL, 3147708, NULL, NULL, 5590242, 1206, 1102, NULL, 'На осн. задачи № 5593252', 'Ознакомиться с различными проектами', 'Рассмотреть  http://www.bigbluebutton.org/ и http://www.gvoconference.com/ru/features.php. . Установить их, разобраться в конфигурировании, собрать документацию, установить работоспособность.', '2013-09-23', '2013-09-23', '2013-09-23', '2013-09-23', 5590242, NULL, NULL);
INSERT INTO "t_Task" (ID, "ServiceNo", "ReporterClientNo", "ReporterPersonNo", "AssigneeClientNo", "AssigneePersonNo", "StatusNo", "PriorityNo", "ParentNo", "Theme", "Name", "Description", "StartDate", "EndDate", "CreationTime", "ModificationTime", "OwnerNo", "Duration", "ActualWork")
              VALUES (5615084, NULL, 3147708, NULL, NULL, 5590242, 1205, 1102, NULL, 'На осн. задачи № 5593252', 'Поставить BigBlueButton на реальную машину', 'Максимально настроить, посмотреть и проанализировать функционал на практике', '2013-09-25', '2013-09-25', '2013-09-25', '2013-09-25', 5590242, NULL, NULL);
INSERT INTO "t_Task" (ID, "ServiceNo", "ReporterClientNo", "ReporterPersonNo", "AssigneeClientNo", "AssigneePersonNo", "StatusNo", "PriorityNo", "ParentNo", "Theme", "Name", "Description", "StartDate", "EndDate", "CreationTime", "ModificationTime", "OwnerNo", "Duration", "ActualWork")
              VALUES (5615485, NULL, 3147708, NULL, NULL, 5590242, 1205, 1102, NULL, 'Приложения для конввертации img в PDF', 'Найти удобное приложения для конввертации img в PDF', NULL, NULL, NULL, '2013-09-25', '2013-09-25', 5590242, NULL, NULL);
INSERT INTO "t_Task" (ID, "ServiceNo", "ReporterClientNo", "ReporterPersonNo", "AssigneeClientNo", "AssigneePersonNo", "StatusNo", "PriorityNo", "ParentNo", "Theme", "Name", "Description", "StartDate", "EndDate", "CreationTime", "ModificationTime", "OwnerNo", "Duration", "ActualWork")
              VALUES (5652751, NULL, 3147708, NULL, NULL, 5590242, 1206, 1102, NULL, 'Обучение FastReport', 'Обучение FastReport', NULL, NULL, NULL, '2013-10-02', '2013-10-02', 5590242, NULL, NULL);

COMMIT WORK;



INSERT INTO "t_TaskStatusHistory" (ID, "CreatedAt", "CreatedBy", "Note", "StatusNo", "TaskNo", "WorkTime")
                           VALUES (5591498, '2013-09-23 11:10:34', 5590242, '', 1202, 5591450, NULL);
INSERT INTO "t_TaskStatusHistory" (ID, "CreatedAt", "CreatedBy", "Note", "StatusNo", "TaskNo", "WorkTime")
                           VALUES (5591518, '2013-09-23 11:11:42', 5590242, '', 1203, 5591450, NULL);
INSERT INTO "t_TaskStatusHistory" (ID, "CreatedAt", "CreatedBy", "Note", "StatusNo", "TaskNo", "WorkTime")
                           VALUES (5591594, '2013-09-23 11:18:57', 5590242, 'Тест', 1211, 5591450, '00:15:00');
INSERT INTO "t_TaskStatusHistory" (ID, "CreatedAt", "CreatedBy", "Note", "StatusNo", "TaskNo", "WorkTime")
                           VALUES (5591785, '2013-09-23 11:30:03', 5590242, '', 1207, 5591728, NULL);
INSERT INTO "t_TaskStatusHistory" (ID, "CreatedAt", "CreatedBy", "Note", "StatusNo", "TaskNo", "WorkTime")
                           VALUES (5592053, '2013-09-23 11:39:22', 5590242, '', 1205, 5591450, NULL);
INSERT INTO "t_TaskStatusHistory" (ID, "CreatedAt", "CreatedBy", "Note", "StatusNo", "TaskNo", "WorkTime")
                           VALUES (5592376, '2013-09-23 11:41:08', 5590242, '', 1206, 5591450, '00:30:00');
INSERT INTO "t_TaskStatusHistory" (ID, "CreatedAt", "CreatedBy", "Note", "StatusNo", "TaskNo", "WorkTime")
                           VALUES (5592412, '2013-09-23 11:42:36', 5590242, '', 1205, 5591450, NULL);
INSERT INTO "t_TaskStatusHistory" (ID, "CreatedAt", "CreatedBy", "Note", "StatusNo", "TaskNo", "WorkTime")
                           VALUES (5592749, '2013-09-23 11:52:16', 5590242, '', 1206, 5591450, NULL);
INSERT INTO "t_TaskStatusHistory" (ID, "CreatedAt", "CreatedBy", "Note", "StatusNo", "TaskNo", "WorkTime")
                           VALUES (5593291, '2013-09-23 12:05:19', 5590242, 'Ознакомление', 1202, 5593252, '00:10:00');
INSERT INTO "t_TaskStatusHistory" (ID, "CreatedAt", "CreatedBy", "Note", "StatusNo", "TaskNo", "WorkTime")
                           VALUES (5593510, '2013-09-23 12:16:15', 5590242, 'Ознакомление с задачей', 1202, 5593323, '00:10:00');
INSERT INTO "t_TaskStatusHistory" (ID, "CreatedAt", "CreatedBy", "Note", "StatusNo", "TaskNo", "WorkTime")
                           VALUES (5594013, '2013-09-23 12:52:30', 5590242, 'Скачивание VMPLAYER и bibluebutton-VM', 1210, 5593323, NULL);
INSERT INTO "t_TaskStatusHistory" (ID, "CreatedAt", "CreatedBy", "Note", "StatusNo", "TaskNo", "WorkTime")
                           VALUES (5594048, '2013-09-23 12:54:04', 5590242, 'Скачивание VMPLAYER и bibluebutton-VM и winrar', 1211, 5593323, '01:00:00');
INSERT INTO "t_TaskStatusHistory" (ID, "CreatedAt", "CreatedBy", "Note", "StatusNo", "TaskNo", "WorkTime")
                           VALUES (5595434, '2013-09-23 14:16:16', 5590242, 'Установка и конфигурирование bigbluebutton', 1211, 5593323, '02:00:00');
INSERT INTO "t_TaskStatusHistory" (ID, "CreatedAt", "CreatedBy", "Note", "StatusNo", "TaskNo", "WorkTime")
                           VALUES (5595822, '2013-09-23 14:54:39', 5590242, 'Тестирование BBB', 1210, 5593323, NULL);
INSERT INTO "t_TaskStatusHistory" (ID, "CreatedAt", "CreatedBy", "Note", "StatusNo", "TaskNo", "WorkTime")
                           VALUES (5602691, '2013-09-24 15:02:10', 5590242, 'Ознакомление с gvoconference', 1210, 5593323, NULL);
INSERT INTO "t_TaskStatusHistory" (ID, "CreatedAt", "CreatedBy", "Note", "StatusNo", "TaskNo", "WorkTime")
                           VALUES (5603311, '2013-09-24 16:02:27', 5590242, 'Тестирование openmeetings', 1211, 5593323, '01:00:00');
INSERT INTO "t_TaskStatusHistory" (ID, "CreatedAt", "CreatedBy", "Note", "StatusNo", "TaskNo", "WorkTime")
                           VALUES (5605749, '2013-09-24 18:09:08', 5590242, '3 системы веб-конференций готовыв к тестированию(установлены локально)', 1210, 5593323, NULL);
INSERT INTO "t_TaskStatusHistory" (ID, "CreatedAt", "CreatedBy", "Note", "StatusNo", "TaskNo", "WorkTime")
                           VALUES (5615000, '2013-09-25 17:40:57', 5590242, '', 1203, 5593323, NULL);
INSERT INTO "t_TaskStatusHistory" (ID, "CreatedAt", "CreatedBy", "Note", "StatusNo", "TaskNo", "WorkTime")
                           VALUES (5615025, '2013-09-25 17:41:13', 5590242, 'Для дальнейшего изучения и глубокого использования выбранно решение BigBlueButton!', 1205, 5593323, NULL);
INSERT INTO "t_TaskStatusHistory" (ID, "CreatedAt", "CreatedBy", "Note", "StatusNo", "TaskNo", "WorkTime")
                           VALUES (5615058, '2013-09-25 17:43:40', 5590242, '', 1206, 5593323, NULL);
INSERT INTO "t_TaskStatusHistory" (ID, "CreatedAt", "CreatedBy", "Note", "StatusNo", "TaskNo", "WorkTime")
                           VALUES (5615514, '2013-09-25 18:04:29', 5590242, '', 1202, 5615485, NULL);
INSERT INTO "t_TaskStatusHistory" (ID, "CreatedAt", "CreatedBy", "Note", "StatusNo", "TaskNo", "WorkTime")
                           VALUES (5616186, '2013-09-25 18:28:16', 5590242, 'www.convert-jpg-to-pdf.net
or
pdf виртуальный принтер', 1210, 5615485, NULL);
INSERT INTO "t_TaskStatusHistory" (ID, "CreatedAt", "CreatedBy", "Note", "StatusNo", "TaskNo", "WorkTime")
                           VALUES (5618239, '2013-09-26 11:49:36', 5590242, 'Формирование инструкции с 2-мя вариантами конвер', 1211, 5615485, '03:00:00');
INSERT INTO "t_TaskStatusHistory" (ID, "CreatedAt", "CreatedBy", "Note", "StatusNo", "TaskNo", "WorkTime")
                           VALUES (5618254, '2013-09-26 11:51:09', 5590242, '', 1203, 5615485, NULL);
INSERT INTO "t_TaskStatusHistory" (ID, "CreatedAt", "CreatedBy", "Note", "StatusNo", "TaskNo", "WorkTime")
                           VALUES (5618281, '2013-09-26 11:53:16', 5590242, '', 1205, 5615485, NULL);
INSERT INTO "t_TaskStatusHistory" (ID, "CreatedAt", "CreatedBy", "Note", "StatusNo", "TaskNo", "WorkTime")
                           VALUES (5618316, '2013-09-26 11:53:43', 5590242, '', 1202, 5615084, NULL);
INSERT INTO "t_TaskStatusHistory" (ID, "CreatedAt", "CreatedBy", "Note", "StatusNo", "TaskNo", "WorkTime")
                           VALUES (5618333, '2013-09-26 11:53:57', 5590242, '', 1203, 5615084, NULL);
INSERT INTO "t_TaskStatusHistory" (ID, "CreatedAt", "CreatedBy", "Note", "StatusNo", "TaskNo", "WorkTime")
                           VALUES (5628189, '2013-09-27 14:14:16', 5590242, 'Поставил uubntu10.04 + различные утилиты для работы BBB, поставил BBB, демки,  все запустил и проверил, начал разбираться в устройстве и настройке', 1211, 5615084, NULL);
INSERT INTO "t_TaskStatusHistory" (ID, "CreatedAt", "CreatedBy", "Note", "StatusNo", "TaskNo", "WorkTime")
                           VALUES (5631389, '2013-09-30 09:53:25', 5590242, 'Анализирование demo.jsp для интеграции bigbluebutton', 1210, 5615084, NULL);
INSERT INTO "t_TaskStatusHistory" (ID, "CreatedAt", "CreatedBy", "Note", "StatusNo", "TaskNo", "WorkTime")
                           VALUES (5631423, '2013-09-30 09:54:27', 5590242, 'Запуск openmeetings из исходников и нахождение swf файлов для клиента', 1210, 5593252, NULL);
INSERT INTO "t_TaskStatusHistory" (ID, "CreatedAt", "CreatedBy", "Note", "StatusNo", "TaskNo", "WorkTime")
                           VALUES (5652776, '2013-10-02 19:05:25', 5590242, 'Доделал отчет ControlGroupOborot', 1211, 5652751, '03:00:00');
INSERT INTO "t_TaskStatusHistory" (ID, "CreatedAt", "CreatedBy", "Note", "StatusNo", "TaskNo", "WorkTime")
                           VALUES (5652791, '2013-10-02 19:05:58', 5590242, '', 1206, 5652751, NULL);
INSERT INTO "t_TaskStatusHistory" (ID, "CreatedAt", "CreatedBy", "Note", "StatusNo", "TaskNo", "WorkTime")
                           VALUES (5652810, '2013-10-02 19:06:12', 5590242, '', 1202, 5593144, NULL);
INSERT INTO "t_TaskStatusHistory" (ID, "CreatedAt", "CreatedBy", "Note", "StatusNo", "TaskNo", "WorkTime")
                           VALUES (5652823, '2013-10-02 19:06:21', 5590242, 'Реализация http get запроса, для получения Json строки', 1211, 5593144, '02:00:00');
INSERT INTO "t_TaskStatusHistory" (ID, "CreatedAt", "CreatedBy", "Note", "StatusNo", "TaskNo", "WorkTime")
                           VALUES (5652841, '2013-10-02 19:07:08', 5590242, '', 1203, 5593144, NULL);
INSERT INTO "t_TaskStatusHistory" (ID, "CreatedAt", "CreatedBy", "Note", "StatusNo", "TaskNo", "WorkTime")
                           VALUES (5660541, '2013-10-03 14:06:58', 5590242, 'Реализовано! перпедача Json массива объектов(строка в таблице задач) и вывод на экран', 1211, 5593144, '03:00:00');
INSERT INTO "t_TaskStatusHistory" (ID, "CreatedAt", "CreatedBy", "Note", "StatusNo", "TaskNo", "WorkTime")
                           VALUES (5660569, '2013-10-03 14:08:47', 5590242, 'скрипты на сайте и сервере', 1211, 5615084, '02:00:00');
INSERT INTO "t_TaskStatusHistory" (ID, "CreatedAt", "CreatedBy", "Note", "StatusNo", "TaskNo", "WorkTime")
                           VALUES (5693676, '2013-10-09 18:48:05', 5590242, 'Реализация навигации приложения', 1211, 5593144, '09:00:00');
INSERT INTO "t_TaskStatusHistory" (ID, "CreatedAt", "CreatedBy", "Note", "StatusNo", "TaskNo", "WorkTime")
                           VALUES (5766345, '2013-10-18 12:31:24', 5590242, '', 1205, 5615084, '10:00:00');
INSERT INTO "t_TaskStatusHistory" (ID, "CreatedAt", "CreatedBy", "Note", "StatusNo", "TaskNo", "WorkTime")
                           VALUES (5766368, '2013-10-18 12:31:53', 5590242, 'Дизайн списка задач + база данных', 1211, 5593144, '15:00:00');
INSERT INTO "t_TaskStatusHistory" (ID, "CreatedAt", "CreatedBy", "Note", "StatusNo", "TaskNo", "WorkTime")
                           VALUES (5766585, '2013-10-18 12:50:28', 5590242, 'Установка на CentOS', 1211, 5615084, '04:00:00');

COMMIT WORK;






INSERT INTO "t_TaskViewers" (ID, "TaskID", "PersonID", "isApprove", "isDirector")
                     VALUES (5591452, 5591450, 2991174, 0, 0);
INSERT INTO "t_TaskViewers" (ID, "TaskID", "PersonID", "isApprove", "isDirector")
                     VALUES (5591775, 5591728, 2991174, 0, 0);
INSERT INTO "t_TaskViewers" (ID, "TaskID", "PersonID", "isApprove", "isDirector")
                     VALUES (5593146, 5593144, 2991174, 0, 0);
INSERT INTO "t_TaskViewers" (ID, "TaskID", "PersonID", "isApprove", "isDirector")
                     VALUES (5593254, 5593252, 2991174, 0, 0);
INSERT INTO "t_TaskViewers" (ID, "TaskID", "PersonID", "isApprove", "isDirector")
                     VALUES (5593490, 5593323, 2991174, 0, 0);
INSERT INTO "t_TaskViewers" (ID, "TaskID", "PersonID", "isApprove", "isDirector")
                     VALUES (5615487, 5615485, 2991174, 0, 0);
INSERT INTO "t_TaskViewers" (ID, "TaskID", "PersonID", "isApprove", "isDirector")
                     VALUES (5618303, 5615084, 2991174, 0, 0);
INSERT INTO "t_TaskViewers" (ID, "TaskID", "PersonID", "isApprove", "isDirector")
                     VALUES (5652753, 5652751, 2991174, 0, 0);

COMMIT WORK;


SET BLOBFILE 'D:\777.lob';

INSERT INTO "l_Client" (ID, "ClientUID", "GroupNo", "Alias", "isReserved", "isArdoClient", "ClientPassword", "isMailEnabled", "EMail", "PopServer", "SmtpServer", "EMailAccount", "EMailPassword", "Sender", "isStatement", "Catalog", "isConfirm", "Comment", "MailBox", "OwnerID", "DepartmentID", "ManagerID", "CategoryNo", "ClientVersionID", "HoldingID", "CodeEXT", "StatusID", "Active", "ProfileNo", "ActivityTypeNo", "OwnerNo", "ExtNo", "BrokerNo", "UCode", "DateRegistered", "ClientPassword2", "WebPassword", "WebCardPassword", "WebDocNo", "WebEdit", "isBudgetControl", "DateEnd", "DateEndComment", "WebOldestOrderDate")
                VALUES (0, '0000', 10001, 'SPTECH', 0, 0, '???', 0, NULL, NULL, NULL, NULL, NULL, NULL, 0, '-', 1, NULL, 0, 0, 2261243, NULL, 1014, NULL, NULL, NULL, 302, 1, NULL, NULL, 0, NULL, NULL, '0000', '2000-01-01', NULL, NULL, NULL, 1, 0, 1, NULL, NULL, NULL);
INSERT INTO "l_Client" (ID, "ClientUID", "GroupNo", "Alias", "isReserved", "isArdoClient", "ClientPassword", "isMailEnabled", "EMail", "PopServer", "SmtpServer", "EMailAccount", "EMailPassword", "Sender", "isStatement", "Catalog", "isConfirm", "Comment", "MailBox", "OwnerID", "DepartmentID", "ManagerID", "CategoryNo", "ClientVersionID", "HoldingID", "CodeEXT", "StatusID", "Active", "ProfileNo", "ActivityTypeNo", "OwnerNo", "ExtNo", "BrokerNo", "UCode", "DateRegistered", "ClientPassword2", "WebPassword", "WebCardPassword", "WebDocNo", "WebEdit", "isBudgetControl", "DateEnd", "DateEndComment", "WebOldestOrderDate")
                VALUES (3147708, '0049', 10003, 'КОНОВАЛОВ', 0, 0, '?', 0, NULL, NULL, NULL, NULL, NULL, NULL, 0, '$(APPDIR)\Outbox', 0, :h00000000_000001FE, 0, 0, 0, 0, 1014, NULL, NULL, NULL, 302, 1, NULL, NULL, 0, NULL, NULL, '0000', '2009-07-20', NULL, NULL, NULL, 1, 0, 0, NULL, NULL, NULL);

COMMIT WORK;


INSERT INTO "l_Person" (ID, "LastName", "FirstName", "MiddleName", "Birthday", "IsPrivate", "UserName", "BirthPlace", "TabNumber", INN, "InsurenceNumber", "Alphabet", "GenderNo", "MaritalStatusNo", "Residance", "Index", "RegistrationDate", "Functioning", "Citizenship", "FormTypeNo", "FormTypeProfNo", "DriverLicense", "BossNo", "SecurityLevel", "ResPermAddr", "RegistrAddr")
                VALUES (5590242, 'Кондратюк', 'Павел', 'Александрович', NULL, 1, 'TS_004', NULL, NULL, NULL, NULL, NULL, 303019, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 2991174, 0, NULL, NULL);

COMMIT WORK;

