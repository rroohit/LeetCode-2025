package g_july

import z_data_type.ListNode

/**
 *  Problem 14. Convert Binary Number in a Linked List to Integer.
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

fun getDecimalValue(head: ListNode?): Int {
    val sb = StringBuilder()

    var curr = head
    while (curr != null) {
        sb.append(curr.`val`)
        curr = curr.next
    }

    return sb.toString().toInt(2)
}