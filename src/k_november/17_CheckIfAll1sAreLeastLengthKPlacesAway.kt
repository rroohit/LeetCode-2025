package k_november

/**
 *  Problem 17. Check If All 1's Are at Least Length K Places Away.
 *
 *  ## Intuition -
 *      We need to ensure every pair of 1's in the array has at least `k` zeros between them.
 *      Track the distance from the previous 1 and verify it never becomes less than `k`.
 *
 *  ## Approach -
 *      Iterate through the array while maintaining a counter `dist` representing the number of
 *          positions since the last seen 1. Whenever a 1 is found, check if the previous distance
 *          is valid; if not, return false. Reset distance on seeing a 1, otherwise increment it.
 *
 *  ## Complexity:
 *       - Time complexity: O(n)
 *       - Space complexity: O(1)
 *
 *  ## Code -
 */
fun main() {

    val testCases = listOf(
        Pair(
            intArrayOf(1, 0, 0, 0, 1, 0, 0, 1), 2
        ),
        Pair(
            intArrayOf(1, 0, 0, 1, 0, 1), 2
        )
    )

    testCases.forEach { (nums, k) ->
        println("Result ==> ${kLengthApart(nums, k)}")
    }

}

private fun kLengthApart(nums: IntArray, k: Int): Boolean {
    var dist = k
    for (num in nums) {
        if (num == 1) {
            if (dist < k) return false
            dist = 0
        } else {
            dist++
        }
    }
    return true
}