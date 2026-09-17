# FindOS Architecture: Video Processing

## Goal
Turn uploaded or indexed videos into searchable, timestamp-aware content without blocking the upload request.

## Pipeline

```text
VIDEO -> STORAGE -> PROCESSING -> AUDIO -> TRANSCRIPTION
      -> TIMESTAMPED SEGMENTS -> SEARCH REPRESENTATIONS -> INDEX
```

## V1 Rules
- Maximum direct-upload size: 1 GB.
- No video-duration limit.
- No audio track: reject immediately.
- Unsupported/corrupt input: reject.
- Required metadata must be present and valid.
- Tags: 3 to 10.
- Duplicate: detect and offer replace, separate upload or cancel.
- Complete transcription failure: processing failure.
- Poor transcript quality: may publish with a warning.

## Async Behavior
The upload request stores the video and returns a processing status. Processing runs in the background.

## Versioning
The currently searchable version remains active during reprocessing. A successful replacement becomes active. A failed replacement leaves the old version active and causes no user-visible replacement.

## Open Engineering Questions
Queue technology, idempotency, retry mechanics, artifact locations, progress representation, transcript-quality evaluation and worker scaling remain to be designed.
