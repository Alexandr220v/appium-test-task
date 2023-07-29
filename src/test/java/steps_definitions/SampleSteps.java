package steps_definitions;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.runner.CucumberRunnerTest;
import lombok.SneakyThrows;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import pages.NativeViewDemoPage;
import pages.SamplesPage;

import java.io.File;
import java.util.List;
import java.util.stream.Collectors;

import static java.lang.Thread.sleep;
import static org.assertj.core.api.Assertions.assertThat;


public class SampleSteps {

    SamplesPage samplesPage;

    NativeViewDemoPage nativeViewDemoPage;

    public SampleSteps() {
        samplesPage = new SamplesPage();
        nativeViewDemoPage = new NativeViewDemoPage();
    }

    @And("^user select \"([^\"]*)\" sample$")
    public void userSelectSample(String sampleName) throws Throwable {
        samplesPage.openSamplesListItem(sampleName);
    }

    @And("^user should see list of native view demos$")
    public void userShouldSeeListOfNativeViewDemos(List<String> expectedSamplesListItems) {
        List<String> actualSamplesListItems = nativeViewDemoPage.getNativeViewDemoList().stream().map(String::trim).collect(Collectors.toList());;
        assertThat(actualSamplesListItems).usingRecursiveComparison().ignoringCollectionOrder().isEqualTo(expectedSamplesListItems);

    }
}
