
package swax.webservice.apiDiscogs.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class Urls {

    @JsonProperty("last")
    private String last;
    @JsonProperty("first")
    private String first;
	@JsonProperty("next")
    private String next;
    @JsonProperty("prev")
    private String prev;

    @JsonProperty("prev")
    public String getPrev() {
		return prev;
	}
    @JsonProperty("prev")
	public void setPrev(String prev) {
		this.prev = prev;
	}

	@JsonProperty("last")
    public String getLast() {
        return last;
    }

    @JsonProperty("last")
    public void setLast(String last) {
        this.last = last;
    }
    
    @JsonProperty("first")
    public String getFirst() {
		return first;
	}
    
    @JsonProperty("first")
	public void setFirst(String first) {
		this.first = first;
	}

    @JsonProperty("next")
    public String getNext() {
        return next;
    }

    @JsonProperty("next")
    public void setNext(String next) {
        this.next = next;
    }

}
