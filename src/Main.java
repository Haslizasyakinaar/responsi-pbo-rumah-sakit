public class Main {
    public static void main(String[] args) {
        System.out.println("=== SISTEM RUMAH SAKIT ===");

        // [3] Konstruktor overloaded
        Pasien p1 = new Pasien("RM-001", "Bumi");
        Pasien p2 = new Pasien("RM-002", "Senja", 30, 5);

        // [4] Inheritance + [5] super(...)
        Dokter dokter = new Dokter("DK-01", "Alura", "Penyakit Dalam", 150000);
        Perawat perawat = new Perawat("PR-01", "Aksara", "Mawar");

        // [2] Immutability
        System.out.println("[2] BATAS_PASIEN_HARIAN = " + TenagaMedis.BATAS_PASIEN_HARIAN);
        System.out.println("[2] ID dokter  = " + dokter.getIdPegawai());

        // [1] State & behavior, [3] getter/setter
        p1.setUmur(40);
        p1.setTingkatKeparahan(2);
        System.out.println("[3] Pasien 1 -> " + p1.getNama() + ", umur " + p1.getUmur());
        System.out.println("[1] Sisa kuota dokter = " + dokter.hitungSisaKuota());

        // [5] super.method() + [6] override
        System.out.println("[5,6] " + dokter.tampilkanProfil());

        // [7,8] Abstract method + if/else state
        System.out.println("[7,8] " + dokter.tanganiPasien(p1));
        System.out.println("[7,8] " + dokter.tanganiPasien(p2));
        System.out.println("[7,8] " + perawat.tanganiPasien(p2));

        // [9] Polimorfisme interface
        DapatDilaporkan laporan = perawat;
        System.out.println("[9] " + laporan.buatLaporan());

        // [10] Multiple interface
        DapatDilaporkan laporanDokter = dokter;
        BisaDitagih penagih = dokter;
        System.out.println("[10] " + laporanDokter.buatLaporan());
        System.out.println("[10] Tagihan " + p2.getNama() + " = Rp" + (long) penagih.hitungTagihan(p2));

        // Hasil akhir pasien
        System.out.println("\n" + p1.ringkasan());
        System.out.println(p2.ringkasan());
    }
}
