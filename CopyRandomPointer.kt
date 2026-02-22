// In this problem, we are using three pass approach. In the first pass, we create a copy of each node and insert it right after the original node. In the second pass, we set the random pointers 
// of the copied node. In the third pass, we restore the original list and extract the copied list.
// Time complexity: O(n) where n is the number of nodes.
// Space complexity: O(1) since we are not using any extra space for the copied nodes. 

/**
 * Example:
 * var ti = Node(5)
 * var v = ti.`val`
 * Definition for a Node.
 * class Node(var `val`: Int) {
 *     var next: Node? = null
 *     var random: Node? = null
 * }
 */

class Solution {
    fun copyRandomList(node: Node?): Node? {
        if (node == null) return null

        //first pass

        var curr: Node? = node
        while(curr != null) {
            val currCopy = Node(curr.`val`)
            currCopy.next = curr.next
            curr.next = currCopy
            curr = curr.next?.next 
        }

        curr = node

        while(curr != null) {
            if(curr.random != null) {
                curr.next?.random = curr.random?.next
            }

            curr = curr.next?.next
        }

        //third pass
       
        curr = node
        val result = node.next
        var copyCurr = result

        while (curr != null) {
            val nextOrig = copyCurr?.next
            curr.next = nextOrig
            copyCurr?.next = nextOrig?.next

            curr = nextOrig
            copyCurr = copyCurr?.next
        }

        return result
    }
}