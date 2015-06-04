package ch.bs.zid.egov.faustina.dataSimulation;

import ch.bs.zid.egov.faustina.application.KategorieService;
import ch.bs.zid.egov.faustina.pojo.Kategorie;


import javax.annotation.PostConstruct;
import javax.ejb.Startup;
import javax.inject.Inject;
import javax.ejb.Singleton;

/**
 * Simulation
 */
@Startup
@Singleton
public class KategorienDataSimulation
{
    @Inject
    private KategorieService kategorieService;

    public KategorienDataSimulation()
    {
    }

    @PostConstruct
    public void initTestData()
    {
        this.daten();
    }

    private void kategorienEinfuellen(String bezeichnung)
    {
        Kategorie kategorie = new Kategorie();
        kategorie.setKategorieBezeichnung(bezeichnung);
        this.kategorieService.addKategorie(kategorie);
        System.out.println("*********************************************"+bezeichnung);
    }

    private void daten()
    {
        this.kategorienEinfuellen("Taseche");
        this.kategorienEinfuellen("Hose");
        this.kategorienEinfuellen("Parka");
        this.kategorienEinfuellen("Schal");
        this.kategorienEinfuellen("Sneaker");
        this.kategorienEinfuellen("High Heels");
        this.kategorienEinfuellen("T-Shirt");
        this.kategorienEinfuellen("Bluse");
        this.kategorienEinfuellen("Pullover");
    }
}
