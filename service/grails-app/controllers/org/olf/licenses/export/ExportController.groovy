package org.olf.licenses.export

import org.olf.licenses.License

import com.k_int.okapi.OkapiTenantAwareController
import com.opencsv.CSVWriterBuilder
import com.opencsv.ICSVWriter

import grails.gorm.multitenancy.CurrentTenant
import groovy.util.logging.Slf4j



/**
 * The ExportController provides endpoints for exporting content in specific formats
 * harvested by the erm module.
 */
@Slf4j
@CurrentTenant
class ExportController extends OkapiTenantAwareController<License>  {

  ExportService exportService

  ExportController()  {
    super(License, true)
  }

  def index(ExportControlObject exportObj) {
    log.debug("ExportController::index")

    // Set the file disposition.
    OutputStreamWriter osWriter

    try {
      response.setHeader "Content-disposition", "attachment; filename=export.csv"
      osWriter = new OutputStreamWriter(new BufferedOutputStream(response.outputStream))
      ICSVWriter csvWriter = new CSVWriterBuilder(osWriter)
        .withSeparator(ICSVWriter.DEFAULT_SEPARATOR)          // ASCII 44: ,
        .withQuoteChar(ICSVWriter.DEFAULT_QUOTE_CHARACTER)    // ASCII 34: "
        .withEscapeChar(ICSVWriter.DEFAULT_ESCAPE_CHARACTER)  // ASCII 34: "
        .withLineEnd(ICSVWriter.DEFAULT_LINE_END)             // "\n"
      .build()

      exportService.exportLicensesAsCsv(csvWriter, exportObj)
    } finally {
      // Always close the stream.
      osWriter?.close()
    }
  }
}
