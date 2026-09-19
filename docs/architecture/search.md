# Search Architecture

## Retrieval unit
Transcript Segment is the primary retrieval unit.

## Retrieval flow
1. Understand natural-language query intent.
2. Keep structured filters structured.
3. Retrieve matching transcript segments using lexical and/or semantic signals.
4. Rank segments.
5. Group by Video.
6. Use the strongest relevant segment to inform Video ranking.
7. Return one result per Video with multiple matching timestamps where appropriate.

## Ranking signals
Segment ranking can combine semantic similarity, lexical/text matching, and metadata. Video ranking considers relevance first, then query-specific engagement and content quality.

Correctness is a prerequisite for high-quality ranking. Global popularity must not dominate a clearly relevant result.

## Evaluation
Use a labeled query set and metrics such as Precision@K, Recall@K, MRR, NDCG, and latency. The guide describes a 100–500 query evaluation set as a useful scale for relevance work. fileciteturn0file0L556-L576
