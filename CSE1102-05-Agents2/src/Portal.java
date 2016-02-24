
public class Portal {
private String _name;
private String _direction;
private Space _destination;
	
public Portal(String name, String direction, Space destination){
	this._name = name;
	this._direction = direction;
	this._destination = destination;
}
public String getName() {
	return _name;
}

public void setName(String _name) {
	this._name = _name;
}

public String getDirection() {
	return _direction;
}

public void setDirection(String _direction) {
	this._direction = _direction;
}

public Space getDestination() {
	return _destination;
}

public void setDestination(Space _destination) {
	this._destination = _destination;
}

public String toString(){
String _nm = getName();
String _drct = getDirection();
String _StringLong = _nm+" that goes "+_drct;
return _StringLong;
}
public String toStringLong(){
	String _tem = toString();
	Space _tem1 = getDestination();
	String toStringLong = _tem + " to " +_tem1;
	return toStringLong;
}
public void transport(Agent _agent){
	_agent.setLocation(this.getDestination());
}
}