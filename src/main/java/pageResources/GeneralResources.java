package pageResources;

public enum GeneralResources {

    browserName("chrome"),
    loginUrl("https://www.phptravels.net/login"),
    homePageUrl("https://www.phptravels.net/"),
    loginPageUrlFailedLogin("https://www.phptravels.net/login/failed");

    private final String resource;

    GeneralResources(String resource) {
        this.resource = resource;
    }

    public String getResource() {
        return resource;
    }
}

