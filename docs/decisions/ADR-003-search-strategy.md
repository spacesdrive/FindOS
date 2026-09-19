# ADR-003: Segment-First Hybrid Search

## Context
FindOS must locate concepts inside long videos and jump to timestamps.

## Decision
Rank transcript segments first, group them by video, then rank videos.

## Signals
Semantic similarity, lexical matching, metadata, query-specific engagement, and content quality.

## Vector direction
Use PostgreSQL + pgvector initially rather than a separate vector database.

## Tradeoffs
More segments to index, but more precise timestamp retrieval.

## Measurement
Precision@K, Recall@K, MRR, NDCG, latency, and timestamp accuracy.

## Reconsideration
Introduce separate search/vector infrastructure only when measurements justify it.
