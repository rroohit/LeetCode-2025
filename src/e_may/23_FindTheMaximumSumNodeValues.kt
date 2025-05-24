package e_may

/**
 *  Problem 23. Find the Maximum Sum of Node Values.
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
        Triple(
            intArrayOf(1, 2, 1),
            3,
            arrayOf(intArrayOf(0, 1), intArrayOf(0, 2))
        )
    )

    testCases.forEach { (nums, k, edges) ->
        println("Result ==> ${maximumValueSum(nums, k, edges)}")
    }

}

fun maximumValueSum(nums: IntArray, k: Int, edges: Array<IntArray>): Long {
    var maxRes = 0L
    nums.forEach {
        maxRes += it
    }

    val xOrValues = LongArray(nums.size)
    for (i in nums.indices) {
        xOrValues[i] = (nums[i].toLong() xor k.toLong()) - nums[i].toLong()
    }
    xOrValues.sortDescending()

    for (i in xOrValues.indices step 2) {
        if (i >= xOrValues.size - 1) break
        val twoSum = xOrValues[i] + xOrValues[i + 1]
        if (twoSum <= 0) break
        maxRes += twoSum
    }

    return maxRes
}