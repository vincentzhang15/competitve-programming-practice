#include <iostream>
using namespace std;

int main()
{
	int square [4][4];
	for(int i = 0; i < 4; i++)
		for(int j = 0; j < 4; j++)
			cin >> square[i][j];
		
	int sum1 = square[0][0] + square[0][1] + square[0][2] + square[0][3];
	int sum2 = square[1][0] + square[1][1] + square[1][2] + square[1][3];
	int sum3 = square[2][0] + square[2][1] + square[2][2] + square[2][3];
	int sum4 = square[3][0] + square[3][1] + square[3][2] + square[3][3];
		
	int sum5 = square[0][0] + square[1][0] + square[2][0] + square[3][0];
	int sum6 = square[0][1] + square[1][1] + square[2][1] + square[3][1];
	int sum7 = square[0][2] + square[1][2] + square[2][2] + square[3][2];
	int sum8 = square[0][3] + square[1][3] + square[2][3] + square[3][3];
	
	if(sum1 == sum2 && sum2 == sum3 && sum3 == sum4 && sum4 == sum5 && sum5 == sum6 && sum6 == sum7 && sum7 == sum8)
		cout << "magic" << endl;
	else
		cout << "not magic" << endl;
	
	return 0;
}