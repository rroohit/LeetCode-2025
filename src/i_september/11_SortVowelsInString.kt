package i_september

// Sort Vowels in a String.
// TC - O(NlogN) :: SC - O(N)
fun main() {

    val testCases = listOf(
        "lEetcOde",
        "lYmpH"
    )

    testCases.forEach { s ->
        println("Result ==> ${sortVowels(s)}")
    }

}

fun sortVowels(s: String): String {
    val chMap = HashMap<Char, Int>()
    for (ch in s) {
        if (ch.isVowel()) {
            chMap[ch] = chMap.getOrDefault(ch, 0) + 1
        }
    }

    val list = chMap.map { it.key }.sorted().toMutableList()
    val sb = StringBuilder()

    for (ch in s) {
        sb.append(
            if (ch.isVowel()) getChar(list, chMap) else ch
        )
    }

    return sb.toString()
}

private fun getChar(list: MutableList<Char>, chMap: HashMap<Char, Int>): Char {
    for (ch in list) {
        if (chMap[ch]!! > 0) {
            chMap[ch] = chMap.getOrDefault(ch, 0) - 1
            if (chMap[ch] == 0) list.remove(ch)
            return ch
        }
    }
    return ' '
}

private fun Char.isVowel(): Boolean {
    val ch = this
    return ch == 'a' || ch == 'A' || ch == 'i' || ch == 'I' || ch == 'e' || ch == 'E' || ch == 'o' || ch == 'O' || ch == 'u' || ch == 'U'
}