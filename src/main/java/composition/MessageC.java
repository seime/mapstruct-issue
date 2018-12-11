package composition;

public class MessageC {

	private MessageA a;
	private MessageB b;
	private String cake;

	public MessageA getA() {
		return a;
	}

	public MessageB getB() {
		return b;
	}

	public void setA(MessageA a) {
		this.a = a;
	}

	public void setB(MessageB b) {
		this.b = b;
	}

	public String getCake() {
		return cake;
	}

	public void setCake(String cake) {
		this.cake = cake;
	}

}
