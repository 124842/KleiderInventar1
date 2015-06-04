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
package ch.bs.zid.egov.faustina.application;

import ch.bs.zid.egov.faustina.entities.KategorieEntity;
import ch.bs.zid.egov.faustina.entities.KleidEntity;
import ch.bs.zid.egov.faustina.entities.MarkenEntity;
import ch.bs.zid.egov.faustina.pojo.Kategorie;
import ch.bs.zid.egov.faustina.pojo.Kleid;
import ch.bs.zid.egov.faustina.pojo.Marke;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaQuery;
import java.io.Serializable;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
/**
 * KleiderService, Hier geschieht die ganze Logik zwischen Datenbank und der Rest der Applikation
 * Auch das Maping von den Pojos und Enteties geschieht hier
 * @author Faustina Bruno
 * @version 1.0
 */

@Stateless
public class KleiderService implements Serializable
{

    @PersistenceContext(unitName = "kleider-pu")
    private EntityManager entityManager;

    @Inject
    KategorieService kategorieService = new KategorieService();

    @Inject
    MarkenService markenService = new MarkenService();

    public Kleid addKleid(Kleid kleid)
    {
        KleidEntity kleidEntity = this.convertKleidToEntity(kleid);
        this.entityManager.persist(kleidEntity);
        return this.convertEntityToKleid(kleidEntity);
    }

    public Kleid updateKleid(Kleid kleid){
        KleidEntity kleidEntity = this.convertKleidToEntity(kleid);
        this.entityManager.merge(kleidEntity);
        return this.convertEntityToKleid(kleidEntity);
    }
    public List<Kleid> getAllKleider()
    {
        CriteriaQuery<KleidEntity> cq = this.entityManager.getCriteriaBuilder().createQuery(KleidEntity.class);
        cq.select(cq.from(KleidEntity.class));
        List<KleidEntity> kleidEntities= this.entityManager.createQuery(cq).getResultList();

        List<Kleid> kleider = new ArrayList<Kleid>();
        if(kleidEntities != null && !kleidEntities.isEmpty()){
            for(KleidEntity kleidEntity:kleidEntities){
                kleider.add(this.convertEntityToKleid(kleidEntity));
            }
        }
        return kleider;
    }


    public Kleid convertEntityToKleid(KleidEntity kleidEntity) {

        Kleid kleid = new Kleid();
        kleid.setKleidId(kleidEntity.getKleidId());
        kleid.setPreis(kleidEntity.getPreis());
        kleid.setKleiderGroesse(kleidEntity.getKleiderGroesse());
        kleid.setKleidBeschreibung(kleidEntity.getKleidBeschreibung());
        kleid.setFarbe(kleidEntity.getFarbe());

        kleid.setMarkenID(kleidEntity.getMarkeEntity().getMarkenId());
        kleid.setMarkenBezeichung(kleidEntity.getMarkeEntity().getMarkenBezeichnung());

        kleid.setKategorieBezeichnung(kleidEntity.getKategorieEntity().getKategorieBezeichnung());
        kleid.setKategorieID(kleidEntity.getKategorieEntity().getKategorieId());

        kleid.setKategorieBezeichnung(this.convertKategorieIDInKategorieBezeichnung(kleidEntity.getKategorieID()));
        kleid.setMarkenBezeichung(this.convertMarkenIDInMarkenBezeichnung(kleidEntity.getMarkenID()));
        return kleid;
    }

    public KleidEntity convertKleidToEntity(Kleid kleid) {
        KleidEntity kleidEntity = new KleidEntity();
        kleidEntity.setKleidId(kleid.getKleidId());
        kleidEntity.setPreis(kleid.getPreis());
        kleidEntity.setKleidBeschreibung(kleid.getKleidBeschreibung());
        kleidEntity.setFarbe(kleid.getFarbe());
        kleidEntity.setKleiderGroesse(kleid.getKleiderGroesse());

        kleidEntity.setKategorieEntity(this.convertToKategorieFromID(kleid.getKategorieID()));
        kleidEntity.setMarkenEntity(this.convertToMarkeFromID(kleid.getMarkenID()));

      kleidEntity.setMarkenID(kleid.getMarkenID());
    kleidEntity.setKategorieID(kleid.getKategorieID());
        return kleidEntity;
    }
public KategorieEntity convertKategorieToEntity(Kategorie kategorie){
    KategorieEntity kategorieEntity = new KategorieEntity();
    kategorieEntity.setKategorieId(kategorie.getKategorieId());
    kategorieEntity.setKategorieBezeichnung(kategorie.getKategorieBezeichnung());
    return kategorieEntity;
}

    public MarkenEntity convertMarkeToEntity(Marke marke){
        MarkenEntity markenEntity = new MarkenEntity();
        markenEntity.setMarkenId(marke.getMarkenId());
        markenEntity.setMarkenBezeichnung(marke.getMarkenBezeichnung());
        return markenEntity;
    }

public Kategorie convertEntityToKategorie(KategorieEntity kategorieEntity){
    Kategorie kategorie = new Kategorie();
    kategorie.setKategorieId(kategorieEntity.getKategorieId());
    kategorie.setKategorieBezeichnung(kategorieEntity.getKategorieBezeichnung());
    return kategorie;
}

    public Marke convertEntityToMarke(MarkenEntity markenEntity){
        Marke marke= new Marke();
        marke.setMarkenId(markenEntity.getMarkenId());
        marke.setMarkenBezeichnung(markenEntity.getMarkenBezeichnung());
        return marke;
    }


    public String convertKategorieIDInKategorieBezeichnung(BigInteger kategorieID){
        List<Kategorie> kategorien = this.kategorieService.getAllKategorien();
        for (Kategorie kategorie : kategorien){
            if(kategorie.getKategorieId().equals(kategorieID)){
                return kategorie.getKategorieBezeichnung();
            }
        }
        return null;
    }

    public String convertMarkenIDInMarkenBezeichnung(BigInteger markenID){
        List<Marke> marken = this.markenService.getAllMarken();
        for(Marke marke: marken){
            if(marke.getMarkenId().equals(markenID)){
                return  marke.getMarkenBezeichnung();
            }
        }
        return null;
    }

    private KategorieEntity convertToKategorieFromID(BigInteger kategorieId){
        int id= kategorieId.intValue();
       return this.convertKategorieToEntity(this.kategorieService.getKategoriefromID(id));
    }

    private MarkenEntity convertToMarkeFromID(BigInteger markenId){
        int id = markenId.intValue();
       return this.convertMarkeToEntity(this.markenService.getMarkefromID(id));
    }

    public Kleid getKleidByID(BigInteger kleidID){
        int id= kleidID.intValue();
        return this.convertEntityToKleid(this.entityManager.find(KleidEntity.class,id));
    }

    public void deleteKleid(BigInteger kleidID){

        KleidEntity kleidToDelet = this.entityManager.find(KleidEntity.class, kleidID);

        this.entityManager.remove(kleidToDelet);

    }
}
