//time: O(n)
//space O(1)


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
        if (head == nullptr) 
        return nullptr;
        
        unordered_map<Node*, Node*> Map;
        Node* curr = head;

        while (curr != nullptr) {
            Map[curr] = new Node(curr->val);
            curr = curr->next;
        }

        curr = head;
        while (curr != nullptr) {
            Map[curr]->next = Map[curr->next];
            Map[curr]->random = Map[curr->random];
            curr = curr->next;
        }

        return Map[head];
        
    }
};