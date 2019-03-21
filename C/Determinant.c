#include <stdio.h>
#include <stdlib.h>
#include <math.h>
float DeterminantHesapla(float matrix[][10],int len);

int main() {
	float  matrix[10][10], ratio, det;
	int i, j, n;
	printf("nxn Matrisinin Boyutunu Girininz: ");
	scanf("%d",&n);
	printf("Matrise Eleman Giriniz:  ");
	for (i = 0; i < n; i++) {
		for (j = 0; j < n; j++) {
			scanf("%f",&matrix[i][j]);
		}
	}
	float ret = DeterminantHesapla(matrix,n);
	printf("%4.2f\n",ret);
	system("pause");
	return 0;
}
float DeterminantHesapla(float matrix[][10],int len)
{
	int rLen = len,i,j,k; //satır sayısı
    float oran; //oran değişkeni
    for (i = 0; i < rLen; i++)
        for (j = 0; j < rLen; j++)
            if (j > i) //üst üçgen
            {
                oran = matrix[j][i] / matrix[i][i];
                for (k = 0; k < rLen; k++)
                    matrix[j][k] -= oran * matrix[i][k];
        	}
    float det = 1;
    for (i = 0; i < rLen; i++)
        det *= matrix[i][i];
    return round(det);
}
