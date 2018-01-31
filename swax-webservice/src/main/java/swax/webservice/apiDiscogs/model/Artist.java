
package swax.webservice.apiDiscogs.model;

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
public class Artist {

    @JsonProperty("join")
    private String join;
    @JsonProperty("name")
    private String name;
    @JsonProperty("anv")
    private String anv;
    @JsonProperty("tracks")
    private String tracks;
    @JsonProperty("role")
    private String role;
    @JsonProperty("resource_url")
    private String resourceUrl;
    @JsonProperty("id")
    private Long id;

    @JsonProperty("join")
    public String getJoin() {
        return join;
    }

    @JsonProperty("join")
    public void setJoin(String join) {
        this.join = join;
    }

    @JsonProperty("name")
    public String getName() {
        return name;
    }

    @JsonProperty("name")
    public void setName(String name) {
        this.name = name;
    }

    @JsonProperty("anv")
    public String getAnv() {
        return anv;
    }

    @JsonProperty("anv")
    public void setAnv(String anv) {
        this.anv = anv;
    }

    @JsonProperty("tracks")
    public String getTracks() {
        return tracks;
    }

    @JsonProperty("tracks")
    public void setTracks(String tracks) {
        this.tracks = tracks;
    }

    @JsonProperty("role")
    public String getRole() {
        return role;
    }

    @JsonProperty("role")
    public void setRole(String role) {
        this.role = role;
    }

    @JsonProperty("resource_url")
    public String getResourceUrl() {
        return resourceUrl;
    }

    @JsonProperty("resource_url")
    public void setResourceUrl(String resourceUrl) {
        this.resourceUrl = resourceUrl;
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
