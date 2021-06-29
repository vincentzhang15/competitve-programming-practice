import java.util.*;

public class j5new
{
	class Signature implements Comparable<Signature> {
		 
		TreeSet<Integer> ts = new TreeSet<Integer>();
		public String item;
		 
		public int hashCode(){
			int hashcode = item.hashCode();
			return hashcode;
		}
		 
		public boolean equals(Object obj){
			//System.out.println("In equals");
			if (obj instanceof Signature) {
				Signature pp = (Signature) obj;
				return (pp.item.equals(this.item));
			} else {
				return false;
			}
		}
		
	    public int compareTo(Signature o) {
			return o.item.compareTo(this.item);
		}
		
		void update()
		{
			item = "";
			for(Iterator it = ts.iterator(); it.hasNext(); )
			{
				item = item + "," + (Integer)it.next();
			}
		}
		
		public void insert(int x)
		{
			ts.add(x);
			update();
		}
		public void add(Signature sig)
		{
			for(Iterator it = sig.ts.iterator(); it.hasNext();)
				ts.add((Integer)it.next());
			
			update();
		}
		public String toString()
		{
			return item;
		}		
	}
	
	
	int N;
	//int q[];
	int p[];

	HashSet<Signature> s = new HashSet<Signature>();
	TreeSet<Signature> s2 = new TreeSet<Signature>();

	
	boolean valid(Signature s)
	{
		for(Iterator it = s.ts.iterator(); it.hasNext(); )
		{
			Integer pid = (Integer)it.next();
			for(int i=0; i<p.length; i++)
			{
				if(pid == p[i])
				{
					if(!s.ts.contains(i))
					{
						return false;
					}
				}
			}
		}
		return true;
	}
	
	void buildCasesSub(Signature st1, Signature sig1, int level)
	{
			boolean started = false;
			for(Iterator it2 = s.iterator(); it2.hasNext(); ) 
			{
				if(!started)
				{
					Signature st = (Signature)it2.next();
					if( st.equals(st1))
						started = true;
					continue;
				}
				
				Signature st2 = (Signature)it2.next();
				
				Signature sig2 = new Signature();
				sig2.add(sig1);
				sig2.add(st2);
				
				if(valid(sig2))
					s2.add(sig2);
				
				System.out.println(" ... " + level + "   " + sig2.item);

				buildCasesSub(st2, sig2, level+1);
			}
	}

	void buildCases()
	{
		for(Iterator it1 = s.iterator(); it1.hasNext(); ) 
		{
			Signature st1 = (Signature)it1.next();
			
			if(valid(st1))
				s2.add(st1);
			
			System.out.println(" ... 1   " + st1.item);
			
			buildCasesSub(st1, st1, 2);
		}
	}
	
	void run()
	{
		Scanner scanner = new Scanner(System.in);
		N = scanner.nextInt();
		
		p = new int[N];
		//q = new int[N];
		
		for(int i = 1; i < N; i++)
		{
			p[i] = scanner.nextInt();
			//p[i] = 0;
		}

		/*
		for(int i = 1; i < N; i++)
		{
			if(q[i] == N)
				continue;
			
			p[q[i]] = i;
		}
		*/

		/*
		for(int i = 1; i < N; i++)
		{
			System.out.println(" ... q   " + q[i]);
		}

			System.out.println("");
		*/
		
		for(int i = 1; i < N; i++)
		{
			System.out.println(" ... p   " + p[i]);
		}

			System.out.println("");
		
		
		
		for(int i = 1; i < N; i++)
		{
			Signature signature = new Signature();
			signature.insert(i);
			/*
			for(int j = p[i]; j!= N; j = p[j])
			{
				signature.insert(j);
			}
			*/
			s.add(signature);
			
			System.out.println(" ... 0   " + signature);
		}
		
			System.out.println("");

		buildCases();

			System.out.println("");
			
		for(Iterator it = s2.iterator(); it.hasNext();)
		{
			System.out.println(" s2: " + ((Signature)it.next()));
		}

			System.out.println("");
			
		System.out.println(s2.size()+1);
		
//		System.out.println(totalposibilities());
	}

	public static void main (String [] args)
	{
		j5new obj = new j5new();
		obj.run();
	}
}
