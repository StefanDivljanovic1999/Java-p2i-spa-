package zadatak2;

public class VisineProba {
public static void main(String[] args) {
	VisineClanovaEkipe v= new VisineClanovaEkipe(5);
	v.unesi(168);
	v.unesi(202);
	v.unesi(194);
	v.unesi(181);
	v.unesi(229);
	
	v.ispisi();
	
	System.out.println("Prosek visina: " +v.vratiProsek());
	System.out.println("Razlika izmedju najviseg i najnizeg igraca je: "+v.vratiNajvecuRazliku()+"cm." );
}
}