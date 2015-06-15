package ch.bs.zid.egov.faustina.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.math.BigInteger;

/**
 * MarkenEntity
 *   @author Faustina Bruno
 * @version 1
 */
@Entity
public class MarkenEntity
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private BigInteger markenId;
    private String markenBezeichnung;

    /**
     * gibt die MarkenID weiter
     * @return markenID, BigInteger
     */
    public BigInteger getMarkenId()
    {
        return this.markenId;
    }

    /**
     * setzt die MarkenID
     * @param markenId, BigInteger
     */
    public void setMarkenId(BigInteger markenId)
    {
        this.markenId = markenId;
    }

    /**
     * gibt die MarkenBezeichnung weiter
     * @return markenBezeichnung, String
     */
    public String getMarkenBezeichnung()
    {
        return this.markenBezeichnung;
    }

    /**
     * setzt die MarkenBezeichnung
     * @param markenBezeichnung, String
     */
    public void setMarkenBezeichnung(String markenBezeichnung)
    {
        this.markenBezeichnung = markenBezeichnung;
    }

    /**
     * String  mit allen Werten einer Marke
     * @return String
     */
    @Override
    public String toString()
    {
        return "Marke{" +
                "kategorieId=" + this.markenId +
                ", kategorieBezeichnung='" + this.markenBezeichnung + '\'' +
                '}';
    }
}
