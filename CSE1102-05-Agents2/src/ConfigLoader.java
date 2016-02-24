import java.io.File;
import java.util.HashMap;
import java.util.Set;

import jeff.ini.Ini;


public class ConfigLoader {
	  private Ini _ini;
	  private HashMap<String, Space>  _spaces  = new HashMap<String, Space>();
	  private HashMap<String, Portal> _portals = new HashMap<String, Portal>();
	  private HashMap<String, Agent>  _agents  = new HashMap<String, Agent>();
	  public ConfigLoader(File iniFile)
	  {
	    _ini = new Ini(iniFile);
	  }
	  private void _buildSpaces(){
		  for(String spaceName : _ini.keys("spaces"))
		  {
			  String description = _ini.get("spaces", spaceName);
			  String imageName = _ini.get("images", spaceName);
			  Space s = new Space(spaceName,description,null, imageName);
			  _spaces.put(spaceName, s);
		  }
	  }
	  
	  private void _buildPortals(){
		  for(String portalName: _ini.keys("portals"))
		  {
			  String description = _ini.get("portals", portalName);
			  Portal p = new Portal(portalName, description, null);
			  //Space dest = p.getDestination();
			  _portals.put(portalName,p);
		  }
	  }
	  
	  private void _buildExits(){
		  for(String spaceName :_ini.keys("exits"))
		  {
			String exitName = _ini.get("exits",spaceName);
			
			//System.out.println(exitName);
			
			Space s = _spaces.get(spaceName);
			Portal p = _portals.get(exitName);
			s.setPortal(p);
		  }
	  }
	  
	  private void _buildDestinations(){
		  for(String portalName: _ini.keys("destinations"))
		  {
			  Portal p = _portals.get(portalName);
			  String nm = _ini.get("destinations", portalName);
			  Space s = _spaces.get(nm);
			  
			  p.setDestination(s);
			  if(s == null){
				  System.out.println("Error due to null space!");
				  System.exit(1);
			  }
		  }
	  }
	  
	  private void _buildAgents(){
		  for(String agentName: _ini.keys("agents"))
		  {
			  String locationNM = _ini.get("agents", agentName);
			  Space s = _spaces.get(locationNM);
			  if(s == null){
				  System.out.println("Error due to null starting space!");
				  System.exit(1);
			  }
			  else{
				  Agent a = new Agent(s,agentName);
				  _agents.put(agentName,a);
			  }
		  }
	  }
	  
	  private Agent _selectStartAgent(){
		  String nm = _ini.get("start","agent");
		  Agent a = _agents.get(nm);
		  if(a == null){
			 System.out.println("Error: Starting agent missing!");
		  }
		  return a;
			  
		  
	  }
	  
	public Agent buildAll()
	  {
	    _buildSpaces();
	   
	    _buildPortals();
	    //System.out.println(_portals);
	    _buildExits();
	    _buildDestinations();
	    //System.out.println(_spaces.get("classroom").toStringLong());
	    _buildAgents();
	    
	    return _selectStartAgent();
	    
	}
}
