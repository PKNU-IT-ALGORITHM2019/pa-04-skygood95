import java.util.Comparator;

public class Weplog {

	String IP;
	String URL;
	String Status;
	String Time;

	public Weplog(String IP, String Time, String URL, String Status) {
		this.IP = IP;
		this.URL = URL;
		this.Status = Status;
		this.Time = Time;
	}

	public static Comparator<Weplog> IPComparator = new Comparator<Weplog>() {
		public int compare(Weplog log1, Weplog log2) {
			return log1.IP.compareTo(log2.IP);
		}
	};
	public static Comparator<Weplog> TIMEComparator = new Comparator<Weplog>() {
		public int compare(Weplog log1, Weplog log2) {
			String fir1 = log1.Time.split("/")[1];
			String fir2 = log2.Time.split("/")[1];
			//System.out.println(fir1);
			int k1=find(fir1);
			int k2=find(fir2);
			if (k1==k2) {
				fir1 = log1.Time.split("/")[0];
				fir2 = log2.Time.split("/")[0];
				if (fir1.compareTo(fir2) == 0) {
					fir1 = log1.Time.split("/")[2];
					fir2 = log2.Time.split("/")[2];
					return fir1.compareTo(fir2);
				}
				return fir1.compareTo(fir2);
			}
			if(k1<k2)
				return -1;
			else if(k1>k2)
				return 1;
			else 
				return 0;
		}
	};
	public static int find(String a) {
		if(a.compareTo("Jan")==0)
			return 1;
		else if(a.compareTo("Feb")==0)
			return 2;
		else if(a.compareTo("Mar")==0)
			return 3;
		else if(a.compareTo("Apr")==0)
			return 4;
		else if(a.compareTo("May")==0)
			return 5;
		else if(a.compareTo("Jun")==0)
			return 6;
		else if(a.compareTo("Jul")==0)
			return 7;
		else if(a.compareTo("Aug")==0)
			return 8;
		else if(a.compareTo("Sep")==0)
			return 9;
		else if(a.compareTo("Oct")==0)
			return 10;
		else if(a.compareTo("Nov")==0)
			return 11;
		else if(a.compareTo("Dec")==0)
			return 12;
		return 0;
	}
}
