# FindOS Video Processing

VIDEO → STORAGE → AUDIO → TRANSCRIPTION → TIMESTAMPED TRANSCRIPT → HYBRID SEGMENTATION → EMBEDDINGS → SEARCH REPRESENTATION.

Teachers do not manually create segments. Segmentation uses timestamps, sentence boundaries, and semantic coherence.

A segment conceptually contains video/version association, transcript text, start time, end time, and embedding.

Processing is asynchronous. One current state exists; processing attempts are retained. V1 requires manual retry after failure.

For replacement, the old active version remains searchable until the new version succeeds. A failed replacement does not affect the old active version.
