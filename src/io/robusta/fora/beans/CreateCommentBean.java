package io.robusta.fora.beans;

import io.robusta.fora.ForaDataSource;
import io.robusta.fora.domain.Comment;

import java.io.Serializable;

public class CreateCommentBean implements Serializable {

	private static final long serialVersionUID = -5056417707231399086L;

	ForaDataSource fora = ForaDataSource.getInstance();

	String content;
	String email;

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
		System.out.println("this :" + this);
	}

	public void createComment() {
		fora.getComments().add(new Comment(email, content));
		email = null;
		content = null;
	}

}
