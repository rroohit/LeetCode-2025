package b_february

/**
 *  Problem 15. Find the Punishment Number of an Integer.
 *
 *  ## Intuition -
 *
 *  ## Approach -
 *
 *  ## Complexity:
 *       - Time complexity: O(n^2)
 *
 *       - Space complexity: O(n)
 *
 * ## Code -
 */
fun main() {

    val testCases = listOf(
        10,
        37
    )

    testCases.forEach { num ->
        println("Result ==> ${punishmentNumber(num)}")
    }

}

fun punishmentNumber(n: Int): Int {
    var punishmentNum = 0
    for (currentNum in 1..n) {
        val squareNum = currentNum * currentNum
        if (canPartition(squareNum, currentNum)) {
            punishmentNum += squareNum
        }
    }
    return punishmentNum
}

fun canPartition(num: Int, target: Int): Boolean {
    if (target < 0 || num < target) return false
    if (num == target) return true
    return (canPartition(num / 10, target - (num % 10)) ||
            canPartition(num / 100, target - (num % 100)) ||
            canPartition(num / 1000, target - (num % 1000)))
}

