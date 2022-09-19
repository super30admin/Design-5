// Time complexity: O(n)
// Space Complexity: O(n)
class Solution {
    public Node copyRandomList(Node head) {
        if(head==null) return null;
        Node temp = head;
        HashMap<Node,Node> map = new HashMap<>();
        //building the map
        while(temp!=null){
            map.put(temp,new Node(temp.val));
            temp=temp.next;
        }
        temp=head;
        Node a =new Node(0);
        Node tempa = a;
        while(temp!=null){
            tempa.next=map.get(temp);
            tempa=tempa.next;
            tempa.random=map.get(temp.random);
            temp=temp.next;
        }
        return a.next;
    }
}
