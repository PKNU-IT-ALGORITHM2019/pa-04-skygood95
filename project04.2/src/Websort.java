import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class Websort {

	Weplog[] wep = new Weplog[100000];
	int num = 0;
	int number = 0;

	public void start() {
		String first;
		while (true) {
			System.out.print("$ ");
			Scanner kb = new Scanner(System.in);
			first = kb.next();
			if (first.equals("read")) {
				first = kb.next();
				read(first);
			} else if (first.equals("sort")) {
				first = kb.next();
				if (first.equals("-t"))
					SortT();
				else if (first.equals("-ip"))
					SortIP();

			} else if (first.equals("print")) {
				print();
			} else if (first.equals("exit")) {
				System.exit(0);
			}
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Websort a = new Websort();
		a.start();
	}

	public void read(String a) {
		try {
			Scanner files = new Scanner(new File(a));
			String loginfor = files.nextLine();
			loginfor = files.nextLine();
			wep[num] = new Weplog(loginfor.split(",")[0], loginfor.split(",")[1], loginfor.split(",")[2],
					loginfor.split(",")[3]);
			while (files.hasNext()) {
				num++;
				loginfor = files.nextLine();
				wep[num] = new Weplog(loginfor.split(",")[0], loginfor.split(",")[1], loginfor.split(",")[2],
						loginfor.split(",")[3]);
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void print() {
		int k = 0;
		if (number == 0) {
			while (k <= num) {
				System.out.println(wep[k].Time);
				System.out.println("	IP: " + wep[k].IP);
				System.out.println("	URL: " + wep[k].URL);
				System.out.println("	Status: " + wep[k].Status);
				k++;
			}
		} else if (number == 1) {
			while (k <= num) {
				System.out.println(wep[k].IP);
				System.out.println("	Time: " + wep[k].Time);
				System.out.println("	URL: " + wep[k].URL);
				System.out.println("	Status: " + wep[k].Status);
				k++;
			}
		}
	}

	public void SortT() {
		Arrays.sort(wep, 0, num + 1, Weplog.TIMEComparator);
		number = 0;
	}

	public void SortIP() {
		Arrays.sort(wep, 0, num + 1, Weplog.IPComparator);
		number = 1;
	}

}
