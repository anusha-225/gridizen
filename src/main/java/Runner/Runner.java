package Runner;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(features="/Users/macbook/eclipse-workspace/gridigen-1/src/main/java/Feature/JoinPage_VerifyMandatoryFiels.feature"
,glue= {"StepDefination"}
,dryRun=false
,format= {"pretty","html:Test-output1"}
,monochrome=true
//format= {"pretty"
)
public class Runner {
	
}
