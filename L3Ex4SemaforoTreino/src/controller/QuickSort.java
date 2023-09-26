package controller;

import model.Piloto;

public class QuickSort {

	public QuickSort() {
		super();
	}

	public Piloto[] quickSort(Piloto []vetor, int inicio, int fim) {
		if (fim>inicio) {
			int pivoFixo = dividir(vetor, inicio, fim);
			quickSort(vetor, inicio, pivoFixo-1);
			quickSort(vetor, pivoFixo+1, fim);
		}
		return vetor;
	}
	
	private int dividir(Piloto [] vetor, int inicio, int fim) {
		int pivo = vetor[inicio].melhorTempo;
		int ponteiroEsquerda = inicio +1;
		int ponteiroDireita = fim;
		
		while (ponteiroEsquerda <= ponteiroDireita) {
			while (ponteiroEsquerda <= ponteiroDireita && vetor[ponteiroEsquerda].melhorTempo<= pivo) {
				ponteiroEsquerda++;
			}
			while (ponteiroDireita >= ponteiroEsquerda && vetor[ponteiroDireita].melhorTempo>= pivo) {
				ponteiroDireita--;
			}
			if (ponteiroEsquerda < ponteiroDireita) {
				trocar(vetor, ponteiroEsquerda, ponteiroDireita);
				ponteiroEsquerda++;
				ponteiroDireita--;
			}
		}
		trocar(vetor, inicio, ponteiroDireita);
		return ponteiroDireita;
		
		
	}

	private void trocar(Piloto[] vetor, int i, int j) {
		Piloto aux = vetor[i];
		vetor[i] = vetor[j];
		vetor[j] = aux;
		
	}
	
	public boolean completouVolta(Piloto[] pilotos) {
		int voltas = 0;
		for (int i = 0; i<14;i++) {
			if (pilotos[i].voltas == 4){
				voltas++;
			}
		}
		if (voltas==14) {
			return true;
		}
		else {
			return false;
		}
	}
}	