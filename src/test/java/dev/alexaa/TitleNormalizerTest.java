package dev.alexaa;

import org.apache.commons.lang3.StringUtils;
import org.junit.jupiter.api.Test;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.List.of;
import static org.junit.jupiter.api.Assertions.assertEquals;

class TitleNormalizerTest {
	private Stream<String> multiplySections(Collection<String> firstSection, Collection<String> secondSection) {
		return firstSection
			.stream()
			.flatMap(first -> secondSection.stream().map(second -> of(first, second)))
			.map(element -> StringUtils.join(element, " "));
	}

	private List<String> withFluff(String... strings) {
		return Stream
			.concat(Stream.of(strings),
				Stream.of("Chief", "Principal", "Lead", "Senior", "Mid", "Junior", ""))
			.collect(Collectors.toList());
	}

	@Test
	public void simpleCase() {
		TitleNormalizer normalizer = new TitleNormalizer();

		String expected = "Software Engineer";
		String input = "Senior Java Engineer";
		String actual = normalizer.normalize(input);

		assertEquals(expected, actual);
	}

	@Test
	public void fluffCase() {
		TitleNormalizer normalizer = new TitleNormalizer();

		String expected = "Software Engineer";
		List<String> firstSection = withFluff();
		List<String> secondSection = of("Engineer", "Developer");

		multiplySections(firstSection, secondSection)
			.map(normalizer::normalize)
			.forEach(actual -> assertEquals(expected, actual));
	}

	@Test
	public void accountant() {
		TitleNormalizer normalizer = new TitleNormalizer();

		String expected = "Accountant";
		List<String> firstSection = withFluff("Chief", "Public");
		List<String> secondSection = of("Accountant", "Bookkeeper", "Auditor", "Clerk");

		multiplySections(firstSection, secondSection)
			.map(normalizer::normalize)
			.forEach(actual -> assertEquals(expected, actual));
	}

	@Test
	public void softwareEngineer() {
		TitleNormalizer normalizer = new TitleNormalizer();

		String expected = "Software Engineer";
		List<String> firstSection = withFluff("C#", "Java", "TypeScript");
		List<String> secondSection = of("Engineer", "Developer");

		multiplySections(firstSection, secondSection)
			.map(normalizer::normalize)
			.forEach(actual -> assertEquals(expected, actual));
	}

	@Test
	public void quantitySurveyor() {
		TitleNormalizer normalizer = new TitleNormalizer();

		String expected = "Quantity Surveyor";
		List<String> firstSection = withFluff("Chief", "Chartered");
		List<String> secondSection = of("Quantity Surveyor", "Surveyor", "Estimator");

		multiplySections(firstSection, secondSection)
			.map(normalizer::normalize)
			.forEach(actual -> assertEquals(expected, actual));
	}

	@Test
	public void architect() {
		TitleNormalizer normalizer = new TitleNormalizer();

		String expected = "Architect";
		List<String> firstSection = withFluff("Chief");
		List<String> secondSection = of("Architect", "Landscaper", "Planner");

		multiplySections(firstSection, secondSection)
			.map(normalizer::normalize)
			.forEach(actual -> assertEquals(expected, actual));
	}
}