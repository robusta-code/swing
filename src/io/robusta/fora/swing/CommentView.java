package io.robusta.fora.swing;

import java.awt.Color;
import java.awt.Image;
import java.awt.image.BufferedImage;

import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JTextPane;
import javax.swing.SwingConstants;

import io.robusta.fora.ForaDataSource;
import io.robusta.fora.domain.Comment;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.UIManager;

public class CommentView extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * @wbp.nonvisual location=130,379
	 */
	Comment model;
	CommentController controller;

	public CommentView() {
		this.model = ForaDataSource.getInstance().getComments().get(1);
		initView();
	}
	
	public CommentView(Comment comment) {
		this.model = comment;
		initView();
	}
	
	JTextPane commentPane;
	/**
	 * Create the panel.
	 */
	public void initView() {
		
		commentPane = new JTextPane();
		commentPane.setBackground(UIManager.getColor("Label.background"));
		commentPane.setEditable(false);
		commentPane.setText(model.getContent());
		add(commentPane);
		
		JLabel lblUser = new JLabel(String.valueOf(model.getUser()));
		lblUser.setVerticalAlignment(SwingConstants.TOP);
		lblUser.setIcon(new ImageIcon(CommentView.class.getResource("/io/robusta/fora/swing/images/user.png")));
		add(lblUser);
		
		JButton buttonLike = new JButton("");
		buttonLike.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				controller.like();
				updateContentColor();
			}
		});
		buttonLike.setIcon(new ImageIcon(CommentView.class.getResource("/io/robusta/fora/swing/images/like.png")));
		add(buttonLike);
		
		JButton buttonDislike = new JButton("");
		buttonDislike.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controller.dislike();
				updateContentColor();
			}
		});
		buttonDislike.setIcon(new ImageIcon(CommentView.class.getResource("/io/robusta/fora/swing/images/dislike.png")));
		add(buttonDislike);
		
		JButton buttonFlag = new JButton("");
		buttonFlag.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controller.flag();
			}
		});
		buttonFlag.setIcon(new ImageIcon(CommentView.class.getResource("/io/robusta/fora/swing/images/flag.jpg")));
		add(buttonFlag);

	}

	public void setController(CommentController controller) {
		this.controller = controller;
	}
	
	private void updateContentColor(){
		if (this.model.getScore() >0){
			commentPane.setForeground(Color.GREEN);
		}else if (this.model.getScore()<0){
			commentPane.setForeground(Color.RED);
		}else{
			commentPane.setForeground(Color.BLACK);
		}
	}
}
