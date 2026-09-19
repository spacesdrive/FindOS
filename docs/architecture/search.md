# FindOS Search Architecture

## Primary unit
Transcript Segment.

## Flow
Query → query understanding → structured constraints + semantic intent → lexical + vector retrieval → candidate segments → segment ranking → group by video → video ranking → video + timestamps.

## Segment signals
- semantic similarity
- keyword/text matching
- metadata such as title/tags

## Video signals
- relevance
- query-specific engagement
- content quality

Correctness is a prerequisite for high-quality ranking.

## Storage direction
PostgreSQL stores authoritative transcript text and relational metadata. pgvector stores segment embeddings. Segment-level search is primary. Video-level embeddings are not primary retrieval.

A separate vector database is not required initially. Reconsider only after measured scale/latency/operational requirements justify it.

## Evaluation
Precision@K, Recall@K, MRR, NDCG, latency, and timestamp accuracy.
