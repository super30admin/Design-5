## Problem 1: 
# This problem was asked at Intuit

# Design a parking lot system where you need to provide a token with the parking space number on it to each new entry for the space closest to the entrance. 
# When someone leave you need update this space as empty. 
# What data structures will you use to perform the closest empty space tracking, plus finding what all spaces are occupied at a give time.



import heapq

class ParkingSpace:
    """
    Represents an individual parking spot in the lot.
    
    Overall Space Complexity: O(1) per instance.
    """
    def __init__(self, floor: int, spot_number: int):
        self.floor = floor
        self.spot_number = spot_number

    # DUNDER METHOD: Less Than (__lt__)
    # ---------------------------------
    # Purpose: Defines custom comparison logic using the '<' operator.
    # Why it's needed: heapq (Min-Heap) uses '<' under the hood to compare objects 
    # and maintain the smallest element at the top.
    # Logic: Prioritizes lower floors first. If floors are identical, prioritizes 
    # lower spot numbers.
    # Time Complexity: O(1)
    # Space Complexity: O(1) Auxiliary Space
    def __lt__(self, other):
        if self.floor == other.floor:
            return self.spot_number < other.spot_number
        return self.floor < other.floor

    # DUNDER METHOD: Representation (__repr__)
    # --------------------------------------
    # Purpose: Controls string formatting when printing the object or displaying 
    # it inside lists/dictionaries.
    # Why it's needed: Replaces default unreadable object memory addresses 
    # (<__main__.ParkingSpace object...>) with clean human-readable output.
    # Time Complexity: O(1)
    # Space Complexity: O(1) Auxiliary Space (string output creation)
    def __repr__(self):
        return f"Floor-{self.floor}, Spot-{self.spot_number}"


class ParkingLot:
    """
    Manages allocation, deallocation, and tracking of parking spaces.
    
    Overall Class Space Complexity: O(N) where N = total parking spots.
    The space is split between available_spots (Min-Heap) and occupied_spots (Hash Map),
    ensuring total space consumed never exceeds N at any given time.
    """
   
    # Purpose: Sets up the available spaces min-heap, occupied spaces map, and token tracker.
    # Data Structures Used:
    #   - available_spots: Min-Heap storing unassigned ParkingSpace objects.
    #   - occupied_spots: Hash Map (Dict) mapping token_id -> ParkingSpace object.
    # Time Complexity: O(N) where N = floors * spots_per_floor to populate the initial heap.
    # Space Complexity: O(N) Total Space
    #   - Stores all N ParkingSpace instances in memory inside the heap array.
    def __init__(self, floors: int, spots_per_floor: int):
        self.floors = floors
        self.spots_per_floor = spots_per_floor
        
        # Min-heap to keep track of available spaces closest to entrance
        self.available_spots = []
        
        # Dictionary to track occupied spots: token_id -> ParkingSpace instance
        self.occupied_spots = {}
        
        self.token_counter = 1

        # Populate initial parking spaces into the min-heap
        for f in range(1, floors + 1):
            for s in range(1, spots_per_floor + 1):
                heapq.heappush(self.available_spots, ParkingSpace(f, s))

    # FUNCTION: park_vehicle
    # ----------------------
    # Purpose: Assigns the available space closest to the entrance to a new vehicle and issues a token.
    # Logic:
    #   1. Removes the top (closest) space from the Min-Heap using heapq.heappop.
    #   2. Generates a unique token ID.
    #   3. Adds mapping to occupied_spots dictionary.
    # Time Complexity: O(log N)
    #   - Heap Pop: O(log N)
    #   - Dictionary Insert: O(1)
    # Space Complexity: O(1) Auxiliary Space
    #   - Reallocates an existing ParkingSpace object reference from the heap 
    #     to the dictionary; no significant extra memory consumed per call.
    def park_vehicle(self) -> str:
        if not self.available_spots:
            return "Parking Lot Full!"

        # Extract the closest empty spot from heap
        assigned_spot = heapq.heappop(self.available_spots)
        
        # Issue token
        token_id = f"TOKEN-{self.token_counter}"
        self.token_counter += 1
        
        # Record in occupied spots dictionary
        self.occupied_spots[token_id] = assigned_spot
        
        return f"Vehicle parked at {assigned_spot}. Token Issued: {token_id}"

    # FUNCTION: unpark_vehicle
    # ------------------------
    # Purpose: Frees up the parking spot corresponding to a given token ID and makes it available again.
    # Logic:
    #   1. Looks up and removes the token from occupied_spots dictionary.
    #   2. Returns the freed ParkingSpace back into the Min-Heap using heapq.heappush.
    # Time Complexity: O(log N)
    #   - Dictionary Pop: O(1)
    #   - Heap Push: O(log N)
    # Space Complexity: O(1) Auxiliary Space
    #   - Moves the ParkingSpace object reference from dictionary back into the heap.
    def unpark_vehicle(self, token_id: str) -> str:
        if token_id not in self.occupied_spots:
            return f"Invalid Token ID: {token_id}"

        # Remove from occupied dictionary
        freed_spot = self.occupied_spots.pop(token_id)
        
        # Push back into min-heap to restore available spot ordering
        heapq.heappush(self.available_spots, freed_spot)
        
        return f"Vehicle with {token_id} left. Freed space: {freed_spot}"

    # FUNCTION: get_occupied_spaces
    # -----------------------------
    # Purpose: Retrieves all currently occupied parking spaces and their associated token IDs.
    # Time Complexity: 
    #   - O(1) to return the dictionary reference.
    #   - O(K) if iterating over the results, where K is the number of occupied spaces.
    # Space Complexity: 
    #   - O(1) Auxiliary Space (returns reference to existing dictionary).
    #   - O(K) if generating a shallow/deep copy, where K is the number of occupied spots (K <= N).
    def get_occupied_spaces(self) -> dict:
        return self.occupied_spots


# --- Driver / Execution Example ---
if __name__ == "__main__":
    # Create a parking lot with 2 floors and 3 spots per floor
    lot = ParkingLot(floors=2, spots_per_floor=3)

    print("--- Parking Vehicles ---")
    t1 = lot.park_vehicle()
    print(t1)  # Assigns Floor-1, Spot-1
    
    t2 = lot.park_vehicle()
    print(t2)  # Assigns Floor-1, Spot-2

    print("\n--- Current Occupied Spaces ---")
    for token, spot in lot.get_occupied_spaces().items():
        print(f"{token}: {spot}")

    print("\n--- Unparking Vehicle ---")
    print(lot.unpark_vehicle("TOKEN-1"))  # Frees Floor-1, Spot-1

    print("\n--- Parking Another Vehicle ---")
    t3 = lot.park_vehicle()
    print(t3)  # Re-assigns Floor-1, Spot-1 (closest spot available)