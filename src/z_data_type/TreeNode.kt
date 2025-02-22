package z_data_type

data class TreeNode(
    var `val`: Int,
    var left: TreeNode? = null,
    var right: TreeNode? = null
)

fun createTree(values: List<Int?>): TreeNode? {
    if (values.isEmpty() || values[0] == null) return null
    val root = TreeNode(values[0]!!)
    val queue: ArrayDeque<TreeNode> = ArrayDeque()
    queue.add(root)

    var i = 1
    while (i < values.size) {
        val current = queue.removeFirst()
        if (i < values.size && values[i] != null) {
            current.left = TreeNode(values[i]!!)
            queue.add(current.left!!)
        }
        i++

        if (i < values.size && values[i] != null) {
            current.right = TreeNode(values[i]!!)
            queue.add(current.right!!)
        }
        i++
    }

    return root
}

// Inorder DFS : left -> root -> right
fun printInorderTree(node: TreeNode?) {
    val arr = ArrayList<Int>()
    inorderHelper(node, arr)
    for (i in arr.indices) {
        print(arr[i])
        if (i < arr.size - 1) print(" -> ")
    }
    println()
}

private fun inorderHelper(curr: TreeNode?, arr: ArrayList<Int>) {
    if (curr == null) return
    inorderHelper(curr.left, arr)
    arr.add(curr.`val`)
    inorderHelper(curr.right, arr)
}