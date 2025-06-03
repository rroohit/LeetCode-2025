package f_june

import java.util.*


/**
 *  Problem 3. Maximum Candies You Can Get from Boxes.
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

}


fun maxCandies(
    status: IntArray,
    candies: IntArray,
    keys: Array<IntArray>,
    containedBoxes: Array<IntArray>,
    initialBoxes: IntArray
): Int {
    val n: Int = status.size
    val canOpen = BooleanArray(n)
    val hasBox = BooleanArray(n)
    val used = BooleanArray(n)

    for (i in 0..<n) {
        canOpen[i] = (status[i] == 1)
    }

    val q: Queue<Int?> = LinkedList<Int?>()
    var ans = 0

    for (box in initialBoxes) {
        hasBox[box] = true
        if (canOpen[box]) {
            q.offer(box)
            used[box] = true
            ans += candies[box]
        }
    }

    while (!q.isEmpty()) {
        val bigBox: Int = q.poll()!!
        for (key in keys[bigBox]) {
            canOpen[key] = true
            if (!used[key] && hasBox[key]) {
                q.offer(key)
                used[key] = true
                ans += candies[key]
            }
        }
        for (box in containedBoxes[bigBox]) {
            hasBox[box] = true
            if (!used[box] && canOpen[box]) {
                q.offer(box)
                used[box] = true
                ans += candies[box]
            }
        }
    }

    return ans
}