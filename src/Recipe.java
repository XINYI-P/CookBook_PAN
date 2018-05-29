import java.util.*;

public class Recipe {
	private int recipeID;
	private String recipeName;
	private int serveAmount;
	private int cookingTime;
	private int preparationTime;
	private Area area;
	private List<Ingredient> needIngredients = new ArrayList<Ingredient>();
	private List<PreparationStep> preparationStep = new ArrayList<PreparationStep>();

	Recipe(/* int idRecipe, */String nameRe, String areaName, int serveAmount) {
		// this.idRecipe = idRecipe;
		Iterator<Area> iterator = Area.getTotalArea().iterator();
		boolean findArea = false;
		while (iterator.hasNext()) {
			Area areaIsExisted = iterator.next();
			if ((areaIsExisted.getNameArea() == areaName)) {
				this.area = areaIsExisted;
				findArea = true;
			}
		}
		if (!findArea) {
			area = new Area(areaName);
		}
		this.recipeName = nameRe;
		this.serveAmount = serveAmount;
		area.addRecipe(this);
	}

	public int getIdRecipe() {
		return recipeID;
	}

	public void setIdRecipe(int idRecipe) {
		this.recipeID = idRecipe;
	}

	public String getNameRe() {
		return recipeName;
	}

	public void setNameRe(String nameRe) {
		this.recipeName = nameRe;
	}

	public int getServeAmount() {
		return serveAmount;
	}

	public void setServeAmount(int serveAmount) {
		this.serveAmount = serveAmount;
	}

	public int getCookingTime() {
		return cookingTime;
	}

	public void setCookingTime(int cookingTime) {
		this.cookingTime = cookingTime;
	}

	public int getPreparationTime() {
		return preparationTime;
	}

	public void setPreparationTime(int preparationTime) {
		this.preparationTime = preparationTime;
	}

	public Area getArea() {
		return area;
	}

	public void setArea(Area area) {
		this.area = area;
	}

	public List<PreparationStep> getPreparationStep() {
		return preparationStep;
	}

	public void setPreparationStep(List<PreparationStep> preparationStep) {
		this.preparationStep = preparationStep;
	}

	public List<Ingredient> getNeedIngredients() {
		return needIngredients;
	}

	public void addIngredient(Ingredient ingredient) {
		needIngredients.add(ingredient);
	}

	public void addPreparationStep(PreparationStep preparation) {
		preparationStep.add(preparation);
	}

	public void deleteIngredients(String ingredient) {
		int size = needIngredients.size();
		for (int i = size - 1; i >= 0; i--) {
			if (needIngredients.get(i).getNameIng().equals(ingredient)) {
				needIngredients.remove(needIngredients.get(i));
			}
		}
	}

	/**
	 * deleteIngredients function change the input parameter as Ingredient
	 * 
	 * @param ingredient
	 */
	public void deleteIngredients(Ingredient ingredient) {
		needIngredients.remove(ingredient);
	}

	public void deletePreparationStep(String preparation) {
		int size = preparationStep.size();
		for (int i = size - 1; i >= 0; i--) {
			if (preparationStep.get(i).getContent().equals(preparation)) {
				preparationStep.remove(preparationStep.get(i));
			}
		}
	}

	public void deletePreparationStep(PreparationStep preparation) {
		preparationStep.remove(preparation);
	}

	public void setIngreAmount() {
		Iterator<Ingredient> iterator = needIngredients.iterator();
		while (iterator.hasNext()) {
			Ingredient ingre = iterator.next();
			ingre.setServeAmount(serveAmount);
			ingre.setTotalAmount();
		}

	}
	
	public void editAddPreparationStep(int index, PreparationStep preparation) {
		preparationStep.add(index - 1, preparation);
	}
	
	public void editDeletePreparationStep(int index) {
		preparationStep.remove(index - 1 );
	}

	public String toString() {
		this.setIngreAmount();
		String descriptRe = "";
		String ingredientDes = "";
		String preparationDes = "";
		int orderIng = 1;
		int orderPre = 1;
		for (Ingredient ingredient : needIngredients) {
			ingredient.getTotalAmount();
			ingredientDes = ingredientDes + orderIng + ". " + ingredient.getNameIng() + "  " + "Amount: "
					+ ingredient.getTotalAmount() + "  " + "Unit: " + ingredient.getUnit();
			if (ingredient.getKinds() != null) {
				ingredientDes = ingredientDes + "  " + "Description: " + ingredient.getKinds();
			}
			ingredientDes = ingredientDes + "\n";
			orderIng++;
		}

		for (PreparationStep step : preparationStep) {
			preparationDes = preparationDes + orderPre + ". " + step.getContent() + "\n";
			orderPre++;
		}

		descriptRe = "Recipe Name: " + this.recipeName + "\n" + "ServeAmount: " + this.serveAmount + "\n"
				+ "Ingredients: " + "\n" + ingredientDes + "\n" + "preparationStep:" + "\n" + preparationDes + "\n"
				+ "preparationTime: " + this.preparationTime + "\n" + "cookingTime: " + this.cookingTime;

		return descriptRe;
	}
}
