/**
 * Ders bilgilerinin tutulduğu sınıf
 * 
 * @author Havva Belinay YÜCE
 */
public class Ders {
    private String dersAdi;
    private String dersKodu;
    private Integer AKTS;

    /**
     * Dersin adını günceller
     * 
     * @param dersAdi Ders adı
     */
    public void setDersAdi(String dersAdi) {
        this.dersAdi = dersAdi;
    }

    /**
     * Dersin adını geri döndürür
     * 
     * @return Ders adı
     */
    public String getDersAdi() {
        return dersAdi;
    }

    /**
     * Dersin kodunu kaydeder
     * 
     * @param dersKodu Ders Kodu
     */
    public void setDersKodu(String dersKodu) {
        this.dersKodu = dersKodu;
    }

    /**
     * Ders kodunu geri döndürür
     * 
     * @return Ders kodu
     */
    public String getDersKodu() {
        return dersKodu;
    }

    /**
     * Dersin AKTS'sini kaydeder
     * 
     * @param AKTS AKTS
     */
    public void setAkts(Integer AKTS) {
        this.AKTS = AKTS;
    }

    /**
     * Dersin AKTS'sini geri döndürür
     * 
     * @return AKTS
     */
    public Integer getAkts() {
        return AKTS;
    }
}
