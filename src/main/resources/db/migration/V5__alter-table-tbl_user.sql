ALTER TABLE TBL_USER
ADD ROLE VARCHAR2(100) DEFAULT 'USER'
ADD CONSTRAINT email_unico UNIQUE (EMAIL);