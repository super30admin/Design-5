#include<iostream>
#include<bits/stdc++.h>
#include<vector>
using namespace std;
class Node {
public:
    int val;
    Node* next;
    Node* random;
    
    Node(int _val) {
        val = _val;
        next = nullptr;
        random = nullptr;
    }
};
/*
First, insert deep copies of each node right next to originals.
Then, link the random pointers using the interleaved structure.
Finally, split the combined list into original and cloned lists.
*/
class Solution{
public:
    Node* copyRandomList(Node* head){
        if(!head) return nullptr;

        Node* curr = head;
        while(curr){
            Node* copyCurr = new Node(curr->val);
            copyCurr->next = curr->next;
            curr->next = copyCurr;

            curr = curr->next->next;
        }
        curr = head;
        while(curr){
            if(curr->random){
                curr->next->random = curr->random->next;
            }
            curr = curr->next->next;
        }

        curr = head;
        Node* copyCurr = curr->next;
        Node* copyHead = copyCurr;
        while(curr){
            curr->next = curr->next->next;
            if(copyCurr->next){
                copyCurr->next = copyCurr->next->next;
            }
            curr = curr->next;
            copyCurr = copyCurr->next;
        }
        return copyHead;
    }
};
