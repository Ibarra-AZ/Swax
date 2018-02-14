
package swax.webservice.apiDiscogs.model;

import swax.webservice.entity.album.AlbumDiscogs;
import lombok.Getter;
import lombok.Setter;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "name",
    "entity_type",
    "catno",
    "resource_url",
    "id",
    "entity_type_name"
})
@Getter
@Setter
public class Label {

    @JsonProperty("name")
    public String name;
    @JsonProperty("entity_type")
    public String entityType;
    @JsonProperty("catno")
    public String catno;
    @JsonProperty("resource_url")
    public String resourceUrl;
    @JsonProperty("id")
    public Integer id;
    @JsonProperty("entity_type_name")
    public String entityTypeName;
    
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
