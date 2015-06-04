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
import ch.bs.zid.egov.faustina.pojo.Kategorie;
import ch.bs.zid.egov.faustina.pojo.Marke;

import javax.persistence.*;
import java.math.BigDecimal;
import java.math.BigInteger;

/**
 * Kleid
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
    @JoinColumn(name="kategorie_ID")
    private KategorieEntity kategorie;

    private BigInteger markenID;
    @ManyToOne(optional = false)
    @JoinColumn(name="marken_ID")
    private MarkenEntity marke;


    public BigInteger getKLeidId()
    {
        return this.kleidId;
    }

    public void setKleidId(BigInteger kleidId)
    {
        this.kleidId = kleidId;
    }

    public String getKleidBeschreibung()
    {
        return this.kleidBeschreibung;
    }

    public void setKleidBeschreibung(String kleidBeschreibung)
    {
        this.kleidBeschreibung = kleidBeschreibung;
    }


    public BigInteger getKleidId()
    {
        return this.kleidId;
    }

    public int getKleiderGroesse()
    {
        return this.kleiderGroesse;
    }

    public void setKleiderGroesse(int kleiderGroesse)
    {
        this.kleiderGroesse = kleiderGroesse;
    }

    public Farben getFarbe()
    {
        return this.farbe;
    }

    public void setFarbe(Farben farbe)
    {
        this.farbe = farbe;
    }

    public BigDecimal getPreis()
    {
        return this.preis;
    }

    public void setPreis(BigDecimal preis)
    {
        this.preis = preis;
    }

    public BigInteger getKategorieID()
    {
        return this.kategorieID;
    }

    public void setKategorieID(BigInteger kategorieID)
    {
        this.kategorieID = kategorieID;
    }

    public BigInteger getMarkenID()
    {
        return this.markenID;
    }

    public void setMarkenID(BigInteger markenID)
    {
        this.markenID = markenID;
    }


    public KategorieEntity getKategorieEntity() {
        return this.kategorie;
    }


    public void setKategorieEntity(KategorieEntity kategorie) {
        this.kategorie = kategorie;
    }


    public MarkenEntity getMarkeEntity() {
        return this.marke;
    }

    public void setMarkenEntity(MarkenEntity marke) {
        this.marke = marke;
    }

    @Override
    public String toString()
    {
        return "Kleid{" +
                "kleidId=" + this.kleidId +
                ", kleidBeschreibung='" + this.kleidBeschreibung + '\'' +
                '}';
    }
}

