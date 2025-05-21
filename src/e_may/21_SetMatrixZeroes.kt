package e_may

/**
 *  Problem 21. Set Matrix Zeroes.
 *
 *  ## Intuition -
 *
 *  ## Approach -
 *
 *  ## Complexity:
 *       - Time complexity: O(n * m)
 *
 *       - Space complexity: O(n + m)
 *
 * ## Code -
 */
fun main() {

    val testCases = listOf(
        arrayOf(
            intArrayOf(1, 1, 1),
            intArrayOf(1, 0, 1),
            intArrayOf(1, 1, 1)
        ),
        arrayOf(
            intArrayOf(0, 1, 2, 0),
            intArrayOf(3, 4, 5, 2),
            intArrayOf(1, 3, 1, 5)
        )
    )

    testCases.forEach { matrix ->
        setZeroes(matrix)
        for (mat in matrix) {
            println(mat.toList())
        }
        println()
    }

}

fun setZeroes(matrix: Array<IntArray>): Unit {
    val row = matrix.size
    val col = matrix[0].size

    val rowZero = BooleanArray(row)
    val colZero = BooleanArray(col)

    for (r in 0..<row) {
        for (c in 0..<col) {
            if (matrix[r][c] == 0) {
                rowZero[r] = true
                colZero[c] = true
            }
        }
    }

    for (r in 0..<row) {
        for (c in 0..<col) {
            if (rowZero[r] || colZero[c]) matrix[r][c] = 0
        }
    }
}



