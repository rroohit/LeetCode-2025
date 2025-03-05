package c_march

/**
 *  Problem 5. Count Total Number of Colored Cells.
 *
 *  ## Intuition -
 *
 *  ## Approach -
 *
 *  ## Complexity:
 *       - Time complexity: O()
 *
 *       - Space complexity: O()
 *
 * ## Code -
 */
fun main() {

    val testCases = listOf(
        1, // 1  - 0
        2, // 5  - 4
        3, // 13 - 8
        4, // 25 - 12
        5, // 41
        20 // 761
    )

    testCases.forEach { n : Int ->
        println("Result ==> ${coloredCells(n)}")
    }

}

// TC - O(1) : SC - O(1)
fun coloredCells(n: Int): Long {
    return 1L + n * (n - 1L) * 2L
}

// TC - O(n) : SC - O(1)
fun coloredCells2(n: Int): Long {
    var total = 1L
    for (i in 0..<n) total += (4 * i)
    return total
}

// TC - O(n) : SC - O(1)
fun coloredCells1(n: Int): Long {
    var prev = 0L
    var total = 1L
    for (i in 1..n) {
        total += prev
        prev += 4
    }
    return total
}