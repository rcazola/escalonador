public class Fila {

	private Processo processo[];
	private int tamanho;

	public Fila(int qtdProcessos) {
		processo = new Processo[qtdProcessos];
		tamanho = 0;
	}

	public boolean vazia() {
		return tamanho == 0;
	}

	public boolean cheia() {
		return tamanho == processo.length;
	}

	public Processo getProcesso(int num) {
		return processo[num];
	}

	public void setProcesso(Processo p, int posicao) {
		this.processo[posicao] = p;
	}

	public int getTamanho() {
		return tamanho;
	}

	public Processo[] pecorrer() {
		Processo aux[] = new Processo[tamanho];
		for (int i = 0; i < tamanho; i++) {
			Processo p = processo[i];
			aux[i] = p;
		}
		return aux;
	}

	public void adicionafinal(Processo processo) {

		if (!cheia()) {
			this.processo[tamanho] = processo;
			tamanho++;
		} else {
			System.out.print("Erro, Lista esta cheia");
		}
	}

	public Processo removerinicio() {
		Processo p = new Processo();
		if (vazia()) {
//			System.out.println("fila vazia, nao é possivel remover");
		} else {
			p = this.processo[0];
			for (int i = 0; i < tamanho - 1; i++) {
				this.processo[i] = processo[i + 1];
			}
			tamanho--;

		}
		
		return p;
	}

	public void adicionainicio(Processo processo) {
		if (!cheia()) {
			for (int i = tamanho; i >= 1; i--) {
				this.processo[i] = this.processo[i - 1];
			}
			tamanho++;
			this.processo[0] = processo;
		} else {
			System.out
					.println("lista cheia não possível  adicionar mais elementos");

		}
	}

	// public static void InsertionSort(Fila fila) {
	// for (int i = 0; i < fila.getTamanho(); i++) {
	//
	// Processo p = fila.getProcesso(i);
	// int a = p.getTempoChegada();
	// Processo pa = fila.getProcesso(i-1);
	// int r = pa.getTempoChegada();
	// for (int j = i - 1; j >= 0 && r > a; j--) {
	//
	// fila.setProcesso(pa, j+1);
	// fila.setProcesso(p, j);
	// }
	// }
	// }

	public static int[] InsertionSort(int[] vetor) {
		for (int i = 0; i < vetor.length; i++) {

			int a = vetor[i];
			for (int j = i - 1; j >= 0 && vetor[j] > a; j--) {

				vetor[j + 1] = vetor[j];
				vetor[j] = a;
			}
		}
		return vetor;
	}

}
