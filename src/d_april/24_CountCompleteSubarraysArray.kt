package d_april

/**
 *  Problem 24. Count Complete Subarrays in an Array.
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
        intArrayOf(1, 3, 1, 2, 2),
        intArrayOf(5, 5, 5, 5)
    )

    testCases.forEach { nums ->
        println("Result ==> ${countCompleteSubarrays(nums)}")
    }

}

fun countCompleteSubarrays(nums: IntArray): Int {
    val totalDistinct = nums.toSet().size
    val freq = HashMap<Int, Int>()
    var l = 0
    var completeKinds = 0
    var ans = 0

    for (r in nums.indices) {
        val rightVal = nums[r]
        freq[rightVal] = freq.getOrDefault(rightVal, 0) + 1
        if (freq[rightVal] == 1) completeKinds++
        while (completeKinds == totalDistinct) {
            ans += (nums.size - r)
            val leftVal = nums[l]
            freq[leftVal] = freq[leftVal]!! - 1
            if (freq[leftVal] == 0) completeKinds--
            l++
        }
    }

    return ans
}

// Brute force
// TC - O(n^2) :: SC - O(n)
fun countCompleteSubarrays1(nums: IntArray): Int {
    val distNums = HashSet<Int>()
    for (num in nums) distNums.add(num)

    var count = 0

    for (i in nums.indices) {
        val subArray = HashSet<Int>()
        subArray.add(nums[i])
        if (subArray.size == distNums.size) count++
        for (j in i + 1..<nums.size) {
            subArray.add(nums[j])
            if (subArray.size == distNums.size) count++
        }
    }

    return count
}