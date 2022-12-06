package org.example.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

import static java.time.Duration.ofSeconds;
import static org.openqa.selenium.By.xpath;
import static org.openqa.selenium.support.PageFactory.initElements;
import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOf;

public class PuffyLuxPage {
    WebDriver driver;

    public PuffyLuxPage(WebDriver driver) {
        this.driver= driver;
        initElements(driver, this);
    }

    @FindBy(className = "product-head__title")
    private WebElement title;

    public WebElement getLogo() {
        return logo;
    }

    @FindBy(xpath = "//a[@class='header__logo-wrapper']")
    private WebElement logo;
    @FindBy(className = "jsProductHeadFaq")
    private WebElement faqBtn;
    @FindBy(className = "product-head__reviews")
    private WebElement reviewsBtn;
    @FindBy(className = "jdgm-subtab")
    private WebElement reviewField;
    @FindBy(className = "main-headline__title")
    private WebElement faqsField;
    @FindBy(className = "popup__close")
    private WebElement popup;

    @FindBy(className = "js-variantOldPrice")
    private WebElement oldPrice;
    @FindBy(className = "jdgm-write-rev-link")
    private WebElement writeRev;

    @FindBy(className = "jdgm-ask-question-btn")
    private WebElement askQuestion;

    @FindBy(className = "jdgm-rev__header")
    private WebElement productReviewArea;

    @FindBy(className = "jdgm-form")
    private WebElement reviewForm;
    @FindBy(className = "jdgm-question-form")
    private WebElement questionForm;

    public WebElement getQuestionForm() {
        return questionForm;
    }

    public WebElement getPopup() {
        return popup;
    }

    public void closePopup() {
        if(popup.isDisplayed()) {
            popup.click();
        }
    }

    public void clickFaqBtn() {
        faqBtn.click();
    }

    public void clickReviewBtn() {
        reviewsBtn.click();
    }

    public WebElement getReviewField() {
        return reviewField;
    }

    public WebElement getFaqsField() {
        return faqsField;
    }

    public void clickSize(String size) {
        driver.findElement(xpath("//input[@data-handle='" + size.toLowerCase() + "']/..")).click();
    }

    public String getPrice() {
        return driver.findElement(By.className("js-variantOldPrice")).getText();
    }

    public String getTitle() {
        return title.getText();
    }
    public void openPage() {
        driver.get("https://puffy.com/products/puffy-lux-mattress");
    }

    public void writeReview() {
        scrollToElement(writeRev);
        closePopup();
        writeRev.click();
    }

    public void askQuestion() {
        scrollToElement(productReviewArea);
        closePopup();
        askQuestion.click();
    }

    private void scrollToElement(WebElement element){
        Actions actions = new Actions(driver);
        actions.moveToElement(driver.findElement(By.className("jdgm-rev__header")));
        actions.perform();
    }
    public WebElement getReviewForm(){
        return reviewForm;
    }
}
