package io.robusta.fora.swing;

import io.robusta.fora.ForaDataSource;
import io.robusta.fora.domain.Comment;
import io.robusta.fora.domain.Subject;

public class SubjectController {

	SubjectView view;
	Subject model;
	
	
	public SubjectController(SubjectView view, Subject model) {
		this.view = view;
		this.model = model;
	}
	
	
	public void addComment(Comment comment){
		model.getComments().add(comment);
		ForaDataSource.getInstance().getComments().add(comment);
		this.view.addComment(comment);
	}

	public void updateView(){
		this.view.updateView();
	}
	
}
