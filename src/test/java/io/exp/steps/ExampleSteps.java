package io.exp.steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.exp.api.ApiClient;
import io.exp.objects.LoginResult;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Implémentation des étapes Gherkin du fichier example.feature.
 * C'est ici que vous insérez le code de test réel (ex: appels RestAssured).
 */
public class ExampleSteps {

    // Variables de contexte pour l'exemple
    private String username;
    private String password;
    private boolean loggedIn = false;
    private String welcomeMessage = "";


    private final ApiClient apiClient;

    public ExampleSteps(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    @Given("the user is on the login page")
    public void userIsOnLoginPage() {
        System.out.println("SETUP: Ouverture de la page de connexion.");
    }

    @When("the user enters {string} and {string}")
    public void userEntersCredentials(String username, String password) {
        this.username = username;
        this.password = password;
        System.out.printf("ACTION: Tentative de connexion avec Utilisateur: %s, Mot de passe: %s%n", username, password);
    }

    @When("the user clicks the {string} button")
    public void userClicksButton(String buttonName) {
        // Utilisation d'ApiClient pour gérer la logique de connexion
        if ("Login".equals(buttonName)) {
            LoginResult loginResult = apiClient.login(username, password);
            this.loggedIn = loginResult.success;

            this.welcomeMessage = loginResult.message;

            System.out.println("ACTION: Clic sur le bouton de connexion.");
        }
    }

    @Then("the user is redirected to the home page")
    public void userIsRedirectedToHomePage() {
        assertTrue("L'utilisateur doit être connecté pour être redirigé.", loggedIn);
        System.out.println("VÉRIFICATION: Redirection vers la page d'accueil réussie.");
    }

    @Then("the welcome message {string} is displayed")
    public void welcomeMessageIsDisplayed(String expectedMessage) {
        assertEquals("Le message de bienvenue affiché n'est pas correct.", expectedMessage, welcomeMessage);
        System.out.println("VÉRIFICATION: Message affiché : " + welcomeMessage);
    }
}