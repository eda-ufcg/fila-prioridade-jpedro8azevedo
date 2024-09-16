import java.util.ArrayList;

public class InsereFinalFilaPrioridade implements FilaPrioridade {

	private ArrayList<Pair> fila;

	public InsereFinalFilaPrioridade(int capacidade) {
		this.fila = new ArrayList<Pair>(capacidade);
	}
	
	// criar um Pair e adicionar no fim da fila
	public void add(String elemento, int prioridade) {
		Pair e = new Pair(elemento, prioridade);
		fila.add(e);
	}


	// buscar pelo elemento de maior prioridade na fila.
	public String removeNext() {
		String out = "";
		if (fila.size() != 0) {
			int indexMaior = 0;
			for (int i = 1; i < fila.size(); i++) {
				if (fila.get(i).getPrioridade() > fila.get(indexMaior).getPrioridade()) {
					indexMaior = i;
				}
			}
			out = fila.get(indexMaior).getElemento();
			fila.remove(indexMaior);
		}
		return out;
	}

}
