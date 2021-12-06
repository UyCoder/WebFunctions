package pages;

import org.openqa.selenium.By;
import java.util.Hashtable;

public class SearchResultsPage extends BasePage {

    public Hashtable<String, By> searchResultsElements;

    public SearchResultsPage() {
        this.searchResultsElements = new Hashtable<>();
        searchResultsElements.put("all sellers button", By.xpath("//a[@class='optionsLength unVisible']"));
        searchResultsElements.put("add to cart button", By.xpath("//button [@class='add-to-basket button']"));
        searchResultsElements.put("continue to cart button", By.xpath("//*[(text()='Sepete Ekle')]//parent::button//parent::div"));
        searchResultsElements.put("my cart button", By.xpath("//*[contains(text(),'Sepetim') and (//span [@class='sf-OldMyAccount-2cv9i sf-OldMyAccount-mWelr'])]//parent::a"));
        this.pageElements = searchResultsElements;
    }
}