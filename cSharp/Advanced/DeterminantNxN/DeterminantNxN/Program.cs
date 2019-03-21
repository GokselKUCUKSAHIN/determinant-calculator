using System;
namespace DeterminantNxN
{
    class Program
    {
        static void Main()
        {
            Console.Write("nxn Matris Boyutunu girin->");
            int n = 0;
            try
            {
                n = int.Parse(Console.ReadLine());
                if(n < 2 || n > 100)
                {
                    if (n > 100)
                    {
                        Console.WriteLine("Girilen değer aşırı büyük!\nDaha küçük boyutları deneyin.\nDevam Etmek bir için bir tuşa basın...");
                    }
                    else
                    {
                        Console.WriteLine("Girilen değer 2'den küçük olamaz\nDevam Etmek bir için bir tuşa basın...");
                    }
                    Console.ReadKey();
                    Main();
                }
            }
            catch (FormatException)
            {
                Console.Write("Geçersiz değer girişi Tekrar Deneyin.\nDevam Etmek bir için bir tuşa basın...");
                Console.ReadKey();
                Main();
            }
            float[,] Matris = new float[n, n];
            for (int i = 0; i < n; i++)
            {
                for (int j = 0; j < n; j++)
                {
                    try
                    {
                        Console.Write("{0}. Satırının {1}. elemanını girin: ", i + 1, j + 1);
                        Matris[i, j] = float.Parse(Console.ReadLine());
                    }
                    catch (FormatException)
                    {
                        j--;
                    }
                }
            }
            MatrisYazdir(Matris);
            Console.WriteLine(DeterminantHesapla(Matris));
        }
        private static float DeterminantHesapla(float[,] matrix)
        {
            int rLen = matrix.GetLength(0); //satır sayısı
            float oran; //oran değişkeni
            for (int i = 0; i < rLen; i++)
                for (int j = 0; j < rLen; j++)
                    if (j > i) //üst üçgen
                    {
                        oran = matrix[j, i] / matrix[i, i];
                        for (int k = 0; k < rLen; k++)
                            matrix[j, k] -= oran * matrix[i, k];
                    }
            float det = 1;
            for (int i = 0; i < rLen; i++)
                det *= matrix[i, i];
            return (float)Math.Round(det);
        }
        private static void MatrisYazdir(float[,] M)
        {
            int r = M.GetLength(0); //satır sayısı
            int c = M.GetLength(1); //kolon sayısı
            for (int i = 0; i < r; i++)
            {
                Console.Write("[");
                for (int j = 0; j < c; j++)
                    Console.Write("{0,4} ", M[i, j]);
                Console.WriteLine("]");
            }
        }
    }
}
/*
//test matrixleri
float[,] A = new float[3, 3] { { 4, 2, 5 }, { 2, 6, 8 }, { 11, 5, 12 } };
float[,] B = new float[4, 4] { { 3, 4, 5, 9 }, { 1, 2, 8, 5 }, { 6, 5, 2, 4 }, { 8, 3, 9, 5 } };
float[,] C = new float[5, 5] { { 1, 2, 3, 4, 5 }, { 4, 3, 2, 5, 6 }, { 7, 9, 6, 3, 4 }, { 7, 5, 5, 1, 2 }, { 5, 4, 3, 7, 6 } };
float[,] D = new float[6, 6] { { 1, 2, 3, 4, 5, 6 }, { 11, 13, 7, 2, 1, 9 }, { 3, 2, 6, 11, 7, 21 }, { 11, 9, 8, 3, 1, 14 }, { 6, 9, 11, 2, 8, 1 }, { 16, 3, 2, 9, 4, 8 } };
*/