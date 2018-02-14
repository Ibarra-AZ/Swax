
package swax.webservice.apiDiscogs.model;

import lombok.Getter;
import lombok.Setter;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "rating",
    "resource_url",
    "basic_information",
    "id",
    "date_added"
})
@Getter
@Setter
public class Want {

    @JsonProperty("rating")
    public int rating;
    @JsonProperty("resource_url")
    public String resourceUrl;
    @JsonProperty("basic_information")
    public BasicInformation basicInformation;
    @JsonProperty("id")
    public int id;
    @JsonProperty("date_added")
    public String dateAdded;
	
}
