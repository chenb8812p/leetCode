public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int size1 = nums1.length;
        int size2 = nums2.length;
        int mid = (size1 + size2) / 2;
        boolean isDouble = (size1 + size2) % 2 == 0;

        int i1 = 0;
        int i2 = 0;
        int a1 = 0;
        int a2 = 0;
        for (int k = 0; k <= mid; k ++) {
            a1 = a2;
            if (i1 >= size1 || i2 >= size2) {
                if (i1 >= size1) {
                    a2 = nums2[i2];
                    i2++;
                    continue;
                }
                if (i2 >= size2) {
                    a2 = nums1[i1];
                    i1++;
                    continue;
                }
            }
            if (nums1[i1] < nums2[i2]) {
                a2 = nums1[i1];
                i1++;
                continue;
            }
            if (nums1[i1] > nums2[i2]){
                a2 = nums2[i2];
                i2++;
                continue;
            }
            a2 = nums1[i1];
            i1++;
        }
        if (isDouble) {
            return ((double)(a1 + a2) / 2);
        }
        return (double) a2;
    }
