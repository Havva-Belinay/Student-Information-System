import java.util.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Programın başladığı sınıftır.
 * Kullanıcıdan Bölüm, Ders ve Ogrenci bilgilerini
 * alarak, gpaHesaplama metodunu
 * çalıştırarak GPA hesaplanır ve bilgiler
 * hem oluşturulan dosyaya yazılır hem de ekrana
 * yazdırılarak kullanıcıya gösterilir.
 * 
 * @author Havva Belinay YÜCE
 */
public class Main {
    /**
     * Kullanıcıdan ilgili bilgilerin girişinin
     * yapılması istenir ve koleksiyonel olarak
     * depolama işleminin yapılmasını sağlar.
     * 
     * @param args komut satırı argümanlarını ifade etmektedir.
     */
    public static void main(String[] args) {
        Scanner klavye = new Scanner(System.in);
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd.MM.yyyy");
        List<Ogrenci> ogrenciler = new ArrayList<>();
        List<Ders> dersler = new ArrayList<>();

        System.out.println("---- Bölüm Bilgileri ----");

        Bolum bolum = new Bolum();
        System.out.print("Bölüm adı: ");
        bolum.setBolumAdi(klavye.nextLine());

        System.out.print("Web sayfasının linki: ");
        bolum.setWebLinki(klavye.nextLine());

        while (true) {
            try {
                System.out.print("Kuruluş tarihini GG.AA.YYYY şeklinde giriniz: ");
                bolum.setTarih(LocalDate.parse(klavye.nextLine(), dtf));
                break;
            } catch (Exception e) {
                System.out.println("Geçersiz tarih girdiniz!");
            }
        }

        System.out.println("\n ---- Öğrenci Bilgileri ----");
        ogrenciDongusu: while (true) {
            System.out.print("Öğrenci ismi (İşlemi sonlandırmak için 'son' yazınız): ");
            String isim = klavye.nextLine();
            if (isim.equalsIgnoreCase("son"))
                break ogrenciDongusu;

            Ogrenci ogrenci = new Ogrenci();
            ogrenci.setIsim(isim);
            ogrenci.setBolum(bolum);

            System.out.print("Soy isim: ");
            String soyIsim = klavye.nextLine();
            if (soyIsim.equalsIgnoreCase("son"))
                break ogrenciDongusu;
            ogrenci.setSoyisim(soyIsim);

            while (true) {
                System.out.print("Öğrenci numarası: ");
                String girilenNumara = klavye.nextLine();
                if (girilenNumara.equalsIgnoreCase("son"))
                    break ogrenciDongusu;

                try {
                    ogrenci.setNumara(Integer.parseInt(girilenNumara));
                    break;
                } catch (NumberFormatException e) {
                    System.out.println("Öğrenci numarası tam sayılardan oluşmalıdır! ");
                }
            }

            while (true) {
                System.out.print("Doğum tarihini GG.AA.YYYY formatında giriniz: ");
                String tarihKlavye = klavye.nextLine();
                if (tarihKlavye.equalsIgnoreCase("son"))
                    break ogrenciDongusu;

                try {
                    ogrenci.setDogumTarihi(LocalDate.parse(tarihKlavye, dtf));
                    break;
                } catch (Exception e) {
                    System.out.println("Tarih bilgisini istenen formatta giriniz! ");
                }
            }
            ogrenciler.add(ogrenci);
        }

        System.out.println("\n ---- Ders Bilgileri ----");
        dersDongusu: while (true) {
            System.out.print("Ders adı (Bitirmek için 'son' yazınız): ");
            String adi = klavye.nextLine();
            if (adi.equalsIgnoreCase("son"))
                break dersDongusu;

            Ders ders = new Ders();
            ders.setDersAdi(adi);

            while (true) {
                System.out.print("Ders kodu: ");
                String kod = klavye.nextLine();
                if (kod.equalsIgnoreCase("son"))
                    break dersDongusu;

                boolean kodVarMi = false;
                for (Ders ders1 : dersler) {
                    if (ders1.getDersKodu().equalsIgnoreCase(kod)) {
                        kodVarMi = true;
                        break;
                    }
                }

                if (kodVarMi) {
                    System.out.println(kod + " kodlu ders zaten kayıtlı. Başka bir kod giriniz.");
                } else {
                    ders.setDersKodu(kod);
                    break;
                }
            }

            while (true) {
                System.out.print("AKTS: ");
                String aktsGirdisi = klavye.nextLine();
                if (aktsGirdisi.equalsIgnoreCase("son"))
                    break dersDongusu;

                try {
                    ders.setAkts(Integer.parseInt(aktsGirdisi));
                    break;
                } catch (NumberFormatException e) {
                    System.out.println("AKTS değerini tam sayı olarak giriniz! ");
                }
            }
            dersler.add(ders);
        }

        for (Ogrenci ogrenci : ogrenciler) {
            System.out.println("\n ---- " + ogrenci.getIsim() + " " + ogrenci.getSoyisim()
                    + " İçin Tüm Ders Sonuçlarının Girilmesi ----");

            for (Ders ders : dersler) {
                while (true) {
                    System.out.print(ders.getDersAdi()
                            + " dersi için notu (4.00, 3.50, 3.25, 3.00, 2.50, 2.25, 2.00, 1.50, 0.00) giriniz: ");
                    String dersNotuStr = klavye.nextLine();

                    if (dersNotuStr.equals("4.00") || dersNotuStr.equals("3.50") || dersNotuStr.equals("3.25") ||
                            dersNotuStr.equals("3.00") || dersNotuStr.equals("2.50") || dersNotuStr.equals("2.25") ||
                            dersNotuStr.equals("2.00") || dersNotuStr.equals("1.50") || dersNotuStr.equals("0.00")) {

                        double dersNotu = Double.parseDouble(dersNotuStr);
                        ogrenci.notEkle(ders, dersNotu);
                        break;
                    } else {
                        System.out.println("Hata: Lütfen sadece listedeki geçerli notlardan birini giriniz.");
                    }
                }
            }
            ogrenci.gpaHesapla();
        }

        ogrenciler.sort(Comparator.comparingDouble(Ogrenci::getGPA).reversed());

        StringBuilder sonuc = new StringBuilder();

        System.out.println("\n ---- GPA Sıralamaları ----");

        for (int i = 0; i < ogrenciler.size(); i++) {
            Ogrenci ogrenci = ogrenciler.get(i);
            String yeniGpa = String.format("%.2f", ogrenci.getGPA());

            String satir = (i + 1) + ". " + ogrenci.getIsim() + " " + ogrenci.getSoyisim() + " - GPA: "
                    + yeniGpa;
            System.out.println(satir);
            sonuc.append(satir).append("\n");
        }

        try (FileWriter fw = new FileWriter("sonuclar.txt")) {
            fw.write(sonuc.toString());
        } catch (IOException e) {
            System.out.println("Dosyaya yazılamıyor. Hata: " + e.getMessage());
        }
        klavye.close();
    }
}
