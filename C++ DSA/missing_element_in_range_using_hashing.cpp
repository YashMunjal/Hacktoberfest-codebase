#include <bits/stdc++.h> 
using namespace std; 

void printMissing(int arr[], int n, int low, 
				int high) 
{ 
	unordered_set<int> s; 
	for (int i = 0; i < n; i++) 
		s.insert(arr[i]); 

	for (int x = low; x <= high; x++) 
		if (s.find(x) == s.end()) 
			cout << x << " "; 
} 

int main() 
{ 
	int arr[] = { 1, 3, 5, 4 }; 
	int n = sizeof(arr) / sizeof(arr[0]); 
	int low = 1, high = 10; 
	printMissing(arr, n, low, high); 
	return 0; 
} 
