package d_april

/**
 *  Problem 30. Find Numbers with Even Number of Digits.
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
        intArrayOf(12, 345, 2, 6, 7896),
        intArrayOf(555, 901, 482, 1771)
    )

    testCases.forEach { nums ->
        println("Result ==> ${findNumbers(nums)}")
    }

}

fun findNumbers(nums: IntArray): Int {
    var count = 0
    for (num in nums) {
        var n = num
        var length = 0
        while (n > 0) {
            n /= 10
            length++
        }
        if (length % 2 == 0) count++
    }
    return count
}