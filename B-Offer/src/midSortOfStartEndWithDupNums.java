public class midSortOfStartEndWithDupNums {
    //给定一个按照升序排列的整数数组 nums，和一个目标值 target。找出给定目标值在数组中的开始位置和结束位置。
    //
    //你的算法时间复杂度必须是 O(log n) 级别。
    public int[] searchRange(int[] nums, int target) {
            int[] index = new int[]{-1,-1};
            index[0] = left_bound(nums,target);
            index[1] = right_bound(nums,target);
            return index;
        }
        public int left_bound(int[] nums, int target) {
            int left = 0, right = nums.length - 1;
            while (left <= right) {
                int mid = left + (right - left) / 2;
                if (nums[mid] < target) {
                    left = mid + 1;
                } else if (nums[mid] > target) {
                    right = mid - 1;
                } else if (nums[mid] == target) {
                    // 别返回，收缩左侧边界
                    right = mid - 1;
                }
            }
            // 最后要检查 left 越界的情况
            if (left >= nums.length || nums[left] != target)
                return -1;
            return left;
        }
        public int right_bound(int[] nums, int target) {
            int left = 0, right = nums.length - 1;
            while (left <= right) {
                int mid = left + (right - left) / 2;
                if (nums[mid] < target) {
                    left = mid + 1;
                } else if (nums[mid] > target) {
                    right = mid - 1;
                } else if (nums[mid] == target) {
                    // 别返回，收缩左侧边界
                    left = mid + 1;
                }
            }
            // 最后要检查 left 越界的情况
            if (right < 0 || nums[right] != target)
                return -1;
            return right;
        }
}
