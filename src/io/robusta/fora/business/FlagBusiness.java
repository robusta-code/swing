package io.robusta.fora.business;

import io.robusta.fora.ForaDataSource;
import io.robusta.fora.domain.Comment;
import io.robusta.fora.domain.Flag;

import java.util.logging.Logger;

public class FlagBusiness {

	ForaDataSource fora = ForaDataSource.getInstance();
	CommentBusiness commentBusiness = new CommentBusiness();
	private final  static Logger logger = Logger.getLogger(FlagBusiness.class.getName()); 
	
	public synchronized void flagComment(String commentId, String flagMessage){
		logger.info("flagging comment "+commentId+" with "+flagMessage);
		Comment comment = commentBusiness.getCommentById(commentId);
		
		Flag flag = new Flag();
		flag.setContent(flagMessage);		
		comment.getFlags().add(flag);
		synchronized(fora){
			fora.getFlags().add(flag);
		}
		
	}
	
}
