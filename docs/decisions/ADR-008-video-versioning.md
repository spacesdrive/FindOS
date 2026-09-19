# ADR-008: Explicit Video Versioning

## Context
Teachers can replace video content and metadata while the previous version remains searchable until the replacement is ready.

## Decision
Represent each concrete content version explicitly. Only one version is current at a time.

## Why
This supports atomic replacement and failure-safe rollback to the previously working version.

## Consequences
Transcript, processing state, and search representations are tied to a version rather than only to the logical Video.
