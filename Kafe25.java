import java.util.Scanner;

public class Kafe25 {
    static String kodePromo, namaPelanggan;
    static boolean isMember;

    public static void Menu(String namaPelanggan, boolean isMember, String kodePromo) {
        System.out.println("Selamat datang, " + namaPelanggan + "!");

        if (isMember) {
            System.out.println("Anda adalah member, dapatkan diskon 10% untuk setiap pembelian!");
        }
        System.out.println("Anda memasukkan kode promo: " + kodePromo);
        if (kodePromo.equalsIgnoreCase("DISKON50")) {
            System.out.println("Anda mendapatkan diskon tambahan sebesar 50%");
        } else if (kodePromo.equalsIgnoreCase("DISKON30")) {
            System.out.println("Anda mendapatkan diskon tambahan sebesar 30%");
        } else if (!kodePromo.equalsIgnoreCase("NONE")) {
            System.out.println("Kode promo tidak valid.");
        }

        System.out.println("===== MENU RESTO KAFE =====");
        System.out.println("1. Kopi Hitam - Rp 15,000");
        System.out.println("2. Cappuccino - Rp 20,000");
        System.out.println("3. Latte - Rp 22,000");
        System.out.println("4. Teh Tarik - Rp 12,000");
        System.out.println("5. Roti Bakar - Rp 10,000");
        System.out.println("6. Mie Goreng - Rp 18,000");
        System.out.println("===========================");
        System.out.println("Silahkan pilih menu yang Anda inginkan.");
    }

    public static int hitungTotalHarga(int pilihanMenu, int banyakItem) {
        int[] hargaItems = {15000, 20000, 22000, 12000, 10000, 18000};
        return hargaItems[pilihanMenu - 1] * banyakItem;
    }

    public static int hitungTotalKeseluruhan(int totalHarga, String kodePromo) {
        if (kodePromo.equalsIgnoreCase("DISKON50")) {
            totalHarga *= 0.5;
        } else if (kodePromo.equalsIgnoreCase("DISKON30")) {
            totalHarga *= 0.7;
        } else if (!kodePromo.equalsIgnoreCase("NONE")) {
            System.out.println("Kode promo tidak valid. Tidak ada diskon yang diberikan.");
        }

        if (isMember) {
            totalHarga *= 0.9;
        }
        return totalHarga;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Masukkan nama pelanggan: ");
        namaPelanggan = sc.nextLine();
        System.out.print("Apakah terdaftar menjadi member? (true/false): ");
        isMember = sc.nextBoolean();
        sc.nextLine();
        System.out.print("Masukkan kode promo: ");
        kodePromo = sc.nextLine();

        Menu(namaPelanggan, isMember, kodePromo);

        int totalKeseluruhan = 0;

        boolean selesai = false;
        while (!selesai) {
            System.out.print("\nMasukkan nomor menu yang ingin Anda pesan: ");
            int pilihanMenu = sc.nextInt();

            if (pilihanMenu < 1 || pilihanMenu > 6) {
                System.out.println("Nomor menu tidak valid. Silakan pilih nomor antara 1–6.");
                continue;
            }

            System.out.print("Masukkan jumlah item yang ingin dipesan: ");
            int banyakItem = sc.nextInt();

            totalKeseluruhan += hitungTotalHarga(pilihanMenu, banyakItem);

            System.out.print("Apakah Anda ingin menambah pesanan lain? (yes/no): ");
            sc.nextLine();
            String jawab = sc.nextLine();
            if (jawab.equalsIgnoreCase("no")) {
                selesai = true;
            }
        }

        int totalSetelahDiskon = hitungTotalKeseluruhan(totalKeseluruhan, kodePromo);

        System.out.println("\nTotal harga pesanan Anda sebelum diskon: Rp" + String.format("%,d", totalKeseluruhan));
        System.out.println("Total harga pesanan Anda setelah diskon: Rp" + String.format("%,d", totalSetelahDiskon));
        System.out.println("Terima kasih telah berkunjung, " + namaPelanggan + "!");

        sc.close();
    }
}
