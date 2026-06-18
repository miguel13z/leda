package exercicio;

public class LRUEvictionStrategy {
	private LRUCache lista;

	public LRUEvictionStrategy(int maxSize) {
		this.lista = new LRUCache(maxSize);
	}

	public String getNextEviction() {
		if (lista.isFull()) {
			return lista.seeFirst();
		}
		return null;
	}

	public int size() {
		return lista.size();
	}

	public String get(String elemento) {
		return lista.get(elemento);
	}

}
