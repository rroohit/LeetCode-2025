package i_september

import kotlin.math.max

/**
 *  Problem 22. Count Elements With Maximum Frequency.
 *
 *  ## Intuition -
 *  We want to find the frequency of each element in the array. The elements that
 *  occur the most number of times (maximum frequency) are important. The answer
 *  is the total count of all occurrences of those most frequent elements.
 *
 *  ## Approach -
 *  1. Traverse the array once to build a frequency map for all elements.
 *  2. Keep track of the maximum frequency while building the map.
 *  3. Traverse the array again, and for each element whose frequency equals the
 *     maximum frequency, add its frequency to the final result.
 *     (To avoid double-counting, mark it as visited by resetting its frequency to 0.)
 *  4. Return the accumulated result.
 *
 *  ## Complexity:
 *       - Time complexity: O(n)
 *              (one pass to build frequencies, one pass to count elements with max frequency)
 *       - Space complexity: O(n)
 *              (in the worst case, when all elements are distinct, we store all in the map)
 *
 *  ## Code -
 */

fun main() {

    val testCases = listOf(
        intArrayOf(1, 2, 2, 3, 1, 4),
        intArrayOf(1, 2, 3, 4, 5)
    )

    testCases.forEach { nums ->
        println("Result ==> ${maxFrequencyElements(nums)}")
    }

}

fun maxFrequencyElements(nums: IntArray): Int {
    val freq = hashMapOf<Int, Int>()
    var max = 0
    for (num in nums) {
        freq[num] = freq.getOrDefault(num, 0) + 1
        max = max(max, freq[num]!!)
    }

    var count = 0
    for (num in nums) {
        if (freq[num]!! >= max) count += freq[num]!!
        freq[num] = 0
    }

    return count
}
