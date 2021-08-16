package utils;

public enum APIResources {

	authenticateAPI("/api/v3/authenticate");

	private String resource;

	APIResources(String resource) {
		this.resource = resource;
	}
	
	public String getResource() {
		return resource;
	}
}
