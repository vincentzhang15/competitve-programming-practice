import java.util.*;

public class j5
{
	public static void main(String [] args)
	{
		Scanner in = new Scanner(System.in);
		int favouriteteam = in.nextInt();
		int gamessofar = in.nextInt();
		
		int [] teamA = new int [gamessofar];
		int [] teamB = new int [gamessofar];
		int [] ascore = new int [gamessofar];
		int [] bscore = new int [gamessofar];
		
		int favouriteteamscore = 0;
		int gamesfavteamplayed = 0;
		
		HashMap teamsplaying = new HashMap();
		HashMap teamscore = new HashMap();
		
		for(int i = 0; i < gamessofar; i++)
		{
			teamA[i] = in.nextInt();
			teamB[i] = in.nextInt();
			ascore[i] = in.nextInt();
			bscore[i] = in.nextInt();
		}
		for(int i = 0; i < gamessofar; i++)
		{
			if(teamA[i] == favouriteteam);
			{
				gamesfavteamplayed += 1;
				if(ascore[i] == bscore[i])
					favouriteteamscore += 1;
				else if(ascore[i] > bscore[i])
					favouriteteamscore += 3;
			}
			if(teamB[i] == favouriteteam);//else if
			{
				gamesfavteamplayed += 1;
				if(ascore[i] == bscore[i])
					favouriteteamscore += 1;
				else if(ascore[i] < bscore[i])
					favouriteteamscore += 3;
			}			
		}
		System.out.println(favouriteteamscore);
	}
}

