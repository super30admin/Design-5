func main() {
    pl := NewParkingLot(10,20)
    pl.addParkingSpot(1,1)
    pl.addParkingSpot(2,1)
    pl.addParkingSpot(3,1)
    pl.addParkingSpot(1,2)
    pl.addParkingSpot(2,2)
    pl.addParkingSpot(3,2)
    nextAvailSpot := pl.getNextAvail()
    fmt.Println("NextAvail: ", nextAvailSpot.floor,nextAvailSpot.spot)
    
    parkedAt := pl.park()
    fmt.Println("Parked at: ", parkedAt.floor, parkedAt.spot)
    
    nextAvailSpot = pl.getNextAvail()
    fmt.Println("NextAvail: ", nextAvailSpot.floor,nextAvailSpot.spot)

    
    
}



type parkingLot struct {
    totalFloors int // row
    spotsPerFloor int // col
    mh *minHeap
}

type parkingSpot struct {
    floor int // row
    spot int // col
}


func NewParkingLot(floors, spotsPerFloor int) *parkingLot {    
    return &parkingLot{
        totalFloors: floors,
        spotsPerFloor: spotsPerFloor,
        mh: &minHeap{items: []*parkingSpot{}},
    }
}

func (p *parkingLot) addParkingSpot(floor, spot int) {
    if floor > p.totalFloors || spot > p.spotsPerFloor {
        panic("Parking spot position out of bounds")
    }
    heap.Push(p.mh, &parkingSpot{floor: floor, spot: spot})
}

func (p *parkingLot) park() *parkingSpot {
    if p.isFull() {
        panic("Out of parking spots...")
    }
    ps := heap.Pop(p.mh).(*parkingSpot)
    return ps
}

func (p *parkingLot) unpark(floor, spot int) {
    heap.Push(p.mh, &parkingSpot{floor: floor, spot: spot})
}

func (p *parkingLot) getNextAvail() *parkingSpot {
    return p.mh.items[0]
}

func (p *parkingLot) isFull() bool {
    return p.mh.Len() == p.totalFloors * p.spotsPerFloor
}





// implements container heap interface : https://pkg.go.dev/container/heap#Interface
type minHeap struct {
	items []*parkingSpot
}

func (m *minHeap) Len() int {return len(m.items)}
func (m *minHeap) Less(i, j int) bool {
    if m.items[i].floor == m.items[j].floor {
        return m.items[i].spot < m.items[j].spot
    }
    return  m.items[i].floor < m.items[j].floor
}
func (m *minHeap) Swap(i, j int) { m.items[i],m.items[j] = m.items[j], m.items[i]}
func (m *minHeap) Push(x interface{}) {m.items = append(m.items, x.(*parkingSpot))}
func (m *minHeap) Pop() interface{} {
	i := m.items[len(m.items)-1]
	m.items = m.items[:len(m.items)-1]
	return i
}
