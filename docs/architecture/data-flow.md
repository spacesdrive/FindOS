# Data Flow

## Upload
Teacher upload → object storage → Video/Video Version metadata → asynchronous processing → transcript → timestamped segments → embeddings/search representation → indexed/searchable.

## Search
User query → natural-language intent understanding → structured filters → lexical/semantic retrieval over transcript segments → segment ranking → group by Video → video ranking → multiple timestamps returned.

## Playback
Search result → video + timestamp → player starts slightly before the matching segment → transcript highlights the matching segment.

## Replacement
New Video Version → process independently → if successful, transaction switches current version → old version becomes retired. If failed, current version remains active.
