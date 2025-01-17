package zadatak1;

import java.util.Iterator;

public class TezineClanovaEkipe {

	double[] nizTezina;
	int brojac=0;
	
	public TezineClanovaEkipe() {
		nizTezina= new double[20];
		for (int i = 0; i < nizTezina.length; i++) {
			nizTezina[i]=-1;
		}
	}
	
	public void unesi(double tezina) {
		if(tezina<40.5 || brojac>=nizTezina.length) {
			return;
		}
		
		
		nizTezina[brojac++]=tezina;
	}
	
	public void ispisi() {
		for (int i = 0; i < nizTezina.length; i++) {
			if(nizTezina[i]!=-1)
			System.out.println(nizTezina[i]);
		}
	}
	
	boolean pronadjiTezinu(double tezina) {
		for (int i = 0; i < nizTezina.length; i++) {
			if(nizTezina[i]==tezina) {
				return true;
			}
		}
		return false;
		
	}
	
	double pronadjiNajlakseg() {
		double min= Double.MAX_VALUE;
		for (int i = 0; i < nizTezina.length; i++) {
			if(nizTezina[i]<min && nizTezina[i]!=-1) {
				min= nizTezina[i];
			}
		}
		return min;
	}
	
	void ispisiKategorije() {
		int brojLaka=0;
		int brojSrednja=0;
		int brojTeska=0;
		
		for (int i = 0; i < nizTezina.length; i++)
		{
			if(nizTezina[i]==-1) {
				continue;
			}
			if(nizTezina[i]<65) {
				brojLaka++;
			}
			else if (nizTezina[i]>=65 && nizTezina[i]<85) {
				brojSrednja++;
			}
			else {
				brojTeska++;
			}
		}
		System.out.println("Broj igraca lake kategorije: "+brojLaka);
		System.out.println("Broj igraca srednje kategorije: "+brojSrednja);
		System.out.println("Broj igraca teske kategorije: "+brojTeska);

	}
	
	
}

