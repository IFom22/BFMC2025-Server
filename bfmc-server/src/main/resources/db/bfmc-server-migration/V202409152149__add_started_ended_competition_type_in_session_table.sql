ALTER TABLE server.session
    ADD status           VARCHAR NOT NULL,
    ADD competition_type VARCHAR NOT NULL;