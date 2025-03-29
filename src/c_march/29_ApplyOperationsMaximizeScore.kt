package c_march

import java.util.*
import kotlin.math.min
import kotlin.math.sqrt


/**
 *  Problem 29. Apply Operations to Maximize Score.
 *
 *  ## Intuition -
 *
 *  ## Approach -ʔ
 *
 *  ## Complexity:ʔ
 *       - Time complexity: O(n * (√m + logn))
 *
 *       - Space complexity: O(n)
 *
 * ## Code -
 */
fun main() {

    val testCases = listOf(
        Pair(
            listOf(8, 3, 9, 3, 8), 2
        )
    )

    testCases.forEach { test ->
        println("Result ==> ${maximumScore(test.first, test.second)}")
    }

}

private val MOD = 1000000000 + 7
fun maximumScore(nums: List<Int>, k: Int): Int {
    var kk = k.toLong()
    val n = nums.size
    val primeScores = ArrayList(List(n + 1) { 0 })

    for (index in 0..<n) {
        var num = nums[index].toDouble()
        var factor = 2.0
        while (factor <= sqrt(num)) {
            if (num % factor == 0.0) {
                primeScores[index] = primeScores[index] + 1
                while (num % factor == 0.0) num /= factor
            }
            factor++
        }
        if (num >= 2) primeScores[index] = primeScores[index] + 1
    }

    val nextDominant = IntArray(n) { n }
    val prevDominant = IntArray(n) { -1 }

    val decreasingPrimeScoreStack = Stack<Int>()

    for (index in 0..<n) {
        while (!decreasingPrimeScoreStack.isEmpty() &&
            primeScores[decreasingPrimeScoreStack.peek()] <
            primeScores[index]
        ) {
            val topIndex = decreasingPrimeScoreStack.pop()
            nextDominant[topIndex] = index
        }

        if (!decreasingPrimeScoreStack.isEmpty())
            prevDominant[index] = decreasingPrimeScoreStack.peek()

        decreasingPrimeScoreStack.push(index)
    }

    val numOfSubarrays = LongArray(n)
    for (index in 0..<n) {
        numOfSubarrays[index] = (nextDominant[index].toLong() - index) * (index - prevDominant[index])
    }

    val processingQueue = PriorityQueue(java.util.Comparator { a: IntArray, b: IntArray ->
        if (b[0] == a[0]) {
            return@Comparator a[1].compareTo(b[1])
        }
        b[0].compareTo(a[0])
    })

    for (index in 0..<n) {
        processingQueue.offer(intArrayOf(nums[index], index))
    }

    var score: Long = 1

    while (kk > 0) {
        val top = processingQueue.poll()
        val num = top[0]
        val index = top[1]

        val operations = min(kk, numOfSubarrays[index]).toLong()
        score = (score * power(num.toLong(), operations)) % MOD
        kk -= operations.toInt()
    }

    return score.toInt()
}

private fun power(b: Long, expo: Long): Long {
    var base = b
    var exponent = expo
    var res: Long = 1
    while (exponent > 0) {
        if (exponent % 2 == 1L) {
            res = (res * base) % MOD
        }
        base = (base * base) % MOD
        exponent /= 2
    }
    return res
}