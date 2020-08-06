
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

// The main idea is here to create a copy of existing node next to the existing nodes and establist the next pointers and random pointers. After establishing the links, restore back the old list and new list.



//Time Complexity : O(n);
//Space Complexity :O(1)
//Did it run on leetcode : yes
class Solution {
    HashMap<Node,Node> map;
    public Node copyRandomList(Node head) {
        
        if(head == null) return null;
        
        Node ptr = head;
        
        //creating the newNode and estalbishing adjacent to same old node
        while(ptr != null){
            
            Node newNode = new Node(ptr.val);
            newNode.next = ptr.next;
            ptr.next = newNode;
            ptr = newNode.next;
            
        }
        
        //establishing the random pointer links of newList
        ptr = head;
        while(ptr != null){
          if(ptr.random!=null)
            ptr.next.random = ptr.random.next;
          else
              ptr.next.random = null;
            ptr = ptr.next.next;
            
        }
        
        Node old_head = head;
        Node new_head = head.next;
        Node new_List = head.next;
        
        //separating and restoring the linked lists
        while(old_head!=null){
            
          old_head.next = old_head.next.next;
        if(new_head.next != null)
          new_head.next = new_head.next.next;
        else 
            new_head.next = null;
          old_head  = old_head.next;
          new_head = new_head.next;
            
        }
    
        return new_List;
    }
    
   }