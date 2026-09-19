# Database Decisions

## Database
PostgreSQL is the primary database because FindOS needs relational relationships, transactions, constraints, indexing, and complex queries.

## Vector search
pgvector is the initial vector-search approach. Pinecone is not used initially. Transcript text remains authoritative in PostgreSQL; embeddings are derived data.

## IDs
Externally visible entity identifiers use UUIDs.

## Timestamps
Important records use `created_at` and `updated_at`. Authentication keeps `last_login_at` in PostgreSQL because it is durable account data, not cache state.

## Users and roles
Users can have multiple roles. Roles are represented by a `roles` table and assigned through `user_roles`. Role `code` is the stable application value; role `name` is human-readable.

Initial roles: STUDENT, TEACHER, ADMIN, SUPER_ADMIN.

## User identity
Email is required and case-insensitively unique. Phone is optional and unique when provided. Date of birth/age is not stored unless a concrete product requirement requires it. Passwords are stored only as secure password hashes.

## Account and teacher approval
Account lifecycle is separate from teacher approval. Account statuses are PENDING, ACTIVE, SUSPENDED, and DELETED. Teacher approval uses a separate teacher profile with PENDING, APPROVED, and REJECTED states.

## Video model
A logical Video may have multiple Video Versions. A new version is processed while the previous current version remains active. A successful replacement atomically makes the new version current and retires the old version. A failed replacement leaves the old version active.

## Courses
A Course has one owner, may have multiple teacher members, and may contain many videos. A video may belong to many courses. Course deletion removes relationships but does not delete videos.

## Transcripts
Transcript records belong to Video Versions. Transcript Segments are the primary search unit. Old version segments are retired when a new version becomes active.

## Student activity
Watch history stores viewing sessions/events. Saved timestamps allow multiple records per video. Teacher follows are unique per student/teacher pair. Students may rate a video and a course once each and can change the rating.

## Search history
Search history is stored, including no-result searches. Guest searches may have a null user reference.

## Analytics and audit
Analytics store raw events with optional references and JSON metadata. Derived aggregates may be introduced when measurement requires them. Audit records store actor, action, target, timestamp, and metadata.

## Deletion
Deletion behavior is entity-specific. Video deletion removes search/transcript/rating/bookmark relationships while preserving required watch history and analytics. Course deletion keeps videos. Teacher deletion removes the teacher profile while retaining videos/courses and transferring ownership to FindOS/System Admin where required.

## Integrity
Critical multi-record state transitions use transactions. Important relationship tables use composite uniqueness/primary-key constraints. Indexes follow known access patterns and are expanded based on measured query performance.
