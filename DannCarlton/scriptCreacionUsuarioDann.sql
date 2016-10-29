--DANN CARLTON
create user dann identified by dann;

GRANT create session TO dann;
GRANT create table TO dann;
GRANT create view TO dann;
GRANT create any trigger TO dann;
GRANT create any procedure TO dann;
GRANT create sequence TO dann;
GRANT create synonym TO dann;

ALTER USER dann quota unlimited on system;

COMMIT;