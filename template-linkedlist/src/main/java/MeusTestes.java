
public class MeusTestes {

	public static void main(String[] args) {
		LinkedList list = new LinkedList();
		
		list.addLast(1);
        list.addLast(2);
        list.addLast(3);
        list.addLast(4);
        list.addLast(5);
        list.add(0, 10);
        list.add(5, 10);
		
        System.out.println(list.contain(10));
        System.out.println(list.toString());
        
	}

}
