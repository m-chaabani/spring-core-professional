DROP table FORMATEUR_TEST if exists;
DROP table FORMATION_TEST if exists;

CREATE table FORMATEUR_TEST ( ID BIGINT primary key, 
                              FIRST_NAME varchar(50),
                              LAST_NAME varchar(50),
                              CREATED_AT TIMESTAMP,
                              MODIFIED_AT TIMESTAMP,
                              VERSION INT);
                              
CREATE table FORMATION_TEST ( ID BIGINT primary key, 
                              ID_FORMATEUR BIGINT,
                              CODE varchar(50),
                              TITRE varchar(50),
                              DESCRIPTION varchar(200),
                              DUREE BIGINT,
                              PREREQUIS varchar(200),
                              CREATED_AT TIMESTAMP,
                              MODIFIED_AT TIMESTAMP,
                              VERSION INT);                          
                              
    

