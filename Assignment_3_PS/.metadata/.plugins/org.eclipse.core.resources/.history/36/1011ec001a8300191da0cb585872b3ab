package model;

public class Decorator implements ITarget{
    private ITarget target;
	
	public Decorator(ITarget target) {
		this.target =target;
	}

	public ITarget getTarget() {
		return target;
	}

	public void setTarget(ITarget target) {
		this.target = target;
	}


	@Override
	public void changeStatus(String title, String status) {
		target.changeStatus(title, status);
		
	}

}
