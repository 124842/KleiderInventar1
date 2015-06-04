package ch.bs.zid.egov.faustina.dataSimulation;

import ch.bs.zid.egov.faustina.application.KleiderService;
import ch.bs.zid.egov.faustina.entities.KleidEntity;
import ch.bs.zid.egov.faustina.pojo.Kategorie;
import ch.bs.zid.egov.faustina.pojo.Kleid;
import ch.bs.zid.egov.faustina.pojo.Marke;

import javax.annotation.PostConstruct;
import javax.ejb.Startup;
import javax.inject.Inject;
import javax.ejb.Singleton;
import java.math.BigDecimal;
import java.math.BigInteger;

/**
 * Created by Faustina privat on 28.04.2015.
 */
@Startup
@Singleton
public class KleiderDataSimulation {

    @Inject
    private KleiderService kleiderService;

    @Inject
    private Marke marke;
    @Inject
    private Kategorie kategorie;
    public KleiderDataSimulation() {
    }


    public void initTestData() {
        this.daten();
    }

    private void kleidEinfuellen(BigInteger kategorieID, String beschreibung, int groesse,
                                      BigInteger markenID, BigDecimal preis) {
        Kleid kleid = new Kleid();
     //   kleid.setKategorie(new Kategorie());
        kategorie.setKategorieId(kategorieID);
        kleid.setKleidBeschreibung(beschreibung);
        kleid.setKleiderGroesse(groesse);
      //  kleid.setMarke(new Marke());
        marke.setMarkenId(markenID);
        kleid.setPreis(preis);
        this.kleiderService.addKleid(kleid);
        System.out.println("*********************************************"+beschreibung);

    }


    private void daten() {
        this.kleidEinfuellen(new BigInteger("1"), "Gucci Hose", 38,
                new BigInteger("1"), new BigDecimal("1000.65"));

        this.kleidEinfuellen(new BigInteger("1"), "Gucci Kleid", 38,
                new BigInteger("1"), new BigDecimal("1000.65"));

    }
    }