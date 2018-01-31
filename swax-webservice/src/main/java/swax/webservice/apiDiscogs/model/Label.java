
package swax.webservice.apiDiscogs.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "name",
    "entity_type",
    "catno",
    "resource_url",
    "id",
    "entity_type_name"
})
public class Label {

    @JsonProperty("name")
    private String name;
    @JsonProperty("entity_type")
    private String entityType;
    @JsonProperty("catno")
    private String catno;
    @JsonProperty("resource_url")
    private String resourceUrl;
    @JsonProperty("id")
    private Long id;
    @JsonProperty("entity_type_name")
    private String entityTypeName;

    @JsonProperty("name")
    public String getName() {
        return name;
    }

    @JsonProperty("name")
    public void setName(String name) {
        this.name = name;
    }

    @JsonProperty("entity_type")
    public String getEntityType() {
        return entityType;
    }

    @JsonProperty("entity_type")
    public void setEntityType(String entityType) {
        this.entityType = entityType;
    }

    @JsonProperty("catno")
    public String getCatno() {
        return catno;
    }

    @JsonProperty("catno")
    public void setCatno(String catno) {
        this.catno = catno;
    }

    @JsonProperty("resource_url")
    public String getResourceUrl() {
        return resourceUrl;
    }

    @JsonProperty("resource_url")
    public void setResourceUrl(String resourceUrl) {
        this.resourceUrl = resourceUrl;
    }

    @JsonProperty("id")
    public Long getId() {
        return id;
    }

    @JsonProperty("id")
    public void setId(Long id) {
        this.id = id;
    }

    @JsonProperty("entity_type_name")
    public String getEntityTypeName() {
        return entityTypeName;
    }

    @JsonProperty("entity_type_name")
    public void setEntityTypeName(String entityTypeName) {
        this.entityTypeName = entityTypeName;
    }

}
