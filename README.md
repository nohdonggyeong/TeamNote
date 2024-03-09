### advanced, professional 모두 문제에서 상황과 입력 조건 및 범위가 주어진다.
> <b>1. 상황</b> -> 맵, 그래프, 트리, 경우의 수, 점화식 중 어떤 문제인지 파악하고, 어떤 알고리즘을 요구하는지 분석한다.<br/>
>
> <b>2. 입력 조건</b> -> 분석 중인 알고리즘이 주어진 입력 조건 및 범위에 따라 시간 제한을 초과한다면 다른 알고리즘을 선택해야 한다.
<br/>

# 알고리즘 선택
### advanced
- 문제 내용대로 구현 해야 하고, 시간 제한을 생각하지 않아도 되는 적당한 범위가 입력 조건으로 주어진다. -> [Brute force](src/advanced/bruteforce/)
- 맵, 그래프, 경우의 수에서 완전 탐색까지는 아니더라도 특정 조건을 달성할 때까지 탐색해야 한다. -> [Backtracking](src/advanced/backtracking/)
- 맵, 그래프, 경우의 수에서 완전하게 탐색(Exhaustive search)해야 한다. -> [DFS(Depth first search)](src/advanced/dfs/)
- 맵, 그래프에서 단일 출발점에서 단일 도착점까지의 최단거리를 구해야 한다. -> [BFS(Breadth first search)](src/advanced/bfs/)

### professional
- 그래프에서 간선의 가중치가 모두 양수일 때, 단일 출발지에서 다른 모든 정점까지의 거리를 구해야 한다. -> [Dijkstra](src/professional/dijkstra/)
- 그래프에서 간선의 가중치가 음수가 있을 때, 단일 출발지에서 다른 모든 정점까지의 거리를 구해야 한다. -> [Bellman Ford](src/professional/bellmanford/)
- 그래프에서 간선의 가중치로 음수도 가능하고, 모든 정점 쌍의 거리를 구해야 한다. -> [Floyd Warshall](src/professional/floydwarshall/)
- 그래프에서 정점들의 연결 순서를 찾아야 한다. -> [Topological sorting](src/professional/topologicalsorting/)
- 그래프에서 서로소 집합을 구분해야 한다. -> [Union find](src/professional/unionfind/)
- 그래프에서 모든 정점을 연결하는 최소 간선 개수인 N - 1개만 남겨야 한다. -> [MST(Minimun spanning tree)](src/professional/mst/)
- 트리에서 두 정점의 최소 거리를 구해야 한다. -> [LCA(Lowest common ancestor)](src/professional/lca/)
- 매우 큰 수가 입력 조건으로 주어질 때 개수를 세어야 한다. -> [Segment Tree](src/professional/segmenttree/)
- 점화식을 찾아내야 값을 구해야 한다. -> [Dynamic programming](src/professional/dp/)
- 정렬된 배열에서 매우 빠른 속도로 요소의 인덱스를 찾아내야 한다. -> [Binary search](src/professional/binarysearch/)
- 배열에서 가변 구간에서 최대 또는 최소 또는 특정 합계를 만족하는 범위를 찾아야 한다. -> [Two pointer](src/professional/twopointer/)
- 매우 빠른 속도로 배열의 요소를 정렬해야 한다. -> [Quick sort](src/professional/quicksort/)
