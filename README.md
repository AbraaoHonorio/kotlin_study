# kotlin_study


# Kotlin Study — Hexagonal Use Case + Projection Architecture

## Overview

This project demonstrates a **clean, hexagonal architecture** implemented in **plain Kotlin/JVM**, focused on:

- Multiple identifier types (`Long`, `UUID`)
- One use case per **behavior** (no paired use cases)
- Multiple output projections (`User`, `Person`, etc.)
- Explicit, safe mapping without frameworks
- Correct handling of JVM type erasure and Kotlin variance

Core idea:

> **A use case represents behavior.  
> Projection (output type) is chosen at the boundary.**

---

## Goals

- Avoid paired use cases like `FindUserToPersonUseCase`
- Keep use cases behavior-focused
- Make identifiers explicit and type-safe
- Allow multiple output representations from the same use case
- Stay framework-free (no Spring, no reflection scanning)
- Respect Kotlin/JVM type system constraints

---
