ALTER TABLE server.session
    ADD ended TIMESTAMPTZ,
    ADD competition_type VARCHAR NOT NULL;