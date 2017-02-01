package hello;

/**
 * Created by shengliyi on 2017/1/17.
 */
public class Getting {
    private final long id;
    private final String content;

    public Getting(long id,String content){
        this.id = id;
        this.content = content;
    }

    public long getId() {
        return id;
    }

    public String getContent() {
        return content;
    }
}

