package d_april

/**
 *  Problem 17. Count Equal and Divisible Pairs in an Array.
 *
 *  ## Intuition -
 *
 *  ## Approach -
 *
 *  ## Complexity:
 *       - Time complexity: O(n^2)
 *
 *       - Space complexity: O(1)
 *
 * ## Code -
 */
fun main() {

    val testCases = listOf(
        Pair(
            intArrayOf(2, 2, 2, 2, 2, 2, 2), 2
        ),
        Pair(
            intArrayOf(3, 1, 2, 2, 2, 1, 3), 2
        ),
        Pair(
            intArrayOf(1, 2, 3, 4), 1
        )
    )

    testCases.forEach { test ->
        println("Result ==> ${countPairs(test.first, test.second)}")
    }

}

fun countPairs(nums: IntArray, k: Int): Int {
    var count = 0
    for (i in nums.indices) {
        for (j in i + 1..<nums.size) {
            if (nums[i] == nums[j] && (i * j) % k == 0) count++
        }
    }

    return count
}

fun countPairs1(nums: IntArray, k: Int): Int {
    val seen = HashMap<Int, MutableList<Int>>()
    var count = 0
    for (i in nums.indices) {
        val num = nums[i]
        if (seen[num] != null) {
            for (ind in seen[num]!!) {
                val exp = (i * ind) % k
                if (exp == 0) count++
            }
        }

        if (seen[num] == null) seen[num] = mutableListOf()
        seen[num]?.add(i)
    }

    return count
}