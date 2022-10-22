package dev.alexaa.title;

import org.apache.commons.lang3.StringUtils;

import java.util.Collection;
import java.util.List;
import java.util.stream.Stream;

import static dev.alexaa.title.JobTitle.*;

public class Title {
	public final String classification;
	public final Collection<String> tail;
	public final String subject;
	public final Collection<String> fluff = List.of("Chief", "Principal", "Lead", "Senior", "Mid", "Junior");

	private final Collection<JobTitle> titles = List.of(
		SOFTWARE_ENGINEER,
		ARCHITECT,
		ACCOUNTANT,
		QUANTITY_SURVEYOR
	);

	public Title(List<String> words) {
		subject = words
			.stream()
			.findFirst()
			.orElseThrow(IllegalArgumentException::new);

		tail = words
			.subList(1, words.size());

		classification = StringUtils
			.join(tail, " ");
	}

	public boolean emptyWithoutFluff() {
		String[] tail = StringUtils.split(classification, " ");
		return Stream.of(tail).noneMatch(this::isFluff);
	}

	private boolean isFluff(String possiblyFluff) {
		return fluff
			.stream()
			.anyMatch(element -> element.equals(possiblyFluff));
	}

	public String normalize() {
		return titles
			.stream()
			.map(jobTitle -> jobTitle.withTitle(this))
			.sorted(JobTitle::sort)
			.findFirst()
			.orElseThrow(IllegalStateException::new)
			.toString();
	}
}
