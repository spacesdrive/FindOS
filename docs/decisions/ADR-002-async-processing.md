# ADR-002: Process Videos Asynchronously

## Context
A 1 GB, multi-hour lecture can take substantial time to transcribe and index.

## Problem
Blocking an upload request until processing finishes creates poor user experience and unreliable long-running requests.

## Options Considered
1. Synchronous processing
2. Store and process asynchronously
3. Immediately split into many independent distributed services

## Decision
Store the video, create processing state, return status, and process in the background.

## Why
Upload acknowledgement stays fast and processing can be monitored and scaled independently.

## Tradeoffs
Requires job/state management and explicit failure handling. Searchability becomes eventually consistent with upload.

## Failure Policy
V1 marks failed processing as failed and requires a teacher-initiated retry. Existing searchable versions remain active during replacement processing.

## Measurement
Measure processing duration, queue delay, success rate, failure rate and retry rate.

## Reconsideration
Revisit if measured workload requires automatic retries or more independently scalable stages.
