import jeff.textconsole.TextConsole;


public class Agent {
	
private Space _location;
private String _name;

public Agent(Space location, String name){
	this._location = location;
	this._name = name;
}

public Space getLocation() {
	return _location;
}
public void setLocation(Space _location) {
	this._location = _location;
}
public String getName() {
	return _name;
}
public void setName(String _name) {
	this._name = _name;
}
public String toString(){
	return getName();
}
public String toStringLong(){
	return toString() + " is in " + getLocation().toString();
}
public boolean usePortal(TextConsole y){
	if(this.getLocation().getPortal() != null){
		y.println(this.getName()+" is moving from " + this.getLocation() + " to " + this.getLocation().getPortal().getDestination());
		this.getLocation().getPortal().transport(this);
		return true;
	}
	else{
		return false;
	}
	
}
}
