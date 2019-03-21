#include "pch.h"
#include <iostream>
using namespace std;
void MatrisYazdir(float M[][10], int len);
int main()
{
	float  matrix[10][10], ratio, det;
	int i, j, k, n;
	cout << "nxn Matrisin Boyutunu Giriniz: ";
	cin >> n;
	cout << "Matrise Eleman Giriniz: \n";
	for (i = 0; i < n; i++) {
		for (j = 0; j < n; j++) {
			cin >> matrix[i][j];
		}
	}
	//
	MatrisYazdir(matrix, n);
	for (i = 0; i < n; i++) {
		for (j = 0; j < n; j++) {
			if (j > i)
			{

				ratio = matrix[j][i] / matrix[i][i];
				for (k = 0; k < n; k++) {
					matrix[j][k] -= ratio * matrix[i][k];
				}
			}
		}
	}
	det = 1;
	for (i = 0; i < n; i++)
		det *= matrix[i][i];
	cout << "Girilen Matrisin Determinant Sonucu :";
	cout << det;
	cin >> n;
	return 0;
}
void MatrisYazdir(float M[][10], int len)
{
	for (int i = 0; i < len; i++)
	{
		cout << "[";
		for (int j = 0; j < len; j++)
			printf("%4.1f", M[i][j]);
		cout << "]" << endl;
	}
}