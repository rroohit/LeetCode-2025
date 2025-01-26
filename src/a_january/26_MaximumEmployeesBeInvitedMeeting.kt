package a_january

import java.util.*
import kotlin.math.max


/**
 *  Problem 26. Maximum Employees to Be Invited to a Meeting.
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
        intArrayOf(2, 2, 1, 2)
    )

    testCases.forEach { favorite ->
        println("Result ==> ${maximumInvitations(favorite)}")
    }

}

fun maximumInvitations(favorite: IntArray): Int {
    val n = favorite.size
    val inDegree = IntArray(n)

    for (person in 0..<n) {
        inDegree[favorite[person]]++
    }

    val q: Queue<Int> = LinkedList()
    for (person in 0..<n) {
        if (inDegree[person] == 0) {
            q.offer(person)
        }
    }

    val depth = IntArray(n) { 1 }
    while (!q.isEmpty()) {
        val currentNode = q.poll()
        val nextNode = favorite[currentNode]
        depth[nextNode] = max(depth[nextNode], (depth[currentNode] + 1))
        if (--inDegree[nextNode] == 0) {
            q.offer(nextNode)
        }
    }

    var longestCycle = 0
    var twoCycleInvitations = 0

    for (person in 0..<n) {
        if (inDegree[person] == 0) continue
        var cycleLength = 0
        var current = person
        while (inDegree[current] != 0) {
            inDegree[current] = 0
            cycleLength++
            current = favorite[current]
        }

        if (cycleLength == 2) {
            twoCycleInvitations += depth[person] + depth[favorite[person]]
        } else {
            longestCycle = max(longestCycle, cycleLength)
        }
    }

    return max(longestCycle, twoCycleInvitations)
}