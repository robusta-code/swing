package io.robusta.fora.comments.client.images;

import com.google.gwt.core.client.GWT;
import com.google.gwt.resources.client.ClientBundle;
import com.google.gwt.resources.client.ImageResource;

public interface IconsBundle extends ClientBundle{

	public static final IconsBundle instance =  GWT.create(IconsBundle.class);
	  
	@Source("like.png")
	ImageResource like();
	
	@Source("dislike.png")
	ImageResource dislike();
	
	@Source("user.png")
	ImageResource user();
	
	@Source("flag.jpg")
	ImageResource flag();
	
	@Source("noflag.jpg")
	ImageResource noflag();
	
}
