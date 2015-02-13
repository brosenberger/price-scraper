package at.bro.code.pricingscraper.writer;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Locale;

import org.apache.commons.lang.time.FastDateFormat;
import org.springframework.stereotype.Service;

import at.bro.code.pricingscraper.dto.PriceInformation;
import at.bro.code.pricingscraper.dto.PriceInformationSummary;
import at.bro.code.pricingscraper.exceptions.DocumentWriterException;

@Service(value = "writer.csv")
public class CSVWriter implements ResultWriter {

    @Override
    public void writeResults(PriceInformationSummary summary) {

        final FastDateFormat fdf = FastDateFormat.getInstance("yyyy_MM_dd_HH_mm_ss.SSS", Locale.GERMAN);
        FileWriter writer = null;
        final String fileName = summary.getResultFolder() + fdf.format(summary.getExecutionTime()) + ".csv";
        try {
            writer = new FileWriter(fileName);
            for (final PriceInformation pi : summary.getPriceInformations()) {
                writer.append(pi.getId() + ";" + pi.getPrice() + ";" + pi.getTitle() + ";" + pi.getUrl() + "\n");
            }
            writer.close();
        } catch (final IOException e) {
            throw new DocumentWriterException(e);
        } finally {
            try {
                if (writer != null) {
                    writer.close();
                }
            } catch (final IOException e) {
                throw new DocumentWriterException(e);
            }
        }
        summary.setResultFile(fileName);
    }
}
