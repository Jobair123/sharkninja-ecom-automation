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
        String reportPath = System.getProperty("user.dir") + "/reports/ExtentReport.html";

        ExtentSparkReporter reporter = new ExtentSparkReporter(reportPath);
        reporter.config().setDocumentTitle("Automation Report");
        reporter.config().setReportName("Functional Test Results");
        reporter.config().setTheme(Theme.STANDARD);
        
     // 🔹 Add environment/system info automatically
        String os = System.getProperty("os.name");
        String browser = new ReadConfig().getBrowser();
        String url = new ReadConfig().getUrl();

        extent = new ExtentReports();
        extent.attachReporter(reporter);
        extent.setSystemInfo("OS", os);
        extent.setSystemInfo("Browser", browser);
        extent.setSystemInfo("Base URL", url);
        extent.setSystemInfo("Tester Name", "Jobair Hasnat");

        return extent;
    }
}

