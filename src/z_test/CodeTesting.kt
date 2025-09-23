package z_test

import kotlin.math.log

fun main() {


}

fun topKFrequent(words: Array<String>, k: Int): List<String> {
    val freq = hashMapOf<String,Int>()
    for (key in words) {
        freq[key] = freq.getOrDefault(key, 0) + 1
    }

    val buckets = Array<ArrayList<String>>(words.size + 1) { arrayListOf() }
    for ((word, cnt) in freq) {
        buckets[cnt].add(word)
    }

    val ans = ArrayList<String>()
    for (i in buckets.size - 1 downTo 0) {
        for (list in buckets[i].sorted()) {
            ans.add(list)
            if (ans.size == k) break
        }
        if (ans.size == k) break
    }

    return ans
}

fun topKFrequent(nums: IntArray, k: Int): IntArray {
    val freq = hashMapOf<Int, Int>()
    for (num in nums) {
        freq[num] = freq.getOrDefault(num, 0) + 1
    }

    val buckets = Array<ArrayList<Int>>(nums.size + 1) { arrayListOf() }
    for ((num, count) in freq) {
        buckets[count].add(num)
    }

    val ans = IntArray(k)
    var p = 0
    for (i in buckets.size - 1 downTo 0) {
        for (num in buckets[i]) {
            ans[p++] = num
            if (p == k) break
        }
        if (p == k) break
    }

    return ans
}

// TC - O(n * m) :: SC - O(n)
fun groupAnagrams(strs: Array<String>): List<List<String>> {
    val ans = hashMapOf<String, ArrayList<String>>()
    for (word in strs) {
        val key = word.getKey()
        ans.getOrPut(key) { arrayListOf() }.add(word)
    }
    return ans.map { it.value }
}

private fun String.getKey(): String {
    val arr = Array(26) { 0 }
    forEach { ch -> arr[ch - 'a']++ }
    return arr.joinToString("/")
}

// TC - O(n) :: SC - (n)
fun twoSum(nums: IntArray, target: Int): IntArray {
    val numInd = hashMapOf<Int, Int>()
    for (i in nums.indices) {
        val num = nums[i]
        val key = target - num
        if (numInd.contains(key)) return intArrayOf(numInd[key]!!, i)
        numInd[num] = i
    }
    return intArrayOf()
}

// TC - O(n) :: SC - O(n)
fun isAnagram(s: String, t: String): Boolean {
    val map = hashMapOf<Char, Int>()
    for (ch in s) {
        map[ch] = map.getOrDefault(ch, 0) + 1
    }

    for (ch in t) {
        val cnt = map[ch]
        if (cnt == null || cnt == 0) return false
        map[ch] = cnt - 1
    }

    return true
}

// TC - O(n) :: SC - O(n)
fun containsDuplicate(nums: IntArray): Boolean {
    val seen = hashSetOf<Int>()
    for (num in nums) if (!seen.add(num)) return false
    return true
}

fun findNthDigit(n: Int): Int {
    val stringLength = StringLength(n)
    for (i in 1..n) {
        for (ch in "$i") {
            val ans = stringLength.pushChar(ch)
            if (ans != -1) return ans
        }
    }
    return -1
}

class StringLength(private val n: Int) {
    var size = 0
    fun pushChar(char: Char): Int {
        if (++size == n) return char.digitToInt()
        return -1
    }
}