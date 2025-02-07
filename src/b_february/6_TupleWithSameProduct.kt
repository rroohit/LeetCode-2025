package b_february


/**
 *  Problem 6. Tuple with Same Product.
 *
 *  ## Intuition -
 *
 *  ## Approach -
 *
 *  ## Complexity:
 *       - Time complexity: O(n^2)
 *
 *       - Space complexity: O(n^2)
 *
 * ## Code -
 */
fun main() {

    val testCases = listOf(
        intArrayOf(2, 3, 4, 6),
        intArrayOf(1, 2, 4, 5, 10)
    )

    testCases.forEach { nums ->
        println("Result ==> ${tupleSameProduct(nums)}")
    }

}

// need to solve again..
fun tupleSameProduct(nums: IntArray): Int {
    val numsLength = nums.size
    val pairProductsFrequency: MutableMap<Int, Int> = HashMap()
    var totalNumberOfTuples = 0

    for (firstIndex in 0..<numsLength) {
        for (secondIndex in firstIndex + 1..<numsLength) {
            pairProductsFrequency[nums[firstIndex] * nums[secondIndex]] = pairProductsFrequency.getOrDefault(
                nums[firstIndex] * nums[secondIndex],
                0
            ) + 1
        }
    }

    for (productValue in pairProductsFrequency.keys) {
        val productFrequency = pairProductsFrequency[productValue]!!
        val pairsOfEqualProduct = ((productFrequency - 1) * productFrequency) / 2
        totalNumberOfTuples += 8 * pairsOfEqualProduct
    }

    return totalNumberOfTuples
}