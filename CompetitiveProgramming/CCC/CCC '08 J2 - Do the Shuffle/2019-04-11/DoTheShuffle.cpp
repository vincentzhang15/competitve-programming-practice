#include <iostream>
#include <vector>
using namespace std;

int main()
{
	vector<char> nums = {'A', 'B', 'C', 'D', 'E'};
	
	for(;;)
	{
		int a, b;
		cin >> a >> b;
		
		switch(a)
		{
			case 1:
				for(int i = 0; i < b; i++)
				{
					char temp = nums[0];
					nums.erase(nums.begin());
					nums.push_back(temp);
				}
				break;
			case 2:
				for(int i = 0; i < b; i++)
				{
					nums.insert(nums.begin(), nums[nums.size()-1]);
					nums.erase(nums.begin() + nums.size()-1);
				}
				break;
			case 3:
				if(b % 2 == 1)
				{
					char temp = nums[0];
					nums[0] = nums[1];
					nums[1] = temp;
				}
				break;
			case 4:
				for(char c : nums)
					cout << c << " ";
				cout << endl;
				return 0;
		}
	}
	
	return 0;
}