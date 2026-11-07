/** Entitas pasien rumah sakit */
public class Pasien {
    private final String nomorRekamMedis;
    private String nama;
    private int umur;
    private int tingkatKeparahan;
    private String status;
    private double totalBiaya;

    // Konstruktor 1
    public Pasien(String nomorRekamMedis, String nama) {
        this(nomorRekamMedis, nama, 0, 1);
    }

    // Konstruktor 2
    public Pasien(String nomorRekamMedis, String nama, int umur, int tingkatKeparahan) {
        this.nomorRekamMedis = nomorRekamMedis;
        this.nama = nama;
        this.umur = umur;
        setTingkatKeparahan(tingkatKeparahan);
        this.status = "Menunggu";
        this.totalBiaya = 0;
    }

    public String getNomorRekamMedis() { return nomorRekamMedis; }
    public String getNama() { return nama; }
    public void setNama(String nama) { this.nama = nama; }
    public int getUmur() { return umur; }
    public void setUmur(int umur) { this.umur = umur; }
    public int getTingkatKeparahan() { return tingkatKeparahan; }
    public void setTingkatKeparahan(int tingkatKeparahan) {
        if (tingkatKeparahan < 1) this.tingkatKeparahan = 1;
        else if (tingkatKeparahan > 5) this.tingkatKeparahan = 5;
        else this.tingkatKeparahan = tingkatKeparahan;
    }
    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
    public double getTotalBiaya() { return totalBiaya; }
    public void setTotalBiaya(double totalBiaya) { this.totalBiaya = totalBiaya; }

    public void tambahBiaya(double nominal) {
        this.totalBiaya += nominal;
    }

    public String ringkasan() {
        return nomorRekamMedis + " | " + nama + " | keparahan " + tingkatKeparahan
                + " | status: " + status + " | biaya: Rp" + (long) totalBiaya;
    }
}
