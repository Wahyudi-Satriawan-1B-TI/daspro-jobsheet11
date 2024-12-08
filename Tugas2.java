import java.util.Scanner;

public class Tugas2 {
    static int[][] penjualan = new int[5][7];
    static String[] menu = {"Kopi", "Teh", "Es Degan", "Roti Bakar", "Gorengan"};

    public static void inputPenjualan() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Masukkan data penjualan:");
        for (int i = 0; i < menu.length; i++) {
            System.out.println("Menu: " + menu[i]);
            for (int j = 0; j < 7; j++) {
                System.out.print("Hari ke-" + (j + 1) + ": ");
                penjualan[i][j] = scanner.nextInt();
            }
        }
    }

    public static void tampilkanPenjualan() {
        System.out.println("\nData Penjualan:");
        System.out.printf("%-12s", "Menu/Hari");
        for (int i = 1; i <= 7; i++) {
            System.out.printf("Hari %d\t", i);
        }
        System.out.println();
        for (int i = 0; i < menu.length; i++) {
            System.out.printf("%-12s", menu[i]);
            for (int j = 0; j < 7; j++) {
                System.out.printf("%d\t\t", penjualan[i][j]);
            }
            System.out.println();
        }
    }

    public static void menuPenjualanTertinggi() {
        int maxPenjualan = 0;
        String menuTerlaris = "";

        for (int i = 0; i < menu.length; i++) {
            int totalPenjualan = 0;
            for (int j = 0; j < 7; j++) {
                totalPenjualan += penjualan[i][j];
            }
            if (totalPenjualan > maxPenjualan) {
                maxPenjualan = totalPenjualan;
                menuTerlaris = menu[i];
            }
        }

        System.out.println("\nMenu dengan penjualan tertinggi:");
        System.out.println(menuTerlaris + " dengan total penjualan: " + maxPenjualan);
    }

    public static void rataRataPenjualan() {
        System.out.println("\nRata-rata penjualan untuk setiap menu:");
        for (int i = 0; i < menu.length; i++) {
            int totalPenjualan = 0;
            for (int j = 0; j < 7; j++) {
                totalPenjualan += penjualan[i][j];
            }
            double rataRata = (double) totalPenjualan / 7;
            System.out.printf("%s: %.2f%n", menu[i], rataRata);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        inputPenjualan();

        int pilihan;
        do {
            System.out.println("\nMenu:");
            System.out.println("1. Tampilkan seluruh data penjualan");
            System.out.println("2. Tampilkan menu dengan penjualan tertinggi");
            System.out.println("3. Tampilkan rata-rata penjualan untuk setiap menu");
            System.out.println("0. Keluar");
            System.out.print("Pilihan Anda: ");
            pilihan = scanner.nextInt();

            switch (pilihan) {
                case 1:
                    tampilkanPenjualan();
                    break;
                case 2:
                    menuPenjualanTertinggi();
                    break;
                case 3:
                    rataRataPenjualan();
                    break;
                case 0:
                    System.out.println("Keluar dari program.");
                    break;
                default:
                    System.out.println("Pilihan tidak valid.");
            }
        } while (pilihan != 0);
    }
}
