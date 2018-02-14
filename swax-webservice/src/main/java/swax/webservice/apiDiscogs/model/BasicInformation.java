
package swax.webservice.apiDiscogs.model;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "labels",
    "formats",
    "artists",
    "thumb",
    "title",
    "cover_image",
    "resource_url",
    "year",
    "id"
})
@Getter
@Setter
public class BasicInformation {

    @JsonProperty("labels")
    public List<Label> labels = null;
    @JsonProperty("formats")
    public List<Format> formats = null;
    @JsonProperty("artists")
    public List<Artist> artists = null;
    @JsonProperty("thumb")
    public String thumb;
    @JsonProperty("title")
    public String title;
    @JsonProperty("cover_image")
    public String coverImage;
    @JsonProperty("resource_url")
    public String resourceUrl;
    @JsonProperty("year")
    public Integer year;
    @JsonProperty("id")
    public Integer id;

}
