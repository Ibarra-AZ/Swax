
package swax.webservice.apiDiscogs.model;

import lombok.Getter;
import lombok.Setter;
import swax.webservice.entity.album.AlbumDiscogs;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "join",
    "name",
    "anv",
    "tracks",
    "role",
    "resource_url",
    "id"
})
@Getter
@Setter
public class Artist {

    @JsonProperty("join")
    public String join;
    @JsonProperty("name")
    public String name;
    @JsonProperty("anv")
    public String anv;
    @JsonProperty("tracks")
    public String tracks;
    @JsonProperty("role")
    public String role;
    @JsonProperty("resource_url")
    public String resourceUrl;
    @JsonProperty("id")
    public Integer id;
    
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
