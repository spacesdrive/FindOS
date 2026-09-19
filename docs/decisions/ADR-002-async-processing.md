# ADR-002: Process Videos Asynchronously

## Context
Video processing includes audio, transcription, segmentation, embeddings, and indexing.

## Decision
Use asynchronous processing.

## Why
Upload requests should not wait for expensive processing.

## Tradeoffs
Requires state tracking, workers, and failure handling.

## Consequences
One current processing state exists and processing attempts are retained. V1 requires manual retry.

## Reconsideration
Revisit retry and queue design as workload grows.
