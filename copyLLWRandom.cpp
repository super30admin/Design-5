O(N) time and space

class Solution {
public:
    unordered_map<Node*,Node*> m;
    Node* copyRandomList(Node* head) {
        if(head==NULL) return NULL;
        Node* deepHead = clone(head);
        Node* curr = head;
        Node* deepCurr = deepHead;
        while(curr!=NULL){
            deepCurr->next = clone(curr->next);
            deepCurr->random = clone(curr->random);
            curr= curr->next;
            deepCurr = deepCurr->next;
        }
        return deepHead;
    }
    
    Node* clone(Node* node){
        if(node==NULL) return NULL;
        if(m.find(node)!=m.end()) return m[node];
        Node* newNode = new Node(node->val);
        m[node] = newNode;
        return newNode;
    }
};


O(N) time, O(1) space
class Solution {
public:
    Node* copyRandomList(Node* head) {
        if(head==NULL) return NULL;
        Node *curr = head;
        //Step 1 - put deep copy nodes next to original nodes
        while(curr!=NULL){
            Node* newNode = new Node(curr->val);
            newNode->next = curr->next;
            curr->next = newNode;
            curr = curr->next->next;
        }
        curr = head;
        //Step 2 - Make random pointers for deep copy nodes
        while(curr!=NULL){
            if(curr->random!=NULL){
                curr->next->random = curr->random->next;
            }
            curr=curr->next->next;
        }
        //Step 3 - Seperate the two lists
        curr = head;
        Node *deepHead = head->next;
        Node *deepCurr = deepHead;
        while(curr!=NULL && curr->next->next!=NULL){
            curr->next = curr->next->next;
            deepCurr->next = deepCurr->next->next;
            curr=curr->next;
            deepCurr = deepCurr->next;
        }
        //Manipulating last links
        curr->next=curr->next->next;
        deepCurr->next=NULL;
        return deepHead;
    }
};
