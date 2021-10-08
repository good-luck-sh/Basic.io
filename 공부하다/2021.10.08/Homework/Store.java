package example_10_05_4_generic_sample;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;

public class Store {

	private Set<Book> books = new HashSet<>();
	private Set<Ticket> tickets = new HashSet<>();
	private Set<User> users = new HashSet<>();
	private List<Order> orders = new ArrayList<>();
	private List<Product> products = new ArrayList<>();
	//주문번호를 제공하는 객체를 생성한다. 
	//sequence.getAndIncrement() 메소드를 실행하면 10000번부터 순서대로 번호를 제공한다. 
	private AtomicInteger sequence = new AtomicInteger(10000);
	
	
	//loginUsers는 로그인 과정을 통과한 사용자 정보가 저장되는 Map객체다
	//loginUsers Map객체에는 로그인한 사람의 아이디(String)와 그 사람의 정보(User)가 저장된다.
	//private Map<String, User> loginUsers = new HashMap<>();
	private User loginUser = null;
	//로그인된 사용자의 정보를 저장하는 변수 
	
	
	
	public Store() {
		
		books.add(new Book(101,"이것이 자바다","신용권","컴퓨터",35000));
		books.add(new Book(102,"실버산업의 미래","김상아","사회복지",39000));
		books.add(new Book(103,"재료역학","유홍균","항공기계",28000));
		books.add(new Book(104,"현대노인복지론","진석범","사회복지",40000));
		books.add(new Book(105,"유체역학","강종환","항공기계",37000));
		
		tickets.add(new Ticket(201, "콘서트뮤직", "2021-10-17", 21000));
		tickets.add(new Ticket(202, "예술의 전당", "2021-10-12", 16000));
		tickets.add(new Ticket(203, "싸이 공연", "2021-10-31", 55000));
		tickets.add(new Ticket(204, "쇼팽연주곡", "2021-10-16", 16000));
		tickets.add(new Ticket(205, "바흐 전율", "2021-10-11", 17000));
		
		users.add(new User("홍길동","hong","zxcv1234"));
		users.add(new User("김쩡글","jungle","zxcv1234"));
		users.add(new User("강아지","dog","zxcv1234"));
		users.add(new User("고라니","deer","zxcv1234"));
		
		orders.add(new Order(sequence.getAndIncrement(), "hong","도서",101,1,"결제완료"));
		orders.add(new Order(sequence.getAndIncrement(), "jungle","티켓",202,2,"결제완료"));
		orders.add(new Order(sequence.getAndIncrement(), "dog","도서",105,2,"결제완료"));
		orders.add(new Order(sequence.getAndIncrement(), "deer","도서",104,2,"결제완료"));
		
		
	}
	

	//모든 책정보를 출력하는 기능
	public void displayAllBooks() {
	for(Book book : books) {
		System.out.println(book.getNo());
		System.out.println(book.getName());
		System.out.println(book.getWriter());
		System.out.println(book.getGenre());
		System.out.println(book.getPrice());
	}
	}

	//책정보를 책의 상세정보를 출력하는 기능
	public void displayBookDetail(int bookNo) {
		Book foundBook = null;
		for(Book book : books) {
			if(book.getNo()==bookNo) {
				foundBook = book;
			}
				
			}
		if(foundBook == null) {
			System.out.println("### 오류 : 책정보가 존재하지 않습니다.");
			return;
			//throw new 사용자정의예외("책정보를 찾을 수 없습니다."); //나중에 이렇게 진행해야함
		}
		System.out.println(foundBook.getNo());
		System.out.println(foundBook.getName());
		System.out.println(foundBook.getWriter());
		System.out.println(foundBook.getGenre());
		System.out.println(foundBook.getPrice());
		}
	//책 재고량 확인하기 
	public Product foundBookNo (int no) {
		Product product = new Product();
		int number = 0;
		for(Book book : books) {
			number++;
			if(book.getNo()!= no) {
				System.out.println("책 번호가 없습니다.");
				break;
			}
			products.add(new Product(book.getNo(),book.getName(),book.getPrice()));
			return product;
		} 
		return null;
		
	}
	
	
	//도서 주문하기 
	//주문할 책정보와 구매할 수량을 입력받는다. 
	public void orderBook(int no, int count) {
		String type = "도서";
		Product foundproduct = this.foundBookNo(no);
		if(foundproduct == null) {
		System.out.println("책 정보가 없습니다.");
			return;
		}
		for(Product product : products) {
		if(product.getStock() != count) {
			System.out.println("재고가 없습니다.");
			return;
		}
		orders.add(new Order())

		}
	}

	//티켓 재고량 확인하기 
	
	//티켓 예매하기 
	//주문할 티켓정보와 구매할 수량을 입력받는다. 
	public void orderTicket(String no, String count) {
		
	}
	
	//모든 티켓정보를 출력하는 기능
	public void displayAllTicket() {
	for(Ticket ticket : tickets) {
		System.out.println(ticket.getNo());
		System.out.println(ticket.getName());
		System.out.println(ticket.getDate());
		System.out.println(ticket.getPrice());
	}
		
	}
	
	//티켓 상세정보를 출력하는 기능
	public void displayTicketDetail(int ticketNo) {
		Ticket foundTicket = null;
		for(Ticket ticket : tickets) {
			if(ticket.getNo()== ticketNo) {
				foundTicket = ticket;
			}
		}
		if(foundTicket == null) {
			System.out.println("### 오류: 티켓정보가 없습니다. ");
			return;
		}
		System.out.println(foundTicket.getNo());
		System.out.println(foundTicket.getName());
		System.out.println(foundTicket.getDate());
		System.out.println(foundTicket.getPrice());
	}
	//주문 취소하기 
	public void cancelOrder(int productNo) {
		
	}
	//회원 가입 기능
	//아이디가 동일한 사용자는  가입될 수 없다. 
	public void signUp(User user) {//user의 메소드 재정의로 인하여 아이디가 같으면 안들어감. 더욱 간단한 코드가 되었다.
		boolean isSuccess = users.add(user);
		if(isSuccess) {
		System.out.println("### [성공] 회원가입이 완료되었습니다. ");
		} else {
			System.out.println("### [오류] :동일한 아이디를 가진 사용자가 이미 존재합니다.");
		}}

	//회원 탈퇴 기능
	// HashSet에서 사용자정보를 삭제한다. 
	public void exit(String id, String password) {
		User userid = this.findUserById(id);
		boolean userPassword = this.findUserByPassword(password);
		 if(userid==null) {
			 System.out.println("오류:사용자정보를 찾을 수 없습니다. ");
			 return;
		 }
		 if(userPassword) {
			 users.remove(userid);
			 this.logOut();
			 System.out.println("삭제되었습니다. ");
		 } else {
			 System.out.println("비밀번호가 일치하지 않습니다.");
		 }
		 }

	//주문을 하기 위해서 로그인과 로그아웃이 되어야한다.
		//로그인 기능
	public void logIn(String id, String password) {
		User user = this.findUserById(id);
		if(user == null) {
			System.out.println("아이디가 존재하지 않습니다. ");
			return;
		}
		boolean userPassword = this.findUserByPassword(password);
		if(userPassword) {
			loginUser = user;
			System.out.println("[로그인 성공]");
			return;
		} else {
			System.out.println("비밀번호가 틀렸습니다.");
		}
		
		
	}
		//로그아웃 기능
	public void logOut() {
		loginUser = null;
		System.out.println("[로그아웃 성공]");
		return;
	}

	private User findUserById(String userId) {
		for(User user : users) {
			if(user.getUserId().equals(userId)) {
				return user;
			}
		}
		return null;
	}
	private boolean findUserByPassword(String userPassword) {
		boolean isExtends = false;
		for(User user : users) {
			if(user.getPassword().equals(userPassword)) {
				isExtends = true;
				break;
			}
		}
		return isExtends;
		
	}
	//로그인여부를 반환하는 메소드
	public boolean isLogined() {
		return loginUser != null; //로그인유저가 로그인되어있으면 true반환, 아니라면 false를 반환함
	}
	//내 구매내역 보기 
	public void displayMyOrder() {
		
	}
	
	//내 정보 보기 기능
	public void displayMyInfo(String id, String password) {
		User user = this.findUserById(id);
		boolean isExtend = this.findUserByPassword(password);
		if(user == null) {
			System.out.println("아이디가 잘 못 되었습니다.");
			return;
		}
		if(isExtend) {
			System.out.println("사용자의 아이디"+user.getUserId());
			System.out.println("사용자의 이름"+user.getUsername());
			System.out.println("사용자의 포인트"+user.getPoint());
		
		} else {
			System.out.println("비밀번호가 잘 못 되었습니다. ");
		}
		
	}
	
	}
