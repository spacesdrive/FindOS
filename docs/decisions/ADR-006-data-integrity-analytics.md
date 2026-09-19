# ADR-006: Data Integrity, History, and Analytics

## Decision
Enforce critical invariants with database constraints where practical:
- video requires owner
- course requires creator
- rating is 1–5
- one current student/video rating
- one current student/course rating
- one student/teacher follow

Store history/events separately from current state where useful. Retain processing attempts, search history, watch events, and audit events. Analytics use raw events plus derived aggregates.

Users may have multiple roles. No student enrollment in V1.

## Consequence
The schema distinguishes current state, relationships, and event/history data.
