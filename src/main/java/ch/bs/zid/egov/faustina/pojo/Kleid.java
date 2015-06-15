package ch.bs.zid.egov.faustina.pojo;

import javax.persistence.*;
import java.math.BigDecimal;
import java.math.BigInteger;

/**
 * Kleid Objekt
 * @author Faustina Bruno
 * @version 1
 */
public class Kleid {

    private BigInteger kleidId;
    private String kleidBeschreibung;
    private int kleiderGroesse;

    @Enumerated(EnumType.STRING)
    private Farben farbe;

    private BigDecimal preis;
    private String kategorieBezeichnung;
    private String markenBezeichung;
    private BigInteger kategorieID;
    private BigInteger markenID;

    /**
     * gibt die KleiderId weiter
     * @return kleidID, BigInteger
     */
    @SuppressWarnings("unused")
    public BigInteger getKLeidId() {
        return this.kleidId;
    }

    /**
     * setzt die KleiderID
     * @param kleidId, BigIntefer
     */
    public void setKleidId(BigInteger kleidId) {
        this.kleidId = kleidId;
    }

    /**
     * gibt die KleiderBeschreibung weiter
     * @return kleiderBeschreibung, String
     */
    public String getKleidBeschreibung() {
        return this.kleidBeschreibung;
    }

    /**
     * setzt die Kleiderbeschreibung
     * @param kleidBeschreibung, String
     */
    public void setKleidBeschreibung(String kleidBeschreibung) {
        this.kleidBeschreibung = kleidBeschreibung;
    }

    /**
     * gibt die KleiderID weiter
     * @return kleidID, BigInteger
     */
    public BigInteger getKleidId() {
        return this.kleidId;
    }

    /**
     * gibt die KleiderGroesse weiter
     * @return kleiderGroesse, int
     */
    public int getKleiderGroesse() {
        return this.kleiderGroesse;
    }

    /**
     * setzt die kleiderGroesse
     * @param kleiderGroesse, int
     */
    public void setKleiderGroesse(int kleiderGroesse) {
        this.kleiderGroesse = kleiderGroesse;
    }

    /**
     * gibt die Farbe weiter
     * @return farbe, Farbe
     */
    public Farben getFarbe() {
        return this.farbe;
    }

    /**
     * setzt die Farbe
     * @param farbe, Farbe
     */
    public void setFarbe(Farben farbe) {
        this.farbe = farbe;
    }

    /**
     * gibt den Preis weiter
     * @return preis, BigDecimal
     */
    public BigDecimal getPreis() {
        return this.preis;
    }

    /**
     * setzt den Preis
     * @param preis, BigDecimal
     */
    public void setPreis(BigDecimal preis) {
        this.preis = preis;
    }

    /**
     * gibt die KategorieBezeichnung weiter
     * @return kategorieBezeichnung, String
     */
    public String getKategorieBezeichnung() {

        return this.kategorieBezeichnung;
    }

    /**
     * setzt die KategorieBezeichnung
     * @param kategorieBezeichnung, String
     */
    public void setKategorieBezeichnung(String kategorieBezeichnung) {
        this.kategorieBezeichnung = kategorieBezeichnung;
    }

    /**
     * gibt die markenBezeichnung weiter
     * @return markenBezeichnung, String
     */
    public String getMarkenBezeichung() {
        return this.markenBezeichung;
    }

    /**
     * setzt die MarkenBezeichnung
     * @param markenBezeichung, String
     */
    public void setMarkenBezeichung(String markenBezeichung) {
        this.markenBezeichung = markenBezeichung;
    }

    /**
     * gibt die KategorieID weiter
     * @return kategorieID, BigInteger
     */
    public BigInteger getKategorieID() {
        return this.kategorieID;
    }

    /**
     * setzt die kategorieID
     * @param kategorienID, BigInteger
     */
    public void setKategorieID(BigInteger kategorienID) {
        this.kategorieID = kategorienID;
    }

    /**
     * gibt die markenID weiter
     * @return markenID, BigInteger
     */
    public BigInteger getMarkenID() {
        return this.markenID;
    }

    /**
     * Setzt die MarkenID
     * @param markenID, BigInteger
     */
    public void setMarkenID(BigInteger markenID) {
        this.markenID = markenID;
    }

    /**
     * gibt String aus mit allen Werten eines Kleides
     * @return String
     */
    @Override
    public String toString() {
        return "Kleid{" +
                "kleidId=" + this.kleidId +
                ", kleidBeschreibung='" + this.kleidBeschreibung + '\'' +
                "Farbe=" + this.farbe +
                ", kleiderGroesse='" + this.kleiderGroesse + '\'' +
                "markenID=" + this.markenID +
                ",kategorieID='" + this.kategorieID + '\'' +
                '}';
    }
}
