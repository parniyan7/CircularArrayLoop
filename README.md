# Circular Array Loop

This is a solution for the Circular Array Loop problem implemented in Kotlin. The problem statement is as follows:

You are given an array of integers `nums`. There is a loop in `nums` if you can start from some index `i` and follow the sequence of indices formed by `nums[i]`, `nums[nums[i]]`, `nums[nums[nums[i]]]`, ... until you return to the starting index `i`.

If there is a loop, return `true`. Otherwise, return `false`.

A loop is defined as a sequence of indices where:

- The sequence is non-empty.
- For every `i` in the sequence, `nums[i]` is not `0`.
- The sequence is circular, meaning that the last index `nums[nums.length - 1]` is equal to the first index `0`.
- The sequence is not a "single-element" loop, which occurs if the sequence consists of one element only and `nums[nums[0]]` is equal to `0`.

## Solution

The solution uses a two-pointer approach to check for a loop starting from each index in the array. We iterate through each index in the array and for each index, we create two pointers `slow` and `fast` that point to the current index and the next index in the sequence, respectively. We then traverse the sequence by moving the `slow` pointer one step at a time and the `fast` pointer two steps at a time until we either find a loop or reach an invalid index.

We check for invalid loops by checking if the direction of the sequence changes or if the sequence contains only one element. If we find a loop, we mark all the indices in the loop as visited by setting their values to `0`.

## Usage

To use this solution, create an instance of the `Solution` class and call the `circularArrayLoop` method, passing in the `nums` array as a parameter.

```kotlin
val solution = Solution()
val nums = intArrayOf(2, -1, 1, 2, 2)
val result = solution.circularArrayLoop(nums)
println(result) // Output: true
```

In this example, the `nums` array contains a loop starting from index `0` and following the sequence `2 -> 1 -> 2`, which returns to the starting index. Therefore, the output is `true`.
