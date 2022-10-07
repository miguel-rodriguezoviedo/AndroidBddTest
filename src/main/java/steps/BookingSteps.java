package steps;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import driver.AndroidDriverManager;
import gherkin.lexer.Th;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import objects.BookingObject;
import org.testng.Assert;

public class BookingSteps {

    private AndroidDriver<AndroidElement> driver;
    private BookingObject booking;

    @Before
    public void setUp() {
        driver = AndroidDriverManager.getDriver();
    }

    @Given("^realizo la seleccion de \"([^\"]*)\"$")
    public void usuarioEnBookingApp(String destination) throws Exception{
        booking = new BookingObject(driver);
        booking.touchCloseSignIn();
        booking.touchDestination();
        booking.writeDestination(destination);
        Thread.sleep(2000);
        booking.touchFirstResultDestination();
        Thread.sleep(2000);
        booking.makeSwipe(630,1350,700,500);
        Thread.sleep(2000);
    }

    @And("^realizo la seleccion de fechas$")
    public void seleccionFechas() throws Exception{
        booking.makeSwipe(630,1350,700,500);
        booking.makeSwipe(630,1350,700,200);
        Thread.sleep(2000);
        booking.touchFirstDate();
        booking.touchLastDate();
        booking.touchSelectDate();
        Thread.sleep(2000);
    }

    @When("^selecciono cantidad de habitacion$")
    public void seleccionCantidadHabitacion(){
        booking.touchBtnQuantityRoomPeople();
    }

    @And("^selecciono cantidad de personas$")
    public void seleccionCantidadPersonas() throws Exception{
        booking.touchBtnPlusChildren();
        booking.makeSwipe(540,1055,540,743);
        booking.makeSwipe(540,1055,540,743);
        booking.makeSwipe(540,1055,540,743);
        booking.makeSwipe(540,1055,540,743);
        booking.touchBtnOkChildren();
        booking.touchBtnApplyChildren();
        booking.touchSearchBooking();
        Thread.sleep(5000);
    }

    @Then("^selecciono habitacion a mi preferencia$")
    public void seleccionHabitacionPreferencial() throws Exception{
        booking.makeSwipe(574,1464,586,810);
        booking.touchSecondBookingResult();
        Thread.sleep(3000);
    }

    @And("^verifico el precio total a pagar \"([^\"]*)\"$")
    public void verificoPrecioTotalPagar(String priceExpected){
        booking.makeSwipe(567,1437,570,805);
        Assert.assertEquals(booking.getPriceBooking(),priceExpected,"Test Failed");
    }

    @After
    public void tearDown() {
        driver = null;
    }
}
