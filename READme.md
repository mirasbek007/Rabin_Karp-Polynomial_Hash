# Rabin–Karp Using Polynomial Rolling Hash

## Overview
The Rabin–Karp algorithm efficiently searches for a pattern within a text by comparing hash values rather than characters directly. It uses a polynomial rolling hash to compute substring hashes in O(1) time.

## Implementation Details
- **Base:** 256 (number of ASCII characters)
- **Modulus:** 1,000,000,007 (large prime to reduce collisions)
- Hashes are updated efficiently as the pattern slides through the text.

## Testing Results
| Case | Text Length | Pattern | Matches | Execution Time |
|------|--------------|---------|----------|----------------|
| Short | 6 | Goal    | [1,3] | ~0.1 ms |
| Medium | 43 | Messi   | [0,31] | ~0.12 ms |
| Long | 30000 | bca     | [] | ~1.5 ms |

## Complexity Analysis
- **Average Time:** O(n + m)
- **Worst Time:** O(nm) (due to collisions)
- **Space Complexity:** O(1)

## Conclusion
Rabin–Karp with polynomial rolling hash offers efficient substring search with minimal space use and strong scalability across varying text lengths.
