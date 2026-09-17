# ADR-003: Hybrid Segment-Level Search

## Context
FindOS must understand a student's concept and take the student to a useful timestamp.

## Problem
Search must combine semantic meaning, exact terminology, metadata and timestamps.

## Options Considered
1. Lexical/full-text only
2. Semantic/vector only
3. Hybrid lexical + semantic segment-level retrieval

## Decision
Use hybrid retrieval over timestamped transcript segments. Combine semantic similarity, lexical/text matching and metadata signals. Apply structured constraints through structured data.

## Retrieval Flow

```text
Query -> Query understanding -> Semantic + lexical retrieval
      -> Rank segments -> Group by video -> Rank videos
      -> Return one result per video with timestamps
```

## Why
Semantic retrieval captures conceptual similarity, lexical matching captures exact terminology, and segment-level units preserve timestamp precision.

## Tradeoffs
More complexity than a single retrieval method. Requires relevance evaluation, ranking calibration and search dependency management.

## Failure Policy
If semantic/vector search is unavailable in V1, return a search error.

## Measurement
Precision@K, Recall@K, MRR, NDCG, timestamp accuracy and latency.

## Reconsideration
Revisit if relevance, latency, cost or operational complexity fails V1 targets.
