CREATE TABLE server.car
(
    id                  BIGINT PRIMARY KEY GENERATED ALWAYS AS IDENTITY,
    uuid                UUID            NOT NULL UNIQUE DEFAULT gen_random_uuid(),
    car_name            VARCHAR,

    created_at          TIMESTAMPTZ     NOT NULL DEFAULT CURRENT_TIMESTAMP,
    created_by          VARCHAR         NOT NULL,
    created_by_db       VARCHAR         NOT NULL DEFAULT SESSION_USER,
    modified_at         TIMESTAMPTZ     NOT NULL DEFAULT CURRENT_TIMESTAMP,
    modified_by         VARCHAR         NOT NULL,
    modified_by_db      VARCHAR         NOT NULL DEFAULT SESSION_USER
)