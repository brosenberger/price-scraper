package at.bro.code.pricingscraper.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class PriceInformationSummary implements Serializable {
    private static final long serialVersionUID = 1L;

    private final Date executionTime;
    private final String requestUrl;
    private final String resultFolder;
    private String resultFile;
    private final List<PriceInformation> priceInformations = new ArrayList<>();

    public PriceInformationSummary(Date executionTime, String requestUrl, String resultFolder) {
        this.executionTime = executionTime;
        this.requestUrl = requestUrl;
        this.resultFolder = resultFolder;
    }

    public Date getExecutionTime() {
        return executionTime;
    }

    public String getRequestUrl() {
        return requestUrl;
    }

    public String getResultFolder() {
        return resultFolder;
    }

    public void addPriceInformation(PriceInformation pi) {
        this.priceInformations.add(pi);
    }

    public List<PriceInformation> getPriceInformations() {
        return priceInformations;
    }

    public String getResultFile() {
        return resultFile;
    }

    public void setResultFile(String resultFile) {
        this.resultFile = resultFile;
    }

}
