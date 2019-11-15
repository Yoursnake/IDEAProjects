public class LeetCode338CountingBits {
	// 没经过一次 2^n，就是上一次 2^(n-1) 中每个数1的个数加1，列举几项就能找到规律
	// O(n) 1ms 99.8%
	public int[] countBits(int num) {
        int[] res = new int[num + 1];	// res[0] 必定为 0
        int point = 0;
        
        for (int i = 1; i <= num; i++) {
            res[i] = res[point++] + 1;
            if (((i + 1) & i) == 0) point = 0;	// 如果 i + 1 是 2^n，则将 point 指向 0
        }
        
        return res;
    }
}