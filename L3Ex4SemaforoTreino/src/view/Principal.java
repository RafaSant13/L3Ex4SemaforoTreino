package view;

import java.util.concurrent.Semaphore;

import controller.QuickSort;
import controller.ThreadTreino;
import model.Piloto;

public class Principal {

	public static void main(String[] args) {
		QuickSort qs = new QuickSort();
		int limPista = 5;
		int limEscuderia = 1;
		Semaphore pista = new Semaphore(limPista);
		Semaphore [] escuderias = new Semaphore [7];
		Piloto [] pilotos = new Piloto[14];
		int i;
		for(i = 0;i<7;i++) {
			escuderias[i] = new Semaphore(limEscuderia);
			for (int j = 0;j<2;j++) {
				pilotos[(i*2)+j] =new Piloto((i*2)+j+1, 1, 0);
				Thread volta = new ThreadTreino(pilotos[(i*2)+j], pista, escuderias[i]);
				volta.start();
			}
		}
		if (!qs.completouVolta(pilotos)) {
			while (!qs.completouVolta(pilotos)) {
				
			}
			System.out.println("\n");
			Piloto [] grid = qs.quickSort(pilotos, 0, 14-1);
			for (i=0;i<14;i++) {
				System.out.println((i+1)+"º Colocado => Piloto #"+grid[i].numero+" com melhor tempo de "+grid[i].melhorTempo+"s.");
			}
		}
		
		
	
	}

}
