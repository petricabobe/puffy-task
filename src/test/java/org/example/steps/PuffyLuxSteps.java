package org.example.steps;

import io.cucumber.java.After;
import io.cucumber.java.AfterAll;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.pages.PuffyLuxPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;
import java.util.Map;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class PuffyLuxSteps {
    private static final WebDriver driver = new ChromeDriver();
    PuffyLuxPage puffyLuxPage = new PuffyLuxPage(driver);

    @When("user opens the landing page")
    public void openPuffyLuxPage() {
        driver.manage().window().maximize();
        puffyLuxPage.openPage();
    }

    @Then("the company logo can be seen")
    public void getLogo() {
        assertThat(puffyLuxPage.getLogo().isDisplayed());
    }

    @And("product's page name is correct")
    public void getProductTitle() {
        assertThat(puffyLuxPage.getTitle().equals("Puffy Lux Mattress"));
    }

    @Then("the size matches the price")
    public void getDetails(List<Map<String, String>> dataTable) {
        if (puffyLuxPage.getPopup().isDisplayed()) {
            puffyLuxPage.closePopup();
        }
        dataTable.forEach(x -> {
            puffyLuxPage.clickSize(x.get("size"));
            String priceS = puffyLuxPage.getPrice();
            assertThat(x.get("price").equals(priceS));
        });
    }

    @When("clicking on reviews")
    public void clickReviews() {
        puffyLuxPage.clickReviewBtn();
    }

    @Then("user is redirected to all reviews")
    public void getAllReviews() {
        assertThat(puffyLuxPage.getReviewField().isDisplayed());
    }

    @When("clicking on FAQs")
    public void clickFaqs() {
        puffyLuxPage.clickFaqBtn();
    }

    @Then("user is redirected to all FAQs")
    public void getAllFaqs() {
        assertThat(puffyLuxPage.getFaqsField().isDisplayed());
    }

    @When("we click on write review")
    public void clickWriteReview() {
        puffyLuxPage.writeReview();
    }

    @Then("review form is displayed")
    public void checkWriteReviewForm() {
        assertThat(puffyLuxPage.getReviewForm().isDisplayed());
    }

    @When("we click on ask question")
    public void clickAskQuestion() {
        puffyLuxPage.askQuestion();
    }

    @Then("question form is displayed")
    public void checkAskQuestionForm() {
        assertThat(puffyLuxPage.getQuestionForm().isDisplayed());
    }

    @AfterAll
    public static void close() {
        driver.close();
    }
}
