/** Subclass 1: Dokter */
public class Dokter extends TenagaMedis implements DapatDilaporkan, BisaDitagih {
    private String spesialisasi;
    private double tarifKonsultasi;

    public Dokter(String idPegawai, String nama, String spesialisasi, double tarifKonsultasi) {
        super(idPegawai, nama);
        this.spesialisasi = spesialisasi;
        this.tarifKonsultasi = tarifKonsultasi;
    }

    public Dokter(String idPegawai, String nama, String shift, String spesialisasi, double tarifKonsultasi) {
        super(idPegawai, nama, shift);
        this.spesialisasi = spesialisasi;
        this.tarifKonsultasi = tarifKonsultasi;
    }

    public String getSpesialisasi() { return spesialisasi; }
    public void setSpesialisasi(String spesialisasi) { this.spesialisasi = spesialisasi; }
    public double getTarifKonsultasi() { return tarifKonsultasi; }
    public void setTarifKonsultasi(double tarifKonsultasi) { this.tarifKonsultasi = tarifKonsultasi; }

    @Override
    public String tanganiPasien(Pasien pasien) {
        if (getStaminaKerja() <= 0 || getJumlahPasienDitangani() >= BATAS_PASIEN_HARIAN) {
            return "dr. " + getNama() + " tidak dapat menerima " + pasien.getNama()
                    + " (stamina/kuota habis).";
        }
        if (pasien.getTingkatKeparahan() >= 4) {
            pasien.setStatus("Rawat Inap");
            setStaminaKerja(getStaminaKerja() - 40);
        } else if (pasien.getTingkatKeparahan() >= 2) {
            pasien.setStatus("Rawat Jalan");
            setStaminaKerja(getStaminaKerja() - 20);
        } else {
            pasien.setStatus("Pulang");
            setStaminaKerja(getStaminaKerja() - 10);
        }
        setJumlahPasienDitangani(getJumlahPasienDitangani() + 1);
        pasien.tambahBiaya(hitungTagihan(pasien));
        return "dr. " + getNama() + " memeriksa " + pasien.getNama() + " -> " + pasien.getStatus();
    }

    @Override
    public double hitungTagihan(Pasien pasien) {
        return tarifKonsultasi + (pasien.getTingkatKeparahan() * 50000);
    }

    @Override
    public String buatLaporan() {
        return "Laporan Dokter " + getNama() + " (" + spesialisasi + "): "
                + getJumlahPasienDitangani() + " pasien, sisa kuota " + hitungSisaKuota();
    }

    @Override
    public String tampilkanProfil() {
        return super.tampilkanProfil() + " | Dokter " + spesialisasi;
    }
}
