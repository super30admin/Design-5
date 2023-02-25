func main() {
    lot := NewParkingLot()
    lot.AddSpot(2,1)
    lot.AddSpot(1,1)
    lot.AddSpot(3,3)
    lot.AddSpot(1,3)
    lot.AddSpot(1,0)
    
    fmt.Println(lot.Park()) // 1,0
    fmt.Println(lot.Park()) // 1,1
    fmt.Println(lot.Park()) // 1,3
    lot.Unpark(1,0)
    fmt.Println(lot.Park()) // 1,0
    fmt.Println(lot.Park()) // 2,1
    fmt.Println(lot.Park()) // 3,3
    
//     fmt.Println(lot.Park()) // Parking lot is full ( panic )
    
    lot.Unpark(1,1)
    fmt.Println(lot.Park()) // 1,1
    
    
    
}


type parkingLot struct {
    spotPq *minHeap
}

func NewParkingLot() *parkingLot {
    return &parkingLot{spotPq: &minHeap{items: [][]int{}}}
}

func (this *parkingLot) AddSpot(floor, spot int) { heap.Push(this.spotPq, []int{floor, spot}) }

func (this *parkingLot) Park() (int, int) {
    if this.spotPq.Len() == 0 {
        panic("parking lot is full")
    }
    spot := heap.Pop(this.spotPq).([]int)
    return spot[0], spot[1]
}

func (this *parkingLot) Unpark(floor, spot int) {
    heap.Push(this.spotPq, []int{floor,spot})
}

type minHeap struct {items [][]int}
func (m *minHeap) Less(i, j int) bool { 
    iFloor := m.items[i][0]
    jFloor := m.items[j][0]
    if iFloor == jFloor {
        // sort by spot
        return m.items[i][1] < m.items[j][1]
    }
    return iFloor < jFloor
}
func (m *minHeap) Swap(i, j int)  { m.items[i], m.items[j] = m.items[j], m.items[i] }
func (m *minHeap) Len() int  { return len(m.items) }
func (m *minHeap) Push(x interface{}) { m.items = append(m.items, x.([]int)) }
func (m *minHeap) Pop() interface{} {
    out := m.items[len(m.items)-1]
    m.items = m.items[:len(m.items)-1]
    return out
}
