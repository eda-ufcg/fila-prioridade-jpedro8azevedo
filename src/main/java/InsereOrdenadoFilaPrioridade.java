public class InsereOrdenadoFilaPrioridade implements FilaPrioridade {

	private Pair[] fila;
	private int head;
	private int last;

	public InsereOrdenadoFilaPrioridade(int capacidade) {
		this.fila = new Pair[capacidade];
		this.last = -1;
		this.head = -1;
	}
	
	// criar um Pair e inserir de forma ordenada decrescente no array.
	public void add(String elemento, int prioridade) {
		if ((this.last % this.fila.length) + 1 >= this.fila.length) {
			this.resize();
		}
		Pair e = new Pair(elemento, prioridade);
		if (this.last == -1) {
			this.head++;
			this.last++;
			this.fila[this.last] = e;
		}
		else {
			this.last++;
			this.fila[this.last % this.fila.length] = e;
			int i = this.last;
			while (i % this.fila.length != this.head) {
				if (this.fila[i % this.fila.length].getPrioridade() > this.fila[(i - 1) % this.fila.length].getPrioridade()) {
					Pair aux = this.fila[i % this.fila.length];
					this.fila[i % this.fila.length] = this.fila[(i - 1) % this.fila.length];
					this.fila[(i - 1) % this.fila.length] = aux;
					i -= 1;
				}
				else {
					break;
				}
			}
		}
	}


	// remover e retornar o primeiro elemento do array, que é o de maior prioridade. lembrar manipular head e tail
	// para ser uma fila circular. assim a remoção fica O(1)
	public String removeNext() {
		String removed = this.fila[this.head].getElemento();
		if (this.head == this.last % this.fila.length) {
			this.head = -1;
			this.last = -1;
		}
		else {
			this.head++;
		}
		return removed;
	}

	public void resize() {
		Pair[] newFila = new Pair[this.fila.length * 2];
		int j = 0;
		for (int i = this.head; i < this.last; i++) {
			newFila[j] = this.fila[i % this.fila.length];
			j++;
		}
		this.head = 0;
		this.last = j;
		this.fila = newFila;
	}

	public int[] getFila() {
		int[] nums = new int[this.fila.length];
		int j = 0;
		for (int i = head; i <= this.last; i++) {
			nums[j] = this.fila[i % this.fila.length].getPrioridade();
			j++;
		}
		return nums;
	}

}
