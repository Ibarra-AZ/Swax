
package swax.webservice.apiDiscogs.model;

import lombok.Getter;
import lombok.Setter;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "per_page",
    "items",
    "page",
    "urls",
    "pages"
})
@Getter
@Setter
public class Pagination {

    @JsonProperty("per_page")
    public Integer perPage;
    @JsonProperty("items")
    public Integer items;
    @JsonProperty("page")
    public Integer page;
    @JsonProperty("urls")
    public Urls urls;
    @JsonProperty("pages")
    public Integer pages;

}
