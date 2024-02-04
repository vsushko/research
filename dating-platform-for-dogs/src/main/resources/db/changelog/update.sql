--  Lock Database
UPDATE dating.DATABASECHANGELOGLOCK SET `LOCKED` = 1, LOCKEDBY = 'Vasiliys-MacBook-Pro.local (fd8b:50b5:2094:3f97:458:d06f:6674:7d33%bridge100)', LOCKGRANTED = NOW() WHERE ID = 1 AND `LOCKED` = 0;

--  *********************************************************************
--  Update Database Script
--  *********************************************************************
--  Change Log: db/changelog/db.changelog-master.yaml
--  Ran at: 2/4/24, 8:06 PM
--  Against: root@192.168.65.1@jdbc:mysql://localhost:3306/dating
--  Liquibase version: 4.25.1
--  *********************************************************************

UPDATE dating.DATABASECHANGELOG SET MD5SUM = '9:25cd2ea626d17bbb7d16a45995cb7306' WHERE ID = 'create-breeds-table' AND AUTHOR = 'vsushko' AND FILENAME = 'db/changelog/db-changelog.xml';

UPDATE dating.DATABASECHANGELOG SET MD5SUM = '9:7643ee1fce3edc5a5e8cfb1e31e1485a' WHERE ID = 'insert-breeds' AND AUTHOR = 'vsushko' AND FILENAME = 'db/changelog/db-changelog.xml';

UPDATE dating.DATABASECHANGELOG SET MD5SUM = '9:275b2d45572aefe0bc3df47d34a222ed' WHERE ID = 'create-profiles-table' AND AUTHOR = 'vsushko' AND FILENAME = 'db/changelog/db-changelog.xml';

--  Changeset db/changelog/db-changelog.xml::create-ix_pro_bre_id::DBA presents
CREATE INDEX IX_PRO_BRE_ID ON dating.PROFILES(PRO_BRE_ID);

INSERT INTO dating.DATABASECHANGELOG (ID, AUTHOR, FILENAME, DATEEXECUTED, ORDEREXECUTED, MD5SUM, `DESCRIPTION`, COMMENTS, EXECTYPE, CONTEXTS, LABELS, LIQUIBASE, DEPLOYMENT_ID) VALUES ('create-ix_pro_bre_id', 'DBA presents', 'db/changelog/db-changelog.xml', NOW(), 4, '9:58cdb0b25791d46fd9cda5246e064ba0', 'createIndex indexName=IX_PRO_BRE_ID, tableName=PROFILES', '', 'EXECUTED', NULL, NULL, '4.25.1', '7062768598');

--  Changeset db/changelog/db-changelog.xml::create-fk_pro_bre_id::DBA presents
ALTER TABLE dating.PROFILES ADD CONSTRAINT FK_PRO_BRE_ID FOREIGN KEY (PRO_BRE_ID) REFERENCES dating.BREEDS (BRE_ID);

INSERT INTO dating.DATABASECHANGELOG (ID, AUTHOR, FILENAME, DATEEXECUTED, ORDEREXECUTED, MD5SUM, `DESCRIPTION`, COMMENTS, EXECTYPE, CONTEXTS, LABELS, LIQUIBASE, DEPLOYMENT_ID) VALUES ('create-fk_pro_bre_id', 'DBA presents', 'db/changelog/db-changelog.xml', NOW(), 5, '9:d5a014e54263a1a0541c3d63cf6798ba', 'addForeignKeyConstraint baseTableName=PROFILES, constraintName=FK_PRO_BRE_ID, referencedTableName=BREEDS', '', 'EXECUTED', NULL, NULL, '4.25.1', '7062768598');

--  Changeset db/changelog/db-changelog.xml::add-pro_gender-column::DBA presents
ALTER TABLE dating.PROFILES ADD PRO_GENDER CHAR(1) NULL;

INSERT INTO dating.DATABASECHANGELOG (ID, AUTHOR, FILENAME, DATEEXECUTED, ORDEREXECUTED, MD5SUM, `DESCRIPTION`, COMMENTS, EXECTYPE, CONTEXTS, LABELS, LIQUIBASE, DEPLOYMENT_ID) VALUES ('add-pro_gender-column', 'DBA presents', 'db/changelog/db-changelog.xml', NOW(), 6, '9:531a7c7cf534a1bbb245d2ad63d0b5d4', 'addColumn tableName=PROFILES', '', 'EXECUTED', NULL, NULL, '4.25.1', '7062768598');

--  Changeset db/changelog/db-with-sample-data.xml::insert-new-profiles::DBA presents
INSERT INTO dating.PROFILES (PRO_NAME, PRO_BRE_ID, PRO_HEIGHT, PRO_WEIGHT, PRO_DESCRIPTION, PRO_IMAGE_URL) VALUES ('Romantic Soul', (select BRE_ID from BREEDS where BRE_NAME = 'American Staffordshire Terrier'), 40, 30, 'I believe that chasing cats brings dogs together.', '/img/RomanticSoul.jpg');

INSERT INTO dating.PROFILES (PRO_NAME, PRO_HEIGHT, PRO_WEIGHT, PRO_DESCRIPTION, PRO_IMAGE_URL) VALUES ('Caesar', 50, 20, 'Happiness is my way of living. Will you be happy with me?', '/img/Caesar.jpg');

INSERT INTO dating.PROFILES (PRO_NAME, PRO_BRE_ID, PRO_HEIGHT, PRO_WEIGHT, PRO_DESCRIPTION, PRO_IMAGE_URL) VALUES ('Prince Charming', (select BRE_ID from BREEDS where BRE_NAME = 'Golden Retriever'), 80, 40, 'I am a mature dog that is looking for calm and stability.', '/img/PrinceCharming.jpg');

INSERT INTO dating.PROFILES (PRO_NAME, PRO_BRE_ID, PRO_HEIGHT, PRO_WEIGHT, PRO_DESCRIPTION, PRO_IMAGE_URL) VALUES ('Cutie Pie', (select BRE_ID from BREEDS where BRE_NAME = 'Golden Retriever'), 60, 30, 'I have my issues but I am looking for a dog who will love me after all.', '/img/CutiePie.jpg');

INSERT INTO dating.DATABASECHANGELOG (ID, AUTHOR, FILENAME, DATEEXECUTED, ORDEREXECUTED, MD5SUM, `DESCRIPTION`, COMMENTS, EXECTYPE, CONTEXTS, LABELS, LIQUIBASE, DEPLOYMENT_ID) VALUES ('insert-new-profiles', 'DBA presents', 'db/changelog/db-with-sample-data.xml', NOW(), 7, '9:06902efff915e375bb72b59a94c99e93', 'insert tableName=PROFILES; insert tableName=PROFILES; insert tableName=PROFILES; insert tableName=PROFILES', '', 'EXECUTED', NULL, NULL, '4.25.1', '7062768598');

--  Release Database Lock
UPDATE dating.DATABASECHANGELOGLOCK SET `LOCKED` = 0, LOCKEDBY = NULL, LOCKGRANTED = NULL WHERE ID = 1;

