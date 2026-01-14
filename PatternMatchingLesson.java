public class PatternMatchingLesson
{
    private String lessonId;
    private String title;
    private String difficultyLevel;
    private String[] pattern;


    public PatternMatchingLesson ( String lessonId, String title, String difficultyLevel, String[] pattern )
    {
        this.lessonId = lessonId;
        this.title = title;
        this.difficultyLevel = difficultyLevel;
        this.pattern = pattern;
    }


    public boolean evaluateAnswer ( String userAnswer )
    {
        String correctPattern = String.join ( ",", pattern );
        return userAnswer.equals ( correctPattern );
    }


    public String getHint ()
    {
        if ( pattern.length > 0 )
        {
            return "The pattern starts with: " + pattern[0];
        }
        return "No pattern available.";
    }


    public void displayLesson ()
    {
        System.out.println ( "Lesson ID: " + lessonId );
        System.out.println ( "Title: " + title );
        System.out.println ( "Difficulty: " + difficultyLevel );
        System.out.println ( "Pattern length: " + pattern.length );
    }


    public String[] getPattern ()
    {
        return pattern.clone ();
    }


    public String getLessonId ()
    {
        return lessonId;
    }


    public String getTitle ()
    {
        return title;
    }

    
    public String getDifficultyLevel ()
    {
        return difficultyLevel;
    }
}
