//Time - O(n)
//Space - O(n)
class Solution {
public:
    Node* copyRandomList(Node* head) {
        unordered_map<Node*, Node*> umap;
        Node* h1 = head, *h2 = new Node(0), *h3 = h2,*h4 = h2;
        
        while(h1!=NULL){
            h2->next = new Node(h1->val);
            umap[h1] = h2->next;
            h1 = h1->next;
            h2 = h2->next;
        }
        
        h3 = head;
        
        while(h3!=NULL){
            umap[h3]->random = umap[h3->random];
            h3 = h3->next;
        }
        
        return h4->next;
        
    }
};