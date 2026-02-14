import java.util.Map;
import java.util.HashMap;
import java.time.LocalDate;

/**
 * Öğrenci ile ilgili bilgilerin tutulduğu sınıf
 * 
 * @author Havva Belinay YÜCE
 */
public class Ogrenci {
    private String isim;
    private String soyIsim;
    private Integer numara;
    private LocalDate dogumTarihi;
    private Bolum bolum;

    private Map<Ders, Double> dersNotlari = new HashMap<>();
    private double GPA; // varsayılan değeri 0.0 olsun diye. sadece sayısal değer tutsun

    /**
     * Öğrencinin genel not ortalaması, derslerin
     * ağırlıkları da göz önünde bulundurularak hesaplanır.
     * GPA hesabı, (AKTS * not) işlemi her ders için uygulanır
     * ve daha sonra bu değerler toplanıp
     * toplam AKTS'ye bölünerek elde edilir.
     */
    public void gpaHesapla() {
        double toplamNot = 0.0;
        int toplamAKTS = 0;

        for (Map.Entry<Ders, Double> entry : this.dersNotlari.entrySet()) {
            Ders ders = entry.getKey();
            Double not = entry.getValue();

            toplamNot += ders.getAkts() * not;
            toplamAKTS += ders.getAkts();
        }

        if (toplamAKTS > 0) {
            this.GPA = toplamNot / toplamAKTS;
        } else {
            this.GPA = 0.0;
        }
    }

    /**
     * İsim bilgisi güncellenir
     * 
     * @param isim Öğrenci ismi
     */
    public void setIsim(String isim) {
        this.isim = isim;
    }

    /**
     * İsim bilgisini döndürür
     * 
     * @return isim
     */
    public String getIsim() {
        return isim;
    }

    /**
     * Soy isim bilgisi güncellenir
     * 
     * @param soyIsim Öğrencinin soy ismi
     */
    public void setSoyisim(String soyIsim) {
        this.soyIsim = soyIsim;
    }

    /**
     * Soy ismi geri döndürür
     * 
     * @return Soy isim
     */
    public String getSoyisim() {
        return soyIsim;
    }

    /**
     * Okul numarası güncellenir
     * 
     * @param numara Öğrencinin okul numarası
     */
    public void setNumara(Integer numara) {
        this.numara = numara;
    }

    /**
     * Okul numarası geri döndürülür
     * 
     * @return Numara
     */
    public Integer getNumara() {
        return numara;
    }

    /**
     * Doğum tarihi güncellenir
     * 
     * @param dogumTarihi Öğrencinin doğum tarihi
     */
    public void setDogumTarihi(LocalDate dogumTarihi) {
        this.dogumTarihi = dogumTarihi;
    }

    /**
     * Doğum tarihi geri döndürülür
     * 
     * @return Doğum tarihi
     */
    public LocalDate getDogumTarihi() {
        return dogumTarihi;
    }

    /**
     * Bölüm bilgisi güncellenir.
     * 
     * @param bolum Bölüm
     */
    public void setBolum(Bolum bolum) {
        this.bolum = bolum;
    }

    /**
     * Bölüm bilgisi geri döndürülür
     * 
     * @return Bölüm
     */
    public Bolum getBolum() {
        return bolum;
    }

    /**
     * gpaHesapla metodu ile hesaplanan GPA değerini geri döndürür
     * 
     * @return GPA
     */
    public double getGPA() {
        return GPA;
    }

    /**
     * Ders notlarını geri döndürür
     * 
     * @return Ders Notları
     */
    public Map<Ders, Double> getDersNotlari() {
        return dersNotlari;
    }

    /**
     * Map yapısı sayesinde ders ve notları eşleştirerek HashMap'in içerisine
     * kaydeder.
     */
    public void notEkle(Ders ders, Double not) {
        this.dersNotlari.put(ders, not);
    }
}
