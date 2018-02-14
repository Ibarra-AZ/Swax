
package swax.webservice.apiDiscogs.model;

import java.util.List;

import swax.webservice.entity.album.AlbumDiscogs;
import lombok.Getter;
import lombok.Setter;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "descriptions",
    "text",
    "name",
    "qty"
})
@Getter
@Setter
public class Format {

    @JsonProperty("descriptions")
    public List<String> descriptions = null;
    @JsonProperty("text")
    public String text;
    @JsonProperty("name")
    public String name;
    @JsonProperty("qty")
    public String qty;

    /**
     * Utilisé pour la transformation en objet {@link AlbumDiscogs}
     */
    @Override
    public String toString() {
    	if(name!=null){
    		return name;
    	}else{
    		return "";
    	}
    }
}
