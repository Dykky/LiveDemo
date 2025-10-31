import java.util.ArrayList;

/**
 * Kelas {@code KeuanganManager} bertanggung jawab untuk
 * mengelola daftar catatan keuangan seperti menambah,
 * menghapus, menampilkan, dan menghitung saldo total.
 *
 * <p>Kelas ini menggunakan {@link ArrayList} untuk menyimpan
 * daftar objek {@link CatatanKeuangan}.</p>
 *
 * @author Dicky
 * @version 1.0
 */
class KeuanganManager {
    private ArrayList<CatatanKeuangan> daftarCatatan = new ArrayList<>();

    /**
     * Menambahkan catatan keuangan baru ke daftar.
     *
     * @param catatan Objek {@code CatatanKeuangan} yang akan ditambahkan.
     */
    public void tambahCatatan(CatatanKeuangan catatan) {
        daftarCatatan.add(catatan);
        System.out.println("Catatan berhasil ditambahkan!");
    }

    /**
     * Menampilkan semua catatan keuangan yang tersimpan.
     * Jika belum ada, akan menampilkan pesan kosong.
     */
    public void tampilkanCatatan() {
        if (daftarCatatan.isEmpty()) {
            System.out.println("Belum ada catatan keuangan.");
            return;
        }
        daftarCatatanKeuangan();
    }

    /**
     * Menampilkan daftar catatan keuangan dengan nomor urut.
     */
    private void daftarCatatanKeuangan() {
        System.out.println("\n--- Daftar Catatan Keuangan ---");
        for (int i = 0; i < daftarCatatan.size(); i++) {
            System.out.println((i + 1) + ". " + daftarCatatan.get(i));
        }
    }

    /**
     * Menghapus catatan keuangan berdasarkan nomor urut.
     *
     * @param index Nomor indeks (dimulai dari 0).
     */
    public void hapusCatatan(int index) {
        if (index >= 0 && index < daftarCatatan.size()) {
            daftarCatatan.remove(index);
            System.out.println("Catatan berhasil dihapus.");
        } else {
            System.out.println("Nomor catatan tidak valid.");
        }
    }

    /**
     * Menghitung total saldo dari semua catatan keuangan.
     *
     * @return Total saldo (pemasukan - pengeluaran).
     */
    public double hitungSaldo() {
        double total = 0;
        for (CatatanKeuangan c : daftarCatatan) {
            total += c.getJumlah();
        }
        return total;
    }
}
