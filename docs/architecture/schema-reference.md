# Schema Reference

## users
`id UUID PK`, `name`, `email CITEXT UNIQUE NOT NULL`, `phone NULL UNIQUE`, `password_hash`, `account_status`, `email_verified_at NULL`, `last_login_at NULL`, `created_at`, `updated_at`.

## roles
`id UUID PK`, `code UNIQUE NOT NULL`, `name NOT NULL`.

Initial codes: `STUDENT`, `TEACHER`, `ADMIN`, `SUPER_ADMIN`.

## user_roles
`user_id FK`, `role_id FK`, composite primary key.

## teacher_profiles
`user_id PK/FK`, `approval_status`, `approved_at`, `approved_by`, timestamps.

## videos
Logical content identity and FindOS metadata.

## video_versions
Concrete content version, object reference, checksum, processing status, current flag, timestamps.

## courses
Teacher-managed collection with one owner.

## course_teachers
Course/teacher membership.

## course_videos
Course/video membership and ordering.

## tags / video_tags
Normalized video tags.

## transcripts
Transcript for a Video Version.

## transcript_segments
Timestamped searchable transcript units.

## playlists / playlist_videos
Student-owned personal playlists.

## watch_sessions
Viewing sessions/events.

## search_history
User or guest search records, including zero-result searches.

## saved_timestamps
Multiple saved timestamp records per user/video.

## teacher_follows
Unique student/teacher follows.

## video_ratings / course_ratings
One current 1–5 rating per student/content pair.

## processing_attempts
Stage-level processing history.

## analytics_events
Raw product/usage events.

## audit_logs
Administrative action history.
