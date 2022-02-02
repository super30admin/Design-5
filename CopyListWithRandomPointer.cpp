//Time Complexity O(n)
// Space Complexity O(n)
//Problem successfully executed on leetcode
//No problems faced while coading this.


#include<iostream>
#include<vector>
#include<queue>
#include<map>
#include<stack>
using namespace std;


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


class Solution {
public:
    Node* copyRandomList(Node* head) {
        if(head==NULL) return NULL;
        Node* current=head;
        while(current != NULL)
        {
            Node* copyNode= new Node(current->val);
            copyNode->next = current->next;
            current->next=copyNode;
            current = copyNode->next;
        }
        current=head;
        
        while(current!=NULL)
        {
            if(current->random!=NULL)
            {
                (current->next)->random = (current->random)->next;
            }
            current=(current->next)->next;
        }
        
        current=head;
        Node* cpyHead=head->next;
        Node* cpyCurrent=cpyHead;
        
        while(current!=NULL)
        {
            current->next = cpyCurrent->next;
            if(cpyCurrent->next==NULL)
                break;
            cpyCurrent->next = (cpyCurrent->next)->next;
            cpyCurrent=cpyCurrent->next;
            current=current->next;
        }
        return cpyHead;
    }
};