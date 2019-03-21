package test.websocket;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

@Named
@ViewScoped
public class WebsocketBean implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private List<String> messages = new ArrayList<>();
	private String message;
	private String receivedMessage;

	@Inject @org.omnifaces.cdi.Push(channel="test")
	private org.omnifaces.cdi.PushContext pushContext;

	public List<String> getMessages() {
		return messages;
	}
	
	public void messageReceived() {
		messages.add(receivedMessage);
	}
	
	public void push() {
		pushContext.send(message);
		message = null;
	}
	
	public void reload() {
		
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getReceivedMessage() {
		return receivedMessage;
	}

	public void setReceivedMessage(String receivedMessage) {
		this.receivedMessage = receivedMessage;
	}
	
	
}
