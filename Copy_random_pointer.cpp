// Time Complexity: O(n), 3 passes
// Space Complexity: O(1), no extra space used
// Did the code run successfully? Yes

//Approach: 
//1. Create a copy of each node and insert it right after the original node.
//2. Set the random pointer of the copied nodes.
//3. Separate the original and copied nodes to restore the original list and extract the copied list.

class Solution {
public:
    Node* copyRandomList(Node* head) {
        if(head == nullptr){
            return nullptr;
        }
        //1 -> 1' -> 2 -> 2' -> 3 -> 3'
        Node* current = head;
        while(current != nullptr){
            Node* copy = new Node(current -> val);
            copy -> next = current -> next;
            current -> next = copy;
            current = copy -> next;
        }
        //Random pointers in copy
        current = head;
        while(current != nullptr){
            if(current -> random != nullptr){
                current -> next -> random = current -> random -> next;
            }
            current = current -> next -> next;
        }
        //Severe the links
        Node* original = head;
        Node* copy_head = head -> next;
        Node* copy = copy_head;
        while(original != nullptr) {
            original -> next = original -> next -> next;
            if(copy -> next != nullptr){
                copy -> next = copy -> next -> next;
            }
            original = original -> next;
            copy = copy -> next;
        }
        return copy_head;
    }
};