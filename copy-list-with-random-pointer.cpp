// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes

#include <unordered_map>
  
using namespace std;

class Node {
public:
    int val;
    Node* next;
    Node* random;

    Node(int _val) : val(_val), next(nullptr), random(nullptr) {}
};

class Solution {
public:
    Node* copyRandomList(Node* head) {
        if (head == nullptr) {
            return nullptr;
        }

        std::unordered_map<Node*, Node*> nodeMap;

        // First pass: create the copy of each node without random pointers
        Node* current = head;
        while (current != nullptr) {
            nodeMap[current] = new Node(current->val);
            current = current->next;
        }

        // Second pass: link the copy's next and random pointers
        current = head;
        while (current != nullptr) {
            nodeMap[current]->next = nodeMap[current->next];
            nodeMap[current]->random = nodeMap[current->random];
            current = current->next;
        }

        // Return the head of the copied linked list
        return nodeMap[head];
    }
};
