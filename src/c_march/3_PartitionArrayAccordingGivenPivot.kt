package c_march

/**
 *  Problem 3. Partition Array According to Given Pivot.
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
            intArrayOf(9, 12, 5, 10, 14, 3, 10), 10
        )
    )

    testCases.forEach { test ->
        println("Result ==> ${pivotArray(test.first, test.second).toList()}")
    }

}

fun pivotArray(nums: IntArray, pivot: Int): IntArray {
    val result = IntArray(nums.size) { pivot }
    var i = 0
    for (num in nums) {
        if (num < pivot) result[i++] = num
    }

    i = nums.size - 1
    for (j in nums.size - 1 downTo 0) {
        if (nums[j] > pivot) result[i--] = nums[j]
    }

    return result
}

fun pivotArray1(nums: IntArray, pivot: Int): IntArray {
    val less = ArrayList<Int>() // less than pivot
    var eq = 0
    val great = ArrayList<Int>() // greater than pivot
    for (num in nums) {
        if (num == pivot) {
            eq++
        } else if (num > pivot) great.add(num) else less.add(num)
    }
    var i = 0
    for (num in less) nums[i++] = num
    for (e in 1..eq) nums[i++] = pivot
    for (num in great) nums[i++] = num
    return nums
}