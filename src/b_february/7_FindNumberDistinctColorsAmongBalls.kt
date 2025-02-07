package b_february

/**
 *  Problem 7. Find the Number of Distinct Colors Among the Balls.
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
            4,
            arrayOf(intArrayOf(1, 4), intArrayOf(2, 5), intArrayOf(1, 3), intArrayOf(3, 4))
        ),
        Pair(
            4,
            arrayOf(intArrayOf(0, 1), intArrayOf(1, 2), intArrayOf(2, 2), intArrayOf(3, 4), intArrayOf(4, 5))
        )
    )

    testCases.forEach { test ->
        println("Result ==> ${queryResults(test.first, test.second).toList()}")
    }

}


fun queryResults(limit: Int, queries: Array<IntArray>): IntArray {
    // Ball -->  colour
    val ballToCol = HashMap<Int, Int>()

    // colour --> Ball
    val colToBal = HashMap<Int, Int>()

    val result = IntArrayCustom(queries.size)
    for ((ball, col) in queries) {
        if (ballToCol.containsKey(ball)) {
            val prevColor = ballToCol[ball]!!
            colToBal[prevColor] = colToBal[prevColor]!! - 1
            if (colToBal[prevColor] == 0) {
                colToBal.remove(prevColor)
            }
        }

        ballToCol[ball] = col
        colToBal[col] = colToBal.getOrDefault(col, 0) + 1
        result.add(colToBal.size)
    }

    return result.getArray()
}

private class IntArrayCustom(val size: Int) {
    val arr = IntArray(size)
    var i = 0
    fun add(num: Int) {
        if (i >= size) throw IndexOutOfBoundsException()
        arr[i++] = num
    }

    fun get(index: Int): Int {
        if (index >= size) throw IndexOutOfBoundsException()
        return arr[index]
    }

    fun getArray() = arr
}