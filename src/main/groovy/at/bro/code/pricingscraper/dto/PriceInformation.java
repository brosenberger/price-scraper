package at.bro.code.pricingscraper.dto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.UUID;

public class PriceInformation implements Serializable {
    private final String id;
    private String title;
    private String url;
    private BigDecimal price;

    public PriceInformation() {
        this.id = UUID.randomUUID().toString();
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getId() {
        return id;
    }

}
