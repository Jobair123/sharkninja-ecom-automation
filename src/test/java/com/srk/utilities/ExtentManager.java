package com.srk.utilities;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentManager {

    private static ExtentReports extent;

    public static ExtentReports getInstance() {
        if (extent == null) {
            createInstance();
        }
        return extent;
    }

    private static ExtentReports createInstance() {
        String reportPath = System.getProperty("user.dir") + "/test-output/ExtentReport.html";

        ExtentSparkReporter reporter = new ExtentSparkReporter(reportPath);
        reporter.config().setDocumentTitle("Automation Report");
        reporter.config().setReportName("Functional Test Results");
        reporter.config().setTheme(Theme.STANDARD);

        extent = new ExtentReports();
        extent.attachReporter(reporter);
        extent.setSystemInfo("Tester", "Jobair Hasnat");
        extent.setSystemInfo("Environment", "QA");
        extent.setSystemInfo("Browser", "Chrome");

        return extent;
    }
}

