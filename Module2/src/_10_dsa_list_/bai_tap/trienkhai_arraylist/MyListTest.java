package _10_dsa_list_.bai_tap.trienkhai_arraylist;

public class MyListTest {
    public static class Student{
        private int id;
        private String name;

        public Student() {
        }

        public Student(int id, String name) {
            this.id = id;
            this.name = name;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
    public static void main(String[] args) {
        Student a = new Student(1,"Thanh");
        Student b = new Student(2,"Huy");
        Student c = new Student(3,"Quốc");
        Student d = new Student(4,"Thinh");
        Student e = new Student(5,"Cha");
        Student f = new Student(6,"Linh");

        MyList<Student> studentMyList=new MyList<>();
        MyList<Student> newMyList=new MyList<>();
        studentMyList.add(a);
        studentMyList.add(b);
        studentMyList.add(c);
        studentMyList.add(d);
        studentMyList.add(e);
//        studentMyList.add(f,2);
//        System.out.println(studentMyList.size());
//        System.out.println(studentMyList.get(2).getName());
//        System.out.println(studentMyList.indexOf(f));
//        System.out.println(studentMyList.contains(f));

        newMyList = studentMyList.clone();
        Student student=newMyList.remove(1);
        System.out.println(student.getName());
//        for (int i=0; i<newMyList.size(); i++){
//            System.out.println(newMyList.get(i).getName());
//        }

//        for (int i=0; i<studentMyList.size(); i++){
//            Student student=(Student) studentMyList.elements[i];
//            System.out.println(student.getId());
//            System.out.println(student.getName());
//        }
    }
}
