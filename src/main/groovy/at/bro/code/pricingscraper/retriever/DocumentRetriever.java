package at.bro.code.pricingscraper.retriever;

import java.io.IOException;

import org.jsoup.nodes.Document;

public interface DocumentRetriever {
    Document retrieve(String uri) throws IOException;
}
