package i_september

import java.util.*

/**
 *  Problem 20. Implement Router.
 *
 *  ## Intuition -
 *     Maintain packets in FIFO order, avoid duplicates, and efficiently query counts per destination.
 *
 *  ## Approach -
 *     Use a queue for FIFO order, a set for duplicate checking, and a map from destination to sorted timestamp list.
 *     Binary search is used on the sorted timestamp list to answer getCount queries in O(log n).
 *
 *  ## Complexity:
 *       - Time complexity:
 *             addPacket / forwardPacket: O(k) worst-case (removing from front of list)
 *             getCount: O(log k) per query, k = packets for the destination
 *       - Space complexity: O(memoryLimit)
 *
 * ## Code -
 */
fun main() {


}

class Router(memoryLimit: Int) {

    private val limit = memoryLimit
    private val seen = hashSetOf<String>()
    private val queue: Queue<Packet> = LinkedList()

    // destination -> list of timestamps in arrival order (sorted)
    private val destMap = mutableMapOf<Int, MutableList<Int>>()

    fun addPacket(source: Int, destination: Int, timestamp: Int): Boolean {
        val key = "$source#$destination#$timestamp"
        if (!seen.add(key)) return false

        val packet = Packet(source, destination, timestamp, key)
        queue.add(packet)

        val list = destMap.getOrPut(destination) { mutableListOf() }
        list.add(timestamp)

        if (queue.size > limit) {
            val old = queue.remove()!!
            seen.remove(old.key)
            destMap[old.destination]?.removeAt(0)
        }

        return true
    }

    fun forwardPacket(): IntArray {
        if (queue.isEmpty()) return intArrayOf()
        val head = queue.remove()
        seen.remove(head.key)

        destMap[head.destination]?.removeAt(0)

        return intArrayOf(head.source, head.destination, head.timestamp)
    }

    fun getCount(destination: Int, startTime: Int, endTime: Int): Int {
        val list = destMap[destination] ?: return 0
        if (list.isEmpty()) return 0

        val left = lowerBound(list, startTime)
        val right = upperBound(list, endTime)
        return if (left <= right) right - left + 1 else 0
    }

    // first index >= target
    private fun lowerBound(list: List<Int>, target: Int): Int {
        var l = 0
        var r = list.size - 1
        var ans = list.size
        while (l <= r) {
            val m = l + (r - l) / 2
            if (list[m] >= target) {
                ans = m
                r = m - 1
            } else {
                l = m + 1
            }
        }
        return ans
    }

    // last index <= target
    private fun upperBound(list: List<Int>, target: Int): Int {
        var l = 0
        var r = list.size - 1
        var ans = -1
        while (l <= r) {
            val m = l + (r - l) / 2
            if (list[m] <= target) {
                ans = m
                l = m + 1
            } else {
                r = m - 1
            }
        }
        return ans
    }

    private data class Packet(
        val source: Int,
        val destination: Int,
        val timestamp: Int,
        val key: String
    )
}
