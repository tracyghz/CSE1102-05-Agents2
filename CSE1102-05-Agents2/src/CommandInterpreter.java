import java.io.File;

import jeff.imagewindow.ImageWindow;
import jeff.textconsole.TextConsole;
public class CommandInterpreter {
	
private static void _showImage(Agent p, ImageWindow x){
	  String imageName = p.getLocation().getImageName();
	  File imageDir = new File("data", "images");
	  File imageFile = new File(imageDir, imageName);
	  x.loadImage(imageFile);
}
	
public static void run(Agent p, ImageWindow x, TextConsole y){
   
	boolean control = true;
	y.println(p.getName()+ " is in "+p.getLocation());
	_showImage(p,x);
	while(control){
		y.println("==>");
		String input = y.readLine();
		if(input.equals("quit")){
			control = false;
		}
		else if(input.equals("go")){
			p.usePortal(y);
			_showImage(p,x);
		}
		else if(input.equals("help")){
			y.println("This version currently provides the following functions:");
			y.println("go");
			y.println("look");
			y.println("help");
			y.println("quit");
			y.println("where");
		
		}
		else if(input.equals("where")){
			y.println(p.getLocation().toString());
		}
		else if(input.equals("look")){
		
			y.println(p.getLocation().toStringLong());
		}
		else{
			y.println("Sorry, I don't understand "+ input);
		}
	}
	System.exit(0);
}
}
