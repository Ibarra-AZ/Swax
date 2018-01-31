
package swax.webservice.apiDiscogs.model;

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
	public int getRating() {
		return rating;
	}
	public void setRating(int rating) {
		this.rating = rating;
	}
	public String getResourceUrl() {
		return resourceUrl;
	}
	public void setResourceUrl(String resourceUrl) {
		this.resourceUrl = resourceUrl;
	}
	public BasicInformation getBasicInformation() {
		return basicInformation;
	}
	public void setBasicInformation(BasicInformation basicInformation) {
		this.basicInformation = basicInformation;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getDateAdded() {
		return dateAdded;
	}
	public void setDateAdded(String dateAdded) {
		this.dateAdded = dateAdded;
	}

    
}
