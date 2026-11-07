/** Superclass abstract untuk seluruh tenaga medis. */
public abstract class TenagaMedis {
    public static final int BATAS_PASIEN_HARIAN = 3;
    public static final int STAMINA_MAKS = 100;

    private final String idPegawai;
    private String nama;
    private String shift;
    private int staminaKerja;
    private int jumlahPasienDitangani;

    // Konstruktor 1
    public TenagaMedis(String idPegawai, String nama) {
        this(idPegawai, nama, "Pagi");
    }

    // Konstruktor 2 (overloading)
    public TenagaMedis(String idPegawai, String nama, String shift) {
        this.idPegawai = idPegawai;
        this.nama = nama;
        this.shift = shift;
        this.staminaKerja = STAMINA_MAKS;
        this.jumlahPasienDitangani = 0;
    }

    public String getIdPegawai() { return idPegawai; }
    public String getNama() { return nama; }
    public void setNama(String nama) { this.nama = nama; }
    public String getShift() { return shift; }
    public void setShift(String shift) { this.shift = shift; }
    public int getStaminaKerja() { return staminaKerja; }
    public void setStaminaKerja(int staminaKerja) {
        if (staminaKerja < 0) this.staminaKerja = 0;
        else if (staminaKerja > STAMINA_MAKS) this.staminaKerja = STAMINA_MAKS;
        else this.staminaKerja = staminaKerja;
    }
    public int getJumlahPasienDitangani() { return jumlahPasienDitangani; }
    public void setJumlahPasienDitangani(int jumlahPasienDitangani) {
        this.jumlahPasienDitangani = jumlahPasienDitangani;
    }

    // method prosedur (void)
    public void istirahat() {
        setStaminaKerja(STAMINA_MAKS);
        System.out.println(nama + " beristirahat, stamina pulih penuh.");
    }

    public int hitungSisaKuota() {
        return BATAS_PASIEN_HARIAN - jumlahPasienDitangani;
    }

    public String tampilkanProfil() {
        return "[" + idPegawai + "] " + nama + " | shift " + shift
                + " | stamina " + staminaKerja + " | pasien ditangani " + jumlahPasienDitangani;
    }

    public abstract String tanganiPasien(Pasien pasien);
}
