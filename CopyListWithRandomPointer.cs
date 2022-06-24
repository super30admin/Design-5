using System;
using System.Collections.Generic;


namespace Algorithms
{
    public class Node
    {
        public int val;
        public Node next;
        public Node random;

        public Node(int _val)
        {
            val = _val;
            next = null;
            random = null;
        }
    }
    /// Time Complexity : O(n)
    // Space Complexity :O(n)
    // Did this code successfully run on Leetcode :Yes
    // Any problem you faced while coding this :  Referred Online
    public class CopyListWithRandomPointer
    {
        Dictionary<Node, Node> map;
        public Node CopyRandomList(Node head)
        {
            if (head == null) return head;
            map = new Dictionary<Node, Node>();
            Node deepHead = clone(head);
            Node currCopy = deepHead;
            Node curr = head;
            while (curr != null)
            {
                currCopy.next = clone(curr.next);
                currCopy.random = clone(curr.random);
                curr = curr.next;
                currCopy = currCopy.next;
            }
            return deepHead;
        }

        private Node clone(Node node)
        {
            if (node == null) return null;
            if (map.ContainsKey(node))
            {
                return map.GetValueOrDefault(node);
            }
            Node newNode = new Node(node.val);
            map.Add(node, newNode);
            return newNode;
        }


    }
}
