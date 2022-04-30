/**
 * Definition for a Node.
 * type Node struct {
 *     Val int
 *     Next *Node
 *     Random *Node
 * }
 */

/*
    approach: hashmap
    - For now, forget about the random references and simply create a copy of input LL
    - Then while creating a copy of each node, you will create a new node right?
        - Save the originalNodeRef: copyNodeRef as key:val in a map
    - Finally, in another pass/loop over input LL
        - If the current node has a random pointer, 
        - Get the copyOfCurrent node from map
        - Get the copyOfRandom node from map
        - Connect the two using Random reference
    
    Time: o(2n) == o(n)
    space: o(n) == for the hashamp

*/
// func copyRandomList(head *Node) *Node {
//     cHead := &Node{Val: 0}
//     cCurr := cHead
    
//     origToDeepCopyNode := map[*Node]*Node{}
    
//     current := head
//     for current != nil {
//         newNode := &Node{Val: current.Val}
//         cHead.Next = newNode
//         cHead = cHead.Next
//         origToDeepCopyNode[current] = newNode
//         current = current.Next
//     }
    
//     current = head
//     for current != nil {
//         if current.Random != nil {
//             deepCpSrcNode := origToDeepCopyNode[current]
//             deepCpDestNode := origToDeepCopyNode[current.Random]
            
//             deepCpSrcNode.Random = deepCpDestNode
//         }
//         current = current.Next
//     }
//     return cCurr.Next
    
// }


// Time: o(n) , space: o(1)
// Create a copy of each node within the same LL
// Connect the copy nodes to their corresponding copy nodes ( random ref )
// Finally take out the copy nodes into its own LL and restore the original LL
func copyRandomList(head *Node) *Node {
    
    // make a copy of each node in input list
    curr := head
    for curr != nil {
        next := curr.Next
        newNode := &Node{Val: curr.Val}
        curr.Next = newNode
        newNode.Next = next
        curr = next
    }
    
    // now for each copy node, connect to its corresponding random ref
    curr = head
    for curr != nil && curr.Next != nil {
        next := curr.Next.Next
        if curr.Random != nil {
            curr.Next.Random = curr.Random.Next
        }
        curr = next
    }
    
    // finally take out the copied nodes into a new LL
    out := &Node{Val: 0}
    outCurr := out
    curr = head
    var prev *Node
    // 1-1'-2-2'-3-3'-4-4'
    for curr != nil && curr.Next != nil {
        next := curr.Next.Next
        cp := curr.Next
        curr.Next = nil
        outCurr.Next = cp
        outCurr = outCurr.Next
        if prev != nil {
            prev.Next = curr
        }
        prev = curr
        curr = next
    }
    
    return out.Next
}
