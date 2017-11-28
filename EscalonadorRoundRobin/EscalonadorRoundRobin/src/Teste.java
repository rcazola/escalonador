import javax.swing.JOptionPane;


public class Teste {

	public static void main(String[] args) {
		Fifo fifo = new Fifo();

		fifo.rodar(Integer.parseInt(JOptionPane.showInputDialog(""+"Quantidade de processos: ")));

	}

}
