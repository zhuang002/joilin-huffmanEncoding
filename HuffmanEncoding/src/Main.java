import java.util.Hashtable;
import java.util.Scanner;

public class Main {

	static Node root=new Node();
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc =new Scanner(System.in);
		int n = sc.nextInt();
		for (int i=0;i<n;i++) {
			String value = sc.next();
			String path = sc.next();
			root.add(path,value);
		}
		String str = sc.next();		
		Node currentNode = root;
		for (int i=0;i<str.length();i++) {
			if (currentNode.value!=null) {
				System.out.print(currentNode.value);
				currentNode=root;
			} else {
				int index = str.charAt(i)-'0'; //'7'-'0' == 7
				currentNode = currentNode.children[index];
			}
		}
	}
}
class Node {
	Character value = null;
	Node[] children = new Node[2];
	
	public Node() {
		children[0]=null;
		children[1]=null;
	}
	public void add(String path, String val) {
		// TODO Auto-generated method stub
		Node currentNode = this;
		for (int i=0;i<path.length();i++) {
			int index = path.charAt(i)-'0';
			if (currentNode.children[index]!=null) {
				currentNode = currentNode.children[index];
			} else {
				currentNode.children[index]=new Node();
				currentNode = currentNode.children[index];
			}
		}
		currentNode.value = val.charAt(0);
	}
	
	public void addRecursive(String path, String val) {
		if (path.isEmpty()) {
			this.value = val.charAt(0);
			return;
		}
		
		int idx = path.charAt(0)-'0';
		if (this.children[idx]==null) {
			this.children[idx] = new Node();
		}
		this.children[idx].add(path.substring(1), val);
		
	}
}
