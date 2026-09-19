# ADR-006: Data Integrity and Analytics

## Context
FindOS needs strong relational integrity and enough event data to measure search and product behavior.

## Decision
Use database constraints for uniqueness and relationships, transactions for critical state transitions, raw analytics events for behavioral data, and durable audit logs for administrative actions.

## Why
Constraints prevent invalid states at the database boundary. Raw events preserve detail for later aggregate definitions.

## Tradeoffs
Event storage grows over time and requires retention/aggregation strategy.

## Measurement
Monitor event volume, query performance, storage growth, and aggregate usefulness.
