package g_july

import java.util.*


// Delete Duplicate Folders in System

internal class Solution {
    class Trie {
        var serial: String? = null
        var children: MutableMap<String?, Trie> = HashMap<String?, Trie>()
    }

    fun deleteDuplicateFolder(paths: MutableList<MutableList<String?>>): MutableList<MutableList<String?>?> {
        val root: Trie = Solution.Trie()

        for (path in paths) {
            var cur = root
            for (node in path) {
                cur.children.putIfAbsent(node, Trie())
                cur = cur.children.get(node)!!
            }
        }

        val freq: MutableMap<String?, Int?> =
            HashMap<String?, Int?>()

        construct(root, freq)
        val ans: MutableList<MutableList<String?>?> = ArrayList<MutableList<String?>?>()
        val path: MutableList<String?> = ArrayList<String?>()
        operate(root, freq, path, ans)
        return ans
    }

    private fun construct(node: Trie, freq: MutableMap<String?, Int?>) {
        if (node.children.isEmpty()) return
        val v: MutableList<String> = ArrayList<String>()
        for (entry in node.children.entries) {
            construct(entry.value, freq)
            v.add(entry.key + "(" + entry.value.serial + ")")
        }

        Collections.sort(v)

        val sb = StringBuilder()
        for (s in v) {
            sb.append(s)
        }
        node.serial = sb.toString()
        freq.put(node.serial, freq.getOrDefault(node.serial, 0)!! + 1)
    }

    private fun operate(
        node: Trie,
        freq: MutableMap<String?, Int?>,
        path: MutableList<String?>,
        ans: MutableList<MutableList<String?>?>
    ) {
        if (freq.getOrDefault(node.serial, 0)!! > 1) return

        if (!path.isEmpty()) {
            ans.add(ArrayList<String?>(path))
        }

        for (entry in node.children.entries) {
            path.add(entry.key)
            operate(entry.value, freq, path, ans)
            path.removeAt(path.size - 1)
        }
    }
}