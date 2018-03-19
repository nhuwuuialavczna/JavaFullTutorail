Iterable
==================
Đây là interface cha của interface collection

Các phương thức:

#1. Iterator<T> iterator();
- Trả về 1 iterator với kiểu được truyền vào

##2.  default void forEach(Consumer<? super T> action)
- Thực hiện tuần tự các consumer đối với từng phần tử của danh sách

##3.  default Spliterator<T> spliterator()
- Trả về Spliterator. Cái này xem file Spliterator.md