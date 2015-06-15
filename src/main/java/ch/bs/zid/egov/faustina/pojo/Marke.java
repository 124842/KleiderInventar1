package ch.bs.zid.egov.faustina.pojo;

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
     *gibt die MarkenID weiter
     * @return markenID, BigInteger
     */
    public BigInteger getMarkenId() {
        return this.markenId;
    }

    /**
     *Setzt die markenID
     * @param markenId, BigInteger
     */
    public void setMarkenId(BigInteger markenId) {
        this.markenId = markenId;
    }

    /**
     *gibt die makrenBezeichnung weiter
     * @return markenBezeichnung, String
     */
    public String getMarkenBezeichnung() {
        return this.markenBezeichnung;
    }

    /**
     *setzt die MarkenBezeichnung
     * @param markenBezeichnung, String
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
