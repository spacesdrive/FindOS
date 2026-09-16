# FindOS V1 Success Metrics

## 1. Search Latency
- Primary metric: end-to-end search response latency.
- Initial product target: no more than 1 second at the agreed production percentile.
- Recommended engineering reporting: p50, p95 and p99 latency.
- Measure separately for cold/warm cache if relevant and include query complexity where useful.

## 2. First-Result Success
- Definition: first result provides the requested information, even if the explanation is partial, and is not incorrect or unrelated.
- Metric: First Result Success Rate = successful first-result evaluations / total evaluated queries.
- Use a labeled representative query set to avoid confusing clicks with correctness.

## 3. Find Success
- Definition: percentage of student searches where the student successfully finds the desired information.
- Behavioral signals may include result interaction, useful timestamp selection and subsequent watch behavior, but behavioral proxies should be validated against human judgments.

## 4. Timestamp Accuracy
- Definition: difference between the surfaced explanation point and human-labeled ground truth.
- Target: at least 95% of evaluated timestamps within ±5 seconds.
- Important distinction: playback may intentionally begin slightly before the matching point. The accuracy metric should evaluate the identified explanation timestamp, not penalize the intentional context lead-in.

## 5. Processing Success
- Definition: percentage of valid video uploads that successfully become searchable.
- Initial target: at least 99% of valid uploads.
- Invalid uploads rejected during validation are excluded from the processing-success denominator.

## 6. Search Relevance
- Build a representative labeled query set during the search milestone.
- Evaluate Precision@K, Recall@K, MRR and NDCG, alongside latency.
- Track relevance by query type, including title-oriented queries, specific concept queries and queries with multiple matching locations.

## 7. Operational Metrics to Add Later
- Processing duration by stage, retry count, failed jobs, duplicate detections, transcript quality distribution, search error rate and moderation response time should be introduced when their corresponding systems are implemented.
- These are engineering/operational metrics rather than final product-success targets and should not be treated as established V1 targets until measured.