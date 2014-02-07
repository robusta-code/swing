package io.robusta.fora.swing;

import io.robusta.fora.domain.Comment;
import io.robusta.fora.domain.Subject;

public class CreateCommentModel {

	
	Subject subject;
	Comment newComment;
	boolean isAnonymous;
	
	public Subject getSubject() {
		return subject;
	}
	
	public void setSubject(Subject subject) {
		this.subject = subject;
	}
	public Comment getNewComment() {
		return newComment;
	}
	public void setNewComment(Comment newComment) {
		this.newComment = newComment;
	}
	public boolean isAnonymous() {
		return isAnonymous;
	}
	public void setAnonymous(boolean isAnonymous) {
		this.isAnonymous = isAnonymous;
	}
	
	
	
}
