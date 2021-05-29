
public class Question1 {
	public static void main(String[] args) {
		printStars(3);
	}

	private static void printStars(int n) {
		for(int i = 0; i < n;i++) {
			for(int k = n-i; k>0;k--)
				System.out.print(" ");
				
			for(int j = 0;j<i;j++)
				System.out.print("*");
			for(int j = -1;j<i;j++)
				System.out.print("*");
			
			
			System.out.println();
		}
	}
}
