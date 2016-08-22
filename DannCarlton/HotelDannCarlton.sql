-- Generado por Oracle SQL Developer Data Modeler 4.1.3.901
--   en:        2016-08-21 22:27:25 COT
--   sitio:      Oracle Database 11g
--   tipo:      Oracle Database 11g




CREATE
  TABLE touresbalon.HOTEL
  (
    HOTEL_ID         INTEGER NOT NULL ,
    NAME             VARCHAR2 (4000 CHAR) ,
    ADDRESS          VARCHAR2 (4000 CHAR) ,
    CITY             VARCHAR2 (4000 CHAR) ,
    COUNTRY          VARCHAR2 (4000 CHAR) ,
    ROOM_ROOM_NUMBER INTEGER NOT NULL
  ) ;
ALTER TABLE touresbalon.HOTEL ADD CONSTRAINT HOTEL_PK PRIMARY KEY ( HOTEL_ID )
;


CREATE
  TABLE touresbalon.PUBLIC_RESERVATIONS
  (
    ID_PUBLIC_RESERVATION INTEGER NOT NULL ,
    CHECK_IN_DATE         DATE ,
    CHECK_OUT_DATE        DATE ,
    ROOM_NUMBER           INTEGER NOT NULL
  ) ;
ALTER TABLE touresbalon.PUBLIC_RESERVATIONS ADD CONSTRAINT
PUBLIC_RESERVATIONS_PK PRIMARY KEY ( ID_PUBLIC_RESERVATION ) ;


CREATE
  TABLE touresbalon.ROOM
  (
    ROOM_NUMBER INTEGER NOT NULL ,
    TYPE        VARCHAR2 (4000 CHAR) ,
    PRICE       VARCHAR2 (4000 CHAR)
  ) ;
ALTER TABLE touresbalon.ROOM ADD CONSTRAINT ROOM_PK PRIMARY KEY ( ROOM_NUMBER )
;


CREATE
  TABLE touresbalon.TOURESBALON_RESERVATIONS
  (
    RESER_ID               INTEGER NOT NULL ,
    STATE                  INTEGER ,
    GUEST_NAME             VARCHAR2 (4000 CHAR) ,
    PUBLIC_RESERVATIONS_ID INTEGER NOT NULL
  ) ;
ALTER TABLE touresbalon.TOURESBALON_RESERVATIONS ADD CONSTRAINT
TOURESBALON_RESERVATIONS_PK PRIMARY KEY ( RESER_ID ) ;


ALTER TABLE touresbalon.HOTEL ADD CONSTRAINT HOTEL_ROOM_FK FOREIGN KEY (
ROOM_ROOM_NUMBER ) REFERENCES touresbalon.ROOM ( ROOM_NUMBER ) ;

ALTER TABLE touresbalon.TOURESBALON_RESERVATIONS ADD CONSTRAINT
PUBLIC_RESERVATIONS_FK FOREIGN KEY ( PUBLIC_RESERVATIONS_ID ) REFERENCES
touresbalon.PUBLIC_RESERVATIONS ( ID_PUBLIC_RESERVATION ) ;

ALTER TABLE touresbalon.PUBLIC_RESERVATIONS ADD CONSTRAINT
PUBLIC_RESERVATIONS_ROOM_FK FOREIGN KEY ( ROOM_NUMBER ) REFERENCES
touresbalon.ROOM ( ROOM_NUMBER ) ;

CREATE SEQUENCE touresbalon.HOTEL_ID_SEC START WITH 1 NOCACHE ORDER ;

CREATE SEQUENCE touresbalon.PUBLIC_RESERVATION_SEC START WITH 1 NOCACHE ORDER ;

CREATE SEQUENCE touresbalon.RES_TB_SEC START WITH 1 NOCACHE ORDER ;
CREATE OR REPLACE TRIGGER touresbalon.TB_RESERVATIONS_RESER_ID_TRG BEFORE
  INSERT
    ON touresbalon.TOURESBALON_RESERVATIONS FOR EACH ROW WHEN
    (
      NEW.RESER_ID IS NULL
    )
    BEGIN :NEW.RESER_ID := touresbalon.RES_TB_SEC.NEXTVAL;
END;
/


-- Informe de Resumen de Oracle SQL Developer Data Modeler: 
-- 
-- CREATE TABLE                             4
-- CREATE INDEX                             0
-- ALTER TABLE                              7
-- CREATE VIEW                              0
-- ALTER VIEW                               0
-- CREATE PACKAGE                           0
-- CREATE PACKAGE BODY                      0
-- CREATE PROCEDURE                         0
-- CREATE FUNCTION                          0
-- CREATE TRIGGER                           1
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
-- CREATE SEQUENCE                          3
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
