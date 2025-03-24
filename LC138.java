import java.util.HashMap;

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

// Approach: Using HashMap
// Time Complexity: O(N)
// Space Complexity: O(N)

public class LC138 {
    public Node copyRandomList(Node head) {
        if(head==null) return null;
        HashMap<Node, Node> map = new HashMap<>();
        Node temp = head;
        while(temp!=null){
            map.put(temp, new Node(temp.val));
            temp = temp.next;
        }

        Node ans = new Node(-1);
        Node ptr = ans;
        temp = head;
        while(temp!=null){
            ptr.next = map.get(temp);
            ptr = ptr.next;
            if(temp.random!=null) ptr.random = map.get(temp.random);
            temp = temp.next;
        }
        return ans.next;
    }
}

// Approach: Without using HashMap
// Time Complexity: O(N)
// Space Complexity: O(1)

class LC138_1 {
    public Node copyRandomList(Node head) {
        if (head == null)
            return null;
        Node temp = head;
        while (temp != null) {
            Node nxt = new Node(temp.val);
            nxt.next = temp.next;
            temp.next = nxt;
            temp = nxt.next;
        }

        temp = head;
        while (temp != null) {
            Node nxt = temp.next;
            if (temp.random != null)
                nxt.random = temp.random.next;
            temp = temp.next.next;
        }

        Node ans = new Node(-1);
        Node ptr = ans;
        temp = head;
        while (temp != null) {
            ptr.next = temp.next;
            ptr = ptr.next;
            temp.next = temp.next.next;
            temp = temp.next;
        }

        return ans.next;
    }
}