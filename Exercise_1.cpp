/* 
    Approach 1 - using Map

    Time Complexity                              :  O(2*N) ~= O(N) where N is the number of nodes in the linked list
    Space Complexity                             :  O(N) in the hashmap
    Did this code successfully run on Leetcode   :  Yes
    Any problem you faced while coding this      :  No

    Approach 2 - using SameList

    Time Complexity                              :  O(3*N) ~= O(N) due to the 3 loops
    Space Complexity                             :  O(1)
    Did this code successfully run on Leetcode   :  Yes
    Any problem you faced while coding this      :  No
*/

#include <bits/stdc++.h> 
using namespace std;  


// https://leetcode.com/problems/copy-list-with-random-pointer/


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
        // return usingMap(head);
        return usingSameList(head);
    }
    
    Node* usingMap(Node* head) {
        unordered_map<Node*, Node*> mp;
        mp.clear();

        Node *s = head;
        Node *head2 = new Node(s->val);
        Node *s2 = head2;
        
        while(s != NULL) {
            mp[s] = s2;
            s = s->next;
            if(s != NULL) {
                s2->next = new Node(s->val);
                s2 = s2->next;
            }
        }
        
        s = head;
        s2 = head2;
        while(s != nullptr) {
            if(s->random != nullptr) {
                Node *ran = s->random;
                s2->random = mp[ran];
            }
            s = s->next;
            s2 = s2->next;
        }
        
        
        return head2;
    }
    
    
    
    Node* usingSameList(Node *head) {
        if(!head) return nullptr;
        Node *start = head;
        while(start) {
            Node *temp = start->next;
            start->next = new Node(start->val);
            start->next->next = temp;
            start = start->next->next;
        }
        start = head;
        while(start) {
            if(start->random != nullptr)
                start->next->random = start->random->next;
            start = start->next->next;
        }
        
        start = head;
        Node *head2 = head->next;
        while(start) {
            Node *temp = start->next;
            start->next = temp->next;
            if(temp->next != NULL)
            temp->next = temp->next->next;
            start = start->next;
        }
        
        return head2;
    }
};


