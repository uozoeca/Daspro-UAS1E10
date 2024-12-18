import java.util.Scanner;

public class UAS1E10 {
    static int jumlahTim10 = 6;
    static String[] namaTim10 = new String[jumlahTim10];
    static int[][] skorTim10 = new int[jumlahTim10][2];
    static int[] totalSkor10 = new int[jumlahTim10];

    public static void inputDataSkorTim(Scanner sc10) {
        for (int i = 0; i < jumlahTim10; i++) {
            System.out.print("\nMasukkan Nama Tim Ke-" + (i + 1) + ": ");
            namaTim10[i] = sc10.nextLine();

            while (true) {
                System.out.print("Masukkan Skor " + namaTim10[i] + " Untuk Level 1: ");
                int skor110 = sc10.nextInt();
                if (skor110 < 0) {
                    System.out.println("Skor Tidak Valid, Harus Positif Atau 0");
                } else {
                    skorTim10[i][0] = (skor110 < 35) ? 0 : skor110;
                    break;
                }
            }

            while (true) {
                System.out.print("Masukkan Skor " + namaTim10[i] + " Untuk Level 2: ");
                int skor210 = sc10.nextInt();
                if (skor210 < 0) {
                    System.out.println("Skor Tidak Valid, Harus Positif Atau 0");
                } else {
                    skorTim10[i][1] = skor210;
                    break;
                }
            }
            sc10.nextLine();
        }
        System.out.println("\nData Skor Tim Berhasil Dimasukkan");
    }

    public static void hitungTotalSkor() {
        for (int i = 0; i < jumlahTim10; i++) {
            totalSkor10[i] = skorTim10[i][0] + skorTim10[i][1];
            if (totalSkor10[i] % 2 == 0) {
                totalSkor10[i] -= 15;
            }
            if (skorTim10[i][0] > 50 && skorTim10[i][1] > 50) {
                totalSkor10[i] += 10;
            }
        }
    }

    public static void tampilkanTabelSkor() {
        System.out.println("\nHasil Skor Tim:");
        System.out.printf("%-10s %-10s %-10s %-10s\n", "Nama Tim", "Level 1", "Level 2", "Total Skor");
        for (int i = 0; i < jumlahTim10; i++) {
            System.out.printf("%-10s %-10d %-10d %-10d\n", namaTim10[i], skorTim10[i][0], skorTim10[i][1], totalSkor10[i]);
        }
    }

    public static void tentukanJuaraTurnamen() {
        int maxSkor10 = totalSkor10[0];
        int pemenang10 = 0;
        boolean seri10 = false;
        for (int i = 1; i < jumlahTim10; i++) {
            if (totalSkor10[i] > maxSkor10) {
                maxSkor10 = totalSkor10[i];
                pemenang10 = i;
                seri10 = false;
            } else if (totalSkor10[i] == maxSkor10) {
                if (skorTim10[i][1] > skorTim10[pemenang10][1]) {
                    pemenang10 = i;
                    seri10 = false;
                } else if (skorTim10[i][1] == skorTim10[pemenang10][1]) {
                    seri10 = true;
                }
            }
        }
        
        if (seri10) {
            System.out.println("\nTurnamen Berakhir Seri10. Tim Terbaik Adalah Muhammad Zulfikar Dari Desa Permanu, Kecamatan Pakisaji, Kabupaten Malang");
        } else {
            System.out.println("\nSelamat Kepada Tim " + namaTim10[pemenang10] + " Yang Telah Memenangkan Kompetisi");
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int pilihan;
        do {
            System.out.println("\n=== MENU UTAMA ===");
            System.out.println("1. Input Data Skor Tim");
            System.out.println("2. Tampilkan Tabel Skor");
            System.out.println("3. Tentukan Juara");
            System.out.println("4. Keluar");
            System.out.print("Pilih Menu (1-4): ");
            pilihan = sc.nextInt();
            sc.nextLine();

            switch (pilihan) {
                case 1:
                    inputDataSkorTim(sc);
                    break;
                case 2:
                    hitungTotalSkor();
                    tampilkanTabelSkor();
                    break;
                case 3:
                    hitungTotalSkor();
                    tentukanJuaraTurnamen();
                    break;
                case 4:
                    System.out.println("Terima Kasih, Program Keluar...");
                    break;
                default:
                    System.out.println("Pilihan Tidak Valid, Coba Lagi.");
            }
        } while (pilihan != 4);
    }
}
