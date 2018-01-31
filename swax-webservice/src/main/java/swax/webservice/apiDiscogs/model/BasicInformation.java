
package swax.webservice.apiDiscogs.model;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "labels",
    "formats",
    "thumb",
    "title",
    "artists",
    "resource_url",
    "year",
    "id"
})
public class BasicInformation {

    @JsonProperty("labels")
    private List<Label> labels = null;
    @JsonProperty("formats")
    private List<Format> formats = null;
    @JsonProperty("thumb")
    private String thumb;
    @JsonProperty("title")
    private String title;
    @JsonProperty("artists")
    private List<Artist> artists = null;
    @JsonProperty("resource_url")
    private String resourceUrl;
    @JsonProperty("year")
    private Long year;
    @JsonProperty("id")
    private Long id;

    @JsonProperty("labels")
    public List<Label> getLabels() {
        return labels;
    }

    @JsonProperty("labels")
    public void setLabels(List<Label> labels) {
        this.labels = labels;
    }

    @JsonProperty("formats")
    public List<Format> getFormats() {
        return formats;
    }

    @JsonProperty("formats")
    public void setFormats(List<Format> formats) {
        this.formats = formats;
    }

    @JsonProperty("thumb")
    public String getThumb() {
        return thumb;
    }

    @JsonProperty("thumb")
    public void setThumb(String thumb) {
        this.thumb = thumb;
    }

    @JsonProperty("title")
    public String getTitle() {
        return title;
    }

    @JsonProperty("title")
    public void setTitle(String title) {
        this.title = title;
    }

    @JsonProperty("artists")
    public List<Artist> getArtists() {
        return artists;
    }

    @JsonProperty("artists")
    public void setArtists(List<Artist> artists) {
        this.artists = artists;
    }

    @JsonProperty("resource_url")
    public String getResourceUrl() {
        return resourceUrl;
    }

    @JsonProperty("resource_url")
    public void setResourceUrl(String resourceUrl) {
        this.resourceUrl = resourceUrl;
    }

    @JsonProperty("year")
    public Long getYear() {
        return year;
    }

    @JsonProperty("year")
    public void setYear(Long year) {
        this.year = year;
    }

    @JsonProperty("id")
    public Long getId() {
        return id;
    }

    @JsonProperty("id")
    public void setId(Long id) {
        this.id = id;
    }

}
