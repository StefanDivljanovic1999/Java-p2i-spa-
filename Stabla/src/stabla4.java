

import labis.cvorovi.CvorStabla;
import labis.stabla.ABinarnoStablo;

public class stabla4 extends ABinarnoStablo {
	public int broj(CvorStabla k) {
		if(k==null) {
			return 0;
		}
		return 1+broj(k.levo)+broj(k.desno);
	}
	public int zbir(CvorStabla k) {
		if(k==null) {
			return 0;
		}
	return 	k.podatak+  zbir(k.levo)+zbir(k.desno);
	}
	public int zbir_parnih(CvorStabla k) {
		if(k==null) {
			return 0;
		}
		if(k.podatak%2==0) {
			return k.podatak+zbir_parnih(k.levo)+zbir_parnih(k.desno);
		}
		return zbir_parnih(k.levo)+zbir_parnih(k.desno);
	}
	public int proizvod_pozitivnih_trocifrenih(CvorStabla k) {
		if(k==null) {
			return 1;
		}
		if(k.podatak>99 && k.podatak<1000) {
			return k.podatak*proizvod_pozitivnih_trocifrenih(k.levo)*proizvod_pozitivnih_trocifrenih(k.desno);
		}
		return proizvod_pozitivnih_trocifrenih(k.levo)*proizvod_pozitivnih_trocifrenih(k.desno);
	}
	public int broj_neparnih_listova(CvorStabla k) {
		if(k==null) {
			return 0;
		}
		if(k.levo== null && k.desno==null && k.podatak%2!=0) {
			return 1+broj_neparnih_listova(k.levo)+broj_neparnih_listova(k.desno);
		}
		return broj_neparnih_listova(k.levo)+broj_neparnih_listova(k.desno);
	}
	public int zbir_negativnih_polulistova(CvorStabla k) {
		if(k==null) {
			return 0;
		}
		if((k.levo==null) != (k.desno==null) && k.podatak<0) {
			return k.podatak+zbir_negativnih_polulistova(k.levo)+zbir_negativnih_polulistova(k.desno);
		}
		return zbir_negativnih_polulistova(k.levo)+zbir_negativnih_polulistova(k.desno);
	
	}
	public int proizvod_un_deca_listovi(CvorStabla k) {
		if(k==null) {
			return 1;
		}
		if((k.levo!=null && k.desno!=null) && 
				(k.levo.levo==null && k.levo.desno==null) && (k.desno.desno==null&& k.desno.levo==null)) {
			return k.podatak*proizvod_un_deca_listovi(k.levo)*proizvod_pozitivnih_trocifrenih(k.desno);
		}
		return proizvod_un_deca_listovi(k.levo)*proizvod_pozitivnih_trocifrenih(k.desno);
	}
	public boolean prost(int p) {
		int brojac=0;
		for (int i = 1; i <=p; i++) {
			if(p%i==0) {
				brojac++;
			}
		}
		return brojac==2;
	}
	public int proizvod_prostih(CvorStabla k) {
		if(k==null) {
			return 1;
		}
		if(prost(k.podatak)) {
			return k.podatak*proizvod_prostih(k.levo)*proizvod_prostih(k.desno);
		}
		return proizvod_prostih(k.levo)*proizvod_prostih(k.desno);
	}
	public int zbir_deljivih_bar_jednim_detetom(CvorStabla k) {
		if(k==null) {
			return 0;
		}
		if((k.levo!=null && k.podatak%k.levo.podatak==0) ||
				(k.desno!=null && k.podatak%k.desno.podatak==0)) {
			return k.podatak+zbir_deljivih_bar_jednim_detetom(k.levo)+zbir_deljivih_bar_jednim_detetom(k.desno);
		}
		return zbir_deljivih_bar_jednim_detetom(k.levo)+zbir_deljivih_bar_jednim_detetom(k.desno);
	}
	public boolean postoji(CvorStabla k,int p) {
		if(k==null) {
			return false;
		}
		if(k.podatak==p) {
			return true;
		}
		return postoji(k.levo, p) || postoji(k.desno, p);
	}
	public boolean postoji_cvor_u_stablu(CvorStabla k, CvorStabla c) {
		if(k==null || c==null) {
			return false;
		}
		if(k==c) {
			return true;
		}
		return postoji_cvor_u_stablu(k.levo, c) || postoji_cvor_u_stablu(k.desno, c);
	}
	public boolean postoji_neparan_list(CvorStabla k) {
		if(k==null) {
			return false;
		}
		if(k.levo==null && k.desno==null && k.podatak%2!=0) {
			return true;
		}
		return postoji_neparan_list(k.levo)||postoji_neparan_list(k.desno);
	}
	public boolean svaki_polulist_ima_parno_dete(CvorStabla k) {
		if(k==null) {
			return true;
		}
		if((k.levo!=null && k.desno==null && k.levo.podatak%2!=0)
				|| (k.desno!=null && k.levo==null && k.desno.podatak%2!=0)) {
			return false;
		}
		return svaki_polulist_ima_parno_dete(k.levo)&&svaki_polulist_ima_parno_dete(k.desno);
	}
	public boolean svi_pozitivni(CvorStabla k) {
		if(k==null) {
			return true;
		}
		if(k.podatak<0) {
			return false;
		}
		return svi_pozitivni(k.levo)&&svi_pozitivni(k.desno);
	}
	public boolean svi_listovi_deljivi_roditeljem(CvorStabla k) {
		if(k==null) {
			return true;
		}
		if((k.levo!=null && k.levo.levo==null && k.levo.desno==null && k.levo.podatak%k.podatak!=0) ||
			(k.desno!=null && k.desno.levo==null && k.desno.desno==null && k.desno.podatak%k.podatak!=0)) {
			return false;
		}
		return svi_listovi_deljivi_roditeljem(k.levo)&& svi_listovi_deljivi_roditeljem(k.desno);
	}
	public boolean svi_unutrasnji_deljivi_korenom(CvorStabla k) {
		if(k==null) {
			return true;
		}
		if(k.levo!=null && k.desno!=null && k.podatak%koren.podatak!=0) {
			return false;
		}
		return svi_unutrasnji_deljivi_korenom(k.levo)&&svi_unutrasnji_deljivi_korenom(k.desno);
	}
	public int max_vr(CvorStabla k) {
		if(k==null) {
			return Integer.MIN_VALUE;
		}
		return Math.max(k.podatak, Math.max(max_vr(k.levo), max_vr(k.desno)));
	}
	public CvorStabla min(CvorStabla k) {
		if(k==null) {
			return null;
		}
		CvorStabla min=k;
		CvorStabla l= min(k.levo);
		CvorStabla d= min(k.desno);
		if(l!=null && l.podatak<min.podatak) {
			min=l;
		}
		if(d!=null && d.podatak<min.podatak) {
			min=d;
		}
		return min;
	}
	public CvorStabla min_pozitivan(CvorStabla k) {
		if(k==null) {
			return null;
		}
		CvorStabla min=null;
		CvorStabla l= min_pozitivan(k.levo);
		CvorStabla d= min(k.desno);
		if(l.podatak>0) {
			min=l;
		}
		if(l!=null && (min==null || l.podatak<min.podatak)) {
			min=l;
		}
		if(d!=null &&(min==null || d.podatak<min.podatak)) {
			min=d;
		}
		return min;
		
	}
	public CvorStabla pronadji(CvorStabla k, int p) {
		if(k==null) {
			return null;
		}
		if(k.podatak==p) {
			return k;
		}
		CvorStabla l=pronadji(k.levo, p);
		CvorStabla d= pronadji(k.desno, p);
	 if(l!=null) {
		 return l;
	 }
	 return d;
	}
	public CvorStabla pronadjiBST(CvorStabla k, int p) {
		if(k==null) {
			return null;
		}
		if(k.podatak==p) {
			return k;
		}
		if(k.podatak<p) {
			return pronadjiBST(k.levo, p);
		}
		return pronadjiBST(k.desno, p);
	}
	public CvorStabla roditelj(CvorStabla k, CvorStabla c) {
		if(k==null || c==null || k==c) {
			return null;
		}
		if(k.levo==c || k.desno==c) {
			return k;
		}
		CvorStabla l= roditelj(k.levo, c);
		CvorStabla d= roditelj(k.desno, c);
		if(l!=null) {
			return l;
		}
		return d;
	}
	public int visina(CvorStabla k) {
		if(k==null) {
			return 0;
		}
		return 1+Math.max(visina(k.levo), visina(k.desno));
	}
	public int nivo(CvorStabla k, CvorStabla c) {
		if(k== null || c==null || !postoji_cvor_u_stablu(k, c)) {
			return 0;
		}
		if(k==c) {
			return 1;
		}
		if(postoji_cvor_u_stablu(k.levo, c)) {
			return 1+nivo(k.levo, c);
		}
		return 1+nivo(k.desno, c);
	}
	public CvorStabla maxPolulist(CvorStabla k) {
		if(k==null) {
			return null;
		}
		CvorStabla max=null;
		if((k.levo==null) != (k.desno==null)) {
			max=k;
		}
		CvorStabla l= maxPolulist(k.levo);
		CvorStabla d= maxPolulist(k.desno);
		if(l!=null && (max==null || l.podatak>max.podatak)) {
			max=l;
		}
		if(d!=null && (max==null || d.podatak>max.podatak)) {
			max=d;
		}
		return max;
	}
	public CvorStabla najdublji_list(CvorStabla k) {
		if(k==null) {
			return null;
		}
		if(k.levo==null && k.desno==null) {
			return k;
		}
		if(visina(k.levo)>visina(k.desno)) {
			return najdublji_list(k.levo)
					;
		}
		return najdublji_list(k.desno);
	}
	public CvorStabla najplici_list(CvorStabla k) {
		if(k==null) {
			return null;
		}
		if(k.levo==null && k.desno==null) {
			return k;
		}
		CvorStabla l= najdublji_list(k.levo);
		CvorStabla d= najplici_list(k.desno);
		if(l==null) {
			return d;
		}
		if(d==null) {
			return l;
		}
		if(nivo(k, l)<nivo(k, d)) {
			return l;
		} else {
			return d;
		}
	}
	public void ispisi_polulistove_na_nivou(CvorStabla k, int n) {
		if(k==null || n<1) {
			return;
		}
		if((k.levo==null)!=(k.desno==null) && nivo(koren, k)==n) {
			System.out.println(k.podatak);
		}
		ispisi_polulistove_na_nivou(k.levo, n);
		ispisi_polulistove_na_nivou(k.desno, n);
	}
	public void ispisi(CvorStabla k) {
		if(k==null) {
			return;
		}
		System.out.print("  "+k.podatak);
		ispisi(k.levo);
		ispisi(k.desno);
	}
	public void ispisi_polulistove_rastuce(CvorStabla k) {
		if(k==null) {
			return;
		}
		ispisi_polulistove_rastuce(k.levo);
		if((k.levo==null)!=(k.desno==null)) {
			System.out.println(k.podatak);
		}
		ispisi_polulistove_rastuce(k.desno);
		
	}
	public void iste_parnosti_kao_koren(CvorStabla k) {
		if(k==null) {
			return;
		}
		iste_parnosti_kao_koren(k.desno);
		if((k.podatak%2==0 && koren.podatak%2==0) ||
				(k.podatak%2!=0 && koren.podatak%2!=0)) {
			System.out.println(k.podatak);
		}
		iste_parnosti_kao_koren(k.levo);
	}
	public void ispisi_sve_parne_listove_rastuce(CvorStabla k) {
		if(k==null) {
			return;
		}
		ispisi_sve_parne_listove_rastuce(k.levo);
		if(k.podatak%2==0 && k.levo==null && k.desno==null) {
			System.out.println(k.podatak);
		}
		ispisi_sve_parne_listove_rastuce(k.desno);
	}
	public void tri_puta_vece_u_levom_nego_u_desnom(CvorStabla k) {
		if(k==null) {
			return;
		}
		tri_puta_vece_u_levom_nego_u_desnom(k.desno);
		if(broj(k.levo)==3*broj(k.desno)) {
			System.out.println(k.podatak);
		}
		tri_puta_vece_u_levom_nego_u_desnom(k.levo);
	}
	public boolean balansirano(CvorStabla k) {
		if(k==null) {
			return true;
		}
		if(Math.abs(visina(k.levo)-visina(k.desno))>1) {
			return false;
		}
		return balansirano(k.levo)&&balansirano(k.desno);
	}
	public boolean kompletno(CvorStabla k) {
		if(k==null) {
			return true;
		}
		if(visina(k.levo) != visina(k.desno)) {
			return false;
		}
		return kompletno(k.levo)&&kompletno(k.desno);
	}
	public boolean BST(CvorStabla k) {
		if(k==null) {
			return true;
		}
		if(!(max_vr(k.levo)<k.podatak && k.podatak<max_vr(k.desno))) {
			return false;
		}
		return BST(k.levo)&&BST(k.desno);
	}
	public boolean heap(CvorStabla k) {
		if(k==null) {
			return true;
		}
		if(koren.podatak<max_vr(k)) {
			return false;
		}
		return heap(k.levo)&&heap(k.desno);
	}
	public void ubaci( CvorStabla k, int p ) {
	if(p<k.podatak) {
		if(k.levo==null) {
			k.levo= new CvorStabla(p, null, null);
		} else {
			ubaci(k.levo, p);
		}
	} else {
		if(k.desno==null) {
			k.desno= new CvorStabla(p, null, null);
		} else {
			ubaci(k.desno, p);
		}
	}
	}
	public int zbir_predaka(CvorStabla k, CvorStabla c1, CvorStabla c2) {
		if(k==null || c1==null || c2==null || !postoji_cvor_u_stablu(k, c1) ||
				!postoji_cvor_u_stablu(k, c2)) {
			return 0;
		}
		if(postoji_cvor_u_stablu(k.levo, c1) && postoji_cvor_u_stablu(k.levo, c2)) {
			return k.podatak+zbir_predaka(k.levo, c1, c2);
		}
		else if(postoji_cvor_u_stablu(k.desno, c2) && postoji_cvor_u_stablu(k.desno, c2)) {
			return k.podatak+zbir_predaka(k.desno, c1, c2);
		}
		else {
			return k.podatak;
		}
	}
	public boolean ista_struktura(CvorStabla k1, CvorStabla k2 ) {
		if(k1==null && k2==null) {
			return true;
		}
		if((k1.levo==null)!=(k2.levo==null)|| (k1.desno==null) != (k2.desno==null)) {
			return false;
		}
		return ista_struktura(k1.levo, k2.levo) && ista_struktura(k1.desno, k2.desno);
	}
	public boolean ista_struktura_i_vrednost(CvorStabla k1, CvorStabla k2) {
		if(k1==null && k2==null) {
			return true;
		}
	if(k1==null || k2==null) {
		return false;
	}
	if(k1.podatak!=k2.podatak) {
		return false;
	}
	if((k1.levo==null)!=(k2.levo==null)|| (k1.desno==null) != (k2.desno==null)) {
		return false;
	}
		return ista_struktura_i_vrednost(k1.levo, k2.levo)&&ista_struktura_i_vrednost(k1.desno, k2.desno);
	}
	public boolean ogledalo(CvorStabla k1, CvorStabla k2) {
		if(k1==null && k2==null) {
			return true;
		}
		if(k1==null || k2==null) {
			return true;
		}
		if((k1.levo==null)!=(k2.desno==null)
				|| (k1.desno==null)!=(k2.levo==null)) {
			return false;
		}
		return ogledalo(k1.levo, k2.desno) && ogledalo(k1.desno, k2.levo);
	}
	public CvorStabla max(CvorStabla k) {
		if(k==null) {
			return null;
		}
		CvorStabla maks=k;
		CvorStabla l= max(k.levo);
		CvorStabla d= max(k.desno);
		if(l!=null && k.podatak>maks.podatak) {
			maks=l;
		}
		if(d!=null && d.podatak>maks.podatak) {
			maks=d;
		}
		return d;
	}
	public void quiz(int i) {
		if(i>1) {
			quiz(i/2);
			System.out.println(i);
			quiz(i/3);
		}
		System.out.println(i);
	}
	public void quiz1(int i) {
		if(i>0) {
			quiz1(i-2);
			quiz1(i-2);
			System.out.println(i);
		}
	}
	public void quiz2(int i) {
		if(i<1) {
			return;
		}
		System.out.print(" * ");
		if(i%3==0) {
			quiz2(--i);
			System.out.print(" "+i+" ");
			quiz(i/2);
		}
		if(i%3==1) {
			quiz2(i/2);
			System.out.print(" "+i+" ");
			quiz2(i/3);
		}
	}
	public void quiz3(int n) {
		System.out.println(n);
		
		if(n++>3) {
			System.out.println(++n);
			return;
		}
		quiz3(n+1);
	}
	public int preci(CvorStabla k, CvorStabla c1, CvorStabla c2) {
		if(k==null || c1==null || c2==null || !postoji_cvor_u_stablu(k, c2) ||
			!postoji_cvor_u_stablu(k, c1)){
			return 0;
		}
		if(postoji_cvor_u_stablu(k.levo, c2) && postoji_cvor_u_stablu(k.levo, c1)) {
			return k.podatak + preci(k.levo, c1, c2);
		}
		else if(postoji_cvor_u_stablu(k.desno, c2) && postoji_cvor_u_stablu(k.desno, c1)) {
			return k.podatak + preci(k.desno, c1, c2);
		}
		else return k.podatak;
	}
	public boolean struktura(CvorStabla k1, CvorStabla k2) {
		if(k1==null && k2==null) {
			return true;
		}
		if(k1==null || k2==null) {
			return false;
		}
		if(k1.levo!=null && k2.levo==null || k1.desno!=null && k2.desno==null ||
				k1.levo==null && k2.levo!=null || k1.desno==null && k2.desno!=null ) {
			return false;
		}
		return struktura(k1.levo, k2.levo) && struktura(k1.desno, k2.desno);
	}
	public boolean ekvivalentna(CvorStabla k1, CvorStabla k2) {
		if(k1==null && k2==null) {
			return true;
		}
		if(k1==null || k2==null) {
			return true;
		}
		if(k1.podatak!=k2.podatak) {
			return false;
		}
		if(k1.levo!=null && k2.levo==null || k1.desno!=null && k2.desno==null ||
				k1.levo==null && k2.levo!=null || k1.desno==null && k2.desno!=null ) {
			return false;
		}
		return ekvivalentna(k1.levo, k2.levo) && ekvivalentna(k1.desno, k2.desno);
	}
	public boolean ogledalce(CvorStabla k1, CvorStabla k2) {
		if(k1== null && k2==null) {
			return true;
		}
		if(k1== null || k2==null) {
			return true;
		}
		if((k1.levo==null )!= (k2.desno==null) || (k1.desno==null )!=(k2.levo==null)) {
			return false;
		}
		return ogledalce(k1.levo, k2.desno) && ogledalce(k1.desno, k2.levo);
	}
	public void ispisi_svaki_drugi(CvorStabla k) {
		if(k==null) {
			return;
		}
		
	}
	public CvorStabla max_stablo(CvorStabla k) {
		if(k==null) {
			return null;
		}
		CvorStabla max= k;
		CvorStabla l= max_stablo(k.levo);
		CvorStabla d= max_stablo(k.desno);
		if(l!=null && (max==null || l.podatak>max.podatak)) {
			max=l;
		}
		if(d!=null && (max==null || d.podatak>max.podatak)) {
			max=d;
		}
		return max;
	}
	public CvorStabla max_parni_polulist(CvorStabla k) {
		if(k==null) {
			return null;
		}
		CvorStabla max=null;
		if((k.levo==null)!=(k.desno==null) && k.podatak%2==0) {
			max=k;
		}
		CvorStabla l= max_parni_polulist(k.levo);
		CvorStabla d= max_parni_polulist(k.desno);
		if(l!=null && (max==null || l.podatak>max.podatak)) {
			max=l;
		}
		if(d!=null && (max==null || d.podatak>max.podatak)) {
			max=d;
		}
		return max;
	}
	public boolean postoji1(CvorStabla k, CvorStabla c) {
		if(k==null || c==null) {
			return false;
		}
		if(k==c) {
			return true;
		}
		return postoji1(k.levo, c)|| postoji1(k.desno, c);
	}
	public CvorStabla roditej(CvorStabla k, CvorStabla c) {
		if(k==null || c==null ||k==c) {
			return null;
		}
		if(k.levo==c || k.desno==c) {
			return k;
		}
		CvorStabla l= roditej(k.levo, c);
		CvorStabla d= roditej(k.desno, c);
		if(l!=null) {
			return l;
		}
		return d;
	
	}
	public int visina1(CvorStabla k) {
		if(k==null) {
			return 0;
		}
	return 1+Math.max(visina1(k.levo), visina1(k.desno));
	}
	public int zbir_pozitivnih(CvorStabla k) {
		if(k==null) {
			return 0;
		}
		if(k.podatak<0) {
			return zbir_pozitivnih(k.levo)+zbir_pozitivnih(k.desno);
		}
		return k.podatak+ zbir_pozitivnih(k.levo)+zbir_pozitivnih(k.desno);
	}
	public int zbir_negativnih(CvorStabla k) {
		if(k==null) {
			return 0;
		}
		if(k.podatak>0) {
			return zbir_negativnih(k.levo)+zbir_negativnih(k.desno);
		}
		return k.podatak+ zbir_negativnih(k.levo)+zbir_negativnih(k.desno);
	}
	public int razlika(CvorStabla k) {
		return zbir_pozitivnih(k)-Math.abs(zbir_negativnih(k));
	}
	public void ispisi_koren_do_cvor(CvorStabla k, CvorStabla c) {
		if(k==null || c==null || !postoji1(k, c)) {
			return;
		}
		System.out.println(k.podatak);
		if(k==c) {
			return;
		}
		if(postoji1(k.levo, c)) {
			ispisi_koren_do_cvor(k.levo, c);
		} else {
			ispisi_koren_do_cvor(k.desno, c);
		}
	}
	public CvorStabla najplici_list1(CvorStabla k) {
		if(k==null ) {
			return null;
		}
		if(k.levo==null || k.desno==null) {
			return k;
		}
		CvorStabla l= najplici_list1(k.levo);
		CvorStabla d=  najplici_list1(k.desno);
		if(nivo(k, l)<nivo(k, d)) {
			return l;
		}
		return d;
	}
	public int max_zbir_do_lista(CvorStabla k) {
		if(k==null) {
			return 0;
		}
		if(k.levo==null && k.desno==null) {
			return k.podatak;
		}
	int l;
	int d;
	if(k.desno==null) {
		l= max_zbir_do_lista(k.levo);
		return l+k.podatak;
	}
	
	if(k.levo==null) {
		d= max_zbir_do_lista(k.desno);
		return d+k.podatak;
	}
	l=max_zbir_do_lista(k.levo);
	d=max_zbir_do_lista(k.desno);
	return k.podatak+ Math.max(l, d);
	}
	public void ispisi_od_korena_do_lista(CvorStabla k, CvorStabla c) {
		if(k==null || c==null || !postoji1(k, c) ||
				c.levo!=null && c.desno!=null) {
			return;
		}
System.out.println(k.podatak);
	if(k==c) {
		return;
	}
	if(postoji1(k.levo, c)) {
		ispisi_od_korena_do_lista(k.levo, c);
	}
	else {
		ispisi_koren_do_cvor(k.desno, c);
	}
	}
	public int proizvod_listova(CvorStabla k) {
		if(k==null) {
			return 1;
		}
		
		if(k.levo==null && k.desno==null) {
			return k.podatak*proizvod_listova(k.desno)*proizvod_listova(k.desno);
		}
		return proizvod_listova(k.levo)*proizvod_listova(k.desno);
		
	}
	public int broj_el_u_intervalu(CvorStabla k, int dg, int gg) {
		if(k==null ) {
			return 0;
		}
		if(k.podatak<gg && k.podatak>dg) {
		 return 1+ broj_el_u_intervalu(k.levo, dg, gg)+broj_el_u_intervalu(k.desno, dg, gg);
		} else {
		return broj_el_u_intervalu(k.levo, dg, gg)+broj_el_u_intervalu(k.desno, dg, gg);
		}
		}
	public int proizv_zaj_predaka(CvorStabla k, CvorStabla c1, CvorStabla c2) {
			if(k==null ||c1==null || c2==null ||
					!postoji1(k, c2) || !postoji1(k, c1)) {
				return 0;
			}
			
			
			if(postoji1(k.levo, c2) && postoji1(k.levo, c1)) {
			return k.podatak*proizv_zaj_predaka(k.levo, c1, c2);
			}
			else if(postoji1(k.desno, c2) && postoji1(k.desno, c1)) {
				return k.podatak*proizv_zaj_predaka(k.desno, c1, c2);
				}
			else {
				return k.podatak;
			}
		}
	public int proizvod_listova1(CvorStabla k) {
		if(k==null) {
			return 1;
		}
		if(k.levo==null && k.desno==null) {
			return k.podatak* proizvod_listova1(k.levo)*proizvod_listova1(k.desno);
		}
		return proizvod_listova1(k.levo)*proizvod_listova1(k.desno);
	}
	public int max_razlika_roditelja_i_deteta(CvorStabla k) {
		if(k==null) {
			return Integer.MIN_VALUE;
		}
	 int l= max_razlika_roditelja_i_deteta(k.levo);
	 int d= max_razlika_roditelja_i_deteta(k.desno);
	 int trenutnaLevo= Integer.MIN_VALUE;
	 int trenutnaDesno=Integer.MIN_VALUE;
	 
	 if(k.levo!=null) {
		 trenutnaLevo= k.podatak-k.levo.podatak;
	 }
	 if(k.desno!=null) {
		 trenutnaDesno= k.podatak-k.desno.podatak;
	 }
	 return Math.max(Math.max(l, d), Math.max(trenutnaLevo, trenutnaDesno));
	}
	public int zbir_elemenata_na_nivou(CvorStabla k, int br, int nivo) {
		if(k==null) {
			return 0;
		}
	int l= zbir_elemenata_na_nivou(k.levo, br, nivo+1);
	int d= zbir_elemenata_na_nivou(k.desno, br, nivo+1);
	if( nivo==br && k.levo!=null && k.desno!=null ) {
		return l+d+k.podatak;
	} else {
	return l+d;
	}
	}
	
	
} 
