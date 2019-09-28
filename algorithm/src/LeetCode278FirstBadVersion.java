public class LeetCode278FirstBadVersion extends VersionControl {

	public int firstBadVersion(int n) {
        int left = 1;
        int right = n;
        
        while (left < right) {
            int mid = left + (right - left) / 2;    // 必须这么写，不然会有越界问题
            
            if (isBadVersion(mid)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        
        return left;
    }

	@Override
	public boolean isBadVersion(int version) {
		if (version <= 3) return false;
		else return true;
	}
}