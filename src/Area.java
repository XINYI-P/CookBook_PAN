import java.util.ArrayList;
import java.util.LinkedList;
public class Area {
	private int areaID;
	private String areaName;
	private ArrayList <Recipe> recipeListByArea = new ArrayList <Recipe> (); 
	private static LinkedList<Area> totalArea = new LinkedList <Area> ();

	Area(/*int id, */String name){
		//this.idArea = id;
		this.areaName = name;
		totalArea.add(this);
	}
	
	public int getIdArea() {
		return areaID;
	}
	
	public void setIdArea(int idArea) {
		this.areaID = idArea;
	}
	
	public String getNameArea() {
		return areaName;
	}
	
	public void setNameArea(String nameArea) {
		this.areaName = nameArea;
	}
	
	public void addRecipe(Recipe recipe) {
		recipeListByArea.add(recipe);
	}
	
	public ArrayList<Recipe> getRecipeListByArea() {
		return recipeListByArea;
	}
	
	public static LinkedList<Area> getTotalArea() {
		return totalArea;
	}
}
