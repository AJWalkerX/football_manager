import java.util.*;

public class FixtureGenerator {
	
	private static List<Integer[]> generateFixtureList(int teamCount) {
		if (teamCount % 2 != 0) {
			throw new IllegalArgumentException("Takım sayısı çift olmalıdır.");
		}
		
		List<Integer[]> fixture = new ArrayList<>();
		int weeksPerHalf = teamCount - 1; // İlk ve ikinci yarı için haftalar
		int totalWeeks = weeksPerHalf * 2; // Toplam hafta sayısı
		int matchesPerWeek = teamCount / 2; // Her hafta maç sayısı
		
		// İlk yarı maçlarını oluştur
		for (int week = 0; week < weeksPerHalf; week++) {
			for (int match = 0; match < matchesPerWeek; match++) {
				int homeTeam = (week + match) % teamCount;
				int awayTeam = (week + teamCount - match - 1) % teamCount;
				if (homeTeam != awayTeam) {
					fixture.add(new Integer[]{homeTeam, awayTeam});
				}
			}
		}
		
		// İkinci yarı maçlarını oluştur
		List<Integer[]> secondHalf = new ArrayList<>();
		for (Integer[] match : fixture) {
			secondHalf.add(new Integer[]{match[1], match[0]});
		}
		fixture.addAll(secondHalf);
		
		// Haftaları yer değiştir
		return shuffleWeeks(fixture, weeksPerHalf, matchesPerWeek, totalWeeks);
	}
	
	private static List<Integer[]> shuffleWeeks(List<Integer[]> fixture, int weeksPerHalf, int matchesPerWeek, int totalWeeks) {
		List<Integer[]> firstHalf = fixture.subList(0, weeksPerHalf * matchesPerWeek);
		List<Integer[]> secondHalf = fixture.subList(weeksPerHalf * matchesPerWeek, totalWeeks * matchesPerWeek);
		
		List<Integer[]> swappedWeeks = new ArrayList<>();
		for (int i = 0; i < weeksPerHalf; i++) {
			swappedWeeks.add(firstHalf.get(i));
		}
		for (int i = 0; i < weeksPerHalf; i++) {
			if (2 * i + 1 < secondHalf.size()) {
				swappedWeeks.add(secondHalf.get(2 * i));
				swappedWeeks.add(secondHalf.get(2 * i + 1));
			}
		}
		
		return swappedWeeks;
	}
	
	public static void main(String[] args) {
		int teamCount = 6; // Örnek takım sayısı
		
		List<Integer[]> fixtureList = generateFixtureList(teamCount);
		
		System.out.println("Fixture List:");
		for (int i = 0; i < fixtureList.size(); i++) {
			Integer[] match = fixtureList.get(i);
			System.out.printf("Week %d: Team %d vs Team %d\n", i + 1, match[0], match[1]);
		}
	}
}