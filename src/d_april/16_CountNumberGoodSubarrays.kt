package d_april


/**
 *  Problem 16. Count the Number of Good Subarrays.
 *
 *  ## Intuition -
 *
 *  ## Approach -
 *
 *  ## Complexity:
 *       - Time complexity: O(n)
 *
 *       - Space complexity: O(n)
 *
 * ## Code -
 */
fun main() {

    val testCases = listOf(
        Pair(
            intArrayOf(1, 1, 1, 1, 1), 10
        ),
        Pair(
            intArrayOf(3, 1, 4, 3, 2, 2, 4), 2
        )
    )

    testCases.forEach { test ->
        println("Result ==> ${countGood(test.first, test.second)}")
    }

}

fun countGood(nums: IntArray, k: Int): Long {
    val n = nums.size
    var same = 0
    var right = -1
    val cnt = HashMap<Int, Int>()
    var ans: Long = 0
    for (left in 0..<n) {
        while (same < k && right + 1 < n) {
            ++right
            same += cnt.getOrDefault(nums[right], 0)
            cnt[nums[right]] = cnt.getOrDefault(nums[right], 0) + 1
        }
        if (same >= k) {
            ans += (n - right).toLong()
        }
        cnt[nums[left]] = cnt[nums[left]]!! - 1
        same -= cnt[nums[left]]!!
    }
    return ans
}
