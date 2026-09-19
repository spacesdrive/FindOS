# FindOS Database Design Decisions

1. Removing a video from a course keeps the video and removes only course membership.
2. Deleting a course keeps its videos and removes course relationships.
3. Student account deletion removes personal records where appropriate; required historical/analytics data follows retention rules.
4. A video may appear in multiple personal playlists.
5. Watch history retains viewing events/sessions; summaries can be derived.
6. Multiple saved timestamps per video are allowed.
7. A student can follow a teacher only once.
8. A video has one current processing state and retained processing-attempt history.
9. Video versions explicitly support atomic replacement.
10. Old transcript segments are retired when a new version becomes active.
11. YouTube uses the same Video entity with source metadata.
12. Search history is stored, including no-result searches.
13. Analytics use raw events plus derived aggregates where useful.
14. Audit records contain actor, action, target, timestamp, and relevant metadata.
15. Students do not enroll in courses in V1.
16. Teacher approval status is stored explicitly.
17. Users may have multiple roles.
18. UUIDs are preferred for externally visible identifiers.
19. Important mutable records have created_at and updated_at.
20. Deletion is entity-specific, not universally hard or soft delete.
21. Multi-record state changes use transactions where atomicity matters.
22. Indexes prioritize ownership, relationships, history, uniqueness, and segment/version lookups.
23. Search is expected to be the main scaling pressure.
