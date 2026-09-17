# FindOS Learning Log

## Milestone 0: Product Definition

### What I built
Defined the V1 product requirements for FindOS, including users, content sources, search behavior, timestamp behavior, roles, moderation, authentication scope, video lifecycle, analytics, success metrics and non-goals.

### What I learned
- Product requirements should be explicit before architecture.
- Search results need a precise result contract, not just “show relevant videos.”
- Timestamp accuracy is a measurable product property.
- Engagement signals must be distinguished from relevance signals.
- Failed processing should not destroy a working searchable version.
- Scope boundaries are necessary to prevent V1 from becoming multiple products.

### Major decisions
- Students are the primary user.
- Teachers/professors are content providers.
- YouTube is the only external source in V1.
- One result is returned per video, with multiple matching timestamps.
- Guest playback is limited to 30 seconds.
- Maximum upload size is 1 GB with no duration limit.
- Poor transcripts can be published with a warning; complete transcription failure is not successful searchable processing.
- Reprocessing uses old-version preservation until successful replacement.
- Paid subscriptions and payments are V2/non-goals for V1.

### Open implementation questions
Exact search relevance thresholds, ranking formula, authentication policy details, duplicate-detection method, transcript-quality evaluation, moderation duration rules, and infrastructure choices are intentionally deferred to later engineering milestones.