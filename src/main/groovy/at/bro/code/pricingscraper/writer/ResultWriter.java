package at.bro.code.pricingscraper.writer;

import at.bro.code.pricingscraper.dto.PriceInformationSummary;

public interface ResultWriter {
    void writeResults(PriceInformationSummary pricings);
}
