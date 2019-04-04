 
import java.util.Arrays;
import java.util.Random;

public class SortAlgo {

	static Test []t=new Test[33];
	static double[][] timew = new double[9][6];
	static int num[];
	static int heap_size=0;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		newdata();
		int k = 0;
		System.out
				.println("		Random1000	Reverse1000	Random10000	Reverse10000	Random100000	Reverse100000");
		for (int i = 0; i < 6; i++) {
			if (i % 2 == 0) {
				for (int g = 0; g < 10; g++) {
					print(k,i);
					k++;
				}
				for(int g=0;g<9;g++)
				{
					timew[g][i]=(double)timew[g][i]/10.0;
					timew[g][i]=(double)Math.round(timew[g][i]*1000)/1000.0;
	
				}
			} else {
				print(k,i);
				k++;
			}
		}
		System.out.print("Bubble   	");
		for(int i=0;i<6;i++)
			System.out.print(timew[0][i]+"		");
		System.out.println("");
		System.out.print("selection  	");
		for(int i=0;i<6;i++)
			System.out.print(timew[1][i]+"		");
		System.out.println("");
		System.out.print("insertion	");
		for(int i=0;i<6;i++)
			System.out.print(timew[2][i]+"		");
		System.out.println("");
		System.out.print("merge  	 	");
		for(int i=0;i<6;i++)
			System.out.print(timew[3][i]+"		");
		System.out.println("");
		System.out.print("quick1 		 ");
		for(int i=0;i<6;i++)
			System.out.print(timew[4][i]+"		");
		System.out.println("");
		System.out.print("quick2  	");
		for(int i=0;i<6;i++)
			System.out.print(timew[5][i]+"		");
		System.out.println("");
		System.out.print("quick3  	");
		for(int i=0;i<6;i++)
			System.out.print(timew[6][i]+"		");
		System.out.println("");
		System.out.print("Heap  		");
		for(int i=0;i<6;i++)
			System.out.print(timew[7][i]+"		");
		System.out.println("");
		System.out.print("Library  	");
		for(int i=0;i<6;i++)
			System.out.print(timew[8][i]+"		");
		System.out.println("");
		
		

	}
	public static void print(int k,int i) {
		int[] cop = Arrays.copyOf(t[k].numb, t[k].numb.length);
		long now = System.currentTimeMillis();
		bubble(cop);
		timew[0][i] += (System.currentTimeMillis() - now) / 1000.0;
		cop = Arrays.copyOf(t[k].numb, t[k].numb.length);
		now = System.currentTimeMillis();
		selection(cop);
		timew[1][i] +=  (System.currentTimeMillis() - now) / 1000.0;
		cop = Arrays.copyOf(t[k].numb, t[k].numb.length);
		now = System.currentTimeMillis();
		insertions(cop);
		timew[2][i] +=(System.currentTimeMillis() - now) / 1000.0;
		cop = Arrays.copyOf(t[k].numb, t[k].numb.length);
		now = System.currentTimeMillis();
		merge(0, cop.length - 1, cop);
		timew[3][i] +=(System.currentTimeMillis() - now) / 1000.0;
		cop = Arrays.copyOf(t[k].numb, t[k].numb.length);
		now = System.currentTimeMillis();
		quicksort_last(0, cop.length - 1, cop);
		timew[4][i] += (System.currentTimeMillis() - now) / 1000.0;
		cop = Arrays.copyOf(t[k].numb, t[k].numb.length);
		now = System.currentTimeMillis();
		quicksort_middle(0, cop.length - 1, cop);
		timew[5][i] += (System.currentTimeMillis() - now) / 1000.0;
		cop = Arrays.copyOf(t[k].numb, t[k].numb.length);
		now = System.currentTimeMillis();
		quicksort_random(0, cop.length - 1, cop);
		timew[6][i] +=(System.currentTimeMillis() - now) / 1000.0;
		cop = Arrays.copyOf(t[k].numb, t[k].numb.length);
		now = System.currentTimeMillis();
		Heapsort(cop);
		timew[7][i] +=(System.currentTimeMillis() - now) / 1000.0;
		cop = Arrays.copyOf(t[k].numb, t[k].numb.length);
		now = System.currentTimeMillis();
		Library(cop);
		timew[8][i] +=(System.currentTimeMillis() - now) / 1000.0;
		
	}

	public static void newdata() {
		int n = 100, k = 0;
		for (int j = 0; j < 6; j++) {
			if (j % 2 == 0) {
				n *= 10;
				for (int g = 0; g < 10; g++) {
					num = new int[n];
					Random r = new Random();
					for (int i = 0; i < n; i++) {
						num[i] = r.nextInt(n) + 1;
					}
					t[k++]=new Test(num);

				}
			} else {
				num = new int[n];
				int u = n;
				for (int i = 0; i < n; i++) {
					num[i] = u--;
				}
				t[k++]=new Test(num);
			}
		}
	}

	public static void bubble(int[] cop) {
		for (int j = cop.length - 1; j > 0; j--) {
			for (int k = 0; k < j; k++) {
				if (cop[k] > cop[k + 1])
					change(k, cop);
			}
		}
	}

	public static void change(int k, int[] c) {
		int a = c[k];
		c[k] = c[k + 1];
		c[k + 1] = a;
	}

	public static void selection(int[] cop) {
		for (int j = cop.length - 1; j > 0; j--) {
			int max, num = 0;
			max = cop[j];
			for (int k = j - 1; k > 0; k--) {
				if (cop[k] > max) {
					max = cop[k];
					num = k;
				}
			}
			change2(num, cop, j);
		}
	}

	public static void change2(int k, int[] c, int j) {
		int a = c[j];
		c[j] = c[k];
		c[k] = a;
	}

	public static void insertions(int[] cop) {

		for (int j = 1; j < cop.length; j++) {
			int numq = cop[j];
			for (int q = j - 1; q >= 0; q--) {
				if (cop[q] > numq) {
					cop[q + 1] = cop[q];
					if (q == 0)
						cop[q] = numq;
				} else {
					cop[q + 1] = numq;
					break;
				}
			}
		}

	}

	public static void merge(int start, int finish, int[] cop) {
		if (start < finish) {
			int q = (start + finish) / 2;
			merge(start, q, cop);
			merge(q + 1, finish, cop);
			mer(start, q, finish, cop);
		}
	}

	public static void mer(int start, int midle, int finish, int[] cop) {
		int i = start, j = midle + 1, k = 0;
		int[] set = new int[finish - start + 1];
		while (i <= midle && j <= finish) {
			if (cop[i] <= cop[j]) {
				set[k++] = cop[i];
				i++;
			} else if (cop[i] > cop[j]) {
				set[k++] = cop[j];
				j++;
			}
		}
		while (i <= midle) {
			set[k++] = cop[i];
			i++;
		}
		while (j <= finish) {
			set[k++] = cop[j];
			j++;
		}
		System.arraycopy(set, 0, cop, start, finish - start + 1);
	}

	public static void quicksort_last(int k, int last, int[] cop) {
		if (last > k) {
			int q = quick(k, last, cop);
			quicksort_last(k, q - 1, cop);
			quicksort_last(q + 1, last, cop);
		}
	}

	public static int quick(int start, int last, int[] cop) {
		int max = cop[last];
		int i = start-1;
		for (int j = start; j < last; j++) {
			if (cop[j] <= max) {
				i++;
				change2(i,cop,j);
				
			}
		}
		change2(i+1,cop,last);
		return i+1;
	}

	public static void quicksort_middle(int k, int last, int[] cop) {
		if (last > k) {
			int q = quickm(k, last, cop);
			quicksort_middle(k, q - 1, cop);
			quicksort_middle(q + 1, last, cop);
		}
	}

	public static int quickm(int start, int last, int[] cop) {
		int max = compare(start, last, (start + last) / 2, cop);
		int i = start;
		for (int j = start; j < last; j++) {
			if (cop[j] <= max) {
				change2(i,cop,j);
				i++;
			}
		}
		change2(i,cop,last);
		return i;
	}

	public static int compare(int start, int last, int middle, int[] cop) {
		int result = cop[middle];
		if (cop[start] > result) {
			change2(start,cop,last);
			return cop[last];
		} else if (cop[last] < result)
			return cop[last];
		change2(middle,cop,last);
		return cop[last];
	}

	public static void quicksort_random(int k, int last, int[] cop) {
		if (last > k) {
			int q = quickr(k, last, cop);
			quicksort_random(k, q - 1, cop);
			quicksort_random(q + 1, last, cop);
		}

	}
	public static int quickr(int start, int last, int[] cop) {
		Random q=new Random();
		int max=q.nextInt(last-start)+start;
		change2(max,cop,last);
		max=cop[last];
		int i = start;
		for (int j = start; j < last; j++) {
			if (cop[j] <= max) {
				change2(j,cop,i);
				i++;
			}
		}
		change2(i,cop,last);
		return i;
	}
	public static void MAX_HEAPIFY(int k, int[] cop) {
		
		while(k*2+1<=heap_size) 
		{
			int j=k*2+1;
			if(k*2+2<=heap_size)
			{
				if(cop[k*2+1]<cop[k*2+2])
					j=k*2+2;
			}
			if(cop[k]<cop[j])
				change2(k,cop,j);
			else
				return ;
			k = j;
		}
	}
	public static void Heap(int[] cop) {
		int i=(cop.length-1)/2;
		while(i>=0) {
			MAX_HEAPIFY(i,cop);
			i--;
		}
	}
	public static void Heapsort(int[] cop)
	{
		heap_size=cop.length-1;
		Heap(cop);
		for(int i=heap_size;i>=1;i--) {
			change2(i,cop,0);
			heap_size--;
			MAX_HEAPIFY(0,cop);
		}
	}
	public static void Library(int[] cop) {
		Arrays.sort(cop);
	}
}