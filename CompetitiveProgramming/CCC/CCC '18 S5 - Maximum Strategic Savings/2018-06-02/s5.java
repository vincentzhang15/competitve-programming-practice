import java.util.*;

public class s5
{
	int originalSize = 0;
	class Flight // or portal
	{
		int p1, p2; // planet;
		int c1, c2; // city 1, city 2
		int cost;
		Flight(int planet1, int city1, int planet2, int city2, int energy)
		{
			p1 = planet1;
			p2 = planet2;
			c1 = city1;
			c2 = city2;
			cost = energy;
		}
		void print()
		{
			//System.out.println("  node: id = " + id);
		}
	};

	ArrayList<Flight> flights = new ArrayList<Flight>();

	int	remove_flights_from_and_to_same_city()
	{
		int saved = 0;
		for(int i = flights.size()-1; i >= 0; i--)
		{
			if(flights.get(i).c1 == flights.get(i).c2)
			{
				saved += flights.get(i).cost;
				flights.remove(i);
			}
		}
		return saved;
	}
	int	remove_duplicated_flights()
	{
		int saved = 0;
		for(int i=0; i< flights.size(); i++)
		{
			while(i<flights.size())
			{
				boolean changed = false;
				for(int j=i+1; j<flights.size(); j++)
				{
					if( ( flights.get(i).c1 == flights.get(j).c1 && flights.get(i).c2 == flights.get(j).c2) 
						|| ( flights.get(i).c1 == flights.get(j).c2 && flights.get(i).c2 == flights.get(j).c1) )
					{
						if(flights.get(i).cost > flights.get(j).cost )
						{
							saved += flights.get(i).cost;
							flights.remove(i);
							changed = true;
						}
						else
						{
							saved += flights.get(j).cost;
							flights.remove(j);
							changed = true;
						}
					}
				}
				if(!changed)
					break;
			}
		}
		return saved;
	}
	
	int	remove_highest_cost_flight_or_portal_in_a_loop()
	{
		int saved = 0;
		for(int i=0; i< flights.size(); i++)
		{
			while(i<originalSize)
			{
				boolean changed = false;
				for(int j=i+1; j<flights.size() - originalSize; j++)
				{
					if( ( flights.get(i).c1 == flights.get(j).c1 && flights.get(i).c2 == flights.get(j).c2) 
						|| ( flights.get(i).c1 == flights.get(j).c2 && flights.get(i).c2 == flights.get(j).c1) )
					{
						if(flights.get(i).cost > flights.get(j).cost )
						{
							saved += flights.get(i).cost;
							flights.remove(i);
							changed = true;
						}
						else
						{
							saved += flights.get(j).cost;
							flights.remove(j);
							changed = true;
						}
					}
				}
				if(!changed)
					break;
			}
		}
		return saved;
	}

	
	void run()
	{
		Scanner s = new Scanner(System.in);
		int N_planets = s.nextInt();
		int M_cities = s.nextInt();
		int P_flights = s.nextInt();
		int Q_portals = s.nextInt();
		
		for(int i = 0; i < P_flights; i++)
		{
			int city1 = s.nextInt();
			int city2 = s.nextInt();
			int energy = s.nextInt();
			flights.add(new Flight(1, city1, 1, city2, energy));
		}

		int total_saved = 0;
		total_saved += remove_flights_from_and_to_same_city();
		total_saved += remove_duplicated_flights();
		
		total_saved *= N_planets;
		
		int number_of_flights_on_a_planet = flights.size();
		for(int j = 2; j <= N_planets; j ++)
		{
			for(int i=0;i<number_of_flights_on_a_planet; i++)
			{
				flights.add(new Flight(j, flights.get(i).c1, j, flights.get(i).c2, flights.get(i).cost));
			}
		}

		originalSize = flights.size();
		for(int i = 0; i < Q_portals; i++)
		{
			int planet1 = s.nextInt();
			int planet2 = s.nextInt();
			int energy = s.nextInt();
			
			for(int j = 1; j <= M_cities; j ++)
			{
				flights.add(new Flight(planet1, j, planet2, j, energy));
			}
		}
		
		total_saved += remove_highest_cost_flight_or_portal_in_a_loop();
		
		System.out.println(total_saved);
	}
	
	public static void main(String [] args)
	{
		s5 obj = new s5();
		obj.run();
	}   
}