package d_april


/**
 *  Problem 25. Count of Interesting Subarrays.
 *
 *  ## Intuition -
 *
 *  ## Approach -
 *
 *  ## Complexity:
 *       - Time complexity: O(n)
 *
 *       - Space complexity: O(min(n,modulo))
 *
 * ## Code -
 */
fun main() {

    val testCases = listOf(
        Triple(
            listOf(3, 2, 4), 2, 1
        ),
        Triple(
            listOf(3, 1, 9, 6), 3, 0
        )
    )

    testCases.forEach { test ->
        println("Result ==> ${countInterestingSubarrays(test.first, test.second, test.third)}")
    }

}

fun countInterestingSubarrays(
    nums: List<Int>,
    modulo: Int,
    k: Int
): Long {
    val n = nums.size
    val cnt = HashMap<Int, Int>()
    var res: Long = 0
    var prefix = 0
    cnt[0] = 1
    for (i in 0..<n) {
        prefix += if (nums[i] % modulo == k) 1 else 0
        res += cnt.getOrDefault((prefix - k + modulo) % modulo, 0).toLong()
        cnt[prefix % modulo] = cnt.getOrDefault(prefix % modulo, 0) + 1
    }
    return res
}
