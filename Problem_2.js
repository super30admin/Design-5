// ## Problem 2: Copy List with Random Pointer

// https://leetcode.com/problems/copy-list-with-random-pointer/


// HM
// TC: O(N)
// SC: O(N)

// In place
// TC: O(N)
// SC: O(1)

// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

/**
 * // Definition for a Node.
 * function Node(val, next, random) {
 *    this.val = val;
 *    this.next = next;
 *    this.random = random;
 * };
 */


let map;

/**
 * @param {Node} head
 * @return {Node}
 */
var getClone = (node) => {
    if (node === null) return null;
    if (map.has(node)) return map.get(node);

    let newNode = new Node(node.val);
    map.set(node, newNode);
    return newNode;
}

var copyRandomList = function (head) {
    if (head === null)
        return head;

    // map = new Map();

    // let cloneHead = getClone(head);
    // let clonecurr = cloneHead;
    // let curr = head;

    // while(curr !== null){
    //     clonecurr.next = getClone(curr.next);
    //     clonecurr.random = getClone(curr.random);

    //     curr = curr.next;
    //     clonecurr = clonecurr.next;
    // }
    // return cloneHead;

    // Step1: Create a copy as the nodes next in linked list
    let curr = head;
    while (curr !== null) {
        let copyNode = new Node(curr.val);
        copyNode.next = curr.next;
        curr.next = copyNode;
        curr = curr.next.next;
    }
    // Step 2: set the random pointers
    curr = head;
    while (curr !== null) {
        if (curr.random != null) {
            curr.next.random = curr.random.next;
        }
        curr = curr.next.next;
    }

    // Step 3: Get original linked lists;
    curr = head;
    let copyHead = curr.next;
    let copyCurr = copyHead;
    while (curr !== null) {
        curr.next = copyCurr.next;
        if (copyCurr.next === null)
            break;

        copyCurr.next = copyCurr.next.next;
        curr = curr.next;
        copyCurr = copyCurr.next
    }
    return copyHead;

};