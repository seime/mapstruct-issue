package composition;

public class MessageE {
	private MessageA a; // Composition
	private MessageB b;
	private String beer;

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

	public String getBeer() {
		return beer;
	}

	public void setBeer(String beer) {
		this.beer = beer;
	}

}
