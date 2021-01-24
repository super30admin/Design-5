// Time Complexity : O(N)
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

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

class Solution {
    unordered_map<Node*, Node*> map;
public:
    Node* copyRandomList(Node* head) {
        if(head == NULL){
            return head;
        }
        Node *curr = head;
        Node *newList = clone(head);
        Node *newHead = newList;
        while(curr!= NULL){
            newList->next = clone(curr->next);
            newList->random = clone(curr->random);
            curr = curr->next;
            newList = newList->next;
        }
        return newHead;
    }
    
    Node* clone(Node* head){
        if(head == NULL){
            return head;
        }
        if(map.find(head)!=map.end()){
            return map[head];
        }
        Node *newNode = new Node(head->val);
        map.insert(pair<Node*, Node*>(head, newNode));
        return newNode;
    }
};


// Time Complexity : O(N)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

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

class Solution {
public:
    Node* copyRandomList(Node* head) {
        if(head == NULL){
            return head;
        }
        
        Node* curr = head;
        while(curr!=NULL){
            Node *temp = curr -> next;
            curr->next = new Node(curr->val);
            curr->next->next = temp;
            curr = curr->next->next;
        }
        curr = head;
        while(curr!=NULL){
            if(curr->random != NULL){
                curr->next->random = curr->random->next;
            }
            curr = curr->next->next;
        }
        curr = head;
        Node *newList = curr->next;
        Node *newHead = newList;
        while(curr!=NULL){
            curr->next = curr->next->next;
            if(newList->next !=NULL){
                newList->next = newList->next->next;
            }
            curr = curr->next;
            newList = newList->next;
        }
        return newHead;
    }
};
