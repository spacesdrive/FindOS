# FindOS V1 Product Requirements

## 1. Product Overview
- FindOS is a video search engine designed primarily for students. A student searches using natural language for a concept and receives relevant lecture videos with matching timestamps, allowing the student to jump directly to the portion where the concept is explained.
- Primary user: Student. Primary job-to-be-done: <b>Find a specific concept inside a long lecture without watching the entire video.</b>
- Secondary users are teachers/professors, who provide educational content, and System Administrators, who operate and moderate the platform.
- V1 deliberately focuses on searchable educational video rather than becoming a general-purpose public-web video search engine.

## 2. Problem Statement
- Students often need one specific concept from a long lecture or course video. Watching an entire lecture to locate a single explanation wastes time and makes long-form educational video harder to use.
- FindOS addresses this by connecting natural-language search with transcript content and timestamps so that search results lead directly to useful moments in videos.

## 3. Target Users
- <b>Students:</b> Search, discover, watch and navigate educational videos; save useful content; rate content; follow teachers; maintain history and personal playlists.
- <b>Teachers/Professors:</b> Create courses/playlists, upload educational videos after approval, manage their content and inspect aggregated engagement/search analytics.
- <b>System Administrators:</b> Manage users, teachers, content, roles, moderation, processing failures, search/content management, analytics and audit history.

## 4. V1 Content Sources
- <b>Direct uploads:</b> Teachers/professors upload lecture videos to FindOS.
- <b>YouTube:</b> System Administrators can add and index YouTube videos. YouTube is the only external video platform supported in V1.
- All successfully processed FindOS and YouTube content is treated as first-class searchable content from the student's perspective.
- V1 does not search the entire public internet.

## 5. Roles and Permissions
- <b>Guest:</b> May search and use the normal search experience, but video playback is limited to 30 seconds. Guests cannot report content or use authenticated timestamp-sharing access.
- <b>Student:</b> May search, watch, jump between matching timestamps, view/search transcripts, rate video/course, bookmark videos, save timestamps, view history, follow teachers, share video/timestamp links, create personal playlists and manage profile.
- <b>Teacher/Professor:</b> May self-register and use normal viewing/search features while awaiting approval. Upload capability is available only after System Admin approval. Approved teachers may upload videos, manage their own videos, manage courses/playlists, manage profiles and view analytics.
- <b>System Admin:</b> System Admin accounts are created only by another System Admin. Admins manage users, teachers, videos, courses, roles, processing failures, search/content management, reports/moderation, analytics and audit/history.

## 6. Registration and Authentication
- V1 includes registration, login, logout, email verification, forgot password, password reset, change password, session management, multiple-device sessions, remember-me behavior and account deletion.
- Students and teachers/professors self-register. A user cannot simply select the Teacher role and immediately gain upload privileges. Teacher status requires administrative approval.
- Teacher approval is an authorization state, not merely a profile label. An unapproved teacher can log in, search and watch content but cannot upload.

## 7. Video Upload Requirements
- Maximum file size: <b>1 GB per video</b>. There is no duration limit.
- Required metadata: Title, Description, Tags, Course/Playlist and Thumbnail.
- Tags: minimum 3 and maximum 10.
- Course/playlist: the teacher can select an existing course/playlist or create a new one during upload if necessary.
- Unsupported format: reject.
- Corrupted file: reject.
- Missing or invalid required metadata: reject and ask the teacher to correct it.
- No audio track: reject immediately.
- Duplicate video: detect the duplicate and allow the teacher to replace the existing video, upload it as a separate video, or cancel.

## 8. Processing and Publishing
- Videos are processed before normal searchable publication.
- If transcription completely fails to produce a transcript, the video is not treated as a normal successful searchable video.
- If a transcript exists but is poor/unusable, the video may be published with a warning that search may not work properly.
- Processing failures must expose an exact error to the teacher.
- When an existing video is reprocessed after metadata changes, the old searchable version remains available until the new version has successfully completed processing.
- If reprocessing fails, no user-visible replacement occurs. The old version remains active. A successful new version replaces the old version silently.

## 9. Duplicate Upload Behavior
- Duplicate detection is a user decision point rather than an automatic destructive operation.
- The teacher receives three choices: replace the existing video, upload as a separate video, or cancel.
- Replacement must not destroy the existing working version until the replacement has successfully processed.

## 10. Search Scope
- Search covers video titles, descriptions, tags, transcript text, course/playlist names and teacher names.
- V1 filters: teacher, course/playlist, video, duration, upload date, rating and topic/category.
- Search is intended to support natural-language concept discovery, not only exact keyword lookup.

## 11. Search Result Contract
- FindOS returns <b>one result per video</b>. A video may contain multiple matching timestamps.
- A result should communicate the relevant video and the useful locations inside that video rather than producing a separate search result for every transcript segment.
- Matching transcript content should be available around the relevant timestamp so the student can understand why the result is useful.

## 12. Search Ranking
- Primary ranking priorities: <b>1) relevance, 2) query-specific engagement, 3) content quality.</b>
- Relevance considers title, description, tags, transcript/video content and timestamp/segment match.
- Engagement signals may include total watch time, percentage watched, number of views, timestamp jumps, bookmarks, ratings, shares, follows and search-result clicks.
- Query-specific engagement should be more informative than generic popularity. For example, many students finding a particular explanation useful for a specific query is stronger evidence for that query than a large unrelated global view count.
- Content quality considers clarity of explanation, completeness and student ratings.
- Teacher expertise/authority does not automatically outrank equally relevant content.
- Personalization affects recommendations, search suggestions and the home page rather than being the dominant factor in core search relevance.

## 13. Partial and No Results
- If results are reasonably related but do not fully satisfy the query, FindOS displays them as partial matches.
- If the query and available content are substantially unrelated, FindOS displays <b>No relevant results found.</b>
- This implies that V1 must eventually define and measure a relevance threshold rather than relying on subjective judgment alone.

## 14. Timestamp Behavior
- When a student opens a relevant result, playback starts slightly before the matching segment so the explanation has context.
- The relevant transcript segment is highlighted.
- Students can see multiple relevant timestamps when a concept occurs in multiple places.
- Timestamp accuracy target: the identified explanation point should be within <b>±5 seconds</b> of human-labeled ground truth.
- Transcript segments have timestamps. Clicking a segment jumps playback to that point. The currently playing transcript section is highlighted automatically.

## 15. Transcript Experience
- Students can view the complete transcript.
- The initially relevant transcript portion can be shown with an option to expand to the full transcript.
- Students can search within the transcript.
- Transcript segments are timestamped and clickable.

## 16. Sharing
- Authenticated students can share a video at a timestamp.
- Shared timestamp links require login.
- An authenticated recipient opening the link is automatically taken to the specified timestamp.

## 17. Student Personalization and Home
- Personalization includes recommended teachers, recommended courses, search suggestions and a personalized home page.
- Home page sections after activity exists: recently watched videos, continue watching, recommended courses, recommended teachers, new videos from followed teachers and popular videos.
- A brand-new student with no history, follows or searches receives a search bar as the primary home experience.
- Following a teacher prioritizes that teacher in recommendations and makes new videos from the followed teacher appear on the home page. V1 does not include notifications.

## 18. Ratings, Bookmarks and History
- Students rate videos and courses on a 1–5 star scale and may change their rating.
- Students may bookmark videos and save timestamps.
- Students may maintain watch/search history.
- Personal playlists are student-owned collections. A video can be added to multiple personal playlists.

## 19. Teacher Courses / Playlists
- For teachers, Course and Playlist are the same product concept. Teachers create/manage the collection and organize videos inside it.
- Teachers can create, edit and organize courses/playlists, add/remove videos and reorder videos.
- A video may belong to multiple teacher courses/playlists.
- Students can separately create personal playlists. These should be treated as user-owned collections distinct from teacher courses even though the product terminology overlaps.

## 20. Teacher Video Management
- Teachers can edit title, description, tags, course/playlist assignment and thumbnail.
- Teachers cannot directly edit the video file or transcript through the normal edit flow.
- Metadata changes require reprocessing before the new values become searchable.
- Old searchable content remains active during reprocessing and on reprocessing failure.

## 21. Teacher Analytics
- Teachers can see how many students watched videos, searches involving their videos, timestamps students frequently jump to, ratings and other defined engagement analytics.
- Search analytics should be aggregated and should not expose another student's private search history.

## 22. Video Deletion
- When a teacher deletes a video, its transcript, indexed/searchable content, student bookmarks, saved timestamps and ratings are removed.
- Student playlists containing the video, student watch history, student search history and teacher analytics are retained.
- Deleted videos must no longer appear as active searchable/watchable content.

## 23. Teacher Account Deletion
- Deleting a teacher account removes the teacher profile and teacher analytics.
- The teacher's videos and courses remain on FindOS.
- System Administrators control the remaining content.
- The displayed owner becomes <b>FindOS</b>.

## 24. Moderation and Reporting
- Authenticated users can report content. Guests cannot.
- Report reasons: inappropriate content, incorrect information, copyright/ownership issue, spam, or other with a custom message.
- Admins can review/dismiss reports, remove or temporarily hide videos, warn/suspend teachers and delete teacher accounts.
- A suspended teacher's videos and courses are temporarily hidden from search and viewing.
- Administrative moderation actions should be auditable.

## 25. YouTube Content Management
- Admins can add a YouTube URL and FindOS metadata, edit FindOS title/description/tags, remove the item, and re-index/reprocess its transcript.
- If an indexed YouTube video becomes unavailable, it should be removed from normal search/watch access and marked unavailable internally rather than presented as a working video.

## 26. Success Metrics
- <b>Search latency:</b> target no more than 1 second for the defined production percentile. The implementation phase should finalize p95/p99 targets rather than relying on average latency.
- <b>First-result success:</b> percentage of evaluated searches where the first result provides the requested information, even if the explanation is partial, and is not incorrect or unrelated.
- <b>Find success:</b> percentage of student searches where the student successfully finds the desired information. This should be measured using observable behavior plus a labeled evaluation set rather than clicks alone.
- <b>Timestamp accuracy:</b> target at least 95% of evaluated timestamps within ±5 seconds of human-labeled ground truth.
- <b>Processing success:</b> target at least 99% of valid uploads successfully becoming searchable. Deliberately rejected invalid uploads should not be counted as processing failures.
- Search relevance should later be evaluated with a representative labeled query set and metrics such as Precision@K, Recall@K, MRR and NDCG.

## 27. Product Invariants
- 1. A failed reprocessing job must never replace a working searchable version.
- 2. Invalid uploads are rejected rather than silently repaired when required metadata/audio is missing.
- 3. Poor transcript quality may result in publication with a warning; complete transcription failure does not count as successful searchable processing.
- 4. Guest playback is limited to 30 seconds.
- 5. Search returns one result per video, with multiple matching timestamps inside the result.
- 6. Teacher authority alone cannot override content relevance.
- 7. Deleted content leaves active search/watch access but preserves the specifically defined historical records.
- 8. Teacher account deletion does not automatically delete the teacher's videos/courses.

## 28. V1 Non-Goals
- Paid subscriptions
- Course payments
- Mobile applications
- Live video
- Video editing
- Automatic course generation
- External video platforms other than YouTube
- Searching the entire public internet
- Subscription management as a V1 feature

## 29. V1 Completion Standard
- A feature is not considered complete merely because it works locally. Product completion requires implementation, tests, error handling, security considerations, observability, documented failure behavior, performance measurement and scalability review.
- This follows the project's engineering approach of progressing from requirements through design, implementation, testing, failure analysis and measurement. fileciteturn0file0L51-L54