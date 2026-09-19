# Product and Database Requirements

## Problem
FindOS helps users search for concepts inside long videos and jump directly to the relevant timestamp.

## Users
- Guests can search and watch limited content before login.
- Students can search, watch, jump to timestamps, use transcripts, rate, bookmark, save timestamps, manage personal playlists, follow teachers, share timestamps, and view history.
- Teachers can self-register, search/watch before approval, and upload/manage content after approval.
- System Admin/Super Admin manage users, teachers, videos, courses, roles, processing failures, search/content management, moderation, analytics, and audit history.

## Database-relevant requirements
- A user can have multiple roles.
- Students and teachers self-register.
- Teacher approval is separate from account activation.
- Teachers own videos and courses they create.
- Courses may have multiple teachers.
- Videos may belong to multiple courses.
- Video replacement must not destroy a working version before the new version succeeds.
- Transcript segments must map to exact video time ranges.
- Search results are video-level with multiple matching timestamps.
- Search checks transcript even when metadata matches.
- Ratings are 1–5 and changeable.
- A student may save multiple timestamps for a video.
- Search history includes no-result queries.
- Analytics and audit data must survive content/account deletion when retention requirements require it.
