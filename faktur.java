// Kelas Faktur yang merupakan turunan dari Barang
class faktur extends barang {
    private String noFaktur;
    private int jumlahBeli;

    // Konstruktor
    public faktur(String noFaktur, String kodeBarang, String namaBarang, double hargaBarang, int jumlahBeli) {
        super(kodeBarang, namaBarang, hargaBarang); // Menggunakan inheritance dari Barang
        this.noFaktur = noFaktur;
        this.jumlahBeli = jumlahBeli;
    }

    // Method untuk menghitung total harga
    public double total() {
        return hargaBarang * jumlahBeli;
    }

    // Getter No Faktur
    public String getNoFaktur() {
        return noFaktur;
    }

    // Getter Jumlah Beli
    public int getJumlahBeli() {
        return jumlahBeli;
    }
}