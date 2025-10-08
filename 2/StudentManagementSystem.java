class Student {
    private String id;
    private String name;
    private String gender;
    private int english;
    private int math;

    public Student(String id, String name, String gender, int english, int math) {
        this.id = id;
        this.name = name;
        this.gender = gender;
        this.english = english;
        this.math = math;
    }

    // getter和setter方法
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getEnglish() {
        return english;
    }

    public void setEnglish(int english) {
        this.english = english;
    }

    public int getMath() {
        return math;
    }

    public void setMath(int math) {
        this.math = math;
    }

    public String toString(){
        return String.format("学号：%s,姓名：%s,性别：%s,英语:%d,数学：%d",id,name,gender,english,math);
    }

    public boolean equals(Object obj){
        if(this==obj) return true;
        if(obj==null||getClass()!=obj.getClass()) return false;
        Student student = (Student)obj;
        return id.equals(student.id);
    }
}

public class StudentManagementSystem {
    private SqListClass<Student> students;

    public StudentManagementSystem(){
        students= new SqListClass<>();
        initializeData();
    }

    private void initializeData(){
        Student[] initialStudents={
                new Student("2008001", "Alan", "F", 93, 88),
                new Student("2008002", "Danie", "M", 75, 69),
                new Student("2008003", "Helen", "M", 56, 77),
                new Student("2008004", "Bill", "F", 87, 90),
                new Student("2008005", "Peter", "M", 79, 86),
                new Student("2008006", "Amy", "F", 68, 75)
        };
        for(int i=0;i<initialStudents.length;i++){
            students.insert(i,initialStudents[i]);
        }
    }

    //查询
    public Student findStudent(String id){
        for(int i=0;i<students.size();i++){
            Student s=students.GetElem(i);
            if(s.getId().equals(id)){
                return s;
            }
        }
        return null;
    }

    //修改成绩
    public void updateScore(String id,String course,int score){
        Student s = findStudent(id);
        if(s!=null){
            if("英语".equals(course)){
                s.setEnglish(score);
            } else if ("数学".equals(course)) {
                s.setMath(score);
            }
            System.out.println("修改成功："+s);
        }else{
            System.out.print("未找到学号为"+id+"的学生");
        }
    }

    //添加学生
    public void addStudent(Student student){
        if(findStudent(student.getId())==null){
            students.insert(students.size(),student);
            System.out.println("添加成功："+student);
        }else{
            System.out.println("学号已存在，添加失败");
        }
    }

    //删除学生
    public void deleteStudent(String id){
        for(int i=0;i<students.size();i++){
            if(students.GetElem(i).getId().equals(id)){
                students.delete(i);
                System.out.println("删除成功");
                return;
            }
        }
        System.out.println("未找到学号为"+id+"的学生");
    }

    //显示所有学生
    public void displayAll(){
        System.out.println("所有学生信息：");
        for(int i=0;i<students.size();i++){
            System.out.println(students.GetElem(i));
        }
    }

    public static void main(String[] args){
        StudentManagementSystem sms = new StudentManagementSystem();
        sms.displayAll();

        //查询
        System.out.println("\n查询：");
        Student s = sms.findStudent("2008003");
        if(s!=null){
            System.out.println("找到："+s);
        }

        //修改
        System.out.println("\n修改：");
        sms.updateScore("2008003", "英语", 90);

        //添加
        System.out.println("\n添加：");
        sms.addStudent(new Student("2008007", "John", "M", 85, 92));

        //删除
        System.out.println("\n删除：");
        sms.deleteStudent("2008002");

        sms.displayAll();
    }
}