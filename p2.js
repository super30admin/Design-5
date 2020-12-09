// ## Problem 2: Copy List with Random Pointer

// https://leetcode.com/problems/copy-list-with-random-pointer/

// time: O(n) 
// space: O(1)

const copyRandomList = function(head) {
    if (!head) return null;
    let ptr = head;
    while (ptr != null) {
      let newNode = new Node(ptr.val);
      // A->A'->B->B'->C->C'
      newNode.next = ptr.next;
      ptr.next = newNode;
      ptr = newNode.next;
    }
    ptr = head;
    // Iterate the newly created list and use the original nodes' random pointers,
    // to assign references to random pointers for cloned nodes.
    while (ptr != null) {
      ptr.next.random = (ptr.random != null) ? ptr.random.next : null;
      ptr = ptr.next.next;
    }
    // A->A'->B->B'->C->C' would be broken to A->B->C and A'->B'->C'
    let ptr_old_list = head; // A->B->C
    let ptr_new_list = head.next; // A'->B'->C'
    let head_old = head.next;
    while (ptr_old_list != null) {
      ptr_old_list.next = ptr_old_list.next.next;
      ptr_new_list.next = (ptr_new_list.next != null) ? ptr_new_list.next.next : null;
      ptr_old_list = ptr_old_list.next;
      ptr_new_list = ptr_new_list.next;
    }
    return head_old;
}

///////////////////

// Solution with Hash Map
// time: O(n) 
// space: O(n)

let visited = new Map();
function getClonedNode(node) {
    if (node != null) {
      if (visited.has(node)) return visited.get(node);
      else {
        visited.set(node, new Node(node.val, null, null));
        return visited.get(node);
      }
    }
    return null;
}
function copyRandomList(head) {
    if(head == null) return null;
    let oldNode = head;
    let newNode = new Node(oldNode.val);
    visited.set(oldNode, newNode);
    
    while (oldNode !== null) {
      newNode.random = getClonedNode(oldNode.random);
      newNode.next = getClonedNode(oldNode.next);
      oldNode = oldNode.next;
      newNode = newNode.next;
    }
    return visited.get(head);
}