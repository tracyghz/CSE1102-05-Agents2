import java.io.File;

import jeff.imagewindow.ImageWindow;
import jeff.textconsole.TextConsole;


public class Main {
		public static void main(String[] args){
			//Space classroom = new Space("classroom", "a large lecture hall", null, "classroom.jpg");
			//Space sidewalk = new Space("sidewalk","a plain concrete sidewalk with weeds growing through the cracks",null,"sidewalk.jpg");
		    //Portal door = new Portal("door","outside",sidewalk);
		    
		    //classroom.setPortal(door);
		    //Agent student = new Agent(classroom, "Harry Potter");
		    
			
		    ImageWindow f1 = new ImageWindow();
		    TextConsole g1 = TextConsole.create();
		    File configFile = new File("data","config.ini");
		    ConfigLoader cl = new ConfigLoader(configFile);
		    Agent a = cl.buildAll();
		    
		    CommandInterpreter.run(a, f1, g1);
}}
