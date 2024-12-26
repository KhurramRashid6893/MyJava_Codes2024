import java.lang.*;
import java.util.*;
public class ReadKeyboard
{
	public static void main(String arg[])
	{
		Scanner sc = new Scanner(System.in);
		sc.useRadix(2);
		
		int x = sc.nextInt();
		
		System.out.println(x);
	}
}