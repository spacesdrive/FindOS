# FindOS Architecture: Failure Handling

## Principles
1. Never replace working content with failed processing.
2. Preserve the current searchable version during reprocessing.
3. Expose explicit failure states.
4. Keep authoritative application state separate from search state.
5. Keep long-running processing asynchronous.

## Upload Failures
Reject unsupported/corrupt files, missing/invalid required metadata, no-audio files and other validation failures. Show the teacher an exact error.

## Processing Failures
Mark the video failed and require a teacher-initiated retry in V1. If reprocessing an existing video fails, the old version remains active.

## Search Failure
If semantic/vector search is unavailable, return an error.

## YouTube Failure
If an indexed YouTube video becomes unavailable, it should no longer behave as an active searchable/watchable video while retaining internal state for later re-indexing.

## Later Engineering Concerns
Timeouts, idempotency, duplicate processing, partial failure, backpressure, recovery, observability and dead-letter handling remain to be designed.
