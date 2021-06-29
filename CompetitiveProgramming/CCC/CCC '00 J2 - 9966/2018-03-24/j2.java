import java.util.*;

public class j2
{
	public static void main(String [] args)
	{
		Scanner s = new Scanner(System.in);
		int lower = s.nextInt();
		int upper = s.nextInt();

		int count = 0;
		for(int i = lower; i <= upper; i++)
		{
			String check = Integer.toString(i);
			for(int j = 0; j < check.length(); j++)
			{
				if(check.charAt(j) != '1' && check.charAt(j) != '6' && check.charAt(j) != '8' && check.charAt(j) != '9')
				{
					break;
				}
				else
				{
					if(check.length() >= 2)
					{
						if(check.charAt(j) == '6')
						{
							if(j == check.length() -1)
								break;
							else
							{
								if(check.charAt(j+1) != '9')
									break;
							}
						}
						else
						{
							if(check.charAt(j) == '1')
							{
								if(j == check.length() -1)
									break;
								else
								{
									if(check.charAt(j+1) == '6' || check.charAt(j+1) == '8' || check.charAt(j+1) == '9')
										break;
								}
							}
							if(check.charAt(j) == '6')
							{
								if(j == check.length() -1)
									break;
								else
								{
									if(check.charAt(j+1) == '1' || check.charAt(j+1) == '8')
										break;
								}
							}
							if(check.charAt(j) == '8')
							{
								if(j == check.length() -1)
									break;
								else
								{
									if(check.charAt(j+1) == '1' || check.charAt(j+1) == '6' || check.charAt(j+1) == '9')
										break;
								}
							}
							if(check.charAt(j) == '9')
							{
								if(j == check.length() -1)
									break;
								else
								{
									if(check.charAt(j+1) == '1' || check.charAt(j+1) == '6' || check.charAt(j+1) == '8')
										break;
								}
							}
						}
						if(check.charAt(1) != '1' && check.charAt(1) != '8' && check.charAt(1) != '6' && check.charAt(1) != '9')
						{
							break;
						}
					}
					if(check.length() == 1)
					{
						if(check.charAt(0) == '6' || check.charAt(0) == '9')
							break;
					}
					System.out.println(i);
					count++;
				}
			}
		}
		System.out.println(count);
	}
}