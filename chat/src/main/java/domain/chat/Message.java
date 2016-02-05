package domain.chat;

import java.io.Serializable;
import java.util.Date;

public class Message implements Serializable{
	
	protected static final long serialVersionUID = 1L;
	protected Long id;
	protected String content;
	protected Date datePost;
	protected Object sender;
	protected Object receiver;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Date getDatePost() {
		return datePost;
	}
	public void setDatePost(Date datePost) {
		this.datePost = datePost;
	}
	public Object getSender() {
		return sender;
	}
	public void setSender(Object sender) {
		this.sender = sender;
	}
	public Object getReceiver() {
		return receiver;
	}
	public void setReceiver(Object receiver) {
		this.receiver = receiver;
	}
	
	

}
