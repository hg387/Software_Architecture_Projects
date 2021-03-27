import java.time.LocalDateTime;

public abstract class Component {

    public String name;
    public String size;
    public LocalDateTime date = LocalDateTime.now ( );

    public abstract void accept (Visitor visitor);

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }
}
