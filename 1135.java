class Solution {
    private int[] parent;
    public int minimumCost(int N, int[][] connections) {
        parent = new int[N+1];
        for(int i = 0;i<N+1;i++) parent[i] = i;
        int costSum = 0;
        Arrays.sort(connections,(a,b)->a[2]-b[2]);
        for(int[] edge:connections){
            int a = edge[0],b=edge[1];
            if(find(a)!=find(b)){
                N--;
                costSum+=edge[2];
                union(a,b);
            }
        }
        return N==1?costSum:-1;
    }
    
    private int find(int k){
        if(k!=parent[k])
            parent[k] = find(parent[k]);
        return parent[k];
    }
    
    private void union(int a,int b){
        parent[find(a)] = find(b);
    }    
}
// use union find to detect cycle(detect if two nodes connected)
// use https://www.geeksforgeeks.org/kruskals-minimum-spanning-tree-algorithm-greedy-algo-2/ kruskals algorithm to detect it, please remember it
