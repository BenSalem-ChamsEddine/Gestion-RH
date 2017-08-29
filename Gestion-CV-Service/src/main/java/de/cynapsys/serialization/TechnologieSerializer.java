package de.cynapsys.serialization;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;
import de.cynapsys.entities.Competence;
import de.cynapsys.entities.Technologie;

import java.io.IOException;

public class TechnologieSerializer extends StdSerializer<Technologie> {

    public TechnologieSerializer() {
        this(null);
    }
    public TechnologieSerializer(Class<Technologie> t) {
        super(t);
    }

    @Override
    public void serialize(Technologie technologie, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {

        jsonGenerator.writeStartObject();
        jsonGenerator.writeNumberField("id", technologie.getId());
        jsonGenerator.writeStringField("libelle", technologie.getLibelle());
        jsonGenerator.writeFieldName("competence");

        jsonGenerator.writeStartObject();
        jsonGenerator.writeNumberField("id", technologie.getCompetence().getId());
        jsonGenerator.writeStringField("libelle", technologie.getCompetence().getLibelle());
        jsonGenerator.writeEndObject();

        jsonGenerator.writeEndObject();
    }
}
