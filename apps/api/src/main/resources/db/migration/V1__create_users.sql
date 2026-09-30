CREATE EXTENSION IF NOT EXISTS pgcrypto;

CREATE TABLE users (
    id UUID PRIMARY KEY
        DEFAULT gen_random_uuid(),

    name VARCHAR(100) NOT NULL,

    email VARCHAR(255) NOT NULL,

    password_hash VARCHAR(255) NOT NULL,

    account_status VARCHAR(20) NOT NULL
        DEFAULT 'PENDING',

    email_verified_at TIMESTAMPTZ,

    last_login_at TIMESTAMPTZ,

    created_at TIMESTAMPTZ NOT NULL
        DEFAULT NOW(),

    updated_at TIMESTAMPTZ NOT NULL
        DEFAULT NOW()
);

CREATE UNIQUE INDEX users_email_unique
    ON users (LOWER(TRIM(email)));