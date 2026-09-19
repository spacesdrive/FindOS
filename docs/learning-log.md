# FindOS Learning Log

## Milestone 0: Product Definition
FindOS primarily helps students find specific concepts inside long lectures. Teachers/professors provide lecture content. Search is relevance-driven and timestamp-aware.

Important decisions:
- Guests search like students but watch only 30 seconds before login is required.
- Teachers require admin approval before upload.
- Search checks transcript even when title metadata matches.
- Results are one result per video with multiple relevant timestamps.
- Timestamp accuracy target is ±5 seconds from the actual explanation point.
- Personalization is used for recommendations/home/search suggestions, not as the dominant core-search signal.
- Processing is asynchronous and failed processing requires manual retry in V1.
- Old searchable video versions remain active until replacement succeeds.

## Milestone 1: Architecture
- Original videos use Amazon S3.
- Processing is asynchronous.
- Durable artifacts can use S3; authoritative metadata is relational.
- Search is segment-first.
- Structured filters remain structured data.

## Milestone 2: Database Design
- Core entities: User, Video, Course, Transcript Segment.
- Teacher and System Admin are roles of User.
- Video owner is uploader. Course owner is creator.
- Courses can have multiple teachers and videos can belong to multiple courses.
- Transcript Segment belongs to exactly one Video Version.
- Ratings are unique per student/video and per student/course.
- PostgreSQL is the primary database.
- pgvector stores segment embeddings.
- Transcript text remains authoritative; embeddings are derived.
- Hybrid segmentation uses timestamps, sentence boundaries, and semantic coherence.
- Processing has one current state plus retained processing attempts.
- Video versions support atomic replacement.
- Analytics use raw events plus derived aggregates where useful.
- Search performance is expected to be the main scaling pressure.

## Next
Database schema → database ADR → API contracts → backend implementation.
