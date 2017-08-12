package www.Bruteforce;

public class MainClass {

	public static void main(String[] args) {
		try {
			ThreadMaster tm = new ThreadMaster(29, new CodesGenerator().getListOfCodesFourDigits());
			tm.runThreads();
		} catch (Exception ex) {
			System.out.println("The program failed to exectute ... :(");
		}
	}
}
