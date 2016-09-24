-- Generado por Oracle SQL Developer Data Modeler 4.1.3.901
--   en:        2016-09-24 11:38:11 COT
--   sitio:      Oracle Database 11g
--   tipo:      Oracle Database 11g




DROP TABLE touresbalon.ADDRESS CASCADE CONSTRAINTS ;

DROP TABLE touresbalon.CUSTOMER CASCADE CONSTRAINTS ;

DROP TABLE touresbalon.CUSTOMER_ADDRESS CASCADE CONSTRAINTS ;

DROP TABLE touresbalon.ITEMS CASCADE CONSTRAINTS ;

DROP TABLE touresbalon.ORDERS CASCADE CONSTRAINTS ;

CREATE TABLE touresbalon.ADDRESS
  (
    ADDRID       INTEGER NOT NULL ,
    STREET       VARCHAR2 (1000 CHAR) ,
    STATE        VARCHAR2 (1000 CHAR) ,
    ZIP          VARCHAR2 (10 CHAR) ,
    COUNTRY      VARCHAR2 (100 CHAR) ,
    ADDRESS_TYPE VARCHAR2 (10 CHAR) ,
    CITY         VARCHAR2 (40 CHAR)
  ) ;
ALTER TABLE touresbalon.ADDRESS ADD CONSTRAINT ADDRESS_PK PRIMARY KEY ( ADDRID ) ;


CREATE TABLE touresbalon.CUSTOMER
  (
    CUSTID           INTEGER NOT NULL ,
    FNAME            VARCHAR2 (40 CHAR) ,
    LNAME            VARCHAR2 (40 CHAR) ,
    PHONENUMBER      VARCHAR2 (40 CHAR) ,
    EMAIL            VARCHAR2 (40 CHAR) ,
    PASSWORD         VARCHAR2 (40 CHAR) ,
    CREDITCARDTYPE   VARCHAR2 (40 CHAR) ,
    CREDITCARDNUMBER VARCHAR2 (40 CHAR) ,
    STATUS           VARCHAR2 (10 CHAR)
  ) ;
ALTER TABLE touresbalon.CUSTOMER ADD CONSTRAINT CUSTOMER_PK PRIMARY KEY ( CUSTID ) ;


CREATE TABLE touresbalon.CUSTOMER_ADDRESS
  (
    CUSTID INTEGER NOT NULL ,
    ADDRID INTEGER NOT NULL
  ) ;


CREATE TABLE touresbalon.ITEMS
  (
    ITEMID      INTEGER NOT NULL ,
    PRODID      INTEGER ,
    PRODUCTNAME VARCHAR2 (100 CHAR) ,
    PARTNUM     VARCHAR2 (100 CHAR) ,
    PRICE       NUMBER (9,2) ,
    QUANTITY    INTEGER ,
    ORDID       INTEGER NOT NULL
  ) ;
ALTER TABLE touresbalon.ITEMS ADD CONSTRAINT ITEMS_PK PRIMARY KEY ( ITEMID ) ;


CREATE TABLE touresbalon.ORDERS
  (
    ORDID     INTEGER NOT NULL ,
    ORDERDATE DATE ,
    PRICE     NUMBER (9,2) ,
    STATUS    VARCHAR2 (10 CHAR) ,
    COMMENTS  VARCHAR2 (4000 CHAR) ,
    CUSTID    INTEGER NOT NULL
  ) ;
ALTER TABLE touresbalon.ORDERS ADD CONSTRAINT ORDERS_PK PRIMARY KEY ( ORDID ) ;


ALTER TABLE touresbalon.CUSTOMER_ADDRESS ADD CONSTRAINT CUST_ADDRESS_FK FOREIGN KEY ( ADDRID ) REFERENCES touresbalon.ADDRESS ( ADDRID ) ;

ALTER TABLE touresbalon.CUSTOMER_ADDRESS ADD CONSTRAINT CUS_ADD_CUSTOMER_FK FOREIGN KEY ( CUSTID ) REFERENCES touresbalon.CUSTOMER ( CUSTID ) ;

ALTER TABLE touresbalon.ITEMS ADD CONSTRAINT ITEMS_ORDERS_FK FOREIGN KEY ( ORDID ) REFERENCES touresbalon.ORDERS ( ORDID ) ;

ALTER TABLE touresbalon.ORDERS ADD CONSTRAINT ORDERS_CUSTOMER_FK FOREIGN KEY ( CUSTID ) REFERENCES touresbalon.CUSTOMER ( CUSTID ) ;

CREATE SEQUENCE touresbalon.SEC_ADDRESS_ID START WITH 1 NOCACHE ORDER ;

CREATE SEQUENCE touresbalon.SEC_CUSTOMER_ID START WITH 1 NOCACHE ORDER ;

CREATE SEQUENCE touresbalon.SEC_ITEM_ID START WITH 1 NOCACHE ORDER ;

CREATE SEQUENCE touresbalon.SEC_ORDEN_ID START WITH 1 NOCACHE ORDER ;


-- Informe de Resumen de Oracle SQL Developer Data Modeler: 
-- 
-- CREATE TABLE                             5
-- CREATE INDEX                             0
-- ALTER TABLE                              8
-- CREATE VIEW                              0
-- ALTER VIEW                               0
-- CREATE PACKAGE                           0
-- CREATE PACKAGE BODY                      0
-- CREATE PROCEDURE                         0
-- CREATE FUNCTION                          0
-- CREATE TRIGGER                           0
-- ALTER TRIGGER                            0
-- CREATE COLLECTION TYPE                   0
-- CREATE STRUCTURED TYPE                   0
-- CREATE STRUCTURED TYPE BODY              0
-- CREATE CLUSTER                           0
-- CREATE CONTEXT                           0
-- CREATE DATABASE                          0
-- CREATE DIMENSION                         0
-- CREATE DIRECTORY                         0
-- CREATE DISK GROUP                        0
-- CREATE ROLE                              0
-- CREATE ROLLBACK SEGMENT                  0
-- CREATE SEQUENCE                          4
-- CREATE MATERIALIZED VIEW                 0
-- CREATE SYNONYM                           0
-- CREATE TABLESPACE                        0
-- CREATE USER                              0
-- 
-- DROP TABLESPACE                          0
-- DROP DATABASE                            0
-- 
-- REDACTION POLICY                         0
-- 
-- ORDS DROP SCHEMA                         0
-- ORDS ENABLE SCHEMA                       0
-- ORDS ENABLE OBJECT                       0
-- 
-- ERRORS                                   0
-- WARNINGS                                 0
