#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

int main()
{
	string s1, s2;
	cin >> s1 >> s2;
	
	vector<char> list1(s1.begin(), s1.end());
	vector<char> list2(s2.begin(), s2.end());
	
	for(int i = 0; i < list2.size(); i++)
	{
		if(find(list1.begin(), list1.end(), list2[i]) != list1.end())
		{
			list1.erase(find(list1.begin(), list1.end(), list2[i]));
			list2.erase(list2.begin()+i);
			i = -1;
		}
	}
	
	for(auto i : list2)
	{
		if(i != '*')
		{
			cout << "N" << endl;
			return 0;
		}
	}
	cout << "A" << endl;

	return 0;
}