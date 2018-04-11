package cn.zhsit.guava;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.junit.Test;
public class JDKMultimapTest {
    Map<String, List<StudentScore>> StudentScoreMap = new HashMap<String, List<StudentScore>>();

    @Test
    public void testStudentScore(){
        for(int i=10;i<20;i++){
            StudentScore studentScore=new StudentScore();
            studentScore.CourseId=1001+i;
            studentScore.score=100-i;
            addStudentScore("peida",studentScore);
        }

        System.out.println("StudentScoreMap:"+StudentScoreMap.size());
        System.out.println("StudentScoreMap:"+StudentScoreMap.containsKey("peida"));

        System.out.println("StudentScoreMap:"+StudentScoreMap.containsKey("jerry"));
        System.out.println("StudentScoreMap:"+StudentScoreMap.size());
        System.out.println("StudentScoreMap:"+StudentScoreMap.get("peida").size());

        List<StudentScore> StudentScoreList=StudentScoreMap.get("peida");
        if(StudentScoreList!=null&&StudentScoreList.size()>0){
            for(StudentScore stuScore:StudentScoreList){
                System.out.println("stuScore one:"+stuScore.CourseId+" score:"+stuScore.score);
            }
        }
    }

    public void addStudentScore(final String stuName,final StudentScore studentScore) {
        List<StudentScore> stuScore = StudentScoreMap.get(stuName);
        if (stuScore == null) {
            stuScore = new ArrayList<StudentScore>();
            StudentScoreMap.put(stuName, stuScore);
        }
        stuScore.add(studentScore);
    }

}
