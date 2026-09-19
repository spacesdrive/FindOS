# Database Schema Design

## Core entities
- users
- roles
- user_roles
- teacher_profiles
- videos
- video_versions
- courses
- course_teachers
- course_videos
- tags
- video_tags
- transcripts
- transcript_segments
- playlists
- playlist_videos
- watch_sessions
- search_history
- saved_timestamps
- teacher_follows
- video_ratings
- course_ratings
- processing_attempts
- analytics_events
- audit_logs

## User and authorization
`users` stores account identity and lifecycle. `roles` stores controlled role codes/names. `user_roles` is many-to-many and uses `(user_id, role_id)` as its primary key.

User fields include UUID id, name, case-insensitively unique email, optional unique phone, password hash, account status, email verification timestamp, last login timestamp, and created/updated timestamps.

Teacher approval is modeled separately through `teacher_profiles`.

## Content ownership
A Video has one owner. A Course has one owner. Course membership and course-video membership are separate many-to-many relationships.

## Versioning
`video_versions` represents concrete content versions. Only one version is current for a Video. Processing a replacement does not affect the current version until the replacement succeeds.

## Transcript hierarchy
Video → Video Version → Transcript → Transcript Segment.

Segments contain sequence number, start time, end time, and text. Embeddings are derived search data attached to the segment representation.

## Student-owned data
Personal playlists, watch sessions, saved timestamps, follows, ratings, and search history are separate from teacher-managed courses.

## Analytics and audit
Raw analytics events support derived aggregates. Audit logs capture administrative actions and targets.

## Integrity constraints
Use foreign keys, unique constraints, check constraints, and transactions for invariants and critical state changes.

## Indexing
Start with ownership, relationship, history, uniqueness, version/current-state, and transcript lookup indexes. Add search-specific indexes based on measured query plans and latency.
