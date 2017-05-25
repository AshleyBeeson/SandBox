package utils.reporting;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import lombok.Getter;

import java.util.HashMap;
import java.util.Map;

@Getter
public class ExtentReportManager {

    private ExtentHtmlReporter extentHtmlReporter;
    private ExtentReports report;
    private Map<String,ExtentTest> tests = new HashMap<String, ExtentTest>();

    public ExtentReportManager(ReportType reportType, ReportDetails reportDetails){
        report = new ExtentReports();
        attachReport(reportType, reportDetails);
    }

    private void attachReport(ReportType reportType, ReportDetails reportDetails) {
        switch (reportType){
            case HTML:
                report.attachReporter(getHtmlReporter(reportDetails));
        }
    }

    public void createTest(String testName){
        ExtentTest test = report.createTest(testName);
        tests.put(testName,test);
    }

    public ExtentTest getTest(String testName){
        return tests.get(testName);
    }

    private ExtentHtmlReporter getHtmlReporter(ReportDetails reportDetails) {
        String filePath = reportDetails.getReportFilePath() + ".html";
        extentHtmlReporter = new ExtentHtmlReporter(filePath);
        // make the charts visible on report open
        extentHtmlReporter.config().setChartVisibilityOnOpen(true);
        extentHtmlReporter.config().setDocumentTitle(reportDetails.getDocumentTitle());
        extentHtmlReporter.config().setReportName(reportDetails.getReportName());
        return extentHtmlReporter;
    }

    public void clearTests(){
        tests.clear();
        report.flush();
    }

    public enum ReportType{
        HTML,
    }

}
