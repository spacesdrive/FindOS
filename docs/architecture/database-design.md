# FindOS Database Design

## Primary database
PostgreSQL.

## Vector search
pgvector.

## Core entities
- User
- Video
- Course
- Transcript Segment
- Video Version
- Processing Attempt
- Rating
- Bookmark
- Saved Timestamp
- Personal Playlist
- Watch History/Watch Events
- Search History
- Teacher-Course Membership
- Course-Video Membership
- Teacher Follow
- Audit Event
- Analytics Events / derived aggregates

## Key relationships
- User → many Videos; each Video has one owner.
- User → many Courses; each Course has one owner.
- Course ↔ Video is many-to-many.
- Course ↔ Teacher is many-to-many.
- Video Version → many Transcript Segments; each segment belongs to exactly one version.
- Student ↔ Video Rating has one current rating per pair.
- Student ↔ Course Rating has one current rating per pair.
- Student ↔ Teacher Follow is unique per pair.

## Lifecycle
Video: uploaded → processing → ready/failed.
One current state; attempts retained.
Video versions allow staged replacement and atomic activation.

## Transcript
Authoritative transcript text remains stored as data. Embeddings are derived. Segment creation is automatic and hybrid.

## Ownership and deletion
Video owner = uploader. Course owner = creator. Teacher deletion transfers content ownership to System Admin/FindOS. Course deletion does not delete videos. Video deletion removes active searchable content, bookmarks, saved timestamps, and ratings while retaining playlists, watch/search history, and teacher analytics.

## Roles
Teacher and System Admin are User roles. Users may have multiple roles. Teacher approval is explicit.

## Integrity
Important constraints include ownership, rating range 1–5, unique student/video rating, unique student/course rating, and unique student/teacher follow.

## IDs and timestamps
Prefer UUIDs for externally visible IDs. Important records use created_at and updated_at.

## Consistency
Use transactions for atomic multi-record state transitions such as version activation and rating updates.

## Indexing
Prioritize ownership, relationship lookups, history, uniqueness, and segment/version lookups.

## Scale
Search/segment retrieval is the expected major bottleneck. Measure latency, index size, memory, write performance, and database load before adding separate infrastructure.
