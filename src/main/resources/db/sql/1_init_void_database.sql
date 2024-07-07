-- initiate schema
CREATE SCHEMA IF NOT EXISTS void;

-- configure path to use new schema
SET search_path TO void, public;
GRANT ALL PRIVILEGES ON SCHEMA void TO void;

-- Enable the uuid-ossp extension
CREATE EXTENSION IF NOT EXISTS "uuid-ossp";

-- Create a table using a specific UUID version for the primary key
CREATE TABLE IF NOT EXISTS category
(
    id   UUID DEFAULT uuid_generate_v4() PRIMARY KEY,
    name VARCHAR(255) NOT NULL UNIQUE
);

CREATE TABLE IF NOT EXISTS time_management
(
    id              UUID DEFAULT uuid_generate_v4() PRIMARY KEY,
    category_id     UUID,
    task            VARCHAR(255),
    time_in_minutes BIGINT,
    status          VARCHAR(50),
    created_at      TIMESTAMP,
    updated_at      TIMESTAMP,
    version         BIGINT,
    CONSTRAINT fk_category_id FOREIGN KEY (category_id) REFERENCES category (id)
);

