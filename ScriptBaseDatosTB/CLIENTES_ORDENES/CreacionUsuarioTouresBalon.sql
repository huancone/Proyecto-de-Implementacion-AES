create user touresbalon identified by touresbalon;

GRANT create session TO touresbalon;
GRANT create table TO touresbalon;
GRANT create view TO touresbalon;
GRANT create any trigger TO touresbalon;
GRANT create any procedure TO touresbalon;
GRANT create sequence TO touresbalon;
GRANT create synonym TO touresbalon;

ALTER USER touresbalon quota unlimited on system;

COMMIT;