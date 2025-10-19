package j_october

/**
 *  Problem 9. Find the Minimum Amount of Time to Brew Potions.
 *
 *  ## Intuition -
 *
 *  ## Approach -
 *
 *  ## Complexity:
 *       - Time complexity: O()
 *       - Space complexity: O()
 *
 * ## Code -
 */
fun main() {

    val testCases = listOf(
        Pair(
            intArrayOf(1, 5, 2, 4),
            intArrayOf(5, 1, 4, 2)
        )
    )

    testCases.forEach { (skill, mana) ->
        println("Result ==> ${minTime(skill, mana)}")
    }

}

fun minTime(skill: IntArray, mana: IntArray): Long {
    val n = skill.size
    val m = mana.size
    var sumSkill = 0L
    for (s in skill) sumSkill += s.toLong()

    var prevWizardDone = sumSkill * mana[0].toLong()
    for (j in 1 until m) {
        var prevPotionDone = prevWizardDone
        for (i in n - 2 downTo 0) {
            prevPotionDone -= skill[i + 1].toLong() * mana[j - 1].toLong()
            prevWizardDone = maxOf(
                prevPotionDone,
                prevWizardDone - skill[i].toLong() * mana[j].toLong()
            )
        }
        prevWizardDone += sumSkill * mana[j].toLong()
    }
    return prevWizardDone
}
