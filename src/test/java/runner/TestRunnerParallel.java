package runner;


import org.junit.platform.suite.api.Suite;
import org.junit.platform.suite.api.SelectClasspathResource;
import org.junit.platform.suite.api.ConfigurationParameter;

@Suite
@SelectClasspathResource("features") // <- igual a pasta que está dentro de resources
@ConfigurationParameter(key = "cucumber.glue", value = "steps") // <- ajuste pro seu pacote de steps
public class TestRunnerParallel {}

