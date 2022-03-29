CREATE TABLE app_user (id BIGSERIAL NOT NULL PRIMARY KEY, name VARCHAR
, user_name VARCHAR, email VARCHAR,
, password VARCHAR, role VARCHAR,
, account_locked BOOLEAN, enabled BOOLEAN);

CREATE TABLE confirmation_token (id BIGSERIAL NOT NULL PRIMARY KEY, token VARCHAR
, created_at VARCHAR, expired_at VARCHAR,
, confirmed VARCHAR, app_user_id VARCHAR);