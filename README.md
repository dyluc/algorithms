## Algorithms

[![Maintainability Rating](https://sonarcloud.io/api/project_badges/measure?project=dyluc_algorithms&metric=sqale_rating)](https://sonarcloud.io/dashboard?id=dyluc_algorithms)
[![Reliability Rating](https://sonarcloud.io/api/project_badges/measure?project=dyluc_algorithms&metric=reliability_rating)](https://sonarcloud.io/dashboard?id=dyluc_algorithms)
[![Security Rating](https://sonarcloud.io/api/project_badges/measure?project=dyluc_algorithms&metric=security_rating)](https://sonarcloud.io/dashboard?id=dyluc_algorithms)

---
### Sorting Algorithms

#### Merge Sort

Comparison based, divide-and-conquer sorting algorithm.
1. Divide the unsorted list into n sublists, each containing one element (a list of one element is considered sorted).
2. Repeatedly merge sublists to produce new sorted sublists until there is only one sublist remaining. This will be the sorted list.


|            | Best          | Average       | Worst         | Worst Space Complexity |
|------------|---------------|---------------|---------------|------------------------|
| Merge Sort | `Ω(n log(n))` | `Θ(n log(n))` | `O(n log(n))` | `O(n)`                 |