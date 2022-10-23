package dev.alexaa.title;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Title {
	public final String subject;

	private final Collection<JobTitle> titles;

	public Title(List<String> words) {
		subject = words.get(words.size() - 1);

		titles = Stream
			.of(JobTitle.values())
			.map(title -> title.withTitle(this))
			.collect(Collectors.toList());
	}

	public String normalize() {
		return titles
			.stream()
			.min(JobTitle::sort)
			.orElseThrow(IllegalStateException::new)
			.toString();
	}
}
