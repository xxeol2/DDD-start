package one.six;

import java.util.UUID;

public class IdGenerator {
    // UUID
    UUID uuid = UUID.randomUUID();
    String strUuid = uuid.toString(); // 615f2ab9-c374-4b50-9420-2154594af151

    // 식별자 먼저 생성 후 엔티티 객체 생성시 식별자 전달
    String orderNumber = orderRepository.generateOrderNumber();

    Order order = new Order(orderNumber, ...);
    orderRepository.save(order);

    // 자동 증가 칼럼은 DB 테이블에 데이터 삽입한 뒤에야 식별자 알 수 있음
    Article article = new Article(author, title, ...);
    articleRepository.save(article);
    Long savedArticleId = article.getId();
}
