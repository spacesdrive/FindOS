# Failure Handling

## Database
Use transactions for critical multi-record state transitions. Foreign keys and unique constraints protect integrity.

## Video processing
A failed processing attempt is recorded with stage and error information. The current working version remains active when a replacement fails.

## Duplicate uploads
V1 detects duplicates and allows the user/admin flow to choose replacement, separate upload, or cancellation.

## Search
If semantic/vector search is unavailable in V1, the search operation returns an explicit error according to the API contract rather than silently pretending degraded semantic search succeeded.

## Future distributed-system concerns
As workers scale, explicitly address timeouts, retries, duplicate messages, ordering, backpressure, idempotency, partial failure, and recovery.
