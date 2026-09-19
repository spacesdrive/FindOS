# ADR-007: User Role Model

## Context
FindOS users may hold multiple roles, such as STUDENT and TEACHER.

## Decision
Use `users`, `roles`, and `user_roles`. Role codes are controlled and unique. `user_roles` has a composite primary key `(user_id, role_id)`.

## Why
A many-to-many model represents multiple roles without duplicating user records or adding columns every time a new role appears.

## Tradeoffs
Authorization queries require a relationship lookup. Indexing and caching can address this if measurement shows it matters.
