package j_october

/**
 *  Problem 3. Trapping Rain Water II.
 *
 *  ## Intuition -
 *
 *  ## Approach -
 *
 *  ## Complexity:
 *       - Time complexity: O()
 *       - Space complexity: O()
 *
 * ## Code -
 */
fun main() {

    val testCases = listOf(
        arrayOf(
            intArrayOf(1, 4, 3, 1, 3, 2),
            intArrayOf(3, 2, 1, 3, 2, 4),
            intArrayOf(2, 3, 3, 2, 3, 1)
        )
    )

    testCases.forEach { heightMap ->
        println("Result ==> ${trapRainWater(heightMap)}")
    }

}

fun trapRainWater(heightMap: Array<IntArray>): Int {

    return 0
}















