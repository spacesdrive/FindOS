# FindOS V1 Glossary

## Core terms
- <b>FindOS:</b> The video search engine described by this product definition.
- <b>Student:</b> Primary FindOS user searching for concepts inside educational videos.
- <b>Teacher/Professor:</b> Educational content provider who can upload after administrative approval.
- <b>System Admin:</b> Privileged operator responsible for platform management and moderation.
- <b>Guest:</b> Unauthenticated user with normal search access and 30-second playback.
- <b>Video:</b> A searchable educational video item in FindOS, either directly uploaded or indexed from YouTube.
- <b>Course/Playlist:</b> Teacher-managed collection of videos. In V1 these terms represent the same teacher-facing concept.
- <b>Personal Playlist:</b> Student-owned collection of saved videos, distinct from teacher courses.

## Search terms
- <b>Query:</b> Natural-language request submitted by a student.
- <b>Result:</b> One video returned for a query.
- <b>Matching segment:</b> A timestamped transcript/content region relevant to a query.
- <b>Partial match:</b> Content related to the query but not a complete answer.
- <b>No relevant results:</b> No available content meets the defined relevance threshold.
- <b>Query-specific engagement:</b> Engagement behavior associated with a particular query and result, rather than generic popularity.

## Processing terms
- <b>Processing:</b> Work required to turn a source video into usable searchable content.
- <b>Transcript:</b> Time-aligned text derived from video speech.
- <b>Processing failure:</b> A processing stage fails such that the intended searchable output cannot be produced.
- <b>Poor transcript:</b> A transcript exists but is considered insufficiently useful for reliable search. V1 publishes such videos with a warning.
- <b>Reprocessing:</b> Processing a new version of an already indexed video after an edit or other source change.
- <b>Atomic replacement:</b> Product behavior in which the old working searchable version remains active until the replacement successfully processes.

## Content lifecycle
- <b>Active:</b> Content available for normal search and viewing.
- <b>Temporarily hidden:</b> Content unavailable to normal users due to moderation/suspension.
- <b>Deleted:</b> Content removed from active search/watch access while defined historical records may remain.
- <b>Unavailable:</b> External content, such as YouTube content, that can no longer be accessed.