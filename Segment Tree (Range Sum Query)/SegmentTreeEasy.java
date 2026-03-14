public class SegmentTreeEasy {

    static int[] tree;
    static int n;

    // Build tree
    static void build(int[] arr, int start, int end, int index) {

        if (start == end) {
            tree[index] = arr[start];
            return;
        }

        int mid = (start + end) / 2;

        build(arr, start, mid, 2 * index + 1);
        build(arr, mid + 1, end, 2 * index + 2);

        tree[index] = tree[2 * index + 1] + tree[2 * index + 2];
    }

    // Query sum in range
    static int rangeSum(int start, int end, int l, int r, int index) {

        // Complete overlap
        if (l <= start && r >= end)
            return tree[index];

        // No overlap
        if (end < l || start > r)
            return 0;

        int mid = (start + end) / 2;

        return rangeSum(start, mid, l, r, 2 * index + 1)
                + rangeSum(mid + 1, end, l, r, 2 * index + 2);
    }

    public static void main(String[] args) {

        int[] arr = {1, 3, 5, 7, 9, 11};
        n = arr.length;

        tree = new int[4 * n];  // Safe size

        build(arr, 0, n - 1, 0);

        System.out.println("Sum from index 1 to 3: "
                + rangeSum(0, n - 1, 1, 3, 0));
    }
}