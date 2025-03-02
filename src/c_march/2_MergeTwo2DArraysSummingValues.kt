package c_march

/**
 *  Problem 2. Merge Two 2D Arrays by Summing Values.
 *
 *  ## Intuition -
 *
 *  ## Approach -
 *
 *  ## Complexity:
 *       - Time complexity: O(n + m)
 *
 *       - Space complexity: O(n + m)
 *
 * ## Code -
 */
fun main() {

    val testCases = listOf(
        Pair(
            arrayOf(intArrayOf(1, 2), intArrayOf(2, 3), intArrayOf(4, 5)),
            arrayOf(intArrayOf(1, 4), intArrayOf(3, 2), intArrayOf(4, 1))
        )
    )

    testCases.forEach { test ->
        println("Result ==> ${mergeArrays(test.first, test.second)}")
    }

}

fun mergeArrays(nums1: Array<IntArray>, nums2: Array<IntArray>): Array<IntArray> {
    val mapIdVal = HashMap<Int, Int>()
    fillHashMap(nums1, mapIdVal)
    fillHashMap(nums2, mapIdVal)

    val result = ArrayList<IntArray>()
    for (id in 1..1000) {
        if (mapIdVal.containsKey(id)) {
            result.add(intArrayOf(id, mapIdVal[id]!!))
        }
    }

    return result.toTypedArray()
}

private fun fillHashMap(nums: Array<IntArray>, mapIdVal: HashMap<Int, Int>) {
    for ((id, value) in nums) {
        mapIdVal[id] = mapIdVal.getOrDefault(id, 0) + value
    }
}

