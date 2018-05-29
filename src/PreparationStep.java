
public class PreparationStep {
	int preparationID; 
	String content;
	
	PreparationStep(/*int id,*/ String content){
		//this.idPreparation = id;
		this.content = content;
	}
	
	public int getIdPreparation() {
		return preparationID;
	}
	
	public void setIdPreparation(int idPreparation) {
		this.preparationID = idPreparation;
	}
	
	public String getContent() {
		return content;
	}
	
	public void setContent(String name) {
		this.content = name;
	}
}
