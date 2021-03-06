package ee.tkasekamp.vickywaranalyzer.core;

import java.util.Arrays;

import static ee.tkasekamp.vickywaranalyzer.core.Country.findOfficalName;

/**
 * War class. All critical info and a list about war events.
 */
public class War {

	private String name = "";
	private String originalAttacker = ""; // like EST
	private String originalAttackerOfficial = ""; // Like Estonia
	private String attacker = "";
	private String originalDefender = "";
	private String originalDefenderOfficial = "";
	private String defender = "";
	private String action = ""; // Date
	private boolean isActive;
	private Battle [] battleList; 
	private JoinedCountry [] joinedCountryList; 
	private WarGoal [] warGoalList; 
	private String startDate; // Set after reading
	private String endDate = ""; // Set during reading
	private String casus_belli = ""; // Primary casus belli displayed in table. Set after reading
	/* New from HoD */
	private WarGoal originalWarGoal = new WarGoal();


	public War() {
		super();

	}
	public War(boolean isActive) {
		super();
		this.isActive = isActive;

	}

	
	public void setCasusBelliAndStartDate() {
		this.startDate = joinedCountryList[0].getStartDate(); // The first one in the list has the oldest startDate
		/* Check required as only HoD uses original wargoals. Checking if it has been given values */
		if (!(originalWarGoal.getCasus_belli().equals(""))) {
			this.casus_belli = originalWarGoal.getCasus_belli();
		}
		else if (!(warGoalList.length == 0)) {
			this.casus_belli = warGoalList[0].getCasus_belli();	
		}

	}
	
	/** Takes the official names from Reference.countyList and gives them to the
	 * attacker and defender of this war.
	 */
	public void setOfficialNames() {
		originalAttackerOfficial = findOfficalName(originalAttacker);
		originalDefenderOfficial = findOfficalName(originalDefender);
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	public String getOriginalAttacker() {
		return originalAttacker;
	}
	public void setOriginalAttacker(String originalAttacker) {
		this.originalAttacker = originalAttacker;
	}
	public String getOriginalDefender() {
		return originalDefender;
	}
	public void setOriginalDefender(String originalDefender) {
		this.originalDefender = originalDefender;
	}
	public String getAction() {
		return action;
	}
	public void setAction(String action) {
		this.action = action;
	}

	public Battle[] getBattleList() {
		return battleList;
	}

	public void setBattleList(Battle[] battleList) {
		this.battleList = battleList;
	}

	public JoinedCountry[] getCountryList() {
		return joinedCountryList;
	}

	public void setCountryList(JoinedCountry[] countryList) {
		this.joinedCountryList = countryList;
	}
	public WarGoal[] getWarGoalList() {
		return warGoalList;
	}
	public void setWarGoalList(WarGoal[] warGoalList) {
		this.warGoalList = warGoalList;
	}
	public boolean isActive() {
		return isActive;
	}
	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}
	public String getStartDate() {
		return startDate;
	}
	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}
	public String getEndDate() {
		return endDate;
	}
	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}
	public String getCasus_belli() {
		return casus_belli;
	}
	public void setCasus_belli(String casus_belli) {
		this.casus_belli = casus_belli;
	}
	public String getAttacker() {
		return attacker;
	}
	public void setAttacker(String attacker) {
		this.attacker = attacker;
	}
	public String getDefender() {
		return defender;
	}
	public void setDefender(String defender) {
		this.defender = defender;
	}
	@Override
	public String toString() {
		return "War [name=" + name + ", originalAttacker=" + originalAttacker
				+ ", attacker=" + attacker + ", originalDefender="
				+ originalDefender + ", defender=" + defender + ", action="
				+ action + ", isActive=" + isActive + ", battleList="
				+ Arrays.toString(battleList) + ", joinedCountryList="
				+ Arrays.toString(joinedCountryList) + ", warGoalList="
				+ Arrays.toString(warGoalList) + ", startDate=" + startDate
				+ ", endDate=" + endDate + ", casus_belli=" + casus_belli
				+ ", originalWarGoal=" + originalWarGoal + "]";
	}
	public JoinedCountry[] getJoinedCountryList() {
		return joinedCountryList;
	}
	public void setJoinedCountryList(JoinedCountry[] joinedCountryList) {
		this.joinedCountryList = joinedCountryList;
	}
	public WarGoal getOriginalWarGoal() {
		return originalWarGoal;
	}
	public void setOriginalWarGoal(WarGoal originalWarGoal) {
		this.originalWarGoal = originalWarGoal;
	}
	public String getOriginalAttackerOfficial() {
		return originalAttackerOfficial;
	}
	public String getOriginalDefenderOfficial() {
		return originalDefenderOfficial;
	}


	
}
