package utils.reporting;

import lombok.Getter;

@Getter
public class ReportDetails {

    private final String reportFilePath, documentTitle, reportName;

    public ReportDetails(String reportFilePath, String documentTitle, String reportName){
        this.reportFilePath = reportFilePath;
        this.documentTitle = documentTitle;
        this.reportName = reportName;
    }


}
