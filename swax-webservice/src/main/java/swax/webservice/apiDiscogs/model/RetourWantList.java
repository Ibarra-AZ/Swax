
package swax.webservice.apiDiscogs.model;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "wants",
    "pagination"
})
@Getter
@Setter
public class RetourWantList {

    @JsonProperty("wants")
    public List<Want> wants = null;
    @JsonProperty("pagination")
    public Pagination pagination;
    
}
