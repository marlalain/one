package dev.alexaa;

import dev.alexaa.title.Title;
import org.apache.commons.lang3.StringUtils;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Should normalize job titles (either "Architect", "Software Engineer", "Quantity Surveyor" or "Accountant")
 * from a variety of inputs (e.g. "Java Engineer", "C# Engineer", "Accountant" or "Chief Accountant").
 */
public class TitleNormalizer implements Normalizer {
	@Override
	public String normalize(String toNormalize) {
		List<String> words = Stream
			.of(toNormalize.split(" "))
			.map(StringUtils::capitalize)
			.collect(Collectors.toList());

		Title title = new Title(words);

		return title.normalize();
	}
}
