// Time Complexity : O(3N)

// Space Complexity : O(1) - since the answer is stored as a LL

// Did this code successfully run on Leetcode : Yes

// Appoarch: 3 main steps:
// 1. Create a new node next to the original node
// 2. Create random connections between them
// 3. Connect next pointers by disconnecting new ones. 

// 138. Copy List with Random Pointer

#include <bits/stdc++.h>
using namespace std;

// Definition for a Node.
class Node {
public:
    int val;
    Node* next;
    Node* random;
    
    Node(int _val) {
        val = _val;
        next = NULL;
        random = NULL;
    }
};

class Solution {
public:
    // Create new nodes in between
    void insertCopyInBetween(Node* head){
        Node* temp = head;
        while(temp != NULL){
            Node* nextLink = temp->next;
            Node* copyNode = new Node(temp->val);
            copyNode->next = nextLink;
            temp->next = copyNode;
            temp = nextLink;
        }
    }
    // create random connections
    void connectRandomPointers(Node* head){
        Node* temp = head;
        while(temp != NULL){
            Node* copyNode = temp->next;
            if(temp->random){
                copyNode->random = temp->random->next;
            }
            else{
                copyNode->random = NULL;
            }
            temp = temp->next->next;
        }
    }
    // disconnect new connections to get back old LL
    Node* getDeepCopyList(Node* head){
        Node* temp = head;
        Node* dNode = new Node(-1);
        Node* res = dNode;
        while(temp != NULL){
            // creating new list
            res->next = temp->next;
            res = res->next;
            // disconnecting new link to get back original LL
            temp->next = temp->next->next;
            temp = temp->next;
        }
        return dNode->next;
    }

    Node* copyRandomList(Node* head) {
        insertCopyInBetween(head);
        connectRandomPointers(head);
        return getDeepCopyList(head);
    }
};