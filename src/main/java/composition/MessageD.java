package composition;

public class MessageD {
	private MessageA a; // Composition
	private MessageB b;
	private MessageC c; // c.a and c.b are ignored
	private String soda;

	public MessageA getA() {
		return a;
	}

	public MessageB getB() {
		return b;
	}

	public MessageC getC() {
		return c;
	}

	public void setA(MessageA a) {
		this.a = a;
	}

	public void setB(MessageB b) {
		this.b = b;
	}

	public void setC(MessageC c) {
		this.c = c;
	}

	public String getSoda() {
		return soda;
	}

	public void setSoda(String soda) {
		this.soda = soda;
	}

}
