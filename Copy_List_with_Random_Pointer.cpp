/*
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
*/

// Appraoch 1
// Time Complexity - O(n)
// Space Complexity - O(n)
class Solution {
    Node* clone(Node* n, unordered_map<Node*, Node*>& myMap){
        if(!n)
            return n;
        if(myMap.count(n))
            return myMap[n];
        Node* newNode = new Node(n->val);
        myMap[n] = newNode;
        return newNode;
    }
public:
    Node* copyRandomList(Node* head) {
        unordered_map<Node*, Node*> myMap;
        Node* clonedH = clone(head, myMap);
        Node* curr = head;
        Node* clonedCurr = clonedH;
        
        while(curr){
            clonedCurr->next = clone(curr->next, myMap);
            if(curr->random)
                clonedCurr->random = clone(curr->random, myMap);
            curr = curr->next;
            clonedCurr = clonedCurr->next;
        }
        return clonedH;
    }
};


// Appraoch 2
// Time Complexity - O(n)
// Space Complexity - O(1)
class Solution {
public:
    Node* copyRandomList(Node* head) {
        if(!head)
            return head;
        Node* curr = head;
        while(curr){
            Node* c = new Node(curr->val);
            c->next = curr->next;
            curr->next = c;
            curr = curr->next->next;
        }
        
        curr = head;
        while(curr){
            if(curr->random)
                 curr->next->random = curr->random->next;
            curr = curr->next->next;
        }
        
        curr = head;
        Node* copyCurr = head->next;
        Node* copyHead = copyCurr;
        while(curr){
            curr->next = curr->next->next;
            if(copyCurr->next)
                copyCurr->next = copyCurr->next->next;
            curr = curr->next;
            copyCurr = copyCurr->next;
        }
        return copyHead;
    }
};