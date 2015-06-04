package ch.bs.zid.egov.faustina.pojo;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.math.BigInteger;

/**
 * Marken Pojo, was später als Entity in der Datenbank gespeichert werden wird
 * @author Faustina Bruno
 * @version 1
 */
public class Marke {

    private BigInteger markenId;
    private String markenBezeichnung;

    /**
     *
     * @return gibt die MarkenID aus
     */
    public BigInteger getMarkenId() {
        return this.markenId;
    }

    /**
     *
     * @param markenId, setzt die MarkenID
     */
    public void setMarkenId(BigInteger markenId) {
        this.markenId = markenId;
    }

    /**
     *
     * @return gibt die makrenBezeichnung aus
     */
    public String getMarkenBezeichnung() {
        return this.markenBezeichnung;
    }

    /**
     *
     * @param markenBezeichnung, setzt die MarkenBezeichnung
     */
    public void setMarkenBezeichnung(String markenBezeichnung) {
        this.markenBezeichnung = markenBezeichnung;
    }

    /**
     *
     * @return ein String mit den Variabeln markenID und markenBezeichnung
     */
    @Override
    public String toString() {
        return "Marke{" +
                "kategorieId=" + this.markenId +
                ", kategorieBezeichnung='" + this.markenBezeichnung + '\'' +
                '}';
    }
}
