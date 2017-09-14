package entity;

public class Express {
	
	private int id;
	private String code;
	private String sender;
	private String sender_phone;
	private String sender_addr;
	private String receiver;
	private String receiver_phone;
	private String receiver_addr;
	private String state;
	
	public Express() {
	}

	public Express(String code, String sender, String sender_phone, String sender_addr, String receiver,
			String receiver_phone, String receiver_addr, String state) {
		super();
		this.code = code;
		this.sender = sender;
		this.sender_phone = sender_phone;
		this.sender_addr = sender_addr;
		this.receiver = receiver;
		this.receiver_phone = receiver_phone;
		this.receiver_addr = receiver_addr;
		this.state = state;
	}

	public Express(int id, String code, String sender, String sender_phone, String sender_addr, String receiver,
			String receiver_phone, String receiver_addr, String state) {
		super();
		this.id = id;
		this.code = code;
		this.sender = sender;
		this.sender_phone = sender_phone;
		this.sender_addr = sender_addr;
		this.receiver = receiver;
		this.receiver_phone = receiver_phone;
		this.receiver_addr = receiver_addr;
		this.state = state;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getSender() {
		return sender;
	}

	public void setSender(String sender) {
		this.sender = sender;
	}

	public String getSender_phone() {
		return sender_phone;
	}

	public void setSender_phone(String sender_phone) {
		this.sender_phone = sender_phone;
	}

	public String getSender_addr() {
		return sender_addr;
	}

	public void setSender_addr(String sender_addr) {
		this.sender_addr = sender_addr;
	}

	public String getReceiver() {
		return receiver;
	}

	public void setReceiver(String receiver) {
		this.receiver = receiver;
	}

	public String getReceiver_phone() {
		return receiver_phone;
	}

	public void setReceiver_phone(String receiver_phone) {
		this.receiver_phone = receiver_phone;
	}

	public String getReceiver_addr() {
		return receiver_addr;
	}

	public void setReceiver_addr(String receiver_addr) {
		this.receiver_addr = receiver_addr;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}
	
	
}
