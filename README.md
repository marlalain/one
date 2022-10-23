# Job Title Normalizer

Simple OOP Java project that handles normalizing job titles. Examples of usage below:

| Input                         | Output              |
|-------------------------------|---------------------|
| Junior Software Developer     | Software Engineer   |
| Chief Accountant              | Accountant          |
| Chartered Quantity Surveyor   | Quantity Surveyor   |

## Running & Testing

Clone the project and run the tests located at `src/test/java/dev.alexaa`.
You can also test the project from the command line by running:

```shell
git clone https://github.com/minsk-dev/one
# or gh repo clone minsk-dev/one

cd one

./gradlew test
```

###### EXAMPLE OUTPUT

```
> Task :test

TitleNormalizerTest > architect() PASSED

TitleNormalizerTest > simpleCase() PASSED

TitleNormalizerTest > quantitySurveyor() PASSED

TitleNormalizerTest > fluffCase() PASSED

TitleNormalizerTest > accountant() PASSED

TitleNormalizerTest > softwareEngineer() PASSED

---------------------------------------------------------------
|  Results: SUCCESS (9 tests, 9 passed, 0 failed, 0 skipped)  |
---------------------------------------------------------------

BUILD SUCCESSFUL in 1s
3 actionable tasks: 1 executed, 2 up-to-date
```