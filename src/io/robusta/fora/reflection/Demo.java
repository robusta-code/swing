package io.robusta.fora.reflection;

import io.robusta.fora.ForaDataSource;
import io.robusta.fora.annotations.View;
import io.robusta.fora.domain.User;
import io.robusta.fora.swing.CommentView;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;

public class Demo {

	public static void main(String[] args) throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException{
		
		int viewsCount = 0;
		
				
		
		
		Annotation[] annotations = CommentView.class.getAnnotations();
		for (Annotation annotation : annotations){
			System.out.println(annotation.toString());
			if (annotation.annotationType()==View.class){
				viewsCount++;
			}
		}
		
		System.out.println(viewsCount);
		
		User nicolas = ForaDataSource.getInstance().nicolas();
		Field email = nicolas.getClass().getDeclaredField("email");
		email.setAccessible(true);
		String nicolasEmail = (String) email.get(nicolas);
		System.out.println("email de nicolas : "+nicolasEmail);
		
		email.set(nicolas, "newEmail@gmail.com");
		System.out.println("new email de nicolas : "+nicolas.getEmail());
	}
}
