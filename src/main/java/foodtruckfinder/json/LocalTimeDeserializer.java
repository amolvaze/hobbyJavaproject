package foodtruckfinder.json;

import java.io.IOException;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;

public class LocalTimeDeserializer extends StdDeserializer<LocalTime> {
	
	private static final long serialVersionUID = 1L;
	
	private static final DateTimeFormatter FMT_HHMM = DateTimeFormatter.ofPattern("HH:mm");

	public LocalTimeDeserializer() { 
        this(null); 
    } 
 
    public LocalTimeDeserializer(Class<?> vc) { 
        super(vc); 
    }
	
	@Override
	public LocalTime deserialize(JsonParser p, DeserializationContext ctxt)
			throws IOException, JsonProcessingException {
		String time = p.getText();
	    return LocalTime.parse(time, FMT_HHMM); 
	}
	
	

}
