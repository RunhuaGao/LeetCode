class Solution {
    private int[] rootSize;
    private int[] root;

    public int earliestAcq(int[][] logs, int N) {
        Arrays.sort(logs, new Comparator<int[]>() {
            public int compare(int[] o1, int[] o2) {
                return o1[0]-o2[0];
            }
        });
        // idea: union find
        root = new int[N];
        rootSize = new int[N];
        for (int i = 0; i < N; i++) {
            root[i] = i;
            rootSize[i] = 1;
        }
        for (int[] log : logs) {
            final int time = log[0], friendA = log[1], friendB = log[2];
            if (findSize(friendA) >= findSize(friendB)) {
                connect(friendA, friendB);
                if (findSize(friendA) == N) return time;
            } else {
                connect(friendB, friendA);
                if (findSize(friendB) == N) return time;
            }
        }
        return -1;
    }


    private void connect(int a, int b) {
        int rootA = findRoot(a);
        int rootB = findRoot(b);
        if(rootA==rootB) return;
        int newSize = rootSize[rootA] + rootSize[rootB];
        while (b != root[b]) {
            int nextNode = root[b];
            root[b] = rootA;
            b = nextNode;
        }
        rootSize[rootA] = newSize;
        root[b] = rootA;
    }


    private int findRoot(int k) {
        while (root[k] != k) k = root[k];
        return k;
    }


    private int findSize(int k) {
        return rootSize[findRoot(k)];
    }
    
}

// implement improved union-find, mainthe subset size
