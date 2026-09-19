# FindOS Data Flow

## Search
Query → query understanding → structured constraints + semantic intent → lexical/vector retrieval → candidate transcript segments → segment ranking → group by video → video ranking → video + timestamps.

## Upload
Validate → store original in S3 → create processing attempt → asynchronous processing → transcription → segmentation → embeddings → searchable representation → activate successful version.

## Reprocessing
Create new version → process independently → keep old active version → activate new version only after success.

## Deletion
Remove active searchable content and selected personal relationships while retaining required history and analytics.
