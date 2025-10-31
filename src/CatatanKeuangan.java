/**
 * Kelas {@code CatatanKeuangan} merepresentasikan satu transaksi keuangan,
 * baik pemasukan maupun pengeluaran.
 *
 * <p>Setiap catatan memiliki deskripsi dan jumlah uang.
 * Jika nilai jumlah positif maka dianggap pemasukan,
 * sedangkan jika negatif maka dianggap pengeluaran.</p>
 *
 * @author Dicky
 * @version 1.0
 */
class CatatanKeuangan {
    private String deskripsi;
    private double jumlah;

    /**
     * Konstruktor untuk membuat catatan keuangan baru.
     *
     * @param deskripsi Deskripsi dari transaksi.
     * @param jumlah Nilai uang transaksi (positif untuk pemasukan, negatif untuk pengeluaran).
     */
    public CatatanKeuangan(String deskripsi, double jumlah) {
        this.deskripsi = deskripsi;
        this.jumlah = jumlah;
    }

    /**
     * Mengambil deskripsi transaksi.
     *
     * @return Deskripsi transaksi.
     */
    public String getDeskripsi() {
        return deskripsi;
    }

    /**
     * Mengambil jumlah uang transaksi.
     *
     * @return Jumlah uang (positif = pemasukan, negatif = pengeluaran).
     */
    public double getJumlah() {
        return jumlah;
    }

    /**
     * Mengembalikan representasi string dari catatan keuangan.
     *
     * @return Format teks catatan keuangan.
     */
    @Override
    public String toString() {
        String tipe = jumlah >= 0 ? "Pemasukan" : "Pengeluaran";
        return String.format("[%s] %s : Rp %.2f", tipe, deskripsi, jumlah);
    }
}
