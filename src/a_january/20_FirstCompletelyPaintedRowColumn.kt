package a_january

/**
 *  Problem 20. First Completely Painted Row or Column.
 *
 *  ## Intuition -
 *
 *  ## Approach -
 *
 *  ## Complexity:
 *       - Time complexity: O(m * n)
 *
 *       - Space complexity: O(m + n)
 *
 * ## Code -
 */
fun main() {

    val testCases = listOf(
        Pair(
            intArrayOf(1, 3, 4, 2),
            arrayOf(intArrayOf(1, 4), intArrayOf(2, 3))
        ),
        Pair(
            intArrayOf(2, 8, 7, 4, 1, 3, 5, 6, 9),
            arrayOf(
                intArrayOf(3, 2, 5),
                intArrayOf(1, 4, 6),
                intArrayOf(8, 7, 9)
            )
        ),
        Pair(
            intArrayOf(1, 4, 5, 2, 6, 3),
            arrayOf(
                intArrayOf(4, 3, 5),
                intArrayOf(1, 2, 6)
            ) // 1
        )
    )

    testCases.forEach { test ->
        println("Result ==> ${firstCompleteIndex(test.first, test.second)}")
    }

}

fun firstCompleteIndex(arr: IntArray, mat: Array<IntArray>): Int {
    val map = HashMap<Int, Pair<Int, Int>>() //
    for (row in mat.indices) {
        for (col in mat[0].indices) {
            map[mat[row][col]] = Pair(row, col)
        }
    }

    val m = mat.size // row size
    val n = mat[0].size // column size
    val rowCount = IntArray(m)
    val colCount = IntArray(n)

    for (i in arr.indices) {
        val (r, c) = map[arr[i]]!!
        rowCount[r]++
        if (rowCount[r] == n) return i

        colCount[c]++
        if (colCount[c] == m) return i
    }

    return 0
}