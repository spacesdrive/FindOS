# FindOS Architecture: Data Flow

## Student Search

```text
Query
  |
  v
Query understanding
  |
  +--------------------+
  |                    |
  v                    v
Semantic retrieval   Lexical retrieval
  |                    |
  +---------+----------+
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
            |
            v
 Video + timestamps
            |
            v
         Student
```

Structured constraints such as teacher, course, duration, rating and upload date are handled using structured data.

## Video Upload

```text
Teacher
  |
  v
Validation
  |
  +--> invalid --> exact error
  |
  v
Amazon S3
  |
  v
Processing state
  |
  v
Return status
  |
  v
Background processing
```

## Processing

```text
S3 video
   |
   v
Processing
   |
   v
Audio
   |
   v
Transcript
   |
   v
Timestamped segments
   |
   v
Search representations
   |
   v
Search index
   |
   v
Searchable
```

## Replacement

```text
Old searchable version
          |
       reprocess
       /       \
   success    failure
      |          |
      v          v
 replace      keep old
```
