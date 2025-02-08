package b_february

import java.util.PriorityQueue

/**
 *  Problem 8. Design a Number Container System.
 *
 *  ## Intuition -
 *
 *  ## Approach -
 *
 *  ## Complexity:
 *       - Time complexity: O(1)
 *
 *       - Space complexity: O(n)
 *
 * ## Code -
 */
fun main() {

    val testCases = listOf(
        listOf(
            Pair("find", intArrayOf(10)),
            Pair("change", intArrayOf(2, 10)),
            Pair("change", intArrayOf(1, 10)),
            Pair("change", intArrayOf(3, 10)),
            Pair("change", intArrayOf(5, 10)),
            Pair("find", intArrayOf(10)),
            Pair("change", intArrayOf(1, 20)),
            Pair("find", intArrayOf(10)),
        )
    )

    testCases.forEach { test ->
        val numberContainers = NumberContainers()
        test.forEach { data ->
            when (data.first) {
                "find" -> {
                    println("Index -> ${numberContainers.find(data.second[0])}")
                }

                "change" -> {
                    numberContainers.change(data.second[0], data.second[1])
                    println("null")
                }
            }
        }
    }

}

class NumberContainers() {
    private val numToInd = HashMap<Int, PriorityQueue<Int>>()

    // Index --> Num
    private val indNum = HashMap<Int, Int>()

    fun change(index: Int, number: Int) {
        indNum[index] = number
        numToInd.computeIfAbsent(number) { PriorityQueue() }.offer(index)
    }

    fun find(number: Int): Int {
        val qu = numToInd[number] ?: return -1
        while (qu.isNotEmpty()) {
            val index = qu.peek()!!
            if (indNum[index] == number) return index
            qu.poll()
        }
        return -1
    }

}