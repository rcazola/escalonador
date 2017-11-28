import java.util.ArrayList;

import javax.swing.JOptionPane;

public class Fifo {
	private Fila filaProcessos;
	private Fila filaChegada;
	private int contProcessos;
	private int contTempo;
	private int quantum;
	private int vetor[];
	int cnt = 0;
	private int aux[];

	void rodar(int quantProcessos) {
		inicializarLista(quantProcessos);
		processarLista(quantProcessos);
	}

	void inicializarLista(int quantProcessos) {

		quantum = (Integer.parseInt(JOptionPane
				.showInputDialog("Tamanho do quantum: ")));
		filaProcessos = new Fila(quantProcessos);
		filaChegada = new Fila(quantProcessos);
		vetor = new int[quantProcessos];

		for (int i = 1; i <= quantProcessos; i++) {

			aux = new int[quantProcessos];
			Processo p = new Processo();

			// Atribui o numero de Processo (i)
			p.setNumeroProcesso(i);
			p.setNumCiclos(Integer.parseInt(JOptionPane
					.showInputDialog("Numero de Ciclos de Processo: " + i)));
			p.setTempoChegada(Integer.parseInt(JOptionPane
					.showInputDialog("Tempo de chegada de Processo: " + i)));

			cnt = 0;
			// Verifica processos de I/O
			while (cnt >= 0) {
				int c = 0;
				aux[c] = (Integer
						.parseInt(JOptionPane
								.showInputDialog("Tempo da operacao I/O (Para encerrar a entrada de operacoes digite -1): ")));

				p.setOperacao(aux);

				cnt = aux[c];
			}
			filaProcessos.adicionafinal(p);
			vetor[i - 1] = p.getTempoChegada();

		}

		// Ordenação fila por ordem de chegada
		vetor = Fila.InsertionSort(vetor);

		for (int t = 0; t < vetor.length; t++) {
			for (int k = 0; k < vetor.length; k++) {
				Processo u = filaProcessos.getProcesso(k);

				if (vetor[t] == u.getTempoChegada()) {
					filaChegada.adicionafinal(u);
					filaProcessos.removerinicio();
				}

			}
		}
	}

	void processarLista(int quantProcessos) {

		Processo p = new Processo();
		Processo cpu = null;
		int finalizados = 0, m = 0;

		System.out.println("INICIANDO SIMULACAO");
		p = filaChegada.removerinicio();

		while (filaProcessos.getTamanho() > 0
				|| finalizados < quantProcessos) {
			int cont = 0;

			while (cont < quantum) {
				System.out.println("\nTEMPO " + m);

				// Verifica se tem processo chegando

				if (cpu != null) {
					if (cpu.getNumCiclos() == 0) {
						if (filaProcessos.vazia()) {
							System.out.println("#evento - Encerrando P"
									+ cpu.getNumeroProcesso());
							finalizados++;
							cpu = null;
						} else {
							System.out.println("#evento - Encerrando P"
									+ cpu.getNumeroProcesso());
							finalizados++;
							cpu = filaProcessos.removerinicio();
						}
					}
				}

				if (p.getTempoChegada() == m) {
					if (cpu != null) {
						System.out.println("#evento - Chegada P"
								+ p.getNumeroProcesso());
						filaProcessos.adicionafinal(p);
						p = filaChegada.removerinicio();
					} else {
						System.out.println("#evento - Chegada P"
								+ p.getNumeroProcesso());
						cpu = p;
						p = filaChegada.removerinicio();
					}
				}
				m++;

				if (cont == 3) {
					// Verifica se tem processos na fila antes de finalizar
					// o quantum
					if (filaProcessos.getTamanho() == 0) {
						System.out.println("#evento - Fim de quantum P"
								+ cpu.getNumeroProcesso());
						cont = 0;
					} else {
						System.out.println("#evento - Fim de quantum P"
								+ cpu.getNumeroProcesso());
						Processo aux = new Processo();
						aux = cpu;
						cpu = filaProcessos.removerinicio();
						filaProcessos.adicionafinal(aux);
						cont = 0;
					}

				}

				if (cpu != null) {
					System.out.println("CPU: P" + cpu.getNumeroProcesso() + "("
							+ cpu.getNumCiclos() + ")");
					cpu.setNumCiclos(cpu.getNumCiclos() - 1);
				} else {
					System.out.println("ACABARAM OS PROCESSOs");
				}

				if (filaProcessos.vazia()) {
					System.out.println("FILA: Nao ha processos na fila");
				} else {
					Processo perc[] = filaProcessos.pecorrer();
					System.out.print("FILA: ");
					for (int i = 0; i < perc.length; i++) {
						Processo ts = perc[i];
						System.out.print("P" + ts.getNumeroProcesso() + "("
								+ ts.getNumCiclos() + ")  ");
					}
					System.out.print("\n");
				}
				cont++;
				
			}
		}

	}

}
