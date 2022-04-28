// Time Complexity : O(n)
// Space Complexity : O(1)

/**
 * // Definition for a Node.
 * function Node(val, next, random) {
 *    this.val = val;
 *    this.next = next;
 *    this.random = random;
 * };
 */

/**
 * @param {Node} head
 * @return {Node}
 */
var copyRandomList = function(head) {
    if(head === null) return null;
    let curr = head;
    while(curr !== null) {
        let node = new Node(curr.val,curr.next,null);
        curr.next = node;
        curr = curr.next.next;
    }
    
    curr = head;
    while(curr !== null) {
        if(curr.random) {
            curr.next.random = curr.random.next;
        }
        curr = curr.next.next;
    }
    
    let p1 = head;
    let p2 = head.next;
    let head2 = p2;
    
    while(p1 !== null) {
        console.log(p1.val, p2.val);
        p1.next = p2.next;
        if (p2.next !== null) {
            p2.next = p2.next.next;
        } 
        p1 = p1.next;
        p2 = p2.next;
    }
    return head2;
};