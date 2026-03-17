## Goal: Minimize Java Fat-JAR size via Dependency Pruning

You are a Senior DevOps Engineer. Your goal is to reduce the size of the 
project's JAR file by removing unused dependencies from `pom.xml`.

### The Loop Logic:
1. **Hypothesize**: Run `mvn dependency:analyze` to see unused dependencies.
2. **Edit**: Remove ONE dependency or add an `<exclusion>` to a large starter.
3. **Test**: Run `./eval.sh`.
4. **Evaluate**: 
   - If output is `BUILD_FAILED` or `TESTS_FAILED`: REVERT immediately.
   - If output is `SCORE:X`: 
     - If X is smaller than the baseline: COMMIT and keep the change.
     - If X is the same or larger: REVERT.

### Constraints:
- Do not remove `spring-boot-starter` or database drivers (even if 'unused' in tests).
- Focus on heavy libraries like `guava`, `aws-sdk`, or `jackson` modules if they aren't used.