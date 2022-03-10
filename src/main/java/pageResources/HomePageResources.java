package pageResources;

import java.util.ArrayList;
import java.util.List;

public enum HomePageResources {

    SearchByCityDrop("//span[@id='select2-hotels_city-container']"),
    CheckIn("//input[@id='checkin']"),
    CheckOut("//input[@id='checkout']"),
    Travellers("//form[@id='hotels-search']//a[@role='button']"),
    HomeButton("//a[text()='Home']"),
    SearchButton("//form[@id='hotels-search']//button[@id='submit']"),
    LanguagesButton("//button[@id='languages']"),
    CurrencyButton("//button[@id='currency']"),
    SupplierButton("//button[@id='supplier']"),
    AgentsButton("//button[@id='agents']");

    private final String resource;

    HomePageResources(String resource) {
        this.resource = resource;
    }

    public String getResource() {
        return resource;
    }
    public static List<String> getAllLocators() {
        List<String> listOfElements = new ArrayList<>();
        for (HomePageResources homePageResources : HomePageResources.values()) {
            listOfElements.add((homePageResources.getResource()));
        }
     return listOfElements;
    }

}