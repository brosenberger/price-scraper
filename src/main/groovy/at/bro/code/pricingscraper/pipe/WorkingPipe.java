package at.bro.code.pricingscraper.pipe;

import at.bro.code.pricingscraper.dto.PriceInformationSummary;

public interface WorkingPipe {
    PriceInformationSummary doWork(String requestUrl);
}
