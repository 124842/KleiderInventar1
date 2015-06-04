package ch.bs.zid.egov.faustina.pojo;

import javax.persistence.*;
import java.math.BigDecimal;
import java.math.BigInteger;

/**
 * Created by Faustina privat on 15.05.2015.
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


 //   private Kategorie kategorie = new Kategorie();
    private BigInteger kategorieID;

  //  private Marke marke = new Marke();
    private BigInteger markenID;


    public BigInteger getKLeidId() {
        return this.kleidId;
    }

    public void setKleidId(BigInteger kleidId) {
        this.kleidId = kleidId;
    }

    public String getKleidBeschreibung() {
        return this.kleidBeschreibung;
    }

    public void setKleidBeschreibung(String kleidBeschreibung) {
        this.kleidBeschreibung = kleidBeschreibung;
    }


    public BigInteger getKleidId() {
        return this.kleidId;
    }

    public int getKleiderGroesse() {
        return this.kleiderGroesse;
    }

    public void setKleiderGroesse(int kleiderGroesse) {
        this.kleiderGroesse = kleiderGroesse;
    }

    public Farben getFarbe() {
        return this.farbe;
    }

    public void setFarbe(Farben farbe) {
        this.farbe = farbe;
    }

    public BigDecimal getPreis() {
        return this.preis;
    }

    public void setPreis(BigDecimal preis) {
        this.preis = preis;
    }

    public String getKategorieBezeichnung() {

        return this.kategorieBezeichnung;
    }

    public void setKategorieBezeichnung(String kategorieBezeichnung) {
        this.kategorieBezeichnung = kategorieBezeichnung;
    }

    public String getMarkenBezeichung() {
        return this.markenBezeichung;
    }

    public void setMarkenBezeichung(String markenBezeichung) {
        this.markenBezeichung = markenBezeichung;
    }

    public BigInteger getKategorieID() {
        return this.kategorieID;
    }

    public void setKategorieID(BigInteger kategorienID) {
        this.kategorieID = kategorienID;
    }

    public BigInteger getMarkenID() {
        return this.markenID;
    }

    public void setMarkenID(BigInteger markenID) {
        this.markenID = markenID;
    }



    @Override
    public String toString() {
        return "Kleid{" +
                "kleidId=" + this.kleidId +
                ", kleidBeschreibung='" + this.kleidBeschreibung + '\'' +
                '}';
    }
}
