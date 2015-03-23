
public class Model {
	/**
	 * Attribute
	 */
	private int[] laufzeit;
	private double[] guthabenZins, guthabenZinsesZins;
	private double zinssatz, zinsfusz;
	/**
	 * init
	 */
	public void initialise(double zinsfusz, int laufzeit, double startkapital) {
		this.zinsfusz = zinsfusz;
		calculateLaufzeit(laufzeit);
		calculateGuthabenZins(laufzeit, startkapital);
		calculateGuthabenZinsesZins(laufzeit, startkapital);
	}
	/**
	 * Getter / Setter
	 */
	public int[] getLaufzeit() {
		return laufzeit;
	}
	public void setLaufzeit(int[] laufzeit) {
		this.laufzeit = laufzeit;
	}
	
	public double[] getGuthabenZins() {
		return guthabenZins;
	}
	public void setGuthabenZins(double[] guthabenZins) {
		this.guthabenZins = guthabenZins;
	}
	
	public double[] getGuthabenZinsesZins() {
		return guthabenZinsesZins;
	}
	public void setGuthabenZinsesZins(double[] guthabenZinsesZins) {
		this.guthabenZinsesZins = guthabenZinsesZins;
	}
	
	public double getZinssatz() {
		return zinssatz;
	}
	public void setZinssatz(double zinssatz) {
		this.zinssatz = zinssatz;
		this.zinsfusz = (zinssatz * 100);
	}
	
	public double getZinsfusz() {
		return zinsfusz;
	}
	public void setZinsfusz(double zinsfusz) {
		this.zinsfusz = zinsfusz;
		this.zinssatz = (zinsfusz / 100);
	}
	/**
	 * Methoden
	 */
	protected void calculateLaufzeit(int laufzeit) {
		this.laufzeit = new int[laufzeit + 1];
		for (int i = 0; i < this.laufzeit.length; i++) {
			this.laufzeit[i] = i;
		}
	}
	
	protected void calculateGuthabenZins(int laufzeit, double startkapital) {
		this.guthabenZins = new double[laufzeit + 1];
		this.guthabenZins[0] = startkapital;
		for (int i = 1; i < guthabenZins.length; i++) {
			this.guthabenZins[i] = this.guthabenZins[i - 1] + (startkapital * this.zinssatz);
		}
	}
	
	protected void calculateGuthabenZinsesZins(int laufzeit, double startkapital) {
		this.guthabenZinsesZins = new double[laufzeit + 1];
		this.guthabenZinsesZins[0] = startkapital;
		for (int i = 1; i < guthabenZins.length; i++) {
			this.guthabenZinsesZins[i] = this.guthabenZinsesZins[i - 1] + (this.guthabenZinsesZins[i - 1] * this.zinssatz);
		}
	}
}
