Solution Analysis:
This is a classical graph problem: as each condition in the prerequiste is an edge that links two nodes
As each course is a node，what we wanna clarify for this probelm is that if this graph exists a cycle
because with a cycle we can not find a way to go through all courses: for example the [0,1] and [1,0], 0 and 1 these two
nodes form a cycle that result s a failure in finding a way to go through all courses;

After establishing a graph(tips: also need to use a visited array to record all nodes we have visited)
for each node in graph, we current set its status to 1(current visiting)
then we go through all its neighbor points, if we come across a node whose status is also visiting(1), means that we come
across a cycle 

if we come across a visited node(status = 2), then could directly return no cycle(this cycle has been already visited)
which means this node is an end for a path

after dfs all current node's neighbor points, if do not find a cycle, set the current node's status to 2(visited)

Time Complexity: O(E+V)
Space Complexity: O(E+V)
