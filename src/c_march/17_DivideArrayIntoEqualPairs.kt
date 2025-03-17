package c_march

import java.util.*
import kotlin.collections.HashMap
import kotlin.collections.HashSet

/**
 *  Problem 17. Divide Array Into Equal Pairs.
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
        intArrayOf(3, 2, 3, 2, 2, 2),
        intArrayOf(1, 2, 3, 4),
        intArrayOf(1, 2, 3, 4, 1, 2, 3, 4)
    )

    testCases.forEach { nums ->
        println("Result ==> ${divideArray(nums)}")
    }

}

fun divideArray(nums: IntArray): Boolean {
    val unpaired = HashSet<Int>()
    for (num in nums) {
        if (unpaired.contains(num)) {
            unpaired.remove(num)
        } else {
            unpaired.add(num)
        }
    }
    return unpaired.isEmpty()
}

fun divideArray3(nums: IntArray): Boolean {
    Arrays.sort(nums);
    for (i in nums.indices step 2) {
        if (nums[i] != nums[i + 1]) return false
    }
    return true
}

fun divideArray2(nums: IntArray): Boolean {
    val group = HashMap<Int, Int>()
    for (num in nums) {
        group[num] = group.getOrDefault(num, 0) + 1
    }

    for ((_, cnt) in group) {
        if (cnt % 2 != 0) return false
    }

    return true
}

// TC - O(max(nums)) :: SC - (max(nums))
fun divideArray1(nums: IntArray): Boolean {
    var max = 0
    for (num in nums) if (num > max) max = num

    val numCnt = IntArray(max + 1)
    for (num in nums) numCnt[num]++

    for (num in numCnt) {
        if (num == 0 || num % 2 == 0) continue
        return false
    }
    return true
}