package io.robusta.fora.beans;

import io.robusta.fora.ForaDataSource;
import io.robusta.fora.domain.Comment;

import java.util.Vector;

public class ForaDatasourceBean extends ForaDataSource{

	
	
	public ForaDatasourceBean (){
		super(true);
	}
	
	
	public Vector<Comment> getSynchronizedPirelliComments(){
		
		synchronized (instance) {
			Vector<Comment> comments = new Vector<Comment>();
			comments.addAll(instance.getPirelliComments());
			return comments;
		}
		
	}
}
