CREATE TABLE server.log
(
    id                  BIGINT PRIMARY KEY GENERATED ALWAYS AS IDENTITY,
    uuid                UUID            NOT NULL UNIQUE DEFAULT gen_random_uuid(),
    session_id          BIGINT          NOT NULL REFERENCES server.session ON DELETE CASCADE,
    message             VARCHAR         NOT NULL,
    class_сreator       VARCHAR,
    function_сreator    VARCHAR,

    created_at          TIMESTAMPTZ     NOT NULL DEFAULT CURRENT_TIMESTAMP,
    created_by          VARCHAR         NOT NULL,
    created_by_db       VARCHAR         NOT NULL DEFAULT SESSION_USER,
    modified_at         TIMESTAMPTZ     NOT NULL DEFAULT CURRENT_TIMESTAMP,
    modified_by         VARCHAR         NOT NULL,
    modified_by_db      VARCHAR         NOT NULL DEFAULT SESSION_USER
)