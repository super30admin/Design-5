// Time Complexity : O(1)
// Space Complexity : O(f*s)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :

// Your code here along with comments explaining your approach
/*
set max floors, slots
parking lot is a priority queue with least floor and least slot to decide

first add all available parking spots by creating and pushing into pq

get next available by peeking if valid case

park by popping closest available space

unpark by pushing back into pq
*/
package main

import (
	"container/heap"
	"errors"
	"fmt"
)

const maxFloors = 5
const maxSlotsPerFloor = 10

var pl PriorityQueue

func ParkingLotConstructor(l int) PriorityQueue {
	pq := make(PriorityQueue, l)
	heap.Init(&pq)
	return pq
}

func park() ParkingSpace {
	ps, err := getNextAvailable()
	if err != nil {
		fmt.Println("no space available")
	}
	heap.Pop(&pl)
	return ps
}

func unpark(f, s int) {
	ps, err := ParkingSpaceConstructor(f, s)
	if err != nil {
		fmt.Println("invalid")
	}
	heap.Push(&pl, ps)
}

func addParkingSpace (f, s int) {
	ps, err := ParkingSpaceConstructor(f, s)
	if err != nil {
		fmt.Println("error adding parking space")
	}
	heap.Push(&pl, &ps)
}

func getNextAvailable() (ParkingSpace, error) {
	if (&pl).Len() > 0 {
		x := heap.Pop(&pl).(*ParkingSpace)
		heap.Push(&pl, x)
		return *x, nil
	}
	return ParkingSpace{}, errors.New("not space available")
}

func MainParkingLot() {
	pl = ParkingLotConstructor(0)

	addParkingSpace(1, 1)
	addParkingSpace(2, 1)
	addParkingSpace(3, 1)
	addParkingSpace(1, 2)
	addParkingSpace(2, 2)
	addParkingSpace(3, 2)

    n, err := getNextAvailable()
    if err != nil {
    	fmt.Println("no space available")
	}
	fmt.Println("Park at Floor: ", n.Floor, ", Slot: ", n.Slot)
    park()
	n, err = getNextAvailable()
	if err != nil {
		fmt.Println("no space available")
	}
	fmt.Println("Park at Floor: ", n.Floor, ", Slot: ", n.Slot)
}

type ParkingSpace struct {
	Floor int
	Slot  int
}

func ParkingSpaceConstructor(f, s int) (ParkingSpace, error) {
	if f > maxFloors || s > maxSlotsPerFloor {
		return ParkingSpace{}, errors.New("illegal argument: capacity 5 floors, 10 slots")
	}
	return ParkingSpace{Floor: f, Slot: s}, nil
}


//PriorityQueue implementation
type PriorityQueue []*ParkingSpace

func (pq PriorityQueue) Len() int {
	return len(pq)
}

func (pq PriorityQueue) Less(a, b int) bool {
	if pq[a].Floor == pq[b].Floor {
		return pq[a].Slot < pq[b].Slot
	}
	return pq[a].Floor < pq[b].Floor
}

func (pq PriorityQueue) Swap(a, b int) {
	pq[a], pq[b] = pq[b], pq[a]
}

func (pq *PriorityQueue) Push(x interface{}) {
	item := x.(*ParkingSpace)
	*pq = append(*pq, item)
}

func (pq *PriorityQueue) Pop() interface{} {
	old := *pq
	n := len(old)
	x := old[n - 1]
	old[n - 1] = nil
	*pq = old[0:n-1]
	return x
}

/*func (pq *PriorityQueue) update(pqNode *PQNode, s, e int) {
	pqNode.Start = s
	pqNode.End = e
	heap.Fix(pq, pqNode.index)
}*/