package Deserialize_new;

public class Student
{
    private Integer studentId;
    private String studentName;
    private String studentClass;
    private String studentEmailId;
    //default constructor
    public Student()
    {
    }
    //parameterized constructor
    public Student(Integer studentId, String studentName, String studentClass, String studentEmailId)
    {
        super();
        this.studentId = studentId;
        this.studentName = studentName;
        this.studentClass = studentClass;
        this.studentEmailId = studentEmailId;
    }
    //generating getters and setters
    public Integer getStudentId()
    {
        return studentId;
    }
    public void setStudentId(Integer studentId)
    {
        this.studentId = studentId;
    }
    public String getStudentName()
    {
        return studentName;
    }
    public void setStudentName(String studentName)
    {
        this.studentName = studentName;
    }
    public String getStudentClass()
    {
        return studentClass;
    }
    public void setStudentClass(String studentClass)
    {
        this.studentClass = studentClass;
    }
    public String getStudentEmailId()
    {
        return studentEmailId;
    }
    public void setStudentEmailId(String studentEmailId)
    {
        this.studentEmailId = studentEmailId;
    }
    @Override
    public String toString()
    {
        return "Student [studentId=" + studentId + ", studentName=" + studentName + ", studentClass=" + studentClass + ", studentEmailId=" + studentEmailId + "]";
    }
}