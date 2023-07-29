package steps_definitions;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.runner.CucumberRunnerTest;
import dto.User;
import lombok.SneakyThrows;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import pages.DialogPopUp;
import pages.LoginPage;
import pages.SamplesPage;

import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;


public class LoginSteps  {
    LoginPage loginPage;
    SamplesPage samplesPage;

    DialogPopUp dialogPopUp;

    public LoginSteps() {
        loginPage = new LoginPage();
        samplesPage = new SamplesPage();
        dialogPopUp = new DialogPopUp();
    }

    @Given("^user login to app with \"([^\"]*)\" and \"([^\"]*)\"$")
    public void userLogInToApp(String username, String password) {

        User user = User.builder()
                .username(username)
                .password(password)
                .build();
        loginPage.login(user);
    }

    @Then("^user should see Sample list page with title \"([^\"]*)\"$")
    public void userShouldSeeSampleListPage(String title) {
        String label = samplesPage.getSamplesListLabel();
        assertThat(label).isEqualTo(title);
    }

    @Then("^user should see \"([^\"]*)\"$")
    public void userShouldSeeErrorMessage(String expectedErrorMessage) throws Throwable {
        String actualErrorMessage = dialogPopUp.getErrorMessage();
        assertThat(actualErrorMessage).isEqualTo(expectedErrorMessage);
    }

    @And("^user should see Sample list of samples$")
    public void userShouldSeeSampleListOfSamples(List<String> expectedItems) {
        int count = expectedItems.size();
        List<String> listItems = samplesPage.getSamplesListItems();
        if (listItems.size() < count) {
            loginPage.scrollDown();
            listItems.addAll(samplesPage.getSamplesListItems());
        }
        List<String> actualItems = listItems.stream().distinct().collect(Collectors.toList());
        assertThat(actualItems).usingRecursiveComparison().ignoringCollectionOrder().isEqualTo(expectedItems);
    }

}
