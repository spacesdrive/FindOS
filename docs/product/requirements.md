# FindOS Product Requirements

## Problem
FindOS helps students search for a specific concept inside long lecture videos and jump directly to the relevant point.

## Users
- Students: primary users.
- Teachers/Professors: content providers; admin approval required before upload.
- Guests: same search experience, 30-second watch limit before login.
- System Admins: platform management.

## Video sources
- Teacher uploads to FindOS.
- System Admin adds/indexes YouTube videos in V1.
- YouTube videos appear in search like FindOS uploads.

## Search
Searches titles, descriptions, tags, transcript text, course/playlist names, and teacher names. Filters include teacher, course/playlist, video, duration, upload date, rating, and topic/category.

Search flow:
query understanding → lexical + semantic retrieval → transcript-segment ranking → group by video → video ranking → video + timestamps.

Segment ranking uses semantic similarity, keyword/text matching, and metadata. Video ranking prioritizes relevance, query-specific engagement, then content quality.

No relevance score is shown to users. If results are only partial matches they are shown as such; if no relevant result passes the threshold, show no relevant results. If semantic/vector search is unavailable in V1, return an error.

## Timestamp
Player starts slightly before the matching segment; matching transcript is highlighted; multiple relevant timestamps may be shown. Target accuracy: ±5 seconds from the actual explanation point.

## Transcript
Full transcript is shown with timestamped segments. Current segment is highlighted during playback. Clicking a segment jumps the player. Transcript can be searched.

Segments are generated automatically, not manually by teachers. Segmentation uses timestamps, sentence boundaries, and semantic coherence.

## Authentication
Students and teachers self-register. Teachers may use normal non-upload functionality before approval. V1 includes registration, login, logout, email verification, password reset/change, session management, multiple-device sessions, remember me, and account deletion.

## Student
Watch, timestamp jumps, transcript, transcript search, ratings, bookmarks, saved timestamps, watch/search history, teacher follows, sharing, and personal playlists.

Ratings are 1–5 and editable. One current rating per student/video and per student/course.

## Teacher
Create/manage courses, organize videos, manage metadata/profile, view watch/search/timestamp analytics, ratings, and course/playlist content.

Video owner = uploader. Course owner = creator. Additional teachers can be associated with a course and removed without becoming owners.

## Video upload
Maximum 1 GB, no duration limit. Required: title, description, tags, course/playlist, thumbnail. Tags: 3–10.

Unsupported formats, corrupted files, invalid metadata, and missing audio are rejected. Complete transcription failure is a processing failure. Poor transcript quality may publish with a warning.

Duplicate choices: replace, upload separately, or cancel.

## Editing/deletion
Teacher can edit title, description, tags, course/playlist, and thumbnail. Reprocessing creates a replacement version; old searchable version remains active until new version succeeds.

Video deletion removes active searchable content, bookmarks, saved timestamps, and ratings. Playlists, watch history, search history, and teacher analytics remain.

Course deletion does not delete videos; it removes course membership.

Teacher account deletion removes profile/teacher-specific analytics while videos/courses remain and ownership transfers to System Admin/FindOS.

## Courses
Courses can contain many videos; videos can belong to multiple courses. Courses can have multiple teachers. No student enrollment in V1.

## Personalization
Recommendations, followed-teacher content, search suggestions, and personalized home page are supported. No follow notifications in V1.

## Sharing
Timestamp sharing requires login; authenticated users jump to the timestamp.

## Processing
VIDEO → STORAGE → PROCESSING → AUDIO → TRANSCRIPTION → TIMESTAMPED SEGMENTS → SEARCH REPRESENTATIONS → INDEX.

Processing is asynchronous. One current processing state exists; attempts are retained. V1 requires manual retry after failure.

## YouTube
Admins can add, edit FindOS metadata, remove, and re-index/reprocess. FindOS metadata remains authoritative.
