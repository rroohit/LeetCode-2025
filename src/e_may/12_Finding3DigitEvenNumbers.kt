package e_may

/**
 *  Problem 12. Finding 3-Digit Even Numbers.
 *
 *  ## Intuition -
 *
 *  ## Approach -
 *
 *  ## Complexity:
 *       - Time complexity: O(n)
 *
 *       - Space complexity: O(1)
 *
 * ## Code -
 */
fun main() {

    val testCases = listOf(
        intArrayOf(2, 1, 3, 0),
        intArrayOf(2, 2, 8, 8, 2)
    )

    testCases.forEach { digits ->
        println("Result ==> ${findEvenNumbers(digits).toList()}")
    }

}

fun findEvenNumbers(digits: IntArray): IntArray {
    val cntMap = IntArray(10)
    for (num in digits) cntMap[num]++ // TC - O(n)

    val result = ArrayList<Int>()
    for (num in 100..999 step 2) {
        val cnt = num.getIntKeys()
        updateCount(true, cntMap, cnt)
        if (cntMap[cnt[0]] >= 0 && cntMap[cnt[1]] >= 0 && cntMap[cnt[2]] >= 0) result.add(num)
        updateCount(false, cntMap, cnt)
    }

    return result.toIntArray()
}

private fun updateCount(remove: Boolean, arr: IntArray, keys: ArrayList<Int>) {
    for (key in keys) if (remove) arr[key]-- else arr[key]++
}

private fun Int.getIntKeys(): ArrayList<Int> {
    val cntMap = ArrayList<Int>()
    var n = this
    while (n > 0) {
        cntMap.add(n % 10)
        n /= 10
    }
    return cntMap
}

// -------------------------------------------------------------------------------------
fun findEvenNumbers2(digits: IntArray): IntArray {
    val cntMap = IntArray(10)
    for (num in digits) cntMap[num]++ // TC - O(n)
    val result = ArrayList<Int>()
    dfsGetNum(0, result, cntMap)
    result.sort()
    return result.toSet().toIntArray()
}

private fun dfsGetNum(curr: Int, result: ArrayList<Int>, cntMap: IntArray) {
    if (curr > 999) return
    if (curr > 99) {
        if (curr % 2 == 0) result.add(curr)
        return
    }

    for (i in 0..9) {
        if (cntMap[i] == 0) continue
        cntMap[i]--
        dfsGetNum(i + (curr * 10), result, cntMap)
        cntMap[i]++
    }
}

// -------------------------------------------------------------------------------------
fun findEvenNumbers1(digits: IntArray): IntArray {
    val map = HashMap<Int, Int>()
    for (num in digits) map[num] = map.getOrDefault(num, 0) + 1

    val result = ArrayList<Int>()
    for (num in 100..999 step 2) {
        val currMap = num.getCountMap()
        var valid = true
        for ((key, value) in currMap) {
            if (map[key] == null || map[key]!! < value) {
                valid = false
                break
            }
        }

        if (valid) result.add(num)
    }

    return result.toIntArray()
}

private fun Int.getCountMap(): HashMap<Int, Int> {
    val cntMap = hashMapOf<Int, Int>()
    var n = this
    while (n > 0) {
        val key = n % 10
        cntMap[key] = cntMap.getOrDefault(key, 0) + 1
        n /= 10
    }
    return cntMap
}