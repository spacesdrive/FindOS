# FindOS System Overview

```text
Client
  |
  v
API
  |--------------------|
  v                    v
PostgreSQL          Search
  |                 PostgreSQL + pgvector
  |
  v
Async Processing
  |
S3 / transcription / embeddings
```

PostgreSQL is the authoritative relational store. pgvector stores transcript-segment embeddings. S3 stores original video and durable processing artifacts.

Search is segment-first:
query → query understanding → lexical + semantic retrieval → segment ranking → group by video → video ranking → video + timestamps.

Exact queue, worker, transcription provider, embedding model, API framework, and AWS topology remain open implementation decisions.
