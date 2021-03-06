public static class BellmanFord{
    private ArrayList<Edge> edge;
    long[] dist; int v, e;/*v:頂点数,e:辺数*/
    boolean[] nega;
    boolean directed;
    public BellmanFord(int v, int e, boolean directed){
        this.directed = directed;
        this.v = v;
        this.e = this.directed?e:2*e;
        edge = new ArrayList<>(this.e);
        dist = new long[v];
        nega = new boolean[v];
        Arrays.fill(dist,INF);
        Arrays.fill(nega, false);
    }
    public void bellmanford(int s){
        dist[s] = 0;
        boolean update;
        for (int j = 0; j < 2*v-1; j++) {
            update = false;
            for (int i = 0; i < edge.size(); i++) {
                Edge e = edge.get(i);
                if(dist[e.from]!=INF && dist[e.to]>dist[e.from]+e.cost){
                    dist[e.to] = dist[e.from]+e.cost;
                    update = true;
                    if(j >= v-1){
                        nega[e.to] = true;
                    }
                }
            }
            if(!update) break;
        }
    }
    public void addEdge(int from, int to, long cost){
        Edge e = new Edge(from, to, cost);
        edge.add(e);
        if(!this.directed){
            Edge e_rev = new Edge(to, from, cost);
            edge.add(e_rev);
        }
    }
    class Edge{
        int from, to; long cost;
        Edge(int from, int to, long cost){
            this.from = from;
            this.to = to;
            this.cost = cost;
        }
    }
}
