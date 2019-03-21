import java.util.Scanner;

public class Advanced
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        System.out.print("nxn Matris Boyutunu girin->");
        int n = 0;
        try
        {
            n = Integer.parseInt(scanner.nextLine());
            if (n < 2 || n > 100)
            {
                if (n > 100)
                {
                    System.out.println("Girilen değer aşırı büyük!\nDaha küçük boyutları deneyin.\nDevam Etmek bir için Enter'a basın...");
                } else
                {
                    System.out.println("Girilen değer 2'den küçük olamaz\nDevam Etmek bir için Enter'a basın...");
                }
                scanner.nextLine(); //kullanıcının Entera basmasını bekle
               // main(new String[]{"args"});
            }
        }
        catch (NumberFormatException e)
        {
            System.out.println("Geçersiz değer girişi Tekrar Deneyin.\\nDevam Etmek bir için Entera basın...");
            scanner.nextLine(); //kullanıcının Entera basmasını bekle
            //main(new String[]{"args"});
        }
        float[][] Matris = new float[n][n];
        for (int i = 0; i < n; i++)
        {
            for (int j = 0; j < n; j++)
            {
                try
                {
                    System.out.printf("%d. Satırının %d. elemanını girin: ", i + 1, j + 1);
                    Matris[i][j] = Float.parseFloat(scanner.nextLine());
                }
                catch (NumberFormatException ex)
                {
                    j--;
                }
            }
        }
        MatrisYazdir(Matris);
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

    private static void MatrisYazdir(float[][] M)
    {
        int r = M.length; //satır sayısı
        int c = M[0].length; //kolon sayısı
        for (int i = 0; i < r; i++)
        {
            System.out.printf("[");
            for (int j = 0; j < c; j++)
                System.out.printf("%4.0f", M[i][j]);
            System.out.println("]");
        }
    }
}
