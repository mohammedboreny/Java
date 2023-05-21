package Week7;

import java.util.Optional;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class MyLinkedList <E>{
    private double size;
    private Node first;
    private Node last;



    private class Node{
        private Node next;
        private Node previous;
        private E data;



        public Node(Node next, Node previous, E data) {
            this.next = next;
            this.previous = previous;
            this.data = data;
        }
    }
    private Optional<E> first(){
        return first==null?
                Optional.empty()
                :Optional.of(first.data)
                ;}
    private Optional<E> last(){
        return last==null?
                Optional.empty()
                :Optional.of(last.data)
                ;}
    public  MyLinkedList<E> addFirst(E elementData){
        Node oldFirst=first;
        Node addedNode=new Node(oldFirst,null,elementData);
        if (oldFirst==null)
        first=addedNode;
        else
            oldFirst.previous=addedNode;
        size++;
        return this;
    }
    public MyLinkedList<E> addLast(E elementData){
        Node oldLast=last;
        Node newNode=new Node(null,oldLast,elementData);
        last = newNode;
        if (oldLast==null)
            first=newNode;
        else
            oldLast.next=newNode;
        size++;
        return this;

    }

    public static <E> MyLinkedList<E> of(E... data){
        MyLinkedList<E> result=new MyLinkedList<>();
        for (E datum : data) {
            result.add(datum);
        }
        return result;
    }

    public MyLinkedList<E> add(E data){
        return addLast(data);
    }


    public Optional<E> removeLast(){
        return last==null?Optional.empty():Optional.of(removeNode(last));
    }
    public Optional<E> removeFirst(){
        return first==null?Optional.empty():Optional.of(removeNode(first));
    }

    private E removeNode(Node nodeToBeRemoved) {
        Node next=nodeToBeRemoved.next;
        Node prev=nodeToBeRemoved.previous;

        if (prev==null) first=next;
        else prev.next=next;

        if (next==null) last=prev;
        else next.previous=prev;
        size--;
        return nodeToBeRemoved.data;
    }
    public <U> U reduceL(U seed, CBIFunction <U,E,U> accFunc){
        return reduceL(seed,accFunc,first);
    }
    public  <U> U reduceR(U seed, CBIFunction <E,U,U> accFunc){
        return reduceR(seed,accFunc,last);
    }
    private <U> U reduceR(U acc, CBIFunction<E,U,U> accFunc, Node node) {
        return node==null?acc:reduceR(accFunc.apply(node.data).apply(acc),accFunc,node.previous);
    }
    private <U> U reduceL(U acc, CBIFunction<U,E,U> accFunc, Node node) {
        return node==null?acc:reduceL(accFunc.apply(acc).apply(node.data),accFunc,node.next);
    }
    public void forEach(Consumer<E> consumer){
        Node temp=first;
        for (int i = 0; i <size ; i++) {
            consumer.accept(temp.data);
            temp=temp.next;
        }
    }
    public <U> MyLinkedList<U> map(Function<E,U> mapFunction){
        return reduceL(new MyLinkedList<>(),acc->e->acc.addLast(mapFunction.apply(e)));
    }
    public <U> MyLinkedList<U> flatMap(Function<E,MyLinkedList<U>> mapper){
        return reduceL(new MyLinkedList<>(),acc->e->acc.addAll(mapper.apply(e)));
    }
    private MyLinkedList<E> addAll(MyLinkedList<E> anotherList) {
        return anotherList.reduceL(this,acc->e-> acc.addLast(e));
    }
    public <U> MyLinkedList<Tuple<E,U>> zip(MyLinkedList<U> anotherList){
        Node eFirst = first;
        Node uFirst = (Node)anotherList.first;

        return zip(new MyLinkedList<Tuple<E,U>>(),eFirst,uFirst);
    }
    // T0 be revised
    public static <T,U> Tuple<MyLinkedList<T>,MyLinkedList<U>> unZip(MyLinkedList<Tuple<T,U>> zippedList){
        MyLinkedList<T> t=zippedList.reduceL(new MyLinkedList<>(),acc->value->acc.add(value._1));
        MyLinkedList<U> u=zippedList.reduceL(new MyLinkedList<>(),acc->value->acc.add(value._2));
        return new Tuple<>(t,u);
    }
    @Override
    public String toString() {
        return "MyLinkedList{" +
                "size=" + size +
                ", first=" + first +
                ", last=" + last +
                '}';
    }
    private <U> MyLinkedList<Tuple<E, U>> zip(MyLinkedList<Tuple<E, U>> acc, Node eNode, Node uNode) {
        return eNode==null || uNode == null
                ? acc
                :zip(acc.add(new Tuple<E,U>(eNode.data,(U)uNode.data)),eNode.next,uNode.next);
    }
    public boolean allMatch(Predicate<E> condition){
        return reduceL(true,acc->e->acc&&condition.test(e));
    }
    public MyLinkedList<E> reversed(){
        return reduceR(new MyLinkedList<>(),e->acc->acc.addLast(e));
    }
}

