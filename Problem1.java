// https://leetcode.com/problems/copy-list-with-random-pointer/
// Time complexity : O(N)
// Space complexity : O(N)


class Solution {
    public Node copyRandomList(Node head) {
        HashMap<Node,Node> map = new HashMap<>();
        Node temp = head;
        while(head != null){
            clone(head,map);
            head = head.next;
        }
        
        head = temp;
        while(head != null){
            map.get(head).next = map.get(head.next);
            map.get(head).random = map.get(head.random);
            head = head.next;
        }        
        return map.get(temp);
       
    }
    public void clone(Node node,HashMap<Node,Node> map){
        if(node != null)
            map.computeIfAbsent(node,k-> new Node(k.val));
    }
}