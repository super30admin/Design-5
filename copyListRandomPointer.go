// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :

// Your code here along with comments explaining your approach
/*
if head is nil return nil
set copyCurr, curr to head
while curr != nil
create copyCurr with same value as curr without setting random
set copyCurr.Next to curr.Next
set curr.Next to copyCurr
move curr to curr.next.next

again loop over curr
set random value to copied elements for each, check nil condition also

again loop over curr
set curr.Next to curr.next.next
set copycurr.next = copycurr.next.net after checking nil condition
move both curr, copycurr to respective next
return copyhead
*/
package main

import "fmt"

type Node struct {
	Val int
	Next *Node
	Random *Node
}

func copyRandomList(head *Node) *Node {
	if head == nil {
		return nil
	}
	copyCurr := head
	curr := head
	for curr != nil {
		copyCurr = &Node {
			Val: curr.Val,
			Next: curr.Next,
		}
		curr.Next = copyCurr
		curr = curr.Next.Next
	}
	for curr=head;curr != nil; {
		if curr.Random == nil {
			curr.Next.Random = nil
		} else{
			curr.Next.Random = curr.Random.Next
		}
		curr = curr.Next.Next
	}
	copyHead := head.Next
	copyCurr = copyHead
	for curr=head;curr!= nil; {

		curr.Next = curr.Next.Next
		if curr.Next == nil {
			copyCurr.Next = nil
		} else {
			copyCurr.Next = copyCurr.Next.Next
		}
		curr = curr.Next
		copyCurr = copyCurr.Next
	}

	return copyHead
}

func MainCopyListRandom() {
	b := &Node{Val: 3, Next: nil,}
	a := &Node{Val: 2, Next: b,}
	head := &Node{Val: 7, Next: a, Random: nil}
	a.Random = head
	b.Random = nil
	x := copyRandomList(head)
	for curr:=x;curr!= nil; {
		fmt.Println(curr.Val)
		curr = curr.Next
	} //expected 7,2,3
}


