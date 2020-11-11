//time complexity:O(n)
//space complexity:O(n)
//executed on leetcode: yes
//approach:using recursion
//any issues faced? yes, dont know the optimised version

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
    map<Node*,Node*>map;
    Node* copyRandomList(Node* head) {
        if(head==NULL)
            return NULL;
        if(map.find(head)!=map.end())
            return map[head];
        Node* node=new Node(head->val,NULL,NULL);
        map[head]=node;
        node->next=copyRandomList(head->next);
        node->random=copyRandomList(head->random);
        return node;
    }
};