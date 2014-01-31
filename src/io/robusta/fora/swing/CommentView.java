package io.robusta.fora.swing;

import java.awt.Image;
import java.awt.image.BufferedImage;

import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JTextPane;
import javax.swing.SwingConstants;

public class CommentView extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Create the panel.
	 */
	public CommentView() {
		
		JTextPane CommentPane = new JTextPane();
		CommentPane.setText("ehezhtrzhtrzhrtzhrthhzrth\r\nhrzhzrthzrthrzhzrh\r\nhrzthrzthrtzhhhhhhhhh");
		add(CommentPane);
		
		JLabel lblUser = new JLabel("Toto");
		lblUser.setVerticalAlignment(SwingConstants.TOP);
		lblUser.setIcon(new ImageIcon(CommentView.class.getResource("/io/robusta/fora/swing/images/user.png")));
		add(lblUser);
		
		JButton buttonLike = new JButton("");
		buttonLike.setIcon(new ImageIcon(CommentView.class.getResource("/io/robusta/fora/swing/images/like.png")));
		add(buttonLike);
		
		JButton buttonDislike = new JButton("");
		buttonDislike.setIcon(new ImageIcon(CommentView.class.getResource("/io/robusta/fora/swing/images/dislike.png")));
		add(buttonDislike);
		
		JButton buttonFlag = new JButton("");
		buttonFlag.setIcon(new ImageIcon(CommentView.class.getResource("/io/robusta/fora/swing/images/flag.jpg")));
		add(buttonFlag);

	}

}
