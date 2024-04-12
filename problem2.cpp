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
        if(head == NULL) return NULL;
        Node* curr = head;
        while(curr != NULL){
            Node* temp = new Node(curr->val);
            temp->next = curr->next;
            curr->next = temp;
            curr = temp->next;
        }
        curr = head;
        while(curr != NULL){
            if(curr->random != NULL)
                curr->next->random = curr->random->next;
            curr = curr->next->next;
        }
        curr = head;
        Node* tempHead = curr->next;
        Node* temp = curr->next;
        while(curr != NULL){
            curr->next = temp->next;
            curr = curr->next;
            if(curr != NULL)
                temp->next = curr->next;
            temp = temp->next;
        }

        return tempHead;
    }
};
