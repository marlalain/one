package dev.alexaa.title;

import org.apache.commons.lang3.StringUtils;

import java.util.Collection;
import java.util.List;

import static dev.alexaa.title.JobTitle.*;

public class Title {
	public final String classification;
	public final Collection<String> tail;
	public final String subject;

	private final Collection<JobTitle> titles = List.of(
		SOFTWARE_ENGINEER,
		ARCHITECT,
		ACCOUNTANT,
		QUANTITY_SURVEYOR
	);

	public Title(List<String> words) {
		subject = words.get(words.size() - 1);

		tail = words
			.subList(0, words.size() - 1);

		classification = StringUtils
			.join(tail, " ");
	}

	public String normalize() {
		return titles
			.stream()
			.map(jobTitle -> jobTitle.withTitle(this))
			.min(JobTitle::sort)
			.orElseThrow(IllegalStateException::new)
			.toString();
	}
}
