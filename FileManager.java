import java.io.IOException;
import java.io.File;
import java.io.FileWriter;
import java.io.FileReader;
import java.io.BufferedReader;

public class FileManager 
{
    private static final String STUDENT_DIR = "students/";
    private static final String LESSON_DIR = "lessons/";
    private static final String REPORT_DIR = "reports/";


    static 
    {
        createDirectory ( STUDENT_DIR );
        createDirectory ( LESSON_DIR );
        createDirectory ( REPORT_DIR );
    }

    
    private static void createDirectory ( String path ) 
    {
        File dir = new File ( path );
        if ( !dir.exists () ) 
        {
            dir.mkdirs ();
        }
    }


    // Save Student method
    public static void saveStudent ( String studentName, int age, int scores ) 
    {
        String fileName = "STU_" + studentName + ".txt";
        String filePath = STUDENT_DIR + fileName;

        try ( FileWriter writer = new FileWriter ( filePath ) ) 
        {
            writer.write ( fileName + "\n" );
            writer.write ( studentName + "\n" );
            writer.write ( age + "\n" );
            writer.write ( scores + "\n" );
           
            System.out.println ( "Student profile saved successfully." );

        } catch ( IOException e ) 
        {
            System.out.println ( "Error saving student profile." );
            e.printStackTrace ();
        }
    }


    // Load student file and return contents as String
    public static void loadStudent ( String studentName ) 
    {
        String filePath = STUDENT_DIR + "STU_" + studentName + ".txt";

        try ( BufferedReader reader = new BufferedReader ( new FileReader ( filePath ) ) ) 
        {
            String line;

            while ( ( line = reader.readLine () ) != null ) 
            {
                System.out.println ( line );
            }

        } catch ( IOException e ) 
        {
            System.out.println ( "Error loading student profile." );
            e.printStackTrace ();
        }
    }
}



    /*
    public static List<PatternMatchingLesson> loadPatternLessons ( String filename ) 
    {
        List<PatternMatchingLesson> lessons = new ArrayList<> ();
        File file = new File ( LESSON_DIR + filename );

        try ( BufferedReader reader = new BufferedReader ( new FileReader ( file ) ) ) 
        {
            String lessonId;

            while ( ( lessonId = reader.readLine () ) != null ) 
            {
                String title = reader.readLine ();
                int difficulty = Integer.parseInt ( reader.readLine () );
                String[] pattern = reader.readLine ().split ( "," );

                PatternMatchingLesson lesson =
                        new PatternMatchingLesson ( lessonId, title, difficulty, pattern );

                lessons.add ( lesson );
            }
        } catch ( IOException e ) 
        {
            System.out.println ( "Error loading pattern lessons." );
            e.printStackTrace ();
        }

        return lessons;
    }


    public static void saveReport ( String studentId, String reportContent ) 
    {
        String fileName = REPORT_DIR + studentId + "_report.txt";

        try ( FileWriter writer = new FileWriter ( fileName ) ) 
        {
            writer.write ( reportContent );
        } catch ( IOException e ) 
        {
            System.out.println ( "Error saving report." );
            e.printStackTrace ();
        }
    }
}
*/
