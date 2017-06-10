package Labs;

public class Duhtodo {
	String todo;
	int id;
	String state;

	public Duhtodo(int id, String todo, String state) {
		super();
		this.id = id;
		this.todo = todo;
		this.state = state;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTodo() {
		return todo;
	}

	public void setTodo(String todo) {
		this.todo = todo;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}


}
