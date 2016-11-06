package jj.model;

import java.util.Set;

public class AreaBean {
private int id ;
private String name;
private Set<AttractionsBean> attractions;
public Set<AttractionsBean> getAttractions() {
	return attractions;
}
public void setAttractions(Set<AttractionsBean> attractions) {
	this.attractions = attractions;
}


@Override
public String toString() {
	return "AreaBean [id=" + id + ", name=" + name + "]";
}


public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}

}
