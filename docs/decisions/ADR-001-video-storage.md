# ADR-001: Store Video Files in Amazon S3

## Context
FindOS accepts videos up to 1 GB and needs durable storage for originals and processing artifacts.

## Problem
Large binaries should be separated from relational application records.

## Options Considered
1. Database BLOB storage
2. Local filesystem
3. Amazon S3

## Decision
Store original video files and suitable processing artifacts in Amazon S3. Store object references/keys and metadata in the application database.

## Why
This separates large object storage from application data and supports independent processing and future growth.

## Tradeoffs
Adds object-storage lifecycle, access-control and deletion concerns.

## Consequences
The database must maintain the logical relationship between a video and its S3 objects. Buckets must not be treated as unrestricted public storage.

## Measurement
Later measure storage cost, upload throughput, processing access latency and storage utilization.

## Reconsideration
Revisit if cost, compliance, workload or access requirements make S3 unsuitable.
