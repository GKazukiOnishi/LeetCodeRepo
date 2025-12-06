package linkedList;

public class DoublyLinkedList<T> {
    private Node<T> head;
    private Node<T> tail;

    private void addHead(T valor) {
        Node<T> node = new Node<>(valor, head, null);
        if (head != null) {
            head.setAnterior(node);
        } else {
            tail = node;
        }
        head = node;
    }

    private void addTail(T valor) {
        Node<T> node = new Node<>(valor, null, tail);
        if (tail != null) {
            tail.setProximo(node);
        } else {
            head = node;
        }
        tail = node;
    }

    private Node<T> removeHead() {
        if (head == null) {
            return null;
        }
        Node<T> headRemovido = head;
        Node<T> proximoHead = headRemovido.getProximo();
        if (proximoHead != null) {
            proximoHead.setAnterior(null);
        } else {
            tail = null;
        }
        head = proximoHead;
        return headRemovido;
    }

    private Node<T> removeTail() {
        if (tail == null) {
            return null;
        }
        Node<T> tailRemovido = tail;
        Node<T> proximoTail = tailRemovido.getAnterior();
        if (proximoTail != null) {
            proximoTail.setProximo(null);
        } else {
            head = null;
        }
        tail = proximoTail;
        return tailRemovido;
    }

    public static void main(String[] args) throws Exception {
        DoublyLinkedList<Integer> lista = new DoublyLinkedList<>();

        System.out.println("==== Teste addHead em lista vazia ====");
        lista.addHead(10); // cobre branch head == null

        System.out.println("==== Teste addHead em lista com elementos ====");
        lista.addHead(20); // cobre branch head != null

        System.out.println("==== Teste addTail em lista nao vazia ====");
        lista.addTail(30); // cobre branch tail != null

        System.out.println("==== Teste removeHead em lista com varios ====");
        Node<Integer> r1 = lista.removeHead(); // remove 20
        System.out.println("removeHead retornou: " + r1);

        System.out.println("==== Teste removeTail em lista com varios ====");
        Node<Integer> r2 = lista.removeTail(); // remove 30
        System.out.println("removeTail retornou: " + r2);

        System.out.println("==== Teste removeHead em lista com apenas 1 elemento ====");
        Node<Integer> r3 = lista.removeHead(); // remove 10
        System.out.println("removeHead retornou: " + r3);

        System.out.println("==== Teste removeHead em lista vazia ====");
        Node<Integer> r4 = lista.removeHead(); // cobre branch head == null
        System.out.println("removeHead retornou: " + r4);

        System.out.println("==== Teste removeTail em lista vazia ====");
        Node<Integer> r5 = lista.removeTail(); // cobre branch tail == null
        System.out.println("removeTail retornou: " + r5);

        System.out.println("==== Teste addTail em lista vazia ====");
        lista.addTail(40); // cobre branch tail == null
        System.out.println("Tail agora é: " + lista.tail);

        System.out.println("==== Teste removeTail em lista com apenas 1 elemento ====");
        Node<Integer> r6 = lista.removeTail(); // Remove 40
        System.out.println("removeTail retornou: " + r6);
    }
}
