# System Overview

```text
Client
  |
  v
Backend API
  |
  +---- PostgreSQL
  |       |
  |       +---- application data
  |       +---- transcripts
  |       +---- pgvector embeddings
  |       +---- analytics/audit
  |
  +---- S3
  |       |
  |       +---- original videos
  |       +---- durable processing artifacts
  |
  +---- Queue
          |
          v
        Workers
          |
          +---- audio extraction
          +---- transcription
          +---- segmentation
          +---- embedding
          +---- indexing
```

The architecture starts simple and grows only when measured requirements justify additional infrastructure.
