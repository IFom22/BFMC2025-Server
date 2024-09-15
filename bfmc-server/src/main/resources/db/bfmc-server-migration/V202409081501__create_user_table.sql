CREATE TABLE server._user
(
    id                  BIGINT PRIMARY KEY GENERATED ALWAYS AS IDENTITY,
    first_name          VARCHAR         NOT NULL,
    last_name           VARCHAR         NOT NULL,
    email               VARCHAR         NOT NULL,
    password            VARCHAR         NOT NULL,
    role                VARCHAR         NOT NULL,

    created_at          TIMESTAMPTZ     NOT NULL DEFAULT CURRENT_TIMESTAMP,
    created_by          VARCHAR         NOT NULL,
    created_by_db       VARCHAR         NOT NULL DEFAULT SESSION_USER,
    modified_at         TIMESTAMPTZ     NOT NULL DEFAULT CURRENT_TIMESTAMP,
    modified_by         VARCHAR         NOT NULL,
    modified_by_db      VARCHAR         NOT NULL DEFAULT SESSION_USER
)