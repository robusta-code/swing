package io.robusta.fora.swing;

import io.robusta.fora.ForaDataSource;
import io.robusta.fora.domain.Comment;
import io.robusta.fora.domain.User;

public class CreateCommentController {

	CreateCommentView view;
	CreateCommentModel model;
	SubjectController subjectController;
	
	public CreateCommentController(CreateCommentView view, CreateCommentModel model) {
		this.view = view;
		this.model = model;
	}
	
	public void cancelAction(){
		view.resetView();
	}
	
	public void setSubjectController(SubjectController subjectController) {
		this.subjectController = subjectController;
	}
	
	public SubjectController getSubjectController() {
		return subjectController;
	}
	
	public Comment createComment(String content, boolean isAnonymous){
		
		if (content == null || content.isEmpty()){
			view.showError("Empty content");
			return null;
		}
		
		User user = ForaDataSource.getInstance().nicolas();
		
		Comment comment = new Comment();
		comment.setContent(content);
		if (isAnonymous){
			comment.setAnonymous(true);
		}else{
			comment.setUser(user);
		}
		
		model.setNewComment(comment);
		model.setAnonymous(isAnonymous);
		
		subjectController.addComment(comment);
		view.resetView();
		
		return comment;
	}
	
}
