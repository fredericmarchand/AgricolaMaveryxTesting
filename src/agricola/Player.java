package agricola;
//Author: Robert Souter 100802267
//Supervisor: Jean-Pierre Corriveau Ph.D.
//Carleton University
//School of Computer Science
//COMP 4905
//Winter 2013

public class Player {
	
	private boolean human, hasChild, hard;
	private int food, reed, wood, clay, stone, grain, vege, family, rooms, activefam, sheep, cattle, boar, field, empty, pasture, stable, score, space, wellcounter;
	private char roomtype;
	private boolean hasFireplace, hasHearth, hasCOven, hasSOven, hasJoinery, hasPottery, hasBasket, hasFireplace2;

//	private farm
	
	public Player(){
		human=true;
		food=0;
		reed=0;
		wood=0;
		clay=0;
		stone=0;
		grain=0;
		vege=0;
		family=2;
		activefam=2;
		rooms=2;
		roomtype='w';
		sheep=0;
		cattle=0;
		boar=0;
		field=0;
		empty=13;
		pasture=0;
		stable=0;
		score=0;
		space=1;
		wellcounter=0;
		hasHearth=false;
		hasFireplace=false;
		hasFireplace2=false;
		hasCOven=false;
		hasSOven=false;
		hasJoinery=false;
		hasPottery=false;
		hasBasket=false;
		hard=false;
	}
	
	public void setComputer(boolean i){
		human=false;
		hard=i;
		
	}
	
	public boolean isHuman(){
		return human;
	}
	
	public boolean isHard(){
		return hard;
	}
	
	public int getWell(){
		return wellcounter;
	}
	
	public void setWell(){
		wellcounter=5;
	}
	
	public void decWell(){
		wellcounter--;
	}
	
	public int getRemainingSpace(){
		return (space-sheep-cattle-boar);
	}
	
	public int getScore(){
		return score;
	}
	
	public void calcScore(){
		System.out.println("fields: " + field + "\n pastures: " + pasture + "\n vegetables: " + vege + "\nsheeps: " + sheep + "\nboars: " + boar +
			 "\ncattle: " + cattle + "\nempty spots: " + empty + "\nstables: " + stable + "\nroomtype: " + roomtype + "\nrooms: " + rooms + "\nfamily: " + family);
		

		if (field<2)
			score--;
		else
			score=score+field-1;

		score+=pasture;

		score=score+(grain/2);

		if (vege<1)
			score--;
		else
			score+=vege;

		if (sheep<1)
			score--;
		else 
			score=score+(sheep/2);
	
		if (boar<1)
			score--;
		else 
			score=score+(boar/2);

		if (cattle<1)
			score--;
		else 
			score+=cattle;

		score-=empty;

		score+=stable;

		if (roomtype=='c')
			score+=rooms;
		
		if (roomtype=='s')
			score=score+(rooms*2);

		score=score+(family*3);

	}
	
	public void addScore(int n){
		score+=n;
	}
	
	public boolean hasFireplace(){
		return hasFireplace;
	}
	public void setFireplace(){
		hasFireplace=!hasFireplace;
	}
	
	public boolean hasFireplace2(){
		return hasFireplace2;
	}
	public void setFireplace2(){
		hasFireplace2=!hasFireplace2;
	}
	
	public boolean hasHearth(){
		return hasHearth;
	}
	public void setHearth(){
		hasHearth=true;
	}
	
	public boolean hasCOven(){
		return hasCOven;
	}
	public void setCOven(){
		hasCOven=true;
	}
	
	public boolean hasSOven(){
		return hasSOven;
	}
	public void setSOven(){
		hasSOven=true;
	}
	
	public boolean hasJoinery(){
		return hasJoinery;
	}
	public void setJoinery(){
		hasJoinery=true;
	}
	
	public boolean hasPottery(){
		return hasPottery;
	}
	public void setPottery(){
		hasPottery=true;
	}
	
	public boolean hasBasket(){
		return hasBasket;
	}
	public void setBasket(){
		hasBasket=true;
	}
	
	public void addField(){
		field+=1;
	}
	
	public void decVege(){
		vege--;
	}
	public void decGrain(){
		grain--;
	}
	
	public int getField(){
		return field;
	}
	
	public void decEmpty(int n){
		empty-=n;
	}
	
	public int getPasture(){
		return pasture;
	}
	
	public void addPasture(int n){
		pasture+=n;
		space=pasture+(stable*2)+1;
	}
	
	public int getSpace(){
		return space;
	}
	
	public int getStable(){
		return stable;
	}
	
	public void addStable(int n){
		stable+=n;
		space=pasture+(stable*2)+1;
	}
	
	public int getEmpty(){
		return empty;
	}
	
	
	public void addSheep(int n){
		sheep+=n;
	}
	
	public int getSheep(){
		return sheep;
	}
	
	public void addBoar(int n){
		boar+=n;
	}
	
	public int getBoar(){
		return boar;
	}
	
	public void addCattle(int n){
		cattle+=n;
	}
	
	public int getCattle(){
		return cattle;
	}
	
	public boolean hasChild(){
		return hasChild;
	}
	
	public void setChild(){
		hasChild=!hasChild;
	}
	
	public int getRoomType(){
		return roomtype;
	}
	
	public void setRoomType(char r){
		roomtype=r;
	}
	
	public int getFood(){
		return food;
	}
	
	public int getReed(){
		return reed;
	}
	
	public int getWood(){
		return wood;
	}
	
	public int getClay(){
		return clay;
	}
	
	public int getStone(){
		return stone;
	}
	public int getGrain(){
		return grain;
	}
	public int getVege(){
		return vege;
	}
	public int getFamily(){
		return family;
	}
	public int getRooms(){
		return rooms;
	}
	
	public int getActiveFamily(){
		return activefam;
	}

	public void useFam(){
		activefam--;
	}
	
	public void resetFam(){
		activefam=family;
	}
	
	public void addFood(int n){
		food=food+n;
	}
	
	public void addReed(int n){
		reed=reed+n;
	}
	
	public void addWood(int n){
		wood=wood+n;
	}
	
	public void addClay(int n){
		clay=clay+n;
	}
	
	public void addStone(int n){
		stone=stone+n;
	}
	public void addGrain(int n){
		grain+=n;
	}
	public void addVege(){
		vege++;
	}
	public void addFamily(){
		family++;
		hasChild=true;
	}
	public void addRooms(int n){
		rooms=rooms+n;
	}
	
	
	
	
	
	
}