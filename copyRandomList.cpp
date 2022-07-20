// Time Complexity : O(n) 
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes

// Three line explanation of solution in plain english
/* Perfomr three pass operation :-
 *  1. Duplicate each node in the list and insert next to current node and its next node.
 *  2. Create random pointer links to duplicate nodes.
 *  3. Separate original and duplicate list.
 */

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
        if (head == NULL)
        {
            return NULL;
        }
        
        // 1. Insert copy nodes.
        Node* curr = head;
        while (curr != NULL)
        {
            Node* newNode = new Node(curr->val);
            newNode->next = curr->next;
            curr->next = newNode;
            curr = newNode->next;
        }
        
        //2. Create random pointers
        curr = head;
        while (curr != NULL)
        {
            if (curr->random != NULL)
            {
                curr->next->random = curr->random->next;
            }
            
            curr = curr->next->next;
        }
        
        //3. Separate lists
        curr = head;
        Node* copyHead = head->next;
        Node* copyCurr = head->next;
        
        while (curr != NULL)
        {
            curr->next = curr->next->next;
            
            if (curr->next == NULL)
            {
                break;
            }
            
            copyCurr->next = copyCurr->next->next;
            curr = curr->next;
            copyCurr = copyCurr->next;
        }
        
        return copyHead;
    }
};