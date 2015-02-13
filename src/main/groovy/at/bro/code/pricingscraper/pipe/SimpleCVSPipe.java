package at.bro.code.pricingscraper.pipe;

import java.io.IOException;
import java.util.Date;

import org.jsoup.nodes.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import at.bro.code.pricingscraper.dto.PriceInformationSummary;
import at.bro.code.pricingscraper.exceptions.RetrievalException;
import at.bro.code.pricingscraper.retriever.DocumentRetriever;
import at.bro.code.pricingscraper.scraper.Scraper;
import at.bro.code.pricingscraper.writer.ResultWriter;

@Service(value = "pipe.cvs")
public class SimpleCVSPipe implements WorkingPipe {

    @Autowired
    Scraper scraper;

    @Autowired
    ResultWriter writer;

    @Autowired
    DocumentRetriever retriever;

    @Value("${writer.resultFolder}")
    private String resultFolder;

    @Override
    public PriceInformationSummary doWork(String requestUrl) {
        final PriceInformationSummary summary = new PriceInformationSummary(new Date(), requestUrl, resultFolder);

        Document doc;
        try {
            doc = retriever.retrieve(summary.getRequestUrl());
        } catch (final IOException e) {
            throw new RetrievalException(e);
        }
        scraper.scrape(summary, doc);
        writer.writeResults(summary);
        return summary;
    }

}
