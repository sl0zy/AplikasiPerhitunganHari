/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

import java.time.LocalDate;
import java.time.YearMonth;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.time.format.TextStyle;
import java.util.Locale;

public class PerhitunganHari {

    // Hitung jumlah hari dalam bulan & tahun tertentu
    public static int hitungJumlahHari(int tahun, int bulan) {
        YearMonth ym = YearMonth.of(tahun, bulan);
        return ym.lengthOfMonth();
    }

    // Cek tahun kabisat
    public static boolean isKabisat(int tahun) {
        return YearMonth.of(tahun, 1).isLeapYear();
    }

    // Dapatkan hari pertama dan terakhir dalam bulan
    public static String[] getHariPertamaTerakhir(int tahun, int bulan) {
        YearMonth ym = YearMonth.of(tahun, bulan);
        LocalDate pertama = ym.atDay(1);
        LocalDate terakhir = ym.atEndOfMonth();
        Locale indonesia = new Locale("id", "ID");
        return new String[]{
            pertama.getDayOfWeek().getDisplayName(TextStyle.FULL, indonesia),
            terakhir.getDayOfWeek().getDisplayName(TextStyle.FULL, indonesia)
        };
    }

    // Hitung selisih hari antara dua tanggal
    public static long hitungSelisihHari(Date tgl1, Date tgl2) {
        LocalDate d1 = tgl1.toInstant().atZone(java.time.ZoneId.systemDefault()).toLocalDate();
        LocalDate d2 = tgl2.toInstant().atZone(java.time.ZoneId.systemDefault()).toLocalDate();
        return Math.abs(ChronoUnit.DAYS.between(d1, d2));
    }

    // Format tanggal
    public static String formatTanggal(Date date) {
        return new SimpleDateFormat("dd MMMM yyyy").format(date);
    }
}
