package entities;

import java.util.List;

public class League extends BaseEntity{
	private String leagueName;
	
	public League() {
		super.id = 0;
	}
	
	public String getLeagueName() {
		return leagueName;
	}
	
	public void setLeagueName(String leagueName) {
		this.leagueName = leagueName;
	}
	
	
	@Override
	public String toString() {
		return "League{" + "id=" + getId() + ", leagueName='" + getLeagueName() + '\'' + '}';
	}
}