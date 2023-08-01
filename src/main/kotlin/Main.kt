fun main(args: Array<String>) {
    val solution = Solution()
    val nums = intArrayOf(2, -1, 1, 2, 2)
    val result = solution.circularArrayLoop(nums)
    println(result) // Output: true
}
class Solution {
    fun circularArrayLoop(nums: IntArray): Boolean {
        val n = nums.size

        // Check each index as a starting point for the loop
        for (i in 0 until n) {
            var slow = i
            var fast = getNext(nums, i)

            // Check for invalid loops
            while (nums[slow] * nums[fast] > 0 && nums[slow] * nums[getNext(nums, fast)] > 0) {
                if (slow == fast) {
                    // Check for loops with one element
                    if (slow == getNext(nums, slow)) {
                        break
                    }
                    return true
                }

                slow = getNext(nums, slow)
                fast = getNext(nums, getNext(nums, fast))
            }

            // Mark the indices as visited
            var j = i
            while (nums[j] * nums[getNext(nums, j)] > 0) {
                val temp = j
                j = getNext(nums, j)
                nums[temp] = 0
            }
        }

        return false
    }

    // Get the next index in the circular array
    private fun getNext(nums: IntArray, i: Int): Int {
        val n = nums.size
        return ((i + nums[i]) % n + n) % n
    }
}