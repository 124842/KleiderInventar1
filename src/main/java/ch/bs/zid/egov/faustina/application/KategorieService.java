package ch.bs.zid.egov.faustina.application;

import ch.bs.zid.egov.faustina.entities.KategorieEntity;
import ch.bs.zid.egov.faustina.pojo.Kategorie;
import ch.bs.zid.egov.faustina.pojo.Marke;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaQuery;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * KategorieService,Hier geschieht die ganze Logik zwischen Datenbank und der Rest der Applikation
 * Auch das Maping von den Pojos und Enteties geschieht hier
 * @author Faustina Bruno
 * @version 1.0
 */
@Stateless
public class KategorieService implements Serializable {
    @PersistenceContext(unitName = "kleider-pu")
    private EntityManager entityManager;
    /**
     * Fügt eine Kategorie in die Datenbank hinzu
     * @param kategorie, die zuhinzufügende Kategorie
     * @return Kategrorie, die hinzugefügte Kategorie
     */
    public Kategorie addKategorie(Kategorie kategorie) {
        KategorieEntity kategorieEntity = this.convertKategorieToEntity(kategorie);
        this.entityManager.persist(kategorieEntity);
        return this.convertEntityToKategorie(kategorieEntity);
    }
    /**
     * Holt alle Kategorien von der Datenbank
     * @return List von Kategorien, eine Liste mit allen Kategorien
     */
    public List<Kategorie> getAllKategorien() {
        CriteriaQuery<KategorieEntity> cq = this.entityManager.getCriteriaBuilder().createQuery(KategorieEntity.class);
        cq.select(cq.from(KategorieEntity.class));
        List<KategorieEntity> kategorieEntities = this.entityManager.createQuery(cq).getResultList();

        List<Kategorie> kategories = new ArrayList<Kategorie>();

        if (kategorieEntities != null && !kategorieEntities.isEmpty()) {
            for (KategorieEntity kategorieEntity : kategorieEntities)
            {
                kategories.add(this.convertEntityToKategorie(kategorieEntity));
            }
        }
        return kategories;
    }
    private Kategorie convertEntityToKategorie(KategorieEntity kategorieEntity) {
        Kategorie kategorie = new Kategorie();
        kategorie.setKategorieId(kategorieEntity.getKategorieId());
        kategorie.setKategorieBezeichnung(kategorieEntity.getKategorieBezeichnung());
        return kategorie;
    }
    private KategorieEntity convertKategorieToEntity(Kategorie kategorie) {
        KategorieEntity kategorieEntity = new KategorieEntity();

        kategorieEntity.setKategorieId(kategorie.getKategorieId());
        kategorieEntity.setKategorieBezeichnung(kategorie.getKategorieBezeichnung());
        return kategorieEntity;
    }
    /**
     * Holt Kategorien anhand einer ID aus der Datenbank
     * @param kategorieID, der gesuchten Kategorie
     * @return Kategorie, die auf diese ID passt
     */
    public Kategorie getKategoriefromID(int kategorieID){
        return this.convertEntityToKategorie(this.entityManager.find(KategorieEntity.class,kategorieID));
    }
}
