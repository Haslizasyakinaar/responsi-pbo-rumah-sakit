/** Subclass 2: Perawat */
public class Perawat extends TenagaMedis implements DapatDilaporkan {
    private String ruangan;

    public Perawat(String idPegawai, String nama, String ruangan) {
        super(idPegawai, nama);
        this.ruangan = ruangan;
    }

    public Perawat(String idPegawai, String nama, String shift, String ruangan) {
        super(idPegawai, nama, shift);
        this.ruangan = ruangan;
    }

    public String getRuangan() { return ruangan; }
    public void setRuangan(String ruangan) { this.ruangan = ruangan; }

    @Override
    public String tanganiPasien(Pasien pasien) {
        if (getStaminaKerja() < 15 || getJumlahPasienDitangani() >= BATAS_PASIEN_HARIAN) {
            return "Perawat " + getNama() + " kelelahan/kuota penuh, tidak dapat merawat "
                    + pasien.getNama() + ".";
        }
        if (pasien.getTingkatKeparahan() >= 4) {
            pasien.setStatus("Observasi Intensif");
            setStaminaKerja(getStaminaKerja() - 30);
        } else {
            pasien.setStatus("Pemantauan Rutin");
            setStaminaKerja(getStaminaKerja() - 15);
        }
        setJumlahPasienDitangani(getJumlahPasienDitangani() + 1);
        pasien.tambahBiaya(75000);
        return "Perawat " + getNama() + " merawat " + pasien.getNama() + " -> " + pasien.getStatus();
    }

    @Override
    public String buatLaporan() {
        return "Laporan Perawat " + getNama() + " (ruang " + ruangan + "): "
                + getJumlahPasienDitangani() + " pasien dirawat";
    }

    @Override
    public String tampilkanProfil() {
        return super.tampilkanProfil() + " | Perawat ruang " + ruangan;
    }
}
