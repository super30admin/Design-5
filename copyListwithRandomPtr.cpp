// Time Complexity : O(n)
// Space Complexity : O(n) map of n nodes
// Did this code succesfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// 1. Iterate through original list using next pointers and create deep copy
// 2. During that create a map with a mapping from old node to its deep copy node
// 3. Iterate through original list using random pointers and use the map to find the deep copy nodes in O(1) 
 
class Solution {
public:
    Node* copyRandomList(Node* head) {
        if(head == nullptr)
            return nullptr;
        Node* orig = head;
        Node* newHead = head;
        Node* curr = nullptr;
        Node* prev = nullptr;
        map<Node*, Node*> nodes;
        // assigning all nexts in O(n) 
        while(head!=nullptr){
            curr = new Node(head->val);
            // for start of list
            if(head==orig)
                newHead = curr;
            if(prev)
                prev->next = curr;
            nodes[head] = curr;
            prev = curr;
            head = head->next;
        }
        curr->next = nullptr;
        
        // assigning all randoms in O(n)
        while(orig!=nullptr){
            Node* temp = orig->random;
            if(temp == nullptr)
                nodes[orig]->random = nullptr;
            else
                nodes[orig]->random = nodes[temp];
            orig = orig->next;
        }
        
        
        return newHead;
    }
};