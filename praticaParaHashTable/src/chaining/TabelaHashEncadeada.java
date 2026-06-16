package chaining;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TabelaHashEncadeada {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int tamanho = Integer.parseInt(sc.nextLine());
		
		String comando = "";
		TabelaHash tabela = new TabelaHash(tamanho);
		while (!comando.equals("end")) {
			comando = sc.nextLine();
			commandLine(comando, tabela, sc);
		}
	}

	private static void commandLine(String comando, TabelaHash tabela, Scanner sc) {
		if (comando.equals("end")) {
			return;
		}
		
		String[] linha = comando.split(" ");
		String out = "";
		if (linha[0].equals("put")) {
			tabela.put(Integer.parseInt(linha[1]), linha[2]);
			out = tabela.toString();
		} else if (linha[0].equals("keys")) {
			out = tabela.getKeys();
		} else if (linha[0].equals("values")) {
			out = tabela.getValues();
		} else if (linha[0].equals("remove")) {
			tabela.remove(Integer.parseInt(linha[1]));
			out = tabela.toString();
		}
		
		System.out.println(out);
	}
}

class TabelaHash {
	private List<Pair>[] tabela;
	private List<Integer> chaves;
	private List<String> valores;
	
	public TabelaHash(int tamanho) {
		this.tabela = new List[tamanho];
		this.chaves = new ArrayList<>();
		this.valores = new ArrayList<>();
	}
	
	private int hash(int chave) {
		return chave % tabela.length;
	}
	
	public void put(int chave, String valor) {
		int hash = hash(chave);
		Pair newPair = new Pair(chave, valor);
		
		if (tabela[hash] == null) {
			List<Pair> lista = new ArrayList<>();
			lista.add(newPair);
			tabela[hash] = lista;
			
			chaves.add(chave);
			valores.add(valor);
			return;
		}
		
		List<Pair> lista = tabela[hash];
		for (int i = 0; i < lista.size(); i++) {
			Pair par = lista.get(i);
			if (par.getChave() == chave) {
				valores.remove(par.getValor());
				chaves.remove(Integer.valueOf(par.getChave()));
				
				lista.set(i, newPair);
				valores.add(valor);
				chaves.add(chave);
				return;
			}
		}
		
		lista.add(newPair);
		valores.add(valor);
		chaves.add(chave);
	}
	
	public void remove(int chave) {
		int hash = hash(chave);
		
		if (tabela[hash] != null) {
			List<Pair> lista = tabela[hash];
			for (int i = 0; i < lista.size(); i++) {
				Pair par = lista.get(i);
				if (par.getChave() == chave) {
					valores.remove(par.getValor());
					chaves.remove(Integer.valueOf(chave));
					lista.remove(i);
					break;
				}
			}
		}
	}
	
	public String getKeys() {
		chaves.sort(null);
		return chaves.toString();
	}
	
	public String getValues() {
		valores.sort(null);
		return valores.toString();
	}
	
	@Override
	public String toString() {
		String out = "[";
		for (int i = 0; i < tabela.length; i++) {
			List<Pair> lista = tabela[i];
			
			if (i + 1 >= tabela.length) {
				out += formataUltimo(lista);
			} else {
				out += formataLista(lista);
			}
		}
		
		return out + "]";
	}

	private String formataUltimo(List<Pair> lista) {
		if (lista == null) {
			return "[]";
		} else {
			String out = "[";
			for (int i = 0; i < lista.size(); i++) {
				Pair par = lista.get(i);
				if (i + 1 >= lista.size()) {
					out += par.toString();
				} else {
					out += par.toString() + ", ";
				}
			}
			
			return out + "]";
		}
	}

	private String formataLista(List<Pair> lista) {
		if (lista == null) {
			return "[], ";
		} else {
			String out = "[";
			for (int i = 0; i < lista.size(); i++) {
				Pair par = lista.get(i);
				if (i + 1 >= lista.size()) {
					out += par.toString();
				} else {
					out += par.toString() + ", ";
				}
			}
			
			return out + "], ";
		}
	}

}

class Pair {
	private int chave;
	private String valor;
	
	public Pair(int chave, String valor) {
		this.chave = chave;
		this.valor = valor;
	}
	
	public int getChave() {
		return chave;
	}
	
	public String getValor() {
		return valor;
	}
	
	@Override
	public String toString() {
		return "<" + chave + ", " + valor + ">";
	}
}
