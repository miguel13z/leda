package filaComArray;

import java.util.Scanner;

public class FilaComArray {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int tamanho = Integer.parseInt(sc.nextLine());
		
		commandLine(tamanho, sc);
	}

	private static void commandLine(int tamanho, Scanner sc) {
		String[] comando = new String[2];
		Fila fila = new Fila(tamanho);
		while (true) {
			comando = sc.nextLine().split(" ");
			if (comando[0].equals("end")) break;
			else if (comando[0].equals("print")) {
				System.out.print(fila.toString());
			}
			else if (comando[0].equals("element")) {
				System.out.print(fila.seeFirst());
			}
			else if (comando[0].equals("remove")) {
				System.out.print(fila.removeFirst());
			}
			else if (comando[0].equals("add")) {
				System.out.print(fila.addLast(Integer.parseInt(comando[1])));
			}
		}
	}

}

class Fila {
	private int[] fila;
	private int head;
	private int tail;
	private int size;
	
	public Fila(int capacidade) {
		this.fila = new int[capacidade];
		this.head = -1;
		this.tail = -1;
		this.size = 0;
	}
	
	public String addLast(int elemento) {
		if (isFull()) return "full\n";
		if (isEmpty()) {
			head = 0;
			tail = 0;
		} else {
			tail = (tail + 1) % fila.length;
		}
		
		fila[tail] = elemento;
		size++;
		
		return "";
	}
	
	@Override
	public String toString() {
		if (isEmpty()) return "empty\n";
		
		String out = "";
		for (int i = 0; i < size; i++) {
			int index = (head + i) % fila.length;
			out += fila[index] + " ";
		}
		
		return out.substring(0, out.length() - 1) + "\n";
	}
	
	public String seeFirst() {
		if (isEmpty()) return "empty\n";
		return fila[head] + "\n";
	}
	
	public String removeFirst() {
		if (isEmpty()) return "empty\n";
		if (head == tail) {
			head = -1;
			tail = -1;
		} else {
			head = (head + 1) % fila.length;
		}
		
		size--;
		return "";
		
	}
	
	public boolean isEmpty() {
		return size == 0;
	}

	public boolean isFull() {
		return size == fila.length;
	}
}
