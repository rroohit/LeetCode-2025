package k_november

import java.util.PriorityQueue

/**
 * Problem 4. Find X-Sum of All K-Long Subarrays I.
 *
 * ## Intuition -
 *  For each window of size `k`, we need to calculate the "X-sum" — the sum of the top `x` elements
 *      (based on frequency, and by value if tied). We maintain a frequency map as we slide the window
 *      and use a priority queue to pick the top `x` frequent numbers efficiently.
 *
 * ## Approach -
 *      - Use a sliding window of size `k` and a frequency map to track counts of elements.
 *      - For each window, build a priority queue (min-heap) ordered by frequency, then by number.
 *      - Keep only the top `x` elements in the heap, and compute their contribution as `num * freq`.
 *      - Move the window by removing the leftmost element and updating its frequency.
 *
 * ## Complexity:
 *      - Time complexity: O(n * log x)
 *          (For each of the n windows, inserting into the heap of size x costs log x)
 *
 *      - Space complexity: O(k + x)
 *          (Frequency map stores up to k elements, heap stores up to x elements)
 *
 * ## Code -
 */
fun main() {

    val testCases = listOf(
        Triple(intArrayOf(1, 1, 2, 2, 3, 4, 2, 3), 6, 2),
        Triple(intArrayOf(3, 8, 7, 8, 7, 5), 2, 2),
        Triple(intArrayOf(1, 1, 1, 1, 1, 1, 1), 2, 2),
        Triple(intArrayOf(1, 1, 1, 1, 1, 1, 1), 1, 2),
    )

    testCases.forEach { (nums, k, x) ->
        println("Result ==> ${findXSum(nums, k, x).toList()}")
    }

}

fun findXSum(nums: IntArray, k: Int, x: Int): IntArray {
    val n = nums.size
    val ans = IntArray(n - k + 1) { 0 }
    val freq = hashMapOf<Int, Int>()
    var l = 0
    for (r in nums.indices) {
        freq[nums[r]] = freq.getOrDefault(nums[r], 0) + 1
        if (r - l + 1 == k) {
            ans[l] = getXSum(freq, x)
            val leftKey = nums[l]
            freq[leftKey] = freq.getOrDefault(leftKey, 0) - 1
            if (freq[nums[l]]!! <= 0) freq.remove(leftKey)
            l++
        }
    }
    return ans
}

private fun getXSum(freq: HashMap<Int, Int>, x: Int): Int {
    val pq = PriorityQueue(
        compareByDescending<Map.Entry<Int, Int>> { it.value }
            .thenBy { it.key }
    )
    pq.addAll(freq.entries)

    var sum = 0
    for (i in 1..x) {
        if (pq.isEmpty()) break
        val (num, cnt) = pq.poll()
        sum += num * cnt
    }
    return sum
}

















