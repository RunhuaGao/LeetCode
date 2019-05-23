class Solution {
    private int[] visited;
    private List<ArrayList<Integer>> nodes;
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        if(numCourses==0) return true;
        nodes = new ArrayList<ArrayList<Integer>>();
        for(int i=0;i<numCourses;i++) nodes.add(new ArrayList<>());
        visited = new int[numCourses];
        // establish the graph: add neighbor points
        for(int[] condition:prerequisites){
            int curr = condition[0],pre = condition[1];
            nodes.get(curr).add(pre);
        }
        for(int i = 0;i<numCourses;i++){
            if(visited[i]!=2 && dfs(i)==true)return false;
        }
        return true;
    }
    
    private boolean dfs(int node){
        if(visited[node]==1) return true;
        if(visited[node]==2) return false;
        visited[node] = 1;
        for(int i:nodes.get(node)){
            if(dfs(i)) return false;
        }
        visited[node] = 2;
        return false;
    }
}
