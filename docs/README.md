# FindOS Engineering Documentation

## Current phase
Milestone 2: Database Design

## Current direction
- PostgreSQL is the primary relational database.
- pgvector is the initial vector-search approach.
- Transcript Segment is the primary search unit.
- Transcript segmentation is hybrid: timestamps + sentence boundaries + semantic coherence.
- Videos are stored in Amazon S3.
- Video processing is asynchronous.
- Search ranks transcript segments first, then groups by video and ranks videos.
- Video owner = uploader.
- Course owner = creator.
- Teacher and System Admin are User roles, not separate account entities.

Prefer the simplest architecture that satisfies measured requirements.
