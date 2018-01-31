
package swax.webservice.apiDiscogs.model;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "wants",
    "pagination"
})
public class RetourWantList {

    @JsonProperty("wants")
    public List<Want> wants = null;
    @JsonProperty("pagination")
    public Pagination pagination;
    
	public List<Want> getWants() {
		return wants;
	}
	public void setWants(List<Want> wants) {
		this.wants = wants;
	}
	public Pagination getPagination() {
		return pagination;
	}
	public void setPagination(Pagination pagination) {
		this.pagination = pagination;
	}

}
