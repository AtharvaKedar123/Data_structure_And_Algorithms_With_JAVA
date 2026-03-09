public class DisjointSetEasy {

    static int[] parent;

    // Initialize
    static void makeSet(int n) {
        parent = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;   // Each node is its own parent
        }
    }

    // Find parent (no path compression for simplicity)
    static int find(int x) {
        if (parent[x] == x)
            return x;

        return find(parent[x]);
    }

    // Union
    static void union(int a, int b) {
        int parentA = find(a);
        int parentB = find(b);

        if (parentA != parentB) {
            parent[parentB] = parentA;  // Merge sets
        }
    }

    public static void main(String[] args) {

        makeSet(5);  // 0 to 4

        union(0, 1);
        union(1, 2);
        union(3, 4);

        System.out.println(find(2));  // Same set as 0 & 1
        System.out.println(find(4));  // Same set as 3
    }
}