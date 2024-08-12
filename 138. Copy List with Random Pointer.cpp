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
        //edge case
        if(head==nullptr)  return head;

        unordered_map<Node*, Node*> m;
        auto new_head = new Node(head->val);

        auto h = head->next;
        auto hh = new_head;
        
        m[head] = new_head;
        while(h != nullptr){
            hh->next = new Node(h->val);
            hh = hh->next;

            m[h] = hh;

            h = h->next;
        }

        h = head;
        hh = new_head;

        while(h != nullptr){
            if(h->random == nullptr){
                hh->random = nullptr;
            }
            //else if(m.count(h->random)){
                hh->random = m[h->random];
            //}
            //else{
            //    hh->random = new_head;
            //}

            h = h->next;
            hh = hh->next;
            
        }

        return new_head;
    }
};
