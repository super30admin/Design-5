// Time Complexity : 0(n)
// Space Complexity : 0(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :

    func copyRandomList(_ head: Node?) -> Node? {
        if head == nil {
            return nil
        }
        var current = head
        var previous : Node? = nil
        var newHead: Node?
        var hashmap = [Node:Int]()
        var hashmap2 = [Int:Node]()
        var rhashmap = [Node:Int]()
        var index = 1
        while current != nil {
            guard let curr = current else { return current }
            var node = Node(curr.val)
            previous?.next = node
            hashmap[curr] = index
            hashmap2[index] = node 
            if curr == head {
                newHead = node
            }
            previous = node
            current = curr.next
            index += 1
        }
         current = head
         while current != nil {
             guard let curr = current else {return current}
             if let random = curr.random {
             rhashmap[curr] = hashmap[random,default: -1]
             } else {
                 rhashmap[curr] = -1
             }
             current = curr.next
         }
        current = head
        var newcurrent = newHead
        while current != nil && newHead != nil {
            guard let curr = current else {return current}
            guard let newcurr = newcurrent else {return newcurrent}
            let index = rhashmap[curr,default:-1]
            newcurr.random = hashmap2[index]
            current = curr.next
            newcurrent = newcurr.next
        }
        return newHead
    }


