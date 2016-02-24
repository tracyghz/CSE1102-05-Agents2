
public class Space {
private String _name;
private String _description;
private Portal _portal;
private String _imageName;

public String getImageName(){
	return _imageName;
}
public Space(String name, String description, Portal portal, String imageName ){
	this._name = name;
	this._description = description;
	this._portal = portal;
	this._imageName = imageName;
}
public String getName(){
    return _name;	
}
public String getDescription(){
    return _description;
}
public Portal getPortal(){
	return _portal;
}
public void setName(String _newName){
	_name = _newName;
}
public void setDescription(String _newDescription){
	_description = _newDescription;
}
public void setPortal(Portal _newPortal){
	_portal = _newPortal;
}
public String toString(){
	return _name;
}
public String toStringLong(){
    
	String _nm = getName();
	String _dscpt = getDescription();
	String _StringLong = _nm+": "+_dscpt;
	if (getPortal()!=null)
    {
	_StringLong = _StringLong + " with a ";	
	Portal pt = getPortal();
	String pt_info = pt.toStringLong();
	_StringLong = _StringLong + pt_info;
	}
	
	return _StringLong;
	
	
}
}

