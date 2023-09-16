package pages;

import org.openqa.selenium.By;

public class ModalPage extends BaseSeleniumPage {

    By titleResult = By.id("example-modal-sizes-title-lg");
    By nameResult = By.cssSelector("tr:nth-child(1) > td:nth-child(2)");
    By emailResult = By.cssSelector("tr:nth-child(2) > td:nth-child(2)");
    By genderResult = By.cssSelector("tr:nth-child(3) > td:nth-child(2)");
    By mobileResult = By.cssSelector("tr:nth-child(4) > td:nth-child(2)");
    By dateResult = By.cssSelector("tr:nth-child(5) > td:nth-child(2)");
    By subjectsResult = By.cssSelector( "tr:nth-child(6) > td:nth-child(2)");
    By hobbiesResult = By.cssSelector("tr:nth-child(7) > td:nth-child(2)");
    By pictureResult = By.cssSelector("tr:nth-child(8) > td:nth-child(2)");
    By addressResult = By.cssSelector("tr:nth-child(9) > td:nth-child(2)");
    By stateAndCity = By.cssSelector("tr:nth-child(10) > td:nth-child(2)");

    public String getName(){
        return driver.findElement(nameResult).getText();
    }

    public String getEmail(){
        return driver.findElement(emailResult).getText();
    }
    
    public String getGender(){
        return driver.findElement(genderResult).getText();
    }
    
    public String getMobile(){
        return driver.findElement(mobileResult).getText();
    }
    
    public String getDate(){
        return driver.findElement(dateResult).getText();
    }
    
    public String getSubjects(){
        return driver.findElement(subjectsResult).getText();
    }
    
    public String getHobbies(){
        return driver.findElement(hobbiesResult).getText();
    }
    
    public String getPicture(){
        return driver.findElement(pictureResult).getText();
    }
    
    public String getAddress(){
        return driver.findElement(addressResult).getText();
    }
    
    public String getStateAndCity(){
        return driver.findElement(stateAndCity).getText();
    }

    public String getTitle(){
        return driver.findElement(titleResult).getText();
    }

    @Override
    public boolean isLoaded(int seconds) {
        return !getTitle().isEmpty();
    }
}
