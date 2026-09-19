# ADR-005: Ownership and Lifecycle

## Decision
- Video owner = uploader.
- Course owner = creator.
- Additional course teachers are members, not owners.
- Teacher account deletion leaves videos/courses and transfers ownership to System Admin/FindOS.
- Course deletion removes course relationships but not videos.
- Video deletion removes active searchable content, bookmarks, saved timestamps, and ratings; playlists, watch history, search history, and teacher analytics remain.

## Consequence
Ownership, membership, and historical references must be modeled separately.
