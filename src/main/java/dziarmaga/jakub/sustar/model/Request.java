package dziarmaga.jakub.sustar.model;

public class Request {

	private String command;
	private String login;
	private String token;
	private String parameter;
	
	public String getCommand() {
		return command;
	}
	public void setCommand(String command) {
		this.command = command;
	}
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	public String getParameter() {
		return parameter;
	}
	public void setParameter(String parameter) {
		this.parameter = parameter;
	}
	@Override
	public String toString() {
        StringBuffer buffer = new StringBuffer();

        buffer.append("Command Used: \"" + getCommand() + "," + getParameter() + "\"");
        buffer.append("\r\n");

        return buffer.toString();
    }
}