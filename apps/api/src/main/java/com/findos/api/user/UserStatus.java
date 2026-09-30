package com.findos.api.user;

/**
 * Stored in users.account_status as its name (e.g. "PENDING").
 * The database has no CHECK constraint (project decision), so this enum
 * is the only place the allowed values are defined.
 */
public enum UserStatus {
    PENDING
}
