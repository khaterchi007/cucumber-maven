package io.exp;

import io.cucumber.spring.CucumberContextConfiguration;
import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

/**
 * Classe lanceur (Runner) pour les tests Cucumber.
 * Utilise JUnit pour exécuter les scénarios.
 */
@RunWith(Cucumber.class)
@CucumberContextConfiguration
@SpringBootTest(classes = Application.class) // Démarre le contexte Spring
@ContextConfiguration(classes = Application.class) // Chargeur de contexte
@CucumberOptions(
    features = "src/test/resources/features",
    glue = {"io.exp.steps"},
    plugin = {"pretty", "html:target/cucumber-reports/cucumber-html-report.html"},
    monochrome = true
)
public class TestRunner {
    // Cette classe est vide, elle ne sert que de point d'entrée pour l'exécution JUnit/Cucumber.
}