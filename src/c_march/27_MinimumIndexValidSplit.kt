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
 *       - Space complexity: O(1)
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

// Boyer-Moore Majority Voting Algorithm
// TC - O(n) :: SC - O(1)
fun minimumIndex(nums: List<Int>): Int {
    var x = 0
    var xCount = 0
    for (num in nums) {
        if (xCount == 0) {
            x = num
            xCount++
        } else if (x == num) {
            xCount++
        } else {
            xCount--
        }
    }

    xCount = 0 // totalCount of x
    for (num in nums) if (num == x) xCount++

    var leftX = 0 // left window x Count
    for (i in nums.indices) {
        val num = nums[i]
        if (num == x) leftX++
        val rightX = xCount - leftX // right window x Count
        if (leftX * 2 > i + 1 && rightX * 2 > nums.size - i - 1) return i
    }

    return -1
}

// TC - O(n) :: SC - O(n)
fun minimumIndex1(nums: List<Int>): Int {
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