
package fujiaut.runner;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(tags = "", features = {"src/test/resources/features/Purchase.feature"}, glue = {"fujiaut.definitions"},
        plugin = {})
public class TestRunner extends AbstractTestNGCucumberTests {

}