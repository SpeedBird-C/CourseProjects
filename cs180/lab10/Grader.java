import java.util.List;

/**
 * This class is responsible for the actual grading of each submission. It can be instantiated with the default
 * constructor as follows:
 * 
 * Grader grader = new Grader();
 */
public class Grader {
  
  /**
   * This method should grade the submission as follows:
   * 
   * - Compile the submission.
   * - If the compilation is not successful, assign a score of zero to the submission.
   * - Otherwise, run the submission with each test case's input in the assignment corresponding to the submission.
   * - Sum the point values of each passing test case and assign the sum as the submission's grade.
   *   - A passing test case is defined as a test case where the output produced by the submission is
   *     **exactly identical** to the test case's expected output.
   */
  public void gradeSubmission (Submission submission) {
    if (submission.compile()) {
      List<TestCase> tc = submission.getAssignment().getTests();
      String s;
      int points = 0;
      for (TestCase t : tc) {
        s = t.getInput();
        if(submission.runWithInput(s).equals(t.getExpectedOutput()))
          points += t.getPoints();
      }
      submission.assignGrade(points);
    }
    else submission.assignGrade(0);
  }
  
}
