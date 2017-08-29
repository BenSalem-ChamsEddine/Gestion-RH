package de.cynapsys.servicesImpl;

import de.cynapsys.entities.*;
import de.cynapsys.pojos.*;
import de.cynapsys.repositories.*;
import de.cynapsys.services.CandidatService;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.export.ooxml.JRDocxExporter;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.export.SimpleDocxReportConfiguration;
import net.sf.jasperreports.export.SimpleExporterInput;
import net.sf.jasperreports.export.SimpleOutputStreamExporterOutput;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.*;

@Service
public class CandidatServiceImpl implements CandidatService {

    @Autowired
    CandidatRepository candidatRepository;
    @Autowired
    LangueRepository langueRepository;
    @Autowired
    FormationRepository formationRepository;
    @Autowired
    CertificationRepository certificationRepository;
    @Autowired
    ExperienceRepository experienceRepository;

    @Autowired
    TechnologieRepository technologieRepository;

    @Override
    public Candidat saveCandidat(Candidat c) {
        Candidat candidat = candidatRepository.save(c);
        if(c.getLangues()!= null) {
            for (Langue l : c.getLangues()) {
                int index = c.getLangues().indexOf(l);
                l = langueRepository.findById(l.getId());
                l.getCandidats().add(candidat);
                c.getLangues().set(index, l);
                langueRepository.save(l);
            }
            c.setLangues(c.getLangues());
            return candidatRepository.save(c);
        }else {
            return candidat;
        }
    }

    @Override
    public Candidat updateCandidat(Candidat candidat) {
        if(candidat.getFormations() != null)
        for (Formation formation: candidat.getFormations()) {
            Formation f = formationRepository.findById(formation.getId());
            if(f.getCandidats() == null)
                f.setCandidats(new ArrayList<>());
            Candidat c = f.getCandidats().stream().filter(p -> p.getId().equals(candidat.getId())).findAny().orElse(null);
            if (c == null) {
                f.getCandidats().add(candidat);
                formationRepository.save(f);
            }
        }

        if (candidat.getCertifications() != null)
        for (Certification certification: candidat.getCertifications() ){
            Certification certif = certificationRepository.findById(certification.getId());
            if(certif.getCandidats() == null)
                certif.setCandidats(new ArrayList<>());
            Candidat c = certif.getCandidats().stream().filter(p -> p.getId().equals(candidat.getId())).findAny().orElse(null);
            if(c == null) {
                certif.getCandidats().add(candidat);
                certificationRepository.save(certif);
            }
        }

        if(candidat.getLangues() != null)
        for (Langue l : candidat.getLangues()){
            if(l.getCandidats() == null)
                l.setCandidats(new ArrayList<>());
            Candidat c = l.getCandidats().stream().filter(p -> p.getId().equals(candidat.getId())).findAny().orElse(null);
            if(c == null) {
                l.getCandidats().add(candidat);
                langueRepository.save(l);
            }
        }

        if( candidat.getTechnologies() != null)
        for (Technologie technologie : candidat.getTechnologies()){
            Technologie tech = technologieRepository.findById(technologie.getId());
            if(tech.getCandidats() == null)
                tech.setCandidats(new ArrayList<>());
            Candidat c = tech.getCandidats().stream().filter(p -> p.getId().equals(candidat.getId())).findAny().orElse(null);
            if(c == null){
                tech.getCandidats().add(candidat);
                technologieRepository.save(tech);
            }

        }

        if(candidat.getExperiences() != null)
        for (Experience experience : candidat.getExperiences()){
            Experience ex = experienceRepository.findById(experience.getId());
            if (ex.getCandidat() == null){
                ex.setCandidat(candidat);
                experienceRepository.save(ex);
            }
        }

        return candidatRepository.save(candidat);
    }

    @Override
    public Candidat updateRemoveFormation(Candidat candidat, int idFormation) {
        Formation formation = formationRepository.findById(idFormation);
        candidat = candidatRepository.findById(candidat.getId());
        candidat.getFormations().remove(formation);
        formation.getCandidats().remove(candidat);
        formationRepository.save(formation);
        return candidatRepository.save(candidat);
    }

    @Override
    public Candidat updateRemoveLangue(Candidat candidat, int idLangue) {
        Langue langue = langueRepository.findById(idLangue);
        candidat = candidatRepository.findById(candidat.getId());
        candidat.getLangues().remove(langue);
        langue.getCandidats().remove(candidat);
        langueRepository.save(langue);
        return candidatRepository.save(candidat);
    }

    @Override
    public Candidat updateRemoveCertification(Candidat candidat, int idCertification) {
        Certification certification = certificationRepository.findById(idCertification);
        candidat = candidatRepository.findById(candidat.getId());
        candidat.getCertifications().remove(certification);
        certification.getCandidats().remove(candidat);
        certificationRepository.save(certification);
        return candidatRepository.save(candidat);
    }

    @Override
    public Candidat updateRemoveExperience(Candidat candidat, int idExperience) {
        Experience experience = experienceRepository.findById(idExperience);
        candidat = candidatRepository.findById(candidat.getId());
        candidat.getExperiences().remove(experience);
        experience.setCandidat(null);
        experienceRepository.save(experience);
        return candidatRepository.save(candidat);
    }

    @Override
    public Candidat updateRemoveTechnologie(Candidat candidat, int idTechnologie) {
        Technologie technologie = technologieRepository.findById(idTechnologie);
        candidat = candidatRepository.findById(candidat.getId());
        candidat.getTechnologies().remove(technologie);
        technologie.getCandidats().remove(candidat);
        technologieRepository.save(technologie);
        return candidatRepository.save(candidat);
    }

    @Override
    public List<Candidat> listCandidats() {
        return candidatRepository.findAll();
    }

    @Override
    public void removeCandidat(Candidat c) {
        candidatRepository.delete(c);
    }

    @Override
    public void removeCandidatById(int id) {
        candidatRepository.delete(id);
    }

    @Override
    public Candidat findByTelephone(long telephone) {
        return candidatRepository.findByTelephone(telephone);
    }

    @Override
    public List<Candidat> findByDateEmbauche(Date date) {
        return candidatRepository.findByDateEmbauche(date);
    }

    @Override
    public Candidat findByEmail(String email) {
        return candidatRepository.findByEmail(email);
    }

    @Override
    public Candidat findById(int id) {
        return candidatRepository.findById(id);
    }

    @Override
    public List<Candidat> findByNiveauExperience(String niveau) {
        return candidatRepository.findByNiveauExperience(niveau);
    }

    @Override
    public List<Candidat> findBySituation(String situation) {
        return candidatRepository.findBySituation(situation);
    }

    @Override
    public List<Candidat> findByNom(String nom) {
        return candidatRepository.findByNom(nom);
    }

    @Override
    public List<Candidat> findByPrenom(String prenom) {
        return candidatRepository.findByPrenom(prenom);
    }

    @Override
    public List<Candidat> findByIntegritee(String integritee) {
        return candidatRepository.findByIntegritee(integritee);
    }

    @Override
    public List<Candidat> findByCertifications(Certification certification) {
        return candidatRepository.findByCertifications(certification);
    }

    @Override
    public List<Candidat> findByFormations(Formation formation) {
        return candidatRepository.findByFormations(formation);
    }

    @Override
    public List<Candidat> findByLangues(Langue langue) {
        return candidatRepository.findByLangues(langue);
    }

    @Override
    public List<Candidat> findByExperiences(Experience experience) {
        return candidatRepository.findByExperiences(experience);
    }

    @Override
    public List<Candidat> findByTechnologies(Technologie technologie) {
        return candidatRepository.findByTechnologies(technologie);
    }

    @Override
    public void imprimerCV(int idCandidat, String format, HttpServletResponse response) throws JRException, IOException {

        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy");
        SimpleDateFormat dateMoisFormat = new SimpleDateFormat("yyyy-MM");

        Candidat candidat = candidatRepository.findById(idCandidat);
        if (candidat == null){
            candidat = new Candidat();
            candidat.setTechnologies(new ArrayList<>());
            candidat.setLangues(new ArrayList<>());
            candidat.setAffectations(new ArrayList<>());
            candidat.setCertifications(new ArrayList<>());
            candidat.setExperiences(new ArrayList<>());
            candidat.setFormations(new ArrayList<>());
        }

        CandidatPojo candidatPojo =new CandidatPojo();
        candidatPojo.setNiveauExperience(candidat.getNiveauExperience());
        candidatPojo.setNom(candidat.getNom() +' ' + candidat.getPrenom());

        CertificationPojo certificationPojo = new CertificationPojo();
        List<CertificationPojo> listCertificationPojo = new ArrayList<>();
        for (Certification certification : candidat.getCertifications()){
            certificationPojo.setLibelleCertif(certification.getLibelle());
            certificationPojo.setLieuCertif(certification.getLieu());
            certificationPojo.setDateCertif(dateFormat.format(certification.getDate()));
            listCertificationPojo.add(certificationPojo);
        }
        candidatPojo.setListCertification(listCertificationPojo);

        FormationPojo formationPojo = new FormationPojo();
        List<FormationPojo> listFormationPojo = new ArrayList<>();
        for(Formation formation : candidat.getFormations()){
            formationPojo.setLibelleForm(formation.getLibelle());
            formationPojo.setLieu(formation.getLieu());
            formationPojo.setAnnee(dateFormat.format(formation.getDatedebut()) + '-' + dateFormat.format(formation.getDatefin()));
            listFormationPojo.add(formationPojo);
        }
        candidatPojo.setListFormation(listFormationPojo);

        CompetencePojo competencePojo = new CompetencePojo();
        List<CompetencePojo> listCompetence = new ArrayList<>();
        for (Technologie technologie:candidat.getTechnologies()) {

            competencePojo = listCompetence.stream().filter(p -> p.getLibelleComp().equals(technologie.getCompetence().getLibelle())).findAny().orElse(null);

            if (competencePojo != null){
                    competencePojo.setTechnologies(competencePojo.getTechnologies() + ", " + technologie.getLibelle());
            }
            else
            {
                competencePojo = new CompetencePojo();
                competencePojo.setLibelleComp(technologie.getCompetence().getLibelle());
                competencePojo.setTechnologies(technologie.getLibelle());
                listCompetence.add(competencePojo);
            }
        }
        candidatPojo.setListCompetence(listCompetence);

        ExperiencePojo experiencePojo = new ExperiencePojo();
        List<ExperiencePojo> listExperience = new ArrayList<>();
        List<TachePojo> listTache = new ArrayList<>();
        TachePojo tachePojo = new TachePojo();
        for (Experience e: candidat.getExperiences()) {
            experiencePojo.setDateExp(dateMoisFormat.format(e.getDatedebut()) + " - " + dateMoisFormat.format(e.getDatefin()));
            experiencePojo.setPoste(e.getPoste());
            experiencePojo.setClient(e.getProjet().getClient());
            experiencePojo.setEquipeProjet(e.getProjet().getEquipeprojet());
            experiencePojo.setTitreProjet(e.getProjet().getTitre());

            for (Tache t: e.getTaches()) {
                tachePojo.setLibelleTache(t.getLibelle());
                listTache.add(tachePojo);
                tachePojo = new TachePojo();
            }
            experiencePojo.setListTache(listTache);
            listTache = new ArrayList<>();

            for (Technologie technologie: e.getProjet().getTechnologies()){
                if (experiencePojo.getTechnologiesPro() != null)
                    experiencePojo.setTechnologiesPro(experiencePojo.getTechnologiesPro()+ ", " + technologie.getLibelle());
                else
                    experiencePojo.setTechnologiesPro(technologie.getLibelle());
            }
            listExperience.add(experiencePojo);
            experiencePojo = new ExperiencePojo();
        }
        candidatPojo.setListExperience(listExperience);

        LanguePojo languePojo= new LanguePojo();
        List<LanguePojo> listLangue = new ArrayList<>();
        for (Langue l : candidat.getLangues()) {
            languePojo.setLibelleLang(l.getLibelle());
            languePojo.setNiveau(l.getNiveau());
            listLangue.add(languePojo);
            languePojo = new LanguePojo();
        }
        candidatPojo.setListLangue(listLangue);

        List<CandidatPojo> listcandidat = new ArrayList<>();
        listcandidat.add(candidatPojo);

        Map<String, Object> params = new HashMap<>();
        params.put("nom", candidatPojo.getNom());
        params.put("niveauExperience", candidatPojo.getNiveauExperience());

        //competence
        params.put("libelleComp", competencePojo.getLibelleComp());
        params.put("technologies", competencePojo.getTechnologies());

        //experience
        params.put("client", experiencePojo.getClient());
        params.put("dateExp", experiencePojo.getDateExp());
        params.put("titreProjet", experiencePojo.getTitreProjet());
        params.put("equipeProjet", experiencePojo.getEquipeProjet());
        params.put("technologiesPro", experiencePojo.getTechnologiesPro());
        params.put("libelleTache", tachePojo.getLibelleTache());

        //langue
        params.put("libelleLang", languePojo.getLibelleLang());
        params.put("niveau", languePojo.getNiveau());



        JRBeanCollectionDataSource dataSourceMasterReport = new JRBeanCollectionDataSource(listcandidat);

        InputStream jasperStream = this.getClass().getResourceAsStream("/jasperreports/template-cv-cynapsys.jasper");
        JasperReport jasperReport = (JasperReport) JRLoader.loadObject(jasperStream);
        JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, params, dataSourceMasterReport);

            response.setContentType("application/x-pdf");
            response.setHeader("Content-disposition", "inline; filename="+candidatPojo.getNom()+"."+format);
            JasperExportManager.exportReportToPdfStream(jasperPrint, response.getOutputStream());


    }


}
