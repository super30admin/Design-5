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
//time: O(n)
//space: O(1)
class Solution {
public:
    Node* copyRandomList(Node* head) {
        if(head == NULL) return NULL;
        Node* ptr = head;
        while(ptr != NULL) {
            Node* copyNode = new Node(ptr -> val);
            copyNode -> next = ptr -> next;
            ptr -> next = copyNode;
            ptr = ptr -> next -> next;
        }
        ptr = head;
        while(ptr != NULL) {
            if(ptr -> random != NULL) {
                ptr -> next -> random = ptr -> random -> next;
            }
            ptr = ptr -> next -> next;
        }
        ptr = head;
        Node* result = head -> next;
        Node* copyPtr = result;
        while(ptr != NULL) {
            ptr -> next = copyPtr -> next;
            ptr = ptr -> next;
            if(ptr != NULL) {    
                copyPtr -> next = ptr -> next;
                copyPtr = copyPtr -> next;
            }    
        }
        return result;
    }
};