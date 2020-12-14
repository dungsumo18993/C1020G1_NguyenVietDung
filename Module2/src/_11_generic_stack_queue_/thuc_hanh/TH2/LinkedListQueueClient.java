package _11_generic_stack_queue_.thuc_hanh.TH2;

public class LinkedListQueueClient {
    public static void main(String[] args) {
        MyLinkedListQueue queue = new MyLinkedListQueue();
        queue.enqueue(10);
        queue.enqueue(20);
        System.out.println(queue.size());
        queue.dequeue();
        queue.dequeue();
        queue.enqueue(30);
        queue.enqueue(40);
        queue.enqueue(50);
        queue.enqueue(60);
//        queue.dequeue();
//        System.out.println(queue.size());
//        queue.dequeue();
//        System.out.println(queue.size());
//        queue.dequeue();
//        System.out.println(queue.size());
//        queue.dequeue();
//        System.out.println(queue.size());
        int size=queue.size();
        for(int index=0; index<size; index++){
            System.out.println(queue.dequeue().key);
        }
//        while (queue.dequeue()!=null){
//            System.out.println(queue.dequeue().key);
//                    }
//        System.out.println(queue.size());
//        System.out.println("Dequeued item is " + queue.dequeue().key);
    }
}

