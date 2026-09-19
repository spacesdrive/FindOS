# ADR-004: PostgreSQL + pgvector

## Context
FindOS needs relational data and semantic search over transcript segments.

## Options
1. PostgreSQL only
2. PostgreSQL + pgvector
3. PostgreSQL + separate vector database such as Pinecone

## Decision
Use PostgreSQL as the primary relational database and pgvector for transcript-segment embeddings.

## Why
This keeps relational data, authoritative transcript text, timestamps, and embeddings in one initial data platform while avoiding premature infrastructure.

## Tradeoffs
Transactional and vector workloads share infrastructure. Very large workloads may require separation.

## Measurement
Track vector/lexical/hybrid latency, index size, memory, write performance, CPU/load.

## Reconsideration
Revisit if measured latency, scale, availability, or operational needs exceed the approach.
