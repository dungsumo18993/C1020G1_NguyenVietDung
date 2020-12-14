package _10_dsa_list_.bai_tap.trienkhai_linkedlist;

public class TestMyLinkedList {
    public static class Students{
        private int id;
        private String name;

        public Students() {
        }

        public Students(int id, String name) {
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
        MyLinkedList<Students> myLinkedList=new MyLinkedList<>();
        Students student1 = new Students(1,"Dũng");
        Students student2 = new Students(2,"Huy");
        Students student3 = new Students(3,"Linh");
        Students student4 = new Students(4,"Duy");
        Students student5 = new Students(5,"Rin");

        myLinkedList.addFirst(student1);
        myLinkedList.addFirst(student2);
        myLinkedList.addFirst(student3);

        myLinkedList.add(2,student4);

//        myLinkedList.addLast(student5);

//        myLinkedList.remove(2);

//        myLinkedList.remove(student5);

        System.out.println(myLinkedList.contains(student2));
        System.out.println(myLinkedList.indexOf(student5));

//        for (int i=0; i<myLinkedList.size(); i++){
//            Students student = (Students) myLinkedList.get(i);
//            System.out.println(student.getName());
//        }

//        MyLinkedList<Students> newLinkedList = myLinkedList.clone();
//
//        for (int i=0; i<newLinkedList.size(); i++){
//            Students student = (Students) newLinkedList.get(i);
//            System.out.println(student.getName());
//        }
    }
}
