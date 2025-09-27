import java.util.ArrayList;

public class GPA {
    static double gradeToPoint(String g) {
        if(g== null ) return 0 ;
        g=g.trim().toUpperCase();
        if(g.equals("A+")) return 4.0;
        if(g.equals("A")) return 3.75;
        if(g.equals("A-")) return 3.50;
        if(g.equals("B+")) return 3.00;
        if(g.equals("B")) return 2.75;
        if(g.equals("B-")) return 2.50;
        if(g.equals("C+")) return 2.00;
        if(g.equals("C")) return 1.75;
        if(g.equals("C-")) return 1.50;
        if(g.equals("D")) return 1.00;
        return 0.0;
    }
    static double cgpaEqualWeight(String sid, ArrayList<Enrollment> list) {
        double sum = 0.0;
        int n= 0;
        for(Enrollment e : list) {
            if(sid == e.getStudentID()) {
                String g= e.getGrades();
                if(g!=null && g.length()>0) {
                    sum+= gradeToPoint(g);
                    n++ ;
                }
            }
        }
        return n==0?0 : sum/n;
    }
}
