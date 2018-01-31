
package swax.webservice.apiDiscogs.model;

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
public class Pagination {

    @JsonProperty("per_page")
    private Integer perPage;
    @JsonProperty("items")
    private Long items;
    @JsonProperty("page")
    private Integer page;
    @JsonProperty("urls")
    private Urls urls;
    @JsonProperty("pages")
    private Integer pages;

    @JsonProperty("per_page")
    public Integer getPerPage() {
        return perPage;
    }

    @JsonProperty("per_page")
    public void setPerPage(Integer perPage) {
        this.perPage = perPage;
    }

    @JsonProperty("items")
    public Long getItems() {
        return items;
    }

    @JsonProperty("items")
    public void setItems(Long items) {
        this.items = items;
    }

    @JsonProperty("page")
    public Integer getPage() {
        return page;
    }

    @JsonProperty("page")
    public void setPage(Integer page) {
        this.page = page;
    }

    @JsonProperty("urls")
    public Urls getUrls() {
        return urls;
    }

    @JsonProperty("urls")
    public void setUrls(Urls urls) {
        this.urls = urls;
    }

    @JsonProperty("pages")
    public Integer getPages() {
        return pages;
    }

    @JsonProperty("pages")
    public void setPages(Integer pages) {
        this.pages = pages;
    }

}
