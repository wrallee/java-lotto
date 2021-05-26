package lotto;

import java.util.Arrays;

public enum Rank {
	FIRST_PRIZE(6, 2_000_000_000L),
	SECOND_PRIZE(5, 30_000_000L),
	THIRD_PRIZE(5, 1_500_000L),
	FOURTH_PRIZE(4, 50_000L),
	FIFTH_PRIZE(3, 5_000L),
	NONE(0, 0);

	private static final int SECOND_OR_THIRD = 5;

	private final int count;
	private final long award;

	Rank(int count, long award) {
		this.count = count;
		this.award = award;
	}

	public static Rank valueOf(long value, boolean matchBonus) {
		validateWinnerValue(value);

		if (value == SECOND_OR_THIRD) {
			return matchBonus ? SECOND_PRIZE : THIRD_PRIZE;
		}

		return Arrays.stream(values())
			.filter(winner -> winner.count == value)
			.findFirst()
			.orElse(NONE);
	}

	public long award() {
		return award;
	}

	private static void validateWinnerValue(long value) {
		if (value < 0L || 6L < value) {
			throw new IllegalArgumentException("Winners only have values between 0 and 6.");
		}
	}
}