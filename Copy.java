//  TC - O(n)
// SC - O(n)
/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        if(head == null) return null;
        HashMap<Node, Node> map = new HashMap();
        Node cur = head;
        Node newH = new Node(cur.val);
        Node cur1 = newH;
        map.put(cur, newH);
        while(cur!=null){
            if(map.containsKey(cur.random)){
                newH.random = map.get(cur.random);
            }
            else{
                if(cur.random!=null){
                Node temp = new Node(cur.random.val);
                newH.random = temp;
                map.put(cur.random, newH.random);
                }
                else
                newH.random = null; 
            }
            if(map.containsKey(cur.next)){
                newH.next = map.get(cur.next);
            }
            else{
                if(cur.next!=null){
                Node temp = new Node(cur.next.val);
                newH.next = temp;
                                            //System.out.println(newH.val);

                map.put(cur.next, newH.next);
                }
                else
                newH.next = null;
            }
            //newH.next = new Node(cur.next.val);
            //newH.random = new Node(newH.val);
            
            newH = newH.next;

            cur = cur.next;
        }
        
        return cur1;
        
    }
}