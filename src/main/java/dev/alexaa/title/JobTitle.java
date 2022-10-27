package dev.alexaa.title;

import java.util.Collection;

import static java.util.List.of;

public enum JobTitle {
	ACCOUNTANT("Accountant", of("Accountant", "Bookkeeper", "Auditor", "Clerk")),
	SOFTWARE_ENGINEER("Software Engineer",
		of("Engineer", "Developer", "Software Developer", "Software Engineer")),
	QUANTITY_SURVEYOR("Quantity Surveyor",
		of("Quantity Surveyor", "Chartered Quantity Surveyor", "Estimator", "Chartered Surveyor", "Surveyor")),
	ARCHITECT("Architect", of("Architect", "Landscaper", "Planner"));

	private final String normalizedTitle;
	private final Collection<String> possibleSubjects;
	Title title;

	JobTitle(String normalizedTitle, Collection<String> possibleSubjects) {
		this.normalizedTitle = normalizedTitle;
		this.possibleSubjects = possibleSubjects;
	}

	@Override
	public String toString() {
		return this.normalizedTitle;
	}

	public int sortByTitle(JobTitle jobTitle, Title title) {
		jobTitle.title = title;
		this.title = title;

		return Math.round(jobTitle.score() - score());
	}

	private float score() {
		float score = 0F;

		var matchesPossibleSubjects = equals(title.subject);
		if (matchesPossibleSubjects) return 1F;

		return score;
	}

	private boolean equals(String object) {
		return possibleSubjects
			.stream()
			.anyMatch(object::equals);
	}
}
