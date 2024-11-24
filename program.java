import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

// Main program
public class program {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean loginBerhasil = false;

        // Bagian login
        while (!loginBerhasil) {
            System.out.println("+-----------------------------------------------------+");
            System.out.print("Username : ");
            String username = scanner.nextLine();
            System.out.print("Password : ");
            String password = scanner.nextLine();

            // Membuat captcha sederhana
            String captcha = generateCaptcha(5); // Menghasilkan captcha acak
            System.out.println("Captcha : " + captcha);
            System.out.print("Masukkan Captcha : ");
            String inputCaptcha = scanner.nextLine();

            // Validasi login
            // equalsIgnoreCase digunakan untuk membandingkan String tanpa memperhatikan huruf besar/kecil pada username
            // equals digunakan untuk membandingkan String dengan memperhatikan huruf besar/kecil pada password dan captcha
            if (username.equalsIgnoreCase("admin") && password.equals("1234") && captcha.equals(inputCaptcha)) {
                System.out.println("Login berhasil!");
                loginBerhasil = true;
            } else if (!captcha.equals(inputCaptcha)) { //fungsi equals
                System.out.println("\"Captcha salah! Silakan coba lagi.\n");
            }
            else {
                System.out.println("Login gagal! Username atau password salah.\n");
            }
            System.out.println("+-----------------------------------------------------+");
        }

        // Menampilkan header aplikasi supermarket
        System.out.println("Selamat Datang di Sepermarket Apapun Ada");
        Date date = new Date();  // Membuat objek Date untuk mendapatkan tanggal dan waktu saat ini
        SimpleDateFormat sdf = new SimpleDateFormat("EEEE, dd MMMM yyyy HH:mm:ss"); // Format waktu 
        System.out.println("Tanggal dan Waktu : " + sdf.format(date)); // Menampilkan tanggal dan waktu dalam format yang ditentukan
        System.out.println("+-----------------------------------------------------+");

        boolean lanjut = true;
        while (lanjut) {
            try {
                // Input data barang
                System.out.print("Masukkan No. Faktur: ");
                String noFaktur = scanner.nextLine().toUpperCase(); // toUpperCase untuk mengubah menjadi huruf besar 
                System.out.print("Masukkan Kode Barang: ");
                String kodeBarang = scanner.nextLine().trim(); // trim untuk menghapus spasi berlebih di awal dan akhir 
                System.out.print("Masukkan Nama Barang: ");
                String namaBarang = scanner.nextLine();

                System.out.print("Masukkan Harga Barang: ");
                double hargaBarang = scanner.nextDouble();
                System.out.print("Masukkan Jumlah Beli: ");
                int jumlahBeli = scanner.nextInt();
                if (hargaBarang <= 0 || jumlahBeli <= 0) {
                    throw new IllegalArgumentException("Harga barang dan jumlah barang harus lebih besar dari nol!");
                }

                scanner.nextLine(); // Membersihkan newline

                // Membuat objek faktur
                faktur faktur = new faktur(noFaktur, kodeBarang, namaBarang, hargaBarang, jumlahBeli);

                // Menampilkan faktur
                System.out.println("+-----------------------------------------------------+");
                System.out.println(faktur.infoBarang());
                System.out.println("No. Faktur      : " + faktur.getNoFaktur());
                System.out.println("Jumlah Beli     : " + faktur.getJumlahBeli());
                System.out.println("TOTAL           : Rp " + faktur.total());
                System.out.println("+-----------------------------------------------------+");
                System.out.println("Kasir           : <Trilen Surya Ningsih>");
                System.out.println("+-----------------------------------------------------+");

            } catch (IllegalArgumentException e) {
                System.out.println("Kesalahan input: " + e.getMessage());
                scanner.nextLine();
            } 


            // Menanyakan apakah ingin memasukkan data lainnya 
            System.out.print("\nApakah ingin memasukkan data lainnya? (yes/no): ");
            String jawaban = scanner.nextLine().trim().toLowerCase();
            if (!jawaban.equals("yes")) {
                lanjut = false;
            }
        }

        // Menutup scanner 
        scanner.close();
        System.out.println("\nTerima kasih telah berbelanja di Supermarket Apapun Ada!");
    }

           
    // Method untuk membuat captcha acak
    private static String generateCaptcha(int length) {
        String chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
        StringBuilder captcha = new StringBuilder();
        for (int i = 0; i < length; i++) {
            int index = (int) (Math.random() * chars.length());
            captcha.append(chars.charAt(index));
        }
        return captcha.toString();
    }
}