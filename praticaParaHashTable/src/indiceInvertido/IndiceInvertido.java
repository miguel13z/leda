package indiceInvertido;

import java.util.*;

public class IndiceInvertido {
	
	private Map<String, ArrayList<String>> dicionario;

    public IndiceInvertido() {
        this.dicionario = new HashMap<>();
    }

    public void addDocument(String docId, String content) {
    	if (docId.isBlank()) throw new RuntimeException("DocId inválido");
    	if (content.isBlank()) return;
    	
    	String[] palavras = content.split(" ");
    	for (String palavra : palavras) {
    		if (dicionario.containsKey(palavra)) {
    			ArrayList<String> lista = dicionario.get(palavra);
    			if (!lista.contains(docId)) {
    				dicionario.get(palavra).addLast(docId);
    			}
    		} else {
    			ArrayList<String> novaLista = new ArrayList<>();
    			novaLista.addLast(docId);
    			dicionario.put(palavra, novaLista);
    		}
    	}
    }

    public List<String> search(String palavra) {
    	if (dicionario.containsKey(palavra)) {
    		return dicionario.get(palavra);
    	}
        return null;
    }
}