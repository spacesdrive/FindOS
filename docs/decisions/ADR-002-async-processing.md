# ADR-002: Asynchronous Video Processing

## Context
Transcription, segmentation, embedding, and indexing are long-running operations.

## Decision
Uploads return quickly after durable storage/initial state creation. Background workers process Video Versions asynchronously.

## Why
Long-running processing should not block API requests.

## Tradeoffs
Requires queueing, worker state, failure handling, observability, and idempotency.

## V1
Manual retry is used. Automatic retry/DLQ behavior is deferred until required.
