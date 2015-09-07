public int majorityElement(int[] nums) {
	int len = nums.length;
	if (len == 1) return nums[0];
	int cnt = 1;
	int res = nums[0];
	for (int i = 1; i < len; i++) {
		if (cnt == 0)
			res = nums[i];
		if (nums[i] == res) {
			cnt++;
		} else {
			cnt--;
		}
	}
	return res;
}