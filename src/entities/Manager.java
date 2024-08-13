package entities;

public class Manager extends Person{
	static  int idCounter = 0;
	private Integer experience;
	
	public Manager() {
		super.id = ++idCounter;
	}
	
	public Integer getExperience() {
		return experience;
	}
	
	public void setExperience(Integer experience) {
		this.experience = experience;
	}
	
	@Override
	public String toString() {
		return "Manager{" + "id=" + getId() + ", name='" + getName() + '\'' + ", age='" + getAge() + '\'' + ", experience=" + getExperience() + '}';
	}
}