import java.util.*;

class Friend
{
		public int wait;
		public int state;
		public Friend()
		{
			wait = 0;
			state = 1;
		}
};

class J201504 {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int m = in.nextInt();

		HashMap<Integer, Friend> friends = new HashMap<Integer,Friend>();
		char lastcmd=' ';
		for(int i=0; i < m; i++)
		{
			String str = in.next();
			char cmd = str.charAt(0);
			int n = in.nextInt();
			Integer k = new Integer(n);
			
			int wait = 0;
			switch(cmd)
			{
			case 'R':
			case 'S':
				wait = 1;
				lastcmd = cmd;
				break;
			case 'W':
				if(lastcmd=='W')
					wait = n;
				else
					wait = n-1;
				
				lastcmd = cmd;
				break;
			}
			
			{
				Iterator it = friends.entrySet().iterator();
				while(it.hasNext())
				{
					Map.Entry entry = (Map.Entry)it.next();
					Integer key = (Integer)entry.getKey();
					Friend friend = (Friend)entry.getValue();
				
					if(friend.state == 1)
					{
						friend.wait += wait;
					}
				}
			}
			
			switch(cmd)
			{
			case 'R':
				{
					Friend friend1 = (Friend)friends.get(k);
					if(friend1==null)
						friends.put(new Integer(k), new Friend());
					else
						friend1.state = 1; // state 1: waiting for send reply
				}
				break;
			case 'S':
				{
					Friend friend1 = (Friend)friends.get(k);
					if(friend1!=null)
						friend1.state = 0; // state 0: message has been replied
				}
				break;
			}
		}	
			
		{
			TreeSet<Integer> keys = new TreeSet<Integer>(friends.keySet());
			for (Integer key : keys) { 
				Friend friend = (Friend)friends.get(key);
			
				System.out.print(key);
				System.out.print(' ');
				
				if(friend.state == 1)
					System.out.println(-1);
				else
					System.out.println(friend.wait);
			}
		}
	}
};