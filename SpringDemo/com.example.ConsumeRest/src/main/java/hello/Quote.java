package hello;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Created by shengliyi on 2017/1/17.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Quote {
    private String type;
    private Value value;

    public Quote() {
        super();
    }

    public String getType() {
        return type;
    }

    /*这边的setter可有可无*/
//    public void setType(String type) {
//        this.type = type;
//    }

    public Value getValue() {
        return value;
    }

//    public void setValue(Value value) {
//        this.value = value;
//    }

    @Override
    public String toString() {
        return "Quote{" +
                "type='" + type + '\'' +
                ", value=" + value +
                '}';
    }


}
