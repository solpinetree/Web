package com.lec.spring.repository;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import com.lec.spring.domain.User;


@SpringBootTest // 스프링 context 를 로딩하여 테스트에 사용
class UserRepositoryTest {
	
	@Autowired
	private UserRepository userRepository;

//	@Test
//	@TransactionalEventListener
	void crud() {	// create - read - update - delete
		System.out.println("\n-- TEST#crud() ---------------------------------------------");
		
		// 테스트에 사용할 변수들
		User user1 = null, user2 = null;
		List<Long> ids= null;
		
		
		// 1.
//		userRepository.save(new User());	// INSERT, 저장하기
//		userRepository.findAll().forEach(System.out::println);	// SELECT 전체 조회

		// 2. findxx() + Sort.by()
		// name 필드 역순 출력
//		List<User> users = userRepository.findAll(Sort.by(Direction.DESC, "name"));
//		users.forEach(System.out::println);
		
		// 3. findxxByxx(Iterable)
		// findAllById(Iterable<Long> ids)
//		ids = new ArrayList<>();
//		ids.add(1L);
//		ids.add(2L);
//		ids.add(5L);
//		List<User> users = userRepository.findAllById(ids);
//		users.forEach(System.out::println);
//		

		
		// 4. save(entity) 저장하기
//		user1 = new User("jack", "jack@redknight.com");
//		userRepository.save(user1);
//		List<User> users = userRepository.findAll();
//		users.forEach(System.out::println);
		
		// 5. saveAll(Iterable)
//		user1 = new User("jack", "jack@redknight.com");
//		user2 = new User("steve", "steve@redknight.com");
//		userRepository.saveAll(Lists.newArrayList(user1, user2));
//		List<User> users = userRepository.findAll();
//		users.forEach(System.out::println);
		
//		users = userRepository.findAllById(Lists.newArrayList(1L, 3L, 5L));
//		users.forEach(System.out::println);
		
		// 6. getOne(id
//		user1 = userRepository.getOne(1L);
//		System.out.println(user1);

		// 7. findById(id)
		// 리턴타입은 Optional<E>
//		Optional<User> user = userRepository.findById(1L); 
//		System.out.println(user); 	// Optional
//		System.out.println();
//		
//		user = userRepository.findById(10L);	// 없다면?
//		System.out.println(user); 	// Optional.empty
//		System.out.println();
//		
//		// Optional.orElse() : 찾으면 Entity 리턴, 없는 경우 null 리턴
//		user1 = userRepository.findById(2L).orElse(null);
//		System.out.println(user1);
//		System.out.println();
//		
//		user1 = userRepository.findById(10L).orElse(null);
//		System.out.println(user1);
//		System.out.println();	
		
		// 8. flush()
		// flush() 는 SQL쿼리의 변화를 주는게 아니라 DB 반영 시점을 조정한다. 로그 출력으로는 변화를 확인하기힘들다.
//		userRepository.save(new User("new martin", "newmartin@redknight.com"));
//		userRepository.flush();
//		userRepository.findAll().forEach(System.out::println);
//		
//		// saveAndFlush() = save() + flush()
//		userRepository.saveAndFlush(new User("new martin", "newmartin@redknight.com"));
//		userRepository.findAll().forEach(System.out::println);		

		// 9 count()
//		Long count = userRepository.count();
//		System.out.println(count);
		
		// 10 existsById(id)
//		boolean exists = userRepository.existsById(1L);
//		System.out.println(exists);
		
		// 11 delete(entity)
//		user1 = userRepository.findById(1L).orElse(null);
//		user1 = userRepository.findById(1L).orElseThrow(RuntimeException::new);
//		userRepository.delete(user1);	//	DELETE 쿼리 발생
//		userRepository.findAll().forEach(System.out::println);
		
		// 12 deleteById(id)
//		userRepository.deleteById(1L);
//		userRepository.findAll().forEach(System.out::println);
		
		// 13 deleteAll()
//		userRepository.deleteAll();
//		userRepository.findAll().forEach(System.out::println);
		
		// 14 deleteAll(Iterable)
//		userRepository.deleteAll(userRepository.findAllById(Lists.newArrayList(1L, 3L)));
//		userRepository.findAll().forEach(System.out::println);
		
		// 15 deleteInBatch(Iterable)
//		userRepository.deleteInBatch(userRepository.findAllById(Lists.newArrayList(1L, 3L)));
//		userRepository.findAll().forEach(System.out::println);
		
		// 16 deleteAllInBatch()
//		userRepository.deleteAllInBatch();
//		userRepository.findAll().forEach(System.out::println);
		
		// 17 UPDATE 쿼리 
		// save() 가 INSERT 뿐 아니라 UPDATE 쿼리도 생성한다.
//		userRepository.save(new User("david", "david@reknight.com"));	// INSERT 쿼리
//		
//		User user = userRepository.findById(1L).orElseThrow(RuntimeException::new);
//		user.setEmail("martin@mail.com");	// 수정
//		userRepository.save(user);	// UPDATE 쿼리
//		
//		userRepository.findAll().forEach(System.out::println);
		
		// 18 find + Pageable
		// page 값은 0-base 
		Page<User> users = userRepository.findAll(PageRequest.of(0,3)); 	// page 0, size 3

        System.out.println("page: " + users);  // Page 를 함 찍어보자
        System.out.println("totalElements: " + users.getTotalElements());
        System.out.println("totalPages: " + users.getTotalPages());
        System.out.println("numberOfElements: " + users.getNumberOfElements());
        System.out.println("sort: " + users.getSort());
        System.out.println("size: " + users.getSize());  // 페이징 할때 나누는 size
		
		//System.out.println(users);
		//System.out.println(users.getContent());	// List<>
		users.getContent().forEach(System.out::println);
		
		System.out.println("------------------------------------------------------------\n");
	}

//	@Test
	void select() {
		System.out.println("\n-- TEST#select() ---------------------------------------------");

		// 1. 리턴타입
//		System.out.println(userRepository.findByName("martin"));
//		userRepository.findByName("martin").forEach(System.out::println);
//		System.out.println(userRepository.findByName("dennis").orElse(null));

		// 2. 
//		System.out.println("findByEmail : " + userRepository.findByEmail("martin@redknight.com"));
//		System.out.println("getByEmail : " + userRepository.getByEmail("martin@redknight.com"));
//		System.out.println("readByEmail : " + userRepository.readByEmail("martin@redknight.com"));
//		System.out.println("queryByEmail : " + userRepository.queryByEmail("martin@redknight.com"));
//		System.out.println("searchByEmail : " + userRepository.searchByEmail("martin@redknight.com"));
//		System.out.println("streamByEmail : " + userRepository.streamByEmail("martin@redknight.com"));
//		System.out.println("findUserByEmail : " + userRepository.findUserByEmail("martin@redknight.com"));

		// 3.
//		System.out.println("findSomethingByEmail : " + userRepository.findSomethingByEmail("martin@redknight.com"));

		// 4.
//		System.out.println("findByByName : " + userRepository.findByByName("martin"));

		// 5.
//		System.out.println("findTop1ByName : " + userRepository.findTop1ByName("martin"));
//		System.out.println("findTop2ByName : " + userRepository.findTop2ByName("martin"));
//		System.out.println("findFirst1ByName : " + userRepository.findFirst1ByName("martin"));
//		System.out.println("findFirst2ByName : " + userRepository.findFirst2ByName("martin"));

		// 6.
//		System.out.println("findLast1ByName : " +  userRepository.findLast1ByName("martin"));

		// 7.
//        System.out.println("findByEmailAndName : " + userRepository.findByEmailAndName("martin@redknight.com", "martin"));
//        System.out.println("findByEmailAndName : " + userRepository.findByEmailAndName("martin@redknight.com", "dennis"));
//        System.out.println("findByEmailOrName : " + userRepository.findByEmailOrName("martin@redknight.com", "dennis"));

		// 8.
//        System.out.println("findByCreatedAtAfter : " 
//        		+ userRepository.findByCreatedAtAfter(LocalDateTime.now().minusDays(1L)));  // 어제 이후의 createdAt 값
//        System.out.println("findByIdAfter : " + userRepository.findByIdAfter(4L));
//        System.out.println("findByNameBefore : " + userRepository.findByNameBefore("martin")); 

		// 9.
//		System.out.println("findByCreatedAtGreaterThan : " 
//				+ userRepository.findByCreatedAtGreaterThan(LocalDateTime.now().minusDays(1L)));
//		System.out.println("findByNameGreaterThanEqual : " + userRepository.findByNameGreaterThanEqual("martin"));

		// 10.
//		System.out.println("findByCreatedAtBetween : " 
//				+ userRepository.findByCreatedAtBetween(LocalDateTime.now().minusDays(1L), LocalDateTime.now().plusDays(1L)));
//		System.out.println("findByIdBetween : " + userRepository.findByIdBetween(1L, 3L));
//		System.out.println("findByIdGreaterThanEqualAndIdLessThanEqual : " 
//				+ userRepository.findByIdGreaterThanEqaulAndIdLessThanEqual(1L, 3L));

		// 11.
//        System.out.println("findByIdIsNotNull : " + userRepository.findByIdIsNotNull());

//        System.out.println("findByIdIsNotEmpty : " + userRepository.findByIdIsNotEmpty());     
//		 System.out.println("findByAddressIsNotEmpty : " +userRepository.findByAddressIsNotEmpty());

		// 12.
//		System.out.println("findByNameIn : " + userRepository.findByNameIn(Lists.newArrayList("martin","dennis")));

		// 13.
//		System.out.println("findByNameStartingWith : " + userRepository.findByNameStartingWith("mar"));
//		System.out.println("findByNameEndingWith : " + userRepository.findByNameEndingWith("s"));
//		System.out.println("findByEmailContains : " + userRepository.findByEmailContains("red"));

		// 14.
//		System.out.println("findByEmailLike : " + userRepository.findByEmailLike("%" + "dragon" + "%"));

		System.out.println("\n------------------------------------------------------------\n");
	}

	@Test
	void pagingAndSortingTest() {
		System.out.println("\n-- TEST#PagingAndSortingTest()----");
	
		// 16. OrderBy
//		System.out.println("findTop1ByName : " + userRepository.findTop1ByName("martin"));
//		System.out.println("findTopByNameOrderByIdDesc : " + userRepository.findTopByNameOrderByIdDesc("martin"));
		
		
		// 17. 정렬기준 추가
		System.out.println("findFirstByNameOrderByIdDescEmailDesc: " + userRepository.findFirstByNameOrderByIdDescEmailDesc("martin"));
		
		System.out.println("\n-----------------------------------");
	}

}
