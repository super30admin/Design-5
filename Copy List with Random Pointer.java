//time Complexity : O(n)
//Space Complexity : O(1)
class Solution {
    public Node copyRandomList(Node head) {
        if(head == null){
            return null;
        }
        Node cur = head;
        while(cur != null){
            Node curCopy = new Node(cur.val);
            curCopy.next = cur.next;
            cur.next = curCopy;
            cur = cur.next.next;
        }
        cur = head;
        //random pointers are being set
        while(cur != null){
            if(cur.random != null){
                cur.next.random = cur.random.next;
            }
            cur = cur.next.next;
        }
        cur = head;
        Node copyHead = cur.next;
        Node curCopy = copyHead;
        //Disconnecting the original list from copyList
        while(cur!=null){
            cur.next = cur.next.next;
            if(curCopy.next != null){
                curCopy.next = curCopy.next.next;
            }
            cur = cur.next;
            curCopy = curCopy.next;
        }
        return copyHead;
    }
}
/*
//HashMap approach
//Time Complexity : O(n)
//Space Complexity : O(n)
class Solution {
    HashMap<Node,Node> map;
    public Node copyRandomList(Node head) {
        if(head == null){
            return null;
        }
        map = new HashMap<>();
        Node cur = head;
        //create a copy of the node
        Node copyHead = clone(cur);
        Node curCopy = copyHead;
        while(cur!=null){
            //copy of next 
            curCopy.next = clone(cur.next);
            //copy of random
            curCopy.random = clone(cur.random);
            cur = cur.next;
            curCopy = curCopy.next;
        }
        return copyHead;
    }
    //method to create a new copy
    public Node clone(Node cur){
        if(cur == null){
            return cur;
        }
        //if map contains the cur node then return its copy
        if(map.containsKey(cur)){
            return map.get(cur);
        }
        //otherwie create its copy and add it to map
        Node newNode = new Node(cur.val);
        map.put(cur,newNode);
        return newNode;
    }
}