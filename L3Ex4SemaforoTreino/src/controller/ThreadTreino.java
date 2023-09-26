package controller;

import java.util.concurrent.Semaphore;

import model.Piloto;

public class ThreadTreino extends Thread {
	
	public Semaphore pista;
	public Semaphore escuderia;
	private Piloto piloto;

	public ThreadTreino(Piloto piloto, Semaphore pista, Semaphore escuderia) {
		this.piloto = piloto;
		this.pista = pista;
		this.escuderia = escuderia;
	}
	
	public void run() {
		try {
			pista.acquire();
			try {
				escuderia.acquire();
				volta();
			} catch (Exception e) {
	
			} finally {
				escuderia.release();
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			pista.release();
		}
	}

	private void volta() {
		while (piloto.voltas <=3) {
			System.out.println("Piloto #"+piloto.numero+" saiu para a pista");
			/*try {
				sleep(1000);
			} catch (Exception e) {
			
			}*/
			int tempo = (int) ((Math.random()*41)+20);
			if (tempo<piloto.melhorTempo || piloto.melhorTempo == 0) {
				piloto.melhorTempo = tempo;
			}
			System.out.println("Piloto #"+piloto.numero+" completou a volta em "+tempo+"s.");
			piloto.voltas++;
		}
	}

}
