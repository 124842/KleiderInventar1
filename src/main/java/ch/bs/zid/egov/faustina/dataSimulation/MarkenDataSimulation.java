package ch.bs.zid.egov.faustina.dataSimulation;

import ch.bs.zid.egov.faustina.application.MarkenService;
import ch.bs.zid.egov.faustina.pojo.Marke;

import javax.annotation.PostConstruct;
import javax.ejb.Startup;
import javax.inject.Inject;
import javax.ejb.Singleton;

/**
 * Simulation
 */

@Startup
@Singleton
public class MarkenDataSimulation
{

    @Inject
    private MarkenService markenService;

    public MarkenDataSimulation(){}

    @PostConstruct
    public void initTestData(){
        this.daten();
    }

    private void markenEinfuellen(String bezeichnung){
        Marke marke = new Marke();
        marke.setMarkenBezeichnung(bezeichnung);
        this.markenService.addMarke(marke);
        System.out.println("*********************************************"+bezeichnung);
    }
    private void daten(){
        this.markenEinfuellen("Levis");
        this.markenEinfuellen("H&M");
        this.markenEinfuellen("Zara");
        this.markenEinfuellen("NewBalance");
        this.markenEinfuellen("TopShop");
    }
}
