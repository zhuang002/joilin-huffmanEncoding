import java.util.Hashtable;
import java.util.Scanner;

public class Main {

	static Hashtable<String,String> dic = new Hashtable<>();
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Hashtable<String,String> dic = new Hashtable<>();
		Scanner sc =new Scanner(System.in);
		int n = sc.nextInt();
		for (int i=0;i<n;i++) {
			String value = sc.next();
			String key = sc.next();
			dic.put(key,value);
		}
		String str = sc.next();
		
		System.out.println(decoding(str));
	}

	private static String decoding(String str) {
		// TODO Auto-generated method stub
		if (str.isBlank()) return "";
		String key=findFirstKey(str);
		return dic.get(key)+decoding(str.substring(key.length()));
	}

	private static String findFirstKey(String str) {
		// TODO Auto-generated method stub
		String key="";
		for (int i=0;i<str.length();i++) {
			key+=str.charAt(i);
			if (dic.containsKey(key))
				return key;
		}
		return null;
	}

}
