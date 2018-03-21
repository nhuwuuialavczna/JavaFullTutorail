Test.Collection
======================
- Đây là 1 interface gốc đại diện cho 1 nhóm các đối tượng, các đối tượng được xem như
các element (các yếu tố). Một vài các các collection cho phép các phần tử được giống nhau
số còn lại thì không. Một số có thứ tự và 1 số là không có thứ tự. JDK không cung cấp
bất kì triển khai thẳng nào tại interface này: Nó được triển khai ở các interface con
như List và Set. Interface này thường được dùng để chuyển các collection khác thành
1 collection để sử dụng cho việc tổng quát nhất.

- Một tập hợp gồm các phần tử trùng nhau và không có thứ tự, có thể sử dụng trực tiếp 
interface này

- Tất cả các mục đích chung của Test.Collection là hiện thực các class (nó thường được hiện
thực gián tiếp thông qua các interface con) nên nó cung cấp 2 tiêu chuẩn khởi tạo:
Thứ nhất là 1 constructor không có tham số truyền vào, nó sẽ tạo ra 1 collection rỗng
Thứ 2 là 1 constructor có 1 tham số truyền vào, đó là kiểu của các phần tử. Constructor thứ 
2 giúp người dùng có thể sao chép collection thành 1 collection cùng kiểu.

- Các phương thức được gọi là `phá hoại` trong interface này, nó là các phương thức thao
tác với với collection khi chúng đang vận hành, một số thao tác sẽ ném ra UnsupportedException
nếu chúng không được hỗ trợ

#Các thông tin khác
- Tham số truyền là E: đây là kiểu của các Element. Nếu không truyền mặc định là Object

- Các class và interface kế thừa interface này
    1. Interface : List, Set, Map, SortedList, SortedSet
    2. Class: HashSet, TreeSet, ArrayList, LinkedList, Vector, Collections, Arrays, AbstractCollection

- Có từ phiên bản java 1.2

- Kế thừa Interface: Iterable


#Các phương thức truy vấn

##1. int size()
Phương thức này trả về số lượng phần tử của collection

##2. boolean isEmpty()
Phương thức trả về true nếu collection rỗng và ngược lại

##3. boolean contains(Object o)
Phương thức trả vè true nếu o nằm trong collection và ngược lại. Ném ra NullPointerException
nếu o bị null và trong danh sách không có phần tử null, 
ném ra ClassCastException nếu đối tượng o không cùng kiểu đã khai báo

##4. Iterator<E> iterator()
Phương thức trả về 1 vòng lập cho collection này. Nó không có bất kì đảm bảo nào về
thứ tự các phần tử được trả về (trừ khi nó được đảm bảo bởi 1 số lớp VD: LinkedList)

##5. Object[] toArray()
Phương thức trả về 1 mảng bao gồm tất cả phần tử của collection. Nếu nó được đảm bảo vè 
thứ tự thì phương thức này sẽ phải trả về 1 danh sách được đảm bảo thứ tự

##6. <T> T[] toArray(T[] a)
- Trả về 1 mảng các đối tượng có trong collection. Các đối tượng được khi báo tại runtime
(Là T). Nếu mảng a có số lượng phần tử phù hợp (bằng) thì các phần tử của collection
sẽ được đổ vào mảng a và trả về 1 mảng mới có cùng giá trị của a. Nếu không phù hợp thì
tương tự như phương thức trên(số 5). Trường hợp nhận vào 1 mảng a có số lượng phần tử của collection
thì các phần tử sẽ được bổ sung vào phần đầu của mảng a, và  mảng trả về cũng có giá trị tương tự

- Ném ra ngoại lệ NullPointerException nếu như mảng a null

- Ném ra ArrayStoreException khi kiểu dữ liệu của collection
không phải kiểu dữ liệu là cha của a.


#Các phương thức sửa đổi
##7. boolean add(E e)
- Trả về true nếu collection thay đổi ngay sau khi gọi phương thức này. Trả về false
đối với phần tử được thêm trùng hoặc đã được chứa(trong các cấu trúc dữ liệu không 
được trùng lập và chứa).

- Các collection có hỗ trợ qui định số lượng tối đa các phần tử được thêm vào.
Và một số collection có quy định về việc thêm phần tử. Cụ thể, không được thêm
phần tử null, số còn lại sẽ quy định về kiểu dữ của các phần tử được thêm

- Các ngoại lệ
    + UnsupportedOperationException: Khi nó ko được hỗ trợ tại 1 collection nào đó
    + ClassCastException : Nếu phần tử được thêm vào không cùng kiểu dữ liệu được khai báo
    + NullPointerException: Nếu phần tử thêm vào null(đối với 1 số collection)
    + IllegalArgumentException: Nếu 1 số thuộc tính của phần tử ngăn không cho nó
      thêm vào collection
    + IllegalStateException: Nếu không thể phần tử tại thời điểm này do 1 số hạn chế thêm
   
   
##8. boolean remove(Object o);

- Xóa 1 phần tử ra khỏi collection, nếu nó tồn tại. Trả về true nếu collection thay đổi sau khi gọi phương
thức này và ngược lại.

- Các ngoại lệ:
    + UnsupportedOperationException: Khi nó ko được hỗ trợ tại 1 collection nào đó
    + ClassCastException : Nếu phần tử cần xóa không cùng kiểu dữ liệu được khai báo
    + NullPointerException: Nếu phần tử cần xóa là null
    
#Các phương thức làm việc với 1 số lượng lớn
##9. boolean containsAll(Test.Collection<?> c)

- Phương thức trả về true nếu như tất cả phần tử của c đều nằm trong collection
- Phương thức này kiểm tra dựa trên phương thức equals thuộc về phần tử của collection
- Các ngoại lệ:
    + ClassCastException: Nếu 1 hoặc nhiều phần tử của c không cùng kiểu được khai báo
    + NullPointerException: Nếu danh sách c bị null.
    
##10.  boolean addAll(Test.Collection<? extends E> c);

- Thêm tất cả phần tử của c vào collection. Các hành vi của hoạt động này là không 
xác định nếu bộ sưu tập được chỉ định được sửa đổi trong khi tiến hành hoạt động.
- Trả vê true nếu collection có sự thay đổi và ngược lại. 

- Các ngoại lệ:
    + UnsupportedOperationException: Nếu collection nào đó không hỗ trợ phương thức
    + ClassCastException: Nếu loại của 1 phần tử nào đó không đúng với kiểu được khai báo
    + NullPointerException: Nếu 1 phần tử được thêm vào là null và collection không 
    cho phép phần tử null, hoặc collectionn c bị null
    
- Phương thức này sử dụng phương thức add của chính collection

##11. boolean removeAll(Test.Collection<?> c);    
- Xóa tất cả các phần tử tồn tại trong c ra khỏi collection, nói cách khác, sau khi
gọi phương thức này thì sẽ không còn phần tử thuộc c trong collection
- Trả về true nếu collection bị thay đổi và false nếu ngược lại

- Các ngoại lệ: 
    + UnsupportedOperationException: Nếu collection không hỗ trợ
    + ClassCastException: Nếu 1 hoặc nhiều phần tử của collection không cùng kiểu với
    collection
    + NullPointerException: Nếu có phần tử bị null trong c và nếu collection không hỗ
    trợ phần tử null

##12. default boolean removeIf(Predicate<? super E> filter) 

- Đây là phương thức default được định nghĩa trực tiếp tại interface này

- Phương thức nhận vào 1 Predicate. Predicate này có tác dụng sẽ kiểm tra điều kiện
của phần tử được xóa

- Trả về true nếu collection bị thay đổi sau khi gọi phương thức này

- Các ngoại lệ:
    + NullPointerException: Nếu filter null
    + UnsupportedOperationException: Nếu không hỗ trợ
    
- Có từ phiên bản java 1.8

##13. boolean retainAll(Test.Collection<?> c)

- Phương thức này sẽ giữ lại cho collection các phần tử của collection c
- Nói cách khác, nó sẽ xóa các phần tử có trong collection nếu nó không có trong c
- Các ngoại lệ:
    + UnsupportedOperationException: 
    + ClassCastException: Nếu 1 hoặc nhiều phần tử của c không cùng kiểu với các
    phần tử của collection
    + NullPointerException: Nếu có phần tử null hoặc collection c không cho phép
    chứa phần tử null
    
##14. void clear();
- Xóa toàn bộ phần tử có trong collection
- Test.Collection sẽ null ngay sau khi gọi phương thức này

#Comparison and hashing

##15. boolean equals(Object o);

phương thức so sánh 2 đối tượng. Trả về true nếu sự đối chiếu trùng khớp và ngược lại
Phương thức này sử dụng hashCode để đối chiếu

##16. int hashCode();
Phương thức này tính hashCode của đối tượng bất kì. Phục vụ cho phương thức equals

##17. default Spliterator<E> spliterator()

Phương thức được override lại từ interface cha của interface collection là interface Iterable

Phương thức này tạo ra 1 Spliterator về các phần tử của collection

- Phương thức này có từ Java 8

##18. default Stream<E> stream()
Phương thức trả về 1 stream của các phần tử được sắp xếp 1 cách tuần tự

- Phương thức này có từ Java 8

##19. default Stream<E> parallelStream()
Phương thức trả về 1 stream của các phần tử được sắp xếp 1 cách tuần tự, tuy nhiên công việc sẽ được chia đôi
nghĩa là sẽ chạy song song. Phương thức này tăng tốc xử lý đối với các tập dữ liệu lớn

- Phương thức này có từ Java 8
