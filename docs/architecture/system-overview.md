# FindOS Architecture: System Overview

## Status
Draft based on Milestone 0 requirements and the initial architecture interview.

## Purpose
Define FindOS system boundaries and responsibilities without prematurely choosing infrastructure technologies that have not yet been justified.

## High-Level Model

```text
Students / Teachers / Admins
            |
            v
        FindOS API
        /        \
       v          v
 Application   Search Layer
 Database          |
       |            v
       |       Ranked transcript
       |          segments
       v
 Metadata / state

Teacher upload
      |
      v
 Amazon S3
      |
      v
Async processing
      |
      +--> Audio / Transcript
      +--> Timestamped segments
      +--> Search representations
      |
      v
 Search layer
```

## Major Responsibilities

### API/Application Layer
Handles user-facing operations, authentication and authorization boundaries, metadata, search requests, content actions and administration.

### Application Database
Authoritative store for application metadata, relationships, ownership, lifecycle state and references to stored objects.

### Amazon S3
Stores original video files and suitable processing artifacts. The application database stores references/keys rather than video binaries.

### Processing System
Processes videos asynchronously and produces transcript, timestamp and searchable artifacts.

### Search Layer
Supports lexical/text and semantic retrieval over timestamped transcript segments and relevant metadata. Search candidates are ranked at segment level and then grouped/ranked at video level.

## Boundaries
- Large video binaries do not belong in the application database.
- Search-optimized data is separate from authoritative application data.
- Long-running processing does not block upload requests.
- A failed replacement must never destroy the previous working searchable version.

## Not Yet Decided
Relational database technology, exact search engine/vector technology, queue, worker runtime, transcription provider, API framework, network topology, embedding model and exact ranking weights remain open.
