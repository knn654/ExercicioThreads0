import javax.swing.JOptionPane;

public class Main {
	static int tamanho;

	public static void checar(int num, int qtdVetor) {
		tamanho = qtdVetor;
		if (num % 2 == 0) {
			ThreadVetor.start();
		} else {
			ThreadVetor2.start();
		}
	}
	static Thread ThreadVetor = new Thread() {
		public void run() {
			int[] vet = new int[tamanho];
			double tempoInicial = System.nanoTime();
			for (int i=0;i<vet.length;i++) {
					vet[i] = 0;
			}
			double tempoFinal = System.nanoTime();
			double tempoTotal = tempoFinal - tempoInicial;
			tempoTotal = tempoTotal / Math.pow(10, 9);
			System.out.println("Método for: " + tempoTotal + " s.");
		}
	};
	static Thread ThreadVetor2 = new Thread() {
		public void run() {
			int[] vet = new int[tamanho];
			double tempoInicial = System.nanoTime();
			for (int i : vet) {
					vet[i] = 0;
			}
			double tempoFinal = System.nanoTime();
			double tempoTotal = tempoFinal - tempoInicial;
			tempoTotal = tempoTotal / Math.pow(10, 9);
			System.out.println("Método foreach: " + tempoTotal + " s.");
		}
	};
	
	public static void main(String[] args) {
		int tamanho = Integer.parseInt(JOptionPane.showInputDialog("Digite o tamanho do vetor"));
		int valor = Integer.parseInt(JOptionPane.showInputDialog("Digite o tamanho do vetor"));
		checar(valor, tamanho);
	}
}
