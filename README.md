# Baubillious
My attempt at illuminated AI without looking at the available domain knowledge of artificial intelligence.

# Brain activity like a graph
I see a brain activity in its most basic form as a graph structure. 

Nodes are connected to some neighbours. Each node is at least in someway connected to the graph (i.e. connected graph). All edges have some small weight on it, but the weight can increase as links get stronger, and decrease back to its default if the link has to be forgotten. Nodes can be activated with some power (there is a threshold for activation). When activated, a node activates its neighbours according to the available power (it splits-up the available power to each edge, according to edge weight). If enough power is provided to the neighbours (threshold), they will activate as well. After activating the neighbours, a node will deactivate itself. This process should provide waves of activity through the graph that slowly die-out.

# Environment and agents
Initially, leaf nodes can be assigned input or output roles. Inputs will be activated by the environment and outputs will interact with the environment when activated. Input and output nodes can be considered agents, so I will likely provide an Agent class that interacts with these nodes and the environment to abstract this behaviour.

I haven't really got any ideas for an environment yet. I'm open to ideas. For now I will try to have a high adaptability for the AI towards any environment.

# Evolution theory
I'd like to apply an genetic algorithm to simulate the evolution of brains. The design space of possible graphs is too large to search for the best solution. A heuristic approach like genetic algorithms can help reduce calculation effort.

