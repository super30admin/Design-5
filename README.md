# Design-5

## Problem 1: 
This problem was asked at Intuit

Design a parking lot system where you need to provide a token with the parking space number on it to each new entry for the space closest to the entrance. 
When someone leave you need update this space as empty. 
What data structures will you use to perform the closest empty space tracking, plus finding what all spaces are occupied at a give time.


In this problem we will have to place vehicles in the spot closest to the entrance. We will have different floors to park the vehicle and a matrix grid to store the parked and unparked spots. In the class ParkingSpot we will have getter and setter for the floor and in the ParkingLot class we will have a Priority Queue where we will apply heapify function to get to the nearest available position in O(logn) time. In the priority queue, smallar floor number gets the higher priority and if the floors are same then parking will be done according to the spots. There might be a chance that particular parking spot have a fire exit or something. So, in order to take care of that we are adding the parking spots in a parking lot class. Here we will have 10 floor parking lot and every floor will have 20 spots. Then we will add parking spots at particular places only. If the number of floor or spot is greater than maximum limit we will throw exception here. All these spots are being added in the priority queue itself to simply heap function. Then we will move on to park function. To get the optimal parking spot we will just have to peek into the priority queue as the most optimal spot will be at the top of the priority queue. Once we get the element from peek then we will just call get spot and floor to give the exact spot to the customer. If the priority queue is empty we will throw an exception saying parking lot is full. For unparking all we need to do is put that spot back inside the priority queue. This will be the whole idea behind the parking lot.



## Problem 2: Copy List with Random Pointer

https://leetcode.com/problems/copy-list-with-random-pointer/

Explain approach in 3 lines: In this solution we are creating a deep copy of a linked list where each node has a random pointer in addition to next pointer. We are using hash map to store the mappings between the original nodes and their corresponding copied nodes. During the traversal, for each node we are either retriving or creating the corresponding copied node and linking the next and random pointers accordingly.

Time complexity: O(n) where n is number of nodes in the linked list.

Space complexity: O(n) as we are storing 1:1 mapping in hashmap.

Approached Code: 

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
        HashMap<Node, Node> map = new HashMap<>();

        if(head == null) return null;

        Node copyHead = new Node(head.val);
        map.put(head, copyHead);

        Node curr = head;
        Node copyCurr = copyHead;

        // while(curr.next != null) {
        //     Node copyNode = new Node(curr.next.val);
        //     map.put(curr.next, copyNode);
        //     copyCurr.next = copyNode;
        //     curr = curr.next;
        //     copyCurr = copyCurr.next;
        // }

        // curr = head;
        // copyCurr = copyHead;

        while(curr != null) {
            copyCurr.next = clone(curr.next, map);

            if(curr.random != null) {
                // copyCurr.random = map.get(curr.random);
                copyCurr.random = clone(curr.random, map);
            }
            curr = curr.next;
            copyCurr = copyCurr.next;
        }

        // return copyHead;
        return map.get(head);
    }

    private Node clone (Node node, HashMap<Node, Node> map) {
        if(node == null) return null;
        
        if(map.containsKey(node)) {
            return map.get(node);
        }

        Node newNode = new Node(node.val);
        map.put(node, newNode);

        return newNode;
    }
}