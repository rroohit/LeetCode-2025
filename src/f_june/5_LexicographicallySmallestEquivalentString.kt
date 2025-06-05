package f_june


/**
 *  Problem 5. Lexicographically Smallest Equivalent String.
 *
 *  ## Intuition -
 *
 *  ## Approach -
 *
 *  ## Complexity:
 *       - Time complexity: O(n + m)
 *
 *       - Space complexity: O(26)
 *
 * ## Code -
 */
fun main() {

    val testCases = listOf(
        Triple(
            "parker", "morris", "parser"
        )
    )

    testCases.forEach { (s1, s2, baseStr) ->
        println("Result ==> ${smallestEquivalentString(s1, s2, baseStr)}")
    }

}

fun smallestEquivalentString(s1: String, s2: String, baseStr: String): String {
    for (i in s1.indices) {
        union(s1[i] - 'a', s2[i] - 'a')
    }

    val result = StringBuilder()
    for (c in baseStr) {
        val root = find(c - 'a')
        result.append(('a' + root))
    }

    return result.toString()
}

private val parent = IntArray(26) { it }
private fun find(x: Int): Int {
    if (parent[x] != x) {
        parent[x] = find(parent[x])
    }
    return parent[x]
}

private fun union(x: Int, y: Int) {
    val rootX = find(x)
    val rootY = find(y)
    if (rootX != rootY) {
        if (rootX < rootY) {
            parent[rootY] = rootX
        } else {
            parent[rootX] = rootY
        }
    }
}