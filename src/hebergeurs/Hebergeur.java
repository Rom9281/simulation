package hebergeurs;

interface Hebergeur {
	private boolean acceuil = false;
	
	public static boolean peutAcceuillir() {
		return acceuil;
	}
}
