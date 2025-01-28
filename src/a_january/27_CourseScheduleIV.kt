package a_january

/**
 *  Problem 27. Course Schedule IV.
 *
 *  ## Intuition -
 *
 *  ## Approach -
 *
 *  ## Complexity:
 *       - Time complexity: O()
 *
 *       - Space complexity: O()
 *
 * ## Code -
 */
fun main() {

    val testCases = listOf(
        TestData27(
            numCourses = 2,
            prerequisites = arrayOf(intArrayOf(1, 0)),
            queries = arrayOf(intArrayOf(0, 1), intArrayOf(1, 0))
        )
    )

    testCases.forEach { test ->
        println("Result ==> ${checkIfPrerequisite(test.numCourses, test.prerequisites, test.queries)}")
    }

}

fun checkIfPrerequisite(numCourses: Int, prerequisites: Array<IntArray>, queries: Array<IntArray>): List<Boolean> {

    return listOf()
}


private data class TestData27(
    val numCourses: Int,
    val prerequisites: Array<IntArray>,
    val queries: Array<IntArray>
) {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as TestData27

        if (numCourses != other.numCourses) return false
        if (!prerequisites.contentDeepEquals(other.prerequisites)) return false
        if (!queries.contentDeepEquals(other.queries)) return false

        return true
    }

    override fun hashCode(): Int {
        var result = numCourses
        result = 31 * result + prerequisites.contentDeepHashCode()
        result = 31 * result + queries.contentDeepHashCode()
        return result
    }
}