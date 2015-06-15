package ch.bs.zid.egov.faustina;


import ch.bs.zid.egov.faustina.application.KategorieService;
import ch.bs.zid.egov.faustina.application.KleiderService;
import ch.bs.zid.egov.faustina.application.MarkenService;
import ch.bs.zid.egov.faustina.pojo.Kategorie;
import ch.bs.zid.egov.faustina.pojo.Kleid;
import ch.bs.zid.egov.faustina.pojo.Marke;

import javax.ejb.embeddable.EJBContainer;
import javax.naming.Context;
import javax.naming.NamingException;
import java.math.BigDecimal;
import java.math.BigInteger;

/**
 * Created by Faustina privat on 04.06.2015.
 */
public class UpdateKleid {

/*
    private static Context ctx;
    private static EJBContainer ejbContainer;

    @BeforeClass
    public static void setUp() {
        ejbContainer = EJBContainer.createEJBContainer();
        System.out.println("Opening the container" );
        ctx = ejbContainer.getContext();
    }

    @AfterClass
    public static void tearDown() {
        ejbContainer.close();
        System.out.println("Closing the container" );
    }

    @Test
    public void updateKleid()throws NamingException{

        KleiderService kleiderService =  (KleiderService) ctx.lookup("java:global/classes/KleiderService");
        //KategorieService kategorieService = new KategorieService();
       // MarkenService markenService= new MarkenService();
        Kleid kleid = new Kleid();

      /*
        Kategorie kat1= new Kategorie();
        kat1.setKategorieBezeichnung("fausta");
        kategorieService.addKategorie(kat1);
        Kategorie kategorie = kategorieService.getAllKategorien().get(1);

        Marke mark1 = new Marke();
        mark1.setMarkenBezeichnung("Fausta");
        markenService.addMarke(mark1);
        Marke marke= markenService.getAllMarken().get(1);




        kleid.setKleidBeschreibung("Rotes Mini Kleid");
        kleid.setKleiderGroesse(40);
        kleid.setPreis(new BigDecimal("100"));
        kleid.setKategorieID(kategorie.getKategorieId());
        kleid.setMarkenID(marke.getMarkenId());

        kleiderService.addKleid(kleid);


        String alteBezeichnung = kleid.getKleidBeschreibung();

        kleid.setKleidBeschreibung("Rote Shorts");
        kleiderService.updateKleid(kleid);
        String neueBezeichnung = kleid.getKleidBeschreibung();

Assert.assertNotEquals(alteBezeichnung,kleid.getKleidBeschreibung());


    }
*/
}
