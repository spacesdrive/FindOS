# FindOS Engineering Documentation

## Current phase
Milestone 2: Database Design

## Status
Schema design decisions are complete. Implementation begins with the database foundation and migrations.

## Current direction
- PostgreSQL is the primary relational database.
- pgvector is the initial vector-search approach.
- Transcript Segment is the primary search unit.
- Transcript segmentation is hybrid: timestamps + sentence boundaries + semantic coherence.
- Original videos and durable processing artifacts are stored in Amazon S3.
- Video processing is asynchronous.
- Search retrieves transcript segments first, then groups and ranks videos.
- Video owner is the uploader/owner user.
- Course owner is the creator.
- Teacher and System Admin are roles on User, not separate account entities.
- Users can have multiple roles through `user_roles`.
- Video versions are explicit so replacement can be atomic and failure-safe.
- Transcript segments belong to a video version.
- Analytics use raw events plus derived aggregates when needed.
- Audit records are durable database records.

## Implementation sequence
1. Database connection and migration tooling.
2. Users, roles, and user_roles.
3. Teacher approval profile.
4. Videos and video versions.
5. Courses and course relationships.
6. Transcripts and transcript segments.
7. Student activity and ratings.
8. Processing attempts and analytics/audit data.
9. Search indexes and pgvector.

Prefer the simplest architecture that satisfies measured requirements.
