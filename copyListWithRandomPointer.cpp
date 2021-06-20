/*
The idea is to keep a track of all the deep copies created so that we dont lose reference to it.
///////////////////////////////////////////
Solution 1: Can be done with map
Time Complexity : O(N), Total number of nodes
Space Complexity : O(N), Total number of nodes
///////////////////////////////////////////
Solution 2: Without Map
Time Complexity : O(N), Total number of nodes
Space Complexity : O(1)
///////////////////////////////////////////

*/
class Solution {
public:
    map<Node*, Node*> map;
    Node* copyRandomList(Node* head) {
        Node* copyHead = getClone(head);
        Node* currCopy = copyHead;
        Node* curr = head;
        while( curr != NULL){
            currCopy->next = getClone(curr->next);
            currCopy->random = getClone(curr->random);
            curr = curr->next;
            currCopy = currCopy->next;
        }
        return copyHead;
    }
    
    Node* getClone(Node* node){
        if ( node == NULL) return NULL;
        if ( map.find(node) != map.end()){
            return map[node];
        }
        else{
            Node* newNode = new Node(node->val);
            map.insert({node, newNode});
            return newNode;
        }
    }
};


class Solution {
public:
    Node* copyRandomList(Node* head) {
        Node* curr = head;
        if( head == NULL) return NULL;
        while ( curr != NULL){
            Node* newNode = new Node(curr->val);
            newNode->next = curr->next;
            curr->next = newNode;
            curr = curr->next->next;
        }

        curr = head;
        while ( curr != NULL){
            if (curr->random != NULL)
            curr->next->random = curr->random->next;
            curr = curr->next->next;
        }
        curr = head;
        Node* copyHead = curr->next;
        Node* currCopy = copyHead; 
        while ( curr != NULL){
            curr->next = curr->next->next;
            if ( currCopy->next != NULL)
            currCopy->next = currCopy->next->next;
            curr = curr->next;
            currCopy = currCopy->next;
        }
        return copyHead;
        
    }
};