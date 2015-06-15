/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 *  contributor license agreements.  See the NOTICE file distributed with
 *  this work for additional information regarding copyright ownership.
 *  The ASF licenses this file to You under the Apache License, Version 2.0
 *  (the "License"); you may not use this file except in compliance with
 *  the License.  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 *   Unless required by applicable law or agreed to in writing, software
 *   distributed under the License is distributed on an "AS IS" BASIS,
 *   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *   See the License for the specific language governing permissions and
 *   limitations under the License.
 */
package ch.bs.zid.egov.faustina.entities;

import ch.bs.zid.egov.faustina.pojo.Farben;


import javax.persistence.*;
import java.math.BigDecimal;
import java.math.BigInteger;

/**
 * KleidEntity
 * @author Faustina Bruno
 * @version 1
 */

@Entity
public class KleidEntity
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private BigInteger kleidId;
    private String kleidBeschreibung;
    private int kleiderGroesse;
    private Farben farbe;
    private BigDecimal preis;
    private BigInteger kategorieID;

    @ManyToOne(optional = false)
    private KategorieEntity kategorieEntity;

    private BigInteger markenID;
    @ManyToOne(optional = false)
    private MarkenEntity markenEntity;


    /**
     * Setzt die KleiderID
     * @param kleidId, BigInteger
     */
    public void setKleidId(BigInteger kleidId)
    {
        this.kleidId = kleidId;
    }
    /**
     * Gibt die Kleiderbeschriebung wieder
     * @return kleiderBeschreibung, String
     */
    public String getKleidBeschreibung()
    {
        return this.kleidBeschreibung;
    }
    /**
     * setzt die Kleiderbeschreibung
     * @param kleidBeschreibung, String
     */
    public void setKleidBeschreibung(String kleidBeschreibung)
    {
        this.kleidBeschreibung = kleidBeschreibung;
    }
    /**
     * Gibt die Kleider ID weiter
     * @return kleiderID, BigInteger
     */
    public BigInteger getKleidId()
    {
        return this.kleidId;
    }
    /**
     * Gibt die Kleidergroese weiter
     * @return kleiderGroesse, int
     */
    public int getKleiderGroesse()
    {
        return this.kleiderGroesse;
    }
    /**
     * Setzt die Kleidergroesse
     * @param kleiderGroesse, int
     */
    public void setKleiderGroesse(int kleiderGroesse)
    {
        this.kleiderGroesse = kleiderGroesse;
    }
    /**
     * Gibt die Farbe weiter
     * @return farbe, Farbe
     */
    public Farben getFarbe()
    {
        return this.farbe;
    }
    /**
     * setzt die Farbe
     * @param farbe, Farbe
     */
    public void setFarbe(Farben farbe)
    {
        this.farbe = farbe;
    }
    /**
     * Gibt den Preis weiter
     * @return preis, BigDecimal
     */
    public BigDecimal getPreis()
    {
        return this.preis;
    }
    /**
     * setzt den Preis
     * @param preis, BigDecimal
     */
    public void setPreis(BigDecimal preis)
    {
        this.preis = preis;
    }
    /**
     * Gibt die Kategorie ID weiter
     * @return kategorieID, BigInteger
     */
    public BigInteger getKategorieID()
    {
        return this.kategorieID;
    }
    /**
     * Setzt die KategorienID
     * @param kategorieID, Big Integer
     */
    public void setKategorieID(BigInteger kategorieID)
    {
        this.kategorieID = kategorieID;
    }
    /**
     * Gibt die markenID weiter
     * @return makrenID, BigInteger
     */
    public BigInteger getMarkenID()
    {
        return this.markenID;
    }
    /**
     * Setzt die markenID
     * @param markenID, BigInteger die zusetztende markenID
     */
    public void setMarkenID(BigInteger markenID)
    {
        this.markenID = markenID;
    }
    /**
     * Gibt die KategorieEntity weiter
     * @return KategorieEntity
     */
    public KategorieEntity getKategorieEntity() {
        return this.kategorieEntity;
    }
    /**
     * Setzt die KategoryEntity
     * @param kategorieEntity, die zu setztende KategorieEntity
     */
    public void setKategorieEntity(KategorieEntity kategorieEntity) {
        this.kategorieEntity = kategorieEntity;
    }
    /**
     * Gibt die MarkenEntity weieter
     * @return MarkenEntyty
     */
    public MarkenEntity getMarkeEntity() {
        return this.markenEntity;
    }
    /**
     * Setzt die MarkenEntity
     * @param markenEntity, die zu speichernde Markenentity
     */
    public void setMarkenEntity(MarkenEntity markenEntity) {
        this.markenEntity = markenEntity;
    }
    /**
     * String  mit allen Werten eines Kleides
     * @return String
     */
    @Override
    public String toString()
    {
        return "Kleid{" +
                "kleidId=" + this.kleidId +
                ", kleidBeschreibung='" + this.kleidBeschreibung + '\'' +
                "kleidGroesse=" + this.kleiderGroesse +
                ", kleiderFarbe='" + this.farbe + '\'' +
                "Marke=" + this.markenEntity.getMarkenBezeichnung() +
                ", Kategorie='" + this.kategorieEntity.getKategorieBezeichnung() + '\'' +
                '}';
    }
}

