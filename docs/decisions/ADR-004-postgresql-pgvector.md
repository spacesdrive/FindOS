# ADR-004: PostgreSQL and pgvector

## Context
FindOS needs relational data, transactions, constraints, complex relationships, and semantic search capabilities.

## Options
- PostgreSQL + pgvector
- PostgreSQL + external vector database

## Decision
Use PostgreSQL as the primary database and pgvector for initial vector search.

## Why
This keeps the initial system simpler while supporting both relational and vector workloads.

## Tradeoffs
A single database may eventually become a bottleneck for search at large scale. That is a measurement-driven future decision, not a V1 assumption.

## Consequences
Transcript text remains authoritative in PostgreSQL. Embeddings are derived data and can be regenerated.
