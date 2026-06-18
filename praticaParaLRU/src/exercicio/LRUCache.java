package exercicio;

public class LRUCache {
	private LinkedList lista;
	private int max;
	
	public LRUCache(int max) {
		this.lista = new LinkedList();
		this.max = max;
	}
	
	public int size() {
		return lista.size();
	}
	
	public boolean isFull() {
		return lista.size() == max;
	}
	
	public String get(String elemento) {
		Node no = lista.getNode(elemento);
		if (no != null) {
			lista.moveToTail(no);
			return "hit";
		}
		
		if (isFull()) {
			lista.removeFirst();
		}
		lista.addLast(elemento);
		return "miss";
	}
	
	public String seeFirst() {
		return lista.seeFirst();
	}
}
