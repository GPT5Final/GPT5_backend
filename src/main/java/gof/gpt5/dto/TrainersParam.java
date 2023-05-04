package gof.gpt5.dto;

public class TrainersParam {
	 private String choice;
	 private String search;
	 
	 public TrainersParam() {
	}

	public String getChoice() {
		return choice;
	}

	public void setChoice(String choice) {
		this.choice = choice;
	}

	public String getSearch() {
		return search;
	}

	public void setSearch(String search) {
		this.search = search;
	}

	@Override
	public String toString() {
		return "TrainersParam [choice=" + choice + ", search=" + search + "]";
	}
	 
}
