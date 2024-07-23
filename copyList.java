/*
 * // Definition for a Node.
 * class Node {
 * int val;
 * Node next;
 * Node random;
 * 
 * public Node(int val) {
 * this.val = val;
 * this.next = null;
 * this.random = null;
 * }
 * }
 */

/*
 * 
 * class Solution {
 * public Node copyRandomList(Node head) {
 * //Tc: O(n) Sc: O(1)
 * if (head == null)
 * return null;
 * 
 * // Create new list with same values
 * Node cur = head;
 * while (cur != null) {
 * Node newNode = new Node(cur.val);
 * newNode.next = cur.next;
 * cur.next = newNode;
 * cur = newNode.next;
 * }
 * 
 * cur = head;
 * while (cur != null) {
 * if (cur.random != null)
 * cur.next.random = cur.random.next;
 * cur = cur.next.next;
 * }
 * 
 * cur = head;
 * Node nh = head.next;
 * Node ncur = nh;
 * while (cur != null) {
 * cur.next = ncur.next;
 * cur = cur.next;
 * if (cur != null) {
 * ncur.next = cur.next;
 * ncur = ncur.next;
 * }
 * }
 * 
 * return nh;
 * }
 * }
 * 
 */