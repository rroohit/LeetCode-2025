package g_july

/**
 *  Problem 5. Find Lucky Integer in an Array.
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
        intArrayOf(2, 2, 3, 4),
        intArrayOf(1, 2, 2, 3, 3, 3),
        intArrayOf(2, 2, 2, 3, 3)
    )

    testCases.forEach { arr->
        println("Result ==> ${findLucky(arr)}")
    }

}

fun findLucky(arr: IntArray): Int {
    val freq = HashMap<Int, Int>()
    for (num in arr) {
        freq[num] = freq.getOrDefault(num, 0) + 1
    }

    var ans = -1
    for ((key, num) in freq) {
        if (key == num && num > ans) ans = num
    }
    return ans
}