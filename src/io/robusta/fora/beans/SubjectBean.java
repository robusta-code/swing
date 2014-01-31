package io.robusta.fora.beans;

import io.robusta.fora.domain.Subject;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class SubjectBean {

	
	
	int commentCount;
	String title;

	public SubjectBean(Subject subject) {
		this.title=subject.getTitle();
		
	}
	
	public String getTitle() {
		return title;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}
	
	public int getCommentCount() {
		return commentCount;
	}

	public void setCommentCount(int commentCount) {
		this.commentCount = commentCount;
	}

	

}
