# FindOS Architecture: Search

## Product Contract
Search covers:
- Video titles
- Descriptions
- Tags
- Transcript text
- Course/playlist names
- Teacher names

V1 returns one result per video and may show multiple relevant timestamps.

## Hybrid Retrieval

```text
Query
  |
  v
Query understanding
  |
  +----------------------+
  |                      |
  v                      v
Semantic retrieval    Lexical retrieval
  |                      |
  +----------+-----------+
             |
             v
      Candidate segments
             |
             v
       Segment ranking
             |
             v
        Group by video
             |
             v
        Video ranking
```

## Segment Ranking Signals
- Semantic similarity
- Keyword/text matching
- Metadata signals such as title and tags

## Video Ranking Priorities
1. Relevance
2. Query-specific engagement
3. Content quality

Potential engagement signals: watch time, percentage watched, views, timestamp jumps, bookmarks, ratings, shares, follows and search-result clicks.

Teacher authority does not automatically override relevance.

## Structured Constraints
Query understanding may extract teacher, course, duration, rating, upload date and topic/category constraints. These are applied using structured data.

## Result Threshold
Reasonably related but imperfect content is shown as partial matches. Clearly unrelated content produces “No relevant results found.”

## Failure
If semantic/vector search is unavailable in V1, return a search error rather than silently falling back.

## Evaluation
Use a labeled query set and evaluate Precision@K, Recall@K, MRR, NDCG, timestamp accuracy and latency.
