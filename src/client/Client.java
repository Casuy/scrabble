package client;

public class Client {

    private static Client agent;
    public ServerService server = ServerService.getInstance();
    public ClientAgent client = ClientAgent.getInstance();


    public static Client getInstance() {
        if (agent == null) {
            agent = new Client();
        }
        return agent;
    }

    public static ClientAgent getAgent() {
        return ClientAgent.getInstance();
    }

}
