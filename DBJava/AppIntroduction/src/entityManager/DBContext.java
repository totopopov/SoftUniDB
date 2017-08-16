package entityManager;


public interface DBContext extends AutoCloseable {
    <E> boolean persist(E entity);
}
