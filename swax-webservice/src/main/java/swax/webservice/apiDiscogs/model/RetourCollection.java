
package swax.webservice.apiDiscogs.model;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "pagination",
    "releases"
})
@Getter
@Setter
public class RetourCollection {

    @JsonProperty("pagination")
    private Pagination pagination;
    @JsonProperty("releases")
    private List<Release> releases = null;

}
