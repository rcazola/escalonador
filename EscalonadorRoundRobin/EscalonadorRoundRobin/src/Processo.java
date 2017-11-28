public class Processo {
	private int numeroProcesso;
	private int numCiclos;
	private int tempoChegada;
	private int tempoEspera;
	private int tempoTermino;
	private int tempoAcabar;
	private int operacao[];

	public int[] getOperacao() {
		return operacao;
	}

	public void setOperacao(int[] operacao) {
		this.operacao = operacao;
	}

	public int getNumeroProcesso() {
		return numeroProcesso;
	}

	public void setNumeroProcesso(int numeroProcesso) {
		this.numeroProcesso = numeroProcesso;
	}

	public int getNumCiclos() {
		return numCiclos;
	}

	public void setNumCiclos(int numCiclos) {
		this.numCiclos = numCiclos;
	}

	public int getTempoChegada() {
		return tempoChegada;
	}

	public void setTempoChegada(int tempoChegada) {
		this.tempoChegada = tempoChegada;
	}

	public int getTempoEspera() {
		return tempoEspera;
	}

	public void setTempoEspera(int tempoEspera) {
		this.tempoEspera = tempoEspera;
	}

	public int getTempoTermino() {
		return tempoTermino;
	}

	public void setTempoTermino(int tempoTermino) {
		this.tempoTermino = tempoTermino;
	}

	public int getTempoAcabar() {
		return tempoAcabar;
	}

	public void setTempoAcabar(int tempoAcabar) {
		this.tempoAcabar = tempoAcabar;
	}
}
