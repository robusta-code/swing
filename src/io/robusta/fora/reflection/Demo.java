package io.robusta.fora.reflection;

import io.robusta.fora.ForaDataSource;
import io.robusta.fora.annotations.Controller;
import io.robusta.fora.annotations.Slow;
import io.robusta.fora.annotations.View;
import io.robusta.fora.domain.User;
import io.robusta.fora.swing.CommentController;
import io.robusta.fora.swing.CommentListRenderer;
import io.robusta.fora.swing.CommentView;
import io.robusta.fora.swing.CreateCommentController;
import io.robusta.fora.swing.CreateCommentModel;
import io.robusta.fora.swing.CreateCommentView;
import io.robusta.fora.swing.EditableFlagController;
import io.robusta.fora.swing.EditableFlagView;
import io.robusta.fora.swing.SwingApp;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;


public class Demo {

	public static void main(String[] args) throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException, ClassNotFoundException, InvocationTargetException, InstantiationException{
		
		int viewsCount = 0;
		int controllerCount = 0;
		
				
		
		Class[] classes = {CommentController.class, CommentListRenderer.class, CommentView.class,
				CreateCommentController.class, CreateCommentModel.class, CreateCommentView.class,
				EditableFlagController.class, EditableFlagView.class};
		
		Class[] classView = {CommentView.class};
		
		//Fake App
		SwingApp app = new SwingApp();
		
		for (Class clazz : classView){
			Annotation[] annotations = clazz.getAnnotations();
			
			for (Annotation annotation : annotations){
				System.out.println(annotation.toString());
				if (annotation.annotationType()==View.class){
					viewsCount++;
					
					Method[] methods = clazz.getDeclaredMethods();
					
					for (Method method : methods){
						Annotation[] methodAnnotations = method.getAnnotations();
						System.out.println("Annotations for method "+method.getName()+" : "+Arrays.asList(methodAnnotations));
						
						
						for (Annotation a : methodAnnotations){
							if (a.annotationType() == Slow.class){
								Object object = clazz.newInstance();
								try{
									method.invoke(object);
								}catch (Exception e){
									System.out.println(e.getMessage());
								}
								
							}
						}
						System.out.println("---\n");
					}
					 
					
					
				}
				if (annotation.annotationType()==Controller.class){
					controllerCount++;
				}
			}
		}
		
				
		
		System.out.println("Views : "+viewsCount);
		System.out.println("Controllers : "+controllerCount);
		if (viewsCount != controllerCount){
			System.out.println("Warning : missing controllers or views. Are you sure of what you are doing ?");
		}
		
		//Same for Controller annotations
		
		
		
		
	
	}
}
