--  ************************************************
--  Rolling Back ChangeSet: db/changelog/db-changelog.xml::create-ix_pro_bre_id::DBA presents
DROP INDEX IX_PRO_BRE_ID ON dating.PROFILES;

DELETE FROM dating.DATABASECHANGELOG WHERE ID = 'create-ix_pro_bre_id' AND AUTHOR = 'DBA presents' AND FILENAME = 'db/changelog/db-changelog.xml';

--  Release Database Lock*********************
--  SQL to roll back currently unexecuted changes
--  *********************************************************************
--  Change Log: db/changelog/db.changelog-master.yaml
--  Ran at: 2/4/24, 8:06 PM
--  Against: root@192.168.65.1@jdbc:mysql://localhost:3306/dating
--  Liquibase version: 4.25.1
--  *********************************************************************

--  Lock Database
UPDATE dating.DATABASECHANGELOGLOCK SET `LOCKED` = 1, LOCKEDBY = 'Vasiliys-MacBook-Pro.local (fd8b:50b5:2094:3f97:458:d06f:6674:7d33%bridge100)', LOCKGRANTED = NOW() WHERE ID = 1 AND `LOCKED` = 0;

--  Rolling Back ChangeSet: db/changelog/db-with-sample-data.xml::insert-new-profiles::DBA presents
DELETE FROM dating.PROFILES;

DELETE FROM dating.DATABASECHANGELOG WHERE ID = 'insert-new-profiles' AND AUTHOR = 'DBA presents' AND FILENAME = 'db/changelog/db-with-sample-data.xml';

--  Rolling Back ChangeSet: db/changelog/db-changelog.xml::add-pro_gender-column::DBA presents
ALTER TABLE dating.PROFILES DROP COLUMN PRO_GENDER;

DELETE FROM dating.DATABASECHANGELOG WHERE ID = 'add-pro_gender-column' AND AUTHOR = 'DBA presents' AND FILENAME = 'db/changelog/db-changelog.xml';

--  Rolling Back ChangeSet: db/changelog/db-changelog.xml::create-fk_pro_bre_id::DBA presents
ALTER TABLE dating.PROFILES DROP FOREIGN KEY FK_PRO_BRE_ID;

DELETE FROM dating.DATABASECHANGELOG WHERE ID = 'create-fk_pro_bre_id' AND AUTHOR = 'DBA presents' AND FILENAME = 'db/changelog/db-changelog.xml';

--  Rolling Back ChangeSet: db/changelog/db-changelog.xml::create-ix_pro_bre_id::DBA presents
DROP INDEX IX_PRO_BRE_ID ON dating.PROFILES;

DELETE FROM dating.DATABASECHANGELOG WHERE ID = 'create-ix_pro_bre_id' AND AUTHOR = 'DBA presents' AND FILENAME = 'db/changelog/db-changelog.xml';

--  Release Database Lock
UPDATE dating.DATABASECHANGELOGLOCK SET `LOCKED` = 0, LOCKEDBY = NULL, LOCKGRANTED = NULL WHERE ID = 1;

