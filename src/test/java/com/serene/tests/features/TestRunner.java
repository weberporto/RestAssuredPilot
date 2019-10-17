package com.serene.tests.features;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;

/**
 * @author PortoAmW
 *
 */

@RunWith(CucumberWithSerenity.class)

@CucumberOptions(features= "src/test/resources/features/Siric/Siric.feature", tags = "@Siric")

public class TestRunner {
	
}
