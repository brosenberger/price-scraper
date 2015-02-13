package at.bro.code.pricingscraper.scraper

import groovy.transform.CompileStatic

import org.jsoup.nodes.Document
import org.jsoup.nodes.Element
import org.jsoup.nodes.TextNode
import org.jsoup.select.Elements
import org.springframework.stereotype.Service

import at.bro.code.pricingscraper.dto.PriceInformation
import at.bro.code.pricingscraper.dto.PriceInformationSummary
import at.bro.code.pricingscraper.exceptions.ScraperException

/**
 * User: brosenberger
 * Date: 27.09.13
 * Time: 07:58
 */
@CompileStatic
@Service
class WillhabenScraper extends Scraper {

    @Override
    void scrape(PriceInformationSummary summary, Document doc) {
        Elements elements = doc.select("li.media");
        if (elements==null || elements.isEmpty())
            return ;

        List<PriceInformation> pricings = new ArrayList<>();
        for (Element e:elements) {
            summary.addPriceInformation(extractPriceInformation(e));
        }
    }

    private PriceInformation extractPriceInformation(Element e) {
        PriceInformation pi = new PriceInformation();
        Element headerElement = e.select("a.info-1").first();
        pi.setTitle(((TextNode)headerElement.childNode(0)).getWholeText().trim());
        pi.setUrl(headerElement.attr("abs:href"));
        // (![A-Za-z])*\s*\d*(\.|\d*)*,(-|\d)*\s*(![A-Za-z])*
        Element priceElement = e.select("*.info-2:matchesOwn((![A-Za-z])*\\s*\\d*(\\.|\\d*)*,(-|\\d*)*\\s*(![A-Za-z])*)").first();
        pi.setPrice(convertPrice(((TextNode)priceElement?.childNode(0))?.getWholeText()?.trim()));
        return pi;
    }

    private BigDecimal convertPrice(String n) {
        if (n==null) return null;

        String cleared = n;
        if (cleared?.contains(",-")) {
            cleared = n.replace(",-", "");
        }
        try{
            return new BigDecimal(cleared.replace(".", "").replace(",", ".").trim());
        } catch(NumberFormatException e) {
            throw new ScraperException("tried to read "+n, e);
        }
    }
}