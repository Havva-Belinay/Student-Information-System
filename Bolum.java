import java.time.LocalDate;

/**
 * Bölüm bilgilerinin tutulduğu sınıf
 * 
 * @author Havva Belinay YÜCE
 */
public class Bolum {
    private String bolumAdi;
    private String webLinki;
    private LocalDate tarih;

    /**
     * Bölüm adı güncellenir
     * 
     * @param bolumAdi Değişkene atanacak yeni bölüm adını ifade eder.
     *
     */
    public void setBolumAdi(String bolumAdi) {
        this.bolumAdi = bolumAdi;
    }

    /**
     * Bölüm adını geri döndürür
     * 
     * @return Bölüm adı
     */
    public String getBolumAdi() {
        return bolumAdi;
    }

    /**
     * Web sitesinin linkini günceller
     * 
     * @param webLinki Bölümün web sitesinin linkini değişkene atar
     * 
     */
    public void setWebLinki(String webLinki) {
        this.webLinki = webLinki;
    }

    /**
     * Linki geri döndürür
     * 
     * @return Web sitesi linki
     */
    public String getWebLinki() {
        return webLinki;
    }

    /**
     * Bölümün kuruluş tarihini sisteme kaydeder
     * 
     * @param tarih Kuruluş tarihi
     */
    public void setTarih(LocalDate tarih) {
        this.tarih = tarih;
    }

    /**
     * Tarihi geri döndürür
     * 
     * @return Kuruluş tarihi
     */
    public LocalDate getTarih() {
        return tarih;
    }
}
