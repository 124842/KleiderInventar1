package ch.bs.zid.egov.faustina.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.math.BigInteger;

/**
 * KategorieEntity
 * @author Faustina Bruno
 * @version 1
 */
@Entity
public class KategorieEntity
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private BigInteger kategorieId;
    private String kategorieBezeichnung;

    /**
     * gibt die KategorieID weiter
     * @return BigInteger
     */
    public BigInteger getKategorieId()
    {
        return this.kategorieId;
    }
    /**
     * setzt die Kategorie ID
     * @param kategorieId, BigInteger
     */
    public void setKategorieId(BigInteger kategorieId)
    {
        this.kategorieId = kategorieId;
    }
    /**
     * gibt die Kategorie Bezeichnung weiter
     * @return String
     */
    public String getKategorieBezeichnung()
    {
        return this.kategorieBezeichnung;
    }
    /**
     * setzt die Kategorie Bezeichnung
     * @param kategorieBezeichnung,String Bezeichnung der Kategorie
     */
    public void setKategorieBezeichnung(String kategorieBezeichnung)
    {
        this.kategorieBezeichnung = kategorieBezeichnung;
    }
    /**
     * Gibt ein String aus, mit allen Werten einer Kategorie
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

