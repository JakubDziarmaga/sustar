package dziarmaga.jakub.sustar.model;

import java.util.Arrays;
import java.util.List;

public class Response {

	private int turn;
	private double eventScore;
	private double experimentScore;
	private double totalScore;
	private boolean isTerminated;
	private List<String> nehoRunes;
	private double foodQuantity;
	private double waste;
	private double socialCapital;
	private double production;
	private double foodCapacity;
	private double arcologyIntegrity;
	private double population;
	private double populationCapacity;
	private List<String> events;
	private List<String> unnotableEvents;

	public Response(){
		
		unnotableEvents = Arrays.asList("ProductionChanged","ArcologyIntegrityChanged","FoodQuantityChanged", "WasteChanged",
			 "FoodCapacityChanged","SocialCapitalChanged", "PopulationCapacityChanged","PopulationChanged");
	}
	
	public double getEventScore() {
		return eventScore;
	}

	public void setEventScore(double eventScore) {
		this.eventScore = eventScore;
	}

	public double getExperimentScore() {
		return experimentScore;
	}

	public void setExperimentScore(double experimentScore) {
		this.experimentScore = experimentScore;
	}

	public int getTurn() {
		return turn;
	}
	public void setTurn(int turn) {
		this.turn = turn;
	}
	public boolean getIsTerminated() {
		return isTerminated;
	}
	public void setIsTerminated(boolean isTerminated) {
		this.isTerminated = isTerminated;
	}
	public double getTotalScore() {
		return totalScore;
	}
	public void setTotalScore(double totalScore) {
		this.totalScore = totalScore;
	}
	public List<String> getNehoRunes() {
		return nehoRunes;
	}
	public void setNehoRunes(List<String> nehoRunes) {
		this.nehoRunes = nehoRunes;
	}
	public double getFoodQuantity() {
		return foodQuantity;
	}
	public void setFoodQuantity(double foodQuantity) {
		this.foodQuantity = foodQuantity;
	}
	public double getWaste() {
		return waste;
	}
	public void setWaste(double waste) {
		this.waste = waste;
	}
	public double getSocialCapital() {
		return socialCapital;
	}
	public void setSocialCapital(double socialCapital) {
		this.socialCapital = socialCapital;
	}
	public double getProduction() {
		return production;
	}
	public void setProduction(double production) {
		this.production = production;
	}
	public double getFoodCapacity() {
		return foodCapacity;
	}
	public void setFoodCapacity(double foodCapacity) {
		this.foodCapacity = foodCapacity;
	}
	public double getArcologyIntegrity() {
		return arcologyIntegrity;
	}
	public void setArcologyIntegrity(double arcologyIntegrity) {
		this.arcologyIntegrity = arcologyIntegrity;
	}
	public double getPopulation() {
		return population;
	}
	public void setPopulation(double population) {
		this.population = population;
	}
	public double getPopulationCapacity() {
		return populationCapacity;
	}
	public void setPopulationCapacity(double populationCapacity) {
		this.populationCapacity = populationCapacity;
	}
	
    public List<String> getEvents() {
		return events;
	}
	public void setEvents(List<String> events) {
		this.events = events;
	}
	public String toString() {

        StringBuffer buffer = new StringBuffer();

        buffer.append("TURN: " + getTurn());
        buffer.append("\r\n");
        buffer.append("NOTABLE EVENTS: ");
        buffer.append("\r\n");
        for(String event : events){
        	if(!unnotableEvents.contains(event)){
        		buffer.append(event);
                buffer.append("\r\n");
        	}
        }
        buffer.append("EVENT SCORE: " + getEventScore());
        buffer.append("\r\n");
        buffer.append("EXPERIMENT SCORE: " + getExperimentScore());
        buffer.append("\r\n");
        buffer.append("TOTAL SCORE: " + getTotalScore());
        buffer.append("\r\n");        
        if(nehoRunes !=null){
        buffer.append("RUNES:[ " );
        for(String rune : nehoRunes)
            buffer.append(rune + " " );      
        buffer.append("]\r\n");      
        }
        buffer.append("IS TERMINATED: " + getIsTerminated());
        buffer.append("\r\n");
        buffer.append("FOOD QUANTITY: " + getFoodQuantity());
        buffer.append("\r\n");
        buffer.append("WASTE: " + getWaste());
        buffer.append("\r\n");
        buffer.append("SOCIAL CAPITAL: " + getSocialCapital());
        buffer.append("\r\n");
        buffer.append("PRODUCTION: " + getProduction());
        buffer.append("\r\n");
        buffer.append("FOOD CAPACITY: " + getFoodCapacity());
        buffer.append("\r\n");
        buffer.append("ARCOLOGY INTEGRITY: " + getArcologyIntegrity());
        buffer.append("\r\n");
        buffer.append("POPULATION: " + getPopulation());
        buffer.append("\r\n");
        buffer.append("POPULATION CAPACITY: " + getPopulationCapacity());
        buffer.append("\r\n");
        buffer.append("EVENTS: ");
        buffer.append("\r\n");
        for(String e : getEvents()){
            buffer.append(e.toString());
            buffer.append("\r\n");
        }
        buffer.append("===========================");
        buffer.append("\r\n");

        return buffer.toString();
    }
}
