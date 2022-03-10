package pageResources;

public enum LoginResources {

    loginButton("//span[text()='Login']/parent::button"),
    inputMail("//input[@placeholder='Email']"),
    inputPassword("//input[@placeholder='Password']"),
    homeButton("//a[normalize-space()='Home']");



    private final String resource;

    LoginResources(String resource) {
        this.resource = resource;
    }

    public String getResource() {
        return resource;
    }
}
