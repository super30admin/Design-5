class Solution {
    //Time Complexity:O(n)
    //Space Complexity:O(n)
    
    public Node copyRandomList(Node head) {
        
        HashMap <Node, Node> map = new HashMap<>();
        Node track = head;

        while (track != null ){
            Node node = new Node (track.val);
            map.put (track, node);
            track = track.next;
        }
        track = head;

        while (track != null ){
            map.get(track).next = map.get(track.next);
            track = track.next;
        }
        track = head;
         while (track != null ){
            map.get(track).random = map.get(track.random);
            track = track.next;
        }
        return map.get(head);
    }

