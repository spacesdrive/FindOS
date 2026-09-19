# ADR-003: Segment-First Search

## Context
Users want the concept and timestamp where it is explained.

## Decision
Retrieve and rank transcript segments first, then group results by Video and return matching timestamps.

## Why
The segment is the smallest useful search unit and maps directly to the timestamp-jump experience.

## Tradeoffs
Requires careful segmenting and grouping/ranking logic.

## Measurement
Evaluate relevance with labeled queries and Precision@K, Recall@K, MRR, NDCG, plus latency.
