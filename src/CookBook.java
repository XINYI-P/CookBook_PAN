import java.util.*;
public class CookBook {
	private String cbName;
	private List <Recipe> recipeBook = new ArrayList<Recipe> ();
	private List<Area> areaBook = new ArrayList<Area> ();
	CookBook(String name){
		this.cbName = name;
	}
	
	public void add(Recipe recipe) {
		recipeBook.add(recipe);
		areaBook.add(recipe.getArea());
	}
	
	public Recipe getRecipeByName(String name) {
		Recipe recipe = null;
		Iterator <Recipe> iterator = recipeBook.iterator();
		while(iterator.hasNext()) {
			recipe = iterator.next();
			if(recipe.getNameRe().equals(name)) {
				break;
			}
		}
		return recipe;
	}
	
	public ArrayList<Recipe> getRecipeByArea(String area) {
		ArrayList<Recipe> recipeList = new ArrayList<Recipe> ();
		Iterator <Area> iterator = areaBook.iterator();
		while(iterator.hasNext()) {
			Area areaNew = iterator.next();
			if(areaNew.getNameArea().equals(area)) {
				recipeList = areaNew.getRecipeListByArea();
			}
		}
		return recipeList;
	}
	
	public void editRecipe(String recipeName, int index, String ingredientName) {
		Iterator <Recipe> iterator = recipeBook.iterator();
		while(iterator.hasNext()) {
			if(iterator.next().getNameRe().equals(recipeName)) {
				
			}
		}
	}
}
