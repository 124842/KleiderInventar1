package ch.bs.zid.egov.faustina.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.math.BigInteger;

/**
 * Marke
 */
@Entity
public class MarkenEntity
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private BigInteger markenId;
    private String markenBezeichnung;


    public BigInteger getMarkenId()
    {
        return this.markenId;
    }


    public void setMarkenId(BigInteger markenId)
    {
        this.markenId = markenId;
    }


    public String getMarkenBezeichnung()
    {
        return this.markenBezeichnung;
    }


    public void setMarkenBezeichnung(String markenBezeichnung)
    {
        this.markenBezeichnung = markenBezeichnung;
    }

    @Override
    public String toString()
    {
        return "Marke{" +
                "kategorieId=" + this.markenId +
                ", kategorieBezeichnung='" + this.markenBezeichnung + '\'' +
                '}';
    }
}
