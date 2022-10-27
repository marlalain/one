package dev.alexaa.title;

import java.util.Arrays;
import java.util.List;

public class Title {
	public final String subject;

	public Title(List<String> words) {
		subject = words.get(words.size() - 1);
	}

	public String normalize() {
		return Arrays.stream(JobTitle.values())
			.min((jobTitleA, jobTitleB) -> jobTitleA.sortByTitle(jobTitleB, this))
			.orElseThrow(IllegalStateException::new)
			.toString();
	}
}
