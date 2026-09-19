# ADR-001: Store Original Videos in Amazon S3

## Context
FindOS stores large video files.

## Decision
Store original videos in Amazon S3. PostgreSQL stores metadata and S3 object references.

## Why
Object storage is appropriate for large durable video files.

## Tradeoffs
Adds object-storage integration and access-control/lifecycle requirements.

## Reconsideration
Revisit if storage cost, access patterns, or infrastructure requirements change.
