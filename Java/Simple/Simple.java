import java.util.Scanner;

public class Simple
{

    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        System.out.print("nxn Matris Boyutunu girin->");
        int n = Integer.parseInt(scanner.nextLine());
        float[][] Matris = new float[n][n];
        for (int i = 0; i < n; i++)
        {
            for (int j = 0; j < n; j++)
            {
                System.out.printf("%d. Satırının %d. elemanını girin: ", i + 1, j + 1);
                Matris[i][j] = Float.parseFloat(scanner.nextLine());
            }
        }
        System.out.println(DeterminantHesapla(Matris));
    }

    private static float DeterminantHesapla(float[][] matrix)
    {
        int rLen = matrix.length; //satır sayısı
        float oran; //oran değişkeni
        for (int i = 0; i < rLen; i++)
            for (int j = 0; j < rLen; j++)
                if (j > i) //üst üçgen
                {
                    oran = matrix[j][i] / matrix[i][i];
                    for (int k = 0; k < rLen; k++)
                        matrix[j][k] -= oran * matrix[i][k];
                }
        float det = 1;
        for (int i = 0; i < rLen; i++)
            det *= matrix[i][i];
        return Math.round(det);
    }
}
