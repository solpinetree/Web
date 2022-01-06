package com.lec.spring.repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lec.spring.domain.User;

//Repository 생성
//JpaRepository<Entity타입, Id타입> 상속 ← 바로 이게 Spring Data JPA 가 지원해주는 영역!
//상속받은 것만으로도 많은 JPA 메소드를 편리하게 사용 가능하게 된다.
//상속받은 것만으로도 이미 Spring Context 에 생성된다.. 

public interface UserRepository extends JpaRepository<User, Long>{
	// 1.
//	User findByName(String name);
//	List<User> findByName(String name);
//	Optional<User> findByName(String name);
	Set<User> findByName(String name);
	
	// 2. 조회커리 Naming
	User findByEmail(String email);
	User getByEmail(String email);
	User readByEmail(String email);
	User queryByEmail(String email);
	User searchByEmail(String email);
	User streamByEmail(String email);
	User findUserByEmail(String email);
	
	// 3. find...By << - - 아무말 가능.
	User findSomethingByEmail(String email);
	
	// 4. 잘못된 네이밍 --> RuntimeException 발생
//	User findByByName(String name);
	
	// 5. First, Top
	List<User> findFirst1ByName(String name);
	List<User> findFirst2ByName(String name);
	List<User> findTop1ByName(String name);
	List<User> findTop2ByName(String name);
	
	// 6. Last
	// Last 는 없는 키워드. 없는 키워드는 무시된다.
	List<User> findLast1ByName(String name);	// 걍 findByName()과 동일한 결과
	
	// 7. And, Or
	List<User> findByEmailAndName(String email, String name);
	List<User> findByEmailOrName(String email, String name);
	
	// 8. After, Before
	List<User> findByCreatedAtAfter(LocalDateTime yesterday);
	List<User> findByIdAfter(Long id);
	List<User> findByNameBefore(String name);
	
	// 9. GreaterThan, GreaterThanEqual, LessThan, LessThanEqual
	List<User> findByCreatedAtGreaterThan(LocalDateTime datetime);
	List<User> findByNameGreaterThanEqual(String name);
	
	// 10. Between
	List<User> findByCreatedAtBetween(LocalDateTime from, LocalDateTime to);
	List<User> findByIdBetween(Long id1, Long id2);
//	List<User> findByIdGreaterThanEqaulAndIdLessThanEqual(Long id1, Long id2);
	
	// 11. Null, Empty
	List<User> findByIdIsNotNull();	// id IS NOT NULL
//	List<User> findByIdIsNotEmpty();	// 1:n 관계에서 Address가 존재하는지 여부가 바로 JPA에서 말하는 Empty이다
	List<User> findByAddressIsNotEmpty();
	
	// 12. In, NotIn
	List<User> findByNameIn(List<String> names);	// name IN (?, ?, ...)
	
	// 13. StartingWith, EndingWith, Contains
	// 문자열에 대한 검색 쿼리. => LIKE 쿼리
	List<User> findByNameStartingWith(String name);	// name LIKE ?%
	List<User> findByNameEndingWith(String name);	// name LIKE %?
	List<User> findByEmailContains(String name);	// // name LIKE %?%
	
	
	// 14. Like
	// 위의 키워드는 Like 를 wrapping 한거다. 
	List<User> findByEmailLike(String email);
	
	// 15. Is
	// 특별한 역할 없음. 생략가능. 
	Set<User> findIdByNameIs(String name);	// findByName 과 동일
	
	// 아래 4개는 동일하게 동작하는 메소드다. 
	// Set<User> findByName(String name);
	// Set<User> findUserByName(String name);
	// Set<User> findUserByNameIs(String name);
	// Set<User> findUserByNameEquals(String name);
	
	
	// 16. OrderBy 
	List<User> findTopByNameOrderByIdDesc(String name);
	List<User> findFirstByNameOrderByIdDesc(String name); 
	
	// 17. 정렬기준 추가
	List<User> findFirstByNameOrderByIdDescEmailDesc(String name);
}

