import java.util.Scanner;

/**
 * Kelas utama {@code MainApp} untuk menjalankan aplikasi
 * catatan keuangan harian berbasis teks.
 *
 * <p>Pengguna dapat menambah, melihat, menghapus catatan,
 * serta melihat total saldo.</p>
 *
 * @author Dicky
 * @version 1.0
 */
public class Main {

    /**
     * Metode utama untuk menjalankan aplikasi.
     *
     * @param args Argumen baris perintah (tidak digunakan).
     */
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        KeuanganManager manager = new KeuanganManager();
        int pilihan;

        do {
            tampilkanMenu();
            pilihan = input.nextInt();
            input.nextLine();

            switch (pilihan) {
                case 1 -> prosesDeskripsi(input, manager);
                case 2 -> manager.tampilkanCatatan();
                case 3 -> {
                    manager.tampilkanCatatan();
                    hapusCatatan(input, manager);
                }
                case 4 -> System.out.printf("Total saldo saat ini: Rp %.2f%n", manager.hitungSaldo());
                case 5 -> System.out.println("Terima kasih telah menggunakan sistem ini!");
                default -> System.out.println("Pilihan tidak valid, coba lagi.");
            }

        } while (pilihan != 5);

        input.close();
    }

    /**
     * Menangani proses penghapusan catatan berdasarkan nomor urut.
     *
     * @param input Scanner untuk input pengguna.
     * @param manager Objek {@code KeuanganManager} untuk mengelola data.
     */
    private static void hapusCatatan(Scanner input, KeuanganManager manager) {
        System.out.print("Masukkan nomor catatan yang ingin dihapus: ");
        int index = input.nextInt();
        input.nextLine();
        manager.hapusCatatan(index - 1);
    }

    /**
     * Menangani proses penambahan catatan baru.
     *
     * @param input Scanner untuk input pengguna.
     * @param manager Objek {@code KeuanganManager} untuk menyimpan data.
     */
    private static void prosesDeskripsi(Scanner input, KeuanganManager manager) {
        System.out.print("Masukkan deskripsi: ");
        String deskripsi = input.nextLine();
        System.out.print("Masukkan jumlah (gunakan - untuk pengeluaran): ");
        double jumlah = input.nextDouble();
        input.nextLine();
        manager.tambahCatatan(new CatatanKeuangan(deskripsi, jumlah));
    }

    /**
     * Menampilkan menu utama aplikasi ke layar.
     */
    private static void tampilkanMenu() {
        System.out.println("\n=== SISTEM CATATAN KEUANGAN HARIAN ===");
        System.out.println("1. Tambah Catatan");
        System.out.println("2. Lihat Semua Catatan");
        System.out.println("3. Hapus Catatan");
        System.out.println("4. Lihat Total Saldo");
        System.out.println("5. Keluar");
        System.out.print("Pilih menu: ");
    }
}
