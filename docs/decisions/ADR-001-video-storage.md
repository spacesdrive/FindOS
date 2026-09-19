# ADR-001: Video Storage

## Context
FindOS stores uploaded and indexed video content.

## Decision
Store original videos and durable processing artifacts in Amazon S3. PostgreSQL stores metadata and object references.

## Why
Object storage is appropriate for large binary files, while PostgreSQL remains the system of record for metadata and relationships.

## Tradeoffs
Requires object-storage lifecycle and access controls. Database transactions cannot atomically include S3 operations, so application state transitions must be designed carefully.

## Reconsideration
Revisit if storage cost, access patterns, compliance, or delivery requirements change.
