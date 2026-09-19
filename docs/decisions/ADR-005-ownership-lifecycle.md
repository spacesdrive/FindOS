# ADR-005: Ownership and Lifecycle

## Context
Videos and courses have different ownership and relationship lifecycles.

## Decision
A Video has one owner. A Course has one owner and can have multiple teacher members. A Video can belong to multiple Courses.

Course deletion removes relationships but does not delete Videos.

Teacher deletion removes the teacher profile while preserving Videos/Courses and transferring ownership to FindOS/System Admin where required.

## Why
This preserves content continuity and avoids destructive cascading behavior.

## Reconsideration
Change only when product/legal retention requirements demand different behavior.
