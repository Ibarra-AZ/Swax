
package swax.webservice.apiDiscogs.model;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "descriptions",
    "name",
    "qty",
    "text"
})
public class Format {

    @JsonProperty("descriptions")
    private List<String> descriptions = null;
    @JsonProperty("name")
    private String name;
    @JsonProperty("qty")
    private String qty;
    @JsonProperty("text")
    private String text;

    @JsonProperty("descriptions")
    public List<String> getDescriptions() {
        return descriptions;
    }

    @JsonProperty("descriptions")
    public void setDescriptions(List<String> descriptions) {
        this.descriptions = descriptions;
    }

    @JsonProperty("name")
    public String getName() {
        return name;
    }

    @JsonProperty("name")
    public void setName(String name) {
        this.name = name;
    }

    @JsonProperty("qty")
    public String getQty() {
        return qty;
    }

    @JsonProperty("qty")
    public void setQty(String qty) {
        this.qty = qty;
    }

    @JsonProperty("text")
    public String getText() {
        return text;
    }

    @JsonProperty("text")
    public void setText(String text) {
        this.text = text;
    }

}
