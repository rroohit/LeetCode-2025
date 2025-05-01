package e_may

import java.util.*
import kotlin.math.min

/**
 *  Problem 1. Maximum Number of Tasks You Can Assign.
 *
 *  ## Intuition -
 *
 *  ## Approach -
 *
 *  ## Complexity:
 *       - Time complexity: O(nlogn + mlogm + min(m,n) log^2 min(m,n))
 *
 *       - Space complexity: O(logn + logm + min(m,n))
 *
 * ## Code -
 */
fun main() {

    val testCases = listOf(
        DataOne(
            tasks = intArrayOf(3, 2, 1),
            workers = intArrayOf(0, 3, 3),
            pills = 1,
            strength = 1
        )
    )

    testCases.forEach { task ->
        println("Result ==> ${maxTaskAssign(task.tasks, task.workers, task.pills, task.strength)}")
    }

}

fun maxTaskAssign(
    tasks: IntArray,
    workers: IntArray,
    pills: Int,
    strength: Int
): Int {
    tasks.sort()
    workers.sort()
    val n = tasks.size
    val m = workers.size
    var left = 1
    var right = min(m, n)
    var ans = 0

    while (left <= right) {
        val mid = (left + right) / 2
        if (check(tasks, workers, pills, strength, mid)) {
            ans = mid
            left = mid + 1
        } else {
            right = mid - 1
        }
    }
    return ans
}

private fun check(
    tasks: IntArray,
    workers: IntArray,
    pills: Int,
    strength: Int,
    mid: Int
): Boolean {
    var p = pills
    val ws = TreeMap<Int?, Int>()
    for (i in workers.size - mid..<workers.size) {
        ws[workers[i]] = ws.getOrDefault(workers[i], 0) + 1
    }

    for (i in mid - 1 downTo 0) {
        var key = ws.lastKey()
        if (key!! >= tasks[i]) {
            ws[key] = ws[key]!! - 1
            if (ws[key] == 0) {
                ws.remove(key)
            }
        } else {
            if (p == 0) {
                return false
            }
            key = ws.ceilingKey(tasks[i] - strength)
            if (key == null) {
                return false
            }
            ws[key] = ws[key]!! - 1
            if (ws[key] == 0) {
                ws.remove(key)
            }
            --p
        }
    }
    return true
}

private data class DataOne(
    val tasks: IntArray,
    val workers: IntArray,
    val pills: Int,
    val strength: Int
) {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as DataOne

        if (pills != other.pills) return false
        if (strength != other.strength) return false
        if (!tasks.contentEquals(other.tasks)) return false
        if (!workers.contentEquals(other.workers)) return false

        return true
    }

    override fun hashCode(): Int {
        var result = pills
        result = 31 * result + strength
        result = 31 * result + tasks.contentHashCode()
        result = 31 * result + workers.contentHashCode()
        return result
    }
}