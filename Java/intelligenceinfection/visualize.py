import igraph

spies, enemies, connections = [int(x) for x in input().split()]

g = igraph.Graph().as_directed()
g.add_vertices(spies)
edges = []
for i in range(connections):
    fr, to = [int(x) for x in input().split()]
    edges.append((fr, to))
print(edges)

dirties = [int(x) for x in input().split()]

g.vs["color"] = ["red" if s in dirties else "green" for s in range(spies) ]
g.add_edges(edges)

print(g)

igraph.plot(g, vertex_label=range(spies))
