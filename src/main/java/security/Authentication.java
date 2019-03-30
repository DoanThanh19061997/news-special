package security;

public interface Authentication {
    static  Authentication newModel(String userName,String userPassword){
        return new AuthenticationImpl(userName,userPassword);
    }
    String urlRedirect();
}
