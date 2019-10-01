public class LeetCode292NimGame {

	// 100% 0ms  要是4的倍数，对手回合会剩下 4n+1 4n+2 4n+3，
	// 对手继续取到 4n，最后一回合剩 4 个你取不完，对手可以取完。
	public boolean canWinNim(int n) {
        return n % 4 != 0;
    }
}