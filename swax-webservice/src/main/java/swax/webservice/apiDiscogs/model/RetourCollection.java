
package swax.webservice.apiDiscogs.model;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "pagination",
    "releases"
})
public class RetourCollection {

    @JsonProperty("pagination")
    private Pagination pagination;
    @JsonProperty("releases")
    private List<Release> releases = null;

    @JsonProperty("pagination")
    public Pagination getPagination() {
        return pagination;
    }

    @JsonProperty("pagination")
    public void setPagination(Pagination pagination) {
        this.pagination = pagination;
    }

    @JsonProperty("releases")
    public List<Release> getReleases() {
        return releases;
    }

    @JsonProperty("releases")
    public void setReleases(List<Release> releases) {
        this.releases = releases;
    }

}
