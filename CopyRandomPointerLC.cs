using System;
using System.Collections.Generic;
using System.Text;

namespace Design
{
    class CopyListWithRandomPointersLC
    {
        //Definition for a Node
        public class Node
        {
            internal int val;
            internal Node next;
            internal Node random;

            public Node(int val)
            {
                this.val = val;
                this.next = null;
                this.random = null;
            }
        }
        //TC:O(n)
        //SC:O(n)
        Dictionary<Node, Node> map;
        public Node CopyRandom(Node head)
        {
            if (head == null)
            {
                return null;
            }
            map = new Dictionary<Node, Node>();
            Node copyHead = clone(head);
            Node curr = head;
            map.Add(head, copyHead);
            while (curr != null)
            {
                Node copyNext = clone(curr.next);
                Node copyRandon = clone(curr.random);
                copyHead.next = copyNext;
                copyHead.random = copyRandon;
                copyHead = copyHead.next;
                curr = curr.next;
            }
            return map[head];
        }
        private Node clone(Node node)
        {
            if (node == null) return null;
            if (map.ContainsKey(node)) return map[node];
            Node copyNode = new Node(node.val);
            map.Add(node, copyNode);
            return copyNode;
        }

        //TC:O(n)
        //SC:O(1)
        public Node CopyRandomOptimized(Node head)
        {
            if (head == null)
            {
                return null;
            }
            //Step1: Creating a copy and joining the same
            Node curr = head;
            while (curr != null)
            {
                Node currCopy = new Node(curr.val);
                currCopy = curr.next;
                curr.next = currCopy;
                curr = curr.next.next;
            }
            //Step2: Setting the random pointers
            curr = head;
            while (curr != null)
            {
                if (curr.random != null)
                {
                    curr.next.random = curr.random.next;
                }
                curr = curr.next.next;
            }
            //Step3: Split the two lists into individual lists
            curr = head;
            Node copyHead = curr.next;
            Node currCopy2 = curr.next;
            while (curr != null)
            {
                curr.next = curr.next.next;
                if (currCopy2.next != null)
                {
                    currCopy2.next = currCopy2.next.next;
                }
                curr = curr.next;
                currCopy2 = currCopy2.next;
            }
            return copyHead;
        }
    }
}
