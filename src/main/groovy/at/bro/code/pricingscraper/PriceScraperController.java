package at.bro.code.pricingscraper;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import at.bro.code.pricingscraper.dto.PriceInformationSummary;
import at.bro.code.pricingscraper.pipe.WorkingPipe;

@RestController
public class PriceScraperController {

    private static final Logger LOG = LoggerFactory.getLogger(PriceScraperController.class);

    @Autowired
    private WorkingPipe pipe;

    @RequestMapping("/scrape")
    public PriceInformationSummary scrape(@RequestParam("url") String url) {
        final PriceInformationSummary workDone = pipe.doWork(url);
        LOG.info("scraped {}, results stored in {}", url, workDone.getResultFile());
        return workDone;
    }
}
