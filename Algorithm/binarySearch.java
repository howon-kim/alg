public int binarySearch(int[] nums, int left, int right, int target) {
        int mid = (right + left) / 2;
        if (mid >= nums.length || left > right) {
            return -1;
        } else if (nums[mid] == target) {
            return mid;
        } else if (nums[mid] < target) {
            return binarySearch(nums, mid + 1, right, target);
        } else {
            return binarySearch(nums, left, mid - 1, target);
        }
    }