package de.cynapsys.serialization;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;
import de.cynapsys.entities.*;

import java.io.IOException;
import java.text.SimpleDateFormat;

public class CandidatSerializer extends StdSerializer<Candidat> {


    public CandidatSerializer() {
        this(null);
    }
    public CandidatSerializer(Class<Candidat> t) {
        super(t);
    }

    @Override
    public void serialize(Candidat candidat, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {

        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String formattedDate = null;
        if (candidat.getDateEmbauche() != null){
            formattedDate =dateFormat.format(candidat.getDateEmbauche());
        }

            jsonGenerator.writeStartObject();
            jsonGenerator.writeNumberField("id", candidat.getId());
            jsonGenerator.writeNumberField("telephone", candidat.getTelephone());
            jsonGenerator.writeStringField("dateEmbauche", formattedDate);
            jsonGenerator.writeStringField("email", candidat.getEmail());
            jsonGenerator.writeStringField("niveauExperience", candidat.getNiveauExperience());
            jsonGenerator.writeStringField("nom", candidat.getNom());
            jsonGenerator.writeStringField("prenom", candidat.getPrenom());
            jsonGenerator.writeStringField("situation", candidat.getSituation());
            jsonGenerator.writeStringField("integritee", candidat.getIntegritee());

            // Affectation
            jsonGenerator.writeArrayFieldStart("affectations");
            for (Affectation affectation : candidat.getAffectations()) {
                jsonGenerator.writeStartObject();
                jsonGenerator.writeNumberField("id", affectation.getId());
                jsonGenerator.writeStringField("commercial", affectation.getCommercial());

                if(affectation.getDatedebut() != null){
                    jsonGenerator.writeStringField("datedebut", dateFormat.format(affectation.getDatedebut()));
                }else {
                    jsonGenerator.writeStringField("datedebut", null);
                }

                if(affectation.getDatefin() != null){
                    jsonGenerator.writeStringField("datefin", dateFormat.format(affectation.getDatefin()));
                }else {
                    jsonGenerator.writeStringField("datefin", null);
                }
                jsonGenerator.writeEndObject();
            }
            jsonGenerator.writeEndArray();

        // Certification
        jsonGenerator.writeArrayFieldStart("certifications");
        for (Certification certification : candidat.getCertifications()) {
            jsonGenerator.writeStartObject();
            jsonGenerator.writeNumberField("id", certification.getId());

            if(certification.getDate() != null){
                jsonGenerator.writeStringField("date", dateFormat.format(certification.getDate()));
            }else {
                jsonGenerator.writeStringField("date", null);
            }
            jsonGenerator.writeStringField("libelle", certification.getLibelle());
            jsonGenerator.writeStringField("lieu", certification.getLieu());

            jsonGenerator.writeEndObject();
        }
        jsonGenerator.writeEndArray();

        // Technologie
        jsonGenerator.writeArrayFieldStart("technologies");
        for (Technologie technologie : candidat.getTechnologies()) {
            jsonGenerator.writeStartObject();

            jsonGenerator.writeNumberField("id", technologie.getId());
            jsonGenerator.writeStringField("libelle", technologie.getLibelle());
            jsonGenerator.writeFieldName("competence");

            jsonGenerator.writeStartObject();
//            jsonGenerator.writeNumberField("id", technologie.getCompetence().getId());
            jsonGenerator.writeStringField("libelle", technologie.getCompetence().getLibelle());
            jsonGenerator.writeEndObject();

            jsonGenerator.writeEndObject();
        }
        jsonGenerator.writeEndArray();

        // Formation
        jsonGenerator.writeArrayFieldStart("formations");
        for (Formation formation : candidat.getFormations()) {
            jsonGenerator.writeStartObject();
            jsonGenerator.writeNumberField("id", formation.getId());

            if(formation.getDatedebut() != null){
                jsonGenerator.writeStringField("datedebut", dateFormat.format(formation.getDatedebut()));
            }else {
                jsonGenerator.writeStringField("datedebut", null);
            }

            if(formation.getDatefin() != null){
                jsonGenerator.writeStringField("datefin", dateFormat.format(formation.getDatefin()));
            }else {
                jsonGenerator.writeStringField("datefin", null);
            }

            jsonGenerator.writeStringField("libelle", formation.getLibelle());
            jsonGenerator.writeStringField("lieu", formation.getLieu());

            jsonGenerator.writeEndObject();
        }
        jsonGenerator.writeEndArray();


        // Langue
        jsonGenerator.writeArrayFieldStart("langues");
        for (Langue langue : candidat.getLangues()) {
            jsonGenerator.writeStartObject();
            jsonGenerator.writeNumberField("id", langue.getId());

            jsonGenerator.writeStringField("libelle", langue.getLibelle());
            jsonGenerator.writeStringField("niveau", langue.getNiveau());

            jsonGenerator.writeEndObject();
        }
        jsonGenerator.writeEndArray();


        // Experience
        jsonGenerator.writeArrayFieldStart("experiences");
        for (Experience experience : candidat.getExperiences()) {
            jsonGenerator.writeStartObject();
                jsonGenerator.writeNumberField("id", experience.getId());

                if(experience.getDatedebut() != null){
                    jsonGenerator.writeStringField("datedebut", dateFormat.format(experience.getDatedebut()));
                }else {
                    jsonGenerator.writeStringField("datedebut", null);
                }

                if(experience.getDatefin() != null){
                    jsonGenerator.writeStringField("datefin", dateFormat.format(experience.getDatefin()));
                }else {
                    jsonGenerator.writeStringField("datefin", null);
                }

                jsonGenerator.writeStringField("poste", experience.getPoste());

                jsonGenerator.writeFieldName("projet");
                jsonGenerator.writeStartObject();
                    jsonGenerator.writeNumberField("id", experience.getProjet().getId());
                    jsonGenerator.writeStringField("client", experience.getProjet().getClient());
                    jsonGenerator.writeStringField("equipeprojet", experience.getProjet().getEquipeprojet());
                    jsonGenerator.writeStringField("titre", experience.getProjet().getTitre());
                jsonGenerator.writeEndObject();


                jsonGenerator.writeArrayFieldStart("taches");
                for (Tache tache : experience.getTaches()){
                    jsonGenerator.writeStartObject();
                    jsonGenerator.writeNumberField("id", tache.getId());
                    jsonGenerator.writeStringField("libelle", tache.getLibelle());
                    jsonGenerator.writeEndObject();
                }
                jsonGenerator.writeEndArray();


            jsonGenerator.writeEndObject();
        }
        jsonGenerator.writeEndArray();


            jsonGenerator.writeEndObject();
    }
}
