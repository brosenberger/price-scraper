package at.bro.code.pricingscraper.scraper

import org.jsoup.nodes.Document
import org.jsoup.nodes.Element
import org.springframework.beans.factory.annotation.Autowired

import at.bro.code.pricingscraper.dto.PriceInformationSummary
import at.bro.code.pricingscraper.retriever.DocumentRetriever

public abstract class Scraper {
    @Autowired
    private DocumentRetriever retriever;

    abstract void scrape(PriceInformationSummary summary, Document doc)

    protected String findLink(String uri, String name) {
        Document doc =retriever.retrieve(uri)
        Element link = doc.select("a:contains($name)").first()
        if (link == null) {
            throw new NoSuchElementException("No link named '$name' found at $uri")
        }
        return link.attr('abs:href')
    }

    protected String findEmbeddedPDF(String uri) {
        Document doc = retriever.retrieve(uri)
        Element iframe = doc.select("iframe").first()
        if (iframe == null) {
            throw new NoSuchElementException("No iframe found at $uri")
        }
        return iframe.attr('abs:src')
    }
}