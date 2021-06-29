#include <iostream>
#include <vector>
using namespace std;

int main()
{
	int n;
	cin >> n;
	
	vector <int> list;
	for(int i = 0; i < n; i++)
	{
		int temp;
		cin >> temp;
		list.push_back(temp);
	}

	while(list.size() > 0)
	{
		int min = *list.begin();
		int index = 0;
		for(int i = 0; i < list.size(); i++)
		{
			if(list[i] < min)
			{
				min = list[i];
				index = i;
			}
		}
		cout << min << endl;
		list.erase(list.begin() + index);

	}

	return 0;
}