package ch.bs.zid.egov.faustina.pojo;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.math.BigInteger;

/**
 * Created by Faustina privat on 15.05.2015.
 */
public class Kategorie
{
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
