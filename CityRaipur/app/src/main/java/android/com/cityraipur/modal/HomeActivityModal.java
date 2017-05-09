package android.com.cityraipur.modal;

/**
 * Created by rizwan on 28/04/2017.
 */

public class HomeActivityModal {

    private String title;
    private int image;

    public HomeActivityModal(String title, int image) {
        this.title = title;
        this.image = image;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }
}
