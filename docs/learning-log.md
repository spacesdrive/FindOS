# FindOS Learning Log

## Milestone 2: Database Design

### What I learned
- PostgreSQL is both a relational system of record and, with pgvector, the initial semantic-search store.
- Candidate keys and primary keys are different concepts.
- Database constraints should enforce important invariants instead of trusting application code.
- A user with multiple roles needs a many-to-many relationship.
- Account status and teacher approval represent different lifecycle concepts.
- Video versioning allows safe replacement without destroying the currently working content.
- Transcript segments must belong to a specific video version.
- Raw analytics events preserve detail for later measurement and aggregation.

### Decisions made
- PostgreSQL + pgvector.
- UUID identifiers for externally visible entities.
- Case-insensitive unique email.
- Optional unique phone.
- No age/date-of-birth field without a concrete requirement.
- Multi-role users through `user_roles`.
- Explicit Video Versions.
- Segment-first search.
- Entity-specific deletion rules.
- Transactions for critical state transitions.

### Engineering principle
Prefer constraints and simple relational models first. Add infrastructure only when a measured requirement justifies it.

### Next milestone
Implement the database foundation and first migrations, beginning with users, roles, and user_roles.
