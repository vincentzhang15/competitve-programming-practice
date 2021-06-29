#include <iostream>
#include <vector>
using namespace std;

int main()
{
	int n;
	cin >> n;
	
	vector<int> nums;
	
	for(int i = 0; i < n; i++)
	{
		int a;
		cin >> a;
		if(a == 0)
			nums.erase(nums.begin()+nums.size()-1);
		else
			nums.push_back(a);
	}
	
	int count = 0;
	for(int i : nums)
		count += i;
	
	cout << count << endl;
	
	return 0;
}