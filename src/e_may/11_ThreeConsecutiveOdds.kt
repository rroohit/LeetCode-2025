package e_may

/**
 *  Problem 11. Three Consecutive Odds.
 *
 *  ## Intuition -
 *
 *  ## Approach -
 *
 *  ## Complexity:
 *       - Time complexity: O(n)
 *
 *       - Space complexity: O(1)
 *
 * ## Code -
 */
fun main() {

    val testCases = listOf(
        intArrayOf(2, 6, 4, 1),
        intArrayOf(1, 2, 34, 3, 4, 5, 7, 23, 12)
    )

    testCases.forEach { arr ->
        println("Result ==> ${threeConsecutiveOdds(arr)}")
    }

}

fun threeConsecutiveOdds(arr: IntArray): Boolean {
    var seqCnt = 0
    for (num in arr) {
        seqCnt = if (num and 1 == 1) {
            if (seqCnt == 2) return true
            seqCnt + 1
        } else 0
    }
    return false
}

// TC - O(n) :: SC - O(1)
fun threeConsecutiveOdds1(arr: IntArray): Boolean {
    for (i in 1..<arr.size - 1) {
        if ((arr[i - 1] and 1) + (arr[i] and 1) + (arr[i + 1] and 1) == 3) return true
    }

    return false
}