package at.bro.code.pricingscraper.retriever;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.springframework.stereotype.Service;

@Service(value = "retriever.web")
public class WebDocumentRetriever implements DocumentRetriever {

    @Override
    public Document retrieve(String uri) throws IOException {
        return Jsoup.connect(uri).get();
    }

}
