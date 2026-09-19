# Video Processing

Pipeline:

VIDEO → STORAGE → PROCESSING → AUDIO → TRANSCRIPTION → TIMESTAMPED SEGMENTS → SEARCH REPRESENTATIONS → INDEX

Processing is asynchronous. The API records an initial processing state and workers advance the Video Version through stages.

Each stage should be designed for idempotency. Processing attempts are stored for diagnostics. V1 uses manual retry rather than automatic retry.

Failures mark the relevant version/attempt as failed. A failed replacement does not replace the current working version.

The guide requires explicit processing state, retries/failure handling, idempotency, and metrics as the pipeline matures. fileciteturn0file0L223-L245
