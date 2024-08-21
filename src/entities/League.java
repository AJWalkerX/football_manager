package entities;

import databases.LeagueDB;
import utility.EDivision;
import utility.ERegion;
import utility.FileIOWriter;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class League extends BaseEntity{
	private String leagueName;
	private List<Integer> teamIDList;
	private ERegion region;
	private EDivision division;
	private String season;
	private final LocalDate BEGINNING_SEASON_DATE;
//	private final LocalDate END_SEASON_DATE; //TODO: Bunu daha sonra eklemek gerekbilir!
	
	public League(LeagueDB leagueDB, LocalDate BEGINNING_SEASON_DATE) {
		super.id = leagueDB.findAll().size()+1;
		this.BEGINNING_SEASON_DATE = BEGINNING_SEASON_DATE;
		teamIDList = new ArrayList<>();
		leagueDB.save(this);
		FileIOWriter.writeLeagueToBin(leagueDB);
	}
	
	public League(LeagueDB leagueDB,String leaugeName,ERegion region,EDivision division,String season,
	              ArrayList<Integer> teamIDList, LocalDate BEGINNING_SEASON_DATE){
		super.id = leagueDB.findAll().size()+1;
		this.teamIDList = teamIDList;
		this.leagueName=leaugeName;
		this.region=region;
		this.division=division;
		this.season = season;
		this.BEGINNING_SEASON_DATE = BEGINNING_SEASON_DATE;
		leagueDB.save(this);
		FileIOWriter.writeLeagueToBin(leagueDB);
	}
	
	public LocalDate getBeginningOfSeasonDate() {
		return BEGINNING_SEASON_DATE;
	}
	
	public ERegion getRegion() {
		return region;
	}
	
	public void setRegion(ERegion region) {
		this.region = region;
	}
	
	public EDivision getDivision() {
		return division;
	}
	
	public void setDivision(EDivision division) {
		this.division = division;
	}
	
	public String getSeason() {
		return season;
	}
	
	public void setSeason(String season) {
		this.season = season;
	}
	
	public List<Integer> getTeamIDList() {
		return teamIDList;
	}
	
	public void setTeamIDList(List<Integer> teamIDList) {
		this.teamIDList = teamIDList;
	}
	
	public List<Integer> getTeamList() {
		return teamIDList;
	}
	
	public String getLeagueName() {
		return leagueName;
	}
	
	public void setLeagueName(String leagueName) {
		this.leagueName = leagueName;
	}
	
	
	@Override
	public String toString() {
		return "League{" + "id=" + getId() +
				", leagueName='" + getLeagueName() + '\'' +
				", teamIDList=" + teamIDList +
				", region=" + getRegion() +
				", division=" + getDivision() +
				", season='" + getSeason() + '\'' +
				", BeginningOfSeasonDate=" + getBeginningOfSeasonDate().format(DateTimeFormatter.ofPattern("dd-MM-yyyy"))+ '\''
				+ '}';
	}
}