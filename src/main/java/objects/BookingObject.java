package objects;

import cucumber.api.java.en.And;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.util.List;

public class BookingObject {

    private AndroidDriver<AndroidElement> driver;

    private WebDriverWait wait;

    public BookingObject(AndroidDriver<AndroidElement> driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(this.driver), this);
        wait = new WebDriverWait(this.driver, 20);
    }

    // Locators

    @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"Enter your destination\"]")
    private AndroidElement txtDestination;

    @AndroidFindBy(id = "com.booking:id/facet_with_bui_free_search_booking_header_toolbar_content")
    private AndroidElement txtSearchDestination;

    @AndroidFindBy(xpath = "//android.widget.ImageButton[@content-desc=\"Navigate up\"]")
    private AndroidElement btnCloseSignIn;

    @AndroidFindBy(className = "android.view.ViewGroup")
    private List<AndroidElement> listDestination;

    @AndroidFindBy(xpath = "//android.view.View[@content-desc=\"14 February 2023\"]")
    private AndroidElement btnFirstDate;

    @AndroidFindBy(xpath = "//android.view.View[@content-desc=\"28 February 2023\"]")
    private AndroidElement btnLastDate;

    @AndroidFindBy(id = "com.booking:id/facet_date_picker_confirm")
    private AndroidElement btnSelectDates;

    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.FrameLayout[1]/android.widget.LinearLayout/androidx.recyclerview.widget.RecyclerView[2]/android.widget.FrameLayout[1]/android.widget.LinearLayout/android.view.ViewGroup/android.widget.LinearLayout/android.widget.LinearLayout[3]/android.widget.TextView")
    private AndroidElement btnQuantityRoomAndPeople;

    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.view.ViewGroup[3]/android.widget.LinearLayout/android.widget.Button[2]")
    private AndroidElement btnPlusChildren;

    @AndroidFindBy(id = "android:id/button1")
    private AndroidElement btnOkChildren;

    @AndroidFindBy(id = "com.booking:id/group_config_apply_button")
    private AndroidElement btnApplyChildren;

    @AndroidFindBy(id = "com.booking:id/facet_search_box_cta")
    private AndroidElement btnSearchBooking;


    @AndroidFindBy(id = "com.booking:id/bui_banner_title")
    private AndroidElement bannerElement;

    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.LinearLayout/android.view.ViewGroup/android.widget.FrameLayout/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[3]/android.view.ViewGroup")
    private AndroidElement secondCardResultBooking;

    @AndroidFindBy(id = "com.booking:id/price_view_price")
    private AndroidElement priceBooking;

    @AndroidFindBy(xpath = "com.booking:id/facet_price_view")
    private AndroidElement selectRooms;

    @AndroidFindBy(id = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[2]/android.widget.RelativeLayout/android.widget.LinearLayout[2]/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.Button")
    private AndroidElement btnReserve;

    public void touchDestination(){
        wait.until(ExpectedConditions.visibilityOf(txtDestination)).click();
    }

    public void touchFirstResultDestination(){
        ((AndroidElement) listDestination.get(1)).click();
    }

    public void writeDestination(String texto){
        wait.until(ExpectedConditions.visibilityOf(txtSearchDestination)).sendKeys(texto);
    }

    public void touchCloseSignIn(){
        wait.until(ExpectedConditions.visibilityOf(btnCloseSignIn)).click();
    }

    public void makeSwipe(int startX,int startY,int endX,int endY){
        TouchAction swipe = new TouchAction(driver);
        swipe.longPress(PointOption.point(startX,startY));
        swipe.moveTo(PointOption.point(endX,endY));
        swipe.release();
        swipe.perform();
    }

    public void touchFirstDate(){
        wait.until(ExpectedConditions.visibilityOf(btnFirstDate)).click();
    }

    public void touchLastDate(){
        wait.until(ExpectedConditions.visibilityOf(btnLastDate)).click();
    }

    public void touchSelectDate(){
        wait.until(ExpectedConditions.visibilityOf(btnSelectDates)).click();
    }

    public void touchBtnQuantityRoomPeople(){
        wait.until(ExpectedConditions.visibilityOf(btnQuantityRoomAndPeople)).click();
    }

    public void touchBtnPlusChildren(){
        wait.until(ExpectedConditions.visibilityOf(btnPlusChildren)).click();
    }

    public void touchBtnOkChildren(){
        wait.until(ExpectedConditions.visibilityOf(btnOkChildren)).click();
    }

    public void touchBtnApplyChildren(){
        wait.until(ExpectedConditions.visibilityOf(btnApplyChildren)).click();
    }

    public void touchSearchBooking(){
        wait.until(ExpectedConditions.visibilityOf(btnSearchBooking)).click();
    }

    public void touchSecondBookingResult(){
            wait.until(ExpectedConditions.visibilityOf(secondCardResultBooking)).click();
    }

    public String getPriceBooking(){
        return wait.until(ExpectedConditions.visibilityOf(priceBooking)).getText().replace("US$","");
    }

}

