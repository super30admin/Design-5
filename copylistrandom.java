/*
TC O(N)
SC O(1)
*/
class Solution {
    public Node copyRandomList(Node head) {
		
        Map<Node, Node> originalCopyMap = new HashMap<>();
        originalCopyMap.put(null, null);
        Node copyHead = new Node(10001);
        Node temp = copyHead;
        while(head != null) {
			
            Node copyNode = originalCopyMap.getOrDefault(head, null);
            if(copyNode == null) {
                copyNode = new Node(head.val);
                originalCopyMap.put(head, copyNode);
            }
            temp.next = copyNode;
            temp = temp.next;
            
            if(head.random != null) {
                Node copyRandom = originalCopyMap.getOrDefault(head.random, null);
                if(copyRandom == null) {
                    copyRandom = new Node(head.random.val);
                    originalCopyMap.put(head.random, copyRandom);
                }
                temp.random = copyRandom;
            }
            head = head.next;
        }
        return copyHead.next;  
    }
}