package ch.bs.zid.egov.faustina.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.math.BigInteger;

/**
 * Kategorie
 */
@Entity
public class KategorieEntity
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private BigInteger kategorieId;
    private String kategorieBezeichnung;


    public BigInteger getKategorieId()
    {
        return this.kategorieId;
    }


    public void setKategorieId(BigInteger kategorieId)
    {
        this.kategorieId = kategorieId;
    }


    public String getKategorieBezeichnung()
    {
        return this.kategorieBezeichnung;
    }

    public void setKategorieBezeichnung(String kategorieBezeichnung)
    {
        this.kategorieBezeichnung = kategorieBezeichnung;
    }

    @Override
    public String toString()
    {
        return "Kategorie{" +
                "kategorieId=" + this.kategorieId +
                ", kategorieBezeichung='" + this.kategorieBezeichnung + '\'' +
                '}';
    }
}

