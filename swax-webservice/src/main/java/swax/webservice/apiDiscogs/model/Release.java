package swax.webservice.apiDiscogs.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import lombok.Getter;
import lombok.Setter;


@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "instance_id",
    "date_added",
    "basic_information",
    "id",
    "rating"
})
@Getter
@Setter
public class Release {

    @JsonProperty("instance_id")
    public Integer instanceId;
    @JsonProperty("date_added")
    public String dateAdded;
    @JsonProperty("basic_information")
    public BasicInformation basicInformation;
    @JsonProperty("id")
    public Integer id;
    @JsonProperty("rating")
    public Integer rating;

}
