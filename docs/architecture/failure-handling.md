# FindOS Failure Handling

## Upload
Reject unsupported formats, corrupted files, invalid/missing metadata, and missing audio.

## Processing
Mark failed, retain active version, record failure, require manual retry.

## Reprocessing
Old searchable version remains active until replacement succeeds.

## YouTube
Unavailable source can be marked unavailable and removed from normal search/watch until re-indexed.

## Integrity
Database constraints should enforce important invariants where practical: required ownership, valid rating range, unique current ratings, unique follows.

## Async concerns
Implementation must account for idempotency, duplicate jobs, timeouts, partial failure, ordering, backpressure, and recovery.
