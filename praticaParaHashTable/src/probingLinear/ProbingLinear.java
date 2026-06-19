package probingLinear;

import java.util.*;

public class ProbingLinear {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int tamanho = Integer.parseInt(sc.nextLine());
		HashMap tabela = new HashMap(tamanho);
		String comando = "";
		
		while(!comando.equals("end")) {
			comando = sc.nextLine();
			commandLine(comando, sc, tabela);
		}
	}

	private static void commandLine(String comando, Scanner sc, HashMap tabela) {
		if (comando.equals("end")) return;
		if (comando.equals("keys")) {
			System.out.println(tabela.getKeys());
			return;
		}
		if (comando.equals("values")) {
			System.out.println(tabela.getValues());
			return;
		}
		
		String[] comandoDividido = comando.split(" ");
		if (comandoDividido[0].equals("remove")) {
			tabela.remove(Integer.parseInt(comandoDividido[1]));
			System.out.println(tabela.toString());
			return;
		}
		
		if (comandoDividido[0].equals("put")) {
			tabela.put(Integer.parseInt(comandoDividido[1]), comandoDividido[2]);
			System.out.println(tabela.toString());
			return;
		}
	}

}

class HashMap {
	private Pair[] tabela;
	private int size;
	
	public HashMap(int tamanho) {
		tabela = new Pair[tamanho];
		this.size = 0;
	}
	
	private int hash(int chave) {
		return chave % tabela.length;
	}
	
	public void put(int chave, String valor) {
		int indexApagado = -1;
		Pair newPair = new Pair(chave, valor);
		for (int i = 0; i < tabela.length; i++) {
			int hash = hash(chave + i);
			Pair elemento = tabela[hash];
			
			if (elemento != null && elemento.getKey() == chave) {
				tabela[hash] = newPair;
				return;
			}
			
			if (elemento != null && elemento.getKey() == Integer.MIN_VALUE && indexApagado == -1) {
				indexApagado = hash;
			}
			
			if (elemento == null) {
	            if (indexApagado != -1) {
	                tabela[indexApagado] = newPair;
	            } else {
	                tabela[hash] = newPair;
	            }
	            size++;
	            return;
	        }
		}
		if (indexApagado != -1) {
			tabela[indexApagado] = newPair;
			size++;
		}
		
	}
	
	public void remove(int chave) {
		for (int i = 0; i < tabela.length; i++) {
			int hash = hash(chave + i);
			Pair elemento = tabela[hash];
			if (elemento == null) return;
			if (elemento.getKey() == chave) {
				tabela[hash] = new Pair(Integer.MIN_VALUE, "APAGADO");
				size--;
				return;
			}
		}
	}
	
	public String getKeys() {
		int[] out = new int[size];
		int i = 0;
		for (Pair par : tabela) {
			if (par != null && par.getKey() != Integer.MIN_VALUE) {
				out[i] = par.getKey();
				i++;
			}
		}
		
		Arrays.sort(out);
		return Arrays.toString(out);
	}
	
	
	public String getValues() {
		String[] out = new String[size];
		int i = 0;
		for (Pair par : tabela) {
			if (par != null && !par.getValue().equals("APAGADO")) {
				out[i] = par.getValue();
				i++;
			}
		}
		
		Arrays.sort(out);
		return Arrays.toString(out);
	}
	
	@Override
	public String toString() {
		String out = "[";
		for (int i = 0; i < tabela.length; i++) {
			Pair elemento = tabela[i];
	        
			if (elemento == null || elemento.getKey() == Integer.MIN_VALUE) {
				out += "null";
	        } else {
	            out += elemento.toString();
	        }
	        
			if (i < tabela.length - 1) {
				out += ", ";
	        }
	    }
	    out += "]";
	    
	    return out;
    }
}

class Pair {
	private int chave;
	private String valor;
	
	public Pair(int chave, String valor) {
		this.chave = chave;
		this.valor = valor;
	}
	

	public int getKey() {
		return chave;
	}
	
	public String getValue() {
		return valor;
	}
	
	@Override
	public String toString() {
		return "<" + chave + ", " + valor + ">";
	}
}
