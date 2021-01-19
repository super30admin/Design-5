# Design a parking lot system where you need to provide a token with the parking space number 
# on it to each new entry for the space closest to the entrance. 
# When someone leave you need update this space as empty. 
# What data structures will you use to perform the closest empty space tracking, 
# plus finding what all spaces are occupied at a give time.

# Solution
"""
1. For maintaining the closest empty space MinHeap can be used. It is a tree 
data structure in which root node value is less than the children. So to find nearest
empty slot Put/Insert/Add the slot when someone leaves and remove and give when someone arrives. 

2. For finding all spaces occupied at a given time HashMap can be used. It is a data structure
which uses key value pairs for storing data/values. So the keys will be parking spots and values
will be the cars parked at that respective parking slot. Remove the tag when someone leaves and 
assign when someone enters.

"""

"""
# Time Complexity : 
# Space Complexity : 
# Did this code successfully run on Leetcode : 
# Any problem you faced while coding this : 
# Your code here along with comments explaining your approach
# Approach
"""