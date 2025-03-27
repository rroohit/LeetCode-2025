package c_march

/**
 *  Problem 27. Minimum Index of a Valid Split.
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
        listOf(1, 2, 2, 2)
    )

    testCases.forEach { nums ->
        println("Result ==> ${minimumIndex(nums)}")
    }

}

// TC - O(n) :: SC - O(n)
fun minimumIndex(nums: List<Int>): Int {
    val first = HashMap<Int, Int>()
    val second = HashMap<Int, Int>()

    for (num in nums) {
        second[num] = second.getOrDefault(num, 0) + 1
    }

    for (i in nums.indices) {
        val num = nums[i]
        second[num] = second[num]!! - 1
        first[num] = first.getOrDefault(num, 0) + 1
        if (first[num]!! * 2 > i + 1 && second[num]!! * 2 > nums.size - i - 1) return i
    }

    return -1
}