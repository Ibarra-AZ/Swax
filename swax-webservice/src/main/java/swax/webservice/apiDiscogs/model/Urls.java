
package swax.webservice.apiDiscogs.model;

import lombok.Getter;
import lombok.Setter;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Getter
@Setter
public class Urls {

    @JsonProperty("last")
    public String last;
    @JsonProperty("first")
    public String first;
    @JsonProperty("next")
    public String next;
    @JsonProperty("prev")
    public String prev;

}
