ALTER TABLE account ALTER COLUMN username DROP NOT NULL;
ALTER TABLE account ADD COLUMN confirmed_at TIMESTAMP;
ALTER TABLE account ADD COLUMN confirmed_ip INET;
ALTER TABLE account ADD COLUMN newsletter BOOLEAN NOT NULL DEFAULT TRUE;
ALTER TABLE account ADD COLUMN username_typohard varchar(100) UNIQUE;

DROP TABLE confirmaccountlink;
ALTER TABLE loginlink ADD COLUMN redirect TEXT;
