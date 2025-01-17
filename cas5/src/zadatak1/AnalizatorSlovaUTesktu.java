package zadatak1;

public class AnalizatorSlovaUTesktu {
String tekst="nepoznat";

public String getTekst() {
	return tekst;
}

public void setTekst(String tekst) {
	this.tekst = tekst;
}

int duzinaTeksta() {
	return tekst.length();
}

int pojavljivanjeMalogA() {
	int brojac=0;
	for (int i = 0; i < tekst.length(); i++) {
		if(tekst.charAt(i)=='a') {
			brojac++;
		}
	}
	return brojac;
}

int pojavljivanjeSlova(char slovo) {
	int brojac=0;
	for (int i = 0; i < tekst.length(); i++) {
		if(tekst.charAt(i)==slovo) {
			brojac++;
		}
	}
	return brojac;
	
}

int brojRecenica() {
	int brojac=0;
	for (int i = 0; i <tekst.length(); i++) {
		if(tekst.charAt(i)=='.' || tekst.charAt(i)=='!' || tekst.charAt(i)=='?') {
			brojac++;
		}
	}
	return brojac;
}

int brojSamoglasnika() {
	int brojac=0;
	for (int i = 0; i <tekst.length(); i++) {
		if(tekst.charAt(i)=='a' || tekst.charAt(i)=='A' || tekst.charAt(i)=='e' || tekst.charAt(i)=='E' || tekst.charAt(i)=='i' || tekst.charAt(i)=='I' || tekst.charAt(i)=='o' || tekst.charAt(i)=='O' || tekst.charAt(i)=='u' || tekst.charAt(i)=='U') {
			brojac++;
		}
	}
	return brojac;
}

char maxZnak() {
	int maxPonavljanje=Integer.MIN_VALUE;
	char maxZnak=' ';
	
	for (int i = 0; i < tekst.length(); i++) {
		if(pojavljivanjeSlova(tekst.charAt(i))>maxPonavljanje && tekst.charAt(i)!=' ') {
			maxPonavljanje=pojavljivanjeSlova(tekst.charAt(i));
			maxZnak=tekst.charAt(i);
		
		}
	}
	System.out.print("Broj ponavljanja: "+maxPonavljanje+" ");
	return maxZnak;

}

char minZnak() {
	int minPonavljanje=Integer.MAX_VALUE;
	char minZnak=' ';
	
	for (int i = 0; i < tekst.length(); i++) {
		if(pojavljivanjeSlova(tekst.charAt(i))<minPonavljanje && tekst.charAt(i)!=' ') {
			minPonavljanje=pojavljivanjeSlova(tekst.charAt(i));
			minZnak=tekst.charAt(i);
		
		}
	}
	System.out.print("Broj ponavljanja: "+minPonavljanje+" ");
	return minZnak;

}

int prvoPojavljivanjeA() {
	return tekst.indexOf('a');
}

int zadnjePojavljivanjeA() {
	return tekst.lastIndexOf('a');
}

int prvoPojavljivanje(char slovo) {
	return tekst.indexOf(slovo);
}

int zadnjePojavljivanje(char slovo) {
	return tekst.lastIndexOf(slovo);
}

int drugoPojavljivanje(char slovo) {
	if(pojavljivanjeSlova(slovo)<2) {
		System.out.println("Nema drugog ponavljanja!");
		return -1;
		}
	int i=prvoPojavljivanje(slovo);
	i++;
	while(tekst.charAt(i)!=slovo) {
		i++;
	}
	
	return i;
}

int pretposlednjePojavljivanje(char slovo) {
	if(pojavljivanjeSlova(slovo)<2) {
		System.out.println("Nema pretposlednjeg pojavljivanja ponavljanjaa!");
		return -1;
		}
	else if (pojavljivanjeSlova(slovo)==2) {
		return prvoPojavljivanje(slovo);
	} else {
	int i=zadnjePojavljivanje(slovo);
	System.out.println(i);
	i--;
	

	while(tekst.charAt(i)!=slovo) {
		
		i--;
	}
	
	return i;
	}
}




}
