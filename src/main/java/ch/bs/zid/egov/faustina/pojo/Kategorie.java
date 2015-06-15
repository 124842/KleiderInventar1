package ch.bs.zid.egov.faustina.pojo;

import java.math.BigInteger;

/**
 * Kategorie Objekt
 * @author Faustina Bruno
 * @version 1
 */
public class Kategorie
{
    private BigInteger kategorieId;
    private String kategorieBezeichnung;

    /**
     * gibt die KategorieDI weiter
     * @return kategorieID, BigInteger
     */
    public BigInteger getKategorieId()
    {
        return this.kategorieId;
    }

    /**
     * setzt die KategorieID
     * @param kategorieId, BigInteger
     */
    public void setKategorieId(BigInteger kategorieId)
    {
        this.kategorieId = kategorieId;
    }

    /**
     * Gibt die KategorieBezeichnung weiter
     * @return kategorieBezeichnug, String
     */
    public String getKategorieBezeichnung()
    {
        return this.kategorieBezeichnung;
    }

    /**
     * setzte die Kategorie Bezeichnug
     * @param kategorieBezeichnung, String
     */
    public void setKategorieBezeichnung(String kategorieBezeichnung)
    {
        this.kategorieBezeichnung = kategorieBezeichnung;
    }

    /**
     * Gibt String mit allen Werten einer Kategorie aus
     * @return String
     */
    @Override
    public String toString()
    {
        return "Kategorie{" +
                "kategorieId=" + this.kategorieId +
                ", kategorieBezeichung='" + this.kategorieBezeichnung + '\'' +
                '}';
    }
}
