
package swax.webservice.apiDiscogs.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "collection_id",
    "release_id",
    "rating",
    "basic_information",
    "date_added"
})
public class Release {

    @JsonProperty("collection_id")
    private Long collectionId;
    @JsonProperty("release_id")
    private Long releaseId;
    @JsonProperty("rating")
    private Long rating;
    @JsonProperty("basic_information")
    private BasicInformation basicInformation;
    @JsonProperty("date_added")
    private String dateAdded;

    @JsonProperty("collection_id")
    public Long getCollectionId() {
        return collectionId;
    }

    @JsonProperty("collection_id")
    public void setCollectionId(Long collectionId) {
        this.collectionId = collectionId;
    }

    @JsonProperty("release_id")
    public Long getReleaseId() {
        return releaseId;
    }

    @JsonProperty("release_id")
    public void setReleaseId(Long releaseId) {
        this.releaseId = releaseId;
    }

    @JsonProperty("rating")
    public Long getRating() {
        return rating;
    }

    @JsonProperty("rating")
    public void setRating(Long rating) {
        this.rating = rating;
    }

    @JsonProperty("basic_information")
    public BasicInformation getBasicInformation() {
        return basicInformation;
    }

    @JsonProperty("basic_information")
    public void setBasicInformation(BasicInformation basicInformation) {
        this.basicInformation = basicInformation;
    }

    @JsonProperty("date_added")
    public String getDateAdded() {
        return dateAdded;
    }

    @JsonProperty("date_added")
    public void setDateAdded(String dateAdded) {
        this.dateAdded = dateAdded;
    }

}
