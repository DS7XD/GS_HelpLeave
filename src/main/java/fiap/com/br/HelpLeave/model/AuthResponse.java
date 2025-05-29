package fiap.com.br.HelpLeave.model;

public class AuthResponse {

    @SuppressWarnings("FieldMayBeFinal")
    private String token;

    public AuthResponse(String token) {
        this.token = token;
    }

    public String getToken() {
        return token;
    }
}
