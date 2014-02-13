package io.robusta.fora.swing;

import io.robusta.fora.ForaDataSource;
import io.robusta.fora.domain.Comment;
import io.robusta.fora.domain.Flag;
import io.robusta.fora.domain.Subject;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.util.List;

import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class SubjectView extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	Subject model;
	SubjectController controller;
	

	public SubjectView(Subject model) {
		super();
		this.model = model;
		initView();
	}

	JPanel commentsPanel;
	JLabel numberLabel;
	private void initView() {

		// R�cup�ration du sujet pirelli

		setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		add(panel, BorderLayout.NORTH);
		panel.setLayout(new BorderLayout(0, 0));

		// affichage du sujet
		JLabel label = new JLabel(model.getTitle());
		panel.add(label, BorderLayout.WEST);
		
		numberLabel = new JLabel(this.model.getComments().size()+ " comments");
		panel.add(numberLabel, BorderLayout.EAST);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setPreferredSize(new Dimension(700,500));
		add(scrollPane, BorderLayout.CENTER);

		 commentsPanel = new JPanel();
		scrollPane.setViewportView(commentsPanel);
		commentsPanel.setLayout(new BoxLayout(commentsPanel, BoxLayout.Y_AXIS));

		// affichage des commentaires
		List<Comment> comments = model.getComments();
		for (Comment comment : comments) {
			CommentView commentView = createCommentView(comment);
			commentsPanel.add(commentView);
		}

	}

	private CommentView createCommentView(Comment comment) {

		CommentView commentView = new CommentView(comment);
		CommentController controller = new CommentController(comment,
				commentView);
		commentView.setController(controller);
		return commentView;
	}

	public void updateView(){
		commentsPanel.removeAll();
		List<Comment> comments = model.getComments();
		for (Comment comment : comments) {
			CommentView commentView = createCommentView(comment);
			commentsPanel.add(commentView);
		}
		commentsPanel.validate();
		updateNumberLabel();
		
	}
	
	void updateNumberLabel(){
		numberLabel.setText(this.model.getComments().size()+ " comments");
	}
	
	
	

	public void addComment(Comment comment) {

		CommentView commentView = createCommentView(comment);
		
		commentsPanel.add(commentView);
		commentsPanel.validate();
		updateNumberLabel();
		

	}

	/**
	 * Create the panel.
	 */
	public SubjectView() {
		this.model = ForaDataSource.getInstance().getSubjects().get(0);
		initView();

	}

	public void setController(SubjectController controller) {
		this.controller = controller;
	}

	public SubjectController getController() {
		return this.controller;
	}

	public void updateComment(Comment comment) {
		
		CommentView[] commentViews = (CommentView[]) commentsPanel.getComponents();
		for (CommentView view : commentViews){
			if (view.getModel().equals(comment)){
				view.commentPane.setText(comment.getContent());
			}
		}
	}

}
