
public class MeusTestes {

	public static void main(String[] args) {
		LinkedList list = new LinkedList();
		
		list.addLast(0);
        list.addLast(1);
        list.addLast(2);
        list.addLast(3);
        list.addLast(4);
        list.addLast(5);
		
        System.out.println(list.toString() + "\n");
        
        Node n1 = list.getNo(1);
        Node n2 = list.getNo(2);
        list.swap(n1, n2);
        
        
        System.out.println(list.toString() + "\n");
        
        list.addLast(20);
        
        System.out.println(list.toString() + "\n");
	}

}
